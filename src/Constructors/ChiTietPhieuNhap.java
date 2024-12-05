package Constructors;

import java.util.Scanner;

import List.DanhSachDienThoai;

public class ChiTietPhieuNhap {
	private String maPN;
	private String maDT;
	private int soluong;
	private float dongia;
	private float thanhtien;
	
	public ChiTietPhieuNhap() {
		
	}

	public ChiTietPhieuNhap(String maPN, String maDT, int soluong, float dongia, float thanhtien) {
		this.maPN = maPN;
		this.maDT = maDT;
		this.soluong = soluong;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
		
	}
	
	public ChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) {
		this.maPN = chiTietPhieuNhap.getMaPN();
		this.maDT = chiTietPhieuNhap.getMaDT();
		this.soluong = chiTietPhieuNhap.getSoluong();
		this.dongia = chiTietPhieuNhap.getDongia();
		this.thanhtien = chiTietPhieuNhap.getThanhtien();
	}

	public String getMaPN() {
		return maPN;
	}

	public String getMaDT() {
		return maDT;
	}

	public int getSoluong() {
		return soluong;
	}

	public float getDongia() {
		return dongia;
	}

	public float getThanhtien() {
		return thanhtien;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	public void setThanhtien(float thanhtien) {
		this.thanhtien = thanhtien;
	}
	

	
	public void nhap(String[] DanhSachPN) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("Danh sách mã phiếu nhập : ");
			for(int i=0;i< DanhSachPN.length;i++)
			{
				System.out.println((i+1) + "." + DanhSachPN[i]);
			}
			System.out.print("Nhập mã phiếu nhập tương ứng : ");
			choice = sc.nextInt();
			sc.nextLine();
			if(choice >=1 && choice <= DanhSachPN.length)
			{
				this.maPN = DanhSachPN[choice - 1];
				break;
			}
			else
			{
				System.out.println("Vui lòng chọn lại");
			}
		}while(choice >=1 && choice <= DanhSachPN.length);
		System.out.println("Nhập mã điện thoại: ");
		this.maDT = sc.nextLine();
		System.out.println("Nhập số lượng: ");
		this.soluong = sc.nextInt();
		
		this.dongia = DanhSachDienThoai.getDonGia(maDT);
		
		this.thanhtien = this.soluong * this.dongia;
	}
	
	public void xuat() {
		System.out.println("Mã phiếu nhập: " + this.maPN);
		System.out.println("Mã điện thoại: " + this.maDT);
		System.out.println("Số lượng điện thoại: " + this.soluong);
		System.out.println("Đơn giá: " + this.dongia);
		System.out.println("Thành tiền: " + (this.dongia * this.soluong));
	}
	
	
	
	
}
