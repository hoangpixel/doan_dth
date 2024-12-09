package Constructors;
import java.util.Scanner;
public class NhaCungCapQuocTe extends NhaCungCap
{
    private String quocGia;
    public NhaCungCapQuocTe() {
        super();
    }
    public NhaCungCapQuocTe(String maNCC, String tenNCC, String sdtNCC, String diachiNCC, String quocGia) {
        super(maNCC, tenNCC, sdtNCC, diachiNCC);
        this.quocGia = quocGia;
    }
    public String getQuocGia() {
        return quocGia;
    }
    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Quốc gia: " + this.quocGia);
    }
    @Override
    public void nhap()
    {
        Scanner sc=new Scanner(System.in);
        super.nhap();
        System.out.print("Nhập quốc gia : ");
        this.quocGia=sc.nextLine();
    }

}
