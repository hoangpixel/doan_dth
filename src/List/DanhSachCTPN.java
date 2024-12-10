package List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import Constructors.PhieuNhap;
import Constructors.ChiTietPhieuNhap;
import Constructors.DienThoai;
import Constructors.DienThoaiPhim;
import Constructors.DienThoaiThongMinh;
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
	
	// Cập nhật số lượng điện thoại (tăng)
	public void capNhatSoLuong_tang(String maDT, int soLuong) {
		DienThoai[] dsdt = DanhSachDienThoai.getDsdt();
		for(DienThoai dt : dsdt) {
			if(dt.getMaDT().equals(maDT)) {
				dt.setSoluong(dt.getSoluong() + soLuong);
			}
		}
	}
	
	// Cập nhật số lượng điện thoại (giảm)
	public void capNhatSoLuong_giam(String maDT, int soLuong) {
		DienThoai[] dsdt = DanhSachDienThoai.getDsdt();
		for(DienThoai dt : dsdt) {
			if(dt.getMaDT().equals(maDT)) {
				dt.setSoluong(dt.getSoluong() - soLuong);
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
			dsctpn[i] = ctpn;
			PhieuNhap pn = DanhSachPhieuNhap.timMaPhieu(ctpn.getMaPN());
			if(pn != null) {
				pn.tinhTong();
			}
			
			// Cập nhật dsdt tăng
			capNhatSoLuong_tang(ctpn.getMaDT(), ctpn.getSoluong());
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
			dsctpn[i] = ctpn;
			PhieuNhap pn = DanhSachPhieuNhap.timMaPhieu(ctpn.getMaPN());
			if(pn != null) {
				pn.tinhTong();
			}
			// Cập nhật dsdt tăng
			capNhatSoLuong_tang(ctpn.getMaDT(), ctpn.getSoluong());
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
			// Cập nhật dsdt giảm
			capNhatSoLuong_giam(dsctpn[index].getMaDT(), dsctpn[index].getSoluong());
			for(int i = index; i < dsctpn.length - 1; i++) {
				dsctpn[i] = dsctpn[i + 1];
			}
			dsctpn = Arrays.copyOf(dsctpn, dsctpn.length - 1);
			capNhatTongTien();
		}
		else {
			System.out.println("Không tìm thấy chi tiết phiếu nhập!");
		}
	}

	public void suaCTPN() {
		System.out.print("Nhập mã phiếu nhập và mã điện thoại của CTPN cần sửa: ");
		System.out.print("Nhập mã phiếu nhập: ");
		String maPN = sc.nextLine();
		System.out.print("Nhập mã điện thoại: ");
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
					ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(dsctpn[index]);
					String ma = sc.nextLine();
					ctpn.setMaDT(ma);
					ctpn = kiemTraMaDT(ctpn);
					capNhatSoLuong_giam(dsctpn[index].getMaDT(), ctpn.getSoluong());
					dsctpn[index].setMaDT(ctpn.getMaDT());
					capNhatSoLuong_tang(dsctpn[index].getMaDT(), ctpn.getSoluong());
					dsctpn[index].setThanhtien(dsctpn[index].getSoluong() * dsctpn[index].getDongia());
					capNhatTongTien();
					break;
				}
				case 2: {
					System.out.print("Nhập số lượng điện thoại mới: ");
					int soluong = sc.nextInt();
					sc.nextLine();
					capNhatSoLuong_tang(dsctpn[index].getMaDT(), soluong - dsctpn[index].getSoluong());
					dsctpn[index].setSoluong(soluong);
					dsctpn[index].setThanhtien(soluong * dsctpn[index].getDongia());
					capNhatTongTien();
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
	
	
	public void thongke_topSoLuongNhap() {
		System.out.print("Top điện thoại được nhập nhiều nhất: ");
		int n = sc.nextInt();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < dsctpn.length; i++) {
			String maDT = dsctpn[i].getMaDT();
			int soLuong = dsctpn[i].getSoluong();
			
			map.put(maDT, map.getOrDefault(maDT, 0) + soLuong);
		}
		
		// Chuyển HashMap sang danh sách các Entry
	    ArrayList<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

	    // Sắp xếp danh sách theo tổng số lượng giảm dần
	    entryList.sort((a, b) -> b.getValue() - a.getValue());

	    // In ra top n phần tử đầu tiên
	    System.out.println("Top " + n + " điện thoại nhập nhiều nhất:");
	    for (int i = 0; i < Math.min(n, entryList.size()); i++) {
	        Entry<String, Integer> entry = entryList.get(i);
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void capNhatTongTien()
	{
		PhieuNhap[] danhSachPhieuNhap = DanhSachPhieuNhap.getDspn();
		for (PhieuNhap pn : danhSachPhieuNhap) {
			float tongTienMoi = 0;
			for (ChiTietPhieuNhap ctpn : dsctpn) {
				if (ctpn.getMaPN().equals(pn.getMaPN())) {
					tongTienMoi += ctpn.getThanhtien();
				}
			}
			pn.setTongTien(tongTienMoi);
		}
	}
	
}
