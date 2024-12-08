package Constructors;
import java.util.Scanner;
import java.text.DecimalFormat;
public class NhanVien {
    private String manv;
    private String honv;
    private String tennv;
    private float luong;
    private String chucvu;
    private String sdtnv;
    private String socancuoc;
    private String diachinv;
    public NhanVien(){}
    public NhanVien(String manv, String honv, String tennv, float luong, String chucvu, String sdtnv, String socancuoc, String diachinv){
        this.manv=manv;
        this.honv=honv;
        this.tennv=tennv;
        this.luong=luong;
        this.chucvu=chucvu;
        this.sdtnv=sdtnv;
        this.socancuoc=socancuoc;
        this.diachinv=diachinv;
    }
    public NhanVien(NhanVien nhanviena){
        manv=nhanviena.manv;
        honv=nhanviena.honv;
        tennv=nhanviena.tennv;
        luong=nhanviena.luong;
        chucvu=nhanviena.chucvu;
        sdtnv=nhanviena.sdtnv;
        socancuoc=nhanviena.socancuoc;
        diachinv=nhanviena.diachinv;
    }
    public void nhap(){
        Scanner nhap=new Scanner(System.in);
        System.out.println("\nHãy Nhập Thông Tin Nhân Viên: ");
        System.out.print("Mã Nhân Viên: ");
        manv=nhap.nextLine();
        System.out.print("Họ Nhân Viên: ");
        honv=nhap.nextLine();
        System.out.print("Tên Nhân Viên: ");
        tennv=nhap.nextLine();
        System.out.print("Lương: ");
        luong=nhap.nextFloat();
        nhap.nextLine();
        System.out.print("Chức Vụ: ");
        chucvu=nhap.nextLine();
        System.out.print("Số Điện Thoại: ");
        sdtnv=nhap.nextLine();
        System.out.print("Số Căn Cước: ");
        socancuoc=nhap.nextLine();
        System.out.print("Địa chỉ: ");
        diachinv=nhap.nextLine();
        System.out.println("---");
    }
    public void xuat(){
        String format = "| %-15s | %-20s | %-15s | %-30s | %-15s | %-20s | %-15s | %-30s |\n";
        DecimalFormat df = new DecimalFormat("#,###.0");
        System.out.format("+-----------------+----------------------+-----------------+--------------------------------+-----------------+----------------------+-----------------+--------------------------------+\n");
        System.out.format(format, "Mã nhân viên", "Họ nhân viên", "Tên nhân viên", "Lương", "Chức vụ", "Số điện thoại", "Số căn cước", "Địa chỉ");
        System.out.format("+-----------------+----------------------+-----------------+--------------------------------+-----------------+\n");
        System.out.format(format, manv, honv, tennv, df.format(luong), chucvu, sdtnv, socancuoc, diachinv);
        System.out.format("+-----------------+----------------------+-----------------+--------------------------------+-----------------+----------------------+-----------------+--------------------------------+\n");
    }
    public String getMaNv(){
        return manv;
    }
    public String getHoNv(){
        return honv;
    }
    public String getTenNv(){
        return tennv;
    }
    public float getLuong(){
        return luong;
    }
    public String getChucVu(){
        return chucvu;
    }
    public String getSdtNv(){
        return sdtnv;
    }
    public String getSoCanCuoc(){
        return socancuoc;
    }
    public String getDiaChiNv(){
        return diachinv;
    }
    public void setMaNv(String manv){
        this.manv=manv;
    }
    public void setHoNv(String honv){
        this.honv=honv;
    }
    public void setTenNv(String tennv){
        this.tennv=tennv;
    }
    public void setLuong(float luong){
        this.luong=luong;
    }
    public void setChucVu(String chucvu){
        this.chucvu=chucvu;
    }
    public void setSdtNv(String sdtnv){
        this.sdtnv=sdtnv;
    }
    public void setSoCanCuoc(String socancuoc){
        this.socancuoc=socancuoc;
    }
    public void setDiaChiNv(String diachinv){
        this.diachinv=diachinv;
    }
}
