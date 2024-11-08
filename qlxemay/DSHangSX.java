package qlxemay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DSHangSX {
	Scanner s = new Scanner(System.in);
	private ArrayList<HangSX> dshsx;
	private static int mahsx;
	public DSHangSX() {
		dshsx = new ArrayList<>();
	}

	public static int getMahsx() {
		return mahsx;
	}
	public static void setMahsx(int mahsx) {
		DSHangSX.mahsx = mahsx;
	}
	
	public ArrayList<HangSX> getDshsx() {
		return dshsx;
	}
	public void setDshsx(ArrayList<HangSX> dshsx) {
		this.dshsx = dshsx;
	}

	public void xem() {
		if (dshsx != null && !dshsx.isEmpty()) {
			System.out.println("\nTHONG TIN DANH SACH HANG SAN XUAT: ");
			for (HangSX hsx : dshsx) {
				hsx.xuat();
			}
			System.out.println("\n");
		} else {
			System.out.println("Danh sach trong.\n");
		}
	}
	

	public void them() {
		System.out.print("\t NHAP THONG TIN HANG SAN XUAT CAN THEM: \n");
		HangSX hsx = null;
		hsx = new HangSX();
		if (hsx != null) {
			hsx.nhap();
			dshsx.add(hsx);
		}
		System.out.println("\n===== DA LUU DU LIEU HANG SAN XUAT THANH CONG ! =====\n");
	}

	public void sua() {
		System.out.print("Nhap ma hang san xuat can sua: ");
		int maCanSua = s.nextInt();
		s.nextLine(); // Consume the newline left-over
	
		for (HangSX hsx : dshsx) {
			if (hsx.getMahsx() == maCanSua) {
				hsx.sua(); // Call the update method for this supplier
				System.out.println("\nDA CHINH SUA THONG TIN HANG SAN XUAT !\n");
				return; // Exit after editing
			}
		}
		System.out.println("Khong tim thay hang san xuat can chinh sua !");
	}

	public void xoa() {
		System.out.print("Nhap ten hang san xuat can xoa: ");
		String tenCanXoa = s.nextLine();
		boolean removed = dshsx.removeIf(hsx -> hsx.getTenhsx().equals(tenCanXoa));
		if (removed) {
			System.out.println("Da xoa hang san xuat!");
		} else {
			System.out.println("Khong tim thay hang san xuat can xoa !");
		}
	}


	public void timkiem() {
		System.out.println("Nhap ten hang san xuat can tim kiem: ");
		String find = s.nextLine();
		boolean found = false;
		for (HangSX hsx : dshsx) {
			if (hsx.getTenhsx().contains(find)) {
				hsx.xuat();
				found = true;
			}
		}
		if (!found) {
			System.out.println("Khong co hang san xuat can tim kiem !");
		}
	}
	
	public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Chuyển dòng văn bản thành đối tượng HangSX và thêm vào danh sách
                HangSX hsx = parseLineToHangSX(line);
                if (hsx != null) {
                    dshsx.add(hsx);
                }
            }
            System.out.println("Da tai danh sach tu tep tin: " + fileName + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep tin: " + fileName + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (HangSX hsx : dshsx) {
                // Ghi đối tượng HangSX thành dòng văn bản và xuống dòng
                writer.write(parseHangSXToLine(hsx));
                writer.newLine();
            }
            System.out.println("Da cap nhat danh sach vao tap tin: " + fileName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng HangSX
    private HangSX parseLineToHangSX(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 4) {
            int mahsx = Integer.parseInt(parts[0]);
            String sdthsx = parts[1];
            String tenhsx = parts[2];
            String diachihsx = parts[3];
            return new HangSX(mahsx, tenhsx, diachihsx, sdthsx);
        }
        return null;
    }

    // Hàm chuyển đối tượng HangSX thành dòng văn bản
    private String parseHangSXToLine(HangSX hsx) {
        return hsx.getMahsx() + ";" + hsx.getSdthsx() + ";" + hsx.getTenhsx() + ";" + hsx.getDiachihsx();
    }
}
