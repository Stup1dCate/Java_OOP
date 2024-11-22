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
        int luachon;
        System.out.println("Them nhan su cho Cua Hang: ");
        System.out.println("1. Them nhan vien ");
        System.out.println("2. Them quan ly ");
        System.out.println("Nhap lua chon: ");
        luachon = sc.nextInt();
        switch (luachon) {
            case 1:
                ns = new NhanVien();
                if (ns != null) {
                    System.out.println("Nhap ma Nhan vien: ");
                    int count;
                    int mans;
                    do {
                        count = 0;
                        while (true) {
                            if (sc.hasNextInt()) {
                                mans = sc.nextInt();  // Nhập vào giá trị số nguyên
                                break;  // Nếu là số, thoát vòng lặp
                                
                            } else {
                                System.out.println("Ma so phai la so, vui long nhap lai!");
                                sc.next();  // Loại bỏ đầu vào không hợp lệ
                            }
                        }

                        if (mans == 0) {
                            return;
                        }
                        for (NhanSu nv : dsns) {
                            if (nv.getManv() == mans) {
                                count++;
                            }
                            if (count == 1) {
                                System.out.println("Ma Nhan vien da ton tai!");
                                System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                                break;
                            }
                        }
                        if (count == 0) {
                            ns.setManv(mans);
                        }
                    } while (count == 1);
                    ns.nhap();
                    ns.setChucVu("Nhan Vien");
                    dsns.add(ns);
                }
                break;
                        
                       
            case 2:
                ns = new Quanly();
                if (ns != null) {
                    System.out.println("Nhap ma Nhan vien: ");
                    int count;
                    do {
                        count = 0;
                        int mans = sc.nextInt();
                        if (mans == 0) {
                            return;
                        }
                        for (NhanSu ql : dsns) {
                            if (ql.getManv() == mans) {
                                count++;
                            }
                            if (count == 1) {
                                System.out.println("Ma Nhan vien da ton tai!");
                                System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                                break;
                            }
                        }
                        if (count == 0) {
                            ns.setManv(mans);
                        }
                    } while (count == 1);
                    ns.nhap();
                    ns.setChucVu("Quan Ly");
                    dsns.add(ns);
                }
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }

    }

    public void Sua() {
        Scanner s = new Scanner(System.in);
        ArrayList<NhanSu> dstam = new ArrayList<>();
        System.out.println("Nhap ten nhan su can sua: ");

        String tensua;
        int look = 0;
        tensua = s.nextLine();
        for (NhanSu ns : dsns) {
            if (ns.getTen().equals(tensua)) {
                System.out.println("Thong tin nhan su: " + tensua);
                dstam.add(ns);
                ns.xuat();
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay thong tin nhan su!");
            return;
        }
        if (look == 1) {
            for (NhanSu ns : dsns) {
                if (ns.getTen().equals(tensua)) {
                    int ma=ns.getManv();
                    System.out.println("Chon chuc vu moi: ");
                    System.out.println("1.nhan vien ");
                    System.out.println("2.quan ly ");
                    System.out.println("Nhap lua chon: ");
                    int choice = s.nextInt();
                    switch (choice) {
                        case 1:
                            ns = new NhanVien();
                            ns.ChucVu = "Nhan Vien";
                            break;
                        case 2:
                            ns = new Quanly();
                            ns.ChucVu = "Quan Ly";

                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            return;
                    }
                    System.out.println("Nhap ma moi cua nhan su: ");
                int count;
                do {
                    count = 0;
                    int mans = s.nextInt();
                    if (mans == 0) {
                        return;
                    }
                    for (NhanSu nsu : dsns) {
                        if (nsu.getManv() == mans) {
                            count++;
                        }
                        if (mans == ma) {
                            count = 0;
                        }
                        if (count == 1) {
                            System.out.println("Ma nhan su da ton tai!");
                            System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                            break;
                        }
                    }
                    if (count == 0) {
                        ns.setManv(mans);
                    }
                } while (count == 1);
                    ns.Sua();
                    for (int i = 0; i < dsns.size(); i++) {
                        if (dsns.get(i).getTen().equals(tensua)) {
                            
                            dsns.set(i, ns);
                        }
                    }
                    return;
                }
            }
        }
        // Kiem tra xem ma ns moi co trung voi ma ns co trong danh sach khong
        System.out.println("Nhap ma nhan su muon sua: ");
        int ma = s.nextInt();
        for (NhanSu ns : dstam) {
            if (ns.getManv() == ma) {
                System.out.println("Nhap ma moi cua nhan su: ");
                int count;
                do {
                    count = 0;
                    int mans = s.nextInt();
                    if (mans == 0) {
                        return;
                    }
                    for (NhanSu nsu : dsns) {
                        if (nsu.getManv() == mans) {
                            count++;
                        }
                        if (mans == ma) {
                            count = 0;
                        }
                        if (count == 1) {
                            System.out.println("Ma nhan su da ton tai!");
                            System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                            break;
                        }
                    }
                    if (count == 0) {
                        ns.setManv(mans);
                    }
                } while (count == 1);
                int mans=ns.getManv();
                System.out.println("Chon chuc vu moi: ");
                System.out.println("1.nhan vien ");
                System.out.println("2.quan ly ");
                System.out.println("Nhap lua chon: ");
                int choice = s.nextInt();
                switch (choice) {
                    case 1:
                        ns = new NhanVien();
                        ns.setManv(mans);
                        ns.ChucVu = "Nhan Vien";

                        break;
                    case 2:
                        ns = new Quanly();
                        ns.setManv(mans);
                        ns.ChucVu = "Quan Ly";

                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                        return;
                }
                ns.Sua();
                for (int i = 0; i < dsns.size(); i++) {
                    if (ns.getManv() == dsns.get(i).getManv()) {
                        dsns.set(i, ns);
                    }
                }
                return;
            }
        }
        System.out.printf("Khong ton tai nhan su %s co ma: %d\n", tensua, ma);
    }

    public void Xoa() {
          ArrayList<NhanSu> dstam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten nhan su can xoa: ");
        String tenxoa;
        int look = 0;
        tenxoa = sc.nextLine();
        for (NhanSu ns:dsns) {
            if (ns.getTen().equals(tenxoa)) {
                System.out.println("Thong tin nhan su " + tenxoa);
                ns.xuat();
                dstam.add(ns);
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay thong tin nhan su!");
            return;
        }
        if (look == 1) {
            for (NhanSu ns:dsns) {
                if (ns.getTen().equals(tenxoa)) {
                    dsns.remove(ns);
                    System.out.println("Xoa thanh cong!");
                    return;
                }
            }
        }
        System.out.println("Nhap ma nhan su muon xoa: ");
        int ma = sc.nextInt();
        for (NhanSu ns : dstam) {
            if (ns.getManv()== ma) {
                dsns.remove(ns);
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.printf("Khong ton tai nhan su %s co ma: %d\n", tenxoa, ma);
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
        if (parts.length == 7) {
            int manv = Integer.parseInt(parts[0]);
            String ten = parts[1];
            int age = Integer.parseInt(parts[2]);
            String sdt = parts[3];
            String chucvu = parts[4];
            int salary = Integer.parseInt(parts[5]);
            if (chucvu.equals("Nhan Vien")) {
                int SoSPban = Integer.parseInt(parts[6]);
                return new NhanVien(manv, ten, age, sdt, chucvu, salary, SoSPban);
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
            return ns.getManv() + ";" + ns.getTen() + ";" + ns.getAge() + ";" + ns.getSDT() + ";" + ns.getChucVu() + ";" + ns.getSalary() + ";" + nv.getSoSPban();
        } else if (ns.getChucVu().equals("Quan Ly")) {
            Quanly ql = (Quanly) ns;
            return ns.getManv() + ";" + ns.getTen() + ";" + ns.getAge() + ";" + ns.getSDT() + ";" + ns.getChucVu() + ";" + ns.getSalary() + ";" + ql.getBonus();
        }
        return "";
    }
}
