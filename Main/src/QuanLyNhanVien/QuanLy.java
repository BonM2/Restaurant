package QuanLyNhanVien;

import DateTime.Date;
import QuanLyHoaDon.DanhSachHoaDon;
import QuanLyHoaDon.HoaDon;

import java.util.Scanner;

public class QuanLy extends NhanVien {
    private static int soLuong = 0;
    private final int luongCoBan = 10_000_000;
    private final int phuCap = 500_000;

    public QuanLy() {
        super();
    }

    public QuanLy(String tenNhanVien, Date ngaySinh, String gioiTinh, String chucVu) {
        super(tenNhanVien, ngaySinh, gioiTinh, chucVu);
        soLuong++;
    }

    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Lương cơ bản: " + luongCoBan);
        System.out.println("-------------------------------");
    }

    public void menuThuocTinh() {
        super.menuThuocTinh();
    }

    // (Lương cơ bản / số ngày đi làm thực tế) * số ngày đi làm thực tế + phụ cấp + thưởng doanh thu.
    @Override
    public double tinhLuongThucTe() {

        DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();

        double tongDoanhThu = 0.0;

        for (HoaDon hoaDon : dsHoaDon.getDsHoaDon()) {
            tongDoanhThu += hoaDon.getTongTien();
        }

        return 1.0 * luongCoBan + (tongDoanhThu * 0.03);
    }

    public static int getSoLuongQuanLy() {
        return soLuong;
    }
}
