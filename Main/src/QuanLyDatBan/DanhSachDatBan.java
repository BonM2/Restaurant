package QuanLyDatBan;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.IThemSuaXoa;
import KhachHang.KhachHang;
import QuanLyBanAn.BanAn;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachDatBan implements IThemSuaXoa {
    private ArrayList<DatBan> dsDatBan;

    public DanhSachDatBan() {
        dsDatBan = new ArrayList<>();
    }

    public DanhSachDatBan(ArrayList<DatBan> dsDatBan) {
        this.dsDatBan = dsDatBan;
    }

    public ArrayList<DatBan> getDsDatBan() {
        return dsDatBan;
    }

    public void setDsDatBan(ArrayList<DatBan> dsDatBan) {
        this.dsDatBan = dsDatBan;
    }

    @Override
    public void themThongTin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập thông tin bàn ăn: ");
        BanAn banAn = new BanAn();
        banAn.nhapThongTin(sc);

        System.out.print("Nhập thông tin khách hàng: ");
        KhachHang khachHang = new KhachHang();
        khachHang.nhapThongTin(sc);

        System.out.print("Nhập ngày đặt bàn: ");
        Date ngayDatBan = new Date();
        ngayDatBan.nhapDate(sc);

        System.out.print("Nhập thời gian đặt bàn: ");
        Time thoiGianDatBan = new Time();
        thoiGianDatBan.nhapTime(sc);

        System.out.print("Nhập số lượng khách hàng: ");
        byte soLuongKhachHang = sc.nextByte();

        DatBan new_DatBan = new DatBan(banAn, khachHang, ngayDatBan, thoiGianDatBan, soLuongKhachHang);
        dsDatBan.add(new_DatBan);

        System.out.println("Thêm yêu cầu đặt bàn thành công!!!");
    }

    public DatBan timThongTinDatBan(int maDatBan) {
        for (DatBan datBan : dsDatBan) {
            if (datBan.getMaDatBan() == maDatBan) {
                return datBan;
            }
        }
        return null;
    }

    @Override
    public void xoaThongTin(int maDatBan) {
        DatBan datBan = timThongTinDatBan(maDatBan);

        if (datBan != null) {
            dsDatBan.remove(datBan);
            System.out.println("Xóa thành công lời đặt bàn với mã số " + maDatBan);
        }
        else {
            System.out.println("Không tìm thấy mã đặt bàn!!!");
        }
    }

    @Override
    public void suaThongTin(int maDatBan) {
        try (Scanner sc = new Scanner(System.in)) {
            DatBan datBan = timThongTinDatBan(maDatBan);
            if (datBan != null) {
                datBan.menuThuocTinh();
            } else {
                System.out.println("Không tồn tại mã đặt bàn này!!!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
