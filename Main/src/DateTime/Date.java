package DateTime;

import java.util.Objects;
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
                System.out.print("\nNhập ngày: ");
                this.ngay = sc.nextShort();

                System.out.print("Nhập tháng: ");
                this.thang = sc.nextShort();

                System.out.print("Nhập năm: ");
                this.nam = sc.nextShort();

                if (thang < 1 || thang > 12)
                    throw new RuntimeException("Tháng không hợp lệ!!!");
                if (ngay < 1 || ngay > soNgayTrongThang(thang, nam))
                    throw new RuntimeException("Ngày không hợp lệ!!!");
                if (nam < 0)
                    throw new RuntimeException("Năm không hợp lệ!!!");

                valid = true;

            } catch (Exception e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại!");
                sc.nextLine();
            }
        }
    }

    private int soNgayTrongThang(int thang, int nam) {
        switch (thang) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return kiemTraNamNhuan() ? 29 : 28;
        }
        return 0;
    }

    // Hàm toString để in thông tin
    @Override
    public String toString() {
        return String.format("%d/%d/%d", ngay, thang, nam);
    }

    // Hàm kiểm tra năm nhuận
    public boolean kiemTraNamNhuan() {
        return (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
    }

    public short getThang() {
        return thang;
    }

    public short getNam() {
        return nam;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Date date = (Date) obj;
        return ngay == date.ngay && thang == date.thang && nam == date.nam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ngay, thang, nam);
    }
}
