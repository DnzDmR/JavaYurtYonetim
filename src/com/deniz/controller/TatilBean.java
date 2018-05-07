package com.deniz.controller;
 
 
import java.sql.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.deniz.model.TatilCRUD;
import com.deniz.model.OgrenciCRUD;

@ManagedBean
@SessionScoped
public class TatilBean {
	
	private Integer izinId;
	private Integer ogrenciId;
	private Date gidisTarih;
	private Date donusTarih;
	private String izinAdresi;
	private Integer izinDurum; // geldi mi gelmedi mi
	
	private String ogrenciAd;
	private String ogrenciSoyad;
	private Long ogrenciCepNo;
	private Long ogrenciTc;
	private String ogrenciOdaKod;
	
	
	private java.util.Date uGidisTarih;
	private java.util.Date uDonusTarih;
	
	
	
	public java.util.Date getuGidisTarih() {
		return uGidisTarih;
	}
	public void setuGidisTarih(java.util.Date uGidisTarih) {
		this.uGidisTarih = uGidisTarih;
	}
	public java.util.Date getuDonusTarih() {
		return uDonusTarih;
	}
	public void setuDonusTarih(java.util.Date uDonusTarih) {
		this.uDonusTarih = uDonusTarih;
	}
	public Integer getIzinId() {
		return izinId;
	}
	public void setIzinId(Integer izinId) {
		this.izinId = izinId;
	}
	public Integer getOgrenciId() {
		return ogrenciId;
	}
	public void setOgrenciId(Integer ogrenciId) {
		this.ogrenciId = ogrenciId;
	}
	public Date getGidisTarih() {
		return gidisTarih;
	}
	public void setGidisTarih(Date gidisTarih) {
		this.gidisTarih = gidisTarih;
	}
	public Date getDonusTarih() {
		return donusTarih;
	}
	public void setDonusTarih(Date donusTarih) {
		this.donusTarih = donusTarih;
	}
	public String getIzinAdresi() {
		return izinAdresi;
	}
	public void setIzinAdresi(String izinAdresi) {
		this.izinAdresi = izinAdresi;
	}
	public Integer getIzinDurum() {
		return izinDurum;
	}
	public void setIzinDurum(Integer izinDurum) {
		this.izinDurum = izinDurum;
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
	
	public String izin()
	{
		Map<String,String> parametre =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		OgrenciBean  ogrenci =OgrenciCRUD.ogrenciCek(Integer.parseInt(parametre.get("ogrenciId")));
		
		 this.ogrenciTc = ogrenci.getOgrenciTc();
		 this.ogrenciAd = ogrenci.getOgrenciAd();
		 this.ogrenciSoyad = ogrenci.getOgrenciSoyad();
 		 this.ogrenciCepNo = ogrenci.getOgrenciCepNo();
 		 this.ogrenciId	=ogrenci.getOgrenciId();
 		 
		 return "ogrenciizin.jsf?faces-redirect=true";
	}
	
	
	
	
	public void izinTalep()
	{
		 System.out.println("##"+this.izinAdresi);
		
		 java.sql.Date sqlDate =new java.sql.Date(uGidisTarih.getTime());
		 this.gidisTarih=sqlDate;
		 java.sql.Date sqlDate2 =new java.sql.Date(uDonusTarih.getTime());
		 this.donusTarih=sqlDate2;
		 
		 TatilBean izin =this;
		 boolean valid =TatilCRUD.izinTalep(izin);
		 
		 if(valid)
		 {
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("İzin Oluşturuldu."));
		 }
		 else
		 {
			 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("İzin oluşturulamadı."));
		 }
		 
	}
	

}
