package QuanLyMonAn;

public class MonChinh extends MonAn{
    public String loaiMon;

    public MonChinh(){}
    public MonChinh(String tenMon,double gia,String loaiMon){
        super(tenMon,gia,loaiMon);
    }

    @Override
    public void nhapThongTin() {super.nhapThongTin();}
    public void xuatThongTin() {super.xuatThongTin();}
    public String moTa(){
        return "Món chính thường được sử dụng vào giữa buổi tiệc sau khi đã kết thúc lễ khai mạc của buổi tiệc !";
    }


}
