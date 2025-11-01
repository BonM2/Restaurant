package QuanLyNhanVien;

import DateTime.Date;

import java.util.Scanner;

public class PhucVu extends NhanVien{
    private static int soLuong = 0;
    private final int luongCoBan = 5_200_000;
    private final int phuCap = 100_000;
    private int soTienTip;

    public PhucVu() {
        super();
    }

    public PhucVu(String tenNhanVien, Date ngaySinh, String gioiTinh, String chucVu) {
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

    @Override
    public double tinhLuongThucTe() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Số tiền tip nhân viên nhận được trong tháng: ");
        soTienTip = sc.nextInt();

        return 1.0 * luongCoBan + phuCap + soTienTip;
    }

    public static int getSoLuongPhucVu() {
        return soLuong;
    }
}
