package qlxemay;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DSHoaDon {
    private ArrayList<HoaDon> dshd;
    private Scanner s = new Scanner(System.in);
    private static int mahdtt;
	private XeMay xeMay;
	private XeDien xeDien;
	private XeXang xeXang;
	private ArrayList<KhachHang> dsKhachHang;
	private ArrayList<XeMay> dsXeMay;

    public DSHoaDon() {
		dshd = new ArrayList<>();
	}
	public DSHoaDon(XeDien xeDien, XeXang xeXang, XeMay xeMay) {
		this.xeDien = xeDien;
		this.xeXang = xeXang;
		this.xeMay = xeMay;
	}

    public ArrayList<HoaDon> getDsHD() {
        return dshd;
    }
    public void setDsHD(ArrayList<HoaDon> dshd) {
        this.dshd = dshd;
    }

    public static int getMahdtt() {
		return mahdtt;
	}
	public static void setMahdtt(int mahdtt) {
		DSHoaDon.mahdtt = mahdtt;
	}

    public void xem() {
	    if (dshd != null && !dshd.isEmpty()) {
	        for (HoaDon hd : dshd) {
	            // In thông tin hóa đơn
	            System.out.println("Ma hoa don: " + hd.getMahd());
	            System.out.println("Ngay thanh toan : " + hd.getNgaythanhtoan());
	            
	            // In thông tin khách hàng
	            KhachHang kh = hd.getKhachHang();
	            System.out.println("\tTHONG TIN KHACH HANG: ");
	            System.out.println("Ma so khach hang: " + kh.getMakh());
	            System.out.println("Ho va ten khach hang: " + kh.getTenkh());
	            System.out.println("So dien thoai: " + kh.getSdtkh());
	            System.out.println("Gioi tinh: " + kh.getPhai());
	            System.out.println("So tuoi: " + kh.getAge());
	            System.out.println("Dia chi khach hang: " + kh.getDiachikh());
	            
	            // In chi tiết hóa đơn
	            System.out.println("\tCHI TIET HOA DON MUA HANG:");
	            ChiTietHoaDon cthd = hd.getChiTietHoaDon();
	            XeMay sp = hd.getXeMay();
	            System.out.println("Ma san pham: " + sp.getMasp());
	            System.out.println("Ten san pham: " + sp.getTensp());
	            System.out.println("So luong da mua: " + cthd.getSoluongmua());
	            System.out.println("Gia san pham: " + sp.getGiasp());
	            
	            System.out.println("----------------------------");
	            
	            // In thành tiền
	            tinhTong(cthd);  // Gọi phương thức tính thành tiền
	            System.out.println("===============\n");
	        }
	    } else {
	        System.out.println("Danh sach hoa don trong !.");
	    }
	}

    public void them() {
        HoaDon hd = new HoaDon();
        hd.nhap();
        dshd.add(hd);
    }

    public void sua() {
        System.out.print("Nhap ma so hoa don can sua: ");
        int msHDcansua = s.nextInt();
        if (dshd.stream().noneMatch(hd -> hd.getMahd() == msHDcansua)) {
            System.err.println("Khong tim thay ma hoa don.");
            return;
        }
        for (HoaDon hd : dshd) {
            if (hd.getMahd() == msHDcansua) { 
                hd.sua();
                System.out.println("Da chinh sua thanh cong thong tin hoa don.");
                return;
            }
        }
        System.err.println("Khong tim thay ma hoa don can sua");
    }
    
    public void xoa() {
        System.out.print("Nhap ma so hoa don can thanh toan: ");
        int msHDcanxoa = s.nextInt();
        if (dshd.stream().noneMatch(hd -> hd.getMahd() == msHDcanxoa)) {
            System.err.println("Khong tim thay ma hoa don.");
            return;
        }
        for (HoaDon hd : dshd) {
            if (hd.getMahd() == msHDcanxoa) { 
                dshd.remove(hd);
                System.out.println("Da xoa thanh cong hoa don");
                return;
            }
        }
        System.err.println("Khong tim thay ma hoa don can xoa");
    }

    public void timkiem() {
        System.out.print("Nhap ma hoa don can tim kiem: ");
        int msHDcantim = s.nextInt();
        boolean found = false;
        
        for (HoaDon hd : dshd) {
            if (hd.getMahd() == msHDcantim) {
                hd.xuat();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoa don co ma so tuong ung.");
        }
    }
    
    private void tinhTong(ChiTietHoaDon cthd) {
	    double thanhTien = cthd.tinhTien();
	    System.out.println("Thanh tien: " + thanhTien);
	}
    

    public void taiDanhSachTuFile(String fileName, DSKhachHang dsKhachHang, DSXeMay dsXeMay) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
             // Tạo đối tượng HoaDon từ thông tin trong file
                HoaDon hd = new HoaDon();
                hd.setMahd(Integer.parseInt(parts[0]));
                hd.setNgaythanhtoan(parts[1]);

                // Tạo đối tượng KhachHang từ DSKhachHang
                int maKhachHang = Integer.parseInt(parts[2]);
                KhachHang kh = dsKhachHang.timKiemKhachHangTheoMa(maKhachHang);
                hd.setKhachHang(kh);

                // Tạo đối tượng ChiTietHoaDon từ thông tin trong file
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                
                cthd.setSoluongmua(Integer.parseInt(parts[3]));

                // Tạo đối tượng XeMay từ DSXeMay
                int maXeMay = Integer.parseInt(parts[4]);
                XeMay xm = dsXeMay.timKiemXeMayTheoMa(maXeMay);
                cthd.setXeMay(xm);
                hd.setChiTietHoaDon(cthd);

                // Thêm HoaDon vào danh sách
                dshd.add(hd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (HoaDon hd : dshd) {
                writer.write(parseHoaDonToLine(hd));
                writer.newLine();
            }
            System.out.println("Da xuat danh sach ra tap tin " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseHoaDonToLine(HoaDon hd) {
        // Lấy thông tin nhà cung cấp từ sản phẩm
        KhachHang kh = hd.getKhachHang();
        XeMay sp = hd.getXeMay();
        ChiTietHoaDon cthd = hd.getChiTietHoaDon();
        
        // Ghi các đối tượng thành dòng văn bản và xuống dòng
        return hd.getMahd() + ";" + hd.getNgaythanhtoan() + ";" + kh.getMakh() + ";" + kh.getTenkh() + ";" + kh.getAge() +
        kh.getDiachikh() + ";" + kh.getSdtkh() + ";" + sp.getMasp() + sp.getTensp() + ";" + cthd.getSoluongmua();
    }
}