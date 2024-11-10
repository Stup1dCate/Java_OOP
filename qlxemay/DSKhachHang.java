package qlxemay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DSKhachHang {
	Scanner s = new Scanner(System.in);
	private ArrayList<KhachHang> dsKhachHang;  
	private static int makhtt;
	public DSKhachHang() {
		dsKhachHang = new ArrayList<>();  // Khởi tạo danh sách khách hàng
	}

	public static int getMakhtt() {
		return makhtt;
	}

	public static void setMakhtt(int makhtt) {
		DSKhachHang.makhtt = makhtt;
	}
	
	public ArrayList<KhachHang> getdsKhachHang() {
		return dsKhachHang;
	}

	public void setdsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}

	public void xem() {
		if (dsKhachHang != null && !dsKhachHang.isEmpty()) {
			System.out.println("\nTHONG TIN DANH SACH KHACH HANG: ");
			for (KhachHang kh : dsKhachHang) {
				kh.xuat();
			}
			System.out.println("\n");
		} else {
			System.out.println("Danh sach trong.\n");
		}
	}
	public void them() {
		System.out.print("\t NHAP THONG TIN KHACH HANG CAN THEM: \n");
		KhachHang kh = null;
		kh = new KhachHang();
		if (kh != null) {
			kh.nhap();
			dsKhachHang.add(kh);
		}
		System.out.println("\n===== DA LUU DU LIEU KHACH HANG THANH CONG ! =====\n");
	}
	public void sua() {
		  System.out.print("Nhap ten khach hang can sua: ");
	        String tenCanSua = s.nextLine();
	        for(KhachHang kh : dsKhachHang) {
	        	if (kh.getTenkh().equals(tenCanSua)) {
	                // Gọi phương thức sua() của đối tượng tài liệu tương ứng
	                kh.sua();
	                System.out.println("Da sua thanh cong thong tin khach hang !");
	                return; // Kết thúc sau khi sửa
	        	}
	        }
	        System.out.println("Khong tim thay khach hang can sua !");
	}
	public void xoa() {
		System.out.print("Nhap ten khach hang can xoa: ");
        String tenCanXoa = s.nextLine();
        for(KhachHang kh : dsKhachHang) {
        	if (kh.getTenkh().equals(tenCanXoa)) {
                // Gọi phương thức xoa() của đối tượng tài liệu tương ứng
        		dsKhachHang.remove(kh);
                System.out.println("Da xoa thanh cong khach hang !");
                return; // Kết thúc sau khi xóa
            }
        }
        System.out.println("Khong tim thay khach hang can xoa.");
	}
	public void timkiem() {
		System.out.print("Nhap ten khach hang can tim kiem: ");
		String find = s.nextLine();
		boolean found = false;  
		for (KhachHang kh : dsKhachHang) {
			if (kh.getTenkh().contains(find)) {
				kh.xuat();
				found = true; 
			}
		}
		if (!found) {
			System.out.println("Khong co ten khach hang can tim kiem!");
		}
	}
	
	public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Chuyển dòng văn bản thành đối tượng KhachHang và thêm vào danh sách ds3
                KhachHang kh = parseLineToKhachHang(line);
                if (kh != null) {
                    dsKhachHang.add(kh);  // Thêm vào danh sách dsKhachHang
                }
            }
            System.out.println("Da tai danh sach tu tap tin: " + fileName + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tap tin: " + fileName + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        	for(KhachHang kh : dsKhachHang) {
                // Ghi đối tượng NhaCungCap thành dòng văn bản và xuống dòng
                writer.write(parseKhachHangToLine(kh));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng hangSX
    private KhachHang parseLineToKhachHang(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 6) {
            int makh = Integer.parseInt(parts[0]);
            String sdtkh = parts[1];
            String tenkh = parts[2];
            String age = parts[3];
            String diachikh = parts[4];
            String phaikh = parts[5];
            return new KhachHang(makh, age, sdtkh, tenkh, diachikh, phaikh);
        }
        return null;
    }

    // Hàm chuyển đối tượng HangSX thành dòng văn bản
    private String parseKhachHangToLine(KhachHang kh) {
        return kh.getMakh() + ";" + kh.getSdtkh() + ";" + kh.getTenkh() + ";" + kh.getAge() + ";" + kh.getDiachikh() + ";" + kh.getPhai();
    }
    public KhachHang timKiemKhachHangTheoMa(int maKhachHang) {
        for (KhachHang kh : dsKhachHang) {
            if (kh.getMakh() == maKhachHang) {
                return kh;
            }
        }
		System.out.println("Khong tim thay khach hang voi ma so: " + maKhachHang);
        return null; // Trả về null nếu không tìm thấy
    }
}
