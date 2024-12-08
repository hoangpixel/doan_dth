package Constructors;
import List.DanhSachChiTietHoaDon;
import List.DanhSachDienThoai;

import java.text.DecimalFormat;
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
        DienThoai[] dsdt = DanhSachDienThoai.getDsdt();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin chi tiết hóa đơn");
        System.out.print("Mã hóa đơn: ");
        mahd = sc.nextLine();
        System.out.print("Mã điện thoại: ");
        madt = sc.nextLine();
        boolean quan = true;
        do {
            System.out.print("Số lượng: ");
            soluong = sc.nextInt();
            sc.nextLine();
            for(DienThoai a :dsdt){
                if(a.getMaDT().equals(this.madt) && a.getSoluong()<this.soluong){
                    System.out.println("Số lượng điện thoại còn trong kho không đủ, chỉ còn "+a.getSoluong()+" chiếc, vui lòng nhập số lượng khác ");
                    quan = false;
                }
            }
        } while(!quan);
        System.out.print("Đơn giá: ");
        dongia = sc.nextFloat();
        sc.nextLine();
        thanhtien = soluong * dongia;
        for(DienThoai a :dsdt){
            if(a.getMaDT().equals(this.madt)){
                a.setSoluong(a.getSoluong() - this.soluong);
            }
        }
    }




    public void xuatCTHD() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        // Cập nhật định dạng cho bảng
        String format = "| %-15s | %-15s | %-10s | %-15s | %-20s |\n";
        System.out.format("+-----------------+-----------------+------------+-----------------+----------------------+\n");
        // In thông tin chi tiết hoá đơn
        System.out.format(format, mahd, madt, soluong, df.format(dongia), df.format(thanhtien));
        System.out.format("+-----------------+-----------------+------------+-----------------+----------------------+\n");
    }


}
