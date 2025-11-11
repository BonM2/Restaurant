package QuanLyBanAn;

import Interface_XuLy.INhapXuat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BanAn implements INhapXuat {
    private static int count = 0;
    private int maBan;
    private int soLuongChoNgoi;
    private boolean trangThai;

    public BanAn() {
        BanAn.count++;
        maBan = BanAn.count;
        soLuongChoNgoi = 0;
        trangThai = false;
    }

    public BanAn(int maBan, int soLuongChoNgoi, boolean trangThai) {
        this.maBan = maBan;
        this.soLuongChoNgoi = soLuongChoNgoi;
        this.trangThai = trangThai;

        if (maBan > BanAn.count) {
            BanAn.count = maBan;
        }
    }

    public int getMaBan() {
        return maBan;
    }

    public int getSoLuongChoNgoi() {
        return soLuongChoNgoi;
    }

    public void setSoLuongChoNgoi(int soLuongChoNgoi) {
        this.soLuongChoNgoi = soLuongChoNgoi;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public void nhapThongTin(Scanner sc) {

        // Nhập số lượng chỗ ngồi
        while (true) {
            try {
                System.out.print("Nhập số lượng chỗ ngồi: ");
                soLuongChoNgoi = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            }
        }

        // Nhập trạng thái bàn ăn
        while (true) {
            System.out.print("Nhập trạng thái của bàn ăn (1. Đã đặt / 0. Trống): ");
            String input = sc.nextLine();

            if (input.equals("1")) {
                trangThai = true;
                break;
            } else if (input.equals("0")) {
                trangThai = false;
                break;
            } else {
                System.out.println("Lỗi: Chỉ nhập 1 hoặc 0. Nhập lại!");
            }
        }
    }


    @Override
    public void xuatThongTin() {
        System.out.printf("Bàn %d | Chỗ ngồi: %d | Trạng thái: %s\n",
                maBan, soLuongChoNgoi, (trangThai ? "Có khách đặt" : "Trống"));
    }

    @Override
    public String toString() {
        return maBan + "," + soLuongChoNgoi + "," + trangThai;
    }

    public void menuThuocTinh() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Số lượng chỗ ngồi trong bàn ăn.");
            System.out.println("2. Trạng thái bàn ăn.");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.print("Lựa chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                while (true) {
                    try {
                        System.out.print("Nhập số lượng chỗ ngồi mới: ");
                        int new_SoLuong = Integer.parseInt(sc.nextLine());
                        setSoLuongChoNgoi(new_SoLuong);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                    }
                }
            } else if (choice == 2) {
                while (true) {
                    System.out.print("Nhập trạng thái của bàn ăn (1. Đã đặt / 0. Trống): ");
                    String input = sc.nextLine();

                    if (input.equals("1")) {
                        setTrangThai(true);
                        break;
                    } else if (input.equals("0")) {
                        setTrangThai(false);
                        break;
                    } else {
                        System.out.println("Lỗi: Chỉ nhập 1 hoặc 0. Nhập lại!");
                    }
                }
            }
        } while (choice != 0);
    }
}
