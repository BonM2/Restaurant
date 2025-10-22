package QuanLyNhanVien;

import DateTime.Date;
import QuanLyNgayCong.BangChamCong;

import java.util.Scanner;

public class DauBep extends NhanVien{
    private static int soLuong = 0;
    private final int luongCoBan = 7_800_000;
    private final int phuCapTayNghe = 600_000;

    public DauBep() {
        super();
    }

    public DauBep(String tenNhanVien, Date ngaySinh, String gioiTinh, String chucVu) {
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
        System.out.print("Tháng cần tìm: ");
        byte thang = sc.nextByte();
        System.out.print("Năm cần tìm: ");
        short nam = sc.nextShort();

        BangChamCong bangChamCongThangNay = timBangChamCong(thang, nam);

        int soNgayDiLamThucTe = 0;
        if (bangChamCongThangNay != null) {
            soNgayDiLamThucTe = bangChamCongThangNay.getSoNgayDiLamThucTe();
        }

        return (1.0 * luongCoBan / 26) * soNgayDiLamThucTe + phuCapTayNghe;
    }

    public static int getSoLuongDauBep() {
        return soLuong;
    }
}
