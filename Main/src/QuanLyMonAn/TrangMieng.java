package QuanLyMonAn;

public class TrangMieng extends MonAn{
    public String loaiMon;
    public TrangMieng(){}
    public TrangMieng(String tenMon,double gia,String loaiMon){
        super(tenMon,gia,loaiMon);
    }
    public void nhapThongTin() {super.nhapThongTin();}
    public void xuatThongTin() {super.xuatThongTin();}
    public String moTa(){
        return "Món tráng miệng là các món được sử dụng ở cuối buổi tiệc !";
    }
}
