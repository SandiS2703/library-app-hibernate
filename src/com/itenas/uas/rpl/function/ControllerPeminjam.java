package com.itenas.uas.rpl.function;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itenas.uas.rpl.entity.Buku;
import com.itenas.uas.rpl.entity.Peminjam;

public class ControllerPeminjam {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Peminjam.class)
			.buildSessionFactory();

	Session session = factory.getCurrentSession();
	

	public void insertPeminjam() {
		Scanner scan = new Scanner(System.in);

		try {

			session.beginTransaction();

			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			Peminjam peminjam = new Peminjam();

			System.out.print("Nama Peminjam : ");
			peminjam.setNamaPeminjam(scanner2.next());

			System.out.print("Gender Peminjam : ");
			peminjam.setGender(scanner2.next());

			System.out.print("Tanggal Lahir : ");
			peminjam.setTglLahir(scanner2.next());

			session.save(peminjam);

			session.getTransaction().commit();
			System.out.println("Inserted successfully...!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void deletePeminjam() {
		Scanner scan = new Scanner(System.in);

		try {
			session.beginTransaction();
			Scanner scanner = new Scanner(System.in);
			
			showPeminjam2();
			System.out.print("Id peminjam yang ingin dihapus : ");
			int peminjamId = scanner.nextInt();
			Peminjam peminjam = session.get(Peminjam.class, peminjamId);

			session.delete(peminjam);

			//List<Peminjam> peminjam1 = session.createQuery("from Peminjam").getResultList();

			//for (Peminjam myPeminjam : peminjam1) {
			//	System.out.println(myPeminjam.toString());
			//}

			session.getTransaction().commit();
			System.out.println("Deleted successsfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void showPeminjam() {
		List<Peminjam> newlistPeminjam;

		try {
			
			session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Peminjam> listPeminjam = session.createQuery("from Peminjam").getResultList();
			
			printPeminjam(listPeminjam);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void printPeminjam(List<Peminjam> peminjam1) {
		int i = 0;
		for (Peminjam peminjam : peminjam1) {
			System.out.println("Data Ke-" + (i + 1));
			System.out.println("ID Peminjam       : " + peminjam.getIdPeminjam());
			System.out.println("Nama Peminjam     : " + peminjam.getNamaPeminjam());
			System.out.println("Gender Peminjam   : " + peminjam.getGender());
			System.out.println("Tanggal Lahir     : " + peminjam.getTglLahir());
			System.out.println("");
			i++;
		}
	}

	public void updatePeminjam() {
		Scanner scan = new Scanner(System.in);

		try {

			// sava the book object
			session.beginTransaction();

			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			showPeminjam2();
			System.out.print("Id peminjam yang akan ingin update : ");
			int peminjamId = scanner.nextInt();

			// get entity from database
			Peminjam peminjam = session.get(Peminjam.class, peminjamId);

			System.out.print("Nama Peminjam yang akan diperbaharui  : ");
			peminjam.setNamaPeminjam(scanner2.nextLine());

			System.out.print("Gender Peminjam yang akan diperbaharui  : ");
			peminjam.setGender(scanner2.nextLine());

			System.out.print("Tanggal Lahir yang akan diperbaharui  : ");
			peminjam.setTglLahir(scanner2.nextLine());

			session.getTransaction().commit();
			System.out.println("Updated succesfully...!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void cariPeminjam() {

		try {
			Scanner scan = new Scanner(System.in);
			// 1. Begin transaction
			
			session.beginTransaction();

			// 2. Declare Student ID
			System.out.print("Masukkan id peminjam yang ingin dicari : ");
			int peminjamId = scan.nextInt();

			// 2. Get Student object
			Peminjam peminjam = session.get(Peminjam.class, peminjamId);
			// 4. Display student
			System.out.println("ID Peminjam       : " + peminjam.getIdPeminjam());
			System.out.println("Nama Peminjam     : " + peminjam.getNamaPeminjam());
			System.out.println("Gender Peminjam   : " + peminjam.getGender());
			System.out.println("Tanggal Lahir     : " + peminjam.getTglLahir());

			// 5. Commit the transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	public void showPeminjam2() {
		List<Peminjam> newlistPeminjam;

		try {
			

			@SuppressWarnings("unchecked")
			List<Peminjam> listPeminjam = session.createQuery("from Peminjam").getResultList();
			
			printPeminjam(listPeminjam);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
