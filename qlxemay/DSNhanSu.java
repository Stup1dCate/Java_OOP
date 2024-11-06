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
	Scanner sc = new Scanner(System.in);
	private ArrayList<NhanSu> dsns;
	public DSNhanSu() {
		dsns = new ArrayList<>();
	}

	public void Xem() {
		for(NhanSu ns : dsns) {
			ns.xuat();
		}
	}
	public void Them() {
		NhanSu ns = null;
		int luachon;
		System.out.println("Them nhan su cho Cua Hang: ");
		System.out.println("1. Them nhan vien ");
		System.out.println("2. Them quan ly: ");
		System.out.println("Nhap lua chon: ");
		luachon=sc.nextInt();
		switch (luachon) {
			case 1:
				ns=new NhanVien();
				if(ns!= null){
					ns.nhap();
					dsns.add(ns);
				}
				break;
			case 2:
			ns=new Quanly();
				if(ns!= null){
					ns.nhap();
					dsns.add(ns);
				}
				break;
			default:
				break;
		}

	}
	public void Sua() {
		System.out.println("Nhap ten nhan vien can sua: ");
			String tennvcansua=sc.nextLine();
			for(NhanSu ns: dsns){
				if (ns.getTen().equals(tennvcansua)){
					ns.xuat();
					
				}
				else{
					System.out.println("Khong co ten nhan vien can sua");
					return;
				}
			}
		System.out.println("Nhap ma nhan vien can sua: ");
	        int manvcanxoa = sc.nextInt();
	        for(NhanSu ns : dsns) {
	        	if (ns.getManv()==manvcanxoa) {
	                // Gọi phương thức sua() của đối tượng tài liệu tương ứng
	                ns.Sua();
	                System.out.println("Da sua thong tin cua nhan vien!");
	                return; // Kết thúc sau khi sửa
	        	}
	        }
	    System.out.println("Khong tim thay nhan vien can sua!");
	}

	public void Xoa() {
		System.out.println("Nhap ten nhan vien can xoa: ");
		String tennvcanxoa=sc.nextLine();
			for(NhanSu ns: dsns){
				if (ns.getTen().equals(tennvcanxoa)){
					ns.xuat();
					
				}
				else{
					System.out.println("Khong co ten nhan vien can xoa");
					return;
				}
			}
		  
		System.out.println("Nhap ma nhan vien can xoa: ");
        int manvcanxoa = sc.nextInt();
        for(NhanSu ns : dsns) {
        	if (ns.getManv()==manvcanxoa) {
                // Gọi phương thức xoa() của đối tượng tài liệu tương ứng
                dsns.remove(ns);
                System.out.println("Da xoa nhan vien!");
                return; // Kết thúc sau khi xóa
            }
        }
        System.out.println("Khong tim thay nhan vien can xoa!");
	}
	public void TimKiem() {
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
        	for(NhanSu ns : dsns) {
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
			long sdt = Long.parseLong(parts[3]);
			String chucvu = parts[4];
			int salary = Integer.parseInt(parts[5]);
			if (chucvu.equals("NhanVien")) {
				int SoSPban = Integer.parseInt(parts[6]);
				return new NhanVien(manv, ten, age, sdt, chucvu, salary, SoSPban);
			} else if (chucvu.equals("QuanLy")) {
				int bonus = Integer.parseInt(parts[6]);
				return new Quanly(manv, ten, age, sdt, chucvu, salary, bonus);
			}
		}
		return null;
	}
	



    // Hàm chuyển đối tượng NhaCungCap thành dòng văn bản
    private String parseNhanSuToLine(NhanSu ns) {
		if(ns.getChucVu().equals("NhanVien")){
			NhanVien nv =(NhanVien) ns;
			return ns.getManv() + ";" + ns.getTen() + ";" + ns.getAge() + ";" + ns.getSDT() + ";" + ns.getChucVu() + ";" + ns.getSalary() + ";" + nv.getSoSPban() ;
		}
		else if(ns.getChucVu().equals("QuanLy")){
			Quanly ql =(Quanly) ns;
			return ns.getManv() + ";" + ns.getTen() + ";" + ns.getAge() + ";" + ns.getSDT() + ";" + ns.getChucVu() + ";" + ns.getSalary() + ";" + ql.getBonus() ;
		}
	return "";
}
}