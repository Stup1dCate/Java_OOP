package qlxemay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DSHoaDon {
    private ArrayList<HoaDon> dshd;
    private boolean isModified = false;
    public DSHoaDon() {
		dshd = new ArrayList<>();
	}
    public ArrayList<HoaDon> getDsHD() {
        return dshd;
    }
    public void setDsHD(ArrayList<HoaDon> dshd) {
        this.dshd = dshd;
    }
    public void xem() {
	    if (dshd != null && !dshd.isEmpty()) {
	        for (HoaDon hd : dshd) {
	            hd.xuat();
	        }
	    } else {
	        System.out.println("Danh sach hoa don trong !.");
	    }
	}

    public void them(String filedsxm) {
          Scanner s = new Scanner(System.in);
          DSXeMay dsxm=new DSXeMay();
          dsxm.taiDanhSachTuFile(filedsxm);
        System.out.print("\t NHAP THONG TIN HOA DON CAN THEM: \n");
        HoaDon hd= null;
        hd = new HoaDon();
        if (hd != null) {
            System.out.println("Nhap ma Hoa Don: ");
            int count;
            do {
                count = 0;
                int mahd= s.nextInt();
                if (mahd == 0) {
                    return;
                }
                for (HoaDon hdon : dshd) {
                    if (hdon.getMahd()== mahd) {
                        count++;
                    }
                    if (count == 1) {
                        System.out.println("Ma hoa don da ton tai!");
                        System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                        break;
                    }
                }
                if (count == 0) {
                    hd.setMahd(mahd);
                }
            } while (count == 1);
            hd.Nhap(filedsxm);
        if(hd.getXm()==null || hd.getXm().getSoluongnhaphang()==0){
          return;
      }
      dshd.add(hd);
        }
	    isModified = true;
    }

    public void sua(String filedsxm) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma hoa don can sua:");
        int mahdcu=sc.nextInt();
        for(HoaDon hoaDon:dshd){
            if(hoaDon.getMahd()==mahdcu){
                System.out.println("Nhap ma hoa don moi:");
                HoaDon hdon=new HoaDon(hoaDon);
        int mahdmoi;
        boolean test=true;
        do{
            mahdmoi=sc.nextInt();
            if(mahdmoi==0) return;
            for(HoaDon hd:dshd){
                if(mahdmoi==hd.getMahd()) test=false;
            }
            if(mahdcu==mahdmoi) test=true;
            if(test==false) {
                System.out.println("Ma hoa don da ton tai!");
                System.out.println("Vui long nhap lai hoac nhap 0 de thoat.");
            } 
            if(test==true) hoaDon.setMahd(mahdmoi);
        }while(!test);
        hoaDon.sua(filedsxm);
        if(hoaDon.getXm().getSoluongnhaphang()==0){
            hoaDon.setMahd(hdon.getMahd());
           hoaDon.setNgaythanhtoan(hdon.getNgaythanhtoan());
           hoaDon.setSoSPmua(hdon.getSoSPmua());
           hoaDon.setXm(hdon.getXm());
            return;
        }
        isModified = true;
        xuatDanhSachRaFile("fileName.txt");
        return;
            }
        }
        sc.close();
        System.out.println("Khong tim thay ma hoa don can sua");
    }
    
    public void xoa() {
      Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma hoa don can xoa: ");
        int maxoa=sc.nextInt();
        Iterator<HoaDon> iterator = dshd.iterator();
        while (iterator.hasNext()) {
            HoaDon hd = iterator.next();
            if (hd.getMahd() == maxoa) {
                iterator.remove();
                System.out.println("Da xoa thanh cong!");
                isModified = true;
                xuatDanhSachRaFile("fileName.txt");
                return;
            }
        }
        sc.close();
        System.out.println("Khong tim thay hoa don!");
    }

    public void timkiem() {
       Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma hoa don can tim: ");
        int maxoa=sc.nextInt();
        for(HoaDon hd:dshd){
            if(maxoa==hd.getMahd()) {
                hd.xuat();
                return;
            }
        }
        sc.close();
        System.out.println("Khong tim thay hoa don!");
    }
    
    

    public void taiDanhSachTuFile(String fileName) {
    	dshd.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                HoaDon hd = parseLineToHoaDon(line);
                if (hd != null) {
                    dshd.add(hd);
                }
                else {
                    System.out.println("Lỗi khi phân tích dòng: " + line);
                }
            }
            System.out.println("Đã tải danh sách từ file: " + fileName);
            System.out.println("Số lượng hóa đơn: " + dshd.size());
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void xuatDanhSachRaFile(String fileName) {
    	if (dshd == null || dshd.isEmpty()) {
    	    System.out.println("Danh sách rỗng, không ghi vào file.");
    	    return;
    	}
    	if (!isModified) {
    	    System.out.println("Không có thay đổi nào, không ghi vào file.");
    	    return;
    	}
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (HoaDon hd : dshd) {
                writer.write(parseHoaDonToLine(hd));
                writer.newLine();
            }
            System.out.println("Đã xuất danh sách ra file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String parseHoaDonToLine(HoaDon hd) {
        XeMay xemay=hd.getXm();
         if (xemay.getLoaisp().equals("Xe dien")) {
            XeDien xm = (XeDien) xemay;
            return hd.getMahd() + ";" + hd.getNgaythanhtoan() + ";" + hd.getSoSPmua()+ ";"+ xm.getMasp() + ";" + xm.getSoluongnhaphang() + ";" + xm.getTensp() + ";" + xm.getLoaisp() + ";" + xm.getTiennhaphang() + ";" + xm.getDungluongpin() + ";" + xm.getGiasp() + ";" + xm.getHangSX().getMahsx() + ";" + xm.getHangSX().getSdthsx() + ";" + xm.getHangSX().getTenhsx() + ";" + xm.getHangSX().getDiachihsx();
        } else {
            XeXang xm = (XeXang) xemay;
            return hd.getMahd() + ";" + hd.getNgaythanhtoan() + ";" + hd.getSoSPmua()+ ";"+ xm.getMasp() + ";" + xm.getSoluongnhaphang() + ";" + xm.getTensp() + ";" + xm.getLoaisp() + ";" + xm.getTiennhaphang() + ";" + xm.getDungtich()+ ";" + xm.getGiasp() + ";" + xm.getHangSX().getMahsx() + ";" + xm.getHangSX().getSdthsx() + ";" + xm.getHangSX().getTenhsx() + ";" + xm.getHangSX().getDiachihsx();
        }
    }
    private HoaDon parseLineToHoaDon(String line){
       try
       {
    	   String[] parts=line.split(";");
           int mahd=Integer.parseInt(parts[0]);
           String ntt=parts[1];
           int soSPmua=Integer.parseInt(parts[2]);
               int masp = Integer.parseInt(parts[3]);
               int soluong = Integer.parseInt(parts[4]);
               String tensp = parts[5];
               String loaisp = parts[6];
               int gianhap = Integer.parseInt(parts[7]);
               int giaban = Integer.parseInt(parts[9]);
               int mahsx = Integer.parseInt(parts[10]);
               String sdthsx = parts[11];
               String tenhsx = parts[12];
               String diachi = parts[13];
               Double dtodl = Double.parseDouble(parts[8]);
               HangSX hangsx = new HangSX(mahsx, tenhsx, diachi, sdthsx);
               XeMay xm=null;
                  if (loaisp.equals("Xe dien")) {
                   xm= new XeDien(dtodl, masp, soluong, tensp, loaisp, gianhap, giaban, hangsx);
               }
               if (loaisp.equals("Xe xang")) {
                   xm= new XeXang(dtodl, masp, soluong, tensp, loaisp, gianhap, giaban, hangsx);
               }
               return new HoaDon(mahd,ntt,xm, soSPmua);
       }
       catch (Exception e) {
    	    System.out.println("Lỗi khi phân tích dữ liệu: " + line);
    	    e.printStackTrace();
    	    return null;
    	}

}
}
