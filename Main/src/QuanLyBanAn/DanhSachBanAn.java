package QuanLyBanAn;
import Interface_XuLy.IThemSuaXoa;
import QuanLyNhaHang.QuanLyNhaHang;

import java.util.*;
import java.io.*;

public class DanhSachBanAn implements IThemSuaXoa {
    private ArrayList<BanAn> dsBanAn;
    private String URL = "C:\\Users\\Bao\\IdeaProjects\\Restaurant\\Main\\src\\Data\\ListBanAn";

    public DanhSachBanAn() {
        dsBanAn = new ArrayList<>();
    }

    public BanAn timBanAn(int maBan) {
        for (BanAn b : dsBanAn) {
            if (b.getMaBan() == maBan)
                return b;
        }
        return null;
    }

    public BanAn timBanTrong(int soNguoi) {
        for (BanAn b : dsBanAn) {
            if (!b.getTrangThai() && b.getSoLuongChoNgoi() >= soNguoi)
                return b;
        }
        return null;
    }

    public void hienThiSoLuongBanAnHienTai() {
        System.out.println("Số lượng bàn ăn hiện tại: " + dsBanAn.size());
    }

    public void hienThiDanhSachBanAn() {

        if (dsBanAn.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        for (BanAn b : dsBanAn) {
            b.xuatThongTin();
        }
    }

    public int soLuongBanTrong() {
        int count = 0;

        for (BanAn b : dsBanAn) {
            if (!b.getTrangThai())
                count++;
        }

        return count;
    }

    @Override
    public void themThongTin() {

        BanAn banAn = new BanAn();
        banAn.nhapThongTin(QuanLyNhaHang.sc);

        dsBanAn.add(banAn);

        System.out.println("Thêm bàn ăn thành công!!!");
    }

    @Override
    public void xoaThongTin(int maBan) {

        BanAn b = timBanAn(maBan);

        if (b != null) {
            dsBanAn.remove(b);
            System.out.printf("Đã xóa bàn ăn có mã %d thành công!!!\n", maBan);
        } else
            System.out.println("Không tìm thấy bàn ăn với mã bàn: " + maBan);
    }

    @Override
    public void suaThongTin(int maBan) {

        try {
            BanAn b = timBanAn(maBan);
            if (b != null) {
                b.menuThuocTinh();
            } else {
                System.out.println("Không tồn tại mã bàn ăn này.");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
        }
    }

    public void ghiFile() {
        try {
            File output = new File(URL);

            if (!output.exists()) {
                output.createNewFile();
            }

            PrintWriter pw = new PrintWriter(output);
            for (BanAn banAn : dsBanAn) {
                if (banAn != null)
                    pw.println(banAn);
            }

            pw.close();
            System.out.println("Ghi file thành công!!!");
        } catch (Exception e) {
            System.out.println("Lỗi ghi file. Vui lòng xem lại!!!");
        }
    }

    public void docFile() {
        try {
            dsBanAn.clear();
            File input = new File(URL);

            if (!input.exists()) {
                input.createNewFile();
            }

            Scanner sc = new Scanner(input);
            String[] data = new String[1001];
            int n = 0;

            while (sc.hasNextLine()) {
                data[n] = sc.nextLine();
                n++;
            }

            for (int i = 0; i < n; i++) {
                String[] dataThanhPhan = data[i].split(",");
                int maBan = Integer.parseInt(dataThanhPhan[0]);
                byte soLuongChoNgoi = Byte.parseByte(dataThanhPhan[1]);
                boolean trangThai = Boolean.parseBoolean(dataThanhPhan[2]);

                BanAn banAn = new BanAn(maBan, soLuongChoNgoi, trangThai);
                dsBanAn.add(banAn);
            }

            System.out.println("Đọc file thành công!!!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file. Vui lòng xem lại!!!");
        }
    }
}
