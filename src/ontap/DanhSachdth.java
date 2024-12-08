package ontap;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachdth {
    public static DienThoai[] dsdth;
    Scanner sc=new Scanner(System.in);
    public DanhSachdth()
    {
        dsdth=new DienThoai[0];
    }
    public DanhSachdth(DienThoai[] dsdth)
    {
        this.dsdth=dsdth;
    }
    public boolean trungMa(String maDT)
    {
        for(int i=0;i<dsdth.length;i++)
        {
            if(dsdth[i] != null && (dsdth[i].getMaDT().equals(maDT)))
            {
                return true;
            }
        }
        return false;
    }

    public void nhap()
    {
        System.out.printf("Nhap so luong dth : ");
        int n=sc.nextInt();
        sc.nextLine();
        dsdth=new DienThoai[n];
        for(int i=0;i<n;i++)
        {
            DienThoai dth=new DienThoai();
            dth.nhap();
            while(trungMa(dth.getMaDT()))
            {
                System.out.println("ma dht da bi trung");
                System.out.printf("Nhap ma moi : ");
                String maMoi=sc.nextLine();
                dth.setMaDT(maMoi);
            }
            dsdth[i]=dth;
        }
    }

    public void nhapK()
    {
        int n=dsdth.length,k;
        do {
            System.out.printf("Nhap so luong : ");
            k=sc.nextInt();
            sc.nextLine();
            if(k<=0)
            {
                System.out.println("loi");
            }
        }while(k<=0);

        dsdth= Arrays.copyOf(dsdth,n + k);
        int choice;
        for(int i=0;i<k;i++)
        {
            System.out.println("1. dth thong minh");
            System.out.println("2. dth co");
            System.out.printf("lua chon : ");
            choice=sc.nextInt();
            sc.nextLine();
            DienThoai dth;
            if(choice == 1)
            {
                dth=new dthThongMinh();
            }
            else if(choice == 2)
            {
                dth=new dthCo();
            }
            else
            {
                dth = new dthThongMinh();
            }

            dth.nhap();
            while(trungMa(dth.getMaDT()))
            {
                System.out.println("ma da bi trung");
                System.out.printf("Nhap ma moi : ");
                String maMoi=sc.nextLine();
                dth.setMaDT(maMoi);
            }
            dsdth[i+n] = dth;
        }
    }
    public void xuat() {
        String format = "|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s| \n";
        System.out.format("+---------------+---------------+---------------+---------------+---------------+---------------+\n");
        System.out.format(format,"ma dth","ten dth","hang","don gia","so luong","dac diem");
        System.out.format("+---------------+---------------+---------------+---------------+---------------+---------------+ \n");

        for (int i = 0; i < dsdth.length; i++) {
            String chatnang;
            if (dsdth[i] instanceof dthThongMinh) {
                chatnang = ((dthThongMinh) dsdth[i]).getDungluong();
            } else if (dsdth[i] instanceof dthCo) {
                chatnang = ((dthCo) dsdth[i]).getLoaiPhim();
            } else {
                chatnang = "N/A";  // Phòng trường hợp phần tử không phải là loại điện thoại nào
            }

            System.out.format(format,
                    dsdth[i].getMaDT(),
                    dsdth[i].getTenDT(),
                    dsdth[i].getHang(),
                    dsdth[i].getDongia(),
                    dsdth[i].getSoluong(),
                    chatnang);
        }
        System.out.format("+---------------+---------------+---------------+---------------+---------------+---------------+ \n");
        System.out.println();
    }

    public static void main(String[] args)
    {
        DanhSachdth ds=new DanhSachdth();
        ds.nhapK();
        ds.xuat();
    }
}
