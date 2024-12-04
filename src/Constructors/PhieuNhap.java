package Constructors;
import List.DanhSachCTPN;

import java.util.Scanner;

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
    public void nhapPhieu(String[] danhSachMaNCC,String[] danhSachMaNV)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mã phiếu nhập : ");
        this.maPN=sc.nextLine();
        while (true) {
            System.out.print("Nhập ngày nhập hàng (yyyy/mm/dd) : ");
            this.ngayNhap = sc.nextLine();
            if (this.ngayNhap.matches("\\d{4}/\\d{2}/\\d{2}")) {
                break;
            } else {
                System.out.println("Vui lòng nhập ngày theo định dạng yyyy/mm/dd.");
            }
        }
        while (true) {
            System.out.println("Danh sách mã nhà cung cấp:");
            for (int i = 0; i < danhSachMaNCC.length; i++) {
                System.out.println((i + 1) + ". " + danhSachMaNCC[i]);
            }

            System.out.print("Vui lòng chọn số tương ứng với mã nhà cung cấp: ");
            String choiceStr = sc.nextLine();  // Đọc toàn bộ dòng nhập vào

            // Kiểm tra xem đầu vào có phải là số không và nó có nằm trong phạm vi của danh sách không
            try {
                int choice = Integer.parseInt(choiceStr);  // Chuyển đổi đầu vào thành số
                if (choice >= 1 && choice <= danhSachMaNCC.length) {
                    this.maNCC = danhSachMaNCC[choice - 1];
                    break;
                } else {
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ!");
            }
        }
        while (true) {
            System.out.println("Danh sách mã nhân viên:");
            for (int i = 0; i < danhSachMaNV.length; i++) {
                System.out.println((i + 1) + ". " + danhSachMaNV[i]);
            }

            System.out.print("Vui lòng chọn số tương ứng với mã nhân viên: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ nhớ đệm

            if (choice >= 1 && choice <= danhSachMaNV.length) {
                this.maNV = danhSachMaNV[choice - 1];
                break;
            } else {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
        this.tinhTong();
        System.out.println("----------------------------------");
    }
    public void tinhTong()
    {

        tongTien=0;
        ChiTietPhieuNhap[] ctpn = DanhSachCTPN.getDsctpn();
        for(int i = 0; i< ctpn.length; i++)
        {
            if(ctpn[i].getMaPN().equals(this.maPN))
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


        String format = "| %-15s | %-20s | %-15s | %-15s | %-15s |\n";
        System.out.format("+-----------------+----------------------+-----------------+----------------------+-----------------+\n");
        System.out.format(format, "Mã phiếu nhập", "Ngày nhập", "Mã NCC", "Mã NV", "Tổng tiền");
        System.out.format("+-----------------+----------------------+-----------------+----------------------+-----------------+\n");
        System.out.format(format, maPN, ngayNhap, maNCC, maNV, tongTien);
        System.out.format("+-----------------+----------------------+-----------------+----------------------+-----------------+\n");
    }


}