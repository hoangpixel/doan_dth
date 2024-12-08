package ontap;
import java.util.Scanner;
public class dthThongMinh extends DienThoai
{
    public String dungluong;
    Scanner sc=new Scanner(System.in);
    public dthThongMinh(){
        super();
    }
    public dthThongMinh(String maDT,String tenDT,String hang,float dongia,int soluong,String dungluong)
    {
        super(maDT,tenDT,hang,dongia,soluong);
        this.dungluong=dungluong;
    }

    @Override
    public String getDungluong() {
        return dungluong;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.printf("Nhập dung lượng điện thoại : ");
        this.dungluong=sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Dung luong : " + this.dungluong);
    }
}
