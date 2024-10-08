package com.itenas.uas.rpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pustakawan")
public class Pustakawan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_pustakawan")
	private int idPustakawan;
	
	@Column(name = "Nama_pustakawan")
	private String namaPustakawan;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Tgl_lahir")
	private String tanggalLahir;
	
	public Pustakawan() {
	}

	public Pustakawan(String namaPustakawan, String gender, String tanggalLahir) {
		super();
		this.namaPustakawan = namaPustakawan;
		this.gender = gender;
		this.tanggalLahir = tanggalLahir;
	}

	public int getIdPustakawan() {
		return idPustakawan;
	}

	public void setIdPustakawan(int idPustakawan) {
		this.idPustakawan = idPustakawan;
	}

	public String getNamaPustakawan() {
		return namaPustakawan;
	}

	public void setNamaPustakawan(String namaPustakawan) {
		this.namaPustakawan = namaPustakawan;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(String tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	@Override
	public String toString() {
		return "Pustakawan [idPustakawan=" + idPustakawan + ", namaPustakawan=" + namaPustakawan + ", gender=" + gender
				+ ", tanggalLahir=" + tanggalLahir + "]";
	}
	
	
	
}
