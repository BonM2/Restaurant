package QuanLyNhanVien;

import DateTime.Date;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhucVu extends NhanVien{
    private static int soLuong = 0;
    private final int luongCoBan = 5_200_000;
    private final int phuCap = 100_000;

    public PhucVu() {
        super();
        chucVu = "PV";
        soLuong++;
    }

    public PhucVu(String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "PV";
        soLuong++;
    }

    public PhucVu(int maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "PV";
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

        int soTienTip;
        while (true) {
            try {
                System.out.print("Mời nhập số tiền tip của phục vụ " + tenNhanVien + ": ");
                soTienTip = sc.nextInt();
                sc.nextLine();

                if (soTienTip < 0) {
                    System.out.println("Số tiền tip phải là số dương!!!");
                } else {
                    break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                sc.nextLine();
            }
        }

        return 1.0 * luongCoBan + phuCap + soTienTip;
    }

    public static int getSoLuongPhucVu() {
        return soLuong;
    }
}
