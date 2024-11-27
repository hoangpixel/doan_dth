package TypeNCC;
import Interfaces.InterfaceNCC;
import Constructors.NhaCungCap;
public class NhaCungCapNoiDia extends NhaCungCap implements InterfaceNCC
{
    public NhaCungCapNoiDia() {
        super();
    }
    public NhaCungCapNoiDia(String maNCC, String tenNCC, String sdtNCC, String diachiNCC) {
        super(maNCC, tenNCC, sdtNCC, diachiNCC);
    }
    @Override
    public void nhap() {
        super.nhap();
    }
    @Override
    public void xuat() {
        super.xuat();
    }
}
