/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DSHangSX {

    private ArrayList<HangSX> dsHang;
    Scanner sc = new Scanner(System.in);

    public DSHangSX() {
        dsHang = new ArrayList<>();
    }

    public ArrayList<HangSX> getDsHang() {
        return dsHang;
    }

    public void setDsHang(ArrayList<HangSX> dsHang) {
        this.dsHang = dsHang;
    }

    public void xem() {
        for (HangSX hang : dsHang) {
            hang.Xuat();
        }
    }

    public void them() {
        HangSX hang = null;
        hang.Nhap();
        if (hang != null) {
            dsHang.add(hang);
        }
    }

    public void sua() {
        System.out.println("Nhap ten hang san xuat can sua: ");
        String tensua;
        int look = 0;
        tensua = sc.nextLine();
        for (HangSX hang : dsHang) {
            if (hang.getTenhang().equals(tensua)) {
                System.out.println("Thong tin hang san xuat " + tensua);
                hang.Xuat();
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay hang SX!");
            return;
        }
        if (look == 1) {
            for (HangSX hang : dsHang) {
                if (hang.getTenhang().equals(tensua)) {
                    hang.Nhap();
                    System.out.println("Sua thanh cong!");
                    return;
                }
            }
        }
        System.out.println("Nhap ma hang san xuat muon sua: ");
        int ma = sc.nextInt();
        for (HangSX hang : dsHang) {
            if (hang.getMahangsx()==ma) {
                hang.Nhap();
                System.out.println("Sua thanh cong!");
                return;
            }
        }
    }

    public void xoa() {
       System.out.println("Nhap ten hang san xuat can xoa: ");
        String tenxoa;
        int look = 0;
        tenxoa = sc.nextLine();
        for (HangSX hang : dsHang) {
            if (hang.getTenhang().equals(tenxoa)) {
                System.out.println("Thong tin hang san xuat " + tenxoa);
                hang.Xuat();
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay hang SX!");
            return;
        }
        if (look == 1) {
            for (HangSX hang : dsHang) {
                if (hang.getTenhang().equals(tenxoa)) {
                    dsHang.remove(hang);
                    System.out.println("Xoa thanh cong!");
                    return;
                }
            }
        }
        System.out.println("Nhap ma hang san xuat muon xoa: ");
        int ma = sc.nextInt();
        for (HangSX hang : dsHang) {
            if (hang.getMahangsx()==ma) {
                dsHang.remove(hang);
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
    }

    public void timkiem() {
        
        System.out.println("Nhap ten hang san xuat can tim:");
        String search = sc.nextLine();
        for (HangSX hang : dsHang) {
            if (hang.getTenhang().equals(search)) {
                hang.Xuat();
            }
            return;
        }
        System.out.println("Khong tim thay!");
    }

    private String parseHangSXtoLine(HangSX hang) {
        String tenhang = hang.getTenhang();
        String Sdthang = hang.getSdthang();
        String diachi = hang.getDiachi();
        int mahang=hang.getMahangsx();
        return tenhang + ";" +mahang+";" + Sdthang + ";" + diachi;
    }

    public void XuatDSraFile(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (HangSX hang : dsHang) {
                writer.write(parseHangSXtoLine(hang));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HangSX parseLinetoHangSX(String line) {
        String[] pack = line.split(";");
        String tenhang = pack[0];
        int mahang=Integer.parseInt(pack[1]);
        String Sdthang = pack[2];
        String diachi = pack[3];
        HangSX hang = new HangSX(tenhang,mahang, Sdthang, diachi);
        return hang;
    }

    public void LoadFiletoDS(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                HangSX hang = new HangSX();
                hang = parseLinetoHangSX(line);
                dsHang.add(hang);
            }
            System.out.println("Đã tải danh sách từ tệp tin: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp tin: " + filename);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
