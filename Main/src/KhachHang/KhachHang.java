package KhachHang;

import Interface_XuLy.INhapXuat;
import XuLyString.StringUtils;
import java.util.Scanner;

public class KhachHang implements INhapXuat {
    private static int count = 0;
    private int maKhachHang;
    private String tenKhachHang;
    private String phoneNumber;

    public KhachHang() {
        KhachHang.count++;
        maKhachHang = KhachHang.count;
        tenKhachHang = "";
        phoneNumber = "";
    }

    public KhachHang(String tenKhachHang, String phoneNumber) {
        KhachHang.count++;
        maKhachHang = KhachHang.count;
        this.tenKhachHang = tenKhachHang;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhập tên khách hàng: ");
        this.tenKhachHang = sc.nextLine();
        System.out.print("Nhập số điện thoại khách hàng: ");
        phoneNumber = sc.nextLine();
    }

    @Override
    public void xuatThongTin() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Mã khách hàng: " + maKhachHang + "| Tên khách hàng: " + StringUtils.chuanHoaThongTin(tenKhachHang) + "| SĐT: " + phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void menuThuocTinh() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Tên khách hàng.");
            System.out.println("2. Số điện thoại.");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.print("Lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Mời nhập tên mới: ");
                tenKhachHang = sc.nextLine();
                setTenKhachHang(tenKhachHang);
            } else if (choice == 2) {
                System.out.print("Mời nhập số điện thoại mới: ");
                phoneNumber = sc.nextLine();
                setPhoneNumber(phoneNumber);
            }
        } while(choice != 0);
    }
}
