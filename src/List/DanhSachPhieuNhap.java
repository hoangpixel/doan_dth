package List;
import java.util.Scanner;
import java.util.Arrays;
import Constructors.PhieuNhap;
import Constructors.NhaCungCap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Interfaces.InterfaceDocGhi;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
public class DanhSachPhieuNhap implements InterfaceDocGhi
{
    private static PhieuNhap[] dspn;
    public DanhSachPhieuNhap()
    {
        dspn=new PhieuNhap[0];
    }
    public DanhSachPhieuNhap(PhieuNhap dspn[])
    {
        this.dspn=dspn;
    }

    public  static PhieuNhap[] getDspn() {
        return dspn;
    }

    public boolean trungMa(String maPN)
    {
        for(int i=0;i<dspn.length;i++)
        {
            if(dspn[i] != null && (dspn[i].getMaPN().equals(maPN)))
            {
                return true;
            }
        }
        return false;
    }

    public void nhapPhieu()
    {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Nhập số lượng phiếu nhập : ");
        n=sc.nextInt();
        sc.nextLine();
        dspn = new PhieuNhap[n];
        for(int i=0;i<n;i++)
        {
            PhieuNhap pn = new PhieuNhap();
            pn.nhapPhieu();
            while(trungMa(pn.getMaPN()))
            {
                System.out.println("Mã phiếu đã bị trùng vui lòng nhập lại !!!");
                System.out.print("Nhập mã phiếu mới : ");
                String newMa=sc.nextLine();
                pn.setMaPN(newMa);
            }
            dspn[i]=pn;
        }
    }

