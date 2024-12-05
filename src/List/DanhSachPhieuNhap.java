package List;
import java.util.Scanner;
import java.util.Arrays;
import Constructors.PhieuNhap;
import Constructors.NhaCungCap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Interfaces.InterfaceDocGhi;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class DanhSachPhieuNhap implements InterfaceDocGhi
{
    private static PhieuNhap[] dspn;
    public DanhSachPhieuNhap()
    {
        dspn=new PhieuNhap[0];
    }
    public DanhSachPhieuNhap(PhieuNhap dspn[])
    {
        this.dspn=dspn;
    }

    public  static PhieuNhap[] getDspn() {
        return dspn;
    }

    public boolean trungMaPN(String maPN) {
        for (PhieuNhap ds : dspn) {
            if (ds != null && ds.getMaPN().equals(maPN)) {
                return true;
            }
        }
        return false;
    }
    public void nhapPhieuDS(DanhSachNCC danhSachNCC, DanhSachNhanVien danhSachNhanVien) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng phiếu nhập: ");
        int n = sc.nextInt();
        sc.nextLine(); // Xóa bộ nhớ đệm

        dspn = new PhieuNhap[n];
        String[] danhSachMaNCC = danhSachNCC.layDanhSachMaNCC(); // Lấy danh sách mã NCC từ DanhSachNCC
        String[] danhSachMaNV = danhSachNhanVien.layDanhSachMaNV();
        for (int i = 0; i < n; i++) {
            System.out.println("-------- Phiếu nhập thứ " + (i + 1) + " --------");
            PhieuNhap pn = new PhieuNhap();

            do {
                pn.nhapPhieu(danhSachMaNCC, danhSachMaNV); // Truyền danh sách mã NCC vào phương thức nhập
                if (trungMaPN(pn.getMaPN())) {
                    System.out.println("Mã phiếu nhập đã bị trùng! Vui lòng nhập lại.");
                }
            } while (trungMaPN(pn.getMaPN()));

            dspn[i] = pn;
        }
    }
    public void themkNcoHoi(DanhSachNCC danhSachNCC,DanhSachNhanVien danhSachNhanVien)
    {
        Scanner sc=new Scanner(System.in);
        int n=dspn.length;
        int k;
        while(true)
        {
            System.out.print("Bạn có muốn thêm phiếu nhập không? (Y/N) : ");
            String choice=sc.nextLine();
            if(choice.equals("Y"))
            {
                do {
                    System.out.print("Nhập số lượng phiếu : ");
                    k=sc.nextInt();
                    sc.nextLine();
                    if(k<0)
                    {
                        System.out.println("Vui lòng nhập lại !!!");
                    }
                }while(k<0);
                dspn = Arrays.copyOf(dspn, n + k);
                for (int i = 0; i < k; i++) {
                    PhieuNhap pn = new PhieuNhap();
                    String[] danhSachMaNCC = danhSachNCC.layDanhSachMaNCC();
                    String[] danhSachMaNV = danhSachNhanVien.layDanhSachMaNV();
                    do {
                        pn.nhapPhieu(danhSachMaNCC, danhSachMaNV); // Truyền cả danh sách mã NCC và danh sách mã NV
                        if (trungMaPN(pn.getMaPN())) {
                            System.out.println("Mã phiếu nhập đã bị trùng vui lòng nhập lại !!!");
                        }
                    } while (trungMaPN(pn.getMaPN()));
                    dspn[n + i] = pn;
                }
            }
            else if(choice.equals("N"))
            {
                System.out.println("Cảm ơn bạn !!!");
                break;
            }
            else
            {
                System.out.println("Vui lòng nhập (Y/N) !!!");
            }
        }
    }
    public void themKPhantu(DanhSachNCC danhSachNCC,DanhSachNhanVien danhSachNhanVien) {
        Scanner sc = new Scanner(System.in);
        int k;
        int n = dspn.length;
        System.out.print("Nhập số lượng phiếu nhập muốn thêm: ");
        k = sc.nextInt();
        sc.nextLine();
        if (k < 0) {
            System.out.println("Vui lòng nhập số dương !!!");
            return;
        }
        dspn = Arrays.copyOf(dspn, n + k);
        for (int i = 0; i < k; i++) {
            PhieuNhap pn = new PhieuNhap();
            String[] danhSachMaNCC = danhSachNCC.layDanhSachMaNCC();
            String[] danhSachMaNV = danhSachNhanVien.layDanhSachMaNV();
            do {
                pn.nhapPhieu(danhSachMaNCC, danhSachMaNV); // Truyền cả danh sách mã NCC và danh sách mã NV
                if (trungMaPN(pn.getMaPN())) {
                    System.out.println("Mã phiếu nhập đã bị trùng vui lòng nhập lại !!!");
                }
            } while (trungMaPN(pn.getMaPN()));
            dspn[n + i] = pn;
        }
        System.out.println("Đã thêm " + k + " phiếu nhập vào danh sách.");
    }

    public void xoaPhanTu()
    {
        Scanner sc=new Scanner(System.in);
        int n=dspn.length;
        int index=-1;
        System.out.print("Nhập mã phiếu nhập muốn xóa : ");
        String maXoa=sc.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dspn[i].getMaPN().equals(maXoa))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            for(int i=index;i<n-1;i++)
            {
                dspn[i]=dspn[i+1];
            }
            dspn=Arrays.copyOf(dspn,n-1);
        }
        else
        {
            System.out.println("Không tìm thấy phiếu nhập cần xóa !!!");
        }
    }
    public void timMaPhieu()
    {
        Scanner sc=new Scanner(System.in);
        int n=dspn.length;
        String maTim;
        System.out.print("Vui lòng nhập mã cần tìm : ");
        maTim=sc.nextLine();
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(dspn[i].getMaPN().equals(maTim))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            System.out.println("Thông tin của mã phiếu nhập : " + maTim + " là : ");
            dspn[index].xuatPhieuNhap();
        }
        else
        {
            System.out.println("Không thể tìm thấy mã : " + maTim + " trong danh sách !!!");
        }
    }
    public void thongKeTien()
    {
        int s=0;
        for(int i=0;i<dspn.length;i++)
        {
            s+=dspn[i].getTongTien();
        }
        System.out.print("\n");
        System.out.println("Tổng số tiền của tất cả các phếu nhập : " + s);
        System.out.print("\n");
    }
    public void suaPhieuNhap()
    {
        Scanner sc=new Scanner(System.in);
        int n=dspn.length;
        int index=-1;
        String timMa;
        System.out.print("Nhập mã phiếu cần sửa đổi : ");
        timMa=sc.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dspn[i].getMaPN().equals(timMa))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            int choice;
            do
            {
                System.out.println("---------------Menu---------------");
                System.out.println("1. Sửa đổi mã nhà cung cấp");
                System.out.println("2. Sửa đổi ngày nhập hàng");
                System.out.println("3. Sửa đổi mã nhân viên");
                System.out.println("4. Sửa đổi tổng tiền hàng");
                System.out.println("5. Thoát");
                System.out.println("----------------------------------");
                System.out.print("Vui lòng nhập lựa chọn của bạn (1->5) : ");
                choice=sc.nextInt();
                sc.nextLine();
                switch (choice)
                {
                    case 1: {
                        System.out.print("Nhập mã nhà cung cấp cần sửa : ");
                        String newMaNCC = sc.nextLine();
                        dspn[index].setMaNCC(newMaNCC);
                        break;
                    }
                    case 2: {
                        System.out.print("Nhập ngày nhập hàng cẩn sửa đổi (yyyy/mm/dd) : ");
                        String newNgayNhap = sc.nextLine();
                        dspn[index].setNgayNhap(newNgayNhap);
                        break;
                    }
                    case 3: {
                        System.out.printf("Nhập mã nhân viên cần sửa : ");
                        String newMaNV = sc.nextLine();
                        dspn[index].setMaNV(newMaNV);
                        break;
                    }
                    case 4: {
                        System.out.printf("Nhập tổng tiền hàng cẩn sửa : ");
                        float newTongTien = sc.nextFloat();
                        dspn[index].setTongTien(newTongTien);
                        break;
                    }
                    case 5: {
                        System.out.println("Tạm biệt !!!");
                        break;
                    }
                    default: {
                        System.out.println("Lựa chọn không hợp lệ vui lòng chọn từ (1->5) !!!");
                    }
                }
            }while(choice!=5);
        }
        else
        {
            System.out.println("Không tìm thấy mã phiếu cần sửa !!!");
        }
    }
    public void thongKe()
    {
        int n= dspn.length;
        int d=0;
        for(int i=0;i<n;i++)
        {
            d++;
        }
        System.out.println("Có " + d + " phiếu nhập trong danh sách");
    }
    public void docFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/data/ListPhieuNhap.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống

                // Tách chuỗi bằng dấu `;`
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    try {
                        // Tạo đối tượng PhieuNhap từ dữ liệu
                        PhieuNhap pn = new PhieuNhap(
                                parts[0], // Mã phiếu nhập
                                parts[1], // Ngày nhập
                                parts[2], // Mã nhà cung cấp
                                parts[3], // Mã nhân viên
                                Float.parseFloat(parts[4]) // Tổng tiền
                        );

                        // Thêm đối tượng vào danh sách
                        dspn = Arrays.copyOf(dspn, dspn.length + 1);
                        dspn[dspn.length - 1] = pn;
                    } catch (NumberFormatException e) {
                        System.out.println("Dữ liệu tổng tiền không hợp lệ: " + line);
                    }
                } else {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                }
            }
            System.out.println("Dữ liệu phiếu nhập đã được đọc thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        }
    }

    public String[] layDanhSachPN()
    {
        String[] ncc=new String[dspn.length];
        for(int i=0;i< dspn.length;i++)
        {
            ncc[i]=dspn[i].getMaPN();
        }
        return ncc;
    }
    public void ghiFile()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/ListPhieuNhap.txt"))) {
            for (PhieuNhap pn : dspn)
            {
                if (pn != null) {
                    String data = pn.getMaPN() + ";" +
                            pn.getNgayNhap() + ";" +
                            pn.getMaNCC() + ";" +
                            pn.getMaNV() + ";" +
                            pn.getTongTien() + "\n";
                    writer.write(data);  // Ghi dữ liệu vào file
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    public void timKiemTieuChi(DanhSachNCC danhSachNCC, String maNCC,
                               String ngayBatDau, String ngayKetThuc, float tienMin, float tienMax, String maNV) {
        boolean found = false;

        // Định dạng ngày
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        for (PhieuNhap pn : dspn) {
            // Kiểm tra tiêu chí phiếu nhập
            if (!maNV.isEmpty() && !pn.getMaNV().equalsIgnoreCase(maNV)) continue;

            // Kiểm tra khoảng thời gian
            try {
                LocalDate ngayNhap = LocalDate.parse(pn.getNgayNhap(), formatter);
                LocalDate startDate = ngayBatDau.isEmpty() ? null : LocalDate.parse(ngayBatDau, formatter);
                LocalDate endDate = ngayKetThuc.isEmpty() ? null : LocalDate.parse(ngayKetThuc, formatter);

                // Kiểm tra nếu ngày nhập không nằm trong khoảng thời gian
                if (startDate != null && ngayNhap.isBefore(startDate)) continue;  // Trước ngày bắt đầu
                if (endDate != null && ngayNhap.isAfter(endDate)) continue;  // Sau ngày kết thúc

            } catch (Exception e) {
                System.out.println("Lỗi khi xử lý ngày: " + e.getMessage());
                continue;
            }

            // Kiểm tra tiền
            if (tienMin >= 0 && pn.getTongTien() < tienMin) continue;
            if (tienMax >= 0 && pn.getTongTien() > tienMax) continue;

            // Tìm nhà cung cấp tương ứng
            NhaCungCap ncc = danhSachNCC.timNhaCungCapTheoMa(pn.getMaNCC());
            if (ncc != null) {
                boolean match = true;

                // Kiểm tra tiêu chí nhà cung cấp
                if (!maNCC.isEmpty() && !ncc.getMaNCC().equalsIgnoreCase(maNCC)) {
                    match = false;
                }

                // Nếu tất cả tiêu chí khớp, in thông tin
                if (match) {
                    if (!found) System.out.println("Kết quả tìm kiếm:");
                    pn.xuatPhieuNhap();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy kết quả phù hợp.");
        }
    }

    public void xuat()
    {
        for(int i=0;i<dspn.length;i++)
        {
            dspn[i].xuatPhieuNhap();
        }
    }
    public void xuatDs() {
        if (dspn.length == 0)
        {
            System.out.println("Danh sách phiếu nhập trống.");
            return;
        }
        String format = "| %-15s | %-20s | %-15s | %-15s | %-15s |\n";
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.format(format, "Mã phiếu nhập", "Ngày nhập", "Mã NCC", "Mã NV", "Tổng tiền");
        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");

        for (int i = 0; i < dspn.length; i++) {
            System.out.format(format, dspn[i].getMaPN(), dspn[i].getNgayNhap(), dspn[i].getMaNCC(),
                    dspn[i].getMaNV(), dspn[i].getTongTien());
        }

        System.out.format("+-----------------+----------------------+-----------------+-----------------+-----------------+\n");
        System.out.println("\n");
    }

}