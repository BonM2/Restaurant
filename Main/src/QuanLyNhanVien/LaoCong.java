package QuanLyNhanVien;

import DateTime.Date;
import QuanLyNgayCong.BangChamCong;

import java.util.ArrayList;
import java.util.Scanner;

public class LaoCong extends NhanVien {
    private static int soLuong = 0;
    private final int luongCoBan = 4_800_000;
    private final int phuCapChuyenCan = 300_000;

    public LaoCong() {
        super();
    }

    public LaoCong(String tenNhanVien, Date ngaySinh, String gioiTinh, String chucVu) {
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

        System.out.print("Mời nhập số điểm tháng: ");
        int tongDiem = sc.nextInt();

        return 1.0 * luongCoBan + (tongDiem * 10000);
    }

    public static int getSoLuongLaoCong() {
        return soLuong;
    }
}
