package qlxemay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DSHoaDon {

    private ArrayList<HoaDon> dshd;
    private boolean isModified = false;

    public DSHoaDon() {
        dshd = new ArrayList<>();
    }

    public ArrayList<HoaDon> getDsHD() {
        return dshd;
    }

    public void setDsHD(ArrayList<HoaDon> dshd) {
        this.dshd = dshd;
    }

    public void xem() {
        if (dshd != null && !dshd.isEmpty()) {
            for (HoaDon hd : dshd) {
                hd.xuat();
            }
        } else {
            System.out.println("Danh sach hoa don trong !.");
        }
    }

    public void them(String filedsxm, String filedskh) {
        Scanner s = new Scanner(System.in);
        DSXeMay dsxm = new DSXeMay();
        dsxm.taiDanhSachTuFile(filedsxm);
        System.out.print("\t NHAP THONG TIN HOA DON CAN THEM: \n");
        HoaDon hd = null;
        hd = new HoaDon();
        if (hd != null) {
            int mahd = 1;
            for (HoaDon hdon : dshd) {
                mahd = hdon.getMahd() + 1;
            }
            hd.setMahd(mahd);
            hd.Nhap(filedsxm, filedskh);
            if (hd.getXm() == null || hd.getXm().getSoluongnhaphang() == 0) {
                return;
            }
            dshd.add(hd);

        }
    }

    public void sua(String filedsxm,String filedskh) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don can sua: ");
        int mahd;
        while (true) {
            if (sc.hasNextInt()) {
                mahd = sc.nextInt();
                break;
            }
            System.out.print("Ma hoa don phai la so nguyen. Vui long nhap lai: ");
            sc.nextLine();
        }
        sc.nextLine();
        for (HoaDon hd : dshd) {
            if (hd.getMahd() == mahd) {
                hd.sua(filedsxm,filedskh);
                System.out.println("Sua thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay ma hoa don can sua");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don can xoa: ");
        int mahd;
        while (true) {
            if (sc.hasNextInt()) {
                mahd = sc.nextInt();
                break;
            }
            System.out.print("Ma hoa don phai la so nguyen. Vui long nhap lai: ");
            sc.nextLine();
        }
        sc.nextLine();
        for (HoaDon hd : dshd) {
            if (hd.getMahd() == mahd) {
                dshd.remove(hd);
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay ma hoa don can xoa");
    }

    public void timkiem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Tim kiem theo ma hoa don");
        System.out.println("2.Tim kiem theo ten khach hang");
        System.out.print("Chon: ");
        int choice;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                break;
            }
            sc.nextLine();
            System.out.println("Khong hop le. Vui long nhap lai.");
        }
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Nhap ma hoa don:");
                int mahd;
                while(true){
                    if(sc.hasNextInt()){
                        mahd=sc.nextInt();
                        break;
                    }
                    System.out.println("Ma hoa don phai la so. Vui long nhap lai.");
                    sc.nextLine();
                }
                for(HoaDon hd:dshd){
                    if(hd.getMahd()==mahd){
                        hd.xuat();
                        return;
                    }
                }
                System.out.println("Khong tim thay ma hoa don");
                return;
            case 2:
                boolean found=false;
                System.out.print("Nhap ten khach hang: ");
                String name=sc.nextLine();
                for(HoaDon hd:dshd){
                    if(hd.getKhachhang().getTenkh().equals(name)){
                       hd.xuat();
                       found=true;
                    }
                  
                }
                  if(!found){
                        System.out.println("Khong tim thay ten khach hang");
                        return;
                    }
            default:
                System.out.println("Khong hop le");
                return;
        }
    }

    public void taiDanhSachTuFile(String fileName) {
        dshd.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                HoaDon hd = parseLineToHoaDon(line);
                if (hd != null) {
                    dshd.add(hd);
                } else {
                    System.out.println("Lỗi khi phân tích dòng: " + line);
                }
            }
            System.out.println("Đã tải danh sách từ file: " + fileName);
            System.out.println("Số lượng hóa đơn: " + dshd.size());
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        if (dshd == null || dshd.isEmpty()) {
            System.out.println("Danh sách rỗng, không ghi vào file.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (HoaDon hd : dshd) {
                writer.write(parseHoaDonToLine(hd));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseHoaDonToLine(HoaDon hd) {
        XeMay xemay = hd.getXm();
        KhachHang kh=hd.getKhachhang();
        if (xemay.getLoaisp().equals("Xe dien")) {
            XeDien xm = (XeDien) xemay;
            return hd.getMahd() + ";" + hd.getNgaythanhtoan() + ";" + hd.getSoSPmua() + ";" + xm.getMasp() + ";" + xm.getSoluongnhaphang() + ";" + xm.getTensp() + ";" + xm.getLoaisp() + ";" + xm.getTiennhaphang() + ";" + xm.getDungluongpin() + ";" + xm.getGiasp() + ";" + xm.getHangSX().getMahsx() + ";" + xm.getHangSX().getSdthsx() + ";" + xm.getHangSX().getTenhsx() + ";" + xm.getHangSX().getDiachihsx()+";"+kh.getMakh() +";"+kh.getSdtkh() + ";" + kh.getTenkh() + ";" + kh.getAge() + ";" + kh.getDiachikh() + ";" + kh.getPhai();
        } else {
            XeXang xm = (XeXang) xemay;
            return hd.getMahd() + ";" + hd.getNgaythanhtoan() + ";" + hd.getSoSPmua() + ";" + xm.getMasp() + ";" + xm.getSoluongnhaphang() + ";" + xm.getTensp() + ";" + xm.getLoaisp() + ";" + xm.getTiennhaphang() + ";" + xm.getDungtich() + ";" + xm.getGiasp() + ";" + xm.getHangSX().getMahsx() + ";" + xm.getHangSX().getSdthsx() + ";" + xm.getHangSX().getTenhsx() + ";" + xm.getHangSX().getDiachihsx()+";"+kh.getMakh() + ";" +kh.getSdtkh() + ";" + kh.getTenkh() + ";" + kh.getAge() + ";" + kh.getDiachikh() + ";" + kh.getPhai();
        }
    }

    private HoaDon parseLineToHoaDon(String line) {
        try {
            String[] parts = line.split(";");
            int mahd = Integer.parseInt(parts[0]);
            String ntt = parts[1];
            int soSPmua = Integer.parseInt(parts[2]);
            int masp = Integer.parseInt(parts[3]);
            int soluong = Integer.parseInt(parts[4]);
            String tensp = parts[5];
            String loaisp = parts[6];
            int gianhap = Integer.parseInt(parts[7]);
            int giaban = Integer.parseInt(parts[9]);
            int mahsx = Integer.parseInt(parts[10]);
            String sdthsx = parts[11];
            String tenhsx = parts[12];
            String diachi = parts[13];
            int makh = Integer.parseInt(parts[14]);
            String sdtkh = parts[15];
            String tenkh = parts[16];
            String age = parts[17];

            String diachikh = parts[18];
            String phaikh = parts[19];
            KhachHang kh = new KhachHang(makh, age, sdtkh, tenkh, diachikh, phaikh);
            Double dtodl = Double.parseDouble(parts[8]);
            HangSX hangsx = new HangSX(mahsx, tenhsx, diachi, sdthsx);
            XeMay xm = null;
            if (loaisp.equals("Xe dien")) {
                xm = new XeDien(dtodl, masp, soluong, tensp, loaisp, gianhap, giaban, hangsx);
            }
            if (loaisp.equals("Xe xang")) {
                xm = new XeXang(dtodl, masp, soluong, tensp, loaisp, gianhap, giaban, hangsx);
            }
            return new HoaDon(mahd, ntt, xm, soSPmua,kh);
        } catch (Exception e) {
            System.out.println("Loi khi phan tich du lieu: " + line);
            e.printStackTrace();
            return null;
        }

    }
}
