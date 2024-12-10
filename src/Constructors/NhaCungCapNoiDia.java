package Constructors;
import java.util.Scanner;
public class NhaCungCapNoiDia extends NhaCungCap
{
    String quocgia = "Nội địa";
    public NhaCungCapNoiDia(){super();}
    public NhaCungCapNoiDia(String maNCC,String tenNCC,String sdtNCC,String diachiNCC,String quocgia)
    {
        super(maNCC, tenNCC, sdtNCC, diachiNCC);
        this.quocgia=quocgia;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }
}