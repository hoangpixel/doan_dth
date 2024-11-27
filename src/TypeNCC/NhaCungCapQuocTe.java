package TypeNCC;
import Constructors.NhaCungCap;
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
        super.xuat();  // Gọi phương thức xuat() của lớp cha
        System.out.println("Quốc gia: " + this.quocGia);
    }

}
