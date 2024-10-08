package com.itenas.uas.rpl.function;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itenas.uas.rpl.entity.Buku;
import com.itenas.uas.rpl.entity.DetailPinjam;
import com.itenas.uas.rpl.entity.Peminjam;
import com.itenas.uas.rpl.entity.Pinjam;

public class ControllerPinjamDetail {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pinjam.class)
			.addAnnotatedClass(DetailPinjam.class).buildSessionFactory();
	
	Session session = factory.getCurrentSession();

	public void insertDetailPinjam() {

		try {
			int idPeminjam;
			int idBuku;
			int idPinjam;
			String tglPinjam;
			String tglKembali;
			ControllerBuku conBuk = new ControllerBuku();
			ControllerPeminjam conPin = new ControllerPeminjam();
			Scanner scan = new Scanner(System.in);
			session.beginTransaction();

			conPin.showPeminjam();
			System.out.print("Masukkan ID Peminjam  : ");
			idPeminjam = scan.nextInt();
			System.out.println("");
			conBuk.showBuku();
			System.out.print("Masukkan ID Buku      : ");
			idBuku = scan.nextInt();
			System.out.print("Masukkan Tgl Pinjam   : ");
			tglPinjam = scan.next();
			System.out.print("Masukkan Tgl Kembali  : ");
			tglKembali = scan.next();

			Pinjam newPinjam = new Pinjam(idPeminjam, idBuku);
			DetailPinjam newDetail = new DetailPinjam(tglPinjam, tglKembali);

			newPinjam.setDetailPinjam(newDetail);

			session.save(newPinjam);

			session.getTransaction().commit();
			System.out.println("Inserted successfully...!");
			//scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void deleteDetailPinjam() {
		Scanner scan = new Scanner(System.in);

		try {
			session.beginTransaction();

			int id;
			showDetailPinjam2();

			System.out.println("Masukkan ID data yang ingin dihapus : ");
			id = scan.nextInt();

			Pinjam newPinjam = session.get(Pinjam.class, id);

			System.out.println("Data Pinjam : " + newPinjam);

			System.out.println("Yang berhubungan dengan data : " + newPinjam.getDetailPinjam());

			if (newPinjam != null) {
				System.out.println("Deleting : " + newPinjam);
				session.delete(newPinjam);
			}
			session.getTransaction().commit();
			System.out.println("Deleted successfully...!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void showDetailPinjam() {
		List<Pinjam> newistPinjam;
		List<DetailPinjam> newistDetail;

		try {
			session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Pinjam> listPinjam = session.createQuery("from Pinjam").getResultList();
			List<DetailPinjam> listDetail = session.createQuery("from DetailPinjam").getResultList();

			printDetailPinjam(listPinjam);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void printDetailPinjam(List<Pinjam> pinjam1) {
		int i = 0;
		for (Pinjam pinjam : pinjam1) {
			System.out.println("Data Ke-" + (i + 1));
			System.out.println("ID Pinjam         : " + pinjam.getIdPinjam());
			System.out.println("ID Peminjam       : " + pinjam.getIdPeminjam());
			System.out.println("ID Buku           : " + pinjam.getIdBuku());
			System.out.println("ID Detail         : " + pinjam.getDetailPinjam().getIdDetail());
			System.out.println("Tanggal Pinjam    : " + pinjam.getDetailPinjam().getTglPinjam());
			System.out.println("Tanggal Kembali   : " + pinjam.getDetailPinjam().getTglKembali());
			System.out.println("");
			i++;
		}
	}

	public void updateDetailPinjam() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			ControllerBuku conBuk = new ControllerBuku();
			ControllerPeminjam conPin = new ControllerPeminjam();
			session.beginTransaction();


			showDetailPinjam2();
			System.out.print("Masukkan ID detail yang ingin dicari : ");
			int id = scanner.nextInt();
			Pinjam pinjam = session.get(Pinjam.class, id);
			//session.beginTransaction();
			//etailPinjam detail = new DetailPinjam();
			conBuk.showBuku();
			System.out.print("ID buku yang akan diperbaharui  : ");
			pinjam.setIdBuku(scanner.nextInt());
			conPin.showPeminjam();
			System.out.print("ID peminjam yang akan diperbaharui  : ");
			pinjam.setIdPeminjam(scanner.nextInt());

			System.out.print("Tgl pinjam yang akan diperbaharui  : ");
			pinjam.getDetailPinjam().setTglPinjam(scanner.next());

			System.out.print("Tgl kembali yang akan diperbaharui  : ");
			pinjam.getDetailPinjam().setTglKembali(scanner.next());
			
			session.getTransaction().commit();
			System.out.println("Updated succesfully...!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void cariDetailPinjam() {

		try {
			Scanner scan = new Scanner(System.in);
			session.beginTransaction();

			System.out.print("Masukkan ID pinjam yang ingin dicari : ");
			int id = scan.nextInt();

			Pinjam pinjam = session.get(Pinjam.class, id);

			System.out.println("ID Pinjam         : " + pinjam.getIdPinjam());
			System.out.println("ID Peminjam       : " + pinjam.getIdPeminjam());
			System.out.println("ID Buku           : " + pinjam.getIdBuku());
			System.out.println("ID Detail         : " + pinjam.getDetailPinjam().getIdDetail());
			System.out.println("Tanggal Pinjam    : " + pinjam.getDetailPinjam().getTglPinjam());
			System.out.println("Tanggal Kembali   : " + pinjam.getDetailPinjam().getTglKembali());

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public void showDetailPinjam2() {
		List<Pinjam> newistPinjam;
		List<DetailPinjam> newistDetail;

		try {

			@SuppressWarnings("unchecked")
			List<Pinjam> listPinjam = session.createQuery("from Pinjam").getResultList();
			List<DetailPinjam> listDetail = session.createQuery("from DetailPinjam").getResultList();

			printDetailPinjam(listPinjam);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
