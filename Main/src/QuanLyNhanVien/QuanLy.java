package QuanLyNhanVien;

import DateTime.Date;
import Interface_XuLy.INhapXuat;
import QuanLyNgayCong.BangChamCong;

import java.util.ArrayList;
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

        return (1.0 * luongCoBan / 26) * soNgayDiLamThucTe + phuCap;
    }

    public static int getSoLuongQuanLy() {
        return soLuong;
    }
}
