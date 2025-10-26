package QuanLyHoaDon;

import QuanLyMonAn.MonAn;

public class ChiTietHoaDon {
    private MonAn monAn;
    private int soLuong;

    public ChiTietHoaDon(MonAn monAn, int soLuong) {
        this.monAn = monAn;
        this.soLuong = soLuong;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tinhThanhTien(){
        return monAn.getGia() * soLuong;
    }

}

