package QuanLyHoaDon;

import java.util.Scanner;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.INhapXuat;
import KhachHang.KhachHang;
import QuanLySanPham.DanhSachSanPham;
import QuanLySanPham.DoUong;
import QuanLySanPham.MonAn;
import QuanLySanPham.SanPham;

public class HoaDon implements INhapXuat {
    private int maHoaDon = 0;
    private int maBanAn;
    private ChiTietHoaDon chiTietHoaDon;
    private double tongTien;
    private boolean coVoucher;
    private int phieuGiamGia;
    private String tenNhanVienTao;
    private Time thoiGianTao;
    private Date ngayTao;

    public HoaDon() {
        maBanAn = -1;
        chiTietHoaDon = new ChiTietHoaDon();
        tongTien = 0.0;
        coVoucher = false;
        phieuGiamGia = 0;
        tenNhanVienTao = "";
        thoiGianTao = new Time();
        ngayTao = new Date();
    }

    public HoaDon(int maBanAn, ChiTietHoaDon chiTietHoaDon, double tongTien, boolean coVoucher, int phieuGiamGia, String tenNhanVienTao, Time thoiGianTao, Date ngayTao) {
        maHoaDon++;
        this.maBanAn = maBanAn;
        this.chiTietHoaDon = chiTietHoaDon;
        this.tongTien = tongTien;
        this.coVoucher = coVoucher;
        this.phieuGiamGia = phieuGiamGia;
        this.tenNhanVienTao = tenNhanVienTao;
        this.thoiGianTao = thoiGianTao;
        this.ngayTao = ngayTao;
    }

    // nhập thông tin hóa đơn
    public void nhapThongTin(Scanner sc) {
        maHoaDon++;

        System.out.print("Nhập mã bàn ăn: ");
        maBanAn = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập tên nhân viên tạo hóa đơn: ");
        tenNhanVienTao = sc.nextLine();

        System.out.print("Có voucher hay không ? (1 = có /0 = không) ");
        int isTrue = sc.nextInt();
        coVoucher = (isTrue == 1);

        if (coVoucher) {
            System.out.print("Nhập giá trị của voucher (%): ");
            phieuGiamGia = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Nhập chi tiết thông tin hóa đơn: ");

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

        System.out.print("Nhập thời gian tạo hóa đơn: ");
        thoiGianTao = new Time();
        thoiGianTao.nhapTime(sc);

        System.out.print("Nhập ngày tạo hóa đơn: ");
        ngayTao = new Date();
        ngayTao.nhapDate(sc);
    }

    // xuất thông tin hóa đơn
    public void xuatThongTin() {
        System.out.println("______________________________");
        System.out.println("Mã hóa đơn: " + maHoaDon);
        System.out.println("Mã bàn ăn: " + maBanAn);
        System.out.println("Tình trạng voucher: ");
        if (coVoucher)
            System.out.println("Có voucher và giảm giá " + phieuGiamGia + "%");
        else
            System.out.println("Không có voucher");
        System.out.println("Thời gian tạo hóa đơn: " + thoiGianTao.toString());
        System.out.println("Ngày tạo hóa đơn: " + ngayTao.toString());
        chiTietHoaDon.xuatThongTin();
        System.out.println("Tổng tiền: " + capNhatTongTien());
        System.out.println("______________________________");
    }

    //các lựa chọn để thực hiện
    public void menuThuocTinh() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Mã bàn ăn.");
            System.out.println("2. Tên nhân viên tạo.");
            System.out.println("3. Tình trạng voucher.");
            System.out.println("4. Thời gian tạo hóa đơn.");
            System.out.println("5. Ngày tạo hóa đơn.");
            System.out.println("6. Chỉnh sửa chi tiết hóa đơn");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.println("Lựa chọn: ");

            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Mời nhập mã bàn ăn mới: ");
                int new_maBan = sc.nextInt();
                setMaBanAn(new_maBan);
            } else if (choice == 2) {
                System.out.print("Mời nhập tên mới của nhân viên tạo hóa đơn: ");
                String new_name = sc.nextLine();
                setTenNhanVienTao(new_name);
            } else if (choice == 3) {
                System.out.print("Mời nhập tình trạng voucher (1 = có / 0 = không): ");
                int isTrue = sc.nextInt();
                boolean new_Voucher = (isTrue == 1);

                if (new_Voucher) {
                    System.out.print("Nhập phần trăm giảm giá của phiếu mới (%): ");
                    int new_phieuGiamGia = sc.nextInt();
                    setCoVoucher(true);
                    setPhieuGiamGia(new_phieuGiamGia);
                    System.out.print("Đã áp dụng giảm giá " + new_phieuGiamGia + "%");
                } else {
                    setCoVoucher(false);
                    setPhieuGiamGia(0);
                    System.out.println("Không thay đổi về tình trạng voucher đối với hóa đơn này!");
                }
            } else if (choice == 4) {
                System.out.println("Mời nhập thời gian mới: ");
                Time new_time = new Time();
                new_time.nhapTime(sc);
                setThoiGianTao(new_time);
            } else if (choice == 5) {
                System.out.println("Mời nhập ngày tạo mới: ");
                Date new_date = new Date();
                new_date.nhapDate(sc);
                setNgayTao(new_date);
            } else if (choice == 6) {
                System.out.println("1. Sửa tên.");
                System.out.println("2. Sửa số lượng.");
                System.out.print("Mời nhập lựa chọn: ");
                int select = sc.nextInt();

                if (select == 1) {
                    System.out.println("Mời nhập tên mới: ");
                    String tenSP = sc.nextLine();

                } else if (select == 2) {
                    System.out.println("Mời nhập số lượng mới: ");
                    int soLuong = sc.nextInt();

                }
            }
        } while (choice != 0);
    }

    public double capNhatTongTien() {
        double tongTien = chiTietHoaDon.tinhThanhTien();

        if (coVoucher) {
            return tongTien * (double) ((100 - phieuGiamGia) / 100);
        }

        return tongTien;
    }
    public ChiTietHoaDon getChiTietHoaDon() {
        return chiTietHoaDon;
    }
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaBanAn() {
        return maBanAn;
    }

    public void setMaBanAn(int maBanAn) {
        this.maBanAn = maBanAn;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isCoVoucher() {
        return coVoucher;
    }

    public void setCoVoucher(boolean coVoucher) {
        this.coVoucher = coVoucher;
    }

    public int getPhieuGiamGia() {
        return phieuGiamGia;
    }

    public void setPhieuGiamGia(int phieuGiamGia) {
        this.phieuGiamGia = phieuGiamGia;
    }

    public String getTenNhanVienTao() {
        return tenNhanVienTao;
    }

    public void setTenNhanVienTao(String tenNhanVienTao) {
        this.tenNhanVienTao = tenNhanVienTao;
    }

    public Time getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Time thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public short getThangTao() {
        return ngayTao.getThang();
    }

    public short getNamTao() {
        return ngayTao.getNam();
    }
}