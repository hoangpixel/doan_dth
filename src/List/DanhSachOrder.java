package List;
import java.util.Scanner;
import Constructors.Order;
public class DanhSachOrder {
    private Order[] od;
    public DanhSachOrder(){od=new Order[0];}
    public DanhSachOrder(Order[] od)
    {
        this.od=od;
    }
    public void nhapOrder()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng phiếu đặt : ");
        int n=sc.nextInt();
        od=new Order[n];
        for(int i=0;i<n;i++)
        {
            od[i]=new Order();
            od[i].nhapOrder();
        }
    }
    public void xuatOrder()
    {
        int n=od.length;
        for(int i=0;i<n;i++)
        {
            od[i].xuatOrder();
        }
    }
    public void xuatSanPham(DanhSachDienThoai[] dsdth)
    {
        for(DanhSachDienThoai dth : dsdth)
        {
            dth.xuatDS();
        }
    }
    public static void main(String[] args)
    {
        DanhSachOrder ds = new DanhSachOrder();
        ds.nhapOrder();
        ds.xuatOrder();
    }
}
