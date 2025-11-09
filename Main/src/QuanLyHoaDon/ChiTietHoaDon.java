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
    public void nhapThongTin(Scanner sc) {
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        int size = dsGoi.size(), i = 0;

        for (Map.Entry<SanPham, Integer> entry : dsGoi.entrySet()) {
            SanPham sanPham = entry.getKey();
            int soLuong = entry.getValue();

            double giaTien = sanPham.getGiaSanPham() * soLuong;

            if (i < size - 1) {
                if (sanPham.getLoaiSanPham().equals("MON_AN")) {
                    str.append(sanPham.getTenSanPham()).append("|").append(soLuong).append("|").append(giaTien).append(";");
                } else if (sanPham.getLoaiSanPham().equals("DO_UONG")) {
                    str.append(sanPham.getTenSanPham()).append("|").append(soLuong).append("|").append(giaTien).append(";");
                }
            } else {
                if (sanPham.getLoaiSanPham().equals("MON_AN")) {
                    str.append(sanPham.getTenSanPham()).append("|").append(soLuong).append("|").append(giaTien);
                } else if (sanPham.getLoaiSanPham().equals("DO_UONG")) {
                    str.append(sanPham.getTenSanPham()).append("|").append(soLuong).append("|").append(giaTien);
                }
            }

            i++;
        }
        return str.toString();
    }

    public void suaTenSanPham(String tenCu, String tenMoi) {
        for (Map.Entry<SanPham, Integer> entry : dsGoi.entrySet()) {
            if (entry.getKey().getTenSanPham().equalsIgnoreCase(tenCu)) {
                entry.getKey().setTenSanPham(tenMoi);
                System.out.println("Đã cập nhật tên sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có tên: " + tenCu);
    }

    // Phương thức sửa số lượng sản phẩm
    public void suaSoLuongSanPham(String tenSanPham, int soLuongMoi) {
        for (Map.Entry<SanPham, Integer> entry : dsGoi.entrySet()) {
            if (entry.getKey().getTenSanPham().equalsIgnoreCase(tenSanPham)) {
                if (soLuongMoi > 0) {
                    entry.setValue(soLuongMoi);
                    System.out.println("Đã cập nhật số lượng thành công!");
                } else {
                    System.out.println("Số lượng phải là số dương!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có tên: " + tenSanPham);
    }
}

