package qlxemay;

//đọc/ghi file
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//thoát chương trình khi không tìm thấy file 
import java.io.FileNotFoundException;
import java.io.IOException;
//sử dụng dữ liệu mảng
import java.util.ArrayList;
//nhập input trực tiếp
import java.util.Scanner;

class DSXeMay {

    private ArrayList<XeMay> dsXemay;
    private static int masptt;

    public ArrayList<XeMay> getDsXemay() {
        return dsXemay;
    }

    public void setDsXemay(ArrayList<XeMay> dsXemay) {
        this.dsXemay = dsXemay;
    }

    public DSXeMay() {
        dsXemay = new ArrayList<>();
    }

    public DSXeMay(ArrayList<XeMay> dsXemay) {
        this.dsXemay = dsXemay;
    }

    public static int getMasptt() {
        return masptt;
    }

    public static void setMasptt(int masptt) {
        DSXeMay.masptt = masptt;
    }

    public void xem() {
        if (dsXemay != null) {
            if (!dsXemay.isEmpty()) {
                for (int i = 0; i < dsXemay.size(); i++) {
                    XeMay sp = dsXemay.get(i);
                    sp.xuat();
                }
            } else {
                System.out.println("Danh sach san pham trong. \n");
            }
        } else {
            System.out.println("Danh sach san pham trong. \n");
        }
    }

