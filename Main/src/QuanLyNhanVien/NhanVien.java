package QuanLyNhanVien;


import java.util.Scanner;

import DateTime.Date;
import Interface_XuLy.INhapXuat;

import XuLyString.StringUtils;

public abstract class NhanVien implements INhapXuat {
    private static int count = 0;
    protected int maNhanVien;
    protected String tenNhanVien;
    protected Date ngaySinh;
    protected String gioiTinh;
    protected String chucVu;

    public NhanVien() {
        ++NhanVien.count;
        this.maNhanVien = NhanVien.count;
        this.tenNhanVien = "";
        this.ngaySinh = new Date();
        this.gioiTinh = "";
        this.chucVu = "";
    }

    public NhanVien(String tenNhanVien, Date ngaySinh, String gioiTinh) {
        ++NhanVien.count;
        this.maNhanVien = NhanVien.count;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public NhanVien(int maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;

        if (maNhanVien > NhanVien.count) {
            NhanVien.count = maNhanVien;
        }
    }

    // Hàm tính lương cho nhân viên.
    public abstract double tinhLuongThucTe();

    // Hàm nhập thông tin của nhân viên
    @Override
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhập tên nhân viên: ");
        this.tenNhanVien = sc.nextLine();
        System.out.print("Nhập ngày sinh nhân viên: ");
        ngaySinh.nhapDate(sc);
        sc.nextLine();

        while (true) {
            System.out.print("Nhập giới tính nhân viên (F/ M): ");
            this.gioiTinh = sc.nextLine();

            if (gioiTinh.equals("F") || gioiTinh.equals("M")) {
                break;
            } else {
                System.out.println("Lỗi: Chỉ nhập F hoặc M. Nhập lại!");
            }
        }
    }

    // Hàm xuất thông tin của nhân viên
    @Override
    public void xuatThongTin() {
        System.out.println("-------------------------------");
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Họ và tên: " + StringUtils.chuanHoaThongTin(tenNhanVien));
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Chức vụ: " + chucVu);
    }

    @Override
    public String toString() {
        return maNhanVien + "," + tenNhanVien + "," + ngaySinh + "," + gioiTinh + "," + chucVu;
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
                while (true) {
                    System.out.print("Nhập giới tính mới (F/ M): ");
                    String new_gioiTinh = sc.nextLine();

                    if (new_gioiTinh.equals("F") || new_gioiTinh.equals("M")) {
                        setGioiTinh(new_gioiTinh);
                        break;
                    } else {
                        System.out.println("Lỗi: Chỉ nhập F hoặc M. Nhập lại!");
                    }
                }
            } else if (choice == 3) {
                System.out.print("Nhập ngày sinh mới: ");
                Date ngaySinh = new Date();
                ngaySinh.nhapDate(sc);
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

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getChucVu() {
        return chucVu;
    }
}