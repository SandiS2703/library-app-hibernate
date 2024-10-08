package com.itenas.uas.rpl.function;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itenas.uas.rpl.entity.Buku;
import com.itenas.uas.rpl.entity.JenisBuku;

public class ControllerBuku {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Buku.class)
			.addAnnotatedClass(JenisBuku.class).buildSessionFactory();

	Session session = factory.getCurrentSession();

	public void insertBuku() {
		Scanner scan = new Scanner(System.in);

		try {

			session.beginTransaction();

			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			String jenis;
			Buku buku = new Buku();

			System.out.print("Judul : ");
			buku.setJudul(scanner2.nextLine());

			System.out.print("Pengarang : ");
			buku.setPengarang(scanner2.nextLine());

			System.out.print("Penerbit : ");
			buku.setPenerbit(scanner2.nextLine());

			session.getTransaction().commit();
			System.out.println("Inserted successfully...!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void deleteBuku() {
		Scanner scan = new Scanner(System.in);

		try {
			session.beginTransaction();
			Scanner scanner = new Scanner(System.in);

			showBuku2();
			System.out.print("Id buku yang ingin dihapus : ");
			int bukuId = scanner.nextInt();
			Buku buku = session.get(Buku.class, bukuId);

			session.delete(buku);

			session.getTransaction().commit();
			System.out.println("Deleted successsfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void showBuku() {
		List<Buku> newlistBuku;

		try {

			session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Buku> listBuku = session.createQuery("from Buku").getResultList();

			printBuku(listBuku);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void printBuku(List<Buku> buku1) {
		int i = 0;
		for (Buku buku : buku1) {
			System.out.println("Data Ke-" + (i + 1));
			System.out.println("ID Buku        : " + buku.getID_buku());
			System.out.println("Judul Buku     : " + buku.getJudul());
			System.out.println("Pengarang      : " + buku.getPengarang());
			System.out.println("Penerbit       : " + buku.getPenerbit());
			System.out.println("ID Jenis Buku  : " + buku.getJenisBuku().getId());
			System.out.println("");
			i++;
		}
	}

	public void updateBuku() {
		Scanner scan = new Scanner(System.in);

		try {

			// sava the book object
			session.beginTransaction();

			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			showBuku2();
			System.out.print("Id buku yang akan ingin update : ");
			int bukuId = scanner.nextInt();

			// get entity from database
			Buku buku = session.get(Buku.class, bukuId);

			System.out.print("Judul yang akan diperbaharui  : ");
			buku.setJudul(scanner2.nextLine());

			System.out.print("Nama Pengarang yang akan diperbaharui  : ");
			buku.setPengarang(scanner2.nextLine());

			System.out.print("Penerbit yang akan diperbaharui  : ");
			buku.setPenerbit(scanner2.nextLine());

			session.getTransaction().commit();
			System.out.println("Updated succesfully...!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void cariBuku() {

		try {
			Scanner scan = new Scanner(System.in);
			// 1. Begin transaction

			session.beginTransaction();

			// 2. Declare Student ID
			System.out.print("Masukkan id buku yang ingin dicari : ");
			int bukuId = scan.nextInt();

			// 2. Get Student object
			Buku buku = session.get(Buku.class, bukuId);
			// 4. Display student
			System.out.println("ID Buku     : " + buku.getID_buku());
			System.out.println("Judul Buku  : " + buku.getJudul());
			System.out.println("Pengarang   : " + buku.getPengarang());
			System.out.println("Penerbit    : " + buku.getPenerbit());

			// 5. Commit the transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void showBuku2() {
		List<Buku> newlistBuku;

		try {

			@SuppressWarnings("unchecked")
			List<Buku> listBuku = session.createQuery("from Buku").getResultList();

			printBuku(listBuku);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void kategorikanBuku() {

		Scanner scan = new Scanner(System.in);
		ControllerJenisBuku conJen = new ControllerJenisBuku();
		int idJenis, counter, idBuku;

		try {
			session.beginTransaction();
			conJen.showJenisBuku();
			System.out.print("Masukkan ID Jenis buku : ");
			idJenis = scan.nextInt();
			JenisBuku jenisBuku = session.get(JenisBuku.class, idJenis);
			showBuku2();
			System.out.print("Berapa jumlah buku yang merupakan kategori " + jenisBuku.getJenis() + " : ");
			counter = scan.nextInt();
			try {
				for (int i = 0; i < counter; i++) {
					System.out.print("Masukkan ID Buku yang merupakan kategori " + jenisBuku.getJenis() + " : ");
					idBuku = scan.nextInt();
					Buku buku = session.get(Buku.class, idBuku);
					buku.setJenisBuku(jenisBuku);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
