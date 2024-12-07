package List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import Constructors.ChiTietPhieuNhap;
import Constructors.DienThoai;
import Constructors.DienThoaiPhim;
import Constructors.DienThoaiThongMinh;
import Constructors.PhieuNhap;
import Interfaces.InterfaceDocGhi;
import Run.main;

public class DanhSachCTPN implements InterfaceDocGhi{
	private static ChiTietPhieuNhap[] dsctpn;
	
	Scanner sc = new Scanner(System.in);

	public DanhSachCTPN() {
		this.dsctpn = new ChiTietPhieuNhap[0];
	}
	
	public DanhSachCTPN(ChiTietPhieuNhap[] ctpn) {
		this.dsctpn = ctpn;
	}
	
	
	public static ChiTietPhieuNhap[] getDsctpn() {
		return dsctpn;
	}

	public void setDsctpn(ChiTietPhieuNhap[] dsctpn) {
		this.dsctpn = dsctpn;
	}
	
	// Kiểm tra trùng mã đt trong 1 phiếu nhập 
	//+ Kiểm tra mã đt có tồn tại trong danh sách điện thoại
	public ChiTietPhieuNhap kiemTraMaDT(ChiTietPhieuNhap ctpn) {
		// Kiểm tra trùng mã điệnt hoại trong 1 phiếu nhập
		boolean trungMa;
		do {
			trungMa = false;
			for(int i = 0; i < dsctpn.length; i++) {
				if(dsctpn[i] != null && dsctpn[i].getMaPN().equals(ctpn.getMaPN())) {
					if(dsctpn[i].getMaDT().equals(ctpn.getMaDT())) {
						trungMa = true;
					}
				}
			}
			
			if(trungMa) {
				System.out.print("Mã điện thoại nhập bị trùng trong phiếu nhập: " 
						+ ctpn.getMaPN() + ", vui lòng nhập lại: ");
				String maDT = sc.nextLine();
				ctpn.setMaDT(maDT);
			}
		} while (trungMa);
		
		// Kiểm tra mã đt có tồn tại trong danh sách điện thoại
		DienThoai[] dsdt = DanhSachDienThoai.getDsdt();
		do {
			for(int i = 0 ; i < dsdt.length; i++) {
				if(ctpn.getMaDT().equals(dsdt[i].getMaDT())) {
					trungMa = true;
				}
			}
			if(!trungMa) {
				System.out.print("Mã điện thoại \"" + ctpn.getMaDT() 
				+ "\" không tồn tại trong danh sách, vui lòng nhập lại:");
				String maDT = sc.nextLine();
				ctpn.setMaDT(maDT);
			}
		}while(!trungMa);
		return ctpn;
	}
	
	// Hàm kiểm tra mã phiếu nhập đã có chưa (nếu chưa có nhập lại mã phiếu nhập)
	// Trả về mã phiếu nhập 
	public String kiemTraMaPN(String maPN) {
		PhieuNhap[] pn = DanhSachPhieuNhap.getDspn();
		while(true) {
			for(int i = 0; i < pn.length; i++) {
				if(maPN.equals(pn[i].getMaPN())) {
					return maPN;
				}
			}
			System.out.print("Mã phiếu nhập không tồn tại, vui lòng nhập lại mã phiếu nhập: ");
			maPN = sc.nextLine();
		}
	}
	
	// Hàm kiểm tra khi nhập vào số lượng điện thoại không được quá số lượng đang có trong cửa hàng
	public void kiemTraSoLuongDT (ChiTietPhieuNhap ctpn) {
		DienThoai[] dsdt = DanhSachDienThoai.getDsdt();
		for(int i = 0; i < dsdt.length; i++) {
			if(ctpn.getMaDT().equals(dsdt[i].getMaDT())) {
				while(ctpn.getSoluong() > dsdt[i].getSoluong()) {
					System.out.print("Số lượng điện thoại \"" + dsdt[i].getTenDT() 
							+ "\" trong cửa hàng không đủ (" + dsdt[i].getSoluong() 
							+ "), vui lòng nhập lại số lượng: ");
					int soLuong = sc.nextInt();
					ctpn.setSoluong(soLuong);
				}
			}
		}
	}
	
