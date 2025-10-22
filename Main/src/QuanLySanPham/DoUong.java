package QuanLySanPham;

import Interface_XuLy.INhapXuat;

import java.util.Scanner;

public class DoUong extends SanPham implements INhapXuat {
    private int dungTich;

    DoUong() {
        super();
        dungTich = 0;
    }

    public DoUong(String tenSanPham, double giaSanPham, int dungTich) {
        super(tenSanPham, giaSanPham);
        this.dungTich = dungTich;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.println("Nhập dung tích: ");
        dungTich = sc.nextInt();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("| Dung tích của đồ uống là: " + dungTich);
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
                String tenSP = sc.nextLine();
                setTenSanPham(tenSP);
            } else if (choice == 2) {
                System.out.print("Nhập giá mới của đồ uống: ");
                double giaSP = sc.nextDouble();
                setGiaSanPham(giaSP);
            } else if (choice == 3) {
                System.out.print("Nhập dung tích mới của đồ uống: ");
                int dungTich = sc.nextInt();
                setDungTich(dungTich);
            }
        } while (choice != 0);
    }

    public void moTaChiTiet() {
        System.out.println("Đây là một đồ uống có dung tích: " + this.dungTich + "ml");
    }
}
