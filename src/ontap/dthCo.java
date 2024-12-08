package ontap;
import java.util.Scanner;
public class dthCo extends DienThoai
{
    public String loaiPhim;
    Scanner sc=new Scanner(System.in);
    public dthCo()
    {
        super();

    }
    public dthCo(String maDT,String tenDT,String hang,float dongia,int soluong,String loaiPhim)
    {
        super(maDT,tenDT,hang,dongia,soluong);
        this.loaiPhim=loaiPhim;
    }

    @Override
    public String getLoaiPhim() {
        return loaiPhim;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.printf("Nhap loai phim : ");
        this.loaiPhim=sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("loai phim : " + this.loaiPhim);
    }
}
