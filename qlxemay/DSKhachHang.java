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
        System.out.println("1. Sua theo ten khach hang");
        System.out.println("2. Sua theo ma khach hang");
        System.out.print("Lua chon: ");
        int select;
    
        // Kiểm tra lựa chọn nhập vào
        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                sc.nextLine(); 
                break;
            } else {
                sc.nextLine();
                System.out.print("Lua chon khong hop le! Vui long nhap lai: ");
            }
        }
    
        switch (select) {
            case 1: 
                System.out.print("Nhap ten khach hang can sua: ");
                String tensua;
                while (true) {
                    tensua = sc.nextLine().trim();
                    if (tensua.matches("[a-zA-Z\\s]+")) { 
                        break;
                    } else {
                        System.out.println("Ten khach hang khong duoc chua so hoac ky tu dac biet! Vui long nhap lai: ");
                    }
                }
                for (KhachHang kh : dsKhachHang) {
                    if (kh.getTenkh().equalsIgnoreCase(tensua)) { 
                        dstam.add(kh);
                        kh.xuat();
                    }
                }
                if (dstam.isEmpty()) {
                    System.out.println("Khong tim thay ten khach hang can sua!");
                    return;
                }
                if (dstam.size() == 1) {
                    for (KhachHang kh : dsKhachHang) {
                        if (kh.getTenkh().equalsIgnoreCase(tensua)) {
                            kh.sua();
                            System.out.println("Sua thanh cong thong tin khach hang!");
                            return;
                        }
                    }
                } else {
                    System.out.print("Nhap ma khach hang can sua: ");
                    int makh;
                    while (true) {
                        if (sc.hasNextInt()) {
                            makh = sc.nextInt();
                            sc.nextLine();
                            break;
                        } else {
                            System.out.print("Ma khach hang phai la so nguyen! Vui long nhap lai: ");
                            sc.nextLine(); 
                        }
                    }
                    for (KhachHang kh : dstam) {
                        if (kh.getMakh() == makh) {
                            kh.sua();
                            System.out.println("Sua thanh cong thong tin khach hang!");
                            return;
                        }
                    }
                    System.out.printf("Khong tim thay khach hang ten \"%s\" co ma %d%n", tensua, makh);
                }
                break;
    
            case 2: 
                System.out.print("Nhap ma khach hang can sua: ");
                int makh;
                while (true) {
                    if (sc.hasNextInt()) {
                        makh = sc.nextInt();
                        sc.nextLine();
                        break;
                    } else {
                        System.out.print("Ma khach hang phai la so nguyen! Vui long nhap lai: ");
                        sc.nextLine();
                    }
                }
                for (KhachHang kh : dsKhachHang) {
                    if (kh.getMakh() == makh) {
                        kh.sua();
                        System.out.println("Sua thanh cong thong tin khach hang!");
                        return;
                    }
                }
                System.out.println("Khong tim thay ma khach hang can sua!");
                break;
    
            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }
    }
    
    public void xoa() {
        ArrayList<KhachHang> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Xoa theo ten khach hang");
        System.out.println("2. Xoa theo ma khach hang");
        System.out.print("Lua chon: ");
        int select;

        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                sc.nextLine();
                System.out.print("Lua chon khong hop le! Vui long nhap lai: ");
            }
        }
    
        switch (select) {
            case 1: 
                System.out.print("Nhap ten khach hang can xoa: ");
                String tensua;
                while (true) {
                    tensua = sc.nextLine().trim();
                    if (tensua.matches("[a-zA-Z\\s]+")) { 
                        break;
                    } else {
                        System.out.print("Ten khach hang khong duoc chua so hoac ky tu dac biet! Vui long nhap lai: ");
                    }
                }
                for (KhachHang kh : dsKhachHang) {
                    if (kh.getTenkh().equalsIgnoreCase(tensua)) { 
                        dstam.add(kh);
                        kh.xuat(); 
                    }
                }
                if (dstam.isEmpty()) {
                    System.out.println("Khong tim thay ten khach hang can xoa!");
                    return;
                }
                if (dstam.size() == 1) {
                    for (KhachHang kh : dsKhachHang) {
                        if (kh.getTenkh().equalsIgnoreCase(tensua)) {
                            dsKhachHang.remove(kh);
                            System.out.println("Xoa thanh cong khach hang!");
                            return;
                        }
                    }
                } else {
                    System.out.print("Nhap ma khach hang can xoa: ");
                    int makh;
                    while (true) {
                        if (sc.hasNextInt()) {
                            makh = sc.nextInt();
                            sc.nextLine(); 
                            break;
                        } else {
                            System.out.print("Ma khach hang phai la so nguyen! Vui long nhap lai: ");
                            sc.nextLine(); 
                        }
                    }
                    for (KhachHang kh : dstam) {
                        if (kh.getMakh() == makh) {
                            dsKhachHang.remove(kh);
                            System.out.println("Xoa thanh cong khach hang!");
                            return;
                        }
                    }
                    System.out.printf("Khong tim thay khach hang ten \"%s\" co ma %d%n", tensua, makh);
                }
                break;
    
            case 2: 
                System.out.print("Nhap ma khach hang can xoa: ");
                int makh;
                while (true) {
                    if (sc.hasNextInt()) {
                        makh = sc.nextInt();
                        sc.nextLine(); 
                        break;
                    } else {
                        System.out.print("Ma khach hang phai la so nguyen! Vui long nhap lai: ");
                        sc.nextLine(); 
                    }
                }
                for (KhachHang kh : dsKhachHang) {
                    if (kh.getMakh() == makh) {
                        dsKhachHang.remove(kh);
                        System.out.println("Xoa thanh cong khach hang!");
                        return;
                    }
                }
                System.out.println("Khong tim thay ma khach hang!");
                break;
    
            default:
                System.out.println("Yeu cau khong hop le!");
                break;
        }
    }
    

    public void timkiem() {
        ArrayList<KhachHang> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Tim kiem theo ten khach hang");
        System.out.println("2. Tim theo ma khach hang");
        System.out.print("Lua chon: ");
        int select;
    
        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                sc.nextLine();
                System.out.print("Lua chon khong hop le! Vui long nhap lai: ");
            }
        }
    
        switch (select) {
            case 1:
                System.out.print("Nhap ten khach hang: ");
                String tensua = sc.nextLine().trim();
                for (KhachHang kh : dsKhachHang) {
                    if (kh.getTenkh().equalsIgnoreCase(tensua)) { 
                        dstam.add(kh);
                        System.out.println("Thong tin khach hang can tim: ");
                        kh.xuat(); 
                    }
                }
                if (dstam.isEmpty()) {
                    System.out.println("Khong tim thay ten khach hang!");
                } else {
                    System.out.println("Tim thay " + dstam.size() + " khach hang co ten \"" + tensua + "\"");
                }
                break;
    
            case 2: 
                System.out.print("Nhap ma khach hang: ");
                int makh;
                while (true) {
                    if (sc.hasNextInt()) {
                        makh = sc.nextInt();
                        sc.nextLine(); 
                        break;
                    } else {
                        System.out.print("Ma khach hang phai la so nguyen! Vui long nhap lai:");
                        sc.nextLine(); 
                    }
                }
                boolean found = false;
                for (KhachHang kh : dsKhachHang) {
                    if (kh.getMakh() == makh) {
                        System.out.println("Thong tin khach hang can tim: ");
                        kh.xuat(); 
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Khong tim thay ma khach hang!");
                }
                break;
    
            default:
                System.out.println("Yeu cau khong hop le!");
        }
    }
    

    public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                KhachHang kh = parseLineToKhachHang(line);
                if (kh != null) {
                    dsKhachHang.add(kh);  
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
                writer.write(parseKhachHangToLine(kh));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private KhachHang parseLineToKhachHang(String line) {
        String[] parts = line.split(";"); 
        if (parts.length == 6) {
            int makh = Integer.parseInt(parts[0]);
            String sdtkh = parts[1];
            String tenkh = parts[2];
            String age = parts[3];

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
        return null; 
    }
}
