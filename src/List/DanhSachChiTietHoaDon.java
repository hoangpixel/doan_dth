package List;
import List.*;
import Constructors.*;
import Interfaces.InterfaceDocGhi;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class DanhSachChiTietHoaDon implements InterfaceDocGhi{
    Scanner sc = new Scanner(System.in);
    private static ChiTietHoaDon[] cthd;

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

    public static ChiTietHoaDon[] getDscthd() {
		return cthd;
    }
    
    public void add(ChiTietHoaDon a){
        cthd = Arrays.copyOf(cthd, cthd.length + 1);
        cthd[cthd.length - 1] = a;
    }

    public int kiemtraSL(String madt){
        DienThoai[] dt = DanhSachDienThoai.getDsdt();
        for(DienThoai a :dt){
            if(a.getMaDT().equals(madt)){
                return a.getSoluong();
            }
        }
        return 0;
    }

    public void giamslDT(String madt, int sl){
        DienThoai[] dt = DanhSachDienThoai.getDsdt();
        for(DienThoai a :dt){
            if(a.getMaDT().equals(madt)){
                a.setSoluong(a.getSoluong() - sl);
            }
        }
    }

    public static void tangslDT(String madt, int sl){
        DienThoai[] dt = DanhSachDienThoai.getDsdt();
        for(DienThoai a :dt){
            if(a.getMaDT().equals(madt)){
                a.setSoluong(a.getSoluong() + sl);
            }
        }
    }

    public float getDonGia(String madt){
        DienThoai[] dt = DanhSachDienThoai.getDsdt();
        for(DienThoai a :dt){
            if(a.getMaDT().equals(madt)){
                return a.getDongia();
            }
        }
        return 0;
    }

    public void thaydoitienHD(String mahd){
        HoaDon[] dshd = DanhSachHoaDon.getDshd();
        for(HoaDon hd :dshd){
            float tongtien = 0;
            if(hd.getMaHd().equals(mahd)){
                for(ChiTietHoaDon ct :cthd){
                    if(ct.getMahd().equals(hd.getMaHd())){
                        tongtien += ct.getThanhtien();
                    }
                }
                hd.setTongTien(tongtien);
            }
        }
    }

    public static void thaydoitienKH(String mahd){
        float tongtien = 0;
        KhachHang[] dskh = DSKhachHang.getdskh();
        HoaDon[] dshd = DanhSachHoaDon.getDshd();
        for(KhachHang kh :dskh){
            for(HoaDon hd :dshd){
                if(hd.getMaKh().equals(kh.getMakh())){
                    tongtien += hd.getTongTien();
                }
            }
            kh.setTongtien(tongtien);
        }
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
        ChiTietHoaDon a = new ChiTietHoaDon();
        a.nhapCTHD();
        if(a.getMahd() != null) {
        	cthd = Arrays.copyOf(cthd, cthd.length + 1);
        	cthd[cthd.length - 1] = a;
        }
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
        String mahd_temp;
        for(int i = 0; i < cthd.length; i++){
            if(cthd[i].getMahd().equals(mahd) && cthd[i].getMadt().equals(madt)){
                tangslDT(cthd[i].getMadt(), cthd[i].getSoluong());
                mahd_temp = cthd[i].getMahd();
                for (int j = i; j < cthd.length - 1; j++) {
                    cthd[j] = cthd[j + 1];
                }
                cthd = Arrays.copyOf(cthd, cthd.length - 1);
                thaydoitienHD(mahd_temp);
                thaydoitienKH(mahd_temp);
                System.out.println("Xóa chi tiết hóa đơn thành công thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết hóa đơn với mã điện thoại " + madt);
    }
	
	public static void xoaCTHD(String ma_hd){
        do{
            if(timTheoMa(ma_hd)!=-1){
                int position=timTheoMa(ma_hd);
                tangslDT(cthd[position-1].getMadt(), cthd[position-1].getSoluong());
		thaydoitienKH(ma_hd);
                for(int i=position-1; i<cthd.length-1; i=i+1){
                    cthd[i]=cthd[i+1];
                }
                cthd=Arrays.copyOf(cthd, cthd.length-1);
        }
        }while(timTheoMa(ma_hd)!=-1);
    }
    
    public static int timTheoMa(String ma){
    for(int i=0; i<cthd.length; i=i+1)
        if(cthd[i].getMahd().equals(ma))
            return i+1;
    return -1;
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
                    System.out.println("1. Sửa mã điện thoại");
                    System.out.println("2. Sửa số lượng");
                    System.out.println("3. Thoát");
                    System.out.print("Nhập lựa chọn: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            tangslDT(chitiethoadon.getMadt(), chitiethoadon.getSoluong());
                            System.out.print("Nhập mã điện thoại mới: ");
                            chitiethoadon.setMadt(sc.nextLine());
                            giamslDT(chitiethoadon.getMadt(), chitiethoadon.getSoluong());
                            chitiethoadon.setDongia(getDonGia(chitiethoadon.getMadt()));
                            chitiethoadon.setThanhtien(chitiethoadon.getDongia()* chitiethoadon.getSoluong());
                            thaydoitienHD(chitiethoadon.getMahd());
                            thaydoitienKH(chitiethoadon.getMahd());
                            System.out.println("Sửa mã điện thoại thành công.");
                            chitiethoadon.xuatCTHD();
                            break;
                        case 2:
                            tangslDT(chitiethoadon.getMadt(), chitiethoadon.getSoluong());
                            boolean quan = true;
                            int soLuong = -1;
                            do {
                            	quan = true;
                            	System.out.print("Nhập số lượng mới: ");
                            	soLuong = sc.nextInt();
                            	sc.nextLine();
                            	DienThoai[] dsdt = DanhSachDienThoai.getDsdt();
                            	for(DienThoai a : dsdt) {
                            		if(a.getMaDT().equals(chitiethoadon.getMadt()) && a.getSoluong()<soLuong){
                            			System.out.println("Số lượng điện thoại còn trong kho không đủ, chỉ còn "+a.getSoluong()+" chiếc, vui lòng nhập số lượng khác ");
                            			quan = false;
                            		}
                            	}
                            }while(!quan);
                            chitiethoadon.setSoluong(soLuong);
                            chitiethoadon.setThanhtien(chitiethoadon.getSoluong() * chitiethoadon.getDongia());
                            thaydoitienHD(chitiethoadon.getMahd());
                            thaydoitienKH(chitiethoadon.getMahd());
                            giamslDT(chitiethoadon.getMadt(), chitiethoadon.getSoluong());
                            System.out.println("Sửa số lượng thành công.");
                            chitiethoadon.xuatCTHD();
                            break;
                        case 3:
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

    public void ghiFile() {
    	String filePath = "src/data/danhsachchitiethoadon.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ChiTietHoaDon ct : cthd) {
                writer.write(ct.getMahd() + "," + ct.getMadt() + "," + ct.getSoluong() + ","
                        + ct.getDongia() + "," + ct.getThanhtien());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void docFile() {
    	String filePath = "src/data/danhsachchitiethoadon.txt";
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

        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Dữ liệu trong file không hợp lệ: " + e.getMessage());
        }
    }
}
