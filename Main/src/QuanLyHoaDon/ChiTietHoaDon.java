package QuanLyHoaDon;

import Interface_XuLy.INhapXuat;
import QuanLySanPham.SanPham;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChiTietHoaDon implements INhapXuat {
    private Map<SanPham, Integer> dsGoi;

    public ChiTietHoaDon() {
        dsGoi = new HashMap<>();
    }


    public void nhapThongTin(SanPham sanPham, int soLuongSanPham) {

        if (sanPham == null || soLuongSanPham <= 0) {
            return;
        }

        int soLuongSPHienTai = dsGoi.getOrDefault(sanPham, 0);

        this.dsGoi.put(sanPham, soLuongSPHienTai + soLuongSanPham);

        System.out.println("Đã thêm: " + sanPham.getTenSanPham() + " (Số lượng: " + soLuongSanPham + ")");
     }

    public double tinhThanhTien() {
        double tong = 0.0;

        for (Map.Entry<SanPham, Integer> entry : dsGoi.entrySet()) {
            SanPham sanPham = entry.getKey();
            int soLuong = entry.getValue();

            tong += sanPham.getGiaSanPham() * soLuong;
        }

        return tong;
    }

    @Override
    public void xuatThongTin() {
        System.out.println("-----Chi Tiết Hóa Đơn-----");

        int i = 1;

        for (Map.Entry<SanPham, Integer> entry : dsGoi.entrySet()) {
            SanPham sanPham = entry.getKey();
            int soLuong = entry.getValue();

            double giaTien = sanPham.getGiaSanPham() * soLuong;

            System.out.println(i + ". Tên: " + sanPham.getTenSanPham() + ". Số lượng: " + soLuong + ". Giá: " + giaTien);
        }
    }

    @Override
    public void nhapThongTin(Scanner sc) {}


    public Map<SanPham, Integer> getDsGoi() {
        return dsGoi;
    }

    public void setDsGoi(Map<SanPham, Integer> dsGoi) {
        this.dsGoi = dsGoi;
    }
}

