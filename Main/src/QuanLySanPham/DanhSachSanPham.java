package QuanLySanPham;

import Interface_XuLy.IThemSuaXoa;
import QuanLyNhanVien.NhanVien;

import java.util.*;
import java.io.*;

public class DanhSachSanPham implements IThemSuaXoa {
    private ArrayList<SanPham> dsSanPham;
    private final String URL = "C:\\Users\\Bao\\IdeaProjects\\Restaurant\\Main\\src\\Data\\ListSanPham";

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
    public void docFile() {

        try {
            dsSanPham.clear();
            File input = new File(URL);

            if (!input.exists()) {
                input.createNewFile();
            }

            Scanner sc = new Scanner(System.in);
            String[] data = new String[1001];
            int n = 0;

            while (sc.hasNextLine()) {
                data[n] = sc.nextLine();
                n++;
            }

            for (int i = 0; i < n; i++) {
                String[] dataThanhPhan = data[i].split(",");
                String tenSanPham = dataThanhPhan[1];
                double giaSanPham = Double.parseDouble(dataThanhPhan[2]);
                String loaiSanPham = dataThanhPhan[3];

                SanPham new_sanPham = null;
                if ("Mon_An".equalsIgnoreCase(loaiSanPham)) {
                    String viMonAn = dataThanhPhan[4];
                    new_sanPham = new MonAn(tenSanPham, giaSanPham, viMonAn);
                } else if ("Do_Uong".equalsIgnoreCase(loaiSanPham)) {
                    int dungTich = Integer.parseInt(dataThanhPhan[4]);
                    new_sanPham = new DoUong(tenSanPham, giaSanPham, dungTich);
                }
                dsSanPham.add(new_sanPham);
            }
            System.out.println("Đọc file thành công!!");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }


    // 7. Ghi file
    public void ghiFile(String fileName) {
        try {
            File output = new File(URL);

            if (!output.exists()) {
                output.createNewFile();
            }

            PrintWriter pw = new PrintWriter(output);

            for (SanPham sp : dsSanPham) {
                if (sp != null)
                    pw.println(sp);
            }

            System.out.println("File đã được cập nhật.");
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
