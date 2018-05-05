package com.deniz.controller;

 
import java.io.IOException;
import java.sql.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.deniz.model.YoneticiCRUD;
import com.deniz.session.YonetimSession;

@ManagedBean
public class YoneticiBean {
	
	private Long yoneticiTc;
	private Long yoneticiCepNo;
	private Integer yoneticiId;
	private Integer yoneticiYetki;
	private Integer yoneticiBirimId;
	private String yoneticiAd;
	private String yoneticiSoyad;
	private String yoneticiAdres;
	private String yoneticiSifre;
	private Date yoneticiDogumTarihi;
	

	public Long getYoneticiTc() {
		return yoneticiTc;
	}

	public void setYoneticiTc(Long yoneticiTc) {
		this.yoneticiTc = yoneticiTc;
	}

	public Long getYoneticiCepNo() {
		return yoneticiCepNo;
	}

	public void setYoneticiCepNo(Long yoneticiCepNo) {
		this.yoneticiCepNo = yoneticiCepNo;
	}

	public Integer getYoneticiId() {
		return yoneticiId;
	}

	public void setYoneticiId(Integer yoneticiId) {
		this.yoneticiId = yoneticiId;
	}

	public Integer getYoneticiYetki() {
		return yoneticiYetki;
	}

	public void setYoneticiYetki(Integer yoneticiYetki) {
		this.yoneticiYetki = yoneticiYetki;
	}

	public Integer getYoneticiBirimId() {
		return yoneticiBirimId;
	}

	public void setYoneticiBirimId(Integer yoneticiBirimId) {
		this.yoneticiBirimId = yoneticiBirimId;
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

	public Date getYoneticiDogumTarihi() {
		return yoneticiDogumTarihi;
	}

	public void setYoneticiDogumTarihi(Date yoneticiDogumTarihi) {
		this.yoneticiDogumTarihi = yoneticiDogumTarihi;
	}
	
	


	
	
	
	// FONKSİYONLAR BAŞLANGIÇ
	
	public String yoneticiGiris() 
	{
		String durum = YoneticiCRUD.yoneticiGiris(yoneticiTc, yoneticiSifre);
		if(durum.equals("var"))
		{
			HttpSession session = YonetimSession.getSession();
			session.setAttribute("yoneticiTc", yoneticiTc);
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
	
	public void sessionKontrol()
	{
		HttpSession session = YonetimSession.getSession();
		if(session.getAttribute("yoneticiTc")==null)
		{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
				} catch (IOException e) { System.out.println("hata -->>"+e.getMessage());	}
		}
		 
	}
	
	
	public String sessionDestroy()
	{
		YonetimSession.sessionDestroy();
		return "index.jsf?faces-redirect=true";
	}
	
	
	
	
	

}
