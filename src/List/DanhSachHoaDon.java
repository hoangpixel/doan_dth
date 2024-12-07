package List;
import java.util.Scanner;
import java.util.Arrays;
import Constructors.HoaDon;
import Interfaces.InterfaceDocGhi;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class DanhSachHoaDon implements InterfaceDocGhi{
int n=0;
HoaDon[] dshd=new HoaDon[0];
public DanhSachHoaDon(){}
public DanhSachHoaDon(int n, HoaDon[] dshd){
    this.n=n;
    this.dshd=dshd;
}
public DanhSachHoaDon(DanhSachHoaDon temp){
    n=temp.n;
    dshd=temp.dshd;
}
public void check(HoaDon temp){
    for(int i=0; i<n; i=i+1)
        if(dshd[i]!=temp)
            if(dshd[i]!=null)
                if(dshd[i].getMaHd().equals(temp.getMaHd())){
                    System.out.println("\nMã hoá đơn bị trùng");
                    System.out.print("Nhập lại mã hoá đơn: ");
                    String tmp;
                    Scanner nhap=new Scanner(System.in);
                    tmp=nhap.nextLine();
                    temp.setMaHd(tmp);
                    check(temp);
    }
}

public int length(){
    return dshd.length;
}

public void add(HoaDon a){
    dshd = Arrays.copyOf(dshd, dshd.length + 1);
    dshd[dshd.length - 1] = a;
    n += 1;
}

public String taoMaHd() {
    int maxNumber = 0; 
    for (HoaDon hd : dshd) { 
        if (hd != null) { 
            String id = hd.getMaHd();
            int number = Integer.parseInt(id.replaceAll("\\D", "")); 
            if (number > maxNumber) {
                maxNumber = number; 
            }
        }
    }
    return "HD" + (maxNumber + 1); 
}
public void nhapDanhSachHoaDon(DanhSachNhanVien temp1, DSKhachHang temp2){
    System.out.print("Nhập số lượng hoá đơn: ");
    Scanner nhap=new Scanner(System.in);
    n=nhap.nextInt();
    dshd=new HoaDon[n];
    String[] danhsachmanv = temp1.layDanhSachMaNV();
    String[] danhsachmakh = temp2.layDanhSachMaKh();
    if(danhsachmakh.length==0||danhsachmanv.length==0){
        System.out.println("Danh sách nhân viên hay danh sách khách hàng trống, hãy nhập danh sách nhân viên hay danh sách khách hàng trước");
        return;
    }
    for(int i=0; i<n; i=i+1){
        dshd[i]=new HoaDon();
        dshd[i].nhap(danhsachmanv, danhsachmakh);
        check(dshd[i]);
    }
}
public void xuatDanhSachHoaDon(){
    System.out.println();
    if(n==0){
        System.out.println("Danh sách hoá đơn trống");
        return;
    }
    String format = "| %-15s | %-20s | %-15s | %-10s | %-15s |\n";
    System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
    System.out.format(format, "Mã hoá đơn", "Ngày lập hoá đơn", "Mã nhân viên", "Mã khách hàng", "Tổng tiền");
    System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
    for (int i=0; i<n; i=i+1) 
        System.out.format(format, dshd[i].getMaHd(), dshd[i].getNgayLapHd(), dshd[i].getMaNv(),dshd[i].getMaKh(), dshd[i].getTongTien());
    System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
}
public void themHoaDon(DanhSachNhanVien temp1, DSKhachHang temp2){
    String choice;
    Scanner nhap=new Scanner(System.in);
    System.out.println("\nBạn có muốn thêm hoá đơn không? (Y/N)");
    System.out.print("(Y/N): ");
    choice=nhap.nextLine();
    while(!choice.equals("Y")&&!choice.equals("N")){
        System.out.println("Vui lòng nhập (Y/N)");
        System.out.print("(Y/N): ");
        choice=nhap.nextLine();
    }
    if(choice.equals("N"))
    {
        System.out.println("Bạn lựa chọn không");
        return;
    }
    String[] danhsachmanv = temp1.layDanhSachMaNV();
    String[] danhsachmakh = temp2.layDanhSachMaKh();
    if(danhsachmakh.length==0||danhsachmanv.length==0){
        System.out.println("Danh sách nhân viên hay danh sách khách hàng trống, hãy nhập danh sách nhân viên hay danh sách khách hàng trước");
        return;
    }
    System.out.print("Nhập số lượng hoá đơn muốn thêm: ");
    int add;
    add=nhap.nextInt();
    for(int i=0; i<add; i=i+1){
        n=dshd.length;
        dshd=Arrays.copyOf(dshd, n+1);
        dshd[n]=new HoaDon();
        dshd[n].nhap(danhsachmanv, danhsachmakh);
        check(dshd[n]);
        n=n+1;
    }
}
public void xoaTheoMa(){
    String choice;
    Scanner nhap=new Scanner(System.in);
    System.out.println("\nBạn có muốn xoá hoá đơn không? (Y/N)");
    System.out.print("(Y/N): ");
    choice=nhap.nextLine();
    while(!choice.equals("Y")&&!choice.equals("N")){
        System.out.println("Vui lòng nhập (Y/N)");
        System.out.print("(Y/N): ");
        choice=nhap.nextLine();
    }
    if(choice.equals("N")){
        System.out.println("Bạn lựa chọn không");
        return;
    }
    String ma;
    System.out.print("Nhập mã hoá đơn muốn xoá: ");
    ma=nhap.nextLine();
    if(timTheoMa(ma)==-1)
    {
        System.out.println("Không tìm thấy mã hoá đơn muốn xoá");
        return;
    }
    int position=timTheoMa(ma)-1;
    for(int i=position; i<dshd.length-1; i=i+1)
        dshd[i]=dshd[i+1];
    dshd=Arrays.copyOf(dshd, dshd.length-1);
    n=n-1;
}
public int timTheoMa(String ma){
    for(int i=0; i<n; i=i+1)
        if(dshd[i].getMaHd().equals(ma))
            return i+1;
    return -1;
}
public void timTheoMa(){
    String ma;
    System.out.print("\nNhập mã hoá đơn muốn tìm: ");
    Scanner nhap=new Scanner(System.in);
    ma=nhap.nextLine();  
    for(int i=0; i<n; i=i+1)           
        if(dshd[i].getMaHd().equals(ma)){
            System.out.println("Vị trí của hoá đơn cần tìm là: "+(i+1));
            dshd[i].xuat();
            return;
        }
    System.out.println("Không tìm thấy hoá đơn");
    }
public void timTheoMaKh(){
    String ma;
    System.out.print("\nNhập mã khách hàng muốn tìm hoá đơn: ");
    Scanner nhap=new Scanner(System.in);
    ma=nhap.nextLine();
    HoaDon[] find=new HoaDon[0];
    int dai=0;
    for(int i=0; i<n; i=i+1)
        if(dshd[i].getMaKh().equals(ma)){
            find=Arrays.copyOf(find, dai+1);
            find[dai]=new HoaDon();
            find[dai]=dshd[i];
            dai=dai+1;
        }
    if(dai==0){
        System.out.println("Không tìm thấy hoá đơn có mã khách hàng");
        return;
    }
    System.out.println("Có "+dai+" hoá đơn theo mã khách hàng bạn muốn tìm:");
    for(int i=0; i<dai; i=i+1)
        find[i].xuat();
}
public void timTheoMaNv(){
    String ma;
    System.out.print("\nNhập mã nhân viên muốn tìm hoá đơn: ");
    Scanner nhap=new Scanner(System.in);
    ma=nhap.nextLine();
    HoaDon[] find=new HoaDon[0];
    int dai=0;
    for(int i=0; i<n; i=i+1)
        if(dshd[i].getMaNv().equals(ma))
        {
            find=Arrays.copyOf(find, dai+1);
            find[dai]=new HoaDon();
            find[dai]=dshd[i];
            dai=dai+1;
        }
    if(dai==0)
    {
        System.out.println("Không tìm thấy hoá đơn theo mã nhân viên");
        return;
    }
    System.out.println("Có "+dai+" hoá đơn theo mã nhân viên bạn muốn tìm");
    for(int i=0; i<dai; i=i+1)
        find[i].xuat();
}
public void suaTheoMa(){
        String ma;
        Scanner nhap=new Scanner(System.in);
        System.out.print("\nNhập mã của hoá đơn muốn sửa thông tin: ");
        ma=nhap.nextLine();    
        if(timTheoMa(ma)==-1){
            System.out.println("Không tìm thấy mã hoá đơn");
            return;
        }
        int position=timTheoMa(ma);
        System.out.println("\n--- Menu ---");
        System.out.println("1. Sửa đổi ngày lập hoá đơn");
        System.out.println("2. Sửa đổi mã nhân viên");
        System.out.println("3. Sửa đổi mã khách hàng");
        System.out.println("4. Sửa đổi tổng tiền");
        System.out.println("5. Thoát");
        System.out.println("----------------------------------");
        System.out.print("Vui lòng nhập lựa chọn của bạn (1->5): ");
        int choice;
        choice=nhap.nextInt();
        nhap.nextLine();
        switch(choice)
            {
            case 1:
            {
                String ngay;
                System.out.print("Nhập ngày nhập hoá đơn mới (yyyy-mm-dd): ");
                ngay = nhap.nextLine();
                if(ngay.matches("\\d{4}-\\d{2}-\\d{2}")) 
                dshd[position-1].setNgayLapHd(ngay);
                else 
                System.out.println("Vui lòng nhập đúng cấu trúc (yyyy-mm-dd)");
                break;
            }
            case 2:
            {
                System.out.print("Nhập mã nhân viên mới: ");
                String ma_nv;
                ma_nv=nhap.nextLine();
                dshd[position-1].setMaNv(ma_nv);
                break;
            }
            case 3:
            {
                System.out.print("Nhập mã khách hàng mới: ");
                String ma_kh;
                ma_kh=nhap.nextLine();
                dshd[position-1].setMaKh(ma_kh);
                break;
            }
            case 4:
            {
                System.out.print("Nhập tổng tiền mới: ");
                float tong;
                tong=nhap.nextFloat();
                dshd[position-1].setTongTien(tong);
                nhap.nextLine();
                break;
            }
            case 5:
            {
                System.out.println("Thoát");
                break;
            }
            default:
                System.out.println("Lưa chọn không hợp lệ (1 -> 8)");
            }
    }
public void thongKe(){
    System.out.println("\nDanh sách có "+n+" hoá đơn");
}
@Override
public void docFile() {
        HoaDon[] temp=new HoaDon[0];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/data/ListHoaDon.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(";");

                if (parts.length < 5)
                    continue; // Bỏ qua dòng không hợp lệ
                String mahd = parts[0];
                String ngaylaphd = parts[1];
                String manv = parts[2];
                String makh = parts[3];
                float tongtien = Float.parseFloat(parts[4]);
                HoaDon hd = new HoaDon(mahd, ngaylaphd, manv, makh, tongtien);
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = new HoaDon();
                temp[temp.length - 1] = hd;
            }
            dshd=temp;
            n=dshd.length;
            System.out.println("Dữ liệu hoá đơn đã được khôi phục từ file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file: " + e.getMessage());
            }
        }
    }