    public void themK()
    {
        Scanner sc=new Scanner(System.in);
        int n=dspn.length,k;
        do {
            System.out.print("Nhập số lượng phiếu nhập : ");
            k=sc.nextInt();
            sc.nextLine();
            if(k<=0)
            {
                System.out.println("Vui lòng nhập số nguyên dương !!!");
            }
        }while(k<=0);
        dspn = Arrays.copyOf(dspn,n+k);
        for(int i=0;i<k;i++)
        {
            PhieuNhap pn = new PhieuNhap();
            pn.nhapPhieu();
            while(trungMa(pn.getMaPN()))
            {
                System.out.println("Mã phiếu đã bị trùng vui lòng nhập lại !!!");
                System.out.print("Nhập lại mã phiếu mới : ");
                String newMa=sc.nextLine();
                pn.setMaPN(newMa);
            }
            dspn[n+i]=pn;
        }
    }
    public void xoaPhanTu()
    {
        Scanner sc=new Scanner(System.in);
        int n=dspn.length;
        int index=-1;
        System.out.print("Nhập mã phiếu nhập muốn xóa : ");
        String maXoa=sc.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dspn[i].getMaPN().equals(maXoa))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            for(int i=index;i<n-1;i++)
            {
                dspn[i]=dspn[i+1];
            }
            dspn=Arrays.copyOf(dspn,n-1);
        }
        else
        {
            System.out.println("Không tìm thấy phiếu nhập cần xóa !!!");
        }
    }
    public void timMaPhieu()
    {
        Scanner sc=new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");
        int n=dspn.length;
        String maTim;
        System.out.print("Vui lòng nhập mã cần tìm : ");
        maTim=sc.nextLine();
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(dspn[i].getMaPN().equals(maTim))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            if(dspn[index] != null)
            {
                String format = "| %-15s | %-20s | %-15s | %-15s | %-15s |\n";
                System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
                System.out.format(format, "Mã phiếu nhập", "Ngày nhập", "Mã NCC", "Mã NV", "Tổng tiền");
                System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
                System.out.format(format, dspn[index].getMaPN(), dspn[index].getNgayNhap(), dspn[index].getMaNCC(), dspn[index].getMaNV(), df.format(dspn[index].getTongTien()));
                System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
                System.out.println();
            }
            else
            {
                System.out.println("Không có dữ liệu từ mã cần tìm");
            }
        }
        else
        {
            System.out.println("Không thể tìm thấy mã : " + maTim + " trong danh sách !!!");
        }
    }
    
    public static PhieuNhap timMaPhieu(String maPN) {
    	for(int i = 0; i < dspn.length; i++) {
    		if(maPN.equals(dspn[i].getMaPN())) {
    			return dspn[i];
    		}
    	}
    	return null;
    }
    
    public void thongKeTien()
    {
        DecimalFormat df = new DecimalFormat("#,###");
        int s=0;
        for(int i=0;i<dspn.length;i++)
        {
            s+=dspn[i].getTongTien();
        }
        System.out.print("\n");
        System.out.println("Tổng số tiền của tất cả các phếu nhập : " + df.format(s));
        System.out.print("\n");
    }
    public void suaPhieuNhap()
    {
        Scanner sc=new Scanner(System.in);
        int n=dspn.length;
        int index=-1;
        String timMa;
        System.out.print("Nhập mã phiếu cần sửa đổi : ");
        timMa=sc.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dspn[i].getMaPN().equals(timMa))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            int choice;
            do
            {
                System.out.println("---------------Menu---------------");
                System.out.println("1. Sửa đổi mã nhà cung cấp");
                System.out.println("2. Sửa đổi ngày nhập hàng");
                System.out.println("3. Sửa đổi mã nhân viên");
                System.out.println("0. Thoát");
                System.out.println("----------------------------------");
                System.out.print("Vui lòng nhập lựa chọn của bạn (1->3) : ");
                choice=sc.nextInt();
                sc.nextLine();
                switch (choice)
                {
                    case 1: {
                        System.out.print("Nhập mã nhà cung cấp cần sửa : ");
                        String newMaNCC = sc.nextLine();
                        dspn[index].setMaNCC(newMaNCC);
                        break;
                    }
                    case 2: {
                        while(true)
                        {
                            System.out.print("Nhập ngày nhập hàng cẩn sửa đổi (yyyy/mm/dd) : ");
                            String newNgayNhap = sc.nextLine();
                            if(newNgayNhap.matches("\\d{4}/\\d{2}/\\d{2}"))
                            {
                                dspn[index].setNgayNhap(newNgayNhap);
                                break;
                            }
                            else
                            {
                                System.out.println("Vui lòng nhập theo đúng định dạng (yyyy/mm/dd) !!!");
                            }
                        }
                        break;
                    }
                    case 3: {
                        System.out.printf("Nhập mã nhân viên cần sửa : ");
                        String newMaNV = sc.nextLine();
                        dspn[index].setMaNV(newMaNV);
                        break;
                    }
                    case 0: {
                        System.out.println("Tạm biệt !!!");
                        break;
                    }
                    default: {
                        System.out.println("Lựa chọn không hợp lệ vui lòng chọn từ (1->3) !!!");
                    }
                }
            }while(choice!=0);
        }
        else
        {
            System.out.println("Không tìm thấy mã phiếu cần sửa !!!");
        }
    }
    public void thongKe()
    {
        int n= dspn.length;
        int d=0;
        for(int i=0;i<n;i++)
        {
            d++;
        }
        System.out.println("Có " + d + " phiếu nhập trong danh sách");
    }
    public void thongKeTheoTien()
    {
        DecimalFormat df = new DecimalFormat("#,###");
        Scanner sc=new Scanner(System.in);
        float min=0;
        float max=0;
        System.out.print("Nhập tổng tiền nhỏ nhất : ");
        min=sc.nextFloat();
        System.out.print("Nhập tổng tiền lớn nhất : ");
        max=sc.nextFloat();
        String format = "| %-15s | %-20s | %-15s | %-15s | %-15s |\n";
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.format(format, "Mã phiếu nhập", "Ngày nhập", "Mã NCC", "Mã NV", "Tổng tiền");
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");

        for (int i = 0; i < dspn.length; i++)
        {
            if(dspn[i].getTongTien() >= min && dspn[i].getTongTien() <= max)
            {
                System.out.format(format, dspn[i].getMaPN(), dspn[i].getNgayNhap(), dspn[i].getMaNCC(),
                        dspn[i].getMaNV(), df.format(dspn[i].getTongTien()));
            }
        }

        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.println("\n");
    }
    public void docFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/data/ListPhieuNhap.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống

                // Tách chuỗi bằng dấu `;`
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    try {
                        // Tạo đối tượng PhieuNhap từ dữ liệu
                        PhieuNhap pn = new PhieuNhap(
                                parts[0], // Mã phiếu nhập
                                parts[1], // Ngày nhập
                                parts[2], // Mã nhà cung cấp
                                parts[3], // Mã nhân viên
                                Float.parseFloat(parts[4]) // Tổng tiền
                        );

                        // Thêm đối tượng vào danh sách
                        dspn = Arrays.copyOf(dspn, dspn.length + 1);
                        dspn[dspn.length - 1] = pn;
                    } catch (NumberFormatException e) {
                        System.out.println("Dữ liệu tổng tiền không hợp lệ: " + line);
                    }
                } else {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        }
    }

    public String[] layDanhSachPN()
    {
        String[] ncc=new String[dspn.length];
        for(int i=0;i< dspn.length;i++)
        {
            ncc[i]=dspn[i].getMaPN();
        }
        return ncc;
    }
    public void ghiFile()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/ListPhieuNhap.txt"))) {
            for (PhieuNhap pn : dspn)
            {
                if (pn != null) {
                    String data = pn.getMaPN() + ";" +
                            pn.getNgayNhap() + ";" +
                            pn.getMaNCC() + ";" +
                            pn.getMaNV() + ";" +
                            pn.getTongTien() + "\n";
                    writer.write(data);  // Ghi dữ liệu vào file
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    public void timkiemNangCao()
    {
        Scanner sc=new Scanner(System.in);
        String maNV=null,maNCC=null,ngayBatDau=null,ngayKetThuc=null;
        DecimalFormat df = new DecimalFormat("#,###");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Float min=null,max=null;
        System.out.print("Nhập mã nhà cung cập : ");
        maNCC=sc.nextLine().trim().toUpperCase();
        if(maNCC.isEmpty())
        {
            maNCC=null;
        }
        System.out.print("Nhập mã nhân viên : ");
        maNV=sc.nextLine().trim().toUpperCase();
        if(maNV.isEmpty())
        {
            maNV=null;
        }
        LocalDate ngayBatDauDate = null;
        LocalDate ngayKetThucDate = null;
        while (true) {
            System.out.print("Nhập ngày bắt đầu (yyyy/MM/dd): ");
            ngayBatDau = sc.nextLine().trim();
            if(ngayBatDau.isEmpty())
            {
                break;
            }
            try {
                ngayBatDauDate = LocalDate.parse(ngayBatDau, formatter);
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập ngày theo dạng (yyyy/MM/dd) !!!");
            }
        }
        while (true) {
            System.out.print("Nhập ngày kết thúc (yyyy/MM/dd): ");
            ngayKetThuc = sc.nextLine().trim();
            if(ngayKetThuc.isEmpty())
            {
                break;
            }
            try {
                ngayKetThucDate = LocalDate.parse(ngayKetThuc, formatter);
                if (ngayKetThucDate.isBefore(ngayBatDauDate)) {
                    System.out.println("Ngày kết thúc không thể trước ngày bắt đầu, vui lòng nhập lại.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập ngày theo dạng (yyyy/MM/dd) !!!");
            }
        }
        System.out.print("Nhập tổng tiền thấp nhất : ");
        String minInput=sc.nextLine().trim();
        if(!minInput.isEmpty())
        {
            min=Float.parseFloat(minInput);
        }
        System.out.print("Nhập tổng tiền cao nhất : ");
        String maxInput=sc.nextLine().trim();
        if(!maxInput.isEmpty())
        {
            max=Float.parseFloat(maxInput);
        }
        String format = "| %-15s | %-20s | %-15s | %-15s | %-15s |\n";
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.format(format, "Mã phiếu nhập", "Ngày nhập", "Mã NCC", "Mã NV", "Tổng tiền");
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        for(int i=0;i< dspn.length;i++)
        {
            String ngaynhapStr = dspn[i].getNgayNhap();
            LocalDate ngayNhapDate = LocalDate.parse(ngaynhapStr, formatter);
            boolean dk=true;
            if (maNCC != null && !dspn[i].getMaNCC().equals(maNCC)) {
                dk = false;
            }
            if (maNV != null && !dspn[i].getMaNV().equals(maNV)) {
                dk = false;
            }
            if (min != null && dspn[i].getTongTien() < min) {
                dk = false;
            }
            if (max != null && dspn[i].getTongTien() > max) {
                dk = false;
            }
            if (ngayBatDauDate != null && ngayNhapDate.isBefore(ngayBatDauDate)) {
                dk = false;
            }
            if (ngayKetThucDate != null && ngayNhapDate.isAfter(ngayKetThucDate)) {
                dk = false;
            }
            if(dk)
            {
                System.out.format(format, dspn[i].getMaPN(), dspn[i].getNgayNhap(), dspn[i].getMaNCC(),
                        dspn[i].getMaNV(), df.format(dspn[i].getTongTien()));
            }
        }
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.println("\n");
    }
    public void xuat()
    {
        for(int i=0;i<dspn.length;i++)
        {
            dspn[i].xuatPhieuNhap();
        }
    }
    public void xuatDs() {

        DecimalFormat df = new DecimalFormat("#,###");
        if (dspn.length == 0)
        {
            System.out.println("Danh sách phiếu nhập trống.");
            return;
        }
        String format = "| %-15s | %-20s | %-15s | %-15s | %-15s |\n";
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.format(format, "Mã phiếu nhập", "Ngày nhập", "Mã NCC", "Mã NV", "Tổng tiền");
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");

        for (int i = 0; i < dspn.length; i++) {
            System.out.format(format, dspn[i].getMaPN(), dspn[i].getNgayNhap(), dspn[i].getMaNCC(),
                    dspn[i].getMaNV(), df.format(dspn[i].getTongTien()));
        }

        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.println("\n");
    }

}