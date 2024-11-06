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
	Scanner s = new Scanner(System.in);
	private ArrayList<XeMay> dsXemay;
	private static int masptt;
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
		} 
		else {
			System.out.println("Danh sach san pham trong. \n");  
		}
	}
	

	public void them() {
		System.out.println("\tNHAP LAN LUOT THONG TIN SAN PHAM CAN THEM: ");  
        XeMay sp = new XeMay();
        if (sp != null) {
            sp.nhap();
            dsXemay.add(sp);
        }
    }
	public void sua() {
		System.out.print("Nhap ma san pham can sua: ");
		int maCanSua = s.nextInt();
		s.nextLine(); 
		for (int i=0;i<dsXemay.size();i++) {
			XeMay sp = dsXemay.get(i);
			if (sp.getMasp() == maCanSua) {
				System.out.println("Sua thong tin cua san pham co ma: " + maCanSua);
				sp.sua();
				System.out.println("Da cap nhat thong tin san pham!");
				return; 
			}
		}
		System.out.println("Khong tim thay san pham co ma: " + maCanSua);
	}
	public void xoa() {
		System.out.println("Nhap ma xe may can xoa: ");
		int maCanXoa = s.nextInt();
		boolean found = false;
		for (int i = 0; i < dsXemay.size(); i++) {
			XeMay sp = dsXemay.get(i); 
			
			if (sp.getMasp() == maCanXoa) { 
				dsXemay.remove(i); 
				System.out.println("Da xoa san pham thanh cong.");
				found = true;
				break; 
			}
		}
		if (!found) {
			System.out.println("Khong tim thay san pham co ma " + maCanXoa);
		}
	}	
	public void timKiem() {
		System.out.println("Nhap ma san pham can tim kiem: ");
		int maCanTim = s.nextInt();
		boolean found = false;
		for (int i = 0; i < dsXemay.size(); i++) {
			XeMay sp = dsXemay.get(i); 
			
			if (sp.getMasp() == maCanTim) { 
				dsXemay.remove(i); 
				System.out.println("Da xoa san pham thanh cong.");
				found = true;
				break; 
			}
		}
		if (!found) {
			System.out.println("Khong tim thay san pham co ma " + maCanTim);
		}
	}
	 
	public void taiDanhSachTuFile(String fileName) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        if (dsXemay.isEmpty()) {
	            System.out.println("Danh sach san pham trong.");
	        }
	    } 
		catch (FileNotFoundException e) {
	        System.out.println("Khong tim thay tep tin: " + fileName);
	    } 
		catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}


    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        	for(XeMay sp : dsXemay) {
                writer.newLine();
            }
            System.out.println("Da xuat danh sach ra tap tin: " + fileName);
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
    }
}