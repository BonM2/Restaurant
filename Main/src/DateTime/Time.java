package DateTime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Time {
    private byte gio, phut, giay;

    public Time() {
    }

    public Time(byte gio, byte phut, byte giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.gio, this.phut, this.giay);
    }

    public void nhapTime(Scanner sc) {

        // Nhập giờ
        while (true) {
            try {
                System.out.print("\nNhập giờ: ");
                this.gio = sc.nextByte();
                if (gio < 0 || gio > 23) {
                    System.out.println("Giờ không hợp lệ (0-23). Vui lòng nhập lại.");
                    continue;
                }
                break; // hợp lệ thì thoát vòng lặp
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập lại giờ.");
                sc.nextLine(); // Xóa input lỗi
            }
        }

        // Nhập phút
        while (true) {
            try {
                System.out.print("Nhập phút: ");
                this.phut = sc.nextByte();
                if (phut < 0 || phut > 59) {
                    System.out.println("Phút không hợp lệ (0-59). Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập lại phút.");
                sc.nextLine();
            }
        }

        // Nhập giây
        while (true) {
            try {
                System.out.print("Nhập giây: ");
                this.giay = sc.nextByte();
                if (giay < 0 || giay > 59) {
                    System.out.println("Giây không hợp lệ (0-59). Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập lại giây.");
                sc.nextLine();
            }
        }
    }

}
