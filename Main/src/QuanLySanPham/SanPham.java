package QuanLySanPham;

import Interface_XuLy.INhapXuat;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class SanPham implements INhapXuat {
    protected int maSanPham;
    private static int count = 0;
    protected String tenSanPham;
    protected double giaSanPham;
    protected String loaiSanPham;

    SanPham() {
        SanPham.count++;
        maSanPham = SanPham.count;
        tenSanPham = "";
        giaSanPham = 0.0;
    }

    public SanPham(String tenSanPham, double giaSanPham) {
        SanPham.count++;
        this.maSanPham = SanPham.count;
        this.giaSanPham = giaSanPham;
        this.tenSanPham = tenSanPham;
    }

    public SanPham(int maSanPham, String tenSanPham, double giaSanPham) {

        this.maSanPham = maSanPham;
        this.giaSanPham = giaSanPham;
        this.tenSanPham = tenSanPham;

        if (maSanPham > SanPham.count) {
            SanPham.count = maSanPham;
        }
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(double giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    @Override
    public void nhapThongTin(Scanner sc) {

        System.out.print("Nhập tên sản phẩm: ");
        tenSanPham = sc.nextLine();

        while(true) {

            try {
                System.out.print("Nhập giá sản phẩm: ");
                giaSanPham = sc.nextDouble();
                sc.nextLine();

                if (giaSanPham < 0) {
                    System.out.println("Giá sản phẩm phải là số dương!!!");
                } else {
                    break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            }
        }
    }

    @Override
    public void xuatThongTin() {
        System.out.print("Mã sản phẩm: " + maSanPham + "| Loại sản phẩm: " + loaiSanPham + "| Tên: " + tenSanPham + "| Giá: " + giaSanPham);
    }

    public abstract void menuThuocTinh();

    @Override
    public String toString() {
        return maSanPham + "," + tenSanPham + "," + giaSanPham + "," + loaiSanPham;
    }

}