package QuanLyHoaDon;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.IThemSuaXoa;
import KhachHang.KhachHang;
import QuanLyBanAn.BanAn;
import QuanLyDatBan.DatBan;
import QuanLyNhanVien.NhanVien;
import QuanLyNhanVien.TiepTan;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachHoaDon implements IThemSuaXoa{
    private ArrayList<HoaDon> dsHoaDon;
    DanhSachHoaDon(){
            dsHoaDon = new ArrayList<>();
    }
    DanhSachHoaDon(ArrayList<HoaDon> dsHoaDon){
            this.dsHoaDon=dsHoaDon;
        }

    public ArrayList<HoaDon> getDsHoaDon() {
        return dsHoaDon;
    }

    public void setDsHoaDon(ArrayList<HoaDon> dsHoaDon) {
        this.dsHoaDon = dsHoaDon;
    }

    //1.Thêm hóa đơn
    public void themThongTin(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Tạo thông tin hóa đơn mới.");

        System.out.println("Nhập thông tin bàn ăn mới: ");
        BanAn banAn = new BanAn();
        banAn.nhapThongTin(sc);

        System.out.println("Nhập thông tin nhân viên tạo hóa đơn: ");
        NhanVien nhanVienTao=new TiepTan();
        nhanVienTao.nhapThongTin(sc);

        System.out.println("Nhập thông tin loại khách hàng: ");
        KhachHang khachHang= new KhachHang();
        String loai = sc.nextLine();
        khachHang.setLoaiKhach(loai);

        System.out.println("Nhập tình trạng voucher (true = có / false = không): ");
        boolean coVoucher = sc.nextBoolean();
        if(coVoucher){
            System.out.println("Nhập ưu đãi được giảm giá từ voucher (%): ");
            double phieuGiamGia = sc.nextDouble();sc.nextLine();
        }else{
            System.out.println("Bạn không có mã giảm giá !");
        }

        //nhập sản phẩm thêm vào hóa đơn

        System.out.println("Nhập thời gian tạo hóa đơn: ");
        Time thoiGianTao = new Time();
        thoiGianTao.nhapTime(sc);

    }
    //2.Tìm hóa đơn
    public HoaDon timHoaDon(int maHoaDon){
        for(HoaDon bill : dsHoaDon){
            if(bill.getMaHoaDon() == maHoaDon){
                return bill;
            }

        }
        return null;
    }
    //3.Xóa hóa đơn
    public void xoaThongTin(int maHoaDon){
        HoaDon bill = timHoaDon(maHoaDon);

        if(bill != null){
            dsHoaDon.remove(maHoaDon);
            return;
        }else {
            System.out.println("Không tìm thấy hóa đơn trên hệ thống !");
        }

    }
    //4.Sửa hóa đơn
    public void suaThongTin(int maHoaDon){
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
    public void hienThiHoaDon(){
        System.out.println("Hiển thị danh sách hóa đơn.");
        for(HoaDon bill: dsHoaDon){
            bill.xuatThongTin();
        }
        System.out.println("Đã hiển thị tất cả hóa đơn! ");
    }
    //6.Tinh doanh thu theo ngay
    public Double tinhDoanhThuTheoNgay(Date day){
        double tong=0;
        for(HoaDon bill:dsHoaDon){
            tong += bill.getTongTien();
        }
        return tong;
    }

    //7.Tinh doanh thu theo thang
//    public Double tinhDoanhThuTheoThang(byte thang,short nam){
//        double tongMoiNgay,tongThang=0;
//        if (thang < 1 || thang > 12) {
//            System.out.println("Tháng không hợp lệ!");
//            return null;
//        }
//
//        int day;
//        if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12){
//            day = 31;
//        }else if(thang == 4 || thang == 6 || thang == 9 || thang == 11){
//            day = 30;
//        }else{
//            if(nam % 400 == 0 || nam % 4==0 && nam % 100!=0){
//                day = 29;
//            }else{
//                day = 28;
//            }
//        }
//
//        System.out.println("Doanh thu tháng "+thang+" năm "+ nam);
//
//        for(int i = 1;i<=day;i++){
//            for (HoaDon bill : dsHoaDon) {
//                Date d = bill.getThoiGianTao().getDate();
//                if (d.getNgay() == day && d.getThang() == thang && d.getNam() == nam) {
//                    tongMoiNgay += bill.getTongTien();
//                }
//            }
//            tongThang += tongMoiNgay;
//        }
//    }


    //8.docFile

    //9.ghiFile
}
