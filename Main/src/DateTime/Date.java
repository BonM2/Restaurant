package DateTime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Date {
    private short ngay, thang, nam;

    public Date() {}

    public Date(short ngay, short thang, short nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public void nhapDate(Scanner sc) {
        boolean valid = false;

        while (!valid) {
            try {
                // Nhập ngày
                System.out.print("Nhập ngày: ");
                this.ngay = sc.nextShort();

                // Kiểm tra ngày có hợp lệ không
                if (ngay > 31 || ngay < 1) {
                    throw new RuntimeException("Ngày không hợp lệ!!!");
                }

                // Nhập tháng
                System.out.print("Nhập tháng: ");
                this.thang = sc.nextShort();

                // Kiểm tra tháng có hợp lệ không
                if (thang > 12 || thang < 1) {
                    throw new RuntimeException("Tháng không hợp lệ!!!");
                }

                if ((thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12)) {
                    if (ngay > 31 || ngay < 1) {
                        throw new RuntimeException("Ngày không hợp lệ!!!");
                    }
                } else if ((thang == 4 || thang == 6 || thang == 9 || thang == 11)) {
                    if (ngay > 30 || ngay < 1) {
                        throw new RuntimeException("Ngày không hợp lệ!!!");
                    }
                } else {
                    if (kiemTraNamNhuan() && (ngay > 29 || ngay < 1)) {
                        throw new RuntimeException("Ngày không hợp lệ!!!");
                    } else if (!kiemTraNamNhuan() && (ngay > 28 || ngay < 1)) {
                        throw new RuntimeException("Ngày không hợp lệ!!!");
                    }
                }

                // Nhập năm
                System.out.print("Nhập năm: ");
                this.nam = sc.nextShort();

                valid = true;

            } catch (InputMismatchException e) {
                System.out.println("Lỗi: input không hợp lệ. Vui lòng nhập lại.");
                sc.nextLine();
            }
        }
    }

    // Hàm toString để in thông tin
    @Override
    public String toString() {
        return String.format("Ngày %d, tháng %d, năm %d", ngay, thang, nam);
    }

    // Hàm kiểm tra năm nhuận
    public boolean kiemTraNamNhuan() {
        return (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
    }

    public short getNgay() {
        return ngay;
    }

    public short getThang() {
        return thang;
    }

    public short getNam() {
        return nam;
    }
}
