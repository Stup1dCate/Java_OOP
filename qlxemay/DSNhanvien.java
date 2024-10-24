package qlxemay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DSNhanVien {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<NhanVien> ds2;
	private static int manvtt;
	public DSNhanVien() {
		ds2 = new ArrayList<>();
	}
	public static int getManvtt() {
		return manvtt;
	}
	public static void setManvtt(int manvtt) {
		DSNhanVien.manvtt = manvtt;
	}
	public void xem() {
		for(NhanVien nv : ds2) {
			nv.xuat();
		}
	}
	public void them() {
		NhanVien nv = null;
		nv = new NhanVien();
		if (nv != null) {
			nv.nhap();
			ds2.add(nv);
		}
	}
	public void sua() {
		  System.out.println("Nhập tên Nhân viên cần sửa: ");
	        String tenCanSua = scanner.nextLine();
	        for(NhanVien nv : ds2) {
	        	if (nv.getTennv().equals(tenCanSua)) {
	                // Gọi phương thức sua() của đối tượng tài liệu tương ứng
	                nv.sua();
	                System.out.println("Đã sửa thông tin của nhân viên!");
	                return; // Kết thúc sau khi sửa
	        	}
	        }
	        System.out.println("Không tìm thấy nhân viên cần sửa!");
	}
	public void xoa() {
		System.out.println("Nhập tên Nhân viên cần xóa: ");
        String tenCanXoa = scanner.nextLine();
        for(NhanVien nv : ds2) {
        	if (nv.getTennv().equals(tenCanXoa)) {
                // Gọi phương thức xoa() của đối tượng tài liệu tương ứng
                ds2.remove(nv);
                System.out.println("Đã xóa nhân viên!");
                return; // Kết thúc sau khi xóa
            }
        }
        System.out.println("Không tìm thấy nhân viên cần xóa!");
	}
	public void timKiem() {
		System.out.println("Nhập tên Nhân viên cần tìm kiếm: ");
		String find = scanner.nextLine();
		boolean found = true;
		for(NhanVien nv : ds2) {
			if (nv.getTennv().contains(find)) {
				nv.xuat();
			}
			if (!found) {
				System.out.println("Không có nhân viên tìm kiếm !");
			}
		}
	}
	public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Chuyển dòng văn bản thành đối tượng NhaCungCap và thêm vào danh sách
                NhanVien nv = parseLineToNhanVien(line);
                if (nv != null) {
                    ds2.add(nv);
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
        	for(NhanVien nv : ds2) {
                // Ghi đối tượng NhaCungCap thành dòng văn bản và xuống dòng
                writer.write(parseNhanVienToLine(nv));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra tệp tin: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng NhaCungCap
    private NhanVien parseLineToNhanVien(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 6) {
            int manv = Integer.parseInt(parts[0]);
            long sdtnv = Long.parseLong(parts[1]);
            String tennv = parts[2];
            String diachinv = parts[3];
            String phainv = parts[4];
            String chucvunv = parts[5];
            return new NhanVien(manv, tennv, diachinv, sdtnv, phainv, chucvunv);
        }
        return null;
    }

    // Hàm chuyển đối tượng NhaCungCap thành dòng văn bản
    private String parseNhanVienToLine(NhanVien nv) {
        return nv.getManv() + ";" + nv.getSdtnv() + ";" + nv.getTennv() + ";" + nv.getDiachinv() + ";" + nv.getPhai() + ";" + nv.getChucvu();
    }
}
