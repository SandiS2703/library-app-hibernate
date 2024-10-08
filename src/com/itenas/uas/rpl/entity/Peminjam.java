package com.itenas.uas.rpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "peminjam")
public class Peminjam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_peminjam")
	private int idPeminjam;

	@Column(name = "Nama_peminjam")
	private String namaPeminjam;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Tgl_lahir")
	private String tglLahir;

	public Peminjam() {

	}

	public Peminjam(String namaPeminjam, String gender, String tglLahair) {

		this.namaPeminjam = namaPeminjam;
		this.gender = gender;
		this.tglLahir = tglLahair;
	}

	public int getIdPeminjam() {
		return idPeminjam;
	}

	public void setIdPeminjam(int idPeminjam) {
		this.idPeminjam = idPeminjam;
	}

	public String getNamaPeminjam() {
		return namaPeminjam;
	}

	public void setNamaPeminjam(String namaPeminjam) {
		this.namaPeminjam = namaPeminjam;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(String tglLahir) {
		this.tglLahir = tglLahir;
	}

	@Override
	public String toString() {
		return "Peminjam [idPeminjam=" + idPeminjam + ", namaPeminjam=" + namaPeminjam + ", gender=" + gender
				+ ", tglLahair=" + tglLahir + "]";
	}

}
