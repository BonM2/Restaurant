package QuanLySanPham;

import Interface_XuLy.IThemSuaXoa;

import java.util.*;
import java.io.*;

public class DanhSachSanPham implements IThemSuaXoa {
    private ArrayList<SanPham> dsSanPham;
    private final String URL = "C:\\Users\\Bao\\IdeaProjects\\Restaurant\\Main\\src\\Data\\ListSanPham";

    public DanhSachSanPham() {
        dsSanPham = new ArrayList<>();
    }

    public void menuLoaiSanPham() {
        System.out.println("____________LOẠI SẢN PHẨM____________");
        System.out.println("1. Món ăn");
        System.out.println("2. Đồ uống");
        System.out.println("0. Thoát");
        System.out.println("______________________________________");
    }

    @Override
    public void themThongTin() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            menuLoaiSanPham();
            System.out.print("Chọn loại sản phẩm muốn thêm (1-2): ");
            choice = sc.nextInt();sc.nextLine();

            SanPham sanPham;
            if (choice == 1) {
                sanPham = new MonAn();
                sanPham.nhapThongTin(sc);
                dsSanPham.add(sanPham);
                System.out.println("Thêm món ăn thành công!!!");
            } else if (choice == 2) {
                sanPham = new DoUong();
                sanPham.nhapThongTin(sc);
                dsSanPham.add(sanPham);
                System.out.println("Thêm đồ uống thành công!!!");
            }
        } while (choice != 0);
    }

    //2.xoa Mon An
    public void xoaThongTin(int maSanPham) {
        SanPham sp = timSanPham(maSanPham);
        if (sp != null) {
            dsSanPham.remove(sp);
            System.out.println("Xóa sản phẩm với mã: " + maSanPham + " thành công!!!");
        } else {
            System.out.println("Không tìm thấy mã sản phẩm này!!!");
        }
    }

    //3.tim kiem Mon An
    public SanPham timSanPham(int maSanPham) {
        for (SanPham sp : dsSanPham) {
            if (sp.getMaSanPham() == maSanPham) {
                return sp;
            }
        }
        return null;
    }

    //4.hien thi dsMonAn
    public void hienThiDanhSachSanPham() {
        System.out.println("Hiển thị danh sách sản phẩm:");
        for (SanPham sp : dsSanPham) {
            sp.xuatThongTin();
        }
        System.out.println("Hiển thị danh sách sản phẩm thành công !!!");
    }

    //5.sua Thong tin mon an
    public void suaThongTin(int maSanPham) {
        try {
            SanPham sp = timSanPham(maSanPham);
            if (sp != null) {
                sp.menuThuocTinh();
            } else {
                System.out.println("Không tồn tại sản phẩm này.");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
        }
    }

    public void hienThiDanhSachMonAn() {
        for (SanPham sp : dsSanPham) {
            if (sp instanceof MonAn) {
                sp.xuatThongTin();
            }
        }
    }

    public void hienThiDanhSachDoUong() {
        for (SanPham sp : dsSanPham) {
            if (sp instanceof DoUong) {
                sp.xuatThongTin();
            }
        }
    }

    // 6. Đọc file
    public void docFile() {

        try {
            dsSanPham.clear();
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
                int maSanPham = Integer.parseInt(dataThanhPhan[0]);
                String tenSanPham = dataThanhPhan[1];
                double giaSanPham = Double.parseDouble(dataThanhPhan[2]);
                String loaiSanPham = dataThanhPhan[3];

                SanPham new_sanPham = null;
                if ("MON_AN".equalsIgnoreCase(loaiSanPham)) {
                    String viMonAn = dataThanhPhan[4];
                    new_sanPham = new MonAn(maSanPham,tenSanPham, giaSanPham, viMonAn);
                } else if ("DO_UONG".equalsIgnoreCase(loaiSanPham)) {
                    int dungTich = Integer.parseInt(dataThanhPhan[4]);
                    new_sanPham = new DoUong(maSanPham,tenSanPham, giaSanPham, dungTich);
                }
                dsSanPham.add(new_sanPham);
            }
            System.out.println("Đọc file thành công!!");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }


    // 7. Ghi file
    public void ghiFile() {
        try {
            File output = new File(URL);

            if (!output.exists()) {
                output.createNewFile();
            }

            PrintWriter pw = new PrintWriter(output);

            for (SanPham sp : dsSanPham) {
                if (sp != null)
                    pw.println(sp);
            }

            System.out.println("File đã được cập nhật.");
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}