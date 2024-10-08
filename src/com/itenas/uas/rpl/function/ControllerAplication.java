package com.itenas.uas.rpl.function;

import java.util.Scanner;

public class ControllerAplication {

	public void mainMenu() {
		System.out.println("|---------------------------------------|");
		System.out.println("|              Perpustakaan             |");
		System.out.println("|---------------------------------------|");
		System.out.println("|1. Buku                                |");
		System.out.println("|2. Peminjam                            |");
		System.out.println("|3. Pustakawan                          |");
		System.out.println("|4. Pinjam                              |");
		System.out.println("|5. Tipe Buku                           |");
		System.out.println("|0. Keluar                              |");
		System.out.println("|---------------------------------------|");

		Scanner scan = new Scanner(System.in);
		int input;

		System.out.print("Masukkan pilihan anda :");
		input = scan.nextInt();
		switch (input) {

		case 1:
			menuBuku();
			break;

		case 2:
			menuPeminjam();
			break;

		case 3:
			menuPustaka();
			break;

		case 4:
			menuPinjam();
			break;

		case 5:
			menuTipe();
			break;

		case 0:
			break;

		default:
			System.out.println("Pilihan tidak tersedia!!!!");
			mainMenu();
		}
	}

	public void menuBuku() {
		ControllerBuku conBuk = new ControllerBuku();

		System.out.println("|---------------------------------------|");
		System.out.println("|                  Buku                 |");
		System.out.println("|---------------------------------------|");
		System.out.println("|1. Tambah data Buku                    |");
		System.out.println("|2. Tampil data Buku                    |");
		System.out.println("|3. Update data Buku                    |");
		System.out.println("|4. Hapus data Buku                     |");
		System.out.println("|5. Cari data Buku                      |");
		System.out.println("|6. Kategorikan Buku                    |");
		System.out.println("|0. Kembali                             |");
		System.out.println("|---------------------------------------|");

		Scanner scan = new Scanner(System.in);
		int input;

		System.out.print("Masukkan pilihan anda :");
		input = scan.nextInt();
		switch (input) {

		case 1:
			conBuk.insertBuku();
			menuBuku();
			break;

		case 2:
			conBuk.showBuku();
			menuBuku();
			break;

		case 3:
			conBuk.updateBuku();
			menuBuku();
			break;

		case 4:
			conBuk.deleteBuku();
			menuBuku();
			break;

		case 5:
			conBuk.cariBuku();
			;
			menuBuku();
			break;
			
		case 6:
			conBuk.kategorikanBuku();
			menuBuku();
			break;
			
		case 0:
			mainMenu();
			break;

		default:
			System.out.println("Pilihan tidak tersedia!!!!");
			menuBuku();
		}
	}

	public void menuPeminjam() {

		ControllerPeminjam conPin = new ControllerPeminjam();
		System.out.println("|---------------------------------------|");
		System.out.println("|                Peminjam               |");
		System.out.println("|---------------------------------------|");
		System.out.println("|1. Tambah data Peminjam                |");
		System.out.println("|2. Tampil data Peminjam                |");
		System.out.println("|3. Update data Peminjam                |");
		System.out.println("|4. Hapus data Peminjam                 |");
		System.out.println("|5. Cari data Peminjam                  |");
		System.out.println("|0. Kembali                             |");
		System.out.println("|---------------------------------------|");

		Scanner scan = new Scanner(System.in);
		int input;

		System.out.print("Masukkan pilihan anda :");
		input = scan.nextInt();
		switch (input) {

		case 1:
			conPin.insertPeminjam();
			menuPeminjam();
			break;

		case 2:
			conPin.showPeminjam();
			menuPeminjam();
			break;

		case 3:
			conPin.updatePeminjam();
			menuPeminjam();
			break;

		case 4:
			conPin.deletePeminjam();
			menuPeminjam();
			break;

		case 5:
			conPin.cariPeminjam();
			menuPeminjam();
			break;

		case 0:
			mainMenu();
			break;

		default:
			System.out.println("Pilihan tidak tersedia!!!!");
			menuPeminjam();
		}
	}

