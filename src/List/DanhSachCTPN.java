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
import Constructors.DienThoaiPhim;
import Constructors.DienThoaiThongMinh;
import Interfaces.InterfaceDocGhi;

public class DanhSachCTPN implements InterfaceDocGhi{
	private ChiTietPhieuNhap[] dsctpn;
	
	Scanner sc = new Scanner(System.in);

	public DanhSachCTPN() {
		this.dsctpn = new ChiTietPhieuNhap[0];
	}
	
	public DanhSachCTPN(ChiTietPhieuNhap[] ctpn) {
		this.dsctpn = ctpn;
	}
	
	
	public ChiTietPhieuNhap[] getDsctpn() {
		return dsctpn;
	}

	public void setDsctpn(ChiTietPhieuNhap[] dsctpn) {
		this.dsctpn = dsctpn;
	}
	
	public ChiTietPhieuNhap kiemTraTrungMaDT(ChiTietPhieuNhap ctpn) {
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
		return ctpn;
	}
	
	
	public void nhap() {
		System.out.println("Nhập số lượng chi tiết phiếu nhập: ");
		int n = sc.nextInt();
		dsctpn = new ChiTietPhieuNhap[n];
		for(int i = 0; i < n; i++) {
			ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
			ctpn.nhap();
			ctpn = kiemTraTrungMaDT(ctpn);
			dsctpn[i] = ctpn;
			
		}
	}
	
	
	public void them_K_CTPN() {
		System.out.println("Nhập số lượng cần thêm: ");
		int k = sc.nextInt();
		int n = dsctpn.length;
		Arrays.copyOf(dsctpn, n + k);
		for(int i = n; i < dsctpn.length; i++) {
			ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
			ctpn.nhap();
			ctpn = kiemTraTrungMaDT(ctpn);
			dsctpn[n] = ctpn;
		}
	}
	
	public void xuatDS() {
		for(int i = 0; i < dsctpn.length; i++) {
			System.out.println("--------");
			dsctpn[i].xuat();
		}
	}
	
	public int timKiemCTPN() {		// Mã phiếu nhập + mã điện thoại
		System.out.println("Nhập mã phiếu nhập và mã điện thoại: ");
		String maPN = sc.nextLine();
		String maDT = sc.nextLine();
		for(int i = 0; i < this.dsctpn.length; i++) {
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
		System.out.println("Nhập mã phiếu nhập và mã điện thoại: ");
		if(timKiemCTPN() != -1) {
			for(int i = this.timKiemCTPN(); i < dsctpn.length - 1; i++) {
				dsctpn[i] = dsctpn[i + 1];
			}
			Arrays.copyOf(dsctpn, dsctpn.length - 1);
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
					ctpn = kiemTraTrungMaDT(ctpn);
					dsctpn[index].setMaDT(ctpn.getMaDT());
					break;
				}
				case 2: {
					System.out.print("Nhập số lượng điện thoại mới: ");
					int soluong = sc.nextInt();
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
	
	
}
