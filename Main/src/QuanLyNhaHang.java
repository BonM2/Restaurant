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
import java.util.Scanner;

public class QuanLyNhaHang {
    private static String matKhau = "";
    private static final String URL_MatKhau = "C:\\Users\\Bao\\IdeaProjects\\Restaurant\\out\\production\\Main\\Data\\MatKhau";
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
    }

    public static void doiMatKhau() {
        Scanner sc = new Scanner(System.in);
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
        if (choice == 1) {
            dsNhanVien.themThongTin();
        } else if (choice == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã nhân viên muốn sửa thông tin: ");
            int maNhanVien = sc.nextInt();
            dsNhanVien.suaThongTin(maNhanVien);
        } else if (choice == 3) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã nhân viên muốn xóa: ");
            int maNhanVien = sc.nextInt();
            dsNhanVien.xoaThongTin(maNhanVien);
        } else if (choice == 4) {
            dsNhanVien.hienThiDanhSachNhanVien();
        } else if (choice == 5) {
            dsNhanVien.xuatBangLuongNhanVien();
        } else if (choice == 6) {
            dsNhanVien.inSoLuongNhanVienTheoChucVu();
        } else if (choice == 7) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã nhân viên muốn tìm: ");
            int maNhanVien = sc.nextInt();
            NhanVien nv = dsNhanVien.timNhanVienTheoMa(maNhanVien);

            if (nv != null) {
                nv.xuatThongTin();
            } else {
                System.out.println("Không tồn tại mã số nhân viên này!!!");
            }
        } else if (choice == 8) {
            dsNhanVien.docFile();
        } else if (choice == 9) {
            dsNhanVien.ghiFile();
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
        System.out.println("0/ Thoát");
    }

    public static void luaChonChucNangBanAn(int choice) {
        if (choice == 1) {
            dsBanAn.themThongTin();
        } else if (choice == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã bàn ăn cần sửa: ");
            int maBanAn = sc.nextInt();
            dsBanAn.suaThongTin(maBanAn);
        } else if (choice == 3) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã bàn ăn cần xóa: ");
            int maBanAn = sc.nextInt();
            dsBanAn.xoaThongTin(maBanAn);
        } else if (choice == 4) {
            dsBanAn.hienThiDanhSachBanAn();
        } else if (choice == 5) {
            int soLuongBanTrong = dsBanAn.soLuongBanTrong();
            System.out.println("Số lượng bàn ăn trống: " + soLuongBanTrong);
        } else if (choice == 6) {
            dsBanAn.docFile();
        } else if (choice == 7) {
            dsBanAn.ghiFile();
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
        if (choice == 1) {
            dsDatBan.themThongTin();
        } else if (choice == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã đặt bàn muốn xóa: ");
            int maDatBan = sc.nextInt();
            dsDatBan.xoaThongTin(maDatBan);
        } else if (choice == 3) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã đặt bàn để sửa thông tin: ");
            int maDatBan = sc.nextInt();
            dsDatBan.suaThongTin(maDatBan);
        } else if (choice == 4) {
            dsDatBan.hienThiDanhSachDatBan();
        } else if (choice == 5) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã đặt bàn muốn tìm: ");
            int maDatBan = sc.nextInt();
            DatBan datBan = dsDatBan.timThongTinDatBan(maDatBan);

            if (datBan != null) {
                datBan.xuatThongTin();
            } else {
                System.out.println("Không tồn tại mã đặt bàn này!!!");
            }
        } else if (choice == 6) {
            dsDatBan.docFile();
        } else if (choice == 7) {
            dsDatBan.ghiFile();
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
        if (choice == 1) {
            dsSanPham.themThongTin();
        } else if (choice == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã sản phẩm muốn sửa thông tin: ");
            int maSanPham = sc.nextInt();
            dsSanPham.suaThongTin(maSanPham);
        } else if (choice == 3) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã sản phẩm muốn xóa: ");
            int maSanPham = sc.nextInt();
            dsSanPham.xoaThongTin(maSanPham);
        } else if (choice == 4) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã sản phẩm muốn tìm: ");
            int maSanPham = sc.nextInt();
            SanPham sp = dsSanPham.timSanPham(maSanPham);

            if (sp != null) {
                sp.xuatThongTin();
            } else {
                System.out.println("Không tồn tại mã sản phẩm này.");
            }
        } else if (choice == 5) {
            dsSanPham.hienthiSanPham();
        } else if (choice == 6) {
            dsSanPham.docFile();
        } else if (choice == 7) {
            dsSanPham.ghiFile();
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
        if (choice == 1) {
            dsHoaDon.themThongTin();
        } else if (choice == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã hóa đơn muốn xóa: ");
            int maHoaDon = sc.nextInt();
            dsHoaDon.xoaThongTin(maHoaDon);
        } else if (choice == 3) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã hóa đơn cần sửa thông tin: ");
            int maHoaDon = sc.nextInt();
            dsHoaDon.suaThongTin(maHoaDon);
        } else if (choice == 4) {
            dsHoaDon.hienThiDanhSachHoaDon();
        } else if (choice == 5) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập tháng và năm cần tìm: ");

            short thang = sc.nextShort();
            short nam = sc.nextShort();

            ArrayList<HoaDon> dsHoaDonTheoThang = dsHoaDon.timHoaDonTheoThang(thang, nam);

            System.out.println("Thông tin danh sách hóa đơn theo tháng: ");
            for (HoaDon hoaDon : dsHoaDonTheoThang) {
                hoaDon.xuatThongTin();
            }
        } else if (choice == 6) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập ngày, tháng và năm cần tìm: ");

            Date ngayCanTim = new Date();
            ngayCanTim.nhapDate(sc);

            ArrayList<HoaDon> dsHoaDonTheoNgay = dsHoaDon.timHoaDonTheoNgay(ngayCanTim);

            System.out.println("Danh sách hóa đơn theo ngày: ");
            for (HoaDon hoaDon : dsHoaDonTheoNgay) {
                hoaDon.xuatThongTin();
            }
        } else if (choice == 7) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập mã hóa đơn cần tìm: ");
            int maHoaDon = sc.nextInt();
            HoaDon hoaDon = dsHoaDon.timHoaDon(maHoaDon);

            if (hoaDon != null) {
                hoaDon.xuatThongTin();
            } else {
                System.out.println("Không tồn tại mã hóa đơn này!!!");
            }
        } else if (choice == 8) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập tháng và năm cần tính: ");

            short thang = sc.nextShort();
            short nam = sc.nextShort();

            System.out.println("Doanh thu theo tháng " + thang + "/" + nam + ": " + dsHoaDon.tinhDoanhThuTheoThang(thang, nam));
        } else if (choice == 9) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập ngày, tháng và năm cần tính: ");

            Date ngayCanTinh = new Date();
            ngayCanTinh.nhapDate(sc);

            System.out.println("Doanh thu theo " + ngayCanTinh + ": " + dsHoaDon.tinhDoanhThuTheoNgay(ngayCanTinh));
        } else if (choice == 10) {
            dsHoaDon.docFile();
        } else if (choice == 11) {
            dsHoaDon.ghiFile();
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
                }
                else {
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

        int choice = 0;
        do {
            menuChucNangChinh();
            try {
                System.out.print("Mời nhập lựa chọn: ");
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (choice == 1) {
                int nhanVienChoice;
                do {
                    menuChucNangNhanVien();
                    System.out.print("Mời nhập lựa chọn: ");
                    nhanVienChoice = sc.nextInt();
                    sc.nextLine();
                    luaChonChucNangNhanVien(choice);
                } while (nhanVienChoice != 0);
            } else if (choice == 2) {
                int banAnChoice;
                do {
                    menuChucNangBanAn();
                    System.out.print("Mời nhập lựa chọn: ");
                    banAnChoice = sc.nextInt();
                    sc.nextLine();
                } while (banAnChoice != 0);
            }  else if (choice == 3) {
                int datBanChoice;
                do {
                    menuChucNangDatBan();
                    System.out.print("Mời nhập lựa chọn: ");
                    datBanChoice = sc.nextInt();
                    sc.nextLine();
                } while (datBanChoice != 0);
            } else if (choice == 4) {
                int sanPhamChoice;
                do {
                    menuChucNangSanPham();
                    System.out.print("Mời nhập lựa chọn: ");
                    sanPhamChoice = sc.nextInt();
                    sc.nextLine();
                } while (sanPhamChoice != 0);
            } else if (choice == 5) {
                int hoaDonChoice;
                do {
                    menuChucNangHoaDon();
                    System.out.print("Mời nhập lựa chọn: ");
                    hoaDonChoice = sc.nextInt();
                    sc.nextLine();
                } while (hoaDonChoice != 0);
            } else if (choice == 6) {
                doiMatKhau();
            }
        } while(choice != 0);
    }
}
