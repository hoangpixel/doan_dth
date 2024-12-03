package Run;
import List.DanhSachNCC;
import List.DanhSachNhanVien;
import List.DanhSachPhieuNhap;
import List.DSKhachHang;
import List.DanhSachCTPN;
import List.DanhSachDienThoai;
import List.DanhSachChiTietHoaDon;
import List.DanhSachHoaDon;

import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachNCC danhSachNCC = new DanhSachNCC();
        DanhSachPhieuNhap danhSachPhieuNhap = new DanhSachPhieuNhap();
        DanhSachNhanVien danhsachNV = new DanhSachNhanVien();
        DSKhachHang dskh = new DSKhachHang();
        DanhSachChiTietHoaDon dscthd = new DanhSachChiTietHoaDon();
        DanhSachHoaDon danhsachHD = new DanhSachHoaDon();

        System.out.println();
        danhSachNCC.docFile();
        danhSachPhieuNhap.docFile();
        danhsachNV.docTuFile();
        danhsachHD.docFile();
        dskh.docFile("src/data/danhsachkhachhang.txt");
        dscthd.docFile("src/data/danhsachchitiethoadon.txt");
        System.out.println("Đọc file thành công !!!");
        System.out.println();

        while (true) {
            System.out.println("-------------------- MENU --------------------");
            System.out.println("| 1. Nhập và quản lý danh sách nhà cung cấp  |");
            System.out.println("| 2. Nhập và quản lý danh sách phiếu nhập    |");
            System.out.println("| 3. Nhập và quản lý nhân viên               |");
            System.out.println("| 4. Nhập và quản lý khách hàng              |");
            System.out.println("| 5. Nhập và quản lý hoá đơn                 |");
            System.out.println("| 6. Xuất tất cả dữ liệu ra file             |");
            System.out.println("| 7. Tìm kiếm nâng cao                       |");
            System.out.println("| 8. Thoát                                   |");
            System.out.println("----------------------------------------------");
            System.out.print("Vui lòng chọn một tùy chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    menuNCC(danhSachNCC);
                    break;
                case 2:
                    menuPN(danhSachPhieuNhap, danhSachNCC, danhsachNV);
                    break;
                case 3:
                    danhsachNV.menu();
                    break;
                case 4:
                    dskh.menu();
                    break;
                case 5:
                    int lc;
                    do {
                        Scanner nhap = new Scanner(System.in);
                        System.out.println("\n------- Nhập và quản lý hoá đơn -------");
                        System.out.println("| 1. Nhập và quản lý danh sách hoá đơn                 |");
                        System.out.println("| 2. Nhập và quản lý danh sách chi tiết hoá đơn        |");
                        System.out.println("| 3. Thoát                                             |");
                        System.out.print("Nhập lựa chọn (1 -> 3): ");
                        lc = nhap.nextInt();
                        switch (lc) {
                            case 1: {
                                danhsachHD.menu(danhsachNV, dskh);
                                break;
                            }
                            case 2: {
                                dscthd.menu();
                                break;
                            }
                            case 3: {
                                System.out.println("Bạn chọn thoát");
                                break;
                            }
                            default: {
                                System.out.println("Lựa chọn không hợp lệ (1->3)");
                            }
                        }
                    } while (lc != 3);
                    break;
                case 6:
                    danhSachNCC.ghiFile();
                    danhSachPhieuNhap.ghiFile();
                    danhsachNV.xuatRaFile();
                    danhsachHD.ghiFile();
                    System.out.println("Ghi file thành công !!!");
                    System.out.println("\n");
                    break;
                case 7:
                    timKiemNangCaoThuNhat(danhSachNCC,danhSachPhieuNhap);
                    break;
                case 8:
                    System.out.println("Cảm ơn đã sử dụng chương trình. Tạm biệt!");
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    private static void menuNCC(DanhSachNCC danhSachNCC) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------- Quản lý danh sách nhà cung cấp -------");
            System.out.println("| 1. Nhập danh sách nhà cung cấp             |");
            System.out.println("| 2. Thêm nhà cung cấp                       |");
            System.out.println("| 3. Xóa một nhà cung cấp                    |");
            System.out.println("| 4. Sửa thông tin nhà cung cấp              |");
            System.out.println("| 5. Tìm kiếm nhà cung cấp                   |");
            System.out.println("| 6. Xuất danh sách nhà cung cấp             |");
            System.out.println("| 7. Thống kê số lượng nhà cung cấp          |");
            System.out.println("| 8. Quay lại menu chính                     |");
            System.out.println("----------------------------------------------");
            System.out.print("Vui lòng chọn một tùy chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    danhSachNCC.nhapKtrung();
                    break;
                case 2:
                    danhSachNCC.themkNCC();
                    break;
                case 3:
                    danhSachNCC.xoaMotNCC();
                    break;
                case 4:
                    danhSachNCC.suaNCC();
                    break;
                case 5:
                    danhSachNCC.timKiemGanDung();
                    break;
                case 6:
                    danhSachNCC.xuat();
                    break;
                case 7:
                    danhSachNCC.thongKeNCC();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    private static void menuPN(DanhSachPhieuNhap danhSachPhieuNhap, DanhSachNCC danhSachNCC, DanhSachNhanVien danhSachNhanVien) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-------- Quản lý danh sách phiếu nhập --------");
            System.out.println("| 1. Nhập danh sách phiếu nhập               |");
            System.out.println("| 2. Thêm phiếu nhập                         |");
            System.out.println("| 3. Xóa phiếu nhập                          |");
            System.out.println("| 4. Sửa phiếu nhập                          |");
            System.out.println("| 5. Tìm kiếm phiếu nhập                     |");
            System.out.println("| 6. Xuất danh sách phiếu nhập               |");
            System.out.println("| 7. Thống kê số phiếu nhập                  |");
            System.out.println("| 8. Thống kê tổng số tiền                   |");
            System.out.println("| 9. Quay lại menu chính                     |");
            System.out.println("----------------------------------------------");
            System.out.print("Vui lòng chọn một tùy chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    danhSachPhieuNhap.themKPhantu(danhSachNCC, danhSachNhanVien);
                    break;
                case 2:
                    danhSachPhieuNhap.themkNcoHoi(danhSachNCC, danhSachNhanVien);
                    break;
                case 3:
                    danhSachPhieuNhap.xoaPhanTu();
                    break;
                case 4:
                    danhSachPhieuNhap.suaPhieuNhap();
                    break;
                case 5:
                    danhSachPhieuNhap.timMaPhieu();
                    break;
                case 6:
                    danhSachPhieuNhap.xuatDs();
                    break;
                case 7:
                    danhSachPhieuNhap.thongKe();
                    break;
                case 8:
                    danhSachPhieuNhap.thongKeTien();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    private static void timKiemNangCaoThuNhat(DanhSachNCC dsncc, DanhSachPhieuNhap dspn)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("---------- Tìm kiếm nâng cao ----------");
        System.out.print("Nhập mã nhà cung cấp : ");
        String maNCC=sc.nextLine().trim();
        System.out.print("Nhập tên nhà cung cấp : ");
        String tenNCC=sc.nextLine().trim();
        System.out.println("Chọn loại nhà cung cấp : ");
        System.out.println("1. Nội địa");
        System.out.println("2. Quốc tế");
        System.out.println("3. Bỏ qua");
        int loaiNCC=sc.nextInt();
        sc.nextLine();
        String quocgia="";
        if(loaiNCC == 2)
        {
            System.out.print("Nhập quốc gia của nhà cung cấp : ");
            quocgia=sc.nextLine().trim();
        }
        System.out.print("Nhập mã phiếu nhập : ");
        String maPN=sc.nextLine().trim();
        System.out.print("Nhập mã nhân viên : ");
        String maNV=sc.nextLine().trim();
        String ngayNhap;
        while(true)
        {
            System.out.print("Ngày nhập phiếu : ");
            ngayNhap = sc.nextLine().trim();
            if(ngayNhap.matches("\\d{4}/\\d{2}/\\d{2}"))
            {
                break;
            }
            else
            {
                System.out.println("Vui lòng nhập theo kiểu định dạng (yyyy/mm/dd)");
            }
        }
        System.out.println("Đang tiến hành thực hiện chức năng tìm kiếm ...");
        dspn.timKiemTieuChi(dsncc,maNCC,tenNCC,loaiNCC,quocgia,maPN,ngayNhap,maNV);
    }
    
    public void menuDT(DanhSachDienThoai danhSachDT) {
		Scanner sc = new Scanner(System.in);
		int luaChon;
		do {
			System.out.println("----------Quản lý danh sách điện thoại----------");
			System.out.println("1.Xuất danh sách điện thoại.");
			System.out.println("2.Thêm điện thoại vào danh sách.");
			System.out.println("3.Xóa điện thoại theo mã điện thoại.");
			System.out.println("4.Sửa thông tin điện thoại theo mã điện thoại.");
			System.out.println("5.Tìm kiếm điện thoại theo mã điện thoại.");
			System.out.println("6.Thống kê theo loại điện thoại.");
			System.out.println("7.Thống kê theo mức giá.");
			System.out.println("8.Ghi danh sách điện thoại vào file.");
			System.out.println("0.Thoát.");
			System.out.println("------------------------------------------------");
			System.out.print("Nhập lựa chọn: ");
			luaChon = sc.nextInt();
			switch (luaChon) {
			case 1: {
				danhSachDT.xuatDS();
				break;
			}
			case 2: {
				danhSachDT.nhap_n_DienThoai();
				break;
			}
			case 3: {
				danhSachDT.xoa_maDT();
				break;
			}
			case 4: {
				danhSachDT.suaTheoMa();
				break;
			}
			case 5: {
				int index = danhSachDT.timKiem_maDT1();
				if(index == -1) {
					System.out.println("Không tìm thấy điện thoại.");
				}
				else {
					System.out.println("Tìm thấy điện thoại: ");
					danhSachDT.getDsdt()[index].xuat();
				}
				break;
			}
			case 6: {
				danhSachDT.thongKe_loai();
				break;
			}
			case 7: {
				danhSachDT.thongKe_gia();
				break;
			}
			case 8: {
				danhSachDT.ghiFile();
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
    
    public void menuCTPN(DanhSachCTPN danhSachCTPN) {
		Scanner sc = new Scanner(System.in);
		int luaChon;
		do {
			System.out.println("------------Quản lý danh sách CTPN------------");
			System.out.println("1.Xuất danh sách CTPN.");
			System.out.println("2.Thêm CTPN vào danh sách.");
			System.out.println("3.Xóa CTPN theo mã PN + mã điện thoại.");
			System.out.println("4.Sửa thông tin CTPN theo mã PN + mã điện thoại.");
			System.out.println("5.Tìm kiếm CTPN theo mã PN + mã điện thoại.");
			System.out.println("6.Thống kê theo mã điện thoại.");
			System.out.println("7.Ghi danh sách CTPN vào file.");
			System.out.println("0.Thoát.");
			System.out.println("------------------------------------------------");
			System.out.print("Nhập lựa chọn: ");
			luaChon = sc.nextInt();
			switch (luaChon) {
			case 1: {
				danhSachCTPN.xuatDS();
				break;
			}
			case 2: {
				danhSachCTPN.them_K_CTPN();
				break;
			}
			case 3: {
				danhSachCTPN.xoaCTPN();
				break;
			}
			case 4: {
				danhSachCTPN.suaCTPN();
				break;
			}
			case 5: {
				int index = danhSachCTPN.timKiemCTPN();
				System.out.println("Chi tiết phiếu nhập tìm được: ");
				danhSachCTPN.getDsctpn()[index].xuat();
				break;
			}
			case 6: {
				danhSachCTPN.thongke_maDT();
				break;
			}
			case 7: {
				danhSachCTPN.ghiFile();
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
