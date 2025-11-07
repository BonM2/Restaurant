package QuanLyNhaHang;

import DateTime.Date;
import QuanLyBanAn.DanhSachBanAn;
import QuanLyDatBan.DanhSachDatBan;
import QuanLyDatBan.DatBan;
import QuanLyHoaDon.DanhSachHoaDon;
import QuanLyHoaDon.HoaDon;
import QuanLyNhanVien.DanhSachNhanVien;
import QuanLyNhanVien.NhanVien;
import QuanLySanPham.DanhSachSanPham;
import QuanLySanPham.SanPham;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyNhaHang {
    private static String matKhau = "";
    public static Scanner sc = new Scanner(System.in);
    private static final String URL_MatKhau = "C:\\Users\\Bao\\IdeaProjects\\Restaurant\\Main\\src\\Data\\MatKhau";
    private static final String tenCuaHang = "SGU Corner";
    private static final String diaChiCuaHang = "273 An Dương Vương, Phường Chợ Quán, Hồ Chí Minh";
    private static final DanhSachNhanVien dsNhanVien = new DanhSachNhanVien();
    private static final DanhSachBanAn dsBanAn = new DanhSachBanAn();
    private static final DanhSachDatBan dsDatBan = new DanhSachDatBan();
    private static final DanhSachSanPham dsSanPham = new DanhSachSanPham();
    private static final DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();

    public static void menuChucNangChinh() {
        System.out.println("Chào mừng đến với cửa hàng " + tenCuaHang);
        System.out.println("Địa chỉ: " + diaChiCuaHang);
        System.out.println("---------MENU CHỨC NĂNG CHÍNH---------");
        System.out.println("1/ Quản lý nhân viên");
        System.out.println("2/ Quản lý bàn ăn");
        System.out.println("3/ Quản lý đặt bàn");
        System.out.println("4/ Quản lý sản phẩm");
        System.out.println("5/ Quản lý hóa đơn");
        System.out.println("6/ Đổi mật khẩu");
        System.out.println("0/ Thoát chương trình!!!");
    }

    public static void doiMatKhau() {
        System.out.print("Nhập mật khẩu mới: ");
        matKhau = sc.nextLine();

        try {
            PrintWriter pw = new PrintWriter(URL_MatKhau);
            pw.println(matKhau);
            pw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void menuChucNangNhanVien() {
        System.out.println("---------Quản lý nhân viên----------");
        System.out.println("1/ Thêm nhân viên");
        System.out.println("2/ Sửa thông tin nhân viên");
        System.out.println("3/ Xóa nhân viên theo mã số");
        System.out.println("4/ Xuất danh sách nhân viên");
        System.out.println("5/ Xuất bảng lương nhân viên");
        System.out.println("6/ Xuất số lượng nhân viên theo loại");
        System.out.println("7/ Tìm nhân viên theo mã số");
        System.out.println("8/ Đọc file");
        System.out.println("9/ Ghi file");
        System.out.println("0/ Thoát");
    }

    public static void luaChonChucNangNhanVien(int choice) {
        try {
            switch (choice) {
                case 1:
                    dsNhanVien.themThongTin();
                    break;
                case 2:
                    System.out.print("Nhập mã nhân viên muốn sửa thông tin: ");
                    int maNhanVienSua = sc.nextInt();
                    sc.nextLine();
                    dsNhanVien.suaThongTin(maNhanVienSua);
                    break;
                case 3:
                    System.out.print("Nhập mã nhân viên muốn xóa: ");
                    int maNhanVienXoa = sc.nextInt();
                    sc.nextLine();
                    dsNhanVien.xoaThongTin(maNhanVienXoa);
                    break;
                case 4:
                    dsNhanVien.hienThiDanhSachNhanVien();
                    break;
                case 5:
                    dsNhanVien.xuatBangLuongNhanVien();
                    break;
                case 6:
                    dsNhanVien.inSoLuongNhanVienTheoChucVu();
                    break;
                case 7:
                    System.out.print("Nhập mã nhân viên muốn tìm: ");
                    int maNhanVienTim = sc.nextInt();
                    sc.nextLine();

                    NhanVien nv = dsNhanVien.timNhanVienTheoMa(maNhanVienTim);

                    if (nv != null) {
                        nv.xuatThongTin();
                    } else {
                        System.out.println("Không tồn tại mã số nhân viên này!!!");
                    }
                    break;
                case 8:
                    dsNhanVien.docFile();
                    break;
                case 9:
                    dsNhanVien.ghiFile();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lỗi: Chỉ nhập từ 0 đến 9!");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            sc.nextLine();
        }
    }


    public static void menuChucNangBanAn() {
        System.out.println("----------Quản lý bàn ăn---------");
        System.out.println("1/ Thêm bàn ăn");
        System.out.println("2/ Sửa thông tin bàn ăn");
        System.out.println("3/ Xóa bàn ăn theo mã");
        System.out.println("4/ Hiển thị danh sách bàn ăn");
        System.out.println("5/ Hiển thị số lượng bàn ăn trống");
        System.out.println("6/ Đọc file");
        System.out.println("7/ Ghi file");
        System.out.println("8/ Hiển thị số lượng bàn ăn hiện tại");
        System.out.println("0/ Thoát");
    }

    public static void luaChonChucNangBanAn(int choice) {
        try {
            switch (choice) {
                case 1:
                    dsBanAn.themThongTin();
                    break;
                case 2:
                    System.out.print("Nhập mã bàn ăn cần sửa: ");
                    int maBanAnSua = sc.nextInt();
                    sc.nextLine();
                    dsBanAn.suaThongTin(maBanAnSua);
                    break;
                case 3:
                    System.out.print("Nhập mã bàn ăn cần xóa: ");
                    int maBanAnXoa = sc.nextInt();
                    sc.nextLine();
                    dsBanAn.xoaThongTin(maBanAnXoa);
                    break;
                case 4:
                    dsBanAn.hienThiDanhSachBanAn();
                    break;
                case 5:
                    int soLuongBanTrong = dsBanAn.soLuongBanTrong();
                    System.out.println("Số lượng bàn ăn trống: " + soLuongBanTrong);
                    break;
                case 6:
                    dsBanAn.docFile();
                    break;
                case 7:
                    dsBanAn.ghiFile();
                    break;
                case 8:
                    dsBanAn.hienThiSoLuongBanAnHienTai();
                    break;
                case 0:
                    break;
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            sc.nextLine();
        }
    }


    public static void menuChucNangDatBan() {
        System.out.println("----------Quản lý đặt bàn----------");
        System.out.println("1/ Thêm yêu cầu đặt bàn");
        System.out.println("2/ Xóa yêu cầu đặt bàn");
        System.out.println("3/ Sửa yêu cầu đặt bàn");
        System.out.println("4/ Hiển thị danh sách đặt bàn");
        System.out.println("5/ Tìm yêu cầu đặt bàn");
        System.out.println("6/ Đọc file");
        System.out.println("7/ Ghi file");
        System.out.println("0/ Thoát");
    }

    public static void luaChonChucNangDatBan(int choice) {
        try {
            switch (choice) {
                case 1:
                    dsDatBan.themThongTin();
                    break;
                case 2:
                    System.out.print("Nhập mã đặt bàn muốn xóa: ");
                    int maDatBanXoa = sc.nextInt();
                    sc.nextLine();
                    dsDatBan.xoaThongTin(maDatBanXoa);
                    break;
                case 3:
                    System.out.print("Nhập mã đặt bàn để sửa thông tin: ");
                    int maDatBanSua = sc.nextInt();
                    sc.nextLine();
                    dsDatBan.suaThongTin(maDatBanSua);
                    break;
                case 4:
                    dsDatBan.hienThiDanhSachDatBan();
                    break;
                case 5:
                    System.out.print("Nhập mã đặt bàn muốn tìm: ");
                    int maDatBanTim = sc.nextInt();
                    sc.nextLine();
                    DatBan datBan = dsDatBan.timThongTinDatBan(maDatBanTim);

                    if (datBan != null) {
                        datBan.xuatThongTin();
                    } else {
                        System.out.println("Không tồn tại mã đặt bàn này!!!");
                    }

                    break;
                case 6:
                    dsDatBan.docFile();
                    break;
                case 7:
                    dsDatBan.ghiFile();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lỗi: Chỉ nhập từ 0 đến 7!");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            sc.nextLine();
        }
    }


    public static void menuChucNangSanPham() {
        System.out.println("---------Quản lý sản phẩm----------");
        System.out.println("1/ Thêm sản phẩm");
        System.out.println("2/ Sửa thông tin sản phẩm");
        System.out.println("3/ Xóa sản phẩm theo mã");
        System.out.println("4/ Tìm sản phẩm");
        System.out.println("5/ Hiển thị danh sách sản phẩm");
        System.out.println("6/ Đọc file");
        System.out.println("7/ Ghi file");
        System.out.println("0/ Thoát");
    }

    public static void luaChonChucNangSanPham(int choice) {
        try {
            switch (choice) {
                case 1:
                    dsSanPham.themThongTin();
                    break;
                case 2:
                    System.out.print("Nhập mã sản phẩm muốn sửa thông tin: ");
                    int maSanPhamSua = sc.nextInt();
                    sc.nextLine();
                    dsSanPham.suaThongTin(maSanPhamSua);
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm muốn xóa: ");
                    int maSanPhamXoa = sc.nextInt();
                    sc.nextLine();
                    dsSanPham.xoaThongTin(maSanPhamXoa);
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm muốn tìm: ");
                    int maSanPhamTim = sc.nextInt();
                    sc.nextLine();
                    SanPham sp = dsSanPham.timSanPham(maSanPhamTim);
                    if (sp != null) {
                        sp.xuatThongTin();
                    } else {
                        System.out.println("Không tồn tại mã sản phẩm này.");
                    }
                    break;
                case 5:
                    dsSanPham.hienthiSanPham();
                    break;
                case 6:
                    dsSanPham.docFile();
                    break;
                case 7:
                    dsSanPham.ghiFile();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lỗi: Chỉ nhập từ 0 đến 7!");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            sc.nextLine();
        }
    }


    public static void menuChucNangHoaDon() {
        System.out.println("---------Quản lý hóa đơn----------");
        System.out.println("1/ Thêm hóa đơn");
        System.out.println("2/ Xóa hóa đơn");
        System.out.println("3/ Sửa thông tin hóa đơn");
        System.out.println("4/ Hiển thị danh sách hóa đơn");
        System.out.println("5/ Hiển thị danh sách hóa đơn theo tháng");
        System.out.println("6/ Hiển thị danh sách hóa đơn theo ngày");
        System.out.println("7/ Tìm hóa đơn");
        System.out.println("8/ Tính doanh thu theo tháng");
        System.out.println("9/ Tính doanh thu theo ngày");
        System.out.println("10/ Đọc file");
        System.out.println("11/ Ghi file");
        System.out.println("0/ Thoát");
    }

    public static void luaChonChucNangHoaDon(int choice) {
        try {
            switch (choice) {
                case 1:
                    dsHoaDon.themThongTin();
                    break;
                case 2:
                    System.out.print("Nhập mã hóa đơn muốn xóa: ");
                    int maHoaDonXoa = sc.nextInt();
                    sc.nextLine();
                    dsHoaDon.xoaThongTin(maHoaDonXoa);
                    break;
                case 3:
                    System.out.print("Nhập mã hóa đơn cần sửa thông tin: ");
                    int maHoaDonSua = sc.nextInt();
                    sc.nextLine();
                    dsHoaDon.suaThongTin(maHoaDonSua);
                    break;
                case 4:
                    dsHoaDon.hienThiDanhSachHoaDon();
                    break;
                case 5:
                    System.out.print("Nhập tháng và năm cần tìm: ");
                    short thangTim = sc.nextShort();
                    short namTim = sc.nextShort();
                    sc.nextLine();
                    ArrayList<HoaDon> dsHoaDonTheoThang = dsHoaDon.timHoaDonTheoThang(thangTim, namTim);
                    System.out.println("Thông tin danh sách hóa đơn theo tháng: ");

                    for (HoaDon hd : dsHoaDonTheoThang) {
                        if (hd != null) {
                            hd.xuatThongTin();
                        }
                    }
                    break;
                case 6:
                    System.out.print("Nhập ngày, tháng và năm cần tìm: ");
                    Date ngayCanTim = new Date();
                    ngayCanTim.nhapDate(sc);
                    ArrayList<HoaDon> dsHoaDonTheoNgay = dsHoaDon.timHoaDonTheoNgay(ngayCanTim);

                    System.out.println("Danh sách hóa đơn theo ngày: ");
                    for (HoaDon hd : dsHoaDonTheoNgay) {
                        if (hd != null) {
                            hd.xuatThongTin();
                        }
                    }
                    break;
                case 7:
                    System.out.print("Nhập mã hóa đơn cần tìm: ");
                    int maHoaDonTim = sc.nextInt();
                    sc.nextLine();
                    HoaDon hoaDon = dsHoaDon.timHoaDon(maHoaDonTim);
                    if (hoaDon != null) {
                        hoaDon.xuatThongTin();
                    } else {
                        System.out.println("Không tồn tại mã hóa đơn này!!!");
                    }
                    break;
                case 8:
                    System.out.print("Nhập tháng và năm cần tính: ");
                    short thangTinh = sc.nextShort();
                    short namTinh = sc.nextShort();
                    sc.nextLine();
                    System.out.println("Doanh thu theo tháng " + thangTinh + "/" + namTinh + ": " +
                            dsHoaDon.tinhDoanhThuTheoThang(thangTinh, namTinh));
                    break;
                case 9:
                    System.out.print("Nhập ngày, tháng và năm cần tính: ");
                    Date ngayCanTinh = new Date();
                    ngayCanTinh.nhapDate(sc);
                    System.out.println("Doanh thu theo " + ngayCanTinh + ": " +
                            dsHoaDon.tinhDoanhThuTheoNgay(ngayCanTinh));
                    break;
                case 10:
                    dsHoaDon.docFile();
                    break;
                case 11:
                    dsHoaDon.ghiFile();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lỗi: Chỉ nhập từ 0 đến 11!");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            sc.nextLine();
        }
    }


    public static void layMatKhau() {
        try (Scanner sc = new Scanner(new File(URL_MatKhau))) {
            matKhau = "";

            if (sc.hasNextLine()) {
                matKhau = sc.nextLine();
            } else {
                throw new RuntimeException("Đã đọc hết dữ liệu trong file!!!");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Không tồn tại file mật khẩu!!!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        layMatKhau();

        int attempt = 5;

        while (attempt > 0) {

            try {
                System.out.print("Mời nhập mật khẩu: ");
                String password = sc.nextLine();

                if (matKhau.equals(password)) {
                    System.out.println("Đăng nhập thành công!!!");
                    break;
                } else {
                    attempt--;
                    System.out.printf("Bạn còn %d lần nhập\n", attempt);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (attempt == 0) {
                System.out.println("Bạn đã nhập sai quá 5 lần!!!. Chương trình sẽ tự động thoát");
                System.exit(0);
            }
        }

        int choice = -1;
        do {
            menuChucNangChinh();
            try {
                System.out.print("Mời nhập lựa chọn: ");
                choice = sc.nextInt();
                sc.nextLine();
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                sc.nextLine();
                continue;
            }

            if (choice == 1) {
                int nhanVienChoice = -1;
                do {
                    menuChucNangNhanVien();
                    try {
                        System.out.print("Mời nhập lựa chọn: ");
                        nhanVienChoice = sc.nextInt();
                        sc.nextLine();
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                        sc.nextLine();
                        continue;
                    }
                    luaChonChucNangNhanVien(nhanVienChoice);
                } while (nhanVienChoice != 0);
            } else if (choice == 2) {
                int banAnChoice = -1;
                do {
                    menuChucNangBanAn();
                    try {
                        System.out.print("Mời nhập lựa chọn: ");
                        banAnChoice = sc.nextInt();
                        sc.nextLine();
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                        sc.nextLine();
                        continue;
                    }
                    luaChonChucNangBanAn(banAnChoice);
                } while (banAnChoice != 0);
            } else if (choice == 3) {
                int datBanChoice = -1;
                do {
                    menuChucNangDatBan();
                    try {
                        System.out.print("Mời nhập lựa chọn: ");
                        datBanChoice = sc.nextInt();
                        sc.nextLine();
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                        sc.nextLine();
                        continue;
                    }
                    luaChonChucNangDatBan(datBanChoice);
                } while (datBanChoice != 0);
            } else if (choice == 4) {
                int sanPhamChoice = -1;
                do {
                    menuChucNangSanPham();
                    try {
                        System.out.print("Mời nhập lựa chọn: ");
                        sanPhamChoice = sc.nextInt();
                        sc.nextLine();
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                        sc.nextLine();
                        continue;
                    }
                    luaChonChucNangSanPham(sanPhamChoice);
                } while (sanPhamChoice != 0);
            } else if (choice == 5) {
                int hoaDonChoice = -1;
                do {
                    menuChucNangHoaDon();
                    try {
                        System.out.print("Mời nhập lựa chọn: ");
                        hoaDonChoice = sc.nextInt();
                        sc.nextLine();
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                        sc.nextLine();
                        continue;
                    }
                    luaChonChucNangHoaDon(hoaDonChoice);
                } while (hoaDonChoice != 0);
            } else if (choice == 6) {
                doiMatKhau();
            }
        } while (choice != 0);
    }

    public static Scanner getSc() {
        return sc;
    }
}
