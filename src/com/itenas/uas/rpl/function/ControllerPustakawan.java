package com.itenas.uas.rpl.function;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itenas.uas.rpl.entity.Pustakawan;

public class ControllerPustakawan {
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pustakawan.class)
			.buildSessionFactory();

	Session session = factory.getCurrentSession();

	public void insertPustakawan() {
		Scanner scan = new Scanner(System.in);

		try {

			session.beginTransaction();

			Scanner scanner = new Scanner(System.in);
			Pustakawan pustakawan = new Pustakawan();

			System.out.print("Nama : ");
			pustakawan.setNamaPustakawan(scanner.nextLine());

			System.out.print("Gender : ");
			pustakawan.setGender(scanner.nextLine());

			System.out.print("Tanggal Lahir : ");
			pustakawan.setTanggalLahir(scanner.nextLine());

			session.save(pustakawan);

			session.getTransaction().commit();
			System.out.println("Inserted successfully...!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	public void deletePustakawan() {
		Scanner scan = new Scanner(System.in);

		try {
			session.beginTransaction();
			Scanner scanner = new Scanner(System.in);
			
			showPustakawan2();
			System.out.print("Id pustakawan yang ingin dihapus : ");
			int pustakawanId = scanner.nextInt();
			Pustakawan pustakawan = session.get(Pustakawan.class, pustakawanId);

			session.delete(pustakawan);

			List<Pustakawan> pustakawan1 = session.createQuery("from Pustakawan").getResultList();

			for (Pustakawan myPustakawan : pustakawan1) {
				System.out.println(myPustakawan.toString());
			}

			session.getTransaction().commit();
			System.out.println("Deleted successsfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	public void showPustakawan() {
		List<Pustakawan> newlistPustakawan;

		try {
			
			session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Pustakawan> listPustakawan = session.createQuery("from Pustakawan").getResultList();
			
			printPustakawan(listPustakawan);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	private static void printPustakawan(List<Pustakawan> pustakawan1) {
		int i = 0;
		for (Pustakawan pustakawan : pustakawan1) {
			System.out.println("Data Ke-" + (i + 1));
			System.out.println("ID Pustakawan    : " + pustakawan.getIdPustakawan());
			System.out.println("Nama Pustakawan  : " + pustakawan.getNamaPustakawan());
			System.out.println("Gender           : " + pustakawan.getGender());
			System.out.println("Tanggal Lahir    : " + pustakawan.getTanggalLahir());
			System.out.println("");
			i++;
		}
	}
	
	public void updatePustakawan() {
		Scanner scan = new Scanner(System.in);

		try {

			// sava the book object
			session.beginTransaction();

			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			showPustakawan2();
			System.out.print("Id pustakawan yang akan ingin update : ");
			int pustakawanId = scanner.nextInt();

			// get entity from database
			Pustakawan pustakawan = session.get(Pustakawan.class, pustakawanId);

			System.out.print("Nama yang akan diperbaharui  : ");
			pustakawan.setNamaPustakawan(scanner2.nextLine());

			System.out.print("Gender yang akan diperbaharui  : ");
			pustakawan.setGender(scanner2.nextLine());

			System.out.print("Tanggal Lahir yang akan diperbaharui  : ");
			pustakawan.setTanggalLahir(scanner2.nextLine());

			session.getTransaction().commit();
			System.out.println("Updated succesfully...!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	public void cariPustakawan() {

		try {
			Scanner scan = new Scanner(System.in);
			// 1. Begin transaction
			
			session.beginTransaction();

			// 2. Declare Student ID
			System.out.print("Masukkan id pustakawan yang ingin dicari : ");
			int pustakawanId = scan.nextInt();

			// 2. Get Student object
			Pustakawan pustakawan = session.get(Pustakawan.class, pustakawanId);
			// 4. Display student
			System.out.println("ID Pustakawan     : " + pustakawan.getIdPustakawan());
			System.out.println("Nama Pustakawan  : " + pustakawan.getNamaPustakawan());
			System.out.println("Gender   : " + pustakawan.getGender());
			System.out.println("Tanggal Lahir    : " + pustakawan.getTanggalLahir());
			// 5. Commit the transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	public void showPustakawan2() {
		List<Pustakawan> newlistPustakawan;

		try {
			

			@SuppressWarnings("unchecked")
			List<Pustakawan> listPustakawan = session.createQuery("from Pustakawan").getResultList();
			
			printPustakawan(listPustakawan);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
