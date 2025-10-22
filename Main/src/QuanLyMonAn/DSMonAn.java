package QuanLyMonAn;

import java.util.*;
import java.io.*;


public class DSMonAn implements IThemSuaXoa {
    private ArrayList<MonAn> dsMonAn;
    Scanner sc=new Scanner(System.in);
    public DSMonAn(){
        dsMonAn=new ArrayList<>();
    }

    //1.them Mon An(nhap mon an)
    public void themThongTin(){
        System.out.println("Nhập loại món muốn thêm :\n1.Món chính\n2.Món tráng miệng\nMời bạn nhập lựa chọn");
        int tmp=sc.nextInt();sc.nextLine();
        MonAn ma;
        switch(tmp){
            case 1:
                ma = new MonChinh();
                break;
            case 2:
                ma = new TrangMieng();
                break;
            default:
                System.out.println("Lựa chọn không phù hợp !!!");
                return;
        }
        ma.nhapThongTin();
        dsMonAn.add(ma);
        System.out.println("Đã thêm món ăn mới thành công !!!");
    }
    //2.xoa Mon An
    public void xoaThongTin(int maMon) {
        boolean found = false;

        for (int i = 0; i < dsMonAn.size(); i++) {
            if (dsMonAn.get(i).getMaMon() == maMon) {
                dsMonAn.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            // Cập nhật lại mã món sau khi xóa
            for (int i = 0; i < dsMonAn.size(); i++) {
                dsMonAn.get(i).setMaMon(i + 1);
            }

            // Cập nhật lại bộ đếm trong lớp MonAn
            MonAn.count_maMon = dsMonAn.size();

            System.out.println("Đã xóa món ăn thành công và cập nhật lại mã!");
        } else {
            System.out.println("Không tìm thấy món ăn để xóa!");
        }
    }

    //3.tim kiem Mon An
    public MonAn timMonAn(int maMon) {
        for (MonAn Ma : dsMonAn) {
            if (Ma.getMaMon() == maMon) {
                return Ma;
            }
        }
        return null;
    }
    //4.hien thi dsMonAn
    public void hienthiMonAn(){
        System.out.println("Hiển thị danh sách tất cả món ăn :");
        for(MonAn Ma:dsMonAn){
            Ma.xuatThongTin();
        }
        System.out.println("Hiển thị danh sách món ăn thành công !!!");
    }
    //5.sua Thong tin mon an
    public void suaThongTin(int maMon){
        for(MonAn Ma:dsMonAn){
            if(Ma.getMaMon() == maMon){
                System.out.println("Nhập lựa chọn bạn muốn chỉnh sửa :\n1.Sửa tên món ăn\n2.Sửa giá món ăn\n3.Sửa loại món ăn\nMời bạn nhập lựa chọn ");
                int temp=sc.nextInt();sc.nextLine();
                switch (temp){
                    case 1:
                        System.out.println("Nhập tên mới cho món này :");
                        Ma.setTenMon(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập giá mới cho món này :");
                        Ma.setGia(sc.nextInt());
                        sc.nextLine();
                        break;
                    case 3:
                        System.out.println("Nhập loại mới cho món này :");
                        Ma.setLoaiMon(sc.nextLine());
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ !!!");
                        return;
                }
                System.out.println("Cập nhật thành công !!!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã món để chỉnh sửa !!!");
    }
    //6.doc File
    public void docFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename), "UTF-8")) {
            dsMonAn.clear();
            int maxMa = 0;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    int ma = Integer.parseInt(parts[0].trim());
                    String ten = parts[1].trim();
                    double gia = Double.parseDouble(parts[2].trim());
                    String loai = parts[3].trim();

                    MonAn maMonAn = null;
                    if (loai.equalsIgnoreCase("MonChinh") || loai.equalsIgnoreCase("món chính")) {
                        maMonAn = new MonChinh();
                    } else if (loai.equalsIgnoreCase("TrangMieng") || loai.equalsIgnoreCase("tráng miệng")) {
                        maMonAn = new TrangMieng();
                    }

                    if (maMonAn != null) {
                        maMonAn.setMaMon(ma);
                        maMonAn.setTenMon(ten);
                        maMonAn.setGia(gia);
                        maMonAn.setLoaiMon(loai);
                        dsMonAn.add(maMonAn);
                        if (ma > maxMa) maxMa = ma;
                    }
                }
            }
            MonAn.count_maMon = maxMa;
            System.out.println("Đọc file thành công !");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    //7.ghi File
    public void ghiFile(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (MonAn ma : dsMonAn) {
                // Ghi ra từng dòng dạng CSV
                pw.println(
                        ma.getMaMon() + ";" +
                        ma.getTenMon() + ";" +
                        ma.getGia() + ";" +ma.getClass().getSimpleName());
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}
