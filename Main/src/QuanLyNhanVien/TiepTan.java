package QuanLyNhanVien;

import DateTime.Date;
import QuanLyHoaDon.DanhSachHoaDon;
import QuanLyHoaDon.HoaDon;
import QuanLyNhaHang.QuanLyNhaHang;

import java.util.Scanner;

public class TiepTan extends NhanVien{
    private static int soLuong = 0;
    private final int luongCoBan = 6_500_000;

    public TiepTan() {
        super();
        chucVu = "TT";
        soLuong++;
    }

    public TiepTan(String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "TT";
        soLuong++;
    }

    public TiepTan(int maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "TT";
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

        int soHoaDonTiepNhan = 0;

        for (HoaDon hoaDon : dsHoaDon.getDsHoaDon()) {
            if (hoaDon.getTenNhanVienTao().equalsIgnoreCase(tenNhanVien)) {
                soHoaDonTiepNhan++;
            }
        }
        return 1.0 * luongCoBan + (soHoaDonTiepNhan * 15000);
    }

    public static int getSoLuongTiepTan() {
        return soLuong;
    }
}
