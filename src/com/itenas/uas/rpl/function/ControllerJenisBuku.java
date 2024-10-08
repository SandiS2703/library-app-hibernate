package com.itenas.uas.rpl.function;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itenas.uas.rpl.entity.Buku;
import com.itenas.uas.rpl.entity.JenisBuku;

public class ControllerJenisBuku {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(JenisBuku.class)
			.addAnnotatedClass(Buku.class).buildSessionFactory();

	Session session = factory.getCurrentSession();

	public void insertJenisBuku() {
		Scanner scan = new Scanner(System.in);

		try {

			session.beginTransaction();

			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			JenisBuku jenisBuku = new JenisBuku();

			System.out.print("Jenis Buku : ");
			jenisBuku.setJenis(scanner2.nextLine());

			session.save(jenisBuku);

			session.getTransaction().commit();
			System.out.println("Inserted successfully...!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void showJenisBuku() {
		List<JenisBuku> newListJenisBuku;

		try {

			session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<JenisBuku> listJenisBuku = session.createQuery("from JenisBuku").getResultList();

			printJenisBuku(listJenisBuku);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void printJenisBuku(List<JenisBuku> jenis1) {
		int i = 0;
		for (JenisBuku jenis : jenis1) {
			System.out.println("Data Ke-" + (i + 1));
			System.out.println("ID Jenis     : " + jenis.getId());
			System.out.println("Jenis Buku  : " + jenis.getJenis());
			System.out.println("");
			i++;
		}
	}

	public void updateJenisBuku() {
		Scanner scan = new Scanner(System.in);

		try {

			// sava the book object
			session.beginTransaction();

			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			showJenisBuku2();
			System.out.print("Id jenis yang akan ingin update : ");
			int id = scanner.nextInt();

			// get entity from database
			JenisBuku jenisBuku = session.get(JenisBuku.class, id);

			System.out.print("Jenis Buku yang akan diperbaharui  : ");
			jenisBuku.setJenis(scanner2.nextLine());

			session.getTransaction().commit();
			System.out.println("Updated succesfully...!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void cariJenisBuku() {

		try {
			Scanner scan = new Scanner(System.in);
			// 1. Begin transaction

			session.beginTransaction();

			// 2. Declare Student ID
			System.out.print("Masukkan id jenis yang ingin dicari : ");
			int id = scan.nextInt();

			// 2. Get Student object
			JenisBuku jenisBuku = session.get(JenisBuku.class, id);
			// 4. Display student
			System.out.println("ID Jenis     : " + jenisBuku.getId());
			System.out.println("Jenis Buku  : " + jenisBuku.getJenis());

			// 5. Commit the transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void showJenisBuku2() {
		List<JenisBuku> newListJenisBuku;

		try {

			@SuppressWarnings("unchecked")
			List<JenisBuku> listJenisBuku = session.createQuery("from JenisBuku").getResultList();

			printJenisBuku(listJenisBuku);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
