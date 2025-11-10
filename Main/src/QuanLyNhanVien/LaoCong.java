package QuanLyNhanVien;

import DateTime.Date;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LaoCong extends NhanVien {
    private static int soLuong = 0;
    private final int luongCoBan = 4_800_000;
    private final int phuCapChuyenCan = 300_000;

    public LaoCong() {
        super();
        chucVu = "LC";
        soLuong++;
    }

    public LaoCong(String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "LC";
        soLuong++;
    }

    public LaoCong(int maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "LC";
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

        int tongDiem;

        while (true) {
            try {
                System.out.print("Mời nhập số điểm tháng của lao công " + tenNhanVien + ": ");
                tongDiem = sc.nextInt();
                sc.nextLine();

                if (tongDiem < 0) {
                    System.out.println("Số điểm phải là số dương!!!");
                } else {
                    break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                sc.nextLine();
            }
        }

        return 1.0 * luongCoBan + (tongDiem * 10000);
    }

    public static int getSoLuongLaoCong() {
        return soLuong;
    }
}
