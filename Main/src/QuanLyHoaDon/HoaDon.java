package QuanLyHoaDon;

import  java.util.InputMismatchException;
import java.util.Scanner;

import DateTime.Date;
import DateTime.Time;
import Interface_XuLy.INhapXuat;
import QuanLyNhaHang.QuanLyNhaHang;
import QuanLySanPham.DanhSachSanPham;
import QuanLySanPham.SanPham;

public class HoaDon implements INhapXuat {
    private static int count = 0;
    private int maHoaDon;
    private int maBanAn;
    private ChiTietHoaDon chiTietHoaDon;
    private double tongTien;
    private boolean coVoucher;
    private int phieuGiamGia;
    private String tenNhanVienTao;
    private Time thoiGianTao;
    private Date ngayTao;

    public HoaDon() {
        maBanAn = 0;
        HoaDon.count++;
        maHoaDon = HoaDon.count;
        chiTietHoaDon = new ChiTietHoaDon();
        tongTien = 0.0;
        coVoucher = false;
        phieuGiamGia = 0;
        tenNhanVienTao = "";
        thoiGianTao = new Time();
        ngayTao = new Date();
    }

    public HoaDon(int maHoaDon, int maBanAn, ChiTietHoaDon chiTietHoaDon, double tongTien, boolean coVoucher, int phieuGiamGia, String tenNhanVienTao, Time thoiGianTao, Date ngayTao) {
        this.maHoaDon = maHoaDon;
        this.maBanAn = maBanAn;
        this.chiTietHoaDon = chiTietHoaDon;
        this.tongTien = tongTien;
        this.coVoucher = coVoucher;
        this.phieuGiamGia = phieuGiamGia;
        this.tenNhanVienTao = tenNhanVienTao;
        this.thoiGianTao = thoiGianTao;
        this.ngayTao = ngayTao;

        if (maHoaDon > HoaDon.count) {
            HoaDon.count = maHoaDon;
        }
    }

