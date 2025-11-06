package QuanLyNhanVien;

import DateTime.Date;
import Interface_XuLy.IThemSuaXoa;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DanhSachNhanVien implements IThemSuaXoa {
    private ArrayList<NhanVien> dsNhanVien;
    final String URL_NhanVien = "C:\\Users\\Bao\\IdeaProjects\\Restaurant\\Main\\src\\Data\\ListNhanVien";

    public DanhSachNhanVien() {
        dsNhanVien = new ArrayList<>();
    }

    public DanhSachNhanVien(ArrayList<NhanVien> dsNhanVien) {
        this.dsNhanVien = dsNhanVien;
    }

    public ArrayList<NhanVien> getDsNhanVien() {
        return dsNhanVien;
    }

    public void menuLoaiNhanVien() {
        System.out.println("____________LOẠI NHÂN VIÊN____________");
        System.out.println("1. Đầu bếp");
        System.out.println("2. Quản lý");
        System.out.println("3. Lao công");
        System.out.println("4. Tiếp tân");
        System.out.println("5. Phục vụ");
        System.out.println("0. Thoát");
    }

    // 1. Thêm nhân viên mới
    @Override
    public void themThongTin() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            menuLoaiNhanVien();
            System.out.print("Chọn loại nhân viên muốn thêm (1-5): ");
            choice = sc.nextInt();
            sc.nextLine();
            NhanVien nvMoi;
            if (choice == 1) {
                nvMoi = new DauBep();
                nvMoi.nhapThongTin(sc);
                dsNhanVien.add(nvMoi);
                System.out.println("Thêm đầu bếp thành công!!!");
            } else if (choice == 2) {
                nvMoi = new QuanLy();
                nvMoi.nhapThongTin(sc);
                dsNhanVien.add(nvMoi);
                System.out.println("Thêm quản lý thành công!!!");
            } else if (choice == 3) {
                nvMoi = new LaoCong();
                nvMoi.nhapThongTin(sc);
                dsNhanVien.add(nvMoi);
                System.out.println("Thêm lao công thành công!!!");
            } else if (choice == 4) {
                nvMoi = new TiepTan();
                nvMoi.nhapThongTin(sc);
                dsNhanVien.add(nvMoi);
                System.out.println("Thêm tiếp tân thành công!!!");
            } else if (choice == 5) {
                nvMoi = new PhucVu();
                nvMoi.nhapThongTin(sc);
                dsNhanVien.add(nvMoi);
                System.out.println("Thêm phục vụ thành công!!!");
            }
        } while (choice != 0);
    }

    // 2. Hàm tìm nhân viên theo mã số
    public NhanVien timNhanVienTheoMa(int maNhanVien) {
        for (NhanVien nhanVien : dsNhanVien) {
            if (nhanVien.getMaNhanVien() == maNhanVien) {
                return nhanVien;
            }
        }
        return null;
    }

    // 3. Hàm xóa thông tin của nhân viên
    @Override
    public void xoaThongTin(int maNhanVien) {
        NhanVien nv = timNhanVienTheoMa(maNhanVien);

        if (nv != null) {
            dsNhanVien.remove(nv);
            System.out.printf("Nhân viên có mã số %d đã được xóa\n", maNhanVien);
        } else {
            System.out.println("Không tồn tại mã nhân viên này.");
        }
    }

    // 4. Hàm sửa thông tin của nhân viên
    @Override
    public void suaThongTin(int maNhanVien) {

        try {
            NhanVien nv = timNhanVienTheoMa(maNhanVien);
            if (nv != null) {
                nv.menuThuocTinh();
            } else {
                System.out.println("Không tồn tại mã nhân viên này.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 5. Hàm hiển thị danh sách nhân viên
    public void hienThiDanhSachNhanVien() {
        int i = 1;
        for (NhanVien nhanVien : dsNhanVien) {
            if (nhanVien != null) {
                System.out.println("______________THÔNG TIN NHÂN VIÊN THỨ " + i + "_______________");
                nhanVien.xuatThongTin();
                i++;
            }
        }
    }

    // 6. Hàm xuất bảng lương nhân viên
    public void xuatBangLuongNhanVien() {
        DecimalFormat df = new DecimalFormat("#.00");
        int i = 1;
        for (NhanVien nhanVien : dsNhanVien) {
            System.out.print(i + "/ ");
            double salary = nhanVien.tinhLuongThucTe();
            String formatSalary = df.format(salary);
            System.out.println("Mã nhân viên: " + nhanVien.getMaNhanVien() + "| Tên: " + nhanVien.getTenNhanVien() +
                    "| Chức vụ: " + nhanVien.getChucVu() + "| Lương: " + formatSalary);
            i++;
        }
    }

    // 7. Hàm in số lượng nhân viên
    public void inSoLuongNhanVienTheoChucVu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("6. Xem tất cả.");
            System.out.println("______________________________________");
            menuLoaiNhanVien();
            System.out.print("Chọn loại nhân viên cần xem số lượng (1 - 5) hoặc xem tất cả (6): ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Số lượng đầu bếp: " + DauBep.getSoLuongDauBep());
            } else if (choice == 2) {
                System.out.println("Số lượng quản lý: " + QuanLy.getSoLuongQuanLy());
            } else if (choice == 3) {
                System.out.println("Số lượng lao công: " + LaoCong.getSoLuongLaoCong());
            } else if (choice == 4) {
                System.out.println("Số lượng tiếp tân: " + TiepTan.getSoLuongTiepTan());
            } else if (choice == 5) {
                System.out.println("Số lượng phục vụ: " + PhucVu.getSoLuongPhucVu());
            } else if (choice == 6) {
                System.out.println("Số lượng đầu bếp: " + DauBep.getSoLuongDauBep());
                System.out.println("Số lượng quản lý: " + QuanLy.getSoLuongQuanLy());
                System.out.println("Số lượng lao công: " + LaoCong.getSoLuongLaoCong());
                System.out.println("Số lượng tiếp tân: " + TiepTan.getSoLuongTiepTan());
                System.out.println("Số lượng phục vụ: " + PhucVu.getSoLuongPhucVu());
            }
        } while (choice != 0);
    }

    // 8. Hàm đọc file
    public void docFile() {
        try {
            dsNhanVien.clear();
            File input = new File(URL_NhanVien);

            if (!input.exists()) {
                input.createNewFile();
            }

            Scanner sc = new Scanner(input);
            String[] data = new String[1001];
            int n = 0;

            while (sc.hasNextLine()) {
                data[n] = sc.nextLine();
                n++;
            }

            for (int i = 0; i < n; i++) {
                String[] dataThanhPhan = data[i].split(",");

                int maNhanVien = Integer.parseInt(dataThanhPhan[0]);
                String tenNhanVien = dataThanhPhan[1];

                String[] sinhNhat = dataThanhPhan[2].split("/");
                short ngay = Short.parseShort(sinhNhat[0]);
                short thang = Short.parseShort(sinhNhat[1]);
                short nam = Short.parseShort(sinhNhat[2]);

                Date ngaySinh = new Date(ngay, thang, nam);
                String gioiTinh = dataThanhPhan[3];
                String chucVu = dataThanhPhan[4];

                NhanVien nvMoi;
                if (chucVu.equals("QL")) {
                    nvMoi = new QuanLy(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
                } else if (chucVu.equals("DB")) {
                    nvMoi = new DauBep(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
                } else if (chucVu.equals("LC")) {
                    nvMoi = new LaoCong(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
                } else if (chucVu.equals("PV")) {
                    nvMoi = new PhucVu(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
                } else if (chucVu.equals("TT")) {
                    nvMoi = new TiepTan(maNhanVien, tenNhanVien, ngaySinh, gioiTinh);
                } else {
                    nvMoi = null;
                }
                dsNhanVien.add(nvMoi);
            }
            System.out.println("Đọc file thành công!!!");
        } catch (Exception e) {
            System.out.println("Đọc file thất bại. Vui lòng xem lại hàm đọc file!!!");
        }
    }

    // 9. Hàm ghi file
    public void ghiFile() {
        try {
            File output = new File(URL_NhanVien);

            if (!output.exists()) {
                output.createNewFile();
            }

            PrintWriter pw = new PrintWriter(output);

            for (NhanVien nv : dsNhanVien) {
                if (nv != null)
                    pw.println(nv.toString());
            }

            System.out.println("File đã được cập nhật.");
            pw.close();
        } catch (IOException e) {
            System.out.println("Ghi file thất bại. Vui lòng kiểm tra lại hàm ghi file!!!");
        }
    }
}
