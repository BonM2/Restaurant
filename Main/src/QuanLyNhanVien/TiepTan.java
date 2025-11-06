package QuanLyNhanVien;

import DateTime.Date;
import QuanLyHoaDon.DanhSachHoaDon;
import QuanLyHoaDon.HoaDon;

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

    @Override
    public double tinhLuongThucTe() {
        Scanner sc = new Scanner(System.in);

        DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();

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
