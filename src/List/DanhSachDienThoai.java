package List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

import Constructors.DienThoai;
import Constructors.DienThoaiPhim;
import Constructors.DienThoaiThongMinh;
import Interfaces.InterfaceDocGhi;

public class DanhSachDienThoai implements InterfaceDocGhi{
	private static DienThoai[] dsdt;
	
	Scanner sc = new Scanner(System.in);
	
	public DanhSachDienThoai() {
		dsdt = new DienThoai[0];
	}
	
	public DanhSachDienThoai(DienThoai[] dsdt) {
		this.dsdt = dsdt;
	}
	
	public DanhSachDienThoai(DanhSachDienThoai dsdt) {
		this.dsdt = dsdt.getDsdt();
	}

	public static DienThoai[] getDsdt() {
		return dsdt;
	}

	public void setDsdt(DienThoai[] dsdt) {
		this.dsdt = dsdt;
	}
	
	public static int laySoLuongTonKho() {
		int tong = 0;
		for(int i = 0; i < dsdt.length; i++) {
			tong += dsdt[i].getSoluong();
		}
		return tong;
	}
	
	public static float getDonGia(String maDT) {
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i].getMaDT().equals(maDT)) {
				return dsdt[i].getDongia();
			}
		}
		return 0;
	}
	
	public DienThoai kiemTraTrungMaDT(DienThoai dt) {
		boolean trungMa;
		do {
			trungMa = false;
			for(int i = 0; i < dsdt.length; i++) {
				if(dsdt[i] != null && dsdt[i].getMaDT().equals(dt.getMaDT())) {
					trungMa = true;
					break;
				}
			}
			if(trungMa) {
				System.out.print("Mã điện thoại nhập bị trùng, vui lòng nhập lại: ");
				String maDT = sc.nextLine();
				dt.setMaDT(maDT);
			}
		} while (trungMa);
		return dt;
	}
	
	public void nhap_1_DienThoai() {
		
		// Tao them 1 phan tu trong danh sach
		int n = dsdt.length;
		dsdt = Arrays.copyOf(dsdt, n + 1);
		System.out.println("---Nhập điện thoại---");
		System.out.println("1. Nhập điện thoại thông minh."
						+ "\n2.Nhập điện thoại phím.");
		int luaChon = sc.nextInt();
		sc.nextLine();
		switch (luaChon) {
			case 1: {
				DienThoaiThongMinh dttm = new DienThoaiThongMinh();
				dttm.nhap();
				dttm = (DienThoaiThongMinh) kiemTraTrungMaDT((DienThoai) dttm);
				dsdt[n] = dttm;
				break;
			}
			case 2: {
				DienThoaiPhim dtp = new DienThoaiPhim();
				dtp.nhap();
				dtp = (DienThoaiPhim) kiemTraTrungMaDT(dtp);
				dsdt[n] = dtp;
				break;
			}
		}
	}
	
	public void nhap_n_DienThoai() {
		//Nhập số lượng cần thêm
		System.out.println("Nhap so luong: ");
		int n = sc.nextInt();
		dsdt = Arrays.copyOf(dsdt, dsdt.length + n);
		
		for(int i = dsdt.length - n; i < dsdt.length; i++) {
			System.out.println("---Nhập điện thoại---");
			System.out.println("1. Nhập điện thoại thông minh."
							+ "\n2.Nhập điện thoại phím.");
			int luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
				case 1: {
					DienThoaiThongMinh dttm = new DienThoaiThongMinh();
					dttm.nhap();
					dttm = (DienThoaiThongMinh) kiemTraTrungMaDT((DienThoai) dttm);
					dsdt[i] = dttm;
					break;
				}
				case 2: {
					DienThoaiPhim dtp = new DienThoaiPhim();
					dtp.nhap();
					dtp = (DienThoaiPhim) kiemTraTrungMaDT(dtp);
					dsdt[i] = dtp;
					break;
				}
			}
		}
		this.xuatDS();
	}
	
