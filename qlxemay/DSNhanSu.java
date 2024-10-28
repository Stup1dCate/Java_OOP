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
			ns.Xuat();
		}
	}
	public void Them() {
		NhanSu ns = null;
		int luachon;
		System.out.println("Ban muon them 1.Nhan vien hay 2.Quan ly..");
		System.out.println("Nhap lua chon cua ban: ");
		luachon=sc.nextInt();
		switch (luachon) {
			case 1:
				ns=new NhanVien();
				if(ns!= null){
					ns.Nhap();
					dsns.add(ns);
				}
				break;
			case 2:
			ns=new Quanly();
				if(ns!= null){
					ns.Nhap();
					dsns.add(ns);
				}
				break;
			default:
				break;
		}

	}
	public void Sua() {
		  System.out.println("Nhap ma nhan vien can sua: ");
	        String manvcanxoa = sc.nextLine();
	        for(NhanSu ns : dsns) {
	        	if (ns.getManv().equals(manvcanxoa)) {
	                // Gọi phương thức sua() của đối tượng tài liệu tương ứng
	                ns.Sua();
	                System.out.println("Da sua thong tin cua nhan vien!");
	                return; // Kết thúc sau khi sửa
	        	}
	        }
	        System.out.println("Khong tim thay nhan vien can sua!");
	}

	public void Xoa() {
		System.out.println("Nhap ma nhan vien can xoa: ");
        String manvcanxoa = sc.nextLine();
        for(NhanSu ns : dsns) {
        	if (ns.getManv().equals(manvcanxoa)) {
                // Gọi phương thức xoa() của đối tượng tài liệu tương ứng
                dsns.remove(ns);
                System.out.println("Da xoa nhan vien!");
                return; // Kết thúc sau khi xóa
            }
        }
        System.out.println("Không tìm thấy nhân viên cần xóa!");
	}
	public void TimKiem() {
		int luachon;
		System.out.println("Ban muon tim kiem theo 1.Ma nhan vien hay 2.Ten");
		System.out.println("Nhap lua chon cua ban: ");
		luachon=sc.nextInt();
		switch (luachon) {
			case 1:
			System.out.println("Nhap ma nhan vien can tim kiem: ");
			sc.nextLine();
			String manv = sc.nextLine();
			for(NhanSu ns : dsns) {
				if (ns.getManv().equals(manv)) {
					ns.Xuat();
				}
					System.out.println("Khong tim thay nhan vien");
			}		
				break;
			case 2:
			System.out.println("Nhap ten nhan vien can tim kiem: ");
		String find = sc.nextLine();
		boolean found = true;
		for(NhanSu ns : dsns) {
			if (ns.getTen().contains(find)) {
				ns.Xuat();
			}
			if (!found) {
				System.out.println("Khong co nhan vien can tim kiem !");
			}
		}
				break;
			default:
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
            System.out.println("Đã tải danh sách từ tệp tin: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp tin: " + fileName);
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
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  
    private NhanSu parseLineToNhanSu(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 6) {
            String manv = (parts[0]);
            String ten = (parts[1]);
            int age= Integer.parseInt(parts[2]);
            String sdt = parts[3];
            String chucvu = parts[4];
            int salary = Integer.parseInt(parts[5]);
			if(chucvu.equals("NhanVien")){
				int SoSPban=Integer.parseInt(parts[6]);
				return new NhanVien(manv,ten,age,sdt,chucvu,salary,SoSPban);
			}
			else if(chucvu.equals("QuanLy")){
				int bonus=Integer.parseInt(parts[6]);
				return new Quanly(manv,ten,age,sdt,chucvu,salary,bonus);
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
    }
	return "";
}