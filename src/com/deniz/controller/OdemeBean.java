package com.deniz.controller;

import java.sql.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.deniz.model.OdemeCRUD;
import com.deniz.model.OgrenciCRUD;
import com.deniz.model.YoneticiCRUD;
import com.deniz.session.YonetimSession;

@ManagedBean
@SessionScoped
public class OdemeBean {
	
	private int odemeId;
	private int ogrenciId;
	private int yoneticiId;
	private Date odemeTarih;
	private String odemeSekli;
	private int odenecekTutar;
	
	private java.util.Date tarih;

	private String ogrenciAd;
	private String ogrenciSoyad;
	private Long ogrenciCepNo;
	private Long ogrenciTc;
	private String ogrenciOdaKod;
	
	
	
	
	public int getOdenecekTutar() {
		return odenecekTutar;
	}

	public void setOdenecekTutar(int odenecekTutar) {
		this.odenecekTutar = odenecekTutar;
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

	public Long getOgrenciCepNo() {
		return ogrenciCepNo;
	}

	public void setOgrenciCepNo(Long ogrenciCepNo) {
		this.ogrenciCepNo = ogrenciCepNo;
	}

	public Long getOgrenciTc() {
		return ogrenciTc;
	}

	public void setOgrenciTc(Long ogrenciTc) {
		this.ogrenciTc = ogrenciTc;
	}

	public String getOgrenciOdaKod() {
		return ogrenciOdaKod;
	}

	public void setOgrenciOdaKod(String ogrenciOdaKod) {
		this.ogrenciOdaKod = ogrenciOdaKod;
	}

	public int getOdemeId() {
		return odemeId;
	}

	public void setOdemeId(int odemeId) {
		this.odemeId = odemeId;
	}

	public int getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(int ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public int getYoneticiId() {
		return yoneticiId;
	}

	public void setYoneticiId(int yoneticiId) {
		this.yoneticiId = yoneticiId;
	}

	public Date getOdemeTarih() {
		return odemeTarih;
	}

	public void setOdemeTarih(Date odemeTarih) {
		this.odemeTarih = odemeTarih;
	}

	public String getOdemeSekli() {
		return odemeSekli;
	}

	public void setOdemeSekli(String odemeSekli) {
		this.odemeSekli = odemeSekli;
	}

	public java.util.Date getTarih() {
		return tarih;
	}

	public void setTarih(java.util.Date tarih) {
		this.tarih = tarih;
	}
	
	
 
	public String ogrenciOdeme()
	{
		Map<String,String> parametre =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		OgrenciBean  ogrenci =OgrenciCRUD.ogrenciCek(Integer.parseInt(parametre.get("ogrenciId")));
		
		YoneticiBean yonetici = YoneticiCRUD.yoneticiCek(Long.parseLong(YonetimSession.getYoneticiTc()));
		
		 this.ogrenciTc = ogrenci.getOgrenciTc();
		 this.ogrenciAd = ogrenci.getOgrenciAd();
		 this.ogrenciSoyad = ogrenci.getOgrenciSoyad();
 		 this.ogrenciCepNo = ogrenci.getOgrenciCepNo();
 		 this.ogrenciId	=ogrenci.getOgrenciId();
 		 this.odenecekTutar = ogrenci.getOgrenciOdeme();
 		 this.yoneticiId =yonetici.getYoneticiId();
 		 
 		return "ogrenciodeme.jsf?faces-redirect=true";
	}
	
	
	public void ogrenciOdemeYap()
	{
		System.out.println("##");
		
		OdemeCRUD.ogrenciOdemeYap(ogrenciId, yoneticiId);;
	}

}
