package QuanLyNhanVien;


import java.util.Scanner;

import DateTime.Date;
import Interface_XuLy.INhapXuat;

import XuLyString.StringUtils;

public abstract class NhanVien implements INhapXuat {
    protected int maNhanVien = 0;
    protected String tenNhanVien;
    protected Date ngaySinh;
    protected String gioiTinh;
    protected String chucVu;
    public NhanVien() {
        this.tenNhanVien = "";
        this.ngaySinh = new Date();
        this.gioiTinh = "";
        this.chucVu = "";
    }

    public NhanVien(String tenNhanVien, Date ngaySinh, String gioiTinh, String chucVu) {
        maNhanVien++;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
    }

    // Hàm tính lương cho nhân viên.
    public abstract double tinhLuongThucTe();

    // Hàm nhập thông tin của nhân viên
    @Override
    public void nhapThongTin(Scanner sc) {
        maNhanVien++;
        System.out.print("Nhập tên nhân viên: ");
        this.tenNhanVien = sc.nextLine();
        System.out.print("Nhập ngày sinh nhân viên: ");
        ngaySinh.nhapDate(sc);
        sc.nextLine();
        System.out.print("Nhập giới tính nhân viên (F/ M): ");
        this.gioiTinh = sc.nextLine();
        System.out.print("Nhập chức vụ nhân viên: ");
        this.chucVu = sc.nextLine();
    }

    // Hàm xuất thông tin của nhân viên
    @Override
    public void xuatThongTin() {
        System.out.println("-------------------------------");
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Họ và tên: " + StringUtils.chuanHoaThongTin(tenNhanVien));
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Giới tính: " + StringUtils.chuanHoaThongTin(gioiTinh));
        System.out.println("Chức vụ: " + chucVu);
    }

    // Hàm tùy chọn thuộc tính cần sửa của nhân viên
    public void menuThuocTinh() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Họ và tên");
            System.out.println("2. Giới tính");
            System.out.println("3. Ngày sinh");
            System.out.println("4. Chức vụ");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.print("Lựa chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Nhập họ và tên mới: ");
                String hoTen = sc.nextLine();
                setTenNhanVien(hoTen);
            } else if (choice == 2) {
                System.out.print("Nhập giới tính: ");
                String gioiTinh = sc.nextLine();
                setGioiTinh(gioiTinh);
            } else if (choice == 3) {
                System.out.print("Nhập ngày sinh: ");
                Date ngaySinh = new Date();
                setNgaySinh(ngaySinh);
            }
        } while (choice != 0);
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}