package List;
import java.util.Scanner;
import java.util.Arrays;
import Constructors.NhanVien;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class DanhSachNhanVien
{
    private int n=0;
    private NhanVien[] dsnv=new NhanVien[0];
    public DanhSachNhanVien(){
    }
    public DanhSachNhanVien(int n, NhanVien[] dsnv){
        this.n=n;
        this.dsnv=dsnv;
    }
    public DanhSachNhanVien(DanhSachNhanVien dsnvtemp){
        n=dsnvtemp.n;
        dsnv=dsnvtemp.dsnv;
    }
    void check(NhanVien temp){
        for(int i=0; i<n; i=i+1)
            if(dsnv[i]!=null)
                if(dsnv[i]!=temp)
                    if(dsnv[i].getMaNv().equals(temp.getMaNv())){
                        String tmp;
                        Scanner nhap=new Scanner(System.in);
                        System.out.println("\nMã nhân viên bị trùng");
                        System.out.print("Nhập lại mã: ");
                        tmp=nhap.nextLine();
                        temp.setMaNv(tmp);
                        check(temp);
                    }
    }
    void nhapdsnv(){
        System.out.print("Nhập số lượng nhân viên: ");
        Scanner nhap=new Scanner(System.in);
        n=nhap.nextInt();
        dsnv=new NhanVien[n];
        for(int i=0; i<n; i=i+1){
            dsnv[i]=new NhanVien();
            dsnv[i].nhap();
            check(dsnv[i]);
        }
    }
    void xuatdsnv(){
        System.out.print("\n");
        for(int i=0; i<n; i=i+1){
            System.out.println("------Nhân viên thứ "+(i+1)+"------");
            dsnv[i].xuat(dsnv[i]);
        }
    }
    void them()
    {
        Scanner nhap=new Scanner(System.in);
        System.out.print("Nhập số lượng nhân viên muốn thêm: ");
        int add;
        add=nhap.nextInt();
        for(int i=0; i<add; i=i+1){
            n=dsnv.length;
            dsnv = Arrays.copyOf(dsnv, n+1);
            dsnv[n]=new NhanVien();
            dsnv[n].nhap();
            check(dsnv[n]);
            n=n+1;
        }
    }
    void xoaTheoMa(){
        System.out.println("\nBạn có muốn xoá nhân viên không? (Y/N)");
        String choice;
        Scanner nhap=new Scanner(System.in);
        System.out.print("(Y/N): ");
        choice=nhap.nextLine();
        while(!choice.equals("Y")&&!choice.equals("N")){
            System.out.println("\nVui lòng nhập (Y/N)");
            System.out.print("(Y/N): ");
            choice=nhap.nextLine();
        }
        if(choice.equals("N")){
            System.out.println("Bạn lựa chọn không");
            return;
        }
        String ma;
        System.out.print("\nNhập mã nhân viên muốn xoá: ");
        ma=nhap.nextLine();
        if(timTheoMa(ma)!=-1)
        {
            int position=timTheoMa(ma)-1;
            for(int i=position; i<dsnv.length-1; i=i+1)
                dsnv[i]=dsnv[i+1];
            dsnv = Arrays.copyOf(dsnv,dsnv.length-1);
            n=n-1;
        }
        else
            System.out.print("Không tìm thấy mã muốn xoá\n");
    }
    void timTheoMa(){
        String ma;
        System.out.print("\nNhập mã nhân viên muốn tìm: ");
        Scanner nhap=new Scanner(System.in);
        ma=nhap.nextLine();
        for(int i=0; i<n; i=i+1)
            if(dsnv[i].getMaNv().equals(ma)){
                System.out.println("Vị trí của nhân viên cần tìm là: "+(i+1));
                dsnv[i].xuat(dsnv[i]);
                return;
            }
        System.out.println("Không tìm thấy mã nhân viên");
    }
    int timTheoMa(String check){
        for(int i=0; i<n; i=i+1)
            if(dsnv[i].getMaNv().equals(check))
                return i+1;
        return -1;
    }
    void timTheoHo(){
        NhanVien[] findname=new NhanVien[0];
        String ho;
        System.out.print("\nNhập họ muốn tìm: ");
        Scanner nhap=new Scanner(System.in);
        ho=nhap.nextLine();
        int dai=0;
        for(int i=0; i<n; i=i+1)
            if((dsnv[i].getHoNv()).indexOf(ho, 0)!=-1)
            {
                findname=Arrays.copyOf(findname, dai+1);
                findname[dai]=new NhanVien();
                findname[dai]=dsnv[i];
                dai=dai+1;
            }
        if(dai==0){
            System.out.println("Không tìm thấy họ nhân viên");
            return;
        }
        System.out.println("Có "+dai+" nhân viên theo họ bạn muốn tìm:");
        for(int i=0; i<dai; i=i+1)
            findname[i].xuat(findname[i]);
    }
    void timTheoTen(){
        NhanVien[] findname=new NhanVien[0];
        String ten;
        System.out.print("\nNhập tên muốn tìm: ");
        Scanner nhap=new Scanner(System.in);
        ten=nhap.nextLine();
        int dai=0;
        for(int i=0; i<n; i=i+1)
            if((dsnv[i].getTenNv()).indexOf(ten, 0)!=-1)
            {
                findname=Arrays.copyOf(findname, dai+1);
                findname[dai]=new NhanVien();
                findname[dai]=dsnv[i];
                dai=dai+1;
            }
        if(dai==0){
            System.out.println("Không tìm thấy tên nhân viên");
            return;
        }
        System.out.println("Có "+dai+" nhân viên theo tên bạn muốn tìm:");
        for(int i=0; i<dai; i=i+1)
            findname[i].xuat(findname[i]);
    }
    void suaTheoMa(){
        String ma;
        Scanner nhap=new Scanner(System.in);
        System.out.print("\nNhập mã của nhân viên muốn sửa thông tin: ");
        ma=nhap.nextLine();
        if(timTheoMa(ma)==-1){
            System.out.println("Không tìm thấy mã nhân viên");
            return;
        }
        int position=timTheoMa(ma);
        System.out.println("---------------Menu---------------");
        System.out.println("1. Sửa đổi họ nhân viên");
        System.out.println("2. Sửa đổi tên nhân viên");
        System.out.println("3. Sửa đổi lương");
        System.out.println("4. Sửa đổi chức vụ");
        System.out.println("5. Sửa đổi số điện thoại nhân viên");
        System.out.println("6. Sửa đổi số căn cước");
        System.out.println("7. Sửa đổi địa chỉ");
        System.out.println("8. Thoát");
        System.out.println("----------------------------------");
        System.out.print("Vui lòng nhập lựa chọn của bạn (1->8): ");
        int choice;
        choice=nhap.nextInt();
        nhap.nextLine();
        switch(choice)
        {
            case 1:
            {
                System.out.print("Nhập họ mới cho nhân viên: ");
                String ho;
                ho=nhap.nextLine();
                dsnv[position-1].setHoNv(ho);
                break;
            }
            case 2:
            {
                System.out.print("Nhập tên mới cho nhân viên: ");
                String ten;
                ten=nhap.nextLine();
                dsnv[position-1].setTenNv(ten);
                break;
            }
            case 3:
            {
                System.out.print("Nhập lương mới cho nhân viên: ");
                float lg;
                lg=nhap.nextFloat();
                dsnv[position-1].setLuong(lg);
                break;
            }
            case 4:
            {
                System.out.print("Nhập chức vụ mới cho nhân viên: ");
                String cv;
                cv=nhap.nextLine();
                dsnv[position-1].setChucVu(cv);
                break;
            }
            case 5:
            {
                System.out.print("Nhập số điện thoại mới cho nhân viên: ");
                String sdt;
                sdt=nhap.nextLine();
                dsnv[position-1].setSdtNv(sdt);
                break;
            }
            case 6:
            {
                System.out.print("Nhập số căn cước mới cho nhân viên: ");
                String scc;
                scc=nhap.nextLine();
                dsnv[position-1].setSoCanCuoc(scc);
                break;
            }
            case 7:
            {
                System.out.print("Nhập địa chỉ mới cho nhân viên: ");
                String dc;
                dc=nhap.nextLine();
                dsnv[position-1].setDiaChiNv(dc);
                break;
            }
            case 8:
            {
                System.out.println("Thoát");
                break;
            }
            default:
                System.out.println("Lưa chọn không hợp lệ (1 -> 8)");
        }
    }
    void thongKe(){
        System.out.println("\nCó "+n+" nhân viên trong danh sách");
    }
    public String[] layDanhSachMaNV() {
        String[] maNVs = new String[dsnv.length];
        for (int i = 0; i < dsnv.length; i++) {
            maNVs[i] = dsnv[i].getMaNv();
        }
        return maNVs;
    }
    public void docTuFile() {
        NhanVien[] temp=new NhanVien[0];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/data/ListNhanVien.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Bỏ qua các dòng trống
                }

                // Phân tách dữ liệu nhân viên
                String[] parts = line.split(", ");

                if (parts.length < 8) {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                    continue; // Bỏ qua dòng không hợp lệ
                }

                String manv = parts[0].split(": ")[1];
                String honv = parts[1].split(": ")[1];
                String tennv = parts[2].split(": ")[1];
                float luong = Float.parseFloat(parts[3].split(": ")[1]);
                String chucvu = parts[4].split(": ")[1];
                String sdtnv = parts[5].split(": ")[1];
                String socancuoc = parts[6].split(": ")[1];
                String diachinv = parts[7].split(": ")[1];

                // Tạo đối tượng NhanVien từ dữ liệu đọc được
                NhanVien nv = new NhanVien(manv, honv, tennv, luong, chucvu, sdtnv, socancuoc, diachinv);

                // Thêm nhân viên vào danh sách
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = new NhanVien();
                temp[temp.length - 1] = nv;
            }
            dsnv=temp;
            n=dsnv.length;
            System.out.println("Dữ liệu nhân viên đã được khôi phục từ file.");
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
    public void xuatRaFile() {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("src/data/ListNhanVien.txt"));

            for (NhanVien nv : dsnv) {
                if (nv != null) {
                    String data = "Mã NV: " + nv.getMaNv() + ", Họ NV: " + nv.getHoNv() +
                            ", Tên NV: " + nv.getTenNv() + ", Lương: " + nv.getLuong() +
                            ", Chức vụ: " + nv.getChucVu() + ", Số điện thoại: " + nv.getSdtNv() +
                            ", Số CCCD: " + nv.getSoCanCuoc() + ", Địa chỉ: " + nv.getDiaChiNv() + "\n";
                    writer.write(data); // Ghi dữ liệu vào file
                }
            }
            System.out.println("Dữ liệu nhân viên đã được xuất vào ListNhanVien.txt");
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
    
    public void thongKeLuong(){
	    int[] lg=new int[3];
	    for(int i=0; i<3; i=i+1)
	    lg[i]=0;
	    for(int i=0; i<n; i=i+1){
	        if(dsnv[i].getLuong()<=10000000)
	        lg[0]=lg[0]+1;
	        if(dsnv[i].getLuong()<=20000000&&dsnv[i].getLuong()>=10000001)
	        lg[1]=lg[1]+1;
	        if(dsnv[i].getLuong()>=21000001)
	        lg[2]=lg[2]+1;
	    }
	    System.out.println("Số lượng nhân viên có lương từ 10 triệu trở xuống: "+lg[0]);
	    System.out.println("Số lượng nhân viên có lương trên 10 triệu và đến 20 triệu: "+lg[1]);
	    System.out.println("Số lượng nhân viên có lương từ 20 triệu trở xuống: "+lg[2]);
	}
    
    void thongKeMinMax(){
        if(dsnv.length==0){
            System.out.println("Danh sách nhân viên trống");
            return;
        }
        float min=dsnv[0].getLuong();
        float max=dsnv[0].getLuong();
        for(int i=0; i<n; i=i+1){
            if(min>dsnv[i].getLuong())
                min=dsnv[i].getLuong();
            if(max<dsnv[i].getLuong())
                max=dsnv[i].getLuong();
        }
        System.out.println("Lương cao nhất của nhân viên: "+max);
        System.out.println("Lương thấp nhất của nhân viên: "+min);
        System.out.println("Chênh lệch lương cao nhất và thấp nhất: "+(max-min));
    }
    
    public void menu() {
        int choice;
        Scanner nhap = new Scanner(System.in);
        do {
            System.out.println("\n------- Quản lý danh sách nhân viên -------");
            System.out.println("| 1. Nhập danh sách nhân viên                          |");
            System.out.println("| 2. Xuất danh sách nhân viên                          |");
            System.out.println("| 3. Thêm nhân viên                                    |");
            System.out.println("| 4. Xoá nhân viên theo mã nhân viên                   |");
            System.out.println("| 5. Tìm nhân viên theo mã nhân viên                   |");
            System.out.println("| 6. Tìm nhân viên theo họ nhân viên                   |");
            System.out.println("| 7. Tìm nhân viên theo tên nhân viên                  |");
            System.out.println("| 8. Sửa thông tin nhân viên                           |");
            System.out.println("| 9. Thống kê số nhân viên                             |");
            System.out.println("| 10. Thống kê lương của nhân viên                     |");
            System.out.println("| 11. Thống kê lương cao nhất, thấp nhất của nhân viên |");
            System.out.println("| 12. Thoát                                            |");
            System.out.println("----------------------------------------------");
            System.out.print("Vui lòng nhập lựa chọn của bạn (1->12): ");
            choice = nhap.nextInt();
            switch (choice) {
                case 1:
                    nhapdsnv();
                    break;
                case 2:
                    xuatdsnv();
                    break;
                case 3:
                    them();
                    break;
                case 4:
                    xoaTheoMa();
                    break;
                case 5:
                    timTheoMa();
                    break;
                case 6:
                    timTheoHo();
                    break;
                case 7:
                    timTheoTen();
                    break;
                case 8:
                    suaTheoMa();
                    break;
                case 9:
                    thongKe();
                    break;
                case 10:
                    thongKeLuong();
                    break;
                case 11:
                    thongKeMinMax();
                    break;
                case 12:
                    System.out.println("Bạn chọn thoát");
                    break;
                default:
                    System.out.println("Lưa chọn không hợp lệ (1 -> 12)");
            }
        } while (choice != 12);
    }
}
