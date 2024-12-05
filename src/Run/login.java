package Run;
import Constructors.NhanVien;
import List.DanhSachNhanVien;
import java.util.Scanner;
public class login {
    public static void main(String[] args)
    {
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        dsnv.docTuFile();
        Scanner sc = new Scanner(System.in);
        NhanVien[] nv=DanhSachNhanVien.getDsnv();
        boolean dn=false;
        String taikhoan,matkhau;
        do {
            System.out.print("Nhập tài khoản : ");
            taikhoan=sc.nextLine().trim();
            System.out.print("Nhập mật khẩu : ");
            matkhau=sc.nextLine().trim();
            for(int i=0;i<nv.length;i++)
            {
                if((taikhoan.equals(nv[i].getMaNv())) && matkhau.equals("admin123"))
                {
                    main.main();
                    dn=true;
                    break;
                }
            }
            if(!dn)
            {
                System.out.println("Tài khoản hoặc mật khẩu của bạn đã sai vui lòng nhập lại !!!");
            }
        }while(!dn);
    }
}
