package KhachHang;

import DateTime.Date;
import Interface_XuLy.INhapXuat;
import XuLyString.StringUtils;
import java.util.Scanner;

public class KhachHang implements INhapXuat {
    private static int maKhachHang = 0;
    private String tenKhachHang;
    private String phoneNumber;

    private Date ngaySinhKhachHang;
    private String loaiKhach;

    public KhachHang() {
        tenKhachHang = "";
        ngaySinhKhachHang = new Date();
        phoneNumber = "";
        loaiKhach = "";
    }

    public KhachHang(String tenKhachHang, Date ngaySinhKhachHang, String phoneNumber, String loaiKhach) {
        maKhachHang++;
        this.tenKhachHang = tenKhachHang;
        this.phoneNumber = phoneNumber;
        this.ngaySinhKhachHang = ngaySinhKhachHang;
        this.loaiKhach = loaiKhach;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhập tên khách hàng: ");
        this.tenKhachHang = sc.nextLine();
        System.out.print("Nhập ngày sinh khách hàng: ");
        ngaySinhKhachHang = new Date();
        ngaySinhKhachHang.nhapDate(sc);
        System.out.print("Nhập loại khách hàng (Vip/Standard): ");
        this.loaiKhach = sc.nextLine();
    }

    @Override
    public void xuatThongTin() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Mã khách hàng: " + maKhachHang + "| Tên khách hàng: " + StringUtils.chuanHoaThongTin(tenKhachHang) + "| SĐT: " + phoneNumber
                + "| Loại khách hàng: " + loaiKhach + "| Ngày sinh: " + ngaySinhKhachHang;
    }

    public static int getMaKhachHang() {
        return maKhachHang;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getNgaySinhKhachHang() {
        return ngaySinhKhachHang;
    }

    public void setNgaySinhKhachHang(Date ngaySinhKhachHang) {
        this.ngaySinhKhachHang = ngaySinhKhachHang;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public void menuThuocTinh() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Tên khách hàng.");
            System.out.println("2. Số điện thoại.");
            System.out.println("3. Loại khách hàng.");
            System.out.println("4. Tuổi khách hàng.");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.println("Lựa chọn: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Mời nhập tên mới: ");
                String new_name = sc.nextLine();
                setTenKhachHang(new_name);
            } else if (choice == 2) {
                System.out.print("Mời nhập số điện thoại mới: ");
                String new_phoneNumber = sc.nextLine();
                setPhoneNumber(new_phoneNumber);
            } else if (choice == 3) {
                System.out.print("Mời nhập loại khách hàng mới (Vip/ Standard): ");
                String new_loaiKhach = sc.nextLine();
                setLoaiKhach(new_loaiKhach);
            } else if (choice == 4) {
                System.out.print("Mời nhập ngày sinh mới: ");
                Date date = new Date();
                date.nhapDate(sc);
            }
        } while(choice != 0);
    }
}