    // nhập thông tin hóa đơn
    public void nhapThongTin(Scanner sc) {

        while (true) {
            try {
                System.out.print("Nhập mã bàn ăn: ");
                maBanAn = sc.nextInt();
                sc.nextLine();

                if (maBanAn < 0) {
                    System.out.println("Mã bàn ăn phải là số dương!!!");
                } else {
                    break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            }
        }

        System.out.print("Nhập tên nhân viên tạo hóa đơn: ");
        tenNhanVienTao = sc.nextLine();

        while (true) {
            System.out.print("Có voucher hay không ? (1 = có /0 = không) ");
            int isTrue = sc.nextInt();

            try {
                if (isTrue == 1) {
                    coVoucher = true;
                    break;
                } else if (isTrue == 0) {
                    coVoucher = false;
                    break;
                } else {
                    System.out.println("Lỗi: Chỉ nhập 1 hoặc 0. Nhập lại");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            }
        }

        if (coVoucher) {
            while (true) {
                try {
                    System.out.print("Nhập giá trị của voucher (%): ");
                    phieuGiamGia = sc.nextInt();
                    sc.nextLine();

                    if (phieuGiamGia < 0) {
                        System.out.println("Phần trăm giảm giá phải là số dương!!!");
                    } else {
                        break;
                    }
                } catch (NumberFormatException | InputMismatchException e) {
                    System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                }
            }
        }

        System.out.println("Nhập chi tiết thông tin hóa đơn: ");

        while (true) {

            System.out.println("-----------------------");
            System.out.println("1. Món ăn.");
            System.out.println("2. Đồ uống.");
            System.out.println("0. Thoát.");
            System.out.print("Nhập lựa chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            DanhSachSanPham danhSachSanPham = QuanLyNhaHang.getDanhSachSanPham();

            if (choice == 1) {
                danhSachSanPham.hienThiDanhSachMonAn();
                System.out.println("-----------------------");

                int maSP;

                while (true) {
                    try {
                        System.out.print("Nhập mã món ăn muốn chọn: ");
                        maSP = sc.nextInt();
                        sc.nextLine();

                        if (maSP < 0) {
                            System.out.println("Mã món ăn phải là số dương!!!");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                    }
                }

                SanPham sp = danhSachSanPham.timSanPham(maSP);

                if (sp == null) {
                    System.out.println("Mã món ăn không tồn tại");
                } else {
                    if (sp.getLoaiSanPham().equalsIgnoreCase("MON_AN")) {
                        while (true) {
                            try {
                                System.out.print("Mời nhập số lượng món ăn: ");
                                int soLuong = sc.nextInt();
                                sc.nextLine();

                                if (soLuong < 0) {
                                    System.out.println("Số lượng món ăn phải là số dương!!!");
                                } else {
                                    chiTietHoaDon.nhapThongTin(sp, soLuong);
                                    break;
                                }
                            } catch (NumberFormatException | InputMismatchException e) {
                                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                            }
                        }
                    } else {
                        System.out.println("Không thể thêm vào do đây là đồ uống!!!");
                    }

                }
            } else if (choice == 2) {
                danhSachSanPham.hienThiDanhSachDoUong();
                System.out.println("-----------------------");
                int maSP;

                while (true) {
                    try {
                        System.out.print("Nhập mã đồ uống muốn chọn: ");
                        maSP = sc.nextInt();
                        sc.nextLine();

                        if (maSP < 0) {
                            System.out.println("Mã đồ uống phải là số dương!!!");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                    }
                }

                SanPham sp = danhSachSanPham.timSanPham(maSP);

                if (sp == null) {
                    System.out.println("Mã đồ uống không tồn tại!!!");
                }
                else {
                    if (sp.getLoaiSanPham().equalsIgnoreCase("DO_UONG")) {
                        while (true) {
                            try {
                                System.out.print("Mời nhập số lượng đồ uống: ");
                                int soLuong = sc.nextInt();
                                sc.nextLine();

                                if (soLuong < 0) {
                                    System.out.println("Số lượng món ăn phải là số dương!!!");
                                } else {
                                    chiTietHoaDon.nhapThongTin(sp, soLuong);
                                    break;
                                }
                            } catch (NumberFormatException | InputMismatchException e) {
                                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                            }
                        }
                    } else {
                        System.out.println("Không thể thêm vào do đây là món ăn!!!");
                    }
                }

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
            System.out.println("7. Phần trăm giảm giá");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.println("Lựa chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                while (true) {
                    try {
                        System.out.print("Mời nhập mã bàn ăn mới: ");
                        maBanAn = sc.nextInt();
                        sc.nextLine();

                        if (maBanAn < 0) {
                            System.out.println("Mã bàn ăn phải là số dương!!!");
                        } else {
                            setMaBanAn(maBanAn);
                            break;
                        }
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                    }
                }
            } else if (choice == 2) {
                System.out.print("Mời nhập tên mới của nhân viên tạo hóa đơn: ");
                tenNhanVienTao = sc.nextLine();
                setTenNhanVienTao(tenNhanVienTao);
            } else if (choice == 3) {

                while (true) {
                    System.out.print("Mời nhập tình trạng voucher (1 = có / 0 = không): ");
                    int isTrue = sc.nextInt();

                    try {
                        if (isTrue == 1) {
                            setCoVoucher(true);

                            if (coVoucher) {
                                while (true) {
                                    try {
                                        System.out.print("Nhập giá trị của voucher (%): ");
                                        phieuGiamGia = sc.nextInt();
                                        sc.nextLine();

                                        if (phieuGiamGia < 0) {
                                            System.out.println("Phần trăm giảm giá phải là số dương!!!");
                                        } else {
                                            break;
                                        }
                                    } catch (NumberFormatException | InputMismatchException e) {
                                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                                    }
                                }
                            }

                            break;
                        } else if (isTrue == 0) {
                            setCoVoucher(false);
                            setPhieuGiamGia(0);
                            break;
                        } else {
                            System.out.println("Lỗi: Chỉ nhập 1 hoặc 0. Nhập lại");
                        }
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                    }
                }
            } else if (choice == 4) {
                System.out.println("Mời nhập thời gian tạo hóa đơn mới: ");
                thoiGianTao = new Time();
                thoiGianTao.nhapTime(sc);
                setThoiGianTao(thoiGianTao);
            } else if (choice == 5) {
                System.out.println("Mời nhập ngày tạo hóa đơn mới: ");
                ngayTao = new Date();
                ngayTao.nhapDate(sc);
                setNgayTao(ngayTao);
            } else if (choice == 6) {
                System.out.println("1. Sửa tên.");
                System.out.println("2. Sửa số lượng.");
                System.out.print("Mời nhập lựa chọn: ");
                int select = sc.nextInt();

                if (select == 1) {
                    System.out.print("Mời nhập tên sản phẩm cần sửa: ");
                    String tenCu = sc.nextLine();

                    System.out.print("Mời nhập tên mới: ");
                    String tenMoi = sc.nextLine();

                    chiTietHoaDon.suaTenSanPham(tenCu, tenMoi);

                } else if (select == 2) {
                    System.out.print("Mời nhập tên sản phẩm cần sửa số lượng: ");
                    String tenSP = sc.nextLine();

                    while (true) {
                        try {
                            System.out.print("Mời nhập số lượng mới: ");
                            int soLuong = sc.nextInt();
                            sc.nextLine();

                            if (soLuong > 0) {
                                chiTietHoaDon.suaSoLuongSanPham(tenSP, soLuong);
                                break;
                            } else {
                                System.out.println("Số lượng phải là số dương!!!");
                            }
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                            sc.nextLine();
                        }
                    }
                }
            } else if (choice == 7) {
                if (coVoucher) {
                    while (true) {
                        try {
                            System.out.print("Nhập giá trị mới của voucher (%): ");
                            phieuGiamGia = sc.nextInt();
                            sc.nextLine();

                            if (phieuGiamGia < 0) {
                                System.out.println("Phần trăm giảm giá phải là số dương!!!");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException | InputMismatchException e) {
                            System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                        }
                    }
                } else {
                    System.out.println("Không có voucher nên không thể thay đổi mã giảm giá!!!");
                }
            }
        } while (choice != 0);
    }

    public double capNhatTongTien() {
        tongTien = chiTietHoaDon.tinhThanhTien();

        if (coVoucher) {
            return tongTien * ((1.0 * 100 - phieuGiamGia) / 100);
        }

        return tongTien;
    }

    @Override
    public String toString() {
        return maHoaDon + "," + maBanAn + "," + tenNhanVienTao + "," + coVoucher + "," + phieuGiamGia + "," + tongTien + "," + ngayTao.toString() + "," + thoiGianTao.toString() + "," + chiTietHoaDon.toString();
    }

    public int getMaHoaDon() {
        return maHoaDon;
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

    public void setCoVoucher(boolean coVoucher) {
        this.coVoucher = coVoucher;
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