package QuanLyNgayCong;

import java.time.LocalDate;

public class BangChamCong {
    private short thang, nam;
    private int soNgayDiLamThucTe = 0;

    public BangChamCong() {
        thang = 0;
        nam = 0;
        soNgayDiLamThucTe = 0;
    }

    public BangChamCong(short thang, short nam) {

        if (thang < 1 || thang > 12) {
            throw new IllegalArgumentException("Tháng phải nằm trong khoảng 1 đến 12");
        }

        int namHienTai = LocalDate.now().getYear();
        if (nam < 2020 || nam > namHienTai + 1) {
            throw new IllegalArgumentException("Năm không hợp lệ. Phải lớn hơn 2020 và không quá xa tương lai.");
        }

        this.thang = thang;
        this.nam = nam;
        soNgayDiLamThucTe = 0;
    }

    public int getSoNgayDiLamThucTe() {
        return soNgayDiLamThucTe;
    }

    public short getThang() {
        return thang;
    }

    public short getNam() {
        return nam;
    }

    public void chamCong() {
        this.soNgayDiLamThucTe++;
    }
}
