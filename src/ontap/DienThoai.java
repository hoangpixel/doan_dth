package ontap;
import java.util.Scanner;
public class DienThoai
{
    public String maDT;
    public String tenDT;
    public String hang;
    public float dongia;
    public int soluong;
    public String dungluong;
    public String loaiPhim;
    public DienThoai(String maDT, String tenDT, String hang, float dongia, int soluong){}
    public DienThoai(String maDT,String tenDT,String hang,float dongia,int soluong,String dungluong,String loaiPhim)
    {
        this.maDT=maDT;
        this.tenDT=tenDT;
        this.hang=hang;
        this.dongia=dongia;
        this.soluong=soluong;
        this.dungluong=dungluong;
        this.loaiPhim=loaiPhim;
    }

    public DienThoai() {

    }

    public float getDongia() {
        return dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getDungluong() {
        return dungluong;
    }

    public String getHang() {
        return hang;
    }

    public String getMaDT() {
        return maDT;
    }

    public String getLoaiPhim() {
        return loaiPhim;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setDungluong(String dungluong) {
        this.dungluong = dungluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public void setLoaiPhim(String loaiPhim) {
        this.loaiPhim = loaiPhim;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }
    public void nhap()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("nhap ma : ");
        this.maDT=sc.nextLine();
        System.out.print("nhap ten : ");
        this.tenDT=sc.nextLine();
        System.out.print("nhap hang : ");
        this.hang=sc.nextLine();
        System.out.print("nhap don gia : ");
        this.dongia=sc.nextFloat();
        sc.nextLine();
        System.out.print("nhap so luong : ");
        this.soluong=sc.nextInt();
        sc.nextLine();
    }
    public void xuat()
    {
        String format = "|%-15s|%-15s|%-15s|%-15s|%-15s| \n";
        System.out.format("+---------------+---------------+---------------+---------------+---------------+ \n");
        System.out.format(format,"ma dth","ten dth","hang","don gia","so luong");
        System.out.format("+---------------+---------------+---------------+---------------+---------------+ \n");
        System.out.format(format,this.maDT,this.tenDT,this.hang,this.dongia,this.soluong);
        System.out.format("+---------------+---------------+---------------+---------------+---------------+ \n");
    }
}