	public void nhap() {
		System.out.println("Nhập số lượng chi tiết phiếu nhập: ");
		int n = sc.nextInt();
		sc.nextLine();
		dsctpn = new ChiTietPhieuNhap[n];
		for(int i = 0; i < n; i++) {
			ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
			ctpn.nhap();
			ctpn.setMaPN(kiemTraMaPN(ctpn.getMaPN()));
			ctpn = kiemTraMaDT(ctpn);
			kiemTraSoLuongDT(ctpn);
			dsctpn[i] = ctpn;
			PhieuNhap pn = DanhSachPhieuNhap.timMaPhieu(ctpn.getMaPN());
			if(pn != null) {
				pn.tinhTong();
			}
		}
	}
	
	
	public void them_K_CTPN() {
		System.out.println("Nhập số lượng cần thêm: ");
		int k = sc.nextInt();
		sc.nextLine();
		int n = dsctpn.length;
		
		for(int i = n; i < n + k; i++) {
			dsctpn = Arrays.copyOf(dsctpn, i + 1);
			ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
			ctpn.nhap();
			ctpn.setMaPN(kiemTraMaPN(ctpn.getMaPN()));
			ctpn = kiemTraMaDT(ctpn);
			kiemTraSoLuongDT(ctpn);
			dsctpn[i] = ctpn;
			PhieuNhap pn = DanhSachPhieuNhap.timMaPhieu(ctpn.getMaPN());
			if(pn != null) {
				pn.tinhTong();
			}
		}
	}
	
	public void xuatDS() {
		String format = "| %-10s | %-10s | %-10s | %-15s | %-15s |\n";
		System.out.format("+---------------+------------+------------+-----------------+-----------------+\n");
		System.out.format(format, "Mã phiếu nhập", "Mã ĐT", "Số lượng", "Đơn giá", "Thành tiền");
		System.out.format("+---------------+------------+------------+-----------------+-----------------+\n");
		for(int i = 0; i < dsctpn.length; i++) {
			dsctpn[i].xuat();
		}
		System.out.format("+---------------+------------+------------+-----------------+-----------------+\n");
	}
	
	public int timKiemCTPN() {		// Mã phiếu nhập + mã điện thoại
		System.out.println("Nhập mã phiếu nhập và mã điện thoại: ");
		System.out.print("Mã phiếu nhập: ");
		String maPN = sc.nextLine();
		System.out.print("Mã điện thoại: ");
		String maDT = sc.nextLine();
		for(int i = 0; i < dsctpn.length; i++) {
			if(dsctpn[i].getMaPN().equals(maPN) && dsctpn[i].getMaDT().equals(maDT)) {
				return i;
			}
		}
		return -1;
	}
	
	public int timKiemCTPN(String maPN, String maDT) {		// Mã phiếu nhập + mã điện thoại
		for(int i = 0; i < this.dsctpn.length; i++) {
			if(dsctpn[i].getMaPN().equals(maPN) && dsctpn[i].getMaDT().equals(maDT)) {
				return i;
			}
		}
		return -1;
	}
	
	public void xoaCTPN() {
		System.out.println("------Xóa chi tiết phiếu nhập------");
		int index = timKiemCTPN();
		if(index != -1) {
			System.out.println("Đã xóa chi tiết phiếu nhập \"" + dsctpn[index].getMaPN() 
					+ "\" chứa mã điện thoại: " + dsctpn[index].getMaDT() + "\n");
			for(int i = index; i < dsctpn.length - 1; i++) {
				dsctpn[i] = dsctpn[i + 1];
			}
			dsctpn = Arrays.copyOf(dsctpn, dsctpn.length - 1);
			
		}
		else {
			System.out.println("Không tìm thấy chi tiết phiếu nhập!");
		}
	}

