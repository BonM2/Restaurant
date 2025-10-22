package QuanLyNhanVien;

import DateTime.Date;
import QuanLyNgayCong.BangChamCong;

import java.util.ArrayList;
import java.util.Scanner;

public class TiepTan extends NhanVien{
    private static int soLuong = 0;
    private final int luongCoBan = 6_500_000;
    private final int phuCapTrachNhiem = 200_000;

    public TiepTan() {
        super();
    }

    public TiepTan(String tenNhanVien, Date ngaySinh, String gioiTinh, String chucVu) {
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

        return (1.0 * luongCoBan / 26) * soNgayDiLamThucTe + phuCapTrachNhiem;
    }

    public static int getSoLuongTiepTan() {
        return soLuong;
    }
}