    public void them(String filehangsx) {
        Scanner sc = new Scanner(System.in);
        XeMay xm = null;
        int maxm = 1;
        for (XeMay xmay : dsXemay) {
            maxm = xmay.getMasp() + 1;
        }
        System.out.println("Chon loai xe:");
        System.out.println("1.Xe dien");
        System.out.println("2.Xe xang");
        int choice;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                break;
            } else {
                sc.nextLine();
                System.out.println("Khong hop le! Vui long nhap lai.");
            }
        }
        switch (choice) {
            case 1:
                xm = new XeDien();
                xm.setMasp(maxm);
                xm.setLoaisp("Xe dien");
                xm.nhap(filehangsx);
                dsXemay.add(xm);
                break;
            case 2:
                xm = new XeXang();
                xm.setMasp(maxm);
                xm.setLoaisp("Xe xang");
                xm.nhap(filehangsx);
                dsXemay.add(xm);
                break;
            default:
                System.out.println("Khong hop le");
                return;
        }
        DSHangSX dshsx = new DSHangSX();
        dshsx.taiDanhSachTuFile(filehangsx);
        for (HangSX hsx : dshsx.getDshsx()) {
            if (hsx.getMahsx() == xm.getHangSX().getMahsx()) {
                return;
            }
        }
        dshsx.getDshsx().add(xm.getHangSX());
        dshsx.xuatDanhSachRaFile(filehangsx);
    }

    public void sua(String filehangsx) {
        Scanner sc = new Scanner(System.in);
        DSHangSX dshsx = new DSHangSX();
        dshsx.taiDanhSachTuFile(filehangsx);

        ArrayList<XeMay> dstam = new ArrayList<>();
        System.out.println("\t SUA THONG TIN SAN PHAM");
        System.out.println("1.Sua san pham theo ten");
        System.out.println("2.Sua san pham theo ma");
        int choice;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                break;
            } else {
                System.out.println("Khong hop le! Vui long nhap lai.");
                sc.nextLine();
            }
        }
        switch (choice) {
            case 1:
                System.out.println("Nhap ten san pham");
                sc.nextLine();
                String tensua = sc.nextLine();
                for (XeMay xm : dsXemay) {
                    if(xm.getTensp().equals(tensua)){
                        dstam.add(xm);
                    xm.xuat();
                    }
                    
                }
                if (dstam.size() == 0) {
                    System.out.println("Khong tim thay ten san pham");
                    return;
                }
                if (dstam.size() == 1) {
                    for (XeMay xm : dsXemay) {
                        if (xm.getTensp().equals(tensua)) {
                            System.out.println("Chon Loai xe:");
                            System.out.println("1. Xe dien");
                            System.out.println("2. Xe xang");
                            int choic;
                            while (true) {
                                if (sc.hasNextInt()) {
                                    choic = sc.nextInt();
                                    break;
                                } else {
                                    System.out.println("Khong hop le! Vui long nhap lai.");
                                    sc.nextLine();
                                }
                            }
                            sc.nextLine();
                            int maxm;
                            switch (choic) {
                                case 1:
                                    maxm = xm.getMasp();
                                    xm = new XeDien();
                                    xm.setMasp(maxm);
                                    xm.setLoaisp("Xe dien");
                                    xm.sua(filehangsx);
                                    for (int i = 0; i < dsXemay.size(); i++) {
                                        if (dsXemay.get(i).getMasp() == xm.getMasp()) {
                                            dsXemay.set(i, xm);
                                            for (HangSX hsx : dshsx.getDshsx()) {
                                                if (hsx.getMahsx() == xm.getHangSX().getMahsx()) {
                                                    return;
                                                }
                                            }
                                            dshsx.getDshsx().add(xm.getHangSX());
                                            dshsx.xuatDanhSachRaFile(filehangsx);
                                            System.out.println("Sua thanh cong");
                                            return;
                                        }
                                    }
                                    return;
                                case 2:
                                    maxm = xm.getMasp();
                                    xm = new XeXang();
                                    xm.setMasp(maxm);
                                    xm.setLoaisp("Xe xang");
                                    xm.sua(filehangsx);
                                    for (int i = 0; i < dsXemay.size(); i++) {
                                        if (dsXemay.get(i).getMasp() == xm.getMasp()) {
                                            dsXemay.set(i, xm);
                                            for (HangSX hsx : dshsx.getDshsx()) {
                                                if (hsx.getMahsx() == xm.getHangSX().getMahsx()) {
                                                    return;
                                                }
                                            }
                                            dshsx.getDshsx().add(xm.getHangSX());
                                            dshsx.xuatDanhSachRaFile(filehangsx);
                                            System.out.println("Sua thanh cong");
                                            return;
                                        }
                                    }
                                    return;
                                default:
                                    System.out.println("Khong hop le!");
                                    return;
                            }
                        }
                    }
                }
                System.out.println("Nhap ma xe may muon sua");
                int maxm;
                while (true) {
                    if (sc.hasNextInt()) {
                        maxm = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma nhan su phai la so nguyen. Vui long nhap lai.");
                        sc.nextLine();
                    }
                }
                for (XeMay xm : dstam) {
                    if (xm.getMasp() == maxm) {
                        System.out.println("Chon Loai xe:");
                        System.out.println("1. Xe dien");
                        System.out.println("2. Xe xang");
                        int choic;
                        while (true) {
                            if (sc.hasNextInt()) {
                                choic = sc.nextInt();
                                break;
                            } else {
                                System.out.println("Khong hop le! Vui long nhap lai.");
                                sc.nextLine();
                            }
                        }
                        sc.nextLine();
                        switch (choic) {
                            case 1:
                                maxm = xm.getMasp();
                                xm = new XeDien();
                                xm.setMasp(maxm);
                                xm.setLoaisp("Xe dien");
                                xm.sua(filehangsx);
                                for (int i = 0; i < dsXemay.size(); i++) {
                                    if (dsXemay.get(i).getMasp() == xm.getMasp()) {
                                        dsXemay.set(i, xm);
                                        for (HangSX hsx : dshsx.getDshsx()) {
                                            if (hsx.getMahsx() == xm.getHangSX().getMahsx()) {
                                                return;
                                            }
                                        }
                                        dshsx.getDshsx().add(xm.getHangSX());
                                        dshsx.xuatDanhSachRaFile(filehangsx);
                                        System.out.println("Sua thanh cong");
                                        return;
                                    }
                                }
                                return;
                            case 2:
                                maxm = xm.getMasp();
                                xm = new XeXang();
                                xm.setMasp(maxm);
                                xm.setLoaisp("Xe xang");
                                xm.sua(filehangsx);
                                for (int i = 0; i < dsXemay.size(); i++) {
                                    if (dsXemay.get(i).getMasp() == xm.getMasp()) {
                                        dsXemay.set(i, xm);
                                        for (HangSX hsx : dshsx.getDshsx()) {
                                            if (hsx.getMahsx() == xm.getHangSX().getMahsx()) {
                                                return;
                                            }
                                        }
                                        dshsx.getDshsx().add(xm.getHangSX());
                                        dshsx.xuatDanhSachRaFile(filehangsx);
                                        System.out.println("Sua thanh cong");
                                        return;
                                    }
                                }
                                return;
                            default:
                                System.out.println("Khong hop le!");
                                return;
                        }
                    }
                }
                System.out.printf("Khong tim thay san pham %s co ma %d", tensua, maxm);
                return;
            case 2:
                System.out.println("Nhap ma san pham can sua");
                int maxmay;
                while (true) {
                    if (sc.hasNextInt()) {
                        maxmay = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma xe may phai la so nguyen. Vui long nhap lai.");
                        sc.nextLine();
                    }
                }
                for (XeMay xm : dsXemay) {
                    if (xm.getMasp() == maxmay) {
                        xm.xuat();
                        System.out.println("Chon Loai xe:");
                        System.out.println("1. Xe dien");
                        System.out.println("2. Xe xang");
                        int choic;
                        while (true) {
                            if (sc.hasNextInt()) {
                                choic = sc.nextInt();
                                break;
                            } else {
                                System.out.println("Khong hop le! Vui long nhap lai.");
                                sc.nextLine();
                            }
                        }
                        sc.nextLine();
                        switch (choic) {
                            case 1:
                                maxmay = xm.getMasp();
                                xm = new XeDien();
                                xm.setMasp(maxmay);
                                xm.setLoaisp("Xe dien");
                                xm.sua(filehangsx);
                                for (int i = 0; i < dsXemay.size(); i++) {
                                    if (dsXemay.get(i).getMasp() == xm.getMasp()) {
                                        dsXemay.set(i, xm);
                                        for (HangSX hsx : dshsx.getDshsx()) {
                                            if (hsx.getMahsx() == xm.getHangSX().getMahsx()) {
                                                return;
                                            }
                                        }
                                        dshsx.getDshsx().add(xm.getHangSX());
                                        dshsx.xuatDanhSachRaFile(filehangsx);
                                        System.out.println("Sua thanh cong");
                                        return;
                                    }
                                }
                                return;
                            case 2:
                                maxmay = xm.getMasp();
                                xm = new XeXang();
                                xm.setMasp(maxmay);
                                xm.setLoaisp("Xe xang");
                                xm.sua(filehangsx);
                                for (int i = 0; i < dsXemay.size(); i++) {
                                    if (dsXemay.get(i).getMasp() == xm.getMasp()) {
                                        dsXemay.set(i, xm);
                                        for (HangSX hsx : dshsx.getDshsx()) {
                                            if (hsx.getMahsx() == xm.getHangSX().getMahsx()) {
                                                return;
                                            }
                                        }
                                        dshsx.getDshsx().add(xm.getHangSX());
                                        dshsx.xuatDanhSachRaFile(filehangsx);
                                        System.out.println("Sua thanh cong");
                                        return;
                                    }
                                }
                                return;
                            default:
                                System.out.println("Khong hop le!");
                                return;
                        }
                    }
                }
                System.out.println("Khong tim thay ma san pham");
                return;
            default:
                System.out.println("Khong hop le!");
        }
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);

        ArrayList<XeMay> dstam = new ArrayList<>();
        System.out.println("\t XOA SAN PHAM");
        System.out.println("1.Xoa san pham theo ten");
        System.out.println("2.Xoa san pham theo ma");
        int choice;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                break;
            } else {
                System.out.println("Khong hop le! Vui long nhap lai.");
                sc.nextLine();
            }
        }
        switch (choice) {
            case 1:
                System.out.println("Nhap ten san pham");
                sc.nextLine();
                String tensua = sc.nextLine();
                for (XeMay xm : dsXemay) {
                    if(xm.getTensp().equals(tensua)){
                        dstam.add(xm);
                    xm.xuat(); 
                    }
                   
                }
                if (dstam.size() == 0) {
                    System.out.println("Khong tim thay ten san pham");
                    return;
                }
                if (dstam.size() == 1) {
                    for (XeMay xm : dsXemay) {
                        if (xm.getTensp().equals(tensua)) {
                            dsXemay.remove(xm);
                        }
                    }
                }
                System.out.println("Nhap ma xe may muon xoa");
                int maxm;
                while (true) {
                    if (sc.hasNextInt()) {
                        maxm = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma xe may phai la so nguyen. Vui long nhap lai.");
                        sc.nextLine();
                    }
                }
                for (XeMay xm : dstam) {
                    if (xm.getMasp() == maxm) {
                       dsXemay.remove(xm);
                    }
                }
                System.out.printf("Khong tim thay san pham %s co ma %d", tensua, maxm);
                return;
            case 2:
                System.out.println("Nhap ma san pham can xoa");
                int maxmay;
                while (true) {
                    if (sc.hasNextInt()) {
                        maxmay = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma xe may phai la so nguyen. Vui long nhap lai.");
                        sc.nextLine();
                    }
                }
                 for (XeMay xm : dsXemay) {
                    if (xm.getMasp() == maxmay) {
                        dsXemay.remove(xm);
                        System.out.println("Xoa thanh cong");
                        return;
                    }
                }
                System.out.println("Khong tim thay ma san pham");
                return;
            default:
                System.out.println("Khong hop le!");
        }
    }

    public void timKiem() {
        Scanner sc = new Scanner(System.in);
        ArrayList<XeMay> dstam=new ArrayList<>();
        System.out.println("\t TIM KIEM THONG TIN SAN PHAM");
        System.out.println("1.Tim kiem san pham theo ten");
        System.out.println("2.Tim kiem san pham theo ma");
        int choice;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                break;
            } else {
                System.out.println("Khong hop le! Vui long nhap lai.");
                sc.nextLine();
            }
        }
        switch (choice) {
            case 1:
                System.out.println("Nhap ten san pham");
                sc.nextLine();
                String tensua = sc.nextLine();
                for (XeMay xm : dsXemay) {
                    if(xm.getTensp().equals(tensua)){
                        dstam.add(xm);
                    xm.xuat();
                    }
                    
                }
                if(dstam.size()==0){
                      System.out.println("Khong tim thay san pham");
                return;
                }
              return;
            case 2:
                System.out.println("Nhap ma san pham can tim");
                int maxmay;
                while (true) {
                    if (sc.hasNextInt()) {
                        maxmay = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma nhan su phai la so nguyen. Vui long nhap lai.");
                        sc.nextLine();
                    }
                }
                for (XeMay xm : dsXemay) {
                    if (xm.getMasp() == maxmay) {
                       xm.xuat();
                    }
                }
                System.out.println("Khong tim thay ma san pham");
                return;
            default:
                System.out.println("Khong hop le!");
        }
    }

    public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dsXemay.add(parseLinetoXeMay(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep tin: " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (XeMay xm : dsXemay) {
                writer.write(parseXeMaytoLine(xm));
                writer.newLine();
            }
            System.out.println("Da xuat danh sach ra tap tin: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public XeMay timKiemXeMayTheoMa(int ma) {
        for (XeMay xm : dsXemay) {
            if (ma == xm.getMasp()) {
                return xm;
            }
        }
        return null;
    }

    private String parseXeMaytoLine(XeMay xemay) {
        if (xemay.getLoaisp().equals("Xe dien")) {
            XeDien xm = (XeDien) xemay;
            return xm.getMasp() + ";" + xm.getSoluongnhaphang() + ";" + xm.getTensp() + ";" + xm.getLoaisp() + ";" + xm.getTiennhaphang() + ";" + xm.getDungluongpin() + ";" + xm.getGiasp() + ";" + xm.getHangSX().getMahsx() + ";" + xm.getHangSX().getSdthsx() + ";" + xm.getHangSX().getTenhsx() + ";" + xm.getHangSX().getDiachihsx();
        } else {
            XeXang xm = (XeXang) xemay;
            return xm.getMasp() + ";" + xm.getSoluongnhaphang() + ";" + xm.getTensp() + ";" + xm.getLoaisp() + ";" + xm.getTiennhaphang() + ";" + xm.getDungtich() + ";" + xm.getGiasp() + ";" + xm.getHangSX().getMahsx() + ";" + xm.getHangSX().getSdthsx() + ";" + xm.getHangSX().getTenhsx() + ";" + xm.getHangSX().getDiachihsx();
        }
    }

    public XeMay parseLinetoXeMay(String line) {
        String parts[] = line.split(";");
        if (parts.length == 11) {
            int masp = Integer.parseInt(parts[0]);
            int soluong = Integer.parseInt(parts[1]);
            String tensp = parts[2];
            String loaisp = parts[3];
            int gianhap = Integer.parseInt(parts[4]);
            int giaban = Integer.parseInt(parts[6]);
            int mahsx = Integer.parseInt(parts[7]);
            String sdthsx = parts[8];
            String tenhsx = parts[9];
            String diachi = parts[10];
            Double dtodl = Double.parseDouble(parts[5]);
            HangSX hangsx = new HangSX(mahsx, tenhsx, diachi, sdthsx);
            if (loaisp.equals("Xe dien")) {
                return new XeDien(dtodl, masp, soluong, tensp, loaisp, gianhap, giaban, hangsx);
            }
            if (loaisp.equals("Xe xang")) {
                return new XeXang(dtodl, masp, soluong, tensp, loaisp, gianhap, giaban, hangsx);
            }
        }
        return null;
    }
}