@Override
public void ghiFile() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("src/data/ListHoaDon.txt"));

            for (HoaDon hd : dshd) {
                if (hd != null) {
                    String data = hd.getMaHd() + ";" + hd.getNgayLapHd()+
                            ";" + hd.getMaNv()+ ";" + hd.getMaKh()+
                            ";" + hd.getTongTien() + "\n";
                    writer.write(data); // Ghi dữ liệu vào file
                }
            }
            System.out.println("Dữ liệu hoá đơn đã được xuất vào ListHoaDon.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file: " + e.getMessage());
            }
        }
    }

public int kiemtraQuy(int quy, int nam){
    int dai=0;
    for(int i=0; i<n; i=i+1){
        if(quy==1){
            if((dshd[i].getMonth()==1||dshd[i].getMonth()==2||dshd[i].getMonth()==3)&&dshd[i].getYear()==nam)
                dai=dai+1;
        }
        if(quy==2){
           if((dshd[i].getMonth()==4||dshd[i].getMonth()==5||dshd[i].getMonth()==6)&&dshd[i].getYear()==nam)
                dai=dai+1;
        }
        if(quy==3){
           if((dshd[i].getMonth()==7||dshd[i].getMonth()==8||dshd[i].getMonth()==9)&&dshd[i].getYear()==nam)
                dai=dai+1;
        }
        if(quy==4){
           if((dshd[i].getMonth()==10||dshd[i].getMonth()==11||dshd[i].getMonth()==12)&&dshd[i].getYear()==nam)
                dai=dai+1;
        }
        if(quy!=1&&quy!=2&&quy!=3&&quy!=4)
            return -1;
    }
    return dai;
}

