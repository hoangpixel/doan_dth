package List;
import Constructors.ChiTietHoaDon;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class DanhSachChiTietHoaDon {
    Scanner sc = new Scanner(System.in);
    private ChiTietHoaDon[] cthd;

    public DanhSachChiTietHoaDon(){
        this.cthd = new ChiTietHoaDon[0];
    }

    public DanhSachChiTietHoaDon(DanhSachChiTietHoaDon a){
        this.cthd = a.cthd;
    }

    public DanhSachChiTietHoaDon(ChiTietHoaDon[] a){
        this.cthd = a;
    }

    public ChiTietHoaDon[] getCthd() {
        return cthd;
    }

    public void setCthd(ChiTietHoaDon[] cthd) {
        this.cthd = cthd;
    }

    public int length(){
        return cthd.length;
    }

    public void add(ChiTietHoaDon a){
        cthd = Arrays.copyOf(cthd, cthd.length + 1);
        cthd[cthd.length - 1] = a;
    }

    public void nhapDSCTHD(){
        System.out.println("Nhập số lượng chi tiết hóa đơn muốn thêm: ");
        int soluong = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < soluong; i++){
            cthd = Arrays.copyOf(cthd, cthd.length + 1);
            ChiTietHoaDon a = new ChiTietHoaDon();
            a.nhapCTHD();
            cthd[i] = a;
        }
    }

    public void themCTHD(){
        System.out.println("Nhập thông tin chi tiết hóa đơn muốn thêm: ");
        cthd = Arrays.copyOf(cthd, cthd.length + 1);
        ChiTietHoaDon a = new ChiTietHoaDon();
        a.nhapCTHD();
        cthd[cthd.length - 1] = a;
    }

    public void themCTHD(ChiTietHoaDon a){
        cthd = Arrays.copyOf(cthd, cthd.length + 1);
        cthd[cthd.length - 1] = a;
    }

    public void xuatDSCTHD() {
        if (cthd.length == 0) {
            System.out.println("Danh sách chi tiết hóa đơn trống.");
        } else {
            String format = "| %-15s | %-15s | %-10s | %-15s | %-20s |\n";
            // In tiêu đề bảng
            System.out.format("+-----------------+-----------------+------------+-----------------+----------------------+\n");
            System.out.format(format, "Mã CTHD", "Mã ĐT", "Số lượng", "Đơn giá", "Thành tiền");
            for (ChiTietHoaDon ct : cthd) {
                ct.xuatCTHD();
            }
        }
    }

    public void xoaCTHD(){
        System.out.println("Xóa chi tiết hóa đơn");
        System.out.println("Nhập mã hóa đơn của chi tiết cần xóa");
        String mahd = sc.nextLine();
        for(ChiTietHoaDon chitiethoadon : cthd){
            if(chitiethoadon.getMahd().equals(mahd)){
                chitiethoadon.xuatCTHD();
            }
        }
        System.out.println("Nhập mã điện thoại của chi tiết cần xóa");
        String madt = sc.nextLine();
        for(int i = 0; i < cthd.length; i++){
            if(cthd[i].getMahd().equals(mahd) && cthd[i].getMadt().equals(madt)){
                for (int j = i; j < cthd.length - 1; j++) {
                    cthd[j] = cthd[j + 1];
                }
                cthd = Arrays.copyOf(cthd, cthd.length - 1);
                System.out.println("Xóa chi tiết hóa đơn thành công thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết hóa đơn với mã điện thoại " + madt);
    }

    public void suaCTHD(){
        System.out.print("Nhập mã hóa đơn của chi tiết cần sửa: ");
        String mahd = sc.nextLine();
        boolean found = false;
        for(ChiTietHoaDon chitiethoadon : cthd){
            if(chitiethoadon.getMahd().equals(mahd)){
                chitiethoadon.xuatCTHD();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy chi tiết hóa đơn với mã hóa đơn đã nhập.");
            return;
        }
        System.out.print("Nhập mã điện thoại cần sửa: ");
        String madt = sc.nextLine();
        for (ChiTietHoaDon chitiethoadon : cthd) {
            if (chitiethoadon.getMahd().equals(mahd) && chitiethoadon.getMadt().equals(madt)) {
                System.out.println("Chi tiết hóa đơn tìm thấy:");
                chitiethoadon.xuatCTHD();
                while (true) {
                    System.out.println("=== Sửa chi tiết hóa đơn ===");
                    System.out.println("Chọn thao tác muốn sửa:");
                    System.out.println("1. Sửa mã hóa đơn");
                    System.out.println("2. Sửa mã điện thoại");
                    System.out.println("3. Sửa số lượng");
                    System.out.println("4. Sửa đơn giá");
                    System.out.println("5. Thoát");
                    System.out.print("Nhập lựa chọn: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.print("Nhập mã hóa đơn mới: ");
                            chitiethoadon.setMahd(sc.nextLine());
                            System.out.println("Sửa mã hóa đơn thành công.");
                            chitiethoadon.xuatCTHD();
                            break;
                        case 2:
                            System.out.print("Nhập mã điện thoại mới: ");
                            chitiethoadon.setMadt(sc.nextLine());
                            System.out.println("Sửa mã điện thoại thành công.");
                            chitiethoadon.xuatCTHD();
                            break;
                        case 3:
                            System.out.print("Nhập số lượng mới: ");
                            chitiethoadon.setSoluong(sc.nextInt());
                            sc.nextLine();
                            chitiethoadon.setThanhtien(chitiethoadon.getSoluong() * chitiethoadon.getDongia());
                            System.out.println("Sửa số lượng thành công.");
                            chitiethoadon.xuatCTHD();
                            break;
                        case 4:
                            System.out.print("Nhập đơn giá mới: ");
                            chitiethoadon.setDongia(sc.nextFloat());
                            sc.nextLine();
                            chitiethoadon.setThanhtien(chitiethoadon.getSoluong() * chitiethoadon.getDongia());
                            System.out.println("Sửa đơn giá thành công.");
                            chitiethoadon.xuatCTHD();
                            break;
                        case 5:
                            System.out.println("Thoát chỉnh sửa.");
                            return;
                        default:
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    }
                }
            }
        }
        System.out.println("Không tìm thấy chi tiết hóa đơn với mã điện thoại đã nhập.");
    }

    public void timkiemMAHD(){
        boolean found = false;
        System.out.print("Nhập mã hóa đơn của chi tiết cần tìm: ");
        String ma = sc.nextLine();
        for( ChiTietHoaDon ct : cthd){
            if(ct.getMahd().equals(ma)){
                ct.xuatCTHD();
                found = true;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy chi tiết có mã hóa đơn cần tìm");
            return;
        }
    }

    public void timkiemMADT(){
        boolean found = false;
        System.out.print("Nhập mã điện thoại của chi tiết cần tìm: ");
        String ma = sc.nextLine();
        for( ChiTietHoaDon ct : cthd){
            if(ct.getMadt().equals(ma)){
                ct.xuatCTHD();
                found = true;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy chi tiết có mã điện thoại cần tìm");
            return;
        }
    }

    public void timkiemMAHDDT(){
        boolean found = false;
        System.out.print("Nhập mã hóa đơn của chi tiết cần tìm: ");
        String ma = sc.nextLine();
        for( ChiTietHoaDon ct : cthd){
            if(ct.getMahd().equals(ma)){
                ct.xuatCTHD();
                found = true;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy chi tiết có mã hóa đơn cần tìm");
            return;
        }
        found = false;
        System.out.print("Nhập mã điện thoại của chi tiết cần tìm: ");
        ma = sc.nextLine();
        for( ChiTietHoaDon ct : cthd){
            if(ct.getMadt().equals(ma)){
                ct.xuatCTHD();
                found = true;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy chi tiết có mã điện thoại cần tìm");
            return;
        }
    }

    public void menu(){
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Nhập danh sách chi tiết hóa đơn mới(khi chưa có chi tiết hóa đơn nào)");
            System.out.println("2. Thêm một chi tiết hóa đơn");
            System.out.println("3. Sửa chi tiết hóa đơn");
            System.out.println("4. Xóa chi tiết hóa đơn");
            System.out.println("5. Tìm kiếm theo mã hóa đơn");
            System.out.println("6. Tìm kiếm theo mã điện thoại");
            System.out.println("7. Tìm kiếm với mã hóa đơn và mã điện thoại");
            System.out.println("8. Xem danh sách chi tiết hóa đơn");
            System.out.println("9. Thoát");
            System.out.print("Chọn thao tác (1-9): ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    nhapDSCTHD();
                    break;
                case 2:
                    themCTHD();
                    break;
                case 3:
                    suaCTHD();
                    break;
                case 4:
                    xoaCTHD();
                    break;
                case 5:
                    timkiemMAHD();
                    break;
                case 6:
                    timkiemMADT();
                    break;
                case 7:
                    timkiemMAHDDT();
                    break;
                case 8:
                    xuatDSCTHD();
                    break;
                case 9:
                    System.out.println("Thoát khỏi chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public void ghiFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ChiTietHoaDon cthd : cthd) {
                writer.write(cthd.getMahd() + "," + cthd.getMadt() + "," + cthd.getSoluong() + ","
                        + cthd.getDongia() + "," + cthd.getThanhtien());
                writer.newLine();
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void docFile(String filePath) {
        ChiTietHoaDon[] danhSach = new ChiTietHoaDon[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String mahd = parts[0];
                    String madt = parts[1];
                    int soluong = Integer.parseInt(parts[2]);
                    float dongia = Float.parseFloat(parts[3]);
                    float thanhtien = Float.parseFloat(parts[4]);
                    danhSach = Arrays.copyOf(danhSach, danhSach.length + 1);
                    danhSach[danhSach.length - 1] = new ChiTietHoaDon(mahd, madt, soluong, dongia, thanhtien);
                }
            }
            this.cthd = danhSach;
            System.out.println("Đọc file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Dữ liệu trong file không hợp lệ: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        DanhSachChiTietHoaDon cthd = new DanhSachChiTietHoaDon();
        cthd.docFile("dschitiethoadon.txt");
        cthd.menu();
    }
}
