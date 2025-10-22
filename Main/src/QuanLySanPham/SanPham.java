package QuanLySanPham;

import DateTime.Date;
import Interface_XuLy.INhapXuat;

import java.util.Scanner;

public abstract class SanPham implements INhapXuat {
    protected int maSanPham = 0;
    protected String tenSanPham;
    protected double giaSanPham;
    protected String loaiSanPham;

    SanPham() {
        tenSanPham = "";
        giaSanPham = 0.0;
    }

    public SanPham(String tenSanPham, double giaSanPham) {
        maSanPham++;
        this.giaSanPham = giaSanPham;
        this.tenSanPham = tenSanPham;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
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
        maSanPham++;
        System.out.println("Nhập tên sản phẩm: ");
        tenSanPham = sc.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        giaSanPham = sc.nextDouble();
    }

    @Override
    public void xuatThongTin() {
        System.out.print("Mã sản phẩm: " + maSanPham + "| Loại sản phẩm: " + loaiSanPham +"| Tên: " + tenSanPham + "| Giá: " + giaSanPham);
    }

    public abstract void menuThuocTinh();
}
