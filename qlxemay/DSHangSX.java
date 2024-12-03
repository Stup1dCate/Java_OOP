package qlxemay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DSHangSX {

    private ArrayList<HangSX> dshsx;
    private static int mahsx;

    public DSHangSX() {
        dshsx = new ArrayList<>();
    }

    public static int getMahsx() {
        return mahsx;
    }

    public static void setMahsx(int mahsx) {
        DSHangSX.mahsx = mahsx;
    }

    public ArrayList<HangSX> getDshsx() {
        return dshsx;
    }

    public void setDshsx(ArrayList<HangSX> dshsx) {
        this.dshsx = dshsx;
    }

    public void xem() {
        if (dshsx != null && !dshsx.isEmpty()) {
            System.out.println("\nTHONG TIN DANH SACH HANG SAN XUAT: ");
            for (HangSX hsx : dshsx) {
                hsx.xuat();
                System.out.println("____________________________________________________________________");
            }
            System.out.println("\n");
        } else {
            System.out.println("Danh sach trong.\n");
        }
    }

    public void them() {
        Scanner s = new Scanner(System.in);
        System.out.print("\t NHAP THONG TIN HANG SAN XUAT CAN THEM: \n");
        HangSX hsx = null;
        hsx = new HangSX();
        if (hsx != null) {
          int mahsx=0;
          for(HangSX hsx1:dshsx){
              mahsx=hsx1.getMahsx()+1;
          }
          hsx.setMahsx(mahsx);
          hsx.nhap();
          dshsx.add(hsx);
        }
        System.out.println("\n===== DA LUU DU LIEU HANG SAN XUAT THANH CONG ! =====\n");
    }

    public void sua() {
        ArrayList<HangSX> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Sua theo ten hang san xuat");
        System.out.println("2. Sua theo ma hang san xuat");
        System.out.print("Lua chon: ");
        
        int select;
        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                break;
            } else {
                sc.nextLine();
                System.out.println("Lua chon khong hop le! Vui long nhap lai: ");
            }
        }
        
        switch (select) {
            case 1:
                System.out.print("Nhap ten hang san xuat can chinh sua: ");
                sc.nextLine(); 
                String tensua = sc.nextLine();
                
                for (HangSX hsx : dshsx) {
                    if (hsx.getTenhsx().equals(tensua)) {
                        dstam.add(hsx);
                        hsx.xuat(); // Hiển thị thông tin hãng sản xuất
                    }
                }
    
                if (dstam.isEmpty()) {
                    System.out.println("Khong tim thay ten hang san xuat can chinh sua!");
                    return;
                }
    
                if (dstam.size() == 1) {
                    dstam.get(0).sua();
                    System.out.println("Sua thanh cong thong tin hang san xuat!");
                    return;
                }
    
                System.out.print("Co nhieu hang san xuat trung ten. Nhap ma hang san xuat can sua: ");
                int mahsx;
                while (true) {                        
                    if (sc.hasNextInt()) {
                        mahsx = sc.nextInt();
                        break;
                    } else {
                        System.out.print("Ma hang san xuat phai la so nguyen! Vui long nhap lai: ");
                        sc.nextLine();
                    }
                }
    
                for (HangSX hsx : dstam) {
                    if (hsx.getMahsx() == mahsx) {
                        hsx.xuat(); // Hiển thị thông tin trước khi sửa
                        hsx.sua();
                        System.out.println("Sua thanh cong thong tin hang san xuat!");
                        return;
                    }
                }
    
                System.out.printf("Khong tim thay hang san xuat co ten %s va ma %d!\n", tensua, mahsx);
                break;
    
            case 2:
                System.out.print("Nhap ma hang san xuat can sua: ");
                int mahsx2;
                while (true) {                        
                    if (sc.hasNextInt()) {
                        mahsx2 = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma hang san xuat phai la so nguyen. Vui long nhap lai");
                        sc.nextLine();
                    }
                }
    
                for (HangSX hsx : dshsx) {
                    if (hsx.getMahsx() == mahsx2) {
                        hsx.xuat(); // Hiển thị thông tin trước khi sửa
                        hsx.sua();
                        System.out.println("Sua thanh cong thong tin hang san xuat!");
                        return;
                    }
                }
    
                System.out.println("Khong tim thay ma hang san xuat can chinh sua!");
                break;
    
            default:
                System.out.println("Yeu cau khong hop le!");
        }
    }
    
    public void xoa() {
        ArrayList<HangSX> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Xoa theo ten hang san xuat");
        System.out.println("2.Xoa theo ma hang san xuat");
        System.out.print("Lua chon: ");
        int select;
        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                break;
            } else {
                sc.nextLine();
                System.out.print("Lua chon khong hop le! Vui long nhap lai: ");
            }
        }
        switch (select) {
            case 1:
                System.out.print("Nhap ten hang san xuat can xoa: ");
                sc.nextLine();
                String tensua = sc.nextLine();
                for (HangSX hsx : dshsx) {
                    if (hsx.getTenhsx().equals(tensua)) {
                        dstam.add(hsx);
                        hsx.xuat();
                    }
                }
                if (dstam.size() == 0) {
                    System.out.println("Khong tim thay ten hang san xuat can xoa!");
                    return;
                }
                if (dstam.size() == 1) {
                    for (HangSX hsx:dshsx) {
                        if (hsx.getTenhsx().equals(tensua)) {
                            dshsx.remove(hsx);
                            System.out.println("Xoa thanh cong hang san xuat!");
                            return;
                        }
                    }
                } else {
                    System.out.print("Nhap ma hang san xuat can xoa: ");
                    int mahsx;
                    while (true) {                        
                        if(sc.hasNextInt()){
                            mahsx=sc.nextInt();
                            break;
                        }
                        else{
                            System.out.print("Ma hang san xuat phai la so nguyen! Vui long nhap lai: ");
                            sc.nextLine();
                        }
                    }
                    for (HangSX hsx:dstam) {
                        if (hsx.getMahsx() == mahsx) {
                            dshsx.remove(hsx);
                            System.out.println("Xoa thanh cong hang san xuat!");
                            return;
                        }
                    }
                    System.out.printf("Khong tim thay hang san xuat ten %s co  ma %d",tensua,mahsx);
                    return;

                }
                System.out.println("Khong tim thay ten hang san xuat!");
                return;
            case 2:
                System.out.print("Nhap ma hang san xuat can xoa: ");
                int mahsx;
                while (true) {                        
                    if(sc.hasNextInt()){
                        mahsx=sc.nextInt();
                        break;
                    }
                    else{
                        System.out.println("Ma hang san xuat phai la so nguyen! Vui long nhap lai: ");
                        sc.nextLine();
                    }
                }
                for(HangSX hsx:dshsx){
                     if(hsx.getMahsx()==mahsx) {
                         dshsx.remove(hsx);
                         System.out.println("Xoa thanh cong hang san xuat!");
                         return;
                     }
                     
                 }
                System.out.println("Khong tim thay ma hang san xuat.");
                return;
            default:
                System.out.println("Yeu cau khong hop le!");
                return;
        }
    }

    public void timkiem() {
        ArrayList<HangSX> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Tim kiem theo ten hang san xuat");
        System.out.println("2. Tim kiem theo ma hang san xuat");
        System.out.print("Lua chon: ");
        int select;
        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                break;
            } else {
                sc.nextLine();
                System.out.print("Lua chon khong hop le! Vui long nhap lai: ");
            }
        }
        switch (select) {
            case 1:
                System.out.print("Nhap ten hang san xuat can tim: ");
                sc.nextLine(); // Đọc dòng thừa
                String tensua = sc.nextLine();
                for (HangSX hsx : dshsx) {
                    if (hsx.getTenhsx().equals(tensua)) {
                        dstam.add(hsx);
                        System.out.println("THONG TIN HANG SAN XUAT CAN TIM:");
                        hsx.xuat();
                    }
                }
                if (dstam.size() == 0) {
                    System.out.println("Khong tim thay ten hang san xuat!");
                }
                return;
            case 2:
                System.out.print("Nhap ma hang san xuat can tim: ");
                int mahsx;
                while (true) {
                    if (sc.hasNextInt()) {
                        mahsx = sc.nextInt();
                        break;
                    } else {
                        System.out.print("Ma hang san xuat phai la so nguyen! Vui long nhap lai: ");
                        sc.nextLine();
                    }
                }
                boolean found = false;
                for (HangSX hsx : dshsx) {
                    if (hsx.getMahsx() == mahsx) {
                        System.out.println("THONG TIN HANG SAN XUAT CAN TIM:");
                        hsx.xuat();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Khong tim thay hang san xuat co ma can tim!");
                }
                return;
            default:
                System.out.println("Yeu cau khong hop le!");
        }
    }
    

    public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Chuyển dòng văn bản thành đối tượng HangSX và thêm vào danh sách
                HangSX hsx = parseLineToHangSX(line);
                if (hsx != null) {

                    dshsx.add(hsx);
                }
            }
            System.out.println("Da tai danh sach tu tep tin: " + fileName + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep tin: " + fileName + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (HangSX hsx : dshsx) {
                // Ghi đối tượng HangSX thành dòng văn bản và xuống dòng
                writer.write(parseHangSXToLine(hsx));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng HangSX
    private HangSX parseLineToHangSX(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 4) {
            int mahsx = Integer.parseInt(parts[0]);
            String sdthsx = parts[1];
            String tenhsx = parts[2];
            String diachihsx = parts[3];
            return new HangSX(mahsx, tenhsx, diachihsx, sdthsx);
        }
        return null;
    }

    // Hàm chuyển đối tượng HangSX thành dòng văn bản
    private String parseHangSXToLine(HangSX hsx) {
        return hsx.getMahsx() + ";" + hsx.getSdthsx() + ";" + hsx.getTenhsx() + ";" + hsx.getDiachihsx();
    }
}
