package QuanLyDatBan;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.INhapXuat;
import KhachHang.KhachHang;
import QuanLyBanAn.BanAn;

import java.util.Scanner;

public class DatBan implements INhapXuat {
    private static int maDatBan = 0;
    private BanAn banAn;
    private KhachHang khachHang;
    private Date ngayDatBan;
    private Time thoiGianDatBan;
    private byte sucChua;

    public DatBan() {
        banAn = new BanAn();
        khachHang = new KhachHang();
        ngayDatBan = new Date();
        thoiGianDatBan = new Time();
        sucChua = 0;
    }

    public DatBan(BanAn banAn, KhachHang khachHang, Date ngayDatBan, Time thoiGianDatBan, byte sucChua) {
        maDatBan++;
        this.banAn = banAn;
        this.khachHang = khachHang;
        this.ngayDatBan = ngayDatBan;
        this.thoiGianDatBan = thoiGianDatBan;
        this.sucChua = sucChua;
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

    public byte getSucChua() {
        return sucChua;
    }

    public void setSucChua(byte sucChua) {
        this.sucChua = sucChua;
    }

    public Time getThoiGianDatBan() {
        return thoiGianDatBan;
    }

    public void setThoiGianDatBan(Time thoiGianDatBan) {
        this.thoiGianDatBan = thoiGianDatBan;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhập thông tin bàn ăn: ");
        banAn = new BanAn();
        banAn.nhapThongTin(sc);

        System.out.print("Nhập thông tin khách hàng: ");
        khachHang = new KhachHang();
        khachHang.nhapThongTin(sc);

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

    public void menuThuocTinh() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Thông tin bàn ăn.");
            System.out.println("2. Thông tin khách hàng.");
            System.out.println("3. Ngày đặt bàn.");
            System.out.println("4. Thời gian đặt bàn.");
            System.out.println("5. Số lượng khách hàng.");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.println("Lựa chọn: ");

            choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Mời nhập lựa chọn muốn sửa: ");
                BanAn banAn1 = new BanAn();
                banAn1.menuThuocTinh();
                setBanAn(banAn1);
            } else if (choice == 2) {
                System.out.println("Mời nhập lựa chọn muốn sửa: ");
                KhachHang khachHang1 = new KhachHang();
                khachHang1.menuThuocTinh();
                setKhachHang(khachHang1);
            } else if (choice == 3) {
                System.out.println("Mời nhập ngày mới: ");
                Date date = new Date();
                date.nhapDate(sc);
                setNgayDatBan(date);
            } else if (choice == 4) {
                System.out.println("Mời nhập thời gian mới: ");
                Time time = new Time();
                time.nhapTime(sc);
                setThoiGianDatBan(time);
            }  else if (choice == 5) {
                System.out.println("Mời nhập số lượng khách mới: ");
                byte sucChua = sc.nextByte();
                setSucChua(sucChua);
            }
        } while (choice != 0);
    }
}
