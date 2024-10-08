package com.itenas.uas.rpl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pinjam")
public class Pinjam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_pinjam")
	private int idPinjam;

	@Column(name = "ID_peminjam")
	private int idPeminjam;

	@Column(name = "ID_buku")
	private int idBuku;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_detail")
	private DetailPinjam detailPinjam;

	public Pinjam() {
	}

	public Pinjam(int idPeminjam, int idBuku) {
		super();
		this.idPeminjam = idPeminjam;
		this.idBuku = idBuku;
	}

	public int getIdPinjam() {
		return idPinjam;
	}

	public void setIdPinjam(int idPinjam) {
		this.idPinjam = idPinjam;
	}

	public int getIdPeminjam() {
		return idPeminjam;
	}

	public void setIdPeminjam(int idPeminjam) {
		this.idPeminjam = idPeminjam;
	}

	public int getIdBuku() {
		return idBuku;
	}

	public void setIdBuku(int idBuku) {
		this.idBuku = idBuku;
	}

	public DetailPinjam getDetailPinjam() {
		return detailPinjam;
	}

	public void setDetailPinjam(DetailPinjam detailPinjam) {
		this.detailPinjam = detailPinjam;
	}

	@Override
	public String toString() {
		return "Pinjam [idPeminjam=" + idPeminjam + ", idBuku=" + idBuku + ", detailPinjam=" + detailPinjam + "]";
	}

}
