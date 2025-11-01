package QuanLyHoaDon;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.IThemSuaXoa;

import QuanLySanPham.DanhSachSanPham;
import QuanLySanPham.DoUong;
import QuanLySanPham.MonAn;
import QuanLySanPham.SanPham;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachHoaDon implements IThemSuaXoa {
    private ArrayList<HoaDon> dsHoaDon;
    private String URL = "C:\\Users\\Bao\\IdeaProjects\\Restaurant\\Main\\src\\Data\\ListHoaDon";

    public DanhSachHoaDon() {
        dsHoaDon = new ArrayList<>();
    }

    public DanhSachHoaDon(ArrayList<HoaDon> dsHoaDon) {
        this.dsHoaDon = dsHoaDon;
    }

    public ArrayList<HoaDon> getDsHoaDon() {
        return dsHoaDon;
    }

    public void setDsHoaDon(ArrayList<HoaDon> dsHoaDon) {
        this.dsHoaDon = dsHoaDon;
    }

    //1.Thêm hóa đơn
    public void themThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tạo thông tin hóa đơn mới.");

        System.out.println("Nhập mã bàn ăn: ");
        int maBan = sc.nextInt();

        sc.nextLine();

        System.out.println("Nhập tên nhân viên tạo hóa đơn: ");
        String tenNhanVienTao = sc.nextLine();

        System.out.println("Nhập tình trạng voucher (1 = có / 0 = không): ");
        int isTrue = sc.nextInt();
        boolean coVoucher = (isTrue == 1);

        int phieuGiamGia = 0;
        if (coVoucher) {
            System.out.println("Nhập ưu đãi được giảm giá từ voucher (%): ");
            phieuGiamGia = sc.nextInt();

            sc.nextLine();
        } else {
            System.out.println("Bạn không có mã giảm giá !");
        }

        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();

        while (true) {

            System.out.println("-----------------------");
            System.out.println("1. Món ăn.");
            System.out.println("2. Đồ uống.");
            System.out.println("0. Thoát.");
            System.out.println("-----------------------");
            int choice = sc.nextInt();

            DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
            danhSachSanPham.hienthiSanPham();

            if (choice == 1) {
                SanPham sanPham = new MonAn();
                sanPham.nhapThongTin(sc);

                System.out.print("Mời nhập số lượng món ăn: ");
                int soLuong = sc.nextInt();

                chiTietHoaDon.nhapThongTin(sanPham, soLuong);
            } else if (choice == 2) {
                SanPham sanPham = new DoUong();
                sanPham.nhapThongTin(sc);

                System.out.print("Mời nhập số lượng đồ uống: ");
                int soLuong = sc.nextInt();

                chiTietHoaDon.nhapThongTin(sanPham, soLuong);
            } else if (choice == 0) {
                break;
            }
        }

        double tongTien = chiTietHoaDon.tinhThanhTien();

        if (coVoucher) {
            tongTien *= ((100 - phieuGiamGia) / 100);
        }

        System.out.println("Nhập thời gian tạo hóa đơn: ");
        Time thoiGianTao = new Time();
        thoiGianTao.nhapTime(sc);

        System.out.println("Nhập ngày tạo hóa đơn: ");
        Date ngayTao = new Date();
        ngayTao.nhapDate(sc);

        HoaDon hoaDon = new HoaDon(maBan, chiTietHoaDon, tongTien, coVoucher, phieuGiamGia, tenNhanVienTao, thoiGianTao, ngayTao);
        dsHoaDon.add(hoaDon);

        System.out.println("Thêm hóa đơn mới thành công!!!");
    }

    //2.Tìm hóa đơn
    public HoaDon timHoaDon(int maHoaDon) {
        for (HoaDon bill : dsHoaDon) {
            if (bill.getMaHoaDon() == maHoaDon) {
                return bill;
            }

        }
        return null;
    }

    //3.Xóa hóa đơn
    public void xoaThongTin(int maHoaDon) {
        HoaDon bill = timHoaDon(maHoaDon);

        if (bill != null) {
            dsHoaDon.remove(maHoaDon);
        } else {
            System.out.println("Không tìm thấy hóa đơn trên hệ thống !");
        }

    }

    //4.Sửa hóa đơn
    public void suaThongTin(int maHoaDon) {
        try (Scanner sc = new Scanner(System.in)) {
            HoaDon bill = timHoaDon(maHoaDon);

            if (bill != null) {
                bill.menuThuocTinh();
            } else {
                System.out.println("Không tồn tại mã hóa đơn này!!!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //5.Hien thi danh sach hoa don
    public void hienThiHoaDon() {
        System.out.println("Hiển thị danh sách hóa đơn.");

        for (HoaDon bill : dsHoaDon) {
            bill.xuatThongTin();
        }
        System.out.println("Đã hiển thị tất cả hóa đơn! ");
    }

    //6.Tinh doanh thu theo ngay
    public Double tinhDoanhThuTheoNgay(Date day) {
        double tong = 0.0;
        ArrayList<HoaDon> hoaDonTheoNgay = timHoaDonTheoNgay(day);

        if (!hoaDonTheoNgay.isEmpty()) {
            for (HoaDon hoaDon : hoaDonTheoNgay) {
                tong += hoaDon.getTongTien();
            }
        } else
            System.out.println("Không tìm thấy hóa đơn của ngày: " + day);

        return tong;
    }

    public ArrayList<HoaDon> timHoaDonTheoNgay(Date day) {

        ArrayList<HoaDon> dsHoaDonTheoNgay = new ArrayList<>();

        for (HoaDon hoaDon : dsHoaDon) {
            if (hoaDon.getNgayTao() == day)
                dsHoaDonTheoNgay.add(hoaDon);
        }

        return dsHoaDonTheoNgay;
    }

    public ArrayList<HoaDon> timHoaDonTheoThang(short thang, short nam) {
        ArrayList<HoaDon> hoaDonTheoThang = new ArrayList<>();

        for (HoaDon hoaDon : dsHoaDon) {
            if (hoaDon.getThangTao() == thang && hoaDon.getNamTao() == nam)
                hoaDonTheoThang.add(hoaDon);
        }
        return hoaDonTheoThang;
    }

    //7.Tinh doanh thu theo thang
    public double tinhDoanhThuTheoThang(short thang, short nam) {
        double tongThang = 0.0;

        ArrayList<HoaDon> hoaDonTheoThang = timHoaDonTheoThang(thang, nam);

        if (!hoaDonTheoThang.isEmpty()) {
            for (HoaDon hoaDon : hoaDonTheoThang) {
                tongThang += hoaDon.getTongTien();
            }
        }
        else
            System.out.println("Không  tìm thấy bất kỳ hóa đơn trong tháng: " + thang + "/" + nam);

        return tongThang;
    }

    //8.docFile
    public void docFile() {
        try {
            dsHoaDon.clear();
            File input = new File(URL);

            if (!input.exists()) {
                input.createNewFile();
            }

            Scanner sc = new Scanner(System.in);
            String[] data = new String[1001];
            int n = 0;

            while (sc.hasNextLine()) {
                data[n] = sc.nextLine();
                n++;
            }

            for (int i = 0; i < n; i++) {
                String[] dataThanhPhan = data[i].split(",");

                int maBanAn = Integer.parseInt(dataThanhPhan[1]);
                String tenNhanVienTao = dataThanhPhan[2];

                int isTrue = Integer.parseInt(dataThanhPhan[3]);
                boolean coVoucher = (isTrue == 1);

                int phieuGiamGia = Integer.parseInt(dataThanhPhan[4]);
                double tongTien = Double.parseDouble(dataThanhPhan[5]);

                String[] date = dataThanhPhan[6].split("/");
                short ngay = Short.parseShort(date[0]);
                short thang = Short.parseShort(date[1]);
                short nam = Short.parseShort(date[2]);

                Date ngayTao = new Date(ngay, thang, nam);

                String[] time = dataThanhPhan[7].split(":");
                byte gio = Byte.parseByte(date[0]);
                byte phut = Byte.parseByte(date[1]);
                byte giay = Byte.parseByte(date[2]);

                Time thoiGianTao = new Time(gio, phut, giay);

                String chiTietStr = dataThanhPhan[8];

                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();

                String[] listSP = chiTietStr.split(";");

                for(String spStr : listSP) {
                    String[] spParts = spStr.split("\\|");

                    String loaiSP = spParts[0];
                    String tenSP = spParts[1];
                    double gia = Double.parseDouble(spParts[2]);

                    SanPham sp;
                    if (loaiSP.equalsIgnoreCase("MON_AN")) {
                        String viMonAn = spParts[3];
                        sp = new MonAn(tenSP, gia, viMonAn);
                    } else {
                        int dungTich = Integer.parseInt(spParts[3]);
                        sp = new DoUong(tenSP, gia, dungTich);
                    }

                    int soLuong = Integer.parseInt(spParts[4]);

                    chiTietHoaDon.nhapThongTin(sp, soLuong);

                    HoaDon hd = new HoaDon(maBanAn, chiTietHoaDon, tongTien, coVoucher, phieuGiamGia, tenNhanVienTao, thoiGianTao, ngayTao);
                    dsHoaDon.add(hd);
                }

                sc.close();
                System.out.println("Đọc file thành công!" );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //9.Ghi File
    public void ghiFile() {
        try {
            File output = new File(URL);

            if (!output.exists()) {
                output.createNewFile();
            }

            PrintWriter pw = new PrintWriter(output);

            for (HoaDon hoaDon : dsHoaDon) {
                if (hoaDon != null)
                    pw.println(hoaDon);
            }

            System.out.println("File đã được cập nhật.");
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}