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
        int d=0;
        do {
            System.out.println();
            System.out.print("Nhập tài khoản : ");
            taikhoan=sc.nextLine().trim();
            System.out.print("Nhập mật khẩu : ");
            matkhau=sc.nextLine().trim();
            for(int i=0;i<nv.length;i++)
            {
                if((taikhoan.equals(nv[i].getMaNv())) && matkhau.equals("admin123"))
                {
                    main.run(nv[i]);
                    dn=true;
                    break;
                }
            }
            if(!dn)
            {
                System.out.println();
                System.out.println("Tài khoản hoặc mật khẩu của bạn đã sai !!!");
                System.out.println("Bạn đã nhập sai " + (d+1) + " nếu sai 4 lần sẽ bị khóa tài khoản !!!");
                d++;
            }
            if(d==4)
            {
                System.out.println("Tài khoản của bạn đã bị khóa !!!");
                break;
            }
        }while(!dn);
    }
}