	public void suaCTPN() {
		System.out.print("Nhập mã phiếu nhập và mã điện thoại của CTPN cần sửa: ");
		String maPN = sc.nextLine();
		String maDT = sc.nextLine();
		int index = timKiemCTPN(maPN, maDT);
		if(index == -1) {
			System.out.println("Không tìm thấy CTPN với mã PN: " + maPN + " , mã điện thoại: " + maDT);
		}
		else {
			int luaChon;
			do {
				System.out.println("---Sửa thông CTPN---");
				System.out.println("1.Mã điện thoại");
				System.out.println("2.Số lượng điện thoại.");
				System.out.println("0.Thoát.");
				System.out.println("---");
				System.out.print("Nhập lựa chọn: ");
				luaChon = sc.nextInt();
				sc.nextLine();
				
				switch (luaChon) {
				case 1: {
					System.out.print("Nhập mã điện thoại mới: ");
					ChiTietPhieuNhap ctpn = dsctpn[index];
					String ma = sc.nextLine();
					ctpn.setMaDT(ma);
					ctpn = kiemTraMaDT(ctpn);
					dsctpn[index].setMaDT(ctpn.getMaDT());
					break;
				}
				case 2: {
					System.out.print("Nhập số lượng điện thoại mới: ");
					int soluong = sc.nextInt();
					sc.nextLine();
					kiemTraSoLuongDT(dsctpn[index]);
					dsctpn[index].setSoluong(soluong);
					break;
				}
				case 0: {
					System.out.println("Thoát.");
					break;
				}
				default:
					System.out.println("Lựa chọn không hợp lệ.");
				}
			} while (luaChon != 0);
		}
	}
	
	
	public void thongke_maDT() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < dsctpn.length; i++) {
			String maDT = dsctpn[i].getMaDT();
			int soLuong = dsctpn[i].getSoluong();
			
			map.put(maDT, map.getOrDefault(maDT, 0) + soLuong);
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
		    System.out.println("Mã điện thoại: " + entry.getKey() + ", Tổng số lượng: " + entry.getValue());
		}
	}
	
	@Override
	public void docFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/data/DanhSachCTPN.txt"));
			String line;
			int n = 0;
			while((line = reader.readLine()) != null) {
				String[] detail = line.split(";");
				
				String maPN = detail[0];
				String maDT = detail[1];
				int soluong = Integer.parseInt(detail[2]);
				float dongia = Float.parseFloat(detail[3]);
				float thanhtien = Float.parseFloat(detail[4]);
				
				ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(maPN, maDT, soluong, dongia, thanhtien);
				
				dsctpn = Arrays.copyOf(dsctpn, n + 1);
				dsctpn[n++] = ctpn;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ghiFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/DanhSachCTPN.txt"));
			
			for (ChiTietPhieuNhap chiTietPhieuNhap : dsctpn) {
				String data = chiTietPhieuNhap.getMaPN() + ";" + chiTietPhieuNhap.getMaDT()
				+ ";" + chiTietPhieuNhap.getSoluong() + ";" + chiTietPhieuNhap.getDongia()
				+ ";" + chiTietPhieuNhap.getThanhtien() + "\n";
				
				writer.write(data);
			}
			writer.close();
			System.out.println("Đã ghi dữ liệu của danh sách chi tiết phiếu nhập!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DanhSachDienThoai dsdt = new DanhSachDienThoai();
		dsdt.docFile();
		DanhSachPhieuNhap dspn = new DanhSachPhieuNhap();
		dspn.docFile();
		
		DanhSachCTPN dsctpn = new DanhSachCTPN();
		dsctpn.them_K_CTPN();
		System.out.println("finish");
	}
	
	
}
