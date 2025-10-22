package QuanLySanPham;

import Interface_XuLy.IThemSuaXoa;
import QuanLyNhanVien.NhanVien;

import java.util.*;
import java.io.*;

public class DanhSachSanPham implements IThemSuaXoa {
    private ArrayList<SanPham> dsSanPham;

    public DanhSachSanPham() {
        dsSanPham = new ArrayList<>();
    }

    public DanhSachSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public void menuLoaiSanPham() {
        System.out.println("____________LOẠI SẢN PHẨM____________");
        System.out.println("1. Món ăn");
        System.out.println("2. Đồ uống");
        System.out.println("0. Thoát");
        System.out.println("______________________________________");
    }

    @Override
    public void themThongTin() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            menuLoaiSanPham();
            System.out.println("Chọn loại sản phẩm muốn thêm (1-2): ");
            choice = sc.nextInt();

            SanPham sanPham = null;
            if (choice == 1) {
                sanPham = new MonAn();
                sanPham.nhapThongTin(sc);
                dsSanPham.add(sanPham);
                System.out.println("Thêm món ăn thành công!!!");
            } else if (choice == 2) {
                sanPham = new DoUong();
                sanPham.nhapThongTin(sc);
                dsSanPham.add(sanPham);
                System.out.println("Thêm đồ uống thành công!!!");
            }
        } while(choice != 0);
    }

    //2.xoa Mon An
    public void xoaThongTin(int ma) {
        SanPham sp = timSanPham(ma);
        if (sp != null) {
            for (SanPham sanPham : dsSanPham) {
                dsSanPham.remove(sanPham);
                System.out.println("Xóa sản phẩm với mã: " + ma + " thành công!!!");
                return;
            }
        }
        else {
            System.out.println("Không tìm thấy mã sản phẩm này!!!");
        }
    }

    //3.tim kiem Mon An
    public SanPham timSanPham(int ma) {
        for (SanPham sp : dsSanPham) {
            if (sp.getMaSanPham() == ma) {
                return sp;
            }
        }
        return null;
    }

    //4.hien thi dsMonAn
    public void hienthiSanPham() {
        System.out.println("Hiển thị danh sách sản phẩm:");
        for (SanPham sp : dsSanPham) {
            sp.xuatThongTin();
        }
        System.out.println("Hiển thị danh sách sản phẩm thành công !!!");
    }

    //5.sua Thong tin mon an
    public void suaThongTin(int maSanPham) {
        try (Scanner sc = new Scanner(System.in)) {
            SanPham sp = timSanPham(maSanPham);
            if (sp != null) {
                sp.menuThuocTinh();
            } else {
                System.out.println("Không tồn tại sản phẩm này.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 6. Đọc file
    public void docFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            dsSanPham.clear();
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] p = line.split(";");
                int ma = Integer.parseInt(p[0]);
                String ten = p[1];
                double gia = Double.parseDouble(p[2]);
                String loai = p[3];

                SanPham sp = loai.equalsIgnoreCase("MonAn") ? new MonAn() : new DoUong();
                sp.setMaSanPham(ma);
                sp.setTenSanPham(ten);
                sp.setGiaSanPham(gia);
                dsSanPham.add(sp);
            }
            System.out.println("Đọc file thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }


    // 7. Ghi file
    public void ghiFile(String fileName) {
        if (dsSanPham.isEmpty()) {
            System.out.println("️Danh sách rỗng, không thể ghi file!");
            return;
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (SanPham sp : dsSanPham) {
                pw.println(sp.getMaSanPham() + ";" +
                        sp.getTenSanPham() + ";" +
                        sp.getGiaSanPham() + ";" +
                        sp.getClass().getSimpleName());
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

}
