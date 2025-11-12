package QuanLyDatBan;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.INhapXuat;
import KhachHang.KhachHang;
import QuanLyBanAn.BanAn;
import QuanLyBanAn.DanhSachBanAn;
import QuanLyNhaHang.QuanLyNhaHang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DatBan implements INhapXuat {
    private static int count = 0;
    private int maDatBan;
    private BanAn banAn;
    private int soLuongKhach;
    private KhachHang khachHang;
    private Date ngayDatBan;
    private Time thoiGianDatBan;

    public DatBan() {
        DatBan.count++;
        maDatBan = DatBan.count;
        banAn = new BanAn();
        khachHang = new KhachHang();
        ngayDatBan = new Date();
        thoiGianDatBan = new Time();
    }

    public DatBan(int maDatBan, BanAn banAn, KhachHang khachHang, Date ngayDatBan, Time thoiGianDatBan) {
        this.maDatBan = maDatBan;
        this.banAn = banAn;
        this.khachHang = khachHang;
        this.ngayDatBan = ngayDatBan;
        this.thoiGianDatBan = thoiGianDatBan;

        if (maDatBan > DatBan.count) {
            DatBan.count = maDatBan;
        }
    }

    @Override
    public void nhapThongTin(Scanner sc) {

        System.out.println("Nhập thông tin khách hàng: ");
        khachHang = new KhachHang();
        khachHang.nhapThongTin(sc);

        while (true) {
            try {
                System.out.print("Nhập số lượng khách hàng: ");
                soLuongKhach = sc.nextInt();
                sc.nextLine();

                if (soLuongKhach < 0) {
                    System.out.println("Số lượng khách hàng phải là số dương!!!. Mời nhập lại");
                } else {
                    break;
                }

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                sc.nextLine();
            }
        }

        banAn = QuanLyNhaHang.getDanhSachBanAn().timBanTrong(soLuongKhach);

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
        System.out.println("---------------------------------------");
        System.out.print("Mã đặt bàn: " + getMaDatBan() + "\n");
        System.out.println("Thông tin bàn ăn: ");
        banAn.xuatThongTin();
        System.out.println("Thông tin khách hàng: ");
        khachHang.xuatThongTin();
        System.out.println("Ngày đặt bàn: " + ngayDatBan.toString());
        System.out.println("Thời gian đặt bàn: " + thoiGianDatBan.toString());
        System.out.println("---------------------------------------");
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
            System.out.print("Lựa chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                khachHang.menuThuocTinh();
                setKhachHang(khachHang);
            } else if (choice == 2) {
                System.out.println("Mời nhập ngày mới: ");
                ngayDatBan.nhapDate(sc);
                setNgayDatBan(ngayDatBan);
            } else if (choice == 3) {
                System.out.println("Mời nhập thời gian mới: ");
                thoiGianDatBan.nhapTime(sc);
                setThoiGianDatBan(thoiGianDatBan);
            } else if (choice == 4) {
                while (true) {
                    try {
                        System.out.print("Số lượng khách hàng mới: ");
                        soLuongKhach = sc.nextInt();
                        sc.nextLine();

                        if (soLuongKhach < 0) {
                            System.out.println("Số lượng khách hàng phải là số dương!!!. Mời nhập lại");
                        } else {
                            BanAn banAnOld = banAn;
                            banAn = QuanLyNhaHang.getDanhSachBanAn().timBanTrong(soLuongKhach);
                            if (banAn != null) {
                                setSoLuongKhach(soLuongKhach);
                                banAn.setTrangThai(true);
                                banAnOld.setTrangThai(false);
                                System.out.println("Thay đổi số lượng khách hàng thành công!!!");
                                break;
                            } else {
                                System.out.println("***Thay đổi số lượng khách hàng không thành công do không tồn tại bàn ăn phù hợp***");
                                break;
                            }
                        }
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                        sc.nextLine();
                    }
                }
            }
        } while (choice != 0);
    }

    @Override
    public String toString() {
        return maDatBan + "," + banAn.getMaBan() + "," + khachHang.getMaKhachHang() + "," + khachHang.getPhoneNumber() + "," + ngayDatBan.toString() + "," + thoiGianDatBan.toString() + "," + soLuongKhach;
    }

    public int getMaDatBan() {
        return maDatBan;
    }

    public BanAn getBanAn() {
        return banAn;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setNgayDatBan(Date ngayDatBan) {
        this.ngayDatBan = ngayDatBan;
    }

    public void setThoiGianDatBan(Time thoiGianDatBan) {
        this.thoiGianDatBan = thoiGianDatBan;
    }

    public void setSoLuongKhach(int soLuongKhach) {
        this.soLuongKhach = soLuongKhach;
    }

}
