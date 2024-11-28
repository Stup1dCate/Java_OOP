package qlxemay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DSNhanSu {

    private ArrayList<NhanSu> dsns;

    public DSNhanSu() {
        dsns = new ArrayList<>();
    }

    public void Xem() {
        if (dsns != null && !dsns.isEmpty()) {
            System.out.println("\nTHONG TIN DANH SACH NHAN SU: ");
            for (NhanSu ns : dsns) {
                ns.xuat();
            }
        } else {
            System.out.println("Danh sach trong.\n");
        }
    }

    public void Them() {
        Scanner sc = new Scanner(System.in);
        NhanSu ns = null;
        int mans = 1;
        for (NhanSu nsu : dsns) {
            mans = nsu.getManv() + 1;
        }
        System.out.println("\tTHEM THONG TIN NHAN SU");
        System.out.println("1.Them Quan Ly");
        System.out.println("2.Them Nhan Vien");
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
        sc.nextLine();

        switch (choice) {
            case 1:
                ns = new Quanly();
                ns.setManv(mans);
                ns.setChucVu("Quan Ly");
                ns.nhap();
                dsns.add(ns);
                    System.out.println("Them thanh cong!");
                break;
            case 2:
                ns = new NhanVien();
                ns.setManv(mans);
                ns.setChucVu("Nhan Vien");
                ns.nhap();
                dsns.add(ns);
                    System.out.println("Them thanh cong!");
                break;
            default:
                System.out.println("Khong hop le!");
        }
    }

    public void Sua() {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanSu> dstam = new ArrayList<>();
        System.out.println("\t SUA THONG TIN NHAN SU");
        System.out.println("1.Sua nhan su theo ten");
        System.out.println("2.Sua nhan su theo ma");
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
                sc.nextLine();
                System.out.println("Nhap ten nhan su can sua:");
                String tensua = sc.nextLine();
                for (NhanSu ns : dsns) {
                    if (ns.getTen().equals(tensua)) {
                        dstam.add(ns);
                        ns.xuat();
                    }
                }
                if (dstam.size() == 0) {
                    System.out.printf("\nKhong tim thay ten nhan su %s", tensua);
                    return;
                }
                if (dstam.size() == 1) {
                    for (NhanSu ns : dsns) {
                        if (ns.getTen().equals(tensua)) {
                            System.out.println("Chon chuc vu:");
                            System.out.println("1. Quan Ly");
                            System.out.println("2. Nhan Vien");
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
                            int mans;
                            switch (choic) {
                                case 1:
                                    mans = ns.getManv();
                                    ns = new Quanly();
                                    ns.setManv(mans);
                                    ns.setChucVu("Quan Ly");
                                    ns.Sua();
                                    for (int i = 0; i < dsns.size(); i++) {
                                        if (dsns.get(i).getManv() == ns.getManv()) {
                                            dsns.set(i, ns);
                                             System.out.println("Sua thanh cong!");
                                            return;
                                        }
                                    }
                                    return;
                                case 2:
                                    mans = ns.getManv();
                                    ns = new NhanVien();
                                    ns.setManv(mans);
                                    ns.setChucVu("Nhan Vien");
                                    ns.Sua();
                                    for (int i = 0; i < dsns.size(); i++) {
                                        if (dsns.get(i).getManv() == ns.getManv()) {
                                            dsns.set(i, ns);
                                                System.out.println("Sua thanh cong!");
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
                System.out.println("Nhap ma nhan su muon sua:");
                int mans;
                while (true) {
                    if (sc.hasNextInt()) {
                        mans = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma nhan su phai la so nguyen. Vui long nhap lai.");
                        sc.nextLine();
                    }
                }
                for (NhanSu ns : dstam) {
                    if (ns.getManv() == mans) {
                        System.out.println("Chon chuc vu:");
                        System.out.println("1. Quan Ly");
                        System.out.println("2. Nhan Vien");
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
                                ns = new Quanly();
                                ns.setManv(mans);
                                ns.setChucVu("Quan Ly");
                                ns.Sua();
                                for (int i = 0; i < dsns.size(); i++) {
                                    if (dsns.get(i).getManv() == ns.getManv()) {
                                        dsns.set(i, ns);
                                        System.out.println("Sua thanh cong!");
                                        return;
                                    }
                                }
                                return;
                            case 2:
                                ns = new NhanVien();
                                ns.setManv(mans);
                                ns.setChucVu("Nhan Vien");
                                ns.Sua();
                                for (int i = 0; i < dsns.size(); i++) {
                                    if (dsns.get(i).getManv() == ns.getManv()) {
                                        dsns.set(i, ns);
                                            System.out.println("Sua thanh cong!");
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
                System.out.printf("Khong tim thay nhan su ten %s co ma %d", tensua, mans);
                return;
            case 2:
                System.out.println("Nhap ma nhan su muon sua:");
                int mansu;
                while (true) {
                    if (sc.hasNextInt()) {
                        mansu = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma nhan su phai la so nguyen. Vui long nhap lai.");
                        sc.nextLine();
                    }
                }
                for (NhanSu ns : dsns) {
                    if (ns.getManv() == mansu) {
                        System.out.println("Chon chuc vu:");
                        System.out.println("1. Quan Ly");
                        System.out.println("2. Nhan Vien");
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
                                ns = new Quanly();
                                ns.setManv(mansu);
                                ns.setChucVu("Quan Ly");
                                ns.Sua();
                                for (int i = 0; i < dsns.size(); i++) {
                                    if (dsns.get(i).getManv() == ns.getManv()) {
                                        dsns.set(i, ns);
                                            System.out.println("Sua thanh cong!");
                                        return;
                                    }
                                }

                            case 2:
                                ns = new NhanVien();
                                ns.setManv(mansu);
                                ns.setChucVu("Nhan Vien");
                                ns.Sua();
                                for (int i = 0; i < dsns.size(); i++) {
                                    if (dsns.get(i).getManv() == ns.getManv()) {
                                        dsns.set(i, ns);
                                            System.out.println("Sua thanh cong!");
                                        return;
                                    }
                                }

                            default:
                                System.out.println("Khong hop le!");
                                return;
                        }
                    }
                }
                    System.out.println("Khong tim thay ma nhan su");
                    return;

                
        default:
                System.out.println("Khong hop le!");
        }

    }
    
    public void Xoa() {
       Scanner sc = new Scanner(System.in);
        ArrayList<NhanSu> dstam = new ArrayList<>();
        System.out.println("\t XOA THONG TIN NHAN SU");
        System.out.println("1.Xoa nhan su theo ten");
        System.out.println("2.Xoa nhan su theo ma");
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
                sc.nextLine();
                System.out.println("Nhap ten nhan su can xoa:");
                String tensua = sc.nextLine();
                for (NhanSu ns : dsns) {
                    if (ns.getTen().equals(tensua)) {
                        dstam.add(ns);
                        ns.xuat();
                    }
                }
                if (dstam.size() == 0) {
                    System.out.printf("\nKhong tim thay ten nhan su %s", tensua);
                    return;
                }
                if (dstam.size() == 1) {
                    for (NhanSu ns : dsns) {
                        if (ns.getTen().equals(tensua)) {
                          dsns.remove(ns);
                          System.out.println("Xoa thanh cong!");
                          return;
                        }
                    }

                }
                System.out.println("Nhap ma nhan su muon sua:");
                int mans;
                while (true) {
                    if (sc.hasNextInt()) {
                        mans = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma nhan su phai la so nguyen. Vui long nhap lai.");
                        sc.nextLine();
                    }
                }
                for (NhanSu ns : dstam) {
                    if (ns.getManv() == mans) {
                       dsns.remove(ns);
                       System.out.println("Xoa thanh cong!");
                       return;
                    }
                }
                System.out.printf("Khong tim thay nhan su ten %s co ma %d", tensua, mans);
                return;
            case 2:
                System.out.println("Nhap ma nhan su muon xoa:");
                int mansu;
                while (true) {
                    if (sc.hasNextInt()) {
                        mansu = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ma nhan su phai la so nguyen. Vui long nhap lai.");
                        sc.nextLine();
                    }
                }
                for (NhanSu ns : dsns) {
                    if (ns.getManv() == mansu) {
                       dsns.remove(ns);
                       System.out.println("Xoa thanh cong!");
                       return;
                    }
                }
                    System.out.println("Khong tim thay ma nhan su");
                    return;

                
        default:
                System.out.println("Khong hop le!");
        }

    }

    public void TimKiem() {
        Scanner sc = new Scanner(System.in);
        int luachon;
        System.out.println("Lua chon phuong thuc tim kiem");
        System.out.println("1. Theo ma nhan vien");
        System.out.println("2. Theo ten nhan vien");
        System.out.print("Nhap lua chon: ");
        luachon = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng mới còn sót sau khi nhập số

        switch (luachon) {
            case 1:
                System.out.print("Nhap ma nhan vien can tim kiem: ");
                int manv = sc.nextInt();
                boolean foundById = false;
                for (NhanSu ns : dsns) {
                    if (ns.getManv() == manv) {
                        ns.xuat();
                        foundById = true;
                        break; // Ngừng tìm kiếm sau khi tìm thấy
                    }
                }
                if (!foundById) {
                    System.out.println("Khong tim thay nhan vien co ma so tuong ung.");
                }
                break;

            case 2:
                System.out.print("Nhap ten nhan vien can tim kiem: ");
                String find = sc.nextLine();
                boolean foundByName = false;
                for (NhanSu ns : dsns) {
                    if (ns.getTen().contains(find)) {
                        ns.xuat();
                        foundByName = true;
                    }
                }
                if (!foundByName) {
                    System.out.println("Khong co nhan vien can tim kiem!");
                }
                break;

            default:
                System.out.println("Lua chon khong hop le. Vui long chon lai:");
                break;
        }
    }

    public void taiDanhSachTuFile(String fileName) {
        Quanly.setSoluongnv(0);
        NhanVien.setSoluongnv(0);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                NhanSu ns = parseLineToNhanSu(line);
                if (ns != null) {
                    dsns.add(ns);
                }
            }
            System.out.println("Da tai danh sach tu tep tin: " + fileName);

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep tin: " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (NhanSu ns : dsns) {
                // Ghi đối tượng NhaCungCap thành dòng văn bản và xuống dòng
                writer.write(parseNhanSuToLine(ns));
                writer.newLine();
            }
            System.out.println("Da xuat danh sach ra tep tin: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private NhanSu parseLineToNhanSu(String line) {
        String[] parts = line.split(";");
        if (parts.length == 8 || parts.length == 7) {
            int manv = Integer.parseInt(parts[0]);
            String ten = parts[1];
            int age = Integer.parseInt(parts[2]);
            String sdt = parts[3];
            String chucvu = parts[4];
            int salary = Integer.parseInt(parts[5]);
            if (chucvu.equals("Nhan Vien")) {
                int SoSPban = Integer.parseInt(parts[6]);
                int TienThuongSP = Integer.parseInt(parts[7]);
                return new NhanVien(manv, ten, age, sdt, chucvu, salary, SoSPban, TienThuongSP);
            } else if (chucvu.equals("Quan Ly")) {
                int bonus = Integer.parseInt(parts[6]);
                return new Quanly(manv, ten, age, sdt, chucvu, salary, bonus);
            }
        }
        return null;
    }

    // Hàm chuyển đối tượng NhaCungCap thành dòng văn bản
    private String parseNhanSuToLine(NhanSu ns) {
        if (ns.getChucVu().equals("Nhan Vien")) {
            NhanVien nv = (NhanVien) ns;
            return ns.getManv() + ";" + ns.getTen() + ";" + ns.getAge() + ";" + ns.getSDT() + ";" + ns.getChucVu() + ";" + ns.getSalary() + ";" + nv.getSoSPban() + ";" + nv.getTienThuongSP();
        } else if (ns.getChucVu().equals("Quan Ly")) {
            Quanly ql = (Quanly) ns;
            return ns.getManv() + ";" + ns.getTen() + ";" + ns.getAge() + ";" + ns.getSDT() + ";" + ns.getChucVu() + ";" + ns.getSalary() + ";" + ql.getBonus();
        }
        return "";
    }
}
