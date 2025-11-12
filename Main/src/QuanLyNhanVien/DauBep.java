package QuanLyNhanVien;

import DateTime.Date;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DauBep extends NhanVien {
    private static int soLuong = 0;
    private final int luongCoBan = 7_800_000;
    private final int phuCapTayNghe = 600_000;
    private int soLuongMonDaNau;

    public DauBep() {
        super();
        chucVu = "DB";
        soLuong++;
    }

    public DauBep(int maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh) {
        super(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
        chucVu = "DB";
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
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Số lượng món đầu bếp " + tenNhanVien + " đã nấu: ");
                soLuongMonDaNau = sc.nextInt();
                sc.nextLine();

                if (soLuongMonDaNau < 0) {
                    System.out.println("Số lượng món ăn đã nấu phải là số dương!!!");
                } else {
                    break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                sc.nextLine();
            }
        }

        return 1.0 * luongCoBan + phuCapTayNghe + (soLuongMonDaNau * 5000);
    }

    public static int getSoLuongDauBep() {
        return soLuong;
    }
}
