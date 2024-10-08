package com.itenas.uas.rpl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jenis_buku")
public class JenisBuku {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "Jenis")
	private String jenis;

	@OneToMany(mappedBy = "jenisBuku", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH })
	private List<Buku> buku;

	public JenisBuku() {
		super();
	}

	public JenisBuku(String jenis) {
		super();
		this.jenis = jenis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public List<Buku> getBuku() {
		return buku;
	}

	public void setBuku(List<Buku> buku) {
		this.buku = buku;
	}

	public void addBuku(Buku tempBuku) {
		if (buku == null) {
			buku = new ArrayList<Buku>();
		}

		buku.add(tempBuku);
		tempBuku.setJenisBuku(this);
	}

	@Override
	public String toString() {
		return "JenisBuku [id=" + id + ", jenis=" + jenis + ", buku=" + buku + "]";
	}

}
