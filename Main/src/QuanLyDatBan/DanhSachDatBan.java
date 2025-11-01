package QuanLyDatBan;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.IThemSuaXoa;
import KhachHang.KhachHang;
import QuanLyBanAn.BanAn;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachDatBan implements IThemSuaXoa {
    private ArrayList<DatBan> dsDatBan;
    private final String URL = "C:\\Users\\Bao\\IdeaProjects\\Restaurant\\Main\\src\\Data\\ListDatBan";

    public DanhSachDatBan() {
        dsDatBan = new ArrayList<>();
    }

    public DanhSachDatBan(ArrayList<DatBan> dsDatBan) {
        this.dsDatBan = dsDatBan;
    }

    public ArrayList<DatBan> getDsDatBan() {
        return dsDatBan;
    }

    public void setDsDatBan(ArrayList<DatBan> dsDatBan) {
        this.dsDatBan = dsDatBan;
    }

    @Override
    public void themThongTin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng khách hàng: ");
        byte soLuongKhach = sc.nextByte();

        System.out.print("Nhập thông tin khách hàng: ");
        KhachHang khachHang = new KhachHang();
        khachHang.nhapThongTin(sc);

        System.out.print("Nhập ngày đặt bàn: ");
        Date ngayDatBan = new Date();
        ngayDatBan.nhapDate(sc);

        System.out.print("Nhập thời gian đặt bàn: ");
        Time thoiGianDatBan = new Time();
        thoiGianDatBan.nhapTime(sc);

        DatBan new_DatBan = new DatBan(soLuongKhach, khachHang, ngayDatBan, thoiGianDatBan);
        dsDatBan.add(new_DatBan);

        System.out.println("Thêm yêu cầu đặt bàn thành công!!!");
    }

    public DatBan timThongTinDatBan(int maDatBan) {
        for (DatBan datBan : dsDatBan) {
            if (datBan.getMaDatBan() == maDatBan) {
                return datBan;
            }
        }
        return null;
    }

    @Override
    public void xoaThongTin(int maDatBan) {
        DatBan datBan = timThongTinDatBan(maDatBan);

        if (datBan != null) {
            dsDatBan.remove(datBan);
            System.out.println("Xóa thành công lời đặt bàn với mã số " + maDatBan);
        } else {
            System.out.println("Không tìm thấy mã đặt bàn!!!");
        }
    }

    @Override
    public void suaThongTin(int maDatBan) {
        try (Scanner sc = new Scanner(System.in)) {
            DatBan datBan = timThongTinDatBan(maDatBan);
            if (datBan != null) {
                datBan.menuThuocTinh();
            } else {
                System.out.println("Không tồn tại mã đặt bàn này!!!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void hienThiDanhSachDatBan() {
        if (!dsDatBan.isEmpty()) {
            System.out.println("Danh sách đặt bàn: ");
            for (DatBan datBan : dsDatBan) {
                if (datBan != null)
                    System.out.println(datBan);
            }
            System.out.println("Hiển thị danh sách đặt bàn thành công!!!");
        } else
            System.out.println("Không tồn tại danh sách đặt bàn!!!");
    }

    public void docFile() {
        try {
            dsDatBan.clear();
            File input = new File(URL);

            if (!input.exists()) {
                input.createNewFile();
            }

            Scanner sc = new Scanner(System.in);
            String[] data = new String[1001];
            int n = 0;

            while (sc.hasNextLine()) {
                data[n] = sc.nextLine();
                n++;
            }

            for (int i = 0; i < n; i++) {
                String[] dataThanhPhan = data[i].split(",");

                int maDatBan = Integer.parseInt(dataThanhPhan[0]);
                int maBanAn = Integer.parseInt(dataThanhPhan[1]);

                String tenKhachHang = dataThanhPhan[2];
                String phoneNumber = dataThanhPhan[3];

                String[] date = data[4].split("/");

                short ngay = Short.parseShort(date[0]);
                short thang = Short.parseShort(date[1]);
                short nam = Short.parseShort(date[2]);

                Date ngayDatBan = new Date(ngay, thang, nam);

                String[] time = data[5].split("/");

                byte gio = Byte.parseByte(time[0]);
                byte phut = Byte.parseByte(time[1]);
                byte giay = Byte.parseByte(time[2]);

                Time thoiGianDatBan = new Time(gio, phut, giay);

                byte sucChua = Byte.parseByte(data[6]);

                DatBan datBan = new DatBan(maDatBan, new BanAn(maBanAn, sucChua, true), new KhachHang(tenKhachHang, phoneNumber), ngayDatBan, thoiGianDatBan);
                dsDatBan.add(datBan);
            }
            System.out.println("Đọc file thành công!!!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ghiFile() {
        try {
            dsDatBan.clear();
            File output = new File(URL);

            if (!output.exists()) {
                output.createNewFile();
            }

            PrintWriter pw = new PrintWriter(output);

            for (DatBan datBan : dsDatBan) {
                if (datBan != null) {
                    pw.println(datBan);
                }
            }
            System.out.println("File đã được cập nhật!!!");
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
