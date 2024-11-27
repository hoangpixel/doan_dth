package List;
import Constructors.KhachHang;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author winan
 */
public class DSKhachHang {
    private KhachHang[] kh;
    
    public DSKhachHang(int n){
        this.kh = new KhachHang[n];
    }
    
    public DSKhachHang(){
        this.kh = new KhachHang[0];
    }
    
    public DSKhachHang(DSKhachHang a){
        this.kh = a.kh;
    }
    
    public DSKhachHang(KhachHang[] a){
        this.kh = a;
    }

    public KhachHang[] getKh() {
        return kh;
    }

    public void setKh(KhachHang[] kh) {
        this.kh = kh;
    }
    
    public int length(){
        return kh.length;
    }
    
    public static String taoMaKH(int so) {
        return "KH" + so;
    }
    
    public String taoMaKH() {
    int maxNumber = 0; 
    for (KhachHang khach : kh) { 
        if (khach != null) { 
            String id = khach.getMakh(); 
            int number = Integer.parseInt(id.replaceAll("\\D", "")); 
            if (number > maxNumber) {
                maxNumber = number; 
            }
        }
    }
    return "KH" + (maxNumber + 1); 
}
    
    public void nhapKH(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng khách hàng muốn thêm: ");
        int quan = sc.nextInt();
        for( int i = 0; i < quan; i++){
            kh = Arrays.copyOf(kh, kh.length + 1);
            KhachHang a = new KhachHang("KH" + (i+1));
            a.nhapKH();
            kh[i] = a;
        }
    }
    
    public void themKH(){
        kh = Arrays.copyOf(kh, kh.length + 1);
        System.out.println("Nhập thông tin của khách hàng mới: ");
        KhachHang a = new KhachHang();
        a.setMakh(taoMaKH());
        a.nhapKH();
        System.out.println("Kiểm tra thông tin của khách hàng: ");
        a.xuat();
        kh[kh.length - 1] = a;
    }
    
    public void themKH(KhachHang a) {
    kh = Arrays.copyOf(kh, kh.length + 1); 
    kh[kh.length - 1] = a; 
}

    
    public void xemDSKH(){
        System.out.println("Thông tin của tất cả khách hàng: ");
        for (KhachHang kh1 : kh) {
            kh1.xuat();
        }
    }
    
    public void xoaKH() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập SDT khách hàng cần xóa: ");
        String sdt = sc.nextLine();      
        for (int i = 0; i < kh.length; i++) {
            if (kh[i].getSdt().equals(sdt)) {
                for (int j = i; j < kh.length - 1; j++) {
                    kh[j] = kh[j + 1];
                }
                kh = Arrays.copyOf(kh, kh.length - 1);  
                System.out.println("Xóa khách hàng thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng với SDT: " + sdt);
    }
         
    public void suaKH(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập SDT khách hàng: ");
        String sdt_temp = sc.nextLine();
        for (int i = 0; i < kh.length; i++){
            if((kh[i].getSdt()).equals(sdt_temp)){
            KhachHang a = new KhachHang(kh[i]);
            a.xuat();
            System.out.println("1. Sửa tên khách hàng");
            System.out.println("2. Sửa số điện thoại khách hàng");
            System.out.println("3. Sửa tổng tiền của khách hàng");
            System.out.println("\tVui lòng chọn thao tác sửa khách hàng");
            int choice;
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Nhập lại tên khách hàng");
                    String ten_moi = sc.nextLine();
                    a.setTenkh(ten_moi);
                    kh[i] = a;
                    System.out.println("Chỉnh sửa tên khách hàng thành công");
                    kh[i].xuat();
                    break;
                case 2:
                    System.out.println("Nhập lại số điện thoại khách hàng");
                    String sdt_moi = sc.nextLine();
                    a.setSdt(sdt_moi);
                    kh[i] = a;
                    System.out.println("Chỉnh sửa số điện thoại khách hàng thành công");
                    kh[i].xuat();
                    break;
                 case 3:
                    System.out.println("Nhập tổng tiền của khách hàng");
                    float tien_moi = sc.nextFloat();
                    a.setTongtien(tien_moi);
                    kh[i] = a;
                    System.out.println("Chỉnh sửa tổng tiền của khách hàng thành công");
                    kh[i].xuat();
                    break;
                }
            } else {
                System.out.println("Không tìm thấy khách hàng");
            }
        }
    }
        
    
    public void timkiemSDT(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập SDT khách hàng: ");
        String sdt_temp = sc.nextLine();
        for (int i = 0; i < kh.length; i++){
            if((kh[i].getSdt()).equals(sdt_temp)){
            kh[i].xuat();
            return ;
            }
        }
        System.out.println("Không tìm thấy khách hàng");
    }
    
