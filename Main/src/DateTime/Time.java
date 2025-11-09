package DateTime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Time {
    private byte gio, phut, giay;

    public Time() {}

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
        boolean valid = false;

        while (!valid) {
            try {
                // Nhập giờ
                System.out.print("\nNhập giờ: ");
                this.gio = sc.nextByte();

                // Kiểm tra giờ có hợp lệ không
                if (gio > 24 || gio < 0) {
                    throw new RuntimeException("Giờ không hợp lệ !!!");
                }

                // Nhập phút
                System.out.print("Nhập phút: ");
                this.phut = sc.nextByte();

                // Kiểm tra phút có hợp lệ không
                if (phut > 60 || phut < 0) {
                    throw new RuntimeException("Phút không hợp lệ !!!");
                }

                // Nhập giây
                System.out.print("Nhập giây: ");
                this.giay = sc.nextByte();

                // Kiểm tra giây có hợp lệ không
                if (giay > 60 || giay < 0) {
                    throw new RuntimeException("Giây không hợp lệ !!!");
                }

                valid = true;

            } catch (InputMismatchException e) {
                System.out.println("Lỗi: input không hợp lệ. Vui lòng nhập lại.");
                sc.nextLine();
            }
        }
    }
}
