package Constructors;

import java.util.Scanner;

public class DienThoaiThongMinh extends DienThoai{
	private String dungluongluutru;
	
	public DienThoaiThongMinh() {
		
	}
	
	public DienThoaiThongMinh(String maDT, String tenDT, String hang, float dongia, int soluong,
			String hedieuhanh, String mau, String dungluongluutru) {
		super(maDT, tenDT, hang, dongia, soluong, hedieuhanh, mau);
		this.dungluongluutru = dungluongluutru;
	}

	public String getDungluongluutru() {
		return dungluongluutru;
	}

	public void setDungluongluutru(String dungluongluutru) {
		this.dungluongluutru = dungluongluutru;
	}

	@Override
	public String layLoaiDienThoai() {
		return "Điện thoại thông minh";
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		super.nhap();
		
		System.out.println("Nhập dung lượng lưu trữ: ");
		this.dungluongluutru = sc.nextLine();
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.format("Dung lượng: %-10s |\n", this.dungluongluutru);
	}
	
	
}
