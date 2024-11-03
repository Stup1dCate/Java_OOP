package qlxemay;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

class DsHoaDon{
    private ArrayList<HoaDon> dsHoaDon;
    Scanner reader = new Scanner (System.in);
    public DsHoaDon()
    {
        dsHoaDon = new ArrayList<>();
    }
    public ArrayList<HoaDon> getDsHD() {
        return dsHoaDon;
    }
    public void setDsHoaDon(ArrayList<HoaDon> dsHoaDon) {
        this.dsHoaDon = dsHoaDon;
    }
    public void xem()
    {
        for(HoaDon hd: dsHoaDon)
        {
            hd.Xuat();
        }
    }
    public void them()
    {
        HoaDon hd = null;
        hd = new HoaDon();
        if(hd!=null)
        {
            hd.Nhap();
            dsHoaDon.add(hd);
        }
    }
    public void sua()
    {
        System.out.print("nhập mã số hóa đơn cần sửa: ");
        int msHDcansua = reader.nextInt();
        for(HoaDon hd : dsHoaDon)
        {
            if(hd.getMaHd().equals(msHDcansua))
            {
                hd.sua();
                System.out.println("đã sửa thông tin hóa đơn");
                return;
            }
        }
        System.err.println("không tìm thấy hóa đơn cần xóa");
    }
    public void xoa()
    {
        System.out.print("nhập mã số hóa đơn cần xóa: ");
        int msHDcanxoa = reader.nextInt();
        for(HoaDon hd : dsHoaDon)
        {
            if(hd.getMaHd().equals(msHDcanxoa))
            {
                hd.remove();
                System.out.println("đã xóa thông tin hóa đơn");
                return;
            }
        }
        System.err.println("không tìm thấy hóa đơn cần xóa");
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
            System.out.println("Đã tải danh sách từ tệp tin: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp tin: " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        	for(KhachHang kh : dsKhachHang) {
                writer.write(parseKhachHangToLine(kh));
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


    // Hàm chuyển đối tượng NhaCungCap thành dòng văn bản
    private String parseKhachHangToLine(KhachHang kh) {
        return kh.getMahd() + ";" + kh.getNgaythanhtoan() + ";" + kh.getKhachhang().toString() + ";" + kh.getMasp() + ";" + kh.getSoSPmua();
    }
}