public boolean checkNam(int[] mangnam, int num, int nam){
    for(int i=0; i<num; i=i+1){
        if(mangnam[i]==nam)
            return false;
    }
    return true;
}

public int[] taoMangNam(){
    int[] nam=new int[100];
    nam[0]=dshd[0].getYear();
    int dai=1;
    for(int i=1; i<n; i=i+1)
        if(checkNam(nam, dai, dshd[i].getYear())){
            nam[dai]=dshd[i].getYear();
            dai=dai+1;
        }
    int[] year=Arrays.copyOf(nam, dai);
    return year;
}

public HoaDon[] quyI(int nam){
    HoaDon[] quyI=new HoaDon[kiemtraQuy(1, nam)];
    int j=0;
    for(int i=0; i<n; i=i+1)
        if((dshd[i].getMonth()==1||dshd[i].getMonth()==2||dshd[i].getMonth()==3)&&dshd[i].getYear()==nam){
            quyI[j]=dshd[i];
            j=j+1;
        }
    return quyI;
}

public HoaDon[] quyII(int nam){
    HoaDon[] quyII=new HoaDon[kiemtraQuy(2, nam)];
    int j=0;
    for(int i=0; i<n; i=i+1)
        if((dshd[i].getMonth()==3||dshd[i].getMonth()==4||dshd[i].getMonth()==5)&&dshd[i].getYear()==nam){
            quyII[j]=dshd[i];
            j=j+1;
        }
    return quyII;
}

