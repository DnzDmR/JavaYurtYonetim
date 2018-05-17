package com.deniz.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import com.deniz.model.GirisCRUD;

@ManagedBean
public class GirisBean {
	
	private int girisId;
	private java.sql.Timestamp girisTarih;
	private Long yoneticiTc;
	private String yoneticiAd;
	private String yoneticiSoyad;
	
	public int getGirisId() {
		return girisId;
	}
	public void setGirisId(int girisId) {
		this.girisId = girisId;
	}
	public java.sql.Timestamp getGirisTarih() {
		return girisTarih;
	}
	public void setGirisTarih(java.sql.Timestamp girisTarih) {
		this.girisTarih = girisTarih;
	}
	public Long getYoneticiTc() {
		return yoneticiTc;
	}
	public void setYoneticiTc(Long yoneticiTc) {
		this.yoneticiTc = yoneticiTc;
	}
	public String getYoneticiAd() {
		return yoneticiAd;
	}
	public void setYoneticiAd(String yoneticiAd) {
		this.yoneticiAd = yoneticiAd;
	}
	public String getYoneticiSoyad() {
		return yoneticiSoyad;
	}
	public void setYoneticiSoyad(String yoneticiSoyad) {
		this.yoneticiSoyad = yoneticiSoyad;
	}
	
	
	
	public ArrayList<GirisBean> girisLogCek()
	{
		return GirisCRUD.girisLogCek();
	}
	

}
