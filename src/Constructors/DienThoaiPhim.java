package Constructors;

import java.util.Scanner;

public class DienThoaiPhim extends DienThoai{
	private String loaibanphim;
	
	public DienThoaiPhim() {
		
	}

	public DienThoaiPhim(String maDT, String tenDT, String hang, float dongia, int soluong,
			String hedieuhanh, String mau, String loaibanphim) {
		super(maDT, tenDT, hang, dongia, soluong, hedieuhanh, mau);
		this.loaibanphim = loaibanphim;
	}
	
	public DienThoaiPhim(DienThoaiPhim dienThoaiPhim) {
		super((DienThoai) dienThoaiPhim);
		this.loaibanphim = dienThoaiPhim.getLoaibanphim();
	}

	
	public String getLoaibanphim() {
		return loaibanphim;
	}

	public void setLoaibanphim(String loaibanphim) {
		this.loaibanphim = loaibanphim;
	}

	@Override
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		super.nhap();
		
		System.out.println("Nhập loại bàn phím: ");
		this.loaibanphim = sc.nextLine();
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Loại bàn phím: " + this.loaibanphim);
	}
	
	@Override
	public String layLoaiDienThoai() {
		return "Điện thoại phím";
	}
	
	
}
