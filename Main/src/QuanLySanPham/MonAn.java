package QuanLySanPham;

import Interface_XuLy.INhapXuat;

import java.util.Scanner;

public class MonAn extends SanPham implements INhapXuat {
    private String loaiMonAn;

    public MonAn() {
        super();
        loaiMonAn = "";
    }

    public MonAn(String ten, double gia, String loaiMonAn) {
        super(ten, gia);
        this.loaiMonAn = loaiMonAn;
    }

    public String getLoaiMon() {
        return loaiMonAn;
    }

    public void setLoaiMon(String loaiMonAn) {
        this.loaiMonAn = loaiMonAn;
    }

    //1.them mon moi
    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.println("Nhập loại món:");
        loaiMonAn = sc.nextLine();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println(loaiMonAn);
    }

    @Override
    public void menuThuocTinh() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("-------Bảng thuộc tính--------");
            System.out.println("1. Tên món ăn.");
            System.out.println("2. Giá món ăn.");
            System.out.println("3. Loại món ăn.");
            System.out.println("0. Thoát");
            System.out.println("------------------------------");
            System.out.print("Lựa chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Nhập tên mới của món ăn: ");
                String tenSP = sc.nextLine();
                setTenSanPham(tenSP);
            } else if (choice == 2) {
                System.out.print("Nhập giá mới của món ăn: ");
                double giaSP = sc.nextDouble();
                setGiaSanPham(giaSP);
            } else if (choice == 3) {
                System.out.print("Nhập loại món ăn mới: ");
                String loaiMonAn = sc.nextLine();
                setLoaiMon(loaiMonAn);
            }
        } while (choice != 0);
    }

    public void moTaChiTiet() {
        System.out.println("Đây là một món ăn thuộc loại: " + this.loaiMonAn);
    }
}