//	public void xuatDS() {
//		String format = "| %-5s | %-28s | %-12s | %-12s | %-8s | %-13s | %-17s | %-21s |\n";
//		System.out.format("+-------+------------------------------+--------------+--------------+----------+---------------+-------------------+-----------------------+\n");
//		System.out.format(format, "Mã ĐT", "Tên điện thoại", "Hãng", "Đơn giá", "Số lượng", "Hệ điều hành", "Màu", "Thuộc tính riêng");
//		System.out.format("+-------+------------------------------+--------------+--------------+----------+---------------+-------------------+-----------------------+\n");
//		for(int i = 0; i < dsdt.length; i++) {
//			dsdt[i].xuat();
//		}
//		System.out.format("+-------+------------------------------+--------------+--------------+----------+---------------+-------------------+-----------------------+\n");
//        System.out.println("\n");
//	}

	public void xuatDS() {
		// Khởi tạo DecimalFormat để định dạng đơn giá
		DecimalFormat df = new DecimalFormat("#,###.0");

		// Định dạng bảng
		String format = "| %-5s | %-28s | %-12s | %-12s | %-8s | %-13s | %-17s | %-21s |\n";
		System.out.format("+-------+------------------------------+--------------+--------------+----------+---------------+-------------------+-----------------------+\n");
		System.out.format(format, "Mã ĐT", "Tên điện thoại", "Hãng", "Đơn giá", "Số lượng", "Hệ điều hành", "Màu", "Thuộc tính riêng");
		System.out.format("+-------+------------------------------+--------------+--------------+----------+---------------+-------------------+-----------------------+\n");

		// Duyệt qua danh sách và gọi phương thức xuat của từng điện thoại
		for (int i = 0; i < dsdt.length; i++) {
			DienThoai dt = dsdt[i];
			// Định dạng lại đơn giá
			String formattedPrice = df.format(dt.getDongia()); // Giả sử getDonGia() trả về đơn giá của điện thoại
			// In chi tiết từng điện thoại với đơn giá đã được định dạng
			System.out.format(format, dt.getMaDT(), dt.getTenDT(), dt.getHang(), formattedPrice,
					dt.getSoluong(), dt.getHedieuhanh(), dt.getMau(), dt.getThuocTinh());
		}

		// In dòng kết thúc bảng
		System.out.format("+-------+------------------------------+--------------+--------------+----------+---------------+-------------------+-----------------------+\n");
		System.out.println("\n");
	}
	
	public void xoa_maDT() {
		System.out.print("---Nhập mã điện thoại cần xóa: ");
		String maDT = sc.nextLine();
		int index = this.timKiem_maDT1(maDT);
		if(index != -1 ) {
			for(int i = index; i < dsdt.length - 1; i++) {
				dsdt[i] = dsdt[i + 1];
			}
			dsdt = Arrays.copyOf(dsdt, dsdt.length - 1);
			System.out.println("Xóa thành công ");
		}
		else {
			System.out.println("Không tìm thấy mã điện thoại : " + maDT);
		}
	}
	
	public void xoa_maDT(String maDT) {
		int index = this.timKiem_maDT1(maDT);
		if(index != -1) {
			for(int i = index; i < dsdt.length - 1; i++) {
				dsdt[i] = dsdt[i + 1];
			} 
			dsdt = Arrays.copyOf(dsdt, dsdt.length - 1);
			System.out.println("Xóa thành công ");
		}
		else {
			System.out.println("Không tìm thấy mã điện thoại : " + maDT);
		}
	}
	
	public DienThoai timKiem_maDT() {
		System.out.print("---Nhập mã điện thoại cần tìm: ");
		String maDT = sc.nextLine();
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i].getMaDT().equals(maDT)) {
				return dsdt[i];
			}
		}
		return null;
	}
	
	public DienThoai timKiem_maDT(String maDT) {
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i].getMaDT().equals(maDT)) {
				return dsdt[i];
			}
		}
		return null;
	}
	
	public int timKiem_maDT1(String maDT) {
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i].getMaDT().equals(maDT)) {
				return i;
			}
		}
		return -1;
	}
	
	public int timKiem_maDT1() {
		System.out.println("---Nhập mã điện thoại cần tìm: ");
		String maDT = sc.nextLine();
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i].getMaDT().equals(maDT)) {
				return i;
			}
		}
		return -1;
	}
	
	public void timKiemNangCao() {
	    // Biến lưu các tiêu chí tìm kiếm
	    String maDT = null, tenDT = null, hang = null, heDieuHanh = null, mau = null;
	    int loai = -1; // 1: Thông minh, 2: Phím
	    float giaMin = -1, giaMax = -1;

	    int luaChon;
	    do {
	        System.out.println("----------Tìm kiếm nâng cao---------");
	        System.out.println("| 1. Tìm theo mã điện thoại.       |");
	        System.out.println("| 2. Tìm theo điện thoại           |");
	        System.out.println("| 3. Tìm theo hãng                 |");
	        System.out.println("| 4. Tìm theo khoảng giá           |");
	        System.out.println("| 5. Tìm theo hệ điều hành         |");
	        System.out.println("| 6. Tìm theo loại điện thoại      |");
	        System.out.println("| 7. Tìm theo màu sắc              |");
	        System.out.println("| 8. Thực hiện tìm kiếm            |");
	        System.out.println("| 0. Thoát                         |");
	        System.out.println("------------------------------------");
	        System.out.print("Nhập lựa chọn: ");
	        luaChon = sc.nextInt();
	        sc.nextLine();

	        switch (luaChon) {
	            case 1:
	                System.out.print("Nhập mã điện thoại: ");
	                maDT = sc.nextLine();
	                break;
	            case 2:
	                System.out.print("Nhập tên điện thoại: ");
	                tenDT = sc.nextLine();
	                break;
	            case 3:
	                System.out.print("Nhập hãng điện thoại: ");
	                hang = sc.nextLine();
	                break;
	            case 4:
	                System.out.print("Nhập khoảng giá (min max): ");
	                giaMin = sc.nextFloat();
	                giaMax = sc.nextFloat();
	                sc.nextLine();
	                break;
	            case 5:
	                System.out.print("Nhập hệ điều hành: ");
	                heDieuHanh = sc.nextLine();
	                break;
	            case 6:
	                System.out.println("Chọn loại điện thoại (1: Thông minh, 2: Phím): ");
	                loai = sc.nextInt();
	                sc.nextLine();
	                break;
	            case 7:
	                System.out.print("Nhập màu sắc: ");
	                mau = sc.nextLine();
	                break;
	            case 8:
	                // Thực hiện tìm kiếm
	                System.out.println("Kết quả tìm kiếm:");
	                tenDT = tenDT.trim();
	                for (DienThoai dt : dsdt) {
	                    // Kiểm tra từng tiêu chí
	                    if ((maDT == null || dt.getMaDT().equals(maDT)) &&
	                        (tenDT == null || dt.getTenDT().toLowerCase().contains(tenDT.toLowerCase())) &&
	                        (hang == null || dt.getHang().toLowerCase().contains(hang.toLowerCase())) &&
	                        (giaMin == -1 || (dt.getDongia() >= giaMin && dt.getDongia() <= giaMax)) &&
	                        (heDieuHanh == null || dt.getHedieuhanh().toLowerCase().contains(heDieuHanh.toLowerCase())) &&
	                        (loai == -1 || (loai == 1 && dt instanceof DienThoaiThongMinh) || 
	                                       (loai == 2 && dt instanceof DienThoaiPhim)) &&
	                        (mau == null || dt.getMau().toLowerCase().contains(mau.toLowerCase()))) {
	                        dt.xuat();
	                
	                    }
	                    
	                }
	                break;
	            case 0:
	                System.out.println("Thoát tìm kiếm nâng cao.");
	                break;
	            default:
	                System.out.println("Lựa chọn không hợp lệ.");
	        }
	    } while (luaChon != 0);
	}

	
	public void suaTheoMa() {
		System.out.print("---Nhập mã điện thoại cần sửa: ");
		String maDT = sc.nextLine();
		int index = timKiem_maDT1(maDT);
		if(index == -1) {
			System.out.println("Không tìm thấy điện thoại với mã: " + maDT);
		}
		else {
			int luaChon;
			do {
				System.out.println("---Sửa thông tin điện thoại---");
				System.out.println("| 1.Tên điện thoại.          |");
				System.out.println("| 2.Tên hãng.                |");
				System.out.println("| 3.Đơn giá.                 |");
				System.out.println("| 4.Số lượng.                |");
				System.out.println("| 5.Hệ điều hành.            |");
				System.out.println("| 6.Màu.                     |");
				if(dsdt[index] instanceof DienThoaiThongMinh) {
					System.out.println("| 7.Dung lượng lưu trữ.      |");
				}
				if(dsdt[index] instanceof DienThoaiPhim) {
					System.out.println("| 7.Loại bàn phím.           |");
				}
				System.out.println("| 0.Thoát.                   |");
				System.out.println("------------------------------");
				System.out.print("Nhập lựa chọn: ");
				luaChon = sc.nextInt();
				sc.nextLine();
				
				switch (luaChon) {
				case 1: {
					System.out.print("Nhập tên điện thoại mới: ");
					String tenDT = sc.nextLine();
					dsdt[index].setTenDT(tenDT);
					break;
				}
				case 2: {
					System.out.print("Nhập hãng điện thoại mới: ");
					String hang = sc.nextLine();
					dsdt[index].setHang(hang);
					break;
				}
				case 3: {
					System.out.print("Nhập đơn giá mới: ");
					float donGia = sc.nextFloat();
					sc.nextLine();
					dsdt[index].setDongia(donGia);
					break;
				}
				case 4: {
					System.out.print("Nhập số lượng mới: ");
					int soluong = sc.nextInt();
					sc.nextLine();
					dsdt[index].setSoluong(soluong);
					break;
				}
				case 5: {
					System.out.print("Nhập hệ điều hành mới: ");
					String hedieuhanh = sc.nextLine();
					dsdt[index].setHedieuhanh(hedieuhanh);
					break;
				}
				case 6: {
					System.out.print("Nhập màu mới: ");
					String mau = sc.nextLine();
					dsdt[index].setMau(mau);
					break;
				}
				case 7: {
					if(dsdt[index] instanceof DienThoaiThongMinh) {
						System.out.print("Nhập dung lượng lưu trữ mới: ");
						DienThoaiThongMinh dttm = (DienThoaiThongMinh) dsdt[index];
						String dungluongluutru = sc.nextLine();
						dttm.setDungluongluutru(dungluongluutru);
						dsdt[index] = dttm;
					}
					if(dsdt[index] instanceof DienThoaiPhim) {
						System.out.print("Nhập loại bàn phím mới: ");
						DienThoaiPhim dtp = (DienThoaiPhim) dsdt[index];
						String loaibanphim = sc.nextLine();
						dtp.setLoaibanphim(loaibanphim);
						dsdt[index] = dtp;
					}
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
	
	public void thongKe_loai() {
		int dttm = 0;
		int dtp = 0;
		for(int i = 0; i < dsdt.length; i++) {
			if(dsdt[i] instanceof DienThoaiThongMinh) {
				dttm++;
			}
			else {
				dtp++;
			}
		}
		System.out.println("---Thống kê theo loại điện thoại---");
		System.out.println("Điện thoại thông minh \t Điện thoại phím");
		System.out.println("\t" + dttm + "\t\t\t" + dtp + "\n");
	}
	
	public void thongKe_gia() {
		float muc1 = 5000000;
		float muc2 = 10000000;
		int gia_muc1 = 0;
		int gia_muc1_muc2 = 0;
		int gia_muc2 = 0;
		for(int i = 0; i < dsdt.length; i++) {
			float donGia = dsdt[i].getDongia();
			if(donGia < muc1) {
				gia_muc1++;
			}else if(donGia > muc1 && donGia < muc2){
				gia_muc1_muc2++;
			}else if(donGia > muc2) {
				gia_muc2++;
			}
		}
		System.out.println("---Thống kê theo giá---");
		System.out.println("Giá dưới " + muc1 + ": " + gia_muc1);
		System.out.println("Giá từ " + muc1 + " đến " + muc2 + ": " + gia_muc1_muc2);
		System.out.println("Giá trên " + muc2 + ": " + gia_muc2 + "\n");
		

	}
	
	@Override
	public void docFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/data/DanhSachDienThoai.txt"));;
			String line;
			int n = 0;
			while((line = reader.readLine()) != null) {
				String[] detail = line.split(";");
				
				String loai = detail[0];
				String maDT = detail[1];
				String tenDT = detail[2];
				String hang = detail[3];
				float donGia = Float.parseFloat(detail[4]);
				int soLuong = Integer.parseInt(detail[5]);
				String heDieuHanh = detail[6];
				String mau = detail[7];
				
				DienThoai dt = null;
				
				if(loai.equals("1")) {
					String dungLuongLuuTru = detail[8];
					dt = new DienThoaiThongMinh(maDT, tenDT, hang, donGia, soLuong, heDieuHanh, mau, dungLuongLuuTru);
				}
				else if(loai.equals("2")) {
					String loaiBanPhim = detail[8];
					dt = new DienThoaiPhim(maDT, tenDT, hang, donGia, soLuong, heDieuHanh, mau, loaiBanPhim);
				}
				
				if(dt != null) {
					dsdt = Arrays.copyOf(dsdt, n + 1);
					dsdt[n++] = dt;
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void ghiFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/DanhSachDienThoai.txt"));
			for (DienThoai dienThoai : dsdt) {
				String data = "";
				if(dienThoai instanceof DienThoaiThongMinh) {
					// Unboxing
					DienThoaiThongMinh dttm = (DienThoaiThongMinh) dienThoai;
					
					data = "1;" + dttm.getMaDT() + ";" + dttm.getTenDT() + ";" + dttm.getHang() 
					+ ";" + dttm.getDongia() + ";" + dttm.getSoluong() + ";" + dttm.getHedieuhanh() 
					+ ";" + dttm.getMau() + ";" + dttm.getDungluongluutru() + "\n";
				}
				else if(dienThoai instanceof DienThoaiPhim) {
					// Unboxing
					DienThoaiPhim dtp = (DienThoaiPhim) dienThoai;
					
					data = "2;" + dtp.getMaDT() + ";" + dtp.getTenDT() + ";" + dtp.getHang() 
					+ ";" + dtp.getDongia() + ";" + dtp.getSoluong() + ";" + dtp.getHedieuhanh() 
					+ ";" + dtp.getMau() + ";" + dtp.getLoaibanphim() + "\n";
				}
				writer.write(data);
			}
			writer.close();
			System.out.println("Đã ghi dữ liệu của danh sách điện thoại!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DanhSachDienThoai dsdt = new DanhSachDienThoai();
		dsdt.docFile();
		dsdt.timKiemNangCao();
	}
	
	
	public void xuatMaDT_TenDT() { 
		for(int i = 0 ; i < dsdt.length; i++) {
			System.out.println("Mã điện thoại: " + dsdt[i].getMaDT()
					+ " - Tên điện thoại: " + dsdt[i].getTenDT());
		}
	}
	
}
