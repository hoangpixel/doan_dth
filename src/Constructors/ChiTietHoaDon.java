package Constructors;
import java.util.Scanner;

public class ChiTietHoaDon {
    private String mahd;
    private String madt;
    private int soluong;
    private float dongia;
    private float thanhtien;

    public ChiTietHoaDon(){
        this.mahd = null;
        this.madt = null;
        this.soluong = 0;
        this.dongia = 0;
        this.thanhtien = 0;
    }

    public ChiTietHoaDon(String mahd, String madt, int soluong, float dongia, float thanhtien) {
        this.mahd = mahd;
        this.madt = madt;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public ChiTietHoaDon(String mahd, String madt, int soluong, float dongia) {
        this.mahd = mahd;
        this.madt = madt;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = soluong*dongia;
    }

    public ChiTietHoaDon(ChiTietHoaDon a) {
        this.mahd = a.mahd;
        this.madt = a.madt;
        this.soluong = a.soluong;
        this.dongia = a.dongia;
        this.thanhtien = a.thanhtien;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMadt() {
        return madt;
    }

    public void setMadt(String madt) {
        this.madt = madt;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void nhapCTHD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin chi tiết hóa đơn");
        System.out.print("Mã hóa đơn: ");
        mahd = sc.nextLine();
        System.out.print("Mã điện thoại: ");
        madt = sc.nextLine();
        System.out.print("Số lượng: ");
        soluong = sc.nextInt();
        sc.nextLine();
        System.out.print("Đơn giá: ");
        dongia = sc.nextFloat();
        sc.nextLine();
        thanhtien = soluong * dongia;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "mahd=" + mahd + ", madt=" + madt + ", soluong=" + soluong + ", dongia=" + dongia + ", thanhtien=" + thanhtien + '}';
    }

    public void xuatCTHD(){
        System.out.println("Mã chi tiết hóa đơn: "+mahd+"\t Mã điện thoại: "+madt+"\t Số lượng: "+soluong+"\t Đơn giá: "+dongia+"\t Thành tiền: "+thanhtien);
    }


}
