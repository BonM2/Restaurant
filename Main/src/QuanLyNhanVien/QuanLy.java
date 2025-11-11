package QuanLyNhanVien;

import DateTime.Date;
import QuanLyHoaDon.DanhSachHoaDon;
import QuanLyHoaDon.HoaDon;
import QuanLyNhaHang.QuanLyNhaHang;

public class QuanLy extends NhanVien {
    private static int soLuong = 0;
    private final int luongCoBan = 10_000_000;

    public QuanLy() {
        super();
        chucVu = "QL";
        soLuong++;
    }

    public QuanLy(int maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "QL";
        soLuong++;
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Lương cơ bản: " + luongCoBan);
        System.out.println("-------------------------------");
    }

    @Override
    public double tinhLuongThucTe() {
        DanhSachHoaDon dsHoaDon = QuanLyNhaHang.getDanhSachHoaDon();

        double tongDoanhThu = 0.0;

        for (HoaDon hoaDon : dsHoaDon.getDsHoaDon()) {
            tongDoanhThu += hoaDon.capNhatTongTien();
        }

        return 1.0 * luongCoBan + (tongDoanhThu * 0.03);
    }

    public static int getSoLuongQuanLy() {
        return soLuong;
    }
}
