package com.deniz.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.deniz.model.BolumCRUD;
import com.deniz.model.FakulteCRUD;
import com.deniz.model.OgrenciCRUD;




@ManagedBean
@SessionScoped
public class OgrenciBean {
	
	private Integer ogrenciId;
	private Integer ogrenciTc;
	private Integer ogrenciCepNo;
	private Integer ogrenciKayitDurum;
	private Integer ogrenciOdaNo;
	private Integer ogrenciVeliCepNo;
	private Integer ogrenciSinif;
	
	private String ogrenciAd;
	private String ogrenciSoyad;
	private String ogrenciAdres;
	
	private String ogrenciVeliAd;
	private Date ogrenciDogumTarihi;
 
	private  ArrayList<FakulteBean> fakulteList;
	private  ArrayList<BolumBean> bolumList;
	
	private int secilenUniversiteId;
	private int secilenFakulteId;
	private int secilenBolumId;
	
	 
	private java.util.Date tarih;
	 
 
	
	
	public java.util.Date getTarih() {
		return tarih;
	}
	public void setTarih(java.util.Date tarih) {
		this.tarih = tarih;
	}
	public Date getOgrenciDogumTarihi() {
		return ogrenciDogumTarihi;
	}
	public void setOgrenciDogumTarihi(Date ogrenciDogumTarihi) {
		this.ogrenciDogumTarihi = ogrenciDogumTarihi;
	}
	public int getSecilenUniversiteId() {
		return secilenUniversiteId;
	}
	public void setSecilenUniversiteId(int secilenUniversiteId) {
		this.secilenUniversiteId = secilenUniversiteId;
	}
	public int getSecilenFakulteId() {
		return secilenFakulteId;
	}
	public void setSecilenFakulteId(int secilenFakulteId) {
		this.secilenFakulteId = secilenFakulteId;
	}
	public int getSecilenBolumId() {
		return secilenBolumId;
	}
	public void setSecilenBolumId(int secilenBolumId) {
		this.secilenBolumId = secilenBolumId;
	}
	public ArrayList<FakulteBean> getFakulteList() {
		return fakulteList;
	}
	public void setFakulteList(ArrayList<FakulteBean> fakulteList) {
		this.fakulteList = fakulteList;
	}
	public ArrayList<BolumBean> getBolumList() {
		return bolumList;
	}
	public void setBolumList(ArrayList<BolumBean> bolumList) {
		this.bolumList = bolumList;
	}
	public Integer getOgrenciId() {
		return ogrenciId;
	}
	public void setOgrenciId(Integer ogrenciId) {
		this.ogrenciId = ogrenciId;
	}
	public Integer getOgrenciTc() {
		return ogrenciTc;
	}
	public void setOgrenciTc(Integer ogrenciTc) {
		this.ogrenciTc = ogrenciTc;
	}
	public Integer getOgrenciCepNo() {
		return ogrenciCepNo;
	}
	public void setOgrenciCepNo(Integer ogrenciCepNo) {
		this.ogrenciCepNo = ogrenciCepNo;
	}
	public Integer getOgrenciKayitDurum() {
		return ogrenciKayitDurum;
	}
	public void setOgrenciKayitDurum(Integer ogrenciKayitDurum) {
		this.ogrenciKayitDurum = ogrenciKayitDurum;
	}
	public Integer getOgrenciOdaNo() {
		return ogrenciOdaNo;
	}
	public void setOgrenciOdaNo(Integer ogrenciOdaNo) {
		this.ogrenciOdaNo = ogrenciOdaNo;
	}
	public Integer getOgrenciVeliCepNo() {
		return ogrenciVeliCepNo;
	}
	public void setOgrenciVeliCepNo(Integer ogrenciVeliCepNo) {
		this.ogrenciVeliCepNo = ogrenciVeliCepNo;
	}
	public Integer getOgrenciSinif() {
		return ogrenciSinif;
	}
	public void setOgrenciSinif(Integer ogrenciSinif) {
		this.ogrenciSinif = ogrenciSinif;
	}
	public String getOgrenciAd() {
		return ogrenciAd;
	}
	public void setOgrenciAd(String ogrenciAd) {
		this.ogrenciAd = ogrenciAd;
	}
	public String getOgrenciSoyad() {
		return ogrenciSoyad;
	}
	public void setOgrenciSoyad(String ogrenciSoyad) {
		this.ogrenciSoyad = ogrenciSoyad;
	}
	public String getOgrenciAdres() {
		return ogrenciAdres;
	}
	public void setOgrenciAdres(String ogrenciAdres) {
		this.ogrenciAdres = ogrenciAdres;
	}
	public String getOgrenciVeliAd() {
		return ogrenciVeliAd;
	}
	public void setOgrenciVeliAd(String ogrenciVeliAd) {
		this.ogrenciVeliAd = ogrenciVeliAd;
	}
 
	

	
	

	
	public void universiteDegisim()
	{
		System.out.println("secilenUnv:"+secilenUniversiteId);
 		fakulteList=FakulteCRUD.fakulteCek(secilenUniversiteId);
 	}
	
	public void fakulteDegisim()
	{
		System.out.println("secilenfak:"+secilenFakulteId);
 		bolumList=BolumCRUD.bolumCek(secilenFakulteId);
 	}
		
	public void ogrenciKayit()
	{	
		// Util Date olarak alınan doğum tarihi sql date olarak dönüştürüldü.
		java.util.Date utilDate = tarih;
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    this.ogrenciDogumTarihi=sqlDate;
	    
  		OgrenciBean ogrenci = this;
		OgrenciCRUD.ogrenciKayit(ogrenci);
	}
 
	

}
