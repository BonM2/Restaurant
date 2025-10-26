package QuanLyHoaDon;

import java.util.ArrayList;
import java.util.Scanner;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.INhapXuat;
import KhachHang.KhachHang;
import QuanLyBanAn.BanAn;
import QuanLyDatBan.DatBan;
import QuanLyNhanVien.NhanVien;
import QuanLyMonAn.MonAn;
import QuanLyNhanVien.TiepTan;

public abstract class HoaDon implements INhapXuat{
    private int maHoaDon = 0 ;
    private BanAn banAn;
    private ArrayList<ChiTietHoaDon> dsChiTiet;
    private double tongTien;
    private boolean coVoucher;
    private double phieuGiamGia;
    private NhanVien nhanVienTao;
    private KhachHang loaiKhachHang;
    private Time thoiGianTao;

    public HoaDon(){
        banAn = new BanAn();
        dsChiTiet=new ArrayList<>();
        tongTien=0;
        coVoucher=false;
        phieuGiamGia=0;
        nhanVienTao=new TiepTan();
        loaiKhachHang=new KhachHang();
        thoiGianTao=new Time();

    }
    public HoaDon(int maHoaDon, BanAn banAn, ArrayList<ChiTietHoaDon> dsChiTiet, double tongTien, boolean coVoucher, double phieuGiamGia, NhanVien nhanVienTao, KhachHang loaiKhachHang, Time thoiGianTao) {
        maHoaDon++;
        this.banAn = banAn;
        this.dsChiTiet = dsChiTiet;
        this.tongTien = tongTien;
        this.coVoucher = coVoucher;
        this.phieuGiamGia = phieuGiamGia;
        this.nhanVienTao = nhanVienTao;
        this.loaiKhachHang = loaiKhachHang;
        this.thoiGianTao = thoiGianTao;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public BanAn getBanAn() {
        return banAn;
    }

    public void setBanAn(BanAn banAn) {
        this.banAn = banAn;
    }

    public ArrayList<ChiTietHoaDon> getDsChiTiet() {
        return dsChiTiet;
    }

    public void setDsChiTiet(ArrayList<ChiTietHoaDon> dsChiTiet) {
        this.dsChiTiet = dsChiTiet;
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

    public double getPhieuGiamGia() {
        return phieuGiamGia;
    }

    public void setPhieuGiamGia(double phieuGiamGia) {
        this.phieuGiamGia = phieuGiamGia;
    }

    public NhanVien getNhanVienTao() {
        return nhanVienTao;
    }

    public void setNhanVienTao(NhanVien nhanVienTao) {
        this.nhanVienTao = nhanVienTao;
    }

    public KhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(KhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public Time getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Time thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }
    // nhập thông tin hóa đơn
    public void nhapThongTin(Scanner sc){
        maHoaDon++;

        System.out.println("Nhập bàn ăn: ");
        banAn=new BanAn();
        banAn.nhapThongTin(sc);

        System.out.println("Nhập nhân viên tạo hóa đơn: ");
        nhanVienTao=new TiepTan();
        nhanVienTao.nhapThongTin(sc);

        System.out.println("Nhập loại khách hàng: ");
        loaiKhachHang=new KhachHang();
        String loai=sc.nextLine();
        loaiKhachHang.setLoaiKhach(loai);

        System.out.println("Nhập có voucher hay không ? (true = có /false = không) ");
        coVoucher=sc.nextBoolean();
        if(coVoucher){
            System.out.println("Nhập giá trị của voucher (%): ");
            phieuGiamGia=sc.nextDouble();sc.nextLine();
        }

//        System.out.println("Nhập các món ăn trong hóa đơn: ");
//        String process;
//        do {
//            MonAn monAn=new MonAn();
//        }while{
//
//        }

        // Có cần thêm ngày tạo không b ?
        System.out.println("Nhập thời gian tạo hóa đơn: ");
        thoiGianTao=new Time();
        thoiGianTao.nhapTime(sc);
    }

    // xuất thông tin hóa đơn
    public void xuatThongTin(){
        System.out.println("______________________________");
        System.out.println("Mã hóa đơn: "+ maHoaDon);
        System.out.println("Bàn ăn: ");banAn.xuatThongTin();
        System.out.println("Loại khách hàng: ");loaiKhachHang.getLoaiKhach();
        System.out.printf("Tình trạng voucher: ");
            if(coVoucher) System.out.println("Có voucher và giảm giá "+phieuGiamGia+"%");
                else System.out.println("Không có voucher");


                // các sản phẩm trong hóa đơn ..........................................


        System.out.println("Thời gian tạo hóa đơn: "+thoiGianTao.toString());
    }

    //các lựa chọn để thực hiện
    public void menuThuocTinh(){
        Scanner sc=new Scanner(System.in);
        int choice;

        do {
            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Thông tin bàn ăn.");
            System.out.println("2. Thông tin nhân viên tạo.");
            System.out.println("3. Thông tin loại khách hàng.");
            System.out.println("4. Tình trạng voucher.");

            // sửa các loại sản phẩm trong hóa đơn .......

            System.out.println("5. Thời gian tạo hóa đơn.");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.println("Lựa chọn: ");

            choice = sc.nextInt();sc.nextLine();
            if (choice == 1) {
                System.out.print("Mời nhập lựa chọn muốn sửa: ");
                BanAn new_banAn = new BanAn();
                new_banAn.menuThuocTinh();
                setBanAn(new_banAn);
            } else if (choice == 2) {
                System.out.println("Mời nhập lựa chọn muốn sửa: ");
                NhanVien new_nhanVienTao = new TiepTan();
                new_nhanVienTao.menuThuocTinh();
                setNhanVienTao(new_nhanVienTao);
            } else if (choice == 3) {
                System.out.println("Mời nhập lựa chọn muốn sửa: ");
                KhachHang new_khachHang = new KhachHang();
                String loai=sc.nextLine();
                new_khachHang.setLoaiKhach(loai);
                setLoaiKhachHang(new_khachHang);
            } else if (choice == 4) {
                System.out.println("Mời nhập tình trạng voucher (true = có / false = không): ");
                boolean new_Voucher = sc.nextBoolean();

                if(new_Voucher){
                    System.out.println("Nhập phần trăm giảm giá của phiếu mới (%): ");
                    double new_phieuGiamGia= sc.nextDouble();
                    setCoVoucher(true);
                    setPhieuGiamGia(new_phieuGiamGia);
                    System.out.println("Đã áp dụng giảm giá "+new_phieuGiamGia+"%");
                }else{
                    setCoVoucher(false);
                    setPhieuGiamGia(0);
                    System.out.println("Không thay đổi về tình trạng voucher đối với hóa đơn này!");
                }
            }  else if (choice == 5) {
                System.out.println("Mời nhập thời gian mới: ");
                Time new_time = new Time();
                new_time.nhapTime(sc);
                setThoiGianTao(new_time);
            }
        } while (choice != 0);
    }

    public void capNhatTongTien(){
        for(ChiTietHoaDon dsct : dsChiTiet){
            tongTien += dsct.tinhThanhTien();
        }
        if(coVoucher){
            tongTien *= ((100 - phieuGiamGia)/100);
        }
    }

    //public void themSanPham (MonAn monAn,int soLuong){}


}