	public void menuPustaka() {
		ControllerPustakawan conPustaka = new ControllerPustakawan();
		
		System.out.println("|---------------------------------------|");
		System.out.println("|              Pustakawan               |");
		System.out.println("|---------------------------------------|");
		System.out.println("|1. Tambah data Pustakawan              |");
		System.out.println("|2. Tampil data Pustakawan              |");
		System.out.println("|3. Update data Pustakawan              |");
		System.out.println("|4. Hapus data Pustakawan               |");
		System.out.println("|5. Cari data Pustakawan                |");
		System.out.println("|6. Kembali                             |");
		System.out.println("|---------------------------------------|");
		Scanner scan = new Scanner(System.in);
		int input;

		System.out.print("Masukkan pilihan anda :");
		input = scan.nextInt();
		switch (input) {

			case 1:
				conPustaka.insertPustakawan();
				menuPustaka();
				break;
				
			case 2:
				conPustaka.showPustakawan();
				menuPustaka();
				break;
				
			case 3:
				conPustaka.updatePustakawan();
				menuPustaka();
				break;
				
			case 4:
				conPustaka.deletePustakawan();
				menuPustaka();
				break;
				
			case 5:
				conPustaka.cariPustakawan();
				menuPustaka();
				break;

			case 0:
				mainMenu();
				break;
				
			default:
				System.out.println("Pilihan tidak tersedia!!!!");
				menuPustaka();
		}
	}

	public void menuPinjam() {

		ControllerPinjamDetail conDetail = new ControllerPinjamDetail();

		System.out.println("|---------------------------------------|");
		System.out.println("|                Pinjam                 |");
		System.out.println("|---------------------------------------|");
		System.out.println("|1. Tambah data Pinjam                  |");
		System.out.println("|2. Tampil data Pinjam                  |");
		System.out.println("|3. Update data Pinjam                  |");
		System.out.println("|4. Hapus data Pinjam                   |");
		System.out.println("|5. Cari data Pinjam                    |");
		System.out.println("|0. Kembali                             |");
		System.out.println("|---------------------------------------|");

		Scanner scan = new Scanner(System.in);
		int input;

		System.out.print("Masukkan pilihan anda :");
		input = scan.nextInt();
		switch (input) {

		case 1:
			conDetail.insertDetailPinjam();
			menuPinjam();
			break;

		case 2:
			conDetail.showDetailPinjam();
			menuPinjam();
			break;

		case 3:
			conDetail.updateDetailPinjam();
			menuPinjam();
			break;

		case 4:
			conDetail.deleteDetailPinjam();
			menuPinjam();
			break;

		case 5:
			conDetail.cariDetailPinjam();
			menuPinjam();
			break;

		case 0:
			mainMenu();
			break;

		default:
			System.out.println("Pilihan tidak tersedia!!!!");
			menuPinjam();
		}
	}

	public void menuTipe() {
		ControllerJenisBuku conJen = new ControllerJenisBuku();

		System.out.println("|---------------------------------------|");
		System.out.println("|                Jenis                  |");
		System.out.println("|---------------------------------------|");
		System.out.println("|1. Tambah data Jenis                   |");
		System.out.println("|2. Tampil data Jenis                   |");
		System.out.println("|3. Update data Pinjam                  |");
		System.out.println("|4. Cari data Pinjam                    |");
		System.out.println("|0. Kembali                             |");
		System.out.println("|---------------------------------------|");

		Scanner scan = new Scanner(System.in);
		int input;

		System.out.print("Masukkan pilihan anda :");
		input = scan.nextInt();
		switch (input) {

		case 1:
			conJen.insertJenisBuku();
			menuTipe();
			break;

		case 2:
			conJen.showJenisBuku();
			menuTipe();
			break;

		case 3:
			conJen.updateJenisBuku();
			menuTipe();
			break;

		case 4:
			conJen.cariJenisBuku();
			menuTipe();
			break;

		case 0:
			mainMenu();
			break;

		default:
			System.out.println("Pilihan tidak tersedia!!!!");
			menuTipe();
		}
	}
}
