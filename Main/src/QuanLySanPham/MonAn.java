package QuanLySanPham;

import Interface_XuLy.INhapXuat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MonAn extends SanPham implements INhapXuat {
    private String viMonAn;

    public MonAn() {
        super();
        viMonAn = "";
    }

    public MonAn(String ten, double gia, String viMonAn) {
        super(ten, gia);
        this.loaiSanPham = "MON_AN";
        this.viMonAn = viMonAn;
    }

    public MonAn(int maSanPham, String ten, double gia, String viMonAn) {
        super(maSanPham, ten, gia);
        this.loaiSanPham = "MON_AN";
        this.viMonAn = viMonAn;
    }

    public void setViMon(String loaiMonAn) {
        this.viMonAn = loaiMonAn;
    }

    //1.them mon moi
    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        loaiSanPham = "MON_AN";
        System.out.print("Nhập vị món: ");
        viMonAn = sc.nextLine();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("| Vị món ăn: " + viMonAn);
    }

    @Override
    public void menuThuocTinh() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Tên món ăn.");
            System.out.println("2. Giá món ăn.");
            System.out.println("3. Vị món ăn.");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.print("Lựa chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Nhập tên mới của món ăn: ");
                tenSanPham = sc.nextLine();
                setTenSanPham(tenSanPham);
            } else if (choice == 2) {
                while(true) {
                    try {
                        System.out.print("Nhập giá mới của món ăn: ");
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
                System.out.print("Nhập loại món ăn mới: ");
                viMonAn = sc.nextLine();
                setViMon(viMonAn);
            }
        } while (choice != 0);
    }

    @Override
    public String toString() {
        return maSanPham + "," + tenSanPham + "," + giaSanPham + "," + loaiSanPham + "," + viMonAn;
    }

    public String getViMonAn() {
        return viMonAn;
    }
}