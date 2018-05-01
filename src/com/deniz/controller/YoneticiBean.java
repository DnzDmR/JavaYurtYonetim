package com.deniz.controller;

 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.deniz.model.YoneticiCRUD;
import com.deniz.session.YonetimSession;

@ManagedBean
public class YoneticiBean {
	
	private Integer yoneticiId;
	private Integer yoneticiTc;
	private Integer yoneticiCepNo;
	private Integer yoneticiYetki;
	private String yoneticiAd;
	private String yoneticiSoyad;
	private String yoneticiAdres;
	private String yoneticiSifre;
	
	
	public Integer getYoneticiId() {
		return yoneticiId;
	}
	public void setYoneticiId(Integer yoneticiId) {
		this.yoneticiId = yoneticiId;
	}
	public Integer getYoneticiTc() {
		return yoneticiTc;
	}
	public void setYoneticiTc(Integer yoneticiTc) {
		this.yoneticiTc = yoneticiTc;
	}
	public Integer getYoneticiCepNo() {
		return yoneticiCepNo;
	}
	public void setYoneticiCepNo(Integer yoneticiCepNo) {
		this.yoneticiCepNo = yoneticiCepNo;
	}
	public Integer getYoneticiYetki() {
		return yoneticiYetki;
	}
	public void setYoneticiYetki(Integer yoneticiYetki) {
		this.yoneticiYetki = yoneticiYetki;
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
	public String getYoneticiAdres() {
		return yoneticiAdres;
	}
	public void setYoneticiAdres(String yoneticiAdres) {
		this.yoneticiAdres = yoneticiAdres;
	}
	public String getYoneticiSifre() {
		return yoneticiSifre;
	}
	public void setYoneticiSifre(String yoneticiSifre) {
		this.yoneticiSifre = yoneticiSifre;
	}
	
	
	
	// FONKSİYONLAR BAŞLANGIÇ
	
	public String yoneticiGiris() 
	{
		String durum = YoneticiCRUD.yoneticiGiris(yoneticiId, yoneticiSifre);
		if(durum.equals("var"))
		{
			HttpSession session = YonetimSession.getSession();
			session.setAttribute("yoneticiId", yoneticiId);
			return "anasayfa.jsf?faces-redirect=true";
		}
		else if(durum.equals("yok"))
		{
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Kullanıcı Bulunamadı."));
			return "index.jsf";
		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Beklenilmeyen bir hata ile Karşılaşıldı."));
			return "index.jsf";
		}
			
	}
	
	public String sessionKontrol()
	{
		HttpSession session = YonetimSession.getSession();
		if(session.getAttribute("yoneticiId")==null)
		{
			return "sessionyok";
		}
		else
		{
			return "sessionvar";
		}
	}
	
	
	
	
	

}
