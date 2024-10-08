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
@Table(name = "buku")
public class Buku {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_buku")
	private int ID_buku;

	@Column(name = "judul")
	private String judul;

	@Column(name = "pengarang")
	private String pengarang;

	@Column(name = "penerbit")
	private String penerbit;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "ID_jenis")
	private JenisBuku jenisBuku;

	public Buku() {

	}

	public Buku(String judul, String pengarang, String penerbit) {
		this.judul = judul;
		this.pengarang = pengarang;
		this.penerbit = penerbit;
	}

	public int getID_buku() {
		return ID_buku;
	}

	public void setID_buku(int iD_buku) {
		ID_buku = iD_buku;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getPengarang() {
		return pengarang;
	}

	public void setPengarang(String pengarang) {
		this.pengarang = pengarang;
	}

	public String getPenerbit() {
		return penerbit;
	}

	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}

	public JenisBuku getJenisBuku() {
		return jenisBuku;
	}

	public void setJenisBuku(JenisBuku jenisBuku) {
		this.jenisBuku = jenisBuku;
	}

	@Override
	public String toString() {
		return "Buku [ID_buku=" + ID_buku + ", judul =" + judul + ", pengarang =" + pengarang + ", penerbit ="
				+ penerbit + "]";
	}

}