    public void timkiemMA(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng: ");
        String ma_temp = sc.nextLine();
        for (int i = 0; i < kh.length; i++){
            if((kh[i].getMakh()).equals(ma_temp)){
            kh[i].xuat();
            return ;
            }
        }
        System.out.println("Không tìm thấy khách hàng");
    }
    
    public void timkiemTEN(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng: ");
        String ten_temp = sc.nextLine();
        for (int i = 0; i < kh.length; i++){
            if((kh[i].getTenkh()).equals(ten_temp)){
            kh[i].xuat();
            return ;
            }
        }
        System.out.println("Không tìm thấy khách hàng");
    }
    
    public void thongKeKhachHang() {
    int soLuongKhachHang = 0; 
    float tongTien = 0;
    for (KhachHang khach : kh) {
        if (khach != null) {
            soLuongKhachHang++;
            tongTien += khach.getTongtien(); 
        }
    }
    System.out.println("Tổng số khách hàng: " + soLuongKhachHang);
    System.out.println("Tổng tiền của tất cả khách hàng: " + tongTien + " VNĐ");
}
    
    public void docFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            // Tách thông tin từ dòng đọc được
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String maKH = parts[0].trim();
                String tenKH = parts[1].trim();
                String sdt = parts[2].trim();
                float tongTien = Float.parseFloat(parts[3].trim());

                // Tạo đối tượng KhachHang
                KhachHang khach = new KhachHang(maKH, tenKH, sdt, tongTien);

                // Thêm khách hàng vào danh sách
                kh = Arrays.copyOf(kh, kh.length + 1);
                kh[kh.length - 1] = khach;
            } else {
                System.out.println("Dòng dữ liệu không hợp lệ: " + line);
            }
        }
    } catch (IOException e) {
        System.out.println("Lỗi đọc file: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Lỗi định dạng số: " + e.getMessage());
    }
}
    public void xuatFile(String filePath) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
        for (KhachHang khach : kh) {
            if (khach != null) { // Kiểm tra khách hàng không null
                // Ghi thông tin khách hàng theo định dạng
                String line = khach.getMakh() + "," + 
                              khach.getTenkh() + "," + 
                              khach.getSdt() + "," + 
                              khach.getTongtien();
                bw.write(line);
                bw.newLine(); // Xuống dòng
            }
        }
        System.out.println("Xuất file thành công!");
    } catch (IOException e) {
        System.out.println("Lỗi ghi file: " + e.getMessage());
    }
}
public String[] layDanhSachMaKh() {
        String[] ma = new String[kh.length];
        for (int i = 0; i < kh.length; i++) {
            ma[i] = kh[i].getMakh();
        }
        return ma;
}
     public void menu() {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("-----------------Quản lý khách hàng------------------");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Sửa thông tin khách hàng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Hiển thị tất cả khách hàng");
            System.out.println("5. Thoát");
            System.out.print("Chọn thao tác (1-5): ");
            
            int choice = sc.nextInt();
            sc.nextLine();  // Đọc dòng thừa sau khi nextInt()
            
            switch(choice) {
                case 1:
                    themKH();  // Gọi hàm thêm khách hàng
                    break;
                case 2:
                    suaKH();  // Gọi hàm sửa khách hàng
                    break;
                case 3:
                    xoaKH();  // Gọi hàm xóa khách hàng
                    break;
                case 4:
                    xemDSKH();  // Gọi hàm hiển thị danh sách khách hàng
                    break;
                case 5:
                    System.out.println("Thoát khỏi chương trình.");
                    return;  // Thoát khỏi vòng lặp và kết thúc chương trình
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
    
    public static void main(String[] args){
        DSKhachHang kh = new DSKhachHang();
        String filePath = "src/data/danhsachkhachhang.txt";
        kh.docFile(filePath);
        kh.menu();
    }
}
