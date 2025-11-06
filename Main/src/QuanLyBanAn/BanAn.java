package QuanLyBanAn;

import Interface_XuLy.INhapXuat;
import QuanLyNhanVien.NhanVien;

import java.util.Scanner;

public class BanAn implements INhapXuat {
    private static int count = 0;
    private int maBan;
    private byte soLuongChoNgoi;
    private boolean trangThai;

    public BanAn() {
        BanAn.count++;
        maBan = BanAn.count;
        soLuongChoNgoi = 0;
        trangThai = false;
    }

    public BanAn(byte soLuongChoNgoi, boolean trangThai) {
        BanAn.count++;
        maBan = BanAn.count;
        this.soLuongChoNgoi = soLuongChoNgoi;
        this.trangThai = trangThai;
    }

    public BanAn(int maBan, byte soLuongChoNgoi, boolean trangThai) {
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

    public byte getSoLuongChoNgoi() {
        return soLuongChoNgoi;
    }

    public void setSoLuongChoNgoi(byte soLuongChoNgoi) {
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
        System.out.print("Nhập số lượng chỗ ngồi: ");
        soLuongChoNgoi = sc.nextByte();
        System.out.print("Nhập trạng thái của bàn ăn: (1. Đã đặt/ 0. Trống): ");
        trangThai = (sc.nextInt() == 1);
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
                System.out.print("Mời nhập số lượng chỗ ngồi mới của bàn ăn: ");
                byte new_SoLuong = sc.nextByte();
                sc.nextLine();
                setSoLuongChoNgoi(new_SoLuong);
            } else if (choice == 2) {
                System.out.print("Mời nhập trạng thái của bàn ăn: (1. Đã đặt/ 0. Trống): ");
                boolean new_TrangThai = (sc.nextInt() == 1);;
                setTrangThai(new_TrangThai);
            }
        } while (choice != 0);
    }
}
