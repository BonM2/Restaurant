package QuanLySanPham;

import Interface_XuLy.INhapXuat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DoUong extends SanPham implements INhapXuat {
    private int dungTich;

    public DoUong() {
        super();
        dungTich = 0;
    }

    public DoUong(String ten, double gia, int dungTich) {
        super(ten, gia);
        this.loaiSanPham = "DO_UONG";
        this.dungTich = dungTich;
    }

    public DoUong(int ma, String ten, double gia, int dungTich) {
        super(ma, ten, gia);
        this.loaiSanPham = "DO_UONG";
        this.dungTich = dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        this.loaiSanPham = "DO_UONG";

        while (true) {
            try {
                System.out.print("Nhập dung tích (ml): ");
                dungTich = sc.nextInt();
                sc.nextLine();

                if (dungTich < 0) {
                    System.out.println("Dung tích phải là số dương!!!");
                } else {
                    break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
            }
        }
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("| Dung tích của đồ uống là (ml): " + dungTich);
    }

    @Override
    public void menuThuocTinh() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Tên đồ uống.");
            System.out.println("2. Giá đồ uống.");
            System.out.println("3. Dung tích đồ uống.");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.print("Lựa chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Nhập tên mới của đồ uống: ");
                tenSanPham = sc.nextLine();
                setTenSanPham(tenSanPham);
            } else if (choice == 2) {
                while(true) {
                    try {
                        System.out.print("Nhập giá mới của đồ uống: ");
                        giaSanPham = sc.nextDouble();
                        sc.nextLine();

                        if (giaSanPham < 0) {
                            System.out.println("Giá sản phẩm phải là số dương!!!");
                        } else {
                            setGiaSanPham(giaSanPham);
                            break;
                        }
                    } catch (NumberFormatException | InputMismatchException e) {
                        System.out.println("Lỗi: Nhập sai kiểu dữ liệu. Vui lòng nhập lại!");
                        sc.nextLine();
                    }
                }
            } else if (choice == 3) {
                while (true) {
                    try {
                        System.out.print("Nhập dung tích (ml): ");
                        dungTich = sc.nextInt();
                        sc.nextLine();

                        if (dungTich < 0) {
                            System.out.println("Dung tích phải là số dương!!!");
                        } else {
                            setDungTich(dungTich);
                            break;
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
        return maSanPham + "," + tenSanPham + "," + giaSanPham + "," + loaiSanPham + "," + dungTich;
    }

    public int getDungTich() {
        return dungTich;
    }
}