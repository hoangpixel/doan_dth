package Constructors;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;
import List.DanhSachChiTietHoaDon;
import java.text.DecimalFormat;
public class HoaDon {
    private String mahd;
    private String ngaylaphd;
    private String manv;
    private String makh;
    private float tongtien;
    public void nhap(String[] danhsachmanv, String[] danhsachmakh){
        Scanner nhap=new Scanner(System.in);
        System.out.println("\nHãy Nhập Thông Tin Hoá Đơn: ");
        System.out.print("Nhập mã hoá đơn: ");
        mahd=nhap.nextLine();
        while (true) {
            System.out.print("Nhập ngày nhập hoá đơn (yyyy-mm-dd): ");
            ngaylaphd = nhap.nextLine();
            if (ngaylaphd.matches("\\d{4}-\\d{2}-\\d{2}")) {
                break;
            } else {
                System.out.println("Vui lòng nhập đúng cấu trúc (yyyy-mm-dd)");
            }
        }
        System.out.println("Danh sách mã nhân viên:");
        int choice;
        for(int i=0; i<danhsachmanv.length; i=i+1)
        System.out.println("Mã nhân viên thứ "+(i+1)+": "+danhsachmanv[i]);
        do{
        System.out.print("Nhập số thứ tự của nhân viên lập hoá đơn: ");
        choice=nhap.nextInt();
        if(choice<1||choice>danhsachmanv.length)
        System.out.println("Vui lòng nhập đúng cấu trúc");
        }while(choice<1||choice>danhsachmanv.length);
        manv=danhsachmanv[choice-1];
        System.out.println("Danh sách mã khách hàng:");
        for(int i=0; i<danhsachmakh.length; i=i+1)
        System.out.println("Mã khách hàng thứ "+(i+1)+": "+danhsachmakh[i]);
        do{
        System.out.print("Nhập số thứ tự của khách hàng cần lập hoá đơn: ");
        choice=nhap.nextInt();
        if(choice<1||choice>danhsachmakh.length)
        System.out.println("Vui lòng nhập đúng cấu trúc");
        }while(choice<1||choice>danhsachmakh.length);
        makh=danhsachmakh[choice-1];
        tinhTong();
        System.out.println("---");
    }
    
public void tinhTong()
    {

        tongtien=0;
        ChiTietHoaDon[] temp = DanhSachChiTietHoaDon.getDscthd();
        for(int i = 0; i<temp.length; i=i+1)
        {
            if(mahd.equals(temp[i].getMahd()))
            {
                tongtien+=temp[i].getThanhtien();
            }
        }
        setTongTien(tongtien);
    }
    
    public void xuat(){
        DecimalFormat df = new DecimalFormat("#,###.00");
        String format = "| %-15s | %-20s | %-15s | %-30s | %-15s |\n";
        DecimalFormat df = new DecimalFormat("#,###.0");
        System.out.format("+-----------------+----------------------+-----------------+--------------------------------+-----------------+\n");
        System.out.format(format, "Mã hoá đơn", "Ngày lập hoá đơn", "Mã nhân viên", "Mã khách hàng", "Tổng tiền");
        System.out.format("+-----------------+----------------------+-----------------+--------------------------------+-----------------+\n");
        System.out.format(format, mahd, ngaylaphd, manv, makh, df.format(tongtien));
        System.out.format("+-----------------+----------------------+-----------------+--------------------------------+-----------------+\n");
    }
    public int getYear(){
        Date date=Date.valueOf(ngaylaphd);
        LocalDate localDate=date.toLocalDate();
        return localDate.getYear();
    }
    public int getMonth(){
        Date date=Date.valueOf(ngaylaphd);
        LocalDate localDate=date.toLocalDate();
        return localDate.getMonthValue();
    }
    public int getDay(){
        Date date=Date.valueOf(ngaylaphd);
        LocalDate localDate=date.toLocalDate();
        return localDate.getDayOfMonth();
    }
    public HoaDon(){}
    public HoaDon(String mahd, String ngaylaphd, String manv, String makh, float tongtien){
        this.mahd=mahd;
        this.ngaylaphd=ngaylaphd;
        this.manv=manv;
        this.makh=makh;
        this.tongtien=tongtien;
    }
    public HoaDon(HoaDon hoadona){
        mahd=hoadona.mahd;
        ngaylaphd=hoadona.ngaylaphd;
        manv=hoadona.manv;
        makh=hoadona.makh;
        tongtien=hoadona.tongtien;
    }
    public HoaDon(String mahd){
        this.mahd=mahd;
    }
    public String getMaHd(){
        return mahd;
    }
    public String getNgayLapHd(){
        return ngaylaphd;
    }
    public String getMaNv(){
        return manv;
    }
    public String getMaKh(){
        return makh;
    }
    public float getTongTien(){
        return tongtien;
    }
    public void setMaHd(String mahd){
        this.mahd=mahd;
    }
    public void setNgayLapHd(String ngaylaphd){
        this.ngaylaphd=ngaylaphd;
    }
    public void setMaNv(String manv){
        this.manv=manv;
    }
    public void setMaKh(String makh){
        this.makh=makh;
    }
    public void setTongTien(float tongtien){
        this.tongtien=tongtien;
    }
}
