package Constructors;
import List.DanhSachCTPN;
import java.util.Scanner;
import List.DanhSachNCC;
import List.DanhSachNhanVien;
import java.text.DecimalFormat;
public class PhieuNhap
{
    private String maPN;
    private String ngayNhap;
    private String maNCC;
    private String maNV;
    private float tongTien=0;
    private ChiTietPhieuNhap[] ctpn;

    public PhieuNhap(){}
    public PhieuNhap(String maPN,String ngayNhap,String maNCC,String maNV,float tongTien)
    {
        this.maPN=maPN;
        this.ngayNhap=ngayNhap;
        this.maNCC=maNCC;
        this.maNV=maNV;
        this.tongTien=tongTien;
    }
    public PhieuNhap(PhieuNhap copy)
    {
        maPN=copy.maPN;
        ngayNhap=copy.ngayNhap;
        maNCC= copy.maNCC;
        maNV= copy.maNV;
        tongTien= copy.tongTien;
    }
    public void nhapPhieu()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.print("Nhập mã phiếu : ");
            this.maPN=sc.nextLine();
            if(this.maPN.matches("PN\\d{2}"))
            {
                break;
            }
            else
            {
                System.out.println("Vui lòng nhập mã phiếu theo dạng (PN..) !!!");
            }
        }
        while(true)
        {
            System.out.print("Nhập ngày nhập phiếu : ");
            this.ngayNhap=sc.nextLine();
            if(this.ngayNhap.matches("\\d{4}/\\d{2}/\\d{2}"))
            {
                break;
            }else
            {
                System.out.println("Vui lòng nhập theo (yyyy/mm/dd)");
            }
        }
        DanhSachNCC dsncc = new DanhSachNCC();
        dsncc.docFile();
        dsncc.xuat();
        System.out.print("Nhập mã nhà cung cấp : ");
        this.maNCC=sc.nextLine();
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        dsnv.docTuFile();
        dsnv.xuatdsnv();
        System.out.print("Nhập mã nhân viên : ");
        this.maNV=sc.nextLine();
        this.tinhTong();
    }
    public void tinhTong()
    {

        tongTien=0;
        ChiTietPhieuNhap[] ctpn = DanhSachCTPN.getDsctpn();
        for(int i = 0; i< ctpn.length; i++)
        {
            if(this.maPN.equals(ctpn[i].getMaPN()))
            {
                tongTien+=ctpn[i].getThanhtien();
            }
        }
        this.setTongTien(tongTien);
    }

    public String getMaPN()
    {
        return maPN;
    }
    public String getNgayNhap()
    {
        return ngayNhap;
    }
    public String getMaNCC()
    {
        return maNCC;
    }
    public String getMaNV()
    {
        return maNV;
    }
    public float getTongTien() {
        return tongTien;
    }
    public void setMaPN(String maPN)
    {
        this.maPN=maPN;
    }
    public void setNgayNhap(String ngayNhap)
    {
        this.ngayNhap=ngayNhap;
    }
    public void setMaNCC(String maNCC)
    {
        this.maNCC=maNCC;
    }
    public void setMaNV(String maNV)
    {
        this.maNV=maNV;
    }
    public float setTongTien(float tongTien)
    {
        this.tongTien=tongTien;
        return tongTien;
    }
    public void xuatPhieuNhap() {

        DecimalFormat df = new DecimalFormat("#,###");
        String format = "| %-15s | %-20s | %-15s | %-15s | %-15s |\n";
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.format(format, "Mã phiếu nhập", "Ngày nhập", "Mã NCC", "Mã NV", "Tổng tiền");
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.format(format, maPN, ngayNhap, maNCC, maNV, df.format(tongTien));
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
    }


}