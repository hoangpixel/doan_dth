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
	

	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã phiếu nhập: ");
		this.maPN = sc.nextLine();
		System.out.println("Nhập mã điện thoại: ");
		this.maDT = sc.nextLine();
		System.out.println("Nhập số lượng: ");
		this.soluong = sc.nextInt();
		
		this.dongia = DanhSachDienThoai.getDonGia(maDT);
		
		this.thanhtien = this.soluong * this.dongia;
	}
	
	public void xuat() {
		String format = "| %-13s | %-10s | %-10s | %-15s | %-15s |\n";
		System.out.format(format, this.maPN, this.maDT, this.soluong, this.dongia, this.thanhtien);
	}
	
	
	
	
}