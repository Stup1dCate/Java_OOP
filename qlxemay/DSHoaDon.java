package qlxemay;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

class DSHoaDon {
    private ArrayList<HoaDon> dsHoaDon;
    private Scanner reader = new Scanner(System.in);

    public DSHoaDon() {
        dsHoaDon = new ArrayList<>();
    }

    public ArrayList<HoaDon> getDsHD() {
        return dsHoaDon;
    }

    public void setDsHoaDon(ArrayList<HoaDon> dsHoaDon) {
        this.dsHoaDon = dsHoaDon;
    }

    public void xem() {
        for (HoaDon hd : dsHoaDon) {
            hd.Xuat();
        }
    }

    public void them() {
        HoaDon hd = new HoaDon();
        hd.Nhap();
        dsHoaDon.add(hd);
    }

    public void sua() {
        System.out.print("Nhập mã số hóa đơn cần sửa: ");
        String msHDcansua = reader.nextLine();
        for (HoaDon hd : dsHoaDon) {
            if (hd.getMahd().equals(msHDcansua)) {
                hd.sua();
                System.out.println("Đã sửa thông tin hóa đơn.");
                return;
            }
        }
        System.err.println("Không tìm thấy hóa đơn cần sửa.");
    }

    public void xoa() {
        System.out.print("Nhập mã số hóa đơn cần xóa: ");
        String msHDcanxoa = reader.nextLine();
        for (HoaDon hd : dsHoaDon) {
            if (hd.getMahd().equals(msHDcanxoa)) {
                dsHoaDon.remove(hd);
                System.out.println("Đã xóa thông tin hóa đơn.");
                return;
            }
        }
        System.err.println("Không tìm thấy hóa đơn cần xóa.");
    }

    public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                HoaDon hd = parseLineToHoaDon(line);
                if (hd != null) {
                    dsHoaDon.add(hd);  
                }
            }
            System.out.println("Đã tải danh sách từ tệp tin: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp tin: " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (HoaDon hd : dsHoaDon) {
                writer.write(parseHoaDonToLine(hd));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HoaDon parseLineToHoaDon(String line) {
        String[] parts = line.split(";");
        if (parts.length == 5) {
            int mahd = Integer.parseInt(parts[0]);
            String ngaythanhtoan = parts[1];
            KhachHang khachhang = new KhachHang(parts[2]);
            int masp = Integer.parseInt(parts[3]);
            int SoSPmua = Integer.parseInt(parts[4]);
            return new HoaDon(mahd, ngaythanhtoan, khachhang, masp, SoSPmua);
        }
        return null;
    }

    private String parseHoaDonToLine(HoaDon hd) {
        return hd.getMahd() + ";" + hd.getNgaythanhtoan() + ";" + hd.getKhachhang().toString() + ";" + hd.getMasp() + ";" + hd.getSoSPmua();
    }
}
