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
        int luachon;
        System.out.println("Chon loai xe: ");
        System.out.println("1. Them xe dien ");
        System.out.println("2. Them xe xang ");
        System.out.println("Nhap lua chon: ");
        luachon = sc.nextInt();
        switch (luachon) {
            case 1:
                xm = new XeDien();
                if (xm != null) {
                    System.out.println("Nhap ma Xe may: ");
                    // Kiem tra ma xe may co bi trung khong
                    int count;
                    do {
                        count = 0;
                        int maxm = sc.nextInt();
                        if (maxm == 0) {
                            return;
                        }
                        for (XeMay xd : dsXemay) {
                            if (xd.getMasp() == maxm) {
                                count++;
                            }
                            if (count == 1) {
                                System.out.println("Ma xe may da ton tai!");
                                System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                                break;
                            }
                        }
                        if (count == 0) {
                            xm.setMasp(maxm);
                        }
                    } while (count == 1);
                    xm.nhap(filehangsx);
                    xm.setLoaisp("Xe dien");
                    dsXemay.add(xm);
                }
                break;
            case 2:
                xm = new XeXang();
                if (xm != null) {
                    System.out.println("Nhap ma xe may: ");
                    int count;
                    do {
                        count = 0;
                        int maxm = sc.nextInt();
                        if (maxm == 0) {
                            return;
                        }
                        for (XeMay xx : dsXemay) {
                            if (xx.getMasp() == maxm) {
                                count++;
                            }
                            if (count == 1) {
                                System.out.println("Ma xe may da ton tai!");
                                System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                                break;
                            }
                        }
                        if (count == 0) {
                            xm.setMasp(maxm);
                        }
                    } while (count == 1);
                    xm.nhap(filehangsx);
                    xm.setLoaisp("Xe xang");
                    dsXemay.add(xm);
                }
                break;
            default:
                System.out.println("Lua chon khong hop le!");
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
        Scanner s = new Scanner(System.in);
        ArrayList<XeMay> dstam = new ArrayList<>();
        System.out.println("Nhap ten xe may can sua: ");
        String tensua;
        int look = 0;
        tensua = s.nextLine();
        for (XeMay xm : dsXemay) {
            if (xm.getTensp().equals(tensua)) {
                System.out.println("Thong tin xe may: " + tensua);
                dstam.add(xm);
                xm.xuat();
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay thong tin xe may!");
            return;
        }
        if (look == 1) {
            for (XeMay xm : dsXemay) {
                if (xm.getTensp().equals(tensua)) {
                    int ma = xm.getMasp();
                    HangSX hsx = new HangSX(xm.getHangSX().getMahsx(), xm.getHangSX().getTenhsx(), xm.getHangSX().getDiachihsx(), xm.getHangSX().getSdthsx());

                    System.out.println("Chon loai xe moi: ");
                    System.out.println("1.Xe dien ");
                    System.out.println("2.Xe xang ");
                    System.out.println("Nhap lua chon: ");
                    int choice = s.nextInt();
                    switch (choice) {
                        case 1:
                            xm = new XeDien();
                            xm.setMasp(ma);
                            xm.setLoaisp("Xe dien");
                            break;
                        case 2:
                            xm = new XeXang();
                            xm.setMasp(ma);
                            xm.setLoaisp("Xe xang");

                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            return;
                    }
                    System.out.println("Nhap ma moi cua xe may: ");
                    int count;
                    do {
                        count = 0;
                        int masp = s.nextInt();
                        if (masp == 0) {
                            return;
                        }
                        for (XeMay xmay : dsXemay) {
                            if (xmay.getMasp() == masp) {
                                count++;
                            }
                            if (masp == ma) {
                                count = 0;
                            }
                            if (count == 1) {
                                System.out.println("Ma xe may da ton tai!");
                                System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                                break;
                            }
                        }
                        if (count == 0) {
                            xm.setMasp(masp);
                        }
                    } while (count == 1);
                    xm.sua();
                    for (int i = 0; i < dsXemay.size(); i++) {
                        if (dsXemay.get(i).getTensp().equals(tensua)) {

                            dsXemay.set(i, xm);
                        }
                    }
                    DSHangSX dshsx = new DSHangSX();
                    dshsx.taiDanhSachTuFile(filehangsx);
                    if (hsx.getMahsx() == xm.getHangSX().getMahsx()) {
                        for (int i = 0; i < dshsx.getDshsx().size(); i++) {
                            if (dshsx.getDshsx().get(i).getMahsx() == xm.getHangSX().getMahsx()) {
                                dshsx.getDshsx().set(i, xm.getHangSX());
                            }
                            dshsx.xuatDanhSachRaFile(filehangsx);
                            return;
                        }
                    }
                    for (int i = 0; i < dshsx.getDshsx().size(); i++) {
                        if (dshsx.getDshsx().get(i).getMahsx() == hsx.getMahsx()) {
                            dshsx.getDshsx().remove(i);
                        }
                    }
                    for (int i = 0; i < dshsx.getDshsx().size(); i++) {
                        if (dshsx.getDshsx().get(i).getMahsx() == xm.getHangSX().getMahsx()) {
                            dshsx.getDshsx().set(i, xm.getHangSX());
                            dshsx.xuatDanhSachRaFile(filehangsx);
                            return;
                        }

                    }
                    dshsx.getDshsx().add(xm.getHangSX());
                    dshsx.xuatDanhSachRaFile(filehangsx);
                    return;
                }
            }
        }
        // Kiem tra xem ma ns moi co trung voi ma ns co trong danh sach khong
        System.out.println("Nhap ma xe may muon sua: ");
        int ma = s.nextInt();
        for (XeMay xm : dstam) {
            if (xm.getMasp() == ma) {
                System.out.println("Nhap ma moi cua xe may: ");
                int count;
                do {
                    count = 0;
                    int maxm = s.nextInt();
                    if (maxm == 0) {
                        return;
                    }
                    for (XeMay xmay : dsXemay) {
                        if (xmay.getMasp() == maxm) {
                            count++;
                        }
                        if (maxm == ma) {
                            count = 0;
                        }
                        if (count == 1) {
                            System.out.println("Ma Xe may da ton tai!");
                            System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                            break;
                        }
                    }
                    if (count == 0) {
                        xm.setMasp(maxm);
                    }
                } while (count == 1);
                int maxm = xm.getMasp();
                HangSX hsx = new HangSX(xm.getHangSX().getMahsx(), xm.getHangSX().getTenhsx(), xm.getHangSX().getDiachihsx(), xm.getHangSX().getSdthsx());;
                System.out.println("Chon loai xe moi: ");
                System.out.println("1.Xe dien ");
                System.out.println("2.Xe xang ");
                System.out.println("Nhap lua chon: ");
                int choice = s.nextInt();
                switch (choice) {
                    case 1:
                        xm = new XeDien();
                        xm.setMasp(maxm);
                        xm.setLoaisp("Xe dien");
                        break;
                    case 2:
                        xm = new XeXang();
                        xm.setMasp(maxm);
                        xm.setLoaisp("Xe xang");

                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                        return;
                }

                xm.sua();
                for (int i = 0; i < dsXemay.size(); i++) {
                    if (xm.getMasp() == dsXemay.get(i).getMasp()) {
                        dsXemay.set(i, xm);
                    }
                }
                DSHangSX dshsx = new DSHangSX();
                dshsx.taiDanhSachTuFile(filehangsx);

                if (hsx.getMahsx() == xm.getHangSX().getMahsx()) {
                    for (int i = 0; i < dshsx.getDshsx().size(); i++) {
                        if (dshsx.getDshsx().get(i).getMahsx() == xm.getHangSX().getMahsx()) {
                            dshsx.getDshsx().set(i, xm.getHangSX());
                        }
                        dshsx.xuatDanhSachRaFile(filehangsx);
                        return;
                    }
                }
                 for (int i = 0; i < dshsx.getDshsx().size(); i++) {
                        if (dshsx.getDshsx().get(i).getMahsx() == hsx.getMahsx()) {
                            dshsx.getDshsx().remove(i);
                        }
                    }
                    for (int i = 0; i < dshsx.getDshsx().size(); i++) {
                        if (dshsx.getDshsx().get(i).getMahsx() == xm.getHangSX().getMahsx()) {
                            dshsx.getDshsx().set(i, xm.getHangSX());
                            dshsx.xuatDanhSachRaFile(filehangsx);
                            return;
                        }

                    }
                dshsx.getDshsx().add(xm.getHangSX());
                dshsx.xuatDanhSachRaFile(filehangsx);
                return;
            }
        }
        System.out.printf("Khong ton tai nhan su %s co ma: %d\n", tensua, ma);
    }

    public void xoa() {
       ArrayList<XeMay> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten xe may can xoa: ");
        String tenxoa;
        int look = 0;
        tenxoa = sc.nextLine();
        for (XeMay xm:dsXemay) {
            if (xm.getTensp().equals(tenxoa)) {
                System.out.println("Thong tin xe may " + tenxoa);
                xm.xuat();
                dstam.add(xm);
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay thong tin xe may!");
            return;
        }
        if (look == 1) {
            for (XeMay xm:dsXemay) {
                if (xm.getTensp().equals(tenxoa)) {
                    dsXemay.remove(xm);
                    System.out.println("Xoa thanh cong!");
                    return;
                }
            }
        }
        System.out.println("Nhap ma xe may muon xoa: ");
        int ma = sc.nextInt();
        for (XeMay xm : dstam) {
            if (xm.getMasp()== ma) {
                dsXemay.remove(xm);
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.printf("Khong ton tai nhan su %s co ma: %d\n", tenxoa, ma);
    }

    public void timKiem() {
            Scanner sc = new Scanner(System.in);
        int luachon;
        System.out.println("Lua chon phuong thuc tim kiem");
        System.out.println("1. Theo ma xe may");
        System.out.println("2. Theo ten xe may");
        System.out.print("Nhap lua chon: ");
        luachon = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng mới còn sót sau khi nhập số

        switch (luachon) {
            case 1:
                System.out.print("Nhap ma xe may can tim kiem: ");
                int maxm = sc.nextInt();
                boolean foundById = false;
                for (XeMay xm: dsXemay) {
                    if (xm.getMasp() == maxm) {
                        xm.xuat();
                        foundById = true;
                        break; // Ngừng tìm kiếm sau khi tìm thấy
                    }
                }
                if (!foundById) {
                    System.out.println("Khong tim thay xe may co ma so tuong ung.");
                }
                break;

            case 2:
                System.out.print("Nhap ten Xe may can tim kiem: ");
                String find = sc.nextLine();
                boolean foundByName = false;
                for (XeMay xm:dsXemay) {
                    if (xm.getTensp().contains(find)) {
                        xm.xuat();
                        foundByName = true;
                    }
                }
                if (!foundByName) {
                    System.out.println("Khong co xe may can tim kiem!");
                }
                break;

            default:
                System.out.println("Lua chon khong hop le. Vui long chon lai:");
                break;
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
            Double gianhap = Double.parseDouble(parts[4]);
            Double giaban = Double.parseDouble(parts[6]);
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
