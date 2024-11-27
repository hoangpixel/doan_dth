package Constructors;
import java.util.Scanner;
public class Order
{
    private static int d=1;
    private String maDat;
    private String tenKH;
    private String sdtKH;
    private String maSP;
    private String tenSP;
    private int soluongDat;
    private float tongTienDat;
    public Order(){}
    public Order(String maDat,String tenKH,String sdtKH,String maSP,String tenSP,float tongTienDat,int soluongDat)
    {
        this.maDat = "MD" + d++;
        this.tenKH=tenKH;
        this.sdtKH=sdtKH;
        this.maSP=maSP;
        this.tenSP=tenSP;
        this.soluongDat=soluongDat;
        this.tongTienDat=tongTienDat;
    }
    public void Order(Order copy)
    {
        maDat=copy.maDat;
        tenKH= copy.sdtKH;
        sdtKH=copy.sdtKH;
        maSP=copy.maSP;
        tenSP=copy.tenSP;
        soluongDat=copy.soluongDat;
        tongTienDat=copy.tongTienDat;
    }

    public float getTongTienDat() {
        return tongTienDat;
    }

    public int getSoluongDat() {
        return soluongDat;
    }

    public String getMaDat() {
        return maDat;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getTenSP() {
        return tenSP;
    }


    public void setMaDat(String maDat) {
        this.maDat = maDat;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public void setSoluongDat(int soluongDat) {
        this.soluongDat = soluongDat;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setTongTienDat(float tongTienDat) {
        this.tongTienDat = tongTienDat;
    }


    public void nhapOrder()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số điện thoại : ");
        this.sdtKH=sc.nextLine();
        System.out.print("Nhập mã sản phẩm : ");
        this.maSP=sc.nextLine();
        System.out.print("Nhập tên sản phẩm : ");
        this.tenSP=sc.nextLine();
        System.out.print("Nhập số lượng đặt : ");
        this.soluongDat=sc.nextInt();
    }
    public void tongTien(DienThoai[] dsdth)
    {
        for(DienThoai dt : dsdth)
        {
            if(dt.getMaDT().equals(this.maSP))
            {
                if(dt.getSoluong() >= this.soluongDat)
                {
                    this.tongTienDat=this.soluongDat * dt.getDongia();
                    dt.setSoluong(dt.getSoluong() - this.soluongDat);
                }
                else
                {
                    System.out.println("Không đủ số lượng tồn trong kho !!!");
                    this.tongTienDat=0;
                }
                return;
            }
        }
        System.out.println("Không tìm thấy mã sản phẩm : " + this.maSP);
        this.tongTienDat=0;
    }
    public void layTenKH(KhachHang[] dskh)
    {
        for(KhachHang kh : dskh)
        {
            if(kh.getSdt().equals(this.sdtKH))
            {
                this.setTenKH(kh.getTenkh());
                return;
            }
        }
    }
    public void xuatOrder()
    {
        System.out.println("Tên : " + this.tenKH + "\nSố điện thoại : " +this.sdtKH + "\nMã sản phẩm : " + this.maSP + "\nTên sản phẩm : " + this.tenSP + "\nSố lượng đặt : " + this.soluongDat + "\nTổng tiền : " + this.tongTienDat);
    }
}
