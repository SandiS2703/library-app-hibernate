package com.itenas.uas.rpl.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_pinjam")
public class DetailPinjam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_detail")
	private int idDetail;

	@Column(name = "Tgl_pinjam")
	private String tglPinjam;

	@Column(name = "Tgl_kembali")
	private String tglKembali;

	@OneToOne(mappedBy = "detailPinjam", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Pinjam pinjam;

	public DetailPinjam() {
		super();
	}

	public DetailPinjam(String tglPinjam, String tglKembali) {
		super();
		this.tglPinjam = tglPinjam;
		this.tglKembali = tglKembali;
	}

	public int getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(int idDetail) {
		this.idDetail = idDetail;
	}

	public String getTglPinjam() {
		return tglPinjam;
	}

	public void setTglPinjam(String tglPinjam) {
		this.tglPinjam = tglPinjam;
	}

	public String getTglKembali() {
		return tglKembali;
	}

	public void setTglKembali(String tglKembali) {
		this.tglKembali = tglKembali;
	}

	public Pinjam getPinjam() {
		return pinjam;
	}

	public void setPinjam(Pinjam pinjam) {
		this.pinjam = pinjam;
	}

}
