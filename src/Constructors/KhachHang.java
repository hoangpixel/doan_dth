/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Constructors;
import java.util.Scanner;
/**
 *
 * @author winan
 */
public class KhachHang {
    private String makh;
    private String tenkh;
    private String sdt;
    private float tongtien;
    
    public KhachHang(){
        
    }
    public KhachHang(String makh){
        this.makh = makh;
    }

    public KhachHang(KhachHang a) {
        this.makh = a.makh;
        this.tenkh = a.tenkh;
        this.sdt = a.sdt;
        this.tongtien = a.tongtien;
    }
    
    public KhachHang(String makh, String tenkh, String sdt, float tongtien) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.tongtien = tongtien;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    
    public void nhapKH(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Ten | SDT | Tong Tien");
        tenkh = sc.nextLine();
        sdt = sc.nextLine();
        tongtien = sc.nextFloat();
    }
    
   @Override
    public String toString() {
        return "KhachHang{" + "makh=" + makh + ", tenkh=" + tenkh + ", sdt=" + sdt + ", tongtien=" + tongtien + '}';
    }
//    public void xuat(){
//        System.out.println("Mã khách hàng: "+makh+"\t Tên khách hàng: "+ tenkh + " \t SDT: "+sdt+" \t Tổng tiền: "+tongtien+"VNĐ");
//    }

    public void xuat(){
        String format = "| %-15s | %-30s | %-15s | %-20s |\n";  // Cập nhật độ rộng cột "Tổng tiền"
        System.out.format("+-----------------+------------------------------+-----------------+------------------------+\n");
        System.out.format(format, makh, tenkh, sdt, tongtien);
        System.out.format("+-----------------+------------------------------+-----------------+------------------------+\n");

    }

}
