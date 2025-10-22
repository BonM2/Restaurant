package QuanLyMonAn;

import java.sql.SQLOutput;
import java.util.Scanner;

public abstract class MonAn implements INhapXuat {
    protected int maMon = 0;
    protected String tenMon;
    protected double gia;
    protected String loaiMon;
    protected static int count_maMon=0;

    Scanner sc=new Scanner(System.in);
    public MonAn(){}
    public MonAn(String tenMon,double gia,String loaiMon){
        count_maMon++;
        this.tenMon=tenMon;
        this.gia=gia;
        this.loaiMon=loaiMon;

    }

    public static int getCount_maMon() {
        return count_maMon;
    }

    public static void setCount_maMon(int count_maMon) {
        MonAn.count_maMon = count_maMon;
    }

    public  int getMaMon() {return maMon;}

    public  void setMaMon(int maMon) {this.maMon = maMon;}

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getLoaiMon(){return loaiMon;}

    public void setLoaiMon(String loaiMon) {this.loaiMon = loaiMon;}

    //1.them mon moi
    public void nhapThongTin(){
        System.out.println("-------Nhap mon an moi-------");maMon = ++count_maMon;
        System.out.println("Nhap ten : ");tenMon=sc.nextLine();
        System.out.println("Nhap gia : ");gia=sc.nextDouble();sc.nextLine();
        System.out.println("Nhap loai mon : ");loaiMon= sc.nextLine();

    }

    public void xuatThongTin(){
        System.out.println("Mã: "+maMon+",Tên Món: "+tenMon+",Giá tiền: "+gia+",Loại món: "+loaiMon);
    }


    public abstract String moTa();

}
