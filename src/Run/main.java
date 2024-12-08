package Run;
import Constructors.*;
import List.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
public class main {
    public static void run(NhanVien a) {System.out.println("Chương trình bắt đầu!");
        Scanner sc = new Scanner(System.in);
        DanhSachNCC danhSachNCC = new DanhSachNCC();
        DanhSachPhieuNhap danhSachPhieuNhap = new DanhSachPhieuNhap();
        DanhSachNhanVien danhsachNV = new DanhSachNhanVien();
        DSKhachHang dskh = new DSKhachHang();
        DanhSachChiTietHoaDon dscthd = new DanhSachChiTietHoaDon();
        DanhSachHoaDon danhsachHD = new DanhSachHoaDon();
        DanhSachCTPN dsct = new DanhSachCTPN();
        DanhSachDienThoai dsdt = new DanhSachDienThoai();
        

        System.out.println();
        danhSachNCC.docFile();
        danhSachPhieuNhap.docFile();
        danhsachNV.docTuFile();
        danhsachHD.docFile();
        dsct.docFile();
        dskh.docFile("src/data/danhsachkhachhang.txt");
        dscthd.docFile("src/data/danhsachchitiethoadon.txt");
        dsdt.docFile();
        System.out.println("Tất cả dữ liệu đã được khôi phục !!!");
        System.out.println();

        while (true) {
            System.out.println("-------------------- MENU --------------------");
            System.out.println("| 1. Nhập và quản lý danh sách điện thoại    |");
            System.out.println("| 2. Nhập và quản lý danh sách nhà cung cấp  |");
            System.out.println("| 3. Nhập và quản lý danh sách phiếu nhập    |");
            System.out.println("| 4. Nhập và quản lý danh sách CTPN          |");
            System.out.println("| 5. Nhập và quản lý nhân viên               |");
            System.out.println("| 6. Nhập và quản lý khách hàng              |");
            System.out.println("| 7. Nhập và quản lý hoá đơn                 |");
            System.out.println("| 8. Xuất tất cả dữ liệu ra file             |");
            System.out.println("| 9. Tìm kiếm nâng cao                       |");
            System.out.println("| 10. Tạo đơn hàng mới                       |");
            System.out.println("| 0. Thoát                                   |");
            System.out.println("----------------------------------------------");
            System.out.print("Vui lòng chọn một tùy chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
            	case 1:
            		menuDT(dsdt);
            		break;
                case 2:
                    menuNCC(danhSachNCC);
                    break;
                case 3:
                    menuPN(danhSachPhieuNhap);
                    break;
                case 4:
                	menuCTPN(dsct,danhSachPhieuNhap);
                	break;
                case 5:
                    danhsachNV.menu();
                    break;
                case 6:
                    dskh.menu();
                    break;
                case 7:
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
                case 8:
                    danhSachNCC.ghiFile();
                    danhSachPhieuNhap.ghiFile();
                    danhsachNV.xuatRaFile();
                    danhsachHD.ghiFile();
                    System.out.println("Ghi file thành công !!!");
                    System.out.println("\n");
                    break;
                case 9:
                    timKiemNangCaoThuNhat(danhSachNCC,danhSachPhieuNhap);
                    break;
                case 10:
                    checkout(dsdt, dskh, danhsachHD, dscthd, a);
                    break;
                case 0:
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
            System.out.println("| 2. Xuất danh sách nhà cung cấp             |");
            System.out.println("| 3. Sửa thông tin nhà cung cấp              |");
            System.out.println("| 4. Tìm kiếm nhà cung cấp                   |");
            System.out.println("| 5. Xóa một nhà cung cấp                    |");
            System.out.println("| 6. Thống kê số lượng nhà cung cấp          |");
            System.out.println("| 0. Quay lại menu chính                     |");
            System.out.println("----------------------------------------------");
            System.out.print("Vui lòng chọn một tùy chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    danhSachNCC.nhapK();
                    break;
                case 2:
                    danhSachNCC.xuat();
                    break;
                case 3:
                    danhSachNCC.suaNCC();
                    break;
                case 4:
                    danhSachNCC.timKiemGanDung();
                    break;
                case 5:
                    danhSachNCC.xoaMotNCC();
                    break;
                case 6:
                    danhSachNCC.thongKeNCC();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    private static void menuPN(DanhSachPhieuNhap danhSachPhieuNhap) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-------- Quản lý danh sách phiếu nhập --------");
            System.out.println("| 1. Thêm phiếu nhập                         |");
            System.out.println("| 2. Xuất danh sách phiếu nhập               |");
            System.out.println("| 3. Sửa phiếu nhập                          |");
            System.out.println("| 4. Tìm kiếm phiếu nhập                     |");
            System.out.println("| 5. Xóa phiếu nhập                          |");
            System.out.println("| 6. Thống kê số phiếu nhập                  |");
            System.out.println("| 7. Thống kê tổng số tiền                   |");
            System.out.println("| 0. Quay lại menu chính                     |");
            System.out.println("----------------------------------------------");
            System.out.print("Vui lòng chọn một tùy chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    danhSachPhieuNhap.themK();
                    break;
                case 2:
                    danhSachPhieuNhap.xuatDs();
                    break;
                case 3:
                    danhSachPhieuNhap.suaPhieuNhap();
                    break;
                case 4:
                    danhSachPhieuNhap.timMaPhieu();
                    break;
                case 5:
                    danhSachPhieuNhap.xoaPhanTu();
                    break;
                case 6:
                    danhSachPhieuNhap.thongKe();
                    break;
                case 7:
                    danhSachPhieuNhap.thongKeTien();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    private static void timKiemNangCaoThuNhat(DanhSachNCC dsncc, DanhSachPhieuNhap dspn) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Tìm kiếm nâng cao ----------");

        System.out.print("Nhập mã nhà cung cấp : ");
        String maNCC = sc.nextLine().trim();

        System.out.print("Nhập mã nhân viên : ");
        String maNV = sc.nextLine().trim();

        // Nhập khoảng thời gian
        String ngayBatDau = "";
        String ngayKetThuc = "";
        System.out.print("Nhập ngày bắt đầu (yyyy/mm/dd) : ");
        ngayBatDau = sc.nextLine().trim();
        System.out.print("Nhập ngày kết thúc (yyyy/mm/dd) : ");
        ngayKetThuc = sc.nextLine().trim();

        // Nhập tiền min, max
        System.out.print("Nhập tiền min : ");
        float tienMin = sc.nextFloat();
        System.out.print("Nhập tiền max : ");
        float tienMax = sc.nextFloat();

        System.out.println("Đang tiến hành thực hiện chức năng tìm kiếm ...");

        // Gọi hàm tìm kiếm theo tiêu chí
        dspn.timKiemTieuChi(dsncc, maNCC, ngayBatDau, ngayKetThuc, tienMin, tienMax, maNV);
    }

    
    public static void menuDT(DanhSachDienThoai danhSachDT) {
		Scanner sc = new Scanner(System.in);
		int luaChon;
		do {
			System.out.println("-----------Quản lý danh sách điện thoại-----------");
			System.out.println("| 1.Xuất danh sách điện thoại.                   |");
			System.out.println("| 2.Thêm điện thoại vào danh sách.               |");
			System.out.println("| 3.Xóa điện thoại theo mã điện thoại.           |");
			System.out.println("| 4.Sửa thông tin điện thoại theo mã điện thoại. |");
			System.out.println("| 5.Tìm kiếm điện thoại theo mã điện thoại.      |");
			System.out.println("| 6.Thống kê theo loại điện thoại.               |");
			System.out.println("| 7.Thống kê theo mức giá.                       |");
			System.out.println("| 8.Ghi danh sách điện thoại vào file.           |");
			System.out.println("| 9.Xuất số lượng điện thoại tồn kho.            |");
			System.out.println("| 0.Thoát.                                       |");
			System.out.println("--------------------------------------------------");
			System.out.print("Nhập lựa chọn: ");
			luaChon = sc.nextInt();
			sc.nextLine();
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
					String format = "| %-5s | %-28s | %-12s | %-12s | %-8s | %-13s | %-17s | %-21s |\n";
					System.out.format("+-------+------------------------------+--------------+--------------+----------+---------------+-------------------+-----------------------+\n");
					System.out.format(format, "Mã ĐT", "Tên điện thoại", "Hãng", "Đơn giá", "Số lượng", "Hệ điều hành", "Màu", "Thuộc tính riêng");
					System.out.format("+-------+------------------------------+--------------+--------------+----------+---------------+-------------------+-----------------------+\n");
					danhSachDT.getDsdt()[index].xuat();
					System.out.format("+-------+------------------------------+--------------+--------------+----------+---------------+-------------------+-----------------------+\n\n");
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
			case 9: {
				System.out.println("Tổng số lượng sản phẩm tồn kho: " + danhSachDT.laySoLuongTonKho() + "\n");
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
    
    public static void menuCTPN(DanhSachCTPN danhSachCTPN, DanhSachPhieuNhap dspn) {
		Scanner sc = new Scanner(System.in);
		int luaChon;
		do {
			System.out.println("----------------Quản lý danh sách CTPN----------------");
			System.out.println("| 1.Xuất danh sách CTPN.                             |");
			System.out.println("| 2.Thêm CTPN vào danh sách.                         |");
			System.out.println("| 3.Xóa CTPN theo mã PN + mã điện thoại.             |");
			System.out.println("| 4.Sửa thông tin CTPN theo mã PN + mã điện thoại.   |");
			System.out.println("| 5.Tìm kiếm CTPN theo mã PN + mã điện thoại.        |");
			System.out.println("| 6.Thống kê theo mã điện thoại.                     |");
			System.out.println("| 7.Ghi danh sách CTPN vào file.                     |");
			System.out.println("| 0.Thoát.                                           |");
			System.out.println("------------------------------------------------------");
			System.out.print("Nhập lựa chọn: ");
			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
			case 1: {
				danhSachCTPN.xuatDS();
				break;
			}
			case 2: {
				danhSachCTPN.them_K_CTPN();
				dspn.ghiFile();
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
    public static String getFormattedDateTime() {
        // Lấy thời gian hiện tại
        LocalDateTime now = LocalDateTime.now();

        // Định dạng theo kiểu "giờ/ngày/tháng/năm"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm/dd/MM/yyyy");

        // Trả về chuỗi đã định dạng
        return now.format(formatter);
    }
    public static void checkout(DanhSachDienThoai dsdt, DSKhachHang dskh, DanhSachHoaDon dshd, DanhSachChiTietHoaDon dscthd, NhanVien nv){
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        DienThoai[] dt = new DienThoai[0];
        System.out.println("============Tạo đơn hàng============");

        // logic xử lý khách hàng

        System.out.println("Nhập số điện thoại khách hàng: ");
        String sdt = sc.nextLine();
        KhachHang kh = dskh.timkiemSDT(sdt);
        Boolean kh_found = true;
        // Nếu không tìm thấy khách hàng trong ds thì tạo mới
        if(kh == null) {
            System.out.println("Khách hàng không tồn tại, vui lòng nhập thông tin khách hàng mới.");
            System.out.println("Nhập tên khách hàng: ");
            String tenKH = sc.nextLine();
            kh = new KhachHang(dskh.taoMaKH(), tenKH, sdt, 0);
            kh_found = false;
        }


        // xử lý mua hàng
        do{
            dsdt.xuatDS();
            System.out.println("Nhập mã điện thoại cần mua: ");
            DienThoai a = null;
            do {
                String ma = sc.nextLine();
                a = dsdt.timKiem_maDT(ma);
                if(a == null ) {
                    System.out.println("Nhập sai mã, vui lòng nhập lại mã điện thoại cần mua: ");
                }
            }while(a == null);
            System.out.println("Nhập số lượng điện thoại:");
            int quan = sc.nextInt();
            sc.nextLine();
            a.setSoluong(quan);
            dt = Arrays.copyOf(dt, dt.length+1);
            dt[dt.length - 1] = a;
            System.out.println("Đã thêm điện thoại.");
            boolean validChoice = false;
            while (!validChoice) {
                System.out.println("1. Thêm điện thoại khác");
                System.out.println("2. Xác nhận đơn hàng");
                System.out.println("3. Hủy");
                System.out.print("Nhập lựa chọn tiếp theo: ");
                int choice = sc.nextInt();
                sc.nextLine();  // Đọc hết dòng nhập

                switch (choice) {
                    case 1:
                        // Tiếp tục chọn thêm sản phẩm
                        validChoice = true;  // Chưa hoàn tất, tiếp tục vòng lặp
                        break;
                    case 2:
                        // Xác nhận đơn hàng
                        System.out.println("Đơn hàng đã được xác nhận.");
                        done = true;  // Kết thúc vòng lặp chính
                        validChoice = true;  // Đã chọn xác nhận, thoát khỏi vòng lặp con
                        break;
                    case 3:
                        // Hủy đơn hàng
                        System.out.println("Đơn hàng đã bị hủy.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        validChoice = false;  // Tiếp tục vòng lặp nếu lựa chọn không hợp lệ
                }
            }
        } while (!done);

        // Tao hoa don moi

        float tongtien = 0;
        for(DienThoai dienthoai : dt){
            tongtien += dienthoai.getDongia()*dienthoai.getSoluong();
        }
        HoaDon hd_temp = new HoaDon(dshd.taoMaHd(), getFormattedDateTime(), nv.getMaNv(), kh.getMakh(), tongtien );

        //Tao cthd moi

        ChiTietHoaDon[] cthd_list_temp = new ChiTietHoaDon[0];
        for(DienThoai dienthoai : dt){
            ChiTietHoaDon cthd_new = new ChiTietHoaDon(hd_temp.getMaHd(), dienthoai.getMaDT(), dienthoai.getSoluong(), dienthoai.getDongia());
            cthd_list_temp = Arrays.copyOf(cthd_list_temp, cthd_list_temp.length + 1);
            cthd_list_temp[cthd_list_temp.length - 1] = cthd_new;
        }

        hd_temp.xuat();
        for(int i = 0; i < cthd_list_temp.length; i++){
            cthd_list_temp[i].xuatCTHD();
        }

        // Them hoa don va chi tiet hoa don va khach hang vao he thong

        dshd.add(hd_temp);

        for (ChiTietHoaDon a :cthd_list_temp){
            dscthd.add(a);
        }
        if(!kh_found) {
            kh.setTongtien(hd_temp.getTongTien());
            dskh.themKH(kh);
        } else{
            kh.setTongtien(kh.getTongtien() + hd_temp.getTongTien());
            (dskh.timkiemSDT(sdt)).setTongtien(kh.getTongtien());
        }
        dshd.xuatDanhSachHoaDon();
        dscthd.xuatDSCTHD();
        dskh.xemDSKH();

    }
}
