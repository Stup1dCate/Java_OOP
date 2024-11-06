package qlxemay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DSXeMay {
	Scanner scanner = new Scanner(System.in);
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
	        for(XeMay sp : dsXemay) {
	            sp.Xuat();
	        }
	    } else {
	        System.out.println("Danh sách sản phẩm trống.");
	    }
	}

	public void them() {
        XeMay sp = new XeMay();
        if (sp != null) {
            sp.Nhap();
            dsXemay.add(sp);
        }
    }
	public void sua() {
		  System.out.println("Nhập tên Sản phẩm cần sửa: ");
	        String tenCanSua = scanner.nextLine();
	        for(XeMay sp : dsXemay) {
	        	if (sp.getTenSP().equals(tenCanSua)) {
	                // Gọi phương thức sua() của đối tượng tài liệu tương ứng
	                sp.Nhap();
	                System.out.println("Đã sửa thông tin của sản phẩm!");
	                return; // Kết thúc sau khi sửa
	        	}
	        }
	        System.out.println("Không tìm thấy sản phẩm cần sửa!");
	}
	public void xoa() {
		System.out.println("Nhập tên Sản phẩm cần xóa: ");
        String tenCanXoa = scanner.nextLine();
        for(XeMay sp : dsXemay) {
        	if (sp.getTenSP().equals(tenCanXoa)) {
                // Gọi phương thức xoa() của đối tượng tài liệu tương ứng
        		dsXemay.remove(sp);
                System.out.println("Đã xóa sản phẩm!");
                return; // Kết thúc sau khi xóa
            }
        }
        System.out.println("Không tìm thấy sản phẩm cần xóa!");
	}
	public void timKiem() {
		System.out.println("Nhập tên Sản phẩm cần tìm kiếm: ");
		String find = scanner.nextLine();
		boolean found = true;
		for(XeMay sp : dsXemay) {
			if (sp.getTenSP().contains(find)) {
				sp.Xuat();
			}
			if (!found) {
				System.out.println("Không có sản phẩm tìm kiếm !");
			}
		}
	}
	public void taiDanhSachTuFile(String fileName) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        // Kiểm tra xem danh sách có dữ liệu không
	        if (dsXemay.isEmpty()) {
	            System.out.println("Danh sách sản phẩm trống.");
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Không tìm thấy tệp tin: " + fileName);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}


    public void xuatDanhSachRaFile(String fileName2) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
        	for(XeMay sp : dsXemay) {
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}