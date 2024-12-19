package Constructors;
import List.DSKhachHang;
import List.DanhSachChiTietHoaDon;
import List.DanhSachDienThoai;
import List.DanhSachHoaDon;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ChiTietHoaDon {
    private String mahd;
    private String madt;
    private int soluong;
    private float dongia;
    private float thanhtien;

    public ChiTietHoaDon(){
        this.mahd = null;
        this.madt = null;
        this.soluong = 0;
        this.dongia = 0;
        this.thanhtien = 0;
    }

    public ChiTietHoaDon(String mahd, String madt, int soluong, float dongia, float thanhtien) {
        this.mahd = mahd;
        this.madt = madt;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public ChiTietHoaDon(String mahd, String madt, int soluong, float dongia) {
        this.mahd = mahd;
        this.madt = madt;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = soluong*dongia;
    }

    public ChiTietHoaDon(ChiTietHoaDon a) {
        this.mahd = a.mahd;
        this.madt = a.madt;
        this.soluong = a.soluong;
        this.dongia = a.dongia;
        this.thanhtien = a.thanhtien;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMadt() {
        return madt;
    }

    public void setMadt(String madt) {
        this.madt = madt;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void nhapCTHD(){
        DienThoai[] dsdt = DanhSachDienThoai.getDsdt();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin chi tiết hóa đơn");
        do {
            System.out.print("Mã hóa đơn: ");
            mahd = sc.nextLine();
            if(!DanhSachHoaDon.checkmaHD(mahd)){
                System.out.println("Không tìm thấy mã hóa đơn này, vui lòng nhập lại ");
            }
        }while(!DanhSachHoaDon.checkmaHD(mahd));
        do {
            System.out.print("Mã điện thoại: ");
            madt = sc.nextLine();
            if(!DanhSachDienThoai.checkmaDT(madt)){
                System.out.println("Mã điện thoại không tồn tại, vui lòng nhập lại");
            }
        }while(!DanhSachDienThoai.checkmaDT(madt));
        // Lấy điện thoại trong danh sách bằng mã vừa nhập
        DienThoai dt = DanhSachDienThoai.timKiem_maDT(madt);
        
        boolean quan = true;
        do {
        	quan = true;
            do {
                System.out.print("Số lượng: ");
                soluong = sc.nextInt();
                sc.nextLine();
                if(soluong == 0 || soluong < 0){
                    System.out.println("Số lượng không hợp lệ, vui lòng nhập lại");
                }
            }while(soluong == 0 || soluong < 0);
            
            // Kiểm tra số lượng điện thoại trong cửa hàng
            if(dt != null) {
            	if(dt.getSoluong() == 0) {
            		System.out.println("Số lượng điện thoại còn trong kho đã hết, hủy thao tác tạo chi tiết hóa đơn ");
                    quan = false;
                    this.mahd = null;
                    return;
            	}
            	else if(dt.getSoluong() < this.soluong) {
            		System.out.println("Số lượng điện thoại còn trong kho không đủ, chỉ còn "+dt.getSoluong()+" chiếc, vui lòng nhập số lượng khác ");
            		quan = false;
            	}
            }
        } while(!quan);
        
        // Cập nhật số lượng điện thoại
        this.dongia = dt.getDongia();
        this.thanhtien = soluong * dongia;
        dt.setSoluong(dt.getSoluong() - this.soluong);

        // Cập nhật tổng tiền hóa đơn
        HoaDon hd = DanhSachHoaDon.timTheoMaHD(this.mahd);
        hd.setTongTien(hd.getTongTien() + this.thanhtien);
        
        // Cập nhật tổng tiền khách hàng
        KhachHang kh = DSKhachHang.timkiemMaKH(DanhSachHoaDon.timMaKH(this.mahd));
        kh.setTongtien(kh.getTongtien() + this.thanhtien);
    }

    public void xuatCTHD() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        // Cập nhật định dạng cho bảng
        String format = "| %-15s | %-15s | %-10s | %-15s | %-20s |\n";
        System.out.format("+-----------------+-----------------+------------+-----------------+----------------------+\n");
        // In thông tin chi tiết hoá đơn
        System.out.format(format, mahd, madt, soluong, df.format(dongia), df.format(thanhtien));
        System.out.format("+-----------------+-----------------+------------+-----------------+----------------------+\n");
    }


}
