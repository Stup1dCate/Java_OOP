package qlxemay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DSKhachHang {

    private ArrayList<KhachHang> dsKhachHang;
    private static int makhtt;

    public DSKhachHang() {
        dsKhachHang = new ArrayList<>();  // Khởi tạo danh sách khách hàng
    }

    public static int getMakhtt() {
        return makhtt;
    }

    public static void setMakhtt(int makhtt) {
        DSKhachHang.makhtt = makhtt;
    }

    public ArrayList<KhachHang> getdsKhachHang() {
        return dsKhachHang;
    }

    public void setdsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public void xem() {
        if (dsKhachHang != null && !dsKhachHang.isEmpty()) {
            System.out.println("\nTHONG TIN DANH SACH KHACH HANG: ");
            for (KhachHang kh : dsKhachHang) {
                kh.xuat();
            }
            System.out.println("\n");
        } else {
            System.out.println("Danh sach trong.\n");
        }
    }

    public void them() {
        Scanner s = new Scanner(System.in);
        System.out.print("\t NHAP THONG TIN KHACH HANG CAN THEM: \n");
        KhachHang kh = null;
        kh = new KhachHang();
        if (kh != null) {
          int makh=0;
          for(KhachHang kh1:dsKhachHang){
              makh=kh1.getMakh()+1;
          }
          kh.setMakh(makh);
          kh.nhap();
          dsKhachHang.add(kh);
        }
        System.out.println("\n===== DA LUU DU LIEU KHACH HANG THANH CONG ! =====\n");
    }

    public void sua() {
        ArrayList<KhachHang> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Sua theo ten khach hang");
        System.out.println("2.Sua theo ma khach hang");
        int select;
        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                break;
            } else {
                sc.nextLine();
                System.out.println("Khong hop le! Vui long nhap lai");
            }
        }
        switch (select) {
            case 1:
                System.out.println("Nhap ten khach hang:");
                sc.nextLine();
                String tensua = sc.nextLine();
                for (KhachHang kh : dsKhachHang) {
                    if (kh.getTenkh().equals(tensua)) {
                        dstam.add(kh);
                        kh.xuat();
                    }
                }
                if (dstam.size() == 0) {
                    System.out.println("Khong tim thay ten khach hang!");
                    return;
                }
                if (dstam.size() == 1) {
                    for (KhachHang kh : dsKhachHang) {
                        if (kh.getTenkh().equals(tensua)) {
                            kh.sua();
                            System.out.println("Sua thanh cong!");
                            return;
                        }
                    }
                } else {
                    System.out.println("Nhap ma khach hang can sua:");
                    int makh;
                    while (true) {                        
                        if(sc.hasNextInt()){
                            makh=sc.nextInt();
                            break;
                        }
                        else{
                            System.out.println("Ma khach hang phai la so nguyen. Vui long nhap lai");
                            sc.nextLine();
                        }
                    }
                    for (KhachHang kh : dstam) {
                        if (kh.getMakh() == makh) {
                            kh.sua();
                            System.out.println("Sua thanh cong!");
                            return;
                        }
                    }
                    System.out.printf("Khong tim thay khach hang  ten %s co  ma %d",tensua,makh);
                    return;

                }
                System.out.println("Khong tim thay ten khach hang");
                return;
            case 2:
                int makh;
                 while (true) {                        
                        if(sc.hasNextInt()){
                            makh=sc.nextInt();
                            break;
                        }
                        else{
                            System.out.println("Ma khach hang phai la so nguyen. Vui long nhap lai");
                            sc.nextLine();
                        }
                    }
                 for(KhachHang kh:dsKhachHang){
                     if(kh.getMakh()==makh) {
                         kh.sua();
                         System.out.println("Sua thanh cong!");
                         return;
                     }
                     
                 }
                System.out.println("Khong tim thay ma khach hang.");
                return;
            default:
                System.out.println("Khong hop le!");
                return;
        }
    }
    public void xoa() {
        ArrayList<KhachHang> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Xoa theo ten khach hang");
        System.out.println("2.Xoa theo ma khach hang");
        int select;
        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                break;
            } else {
                sc.nextLine();
                System.out.println("Khong hop le! Vui long nhap lai");
            }
        }
        switch (select) {
            case 1:
                System.out.println("Nhap ten khach hang:");
                sc.nextLine();
                String tensua = sc.nextLine();
                for (KhachHang kh : dsKhachHang) {
                    if (kh.getTenkh().equals(tensua)) {
                        dstam.add(kh);
                        kh.xuat();
                    }
                }
                if (dstam.size() == 0) {
                    System.out.println("Khong tim thay ten khach hang!");
                    return;
                }
                if (dstam.size() == 1) {
                    for (KhachHang kh : dsKhachHang) {
                        if (kh.getTenkh().equals(tensua)) {
                            dsKhachHang.remove(kh);
                            System.out.println("Xoa thanh cong!");
                            return;
                        }
                    }
                } else {
                    System.out.println("Nhap ma khach hang can xoa:");
                    int makh;
                    while (true) {                        
                        if(sc.hasNextInt()){
                            makh=sc.nextInt();
                            break;
                        }
                        else{
                            System.out.println("Ma khach hang phai la so nguyen. Vui long nhap lai");
                            sc.nextLine();
                        }
                    }
                    for (KhachHang kh : dstam) {
                        if (kh.getMakh() == makh) {
                            dsKhachHang.remove(kh);
                            System.out.println("Xoa thanh cong!");
                            return;
                        }
                    }
                    System.out.printf("Khong tim thay khach hang  ten %s co  ma %d",tensua,makh);
                    return;

                }
                System.out.println("Khong tim thay ten khach hang");
                return;
            case 2:
                int makh;
                 while (true) {                        
                        if(sc.hasNextInt()){
                            makh=sc.nextInt();
                            break;
                        }
                        else{
                            System.out.println("Ma khach hang phai la so nguyen. Vui long nhap lai");
                            sc.nextLine();
                        }
                    }
                 for(KhachHang kh:dsKhachHang){
                     if(kh.getMakh()==makh) {
                         dsKhachHang.remove(kh);
                         System.out.println("Xoa thanh cong!");
                         return;
                     }
                     
                 }
                System.out.println("Khong tim thay ma khach hang.");
                return;
            default:
                System.out.println("Khong hop le!");
                return;
        }
    }

    public void timkiem() {
     ArrayList<KhachHang> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Tim kiem theo ten khach hang");
        System.out.println("2.Tim theo ma khach hang");
        int select;
        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                break;
            } else {
                sc.hasNextLine();
                System.out.println("Khong hop le! Vui long nhap lai");
            }
        }
        switch (select) {
            case 1:
                System.out.println("Nhap ten khach hang:");
                sc.nextLine();
                String tensua = sc.nextLine();
                for (KhachHang kh : dsKhachHang) {
                    if (kh.getTenkh().equals(tensua)) {
                        dstam.add(kh);
                        kh.xuat();
                    }
                }
                if (dstam.size() == 0) {
                    System.out.println("Khong tim thay ten khach hang!");
                    return;
                }
            case 2:
                int makh;
                 while (true) {                        
                        if(sc.hasNextInt()){
                            makh=sc.nextInt();
                            break;
                        }
                        else{
                            System.out.println("Ma khach hang phai la so nguyen. Vui long nhap lai");
                            sc.nextLine();
                        }
                    }
                 for(KhachHang kh:dsKhachHang){
                     if(kh.getMakh()==makh) {
                         kh.xuat();
                         return;
                     }
                     
                 }
                System.out.println("Khong tim thay ma khach hang.");
                return;
            default:
                System.out.println("Khong hop le!");
                return;
        }
    }

    public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Chuyển dòng văn bản thành đối tượng KhachHang và thêm vào danh sách ds3
                KhachHang kh = parseLineToKhachHang(line);
                if (kh != null) {
                    dsKhachHang.add(kh);  // Thêm vào danh sách dsKhachHang
                }
            }
            System.out.println("Da tai danh sach tu tap tin: " + fileName + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tap tin: " + fileName + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (KhachHang kh : dsKhachHang) {
                // Ghi đối tượng NhaCungCap thành dòng văn bản và xuống dòng
                writer.write(parseKhachHangToLine(kh));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng hangSX
    private KhachHang parseLineToKhachHang(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 6) {
            int makh = Integer.parseInt(parts[0]);
            String sdtkh = parts[1];
            String tenkh = parts[2];
            int age = Integer.parseInt(parts[3]);

            String diachikh = parts[4];
            String phaikh = parts[5];
            return new KhachHang(makh, age, sdtkh, tenkh, diachikh, phaikh);
        }
        return null;
    }

    // Hàm chuyển đối tượng HangSX thành dòng văn bản
    private String parseKhachHangToLine(KhachHang kh) {
        return kh.getMakh() + ";" + kh.getSdtkh() + ";" + kh.getTenkh() + ";" + kh.getAge() + ";" + kh.getDiachikh() + ";" + kh.getPhai();
    }

    public KhachHang timKiemKhachHangTheoMa(int maKhachHang) {
        for (KhachHang kh : dsKhachHang) {
            if (kh.getMakh() == maKhachHang) {
                return kh;
            }
        }
        System.out.println("Khong tim thay khach hang voi ma so: " + maKhachHang);
        return null; // Trả về null nếu không tìm thấy
    }
}
