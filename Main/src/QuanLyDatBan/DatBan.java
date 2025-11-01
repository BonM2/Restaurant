package QuanLyDatBan;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.INhapXuat;
import KhachHang.KhachHang;
import QuanLyBanAn.BanAn;
import QuanLyBanAn.DanhSachBanAn;

import java.util.Scanner;

public class DatBan implements INhapXuat {

    private int maDatBan = 0;
    private BanAn banAn;
    private byte soLuongKhach;
    private KhachHang khachHang;
    private Date ngayDatBan;
    private Time thoiGianDatBan;

    public DatBan() {
        banAn = new BanAn();
        khachHang = new KhachHang();
        ngayDatBan = new Date();
        thoiGianDatBan = new Time();
    }

    public DatBan(byte soLuongKhach, KhachHang khachHang, Date ngayDatBan, Time thoiGianDatBan) {
        maDatBan++;
        DanhSachBanAn danhSachBanAn = new DanhSachBanAn();
        banAn = danhSachBanAn.timBanTrong(soLuongKhach);
        this.khachHang = khachHang;
        this.ngayDatBan = ngayDatBan;
        this.thoiGianDatBan = thoiGianDatBan;
    }

    public DatBan(int maDatBan, BanAn banAn, KhachHang khachHang, Date ngayDatBan, Time thoiGianDatBan) {
        this.maDatBan = maDatBan;
        this.banAn = banAn;
        this.khachHang = khachHang;
        this.ngayDatBan = ngayDatBan;
        this.thoiGianDatBan = thoiGianDatBan;
    }
    public int getMaDatBan() {
        return maDatBan;
    }

    public BanAn getBanAn() {
        return banAn;
    }

    public void setBanAn(BanAn banAn) {
        this.banAn = banAn;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayDatBan() {
        return ngayDatBan;
    }

    public void setNgayDatBan(Date ngayDatBan) {
        this.ngayDatBan = ngayDatBan;
    }

    public Time getThoiGianDatBan() {
        return thoiGianDatBan;
    }

    public byte getSoLuongKhach() {
        return soLuongKhach;
    }


    public void setThoiGianDatBan(Time thoiGianDatBan) {
        this.thoiGianDatBan = thoiGianDatBan;
    }

    @Override
    public void nhapThongTin(Scanner sc) {

        System.out.print("Nhập thông tin khách hàng: ");
        khachHang = new KhachHang();
        khachHang.nhapThongTin(sc);

        System.out.print("Nhập số lượng khách hàng: ");
        soLuongKhach = sc.nextByte();

        DanhSachBanAn danhSachBanAn = new DanhSachBanAn();
        banAn = danhSachBanAn.timBanTrong(soLuongKhach);

        if (banAn != null) {
            System.out.println("Tìm bàn ăn theo nhu cầu của khách hàng thành công!!!");
            banAn.setTrangThai(true);
        } else {
            System.out.println("Không có bàn ăn nào đáp ứng nhu cầu của khách hàng!!!");
            return;
        }

        System.out.print("Ngày đặt bàn: ");
        ngayDatBan = new Date();
        ngayDatBan.nhapDate(sc);

        System.out.print("Thời gian đặt bàn: ");
        thoiGianDatBan = new Time();
        thoiGianDatBan.nhapTime(sc);
    }

    @Override
    public void xuatThongTin() {
        System.out.print("Mã đặt bàn: " + getMaDatBan() + "\n");
        System.out.println("Thông tin bàn ăn: ");
        banAn.xuatThongTin();
        System.out.println("Thông tin khách hàng: ");
        khachHang.xuatThongTin();
        System.out.println("Ngày đặt bàn: " + ngayDatBan.toString());
        System.out.println("Thời gian đặt bàn: " + thoiGianDatBan.toString());
    }

    public void setSoLuongKhach(byte soLuongKhach) {
        this.soLuongKhach = soLuongKhach;
    }

    public void menuThuocTinh() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Thông tin khách hàng.");
            System.out.println("2. Ngày đặt bàn.");
            System.out.println("3. Thời gian đặt bàn.");
            System.out.println("4. Số lượng khách hàng.");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.println("Lựa chọn: ");

            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Mời nhập lựa chọn muốn sửa: ");
                KhachHang khachHang1 = new KhachHang();
                khachHang1.menuThuocTinh();
                setKhachHang(khachHang1);
            } else if (choice == 2) {
                System.out.println("Mời nhập ngày mới: ");
                Date date = new Date();
                date.nhapDate(sc);
                setNgayDatBan(date);
            } else if (choice == 3) {
                System.out.println("Mời nhập thời gian mới: ");
                Time time = new Time();
                time.nhapTime(sc);
                setThoiGianDatBan(time);
            } else if (choice == 4) {
                System.out.print("Số lượng khách hàng mới: ");
                byte new_soLuongKhachHang = sc.nextByte();
                setSoLuongKhach(new_soLuongKhachHang);
            }
        } while (choice != 0);
    }
}
