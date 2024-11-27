package Constructors;
import java.util.Scanner;
import TypeNCC.NhaCungCapQuocTe;
import Interfaces.InterfaceNCC;
public class NhaCungCap implements InterfaceNCC {
    protected String maNCC;
    protected String tenNCC;
    protected String sdtNCC;
    protected String diachiNCC;

    public NhaCungCap() {}

    public NhaCungCap(String maNCC, String tenNCC, String sdtNCC, String diachiNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdtNCC = sdtNCC;
        this.diachiNCC = diachiNCC;
    }

    // Các phương thức getter và setter
    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSdtNCC() {
        return sdtNCC;
    }

    public void setSdtNCC(String sdtNCC) {
        this.sdtNCC = sdtNCC;
    }

    public String getDiachiNCC() {
        return diachiNCC;
    }

    public void setDiachiNCC(String diachiNCC) {
        this.diachiNCC = diachiNCC;
    }

    // Phương thức nhập
    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp: ");
        maNCC = sc.nextLine();
        System.out.print("Nhập tên nhà cung cấp: ");
        tenNCC = sc.nextLine();
        System.out.print("Nhập số điện thoại nhà cung cấp: ");
        sdtNCC = sc.nextLine();
        System.out.print("Nhập địa chỉ nhà cung cấp: ");
        diachiNCC = sc.nextLine();
    }

    // Phương thức xuất
    @Override
    public void xuat()
    {
        String format = "| %-15s | %-20s | %-15s | %-30s |\n";
        System.out.format("+-----------------+----------------------+-----------------+--------------------------------+\n");
        System.out.format(format, "Mã NCC", "Tên NCC", "SĐT", "Địa chỉ");
        System.out.format("+-----------------+----------------------+-----------------+--------------------------------+\n");
        System.out.format(format, maNCC, tenNCC, sdtNCC, diachiNCC);
        if (this instanceof NhaCungCapQuocTe) {
            NhaCungCapQuocTe nccQt = (NhaCungCapQuocTe) this;
            System.out.format("+-----------------+----------------------+-----------------+--------------------------------+\n");
            System.out.format("| %-69s |\n", "Quốc gia: " + nccQt.getQuocGia());
        }
        System.out.format("+-----------------+----------------------+-----------------+--------------------------------+\n");
    }

}
