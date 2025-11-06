package QuanLyNhanVien;

import DateTime.Date;
import java.util.Scanner;

public class DauBep extends NhanVien{
    private static int soLuong = 0;
    private final int luongCoBan = 7_800_000;
    private final int phuCapTayNghe = 600_000;

    public DauBep() {
        super();
        chucVu = "DB";
        soLuong++;
    }

    public DauBep(String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "DB";
        soLuong++;
    }

    public DauBep(int maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "DB";
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

    @Override
    public double tinhLuongThucTe() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Số lượng món đầu bếp đã nấu: ");
        int soLuongMonDaNau = sc.nextInt();

        return 1.0 * luongCoBan + phuCapTayNghe + (soLuongMonDaNau * 5000);
    }

    public static int getSoLuongDauBep() {
        return soLuong;
    }
}
