package List;
import java.util.Scanner;
import java.util.Arrays;
import Constructors.NhaCungCap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import Interfaces.InterfaceDocGhi;
import TypeNCC.NhaCungCapQuocTe;
public class DanhSachNCC implements InterfaceDocGhi
{
    private NhaCungCap[] dsncc;
    public DanhSachNCC()
    {
        dsncc=new NhaCungCap[0];
    }
    public DanhSachNCC(NhaCungCap[] dsncc)
    {
        this.dsncc=dsncc;
    }
    public boolean trungMaNcc(String maNCC)
    {
        for (NhaCungCap ds : dsncc)
        {
            if (ds != null && ds.getMaNCC().equals(maNCC)) {
                return true;
            }
        }
        return false;
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng nhà cung cấp: ");
        int n = sc.nextInt();
        sc.nextLine();
        dsncc = new NhaCungCap[n];
        for (int i = 0; i < n; i++) {
            NhaCungCap ncc = new NhaCungCap();
            do {
                ncc.nhap();
                if (trungMaNcc(ncc.getMaNCC())) {
                    System.out.println("Mã nhà cung cấp này đã bị trùng vui lòng nhập lại !!!");
                }
            } while (trungMaNcc(ncc.getMaNCC()));

            dsncc[i] = ncc;
        }
    }
    public void nhapKtrung() {
        Scanner sc = new Scanner(System.in);
        int n = dsncc.length;
        int k;
        do {
            System.out.print("Nhập số lượng nhà cung cấp: ");
            k = sc.nextInt();
            sc.nextLine();
            if (k < 0) {
                System.out.println("Vui lòng nhập lại !!!");
            }
        } while (k < 0);

        dsncc = Arrays.copyOf(dsncc, n + k);
        for (int i = 0; i < k; i++) {
            System.out.println("Chọn loại nhà cung cấp:");
            System.out.println("1. Nhà cung cấp nội địa");
            System.out.println("2. Nhà cung cấp quốc tế");
            int choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ nhớ đệm

            NhaCungCap ncc;

            if (choice == 1) {
                ncc = new NhaCungCap(); // Tạo NCC Nội Địa
            } else if (choice == 2) {
                ncc = new NhaCungCapQuocTe(); // Tạo NCC Quốc Tế
            } else {
                System.out.println("Lựa chọn không hợp lệ, tạo NCC Nội Địa mặc định.");
                ncc = new NhaCungCap(); // Mặc định tạo NCC Nội Địa
            }

            // Nhập thông tin cho nhà cung cấp
            do {
                ncc.nhap(); // Nhập thông tin cho NCC
                if (trungMaNcc(ncc.getMaNCC())) {
                    System.out.println("Mã nhà cung cấp này đã bị trùng vui lòng nhập lại.");
                }
            } while (trungMaNcc(ncc.getMaNCC()));

            // Nếu là NCC Quốc Tế, nhập thêm quốc gia
            if (ncc instanceof NhaCungCapQuocTe) {
                NhaCungCapQuocTe nccQuocTe = (NhaCungCapQuocTe) ncc;
                Scanner sc2 = new Scanner(System.in);
                System.out.print("Nhập quốc gia của nhà cung cấp quốc tế: ");
                nccQuocTe.setQuocGia(sc2.nextLine()); // Nhập quốc gia
            }

            // Lưu nhà cung cấp vào mảng dsncc
            dsncc[n + i] = ncc;
        }
    }
    public void themkNCC() {
        Scanner sc = new Scanner(System.in);
        int n = dsncc.length;
        int k;

        while (true) {
            System.out.print("Bạn có muốn thêm nhà cung cấp không? (Y/N): ");
            String choice = sc.nextLine().trim();

            if (choice.equalsIgnoreCase("Y")) {
                do {
                    System.out.print("Nhập số lượng nhà cung cấp: ");
                    // Kiểm tra nếu nhập số lượng là một số hợp lệ
                    while (!sc.hasNextInt()) {
                        System.out.println("Vui lòng nhập một số hợp lệ!");
                        sc.nextLine();  // Đọc và bỏ qua dữ liệu không hợp lệ
                    }
                    k = sc.nextInt();
                    sc.nextLine(); // Đọc ký tự newline còn lại
                    if (k < 0) {
                        System.out.println("Số lượng nhà cung cấp phải là số dương. Vui lòng nhập lại.");
                    }
                } while (k < 0);

                // Tăng kích thước mảng dsncc để chứa thêm nhà cung cấp
                dsncc = Arrays.copyOf(dsncc, n + k);
                for (int i = 0; i < k; i++) {
                    System.out.println("Chọn loại nhà cung cấp:");
                    System.out.println("1. Nhà cung cấp nội địa");
                    System.out.println("2. Nhà cung cấp quốc tế");
                    int choiceType = sc.nextInt();
                    sc.nextLine(); // Xóa bộ nhớ đệm

                    NhaCungCap ncc;

                    if (choiceType == 1) {
                        ncc = new NhaCungCap(); // Tạo NCC Nội Địa
                    } else if (choiceType == 2) {
                        ncc = new NhaCungCapQuocTe(); // Tạo NCC Quốc Tế
                    } else {
                        System.out.println("Lựa chọn không hợp lệ, tạo NCC Nội Địa mặc định.");
                        ncc = new NhaCungCap(); // Mặc định tạo NCC Nội Địa
                    }

                    // Nhập thông tin cho nhà cung cấp
                    do {
                        ncc.nhap(); // Nhập thông tin cho NCC
                        if (trungMaNcc(ncc.getMaNCC())) {
                            System.out.println("Mã nhà cung cấp này đã bị trùng vui lòng nhập lại.");
                        }
                    } while (trungMaNcc(ncc.getMaNCC()));

                    // Nếu là NCC Quốc Tế, nhập thêm quốc gia
                    if (ncc instanceof NhaCungCapQuocTe) {
                        NhaCungCapQuocTe nccQuocTe = (NhaCungCapQuocTe) ncc;
                        Scanner sc2 = new Scanner(System.in);
                        System.out.print("Nhập quốc gia của nhà cung cấp quốc tế: ");
                        nccQuocTe.setQuocGia(sc2.nextLine()); // Nhập quốc gia
                    }

                    // Lưu nhà cung cấp vào mảng dsncc
                    dsncc[n + i] = ncc;
                }
            } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("Cảm ơn bạn !!!");
                break;
            } else {
                System.out.println("Vui lòng nhập (Y/N) !!!");
            }
        }
    }

    public void xoaMotNCC()
    {
        int n=dsncc.length;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp muốn xóa : ");
        String xoaMa=sc.nextLine();
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(dsncc[i].getMaNCC().equals(xoaMa))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            for(int i=index;i<n-1;i++)
            {
                dsncc[i]=dsncc[i+1];
            }
            dsncc=Arrays.copyOf(dsncc,n-1);
        }
        else
        {
            System.out.println("Không tìm thấy vị trí cần xóa !!!");
        }
    }
    public void timMaNCC()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp cần tìm kiếm : ");
        String maTim=sc.nextLine();
        int n=dsncc.length;
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(dsncc[i].getMaNCC().equals(maTim))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            System.out.println("Vị trí của nhà cung cấp là : " + index);
            dsncc[index].xuat();
        }
        else
        {
            System.out.println("Không tìm thấy vị trí trong danh sách");
        }
    }
    public void suaNCC()
    {
        Scanner sc=new Scanner(System.in);
        int n=dsncc.length;
        int index=-1;
        System.out.print("Nhập mã nhà cung cấp cần sửa đổi : ");
        String find=sc.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dsncc[i].getMaNCC().equals(find))
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
                System.out.println("1. Sửa đổi tên nhà cung cấp");
                System.out.println("2. Sửa đổi số điện thoại nhà cung cấp");
                System.out.println("3. Sửa đổi địa chỉ nhà cung cấp");
                System.out.println("4. Thoát");
                System.out.println("----------------------------------");
                System.out.print("Vui lòng nhập lựa chọn của bạn (1->4) : ");
                choice=sc.nextInt();
                sc.nextLine();
                switch(choice)
                {
                    case 1:
                    {
                        System.out.print("Nhập tên mới cho nhà cung cấp : ");
                        String newName=sc.nextLine();
                        dsncc[index].setTenNCC(newName);
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Nhập số điện thoại mới cho nhà cung cấp : ");
                        String newPhone=sc.nextLine();
                        dsncc[index].setSdtNCC(newPhone);
                        break;
                    }
                    case 3:
                    {
                        System.out.print("Nhập địa chỉ mới cho nhà cung cấp : ");
                        String newAdd=sc.nextLine();
                        dsncc[index].setDiachiNCC(newAdd);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Tạm biệt bạn !!!");
                        break;
                    }
                    default:
                        System.out.println("Lưa chọn của bạn không hơp lệ vui lòng chọn (1->4)");
                }
            }while(choice!=4);
        }
        else
        {
            System.out.println("Không tìm thấy mã nhà cung cấp cần sửa đổi !!!");
        }
    }
    public void timKiemTen()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Vui lòng nhập tên nhà cung cấp cần tim kiếm : ");
        String findTen=sc.nextLine();
        int index=-1;
        for(int i=0;i<dsncc.length;i++)
        {
            if(dsncc[i].getTenNCC().equals(findTen))
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            System.out.println("Vị trí của tên nhà cung cấp cần tìm là : " + index);
            System.out.println("--Thông tin của nhà cung cấp--");
            dsncc[index].xuat();
        }
    }
    public void thongKeNCC()
    {
        int d=0;
        for(int i=0;i<dsncc.length;i++)
        {
            d++;
        }
        System.out.println("Có "+d+" nhà cung cấp trong danh sách");
    }
    public void timKiemGanDung()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Vui lòng nhập tên cần tìm kiếm : ");
        String findName=sc.nextLine().toLowerCase();
        boolean found=false;
        for(int i=0;i<dsncc.length;i++)
        {
            if(dsncc[i].getTenNCC().toLowerCase().contains(findName))
            {
                System.out.println("Vị trí của tên cần tìm là : " + i);
                System.out.println("--Thông tin của nhà cung cấp--");
                dsncc[i].xuat();
                found=true;
            }
        }
        if(!found)
        {
            System.out.println("Không tìm thấy nhà cung cấp cần tìm !!!");
        }
    }
    public NhaCungCap timNhaCungCapTheoMa(String maNCC) {
        for (NhaCungCap ncc : dsncc) {
            if (ncc != null && ncc.getMaNCC().equalsIgnoreCase(maNCC)) {
                return ncc;
            }
        }
        return null; // Không tìm thấy
    }

    public void xuat() {
        if (dsncc.length == 0) {
            System.out.println("Danh sách nhà cung cấp trống.");
            return;
        }

        String format = "| %-5s | %-15s | %-20s | %-15s | %-55s | %-15s |\n";
        System.out.format("+-------+-----------------+----------------------+-----------------+---------------------------------------------------------+-----------------+\n");
        System.out.format(format, "STT", "Mã NCC", "Tên NCC", "SĐT", "Địa chỉ", "Quốc gia");
        System.out.format("+-------+-----------------+----------------------+-----------------+---------------------------------------------------------+-----------------+\n");

        for (int i = 0; i < dsncc.length; i++) {
            if(dsncc[i] != null)
            {
                String quocGia = (dsncc[i] instanceof NhaCungCapQuocTe)
                        ? ((NhaCungCapQuocTe) dsncc[i]).getQuocGia()
                        : "Nội địa";
                System.out.format(format, i + 1, dsncc[i].getMaNCC(), dsncc[i].getTenNCC(),
                        dsncc[i].getSdtNCC(), dsncc[i].getDiachiNCC(), quocGia);
            }
        }

        System.out.format("+-------+-----------------+----------------------+-----------------+---------------------------------------------------------+-----------------+\n");
        System.out.println("\n");
    }

    public String[] layDanhSachMaNCC() {
        String[] maNCCs = new String[dsncc.length];
        for (int i = 0; i < dsncc.length; i++) {
            maNCCs[i] = dsncc[i].getMaNCC();
        }
        return maNCCs;
    }
    public void docFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/data/ListNCC.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống

                // Tách các phần từ dòng đọc được
                String[] parts = line.split(";");

                // Kiểm tra nếu dữ liệu không đủ phần tử
                if (parts.length < 4) {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                    continue;
                }

                // Đọc các thuộc tính chung
                String maNCC = parts[0];
                String tenNCC = parts[1];
                String sdtNCC = parts[2];
                String diachiNCC = parts[3];

                // Kiểm tra xem nhà cung cấp có phải là NhaCungCapQuocTe
                NhaCungCap ncc;
                if (parts.length > 4 && !parts[4].isEmpty()) {
                    String quocGia = parts[4];
                    ncc = new NhaCungCapQuocTe(maNCC, tenNCC, sdtNCC, diachiNCC, quocGia);
                } else {
                    ncc = new NhaCungCap(maNCC, tenNCC, sdtNCC, diachiNCC);
                }

                // Thêm đối tượng vào danh sách
                dsncc = Arrays.copyOf(dsncc, dsncc.length + 1);
                dsncc[dsncc.length - 1] = ncc;
            }
            System.out.println("Dữ liệu đã được đọc thành công từ file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/ListNCC.txt"))) {
            if (dsncc.length == 0) {
                System.out.println("Danh sách nhà cung cấp trống, không có dữ liệu để xuất.");
                return;
            }

            for (NhaCungCap ncc : dsncc) {
                if (ncc != null) {
                    String data = ncc.getMaNCC() + ";" +
                            ncc.getTenNCC() + ";" +
                            ncc.getSdtNCC() + ";" +
                            ncc.getDiachiNCC() + ";" +
                            (ncc instanceof NhaCungCapQuocTe ? ((NhaCungCapQuocTe) ncc).getQuocGia() : "") + "\n";
                    writer.write(data);  // Ghi dữ liệu vào file
                }
            }
            System.out.println("Dữ liệu nhà cung cấp đã được ghi vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }


}