public HoaDon[] quyIII(int nam){
    HoaDon[] quyIII=new HoaDon[kiemtraQuy(3, nam)];
    int j=0;
    for(int i=0; i<n; i=i+1)
        if((dshd[i].getMonth()==7||dshd[i].getMonth()==8||dshd[i].getMonth()==9)&&dshd[i].getYear()==nam){
            quyIII[j]=dshd[i];
            j=j+1;
        }
    return quyIII;
}

public HoaDon[] quyIV(int nam){
    HoaDon[] quyIV=new HoaDon[kiemtraQuy(4, nam)];
    int j=0;
    for(int i=0; i<n; i=i+1)
        if((dshd[i].getMonth()==10||dshd[i].getMonth()==11||dshd[i].getMonth()==12)&&dshd[i].getYear()==nam){
            quyIV[j]=dshd[i];
            j=j+1;
        }
    return quyIV;
}

public void thongKeTheoQuy(){
    if(n==0){
        System.out.println("Danh sách hoá đơn trống");
        return;
    }
    int[] year=taoMangNam();
    for(int i=0; i<year.length; i=i+1){
        HoaDon[] quyI=quyI(year[i]);
        HoaDon[] quyII=quyII(year[i]);
        HoaDon[] quyIII=quyIII(year[i]);
        HoaDon[] quyIV=quyIV(year[i]);
        float tong1=0;
        float tong2=0;
        float tong3=0;
        float tong4=0;
        System.out.println("Năm "+year[i]+": ");
        for(int temp=0; temp<quyI.length; temp=temp+1)
            tong1=tong1+quyI[temp].getTongTien();
        for(int temp=0; temp<quyII.length; temp=temp+1)
            tong2=tong2+quyII[temp].getTongTien();
        for(int temp=0; temp<quyIII.length; temp=temp+1)
            tong3=tong3+quyIII[temp].getTongTien();
        for(int temp=0; temp<quyIV.length; temp=temp+1)
            tong4=tong4+quyIV[temp].getTongTien();
        System.out.println("Tổng tiền theo quý I: "+tong1);
        System.out.println("Tổng tiền theo quý II: "+tong2);
        System.out.println("Tổng tiền theo quý III: "+tong3);
        System.out.println("Tổng tiền theo quý IV: "+tong4);
        System.out.println("---\n");
    }
}

public void menu(DanhSachNhanVien temp1, DSKhachHang temp2){
    int choice;
    Scanner nhap=new Scanner(System.in);
    do
    {
    System.out.println("\n--- Menu ---");
    System.out.println("1. Nhập danh sách hoá đơn");
    System.out.println("2. Xuất danh sách hoá đơn");
    System.out.println("3. Thêm hoá đơn");
    System.out.println("4. Xoá hoá đơn theo mã hoá đơn");
    System.out.println("5. Tìm hoá đơn theo mã hoá đơn");
    System.out.println("6. Tìm hoá đơn theo mã nhân viên lập hoá đơn");
    System.out.println("7. Tìm hoá đơn theo mã khách hàng");
    System.out.println("8. Sửa hoá đơn theo mã hoá đơn");
    System.out.println("9. Thống kê số hoá đơn hiện có trong danh sách");
    System.out.println("10. Thống kê tổng tiền theo quý");
    System.out.println("11. Thoát");
    System.out.println("----------------------------------");
    System.out.print("Vui lòng nhập lựa chọn của bạn (1->11): ");
    choice=nhap.nextInt();
    switch(choice)
            {
            case 1:
            {
                nhapDanhSachHoaDon(temp1, temp2);
                break;
            }
            case 2:
            {
                xuatDanhSachHoaDon();
                break;
            }
            case 3:
            {
                themHoaDon(temp1, temp2);
                break;
            }
            case 4:
            {
                xoaTheoMa();
                break;
            }
            case 5:
            {
                timTheoMa();
                break;
            }
            case 6:
            {
                timTheoMaNv();
                break;
            }
            case 7:
            {
                timTheoMaKh();
                break;
            }
            case 8:
            {
                suaTheoMa();
                break;
            }
            case 9:
            {
                thongKe();
                break;
            }
            case 10:
            {
                thongKeTheoQuy();
                break;
            }
            case 11:
            {
                System.out.println("Bạn chọn thoát");
                break;
            }
            default:
                System.out.println("Lưa chọn không hợp lệ (1 -> 11)");
            }
    }while(choice!=11);
}
}
