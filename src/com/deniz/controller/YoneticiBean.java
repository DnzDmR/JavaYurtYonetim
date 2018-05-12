package com.deniz.controller;

 
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.deniz.model.YoneticiCRUD;
import com.deniz.session.YonetimSession;

@ManagedBean
@SessionScoped
public class YoneticiBean {
	
	private Long yoneticiTc;
	private Long yoneticiCepNo;
	private Integer yoneticiId;
	private Integer yoneticiYetki;

	private String yoneticiAd;
	private String yoneticiSoyad;
	private String yoneticiAdres;
	private String yoneticiSifre;
	private Date yoneticiDogumTarihi;
	
	private Integer yoneticiBirimId;
	private Integer yoneticiBirimMaas;
	private String yoneticiBirimAd;

	
 	private java.util.Date tarih;

 	private YoneticiBean secilenYonetici;
 	private String arananDeger;
	private ArrayList<YoneticiBean> arananYoneticiList;
	
	private String eskiSifre;
 	
 	

	  
	 
	
	public String getEskiSifre() {
		return eskiSifre;
	}

	public void setEskiSifre(String eskiSifre) {
		this.eskiSifre = eskiSifre;
	}

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

	public Integer getYoneticiBirimId() {
		return yoneticiBirimId;
	}

	public void setYoneticiBirimId(Integer yoneticiBirimId) {
		this.yoneticiBirimId = yoneticiBirimId;
	}

	public String getYoneticiBirimAd() {
		return yoneticiBirimAd;
	}

	public void setYoneticiBirimAd(String yoneticiBirimAd) {
		this.yoneticiBirimAd = yoneticiBirimAd;
	}

	public Integer getYoneticiBirimMaas() {
		return yoneticiBirimMaas;
	}

	public void setYoneticiBirimMaas(Integer yoneticiBirimMaas) {
		this.yoneticiBirimMaas = yoneticiBirimMaas;
	}

	public java.util.Date getTarih() {
		return tarih;
	}

	public void setTarih(java.util.Date tarih) {
		this.tarih = tarih;
	}

	public YoneticiBean getSecilenYonetici() {
		return secilenYonetici;
	}

	public void setSecilenYonetici(YoneticiBean secilenYonetici) {
		this.secilenYonetici = secilenYonetici;
	}

	public String getArananDeger() {
		return arananDeger;
	}

	public void setArananDeger(String arananDeger) {
		this.arananDeger = arananDeger;
	}

	public ArrayList<YoneticiBean> getArananYoneticiList() {
		return arananYoneticiList;
	}

	public void setArananYoneticiList(ArrayList<YoneticiBean> arananYoneticiList) {
		this.arananYoneticiList = arananYoneticiList;
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
	
	public void yoneticiKaydet()
	{
		// Util Date olarak alınan doğum tarihi sql date olarak dönüştürüldü.
				java.util.Date utilDate = tarih;
			    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			    this.yoneticiDogumTarihi=sqlDate;
		
		YoneticiBean yonetici = this;
		
		boolean valid = YoneticiCRUD.yoneticiKaydet(yonetici);
		
		if(valid)
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Yönetici Kaydı Başarılı"));
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Yönetici Kaydı Başarısız"));
		}
		
	}
	
	public ArrayList<YoneticiBean> birimListele()
	{
		return YoneticiCRUD.birimListele();
	}
	
	
	public void yoneticiArama()
	{
		this.arananYoneticiList= YoneticiCRUD.yoneticiArama(arananDeger);
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
	
	
	public void sessionDestroy()
	{
		YonetimSession.sessionDestroy();
		 try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
		} catch (IOException e) {e.printStackTrace();}
	}
	
	
	public void sifreGuncelle()
	{
		
		String valid = YoneticiCRUD.yoneticiGiris(Long.parseLong(YonetimSession.getYoneticiTc().toString()), eskiSifre);
		if(valid.equals("var"))
		{
			boolean valid2= YoneticiCRUD.sifreGuncelle(Long.parseLong(YonetimSession.getYoneticiTc().toString()), yoneticiSifre);
			if(valid2)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Şifre Değiştirildi."));
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Şifre Değiştirilemedi."));
			}
		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mevcut Şifreniz Doğrulanamadı."));
		}
	 	
	}
	
	public void  yoneticiCek()
	{
		YoneticiBean ogrenci =YoneticiCRUD.yoneticiCek(Long.parseLong(YonetimSession.getYoneticiTc()));
		this.yoneticiAd =ogrenci.yoneticiAd;
		this.yoneticiSoyad =ogrenci.yoneticiSoyad;
		this.yoneticiDogumTarihi =ogrenci.yoneticiDogumTarihi;
		this.yoneticiAdres =ogrenci.yoneticiAdres;
		this.yoneticiCepNo = ogrenci.yoneticiCepNo;
		this.yoneticiBirimMaas= ogrenci.yoneticiBirimMaas;
		this.yoneticiBirimAd = ogrenci.yoneticiBirimAd;
		this.yoneticiTc=ogrenci.yoneticiTc;
	}
	
	public void temizle()
	{
		this.yoneticiAd =null;
		this.yoneticiSoyad =null;
		this.yoneticiDogumTarihi =null;
		this.yoneticiAdres =null;
		this.yoneticiCepNo = null;
		this.yoneticiBirimMaas= null;
		this.yoneticiBirimAd =null;
		this.yoneticiTc=null;
		this.yoneticiSifre=null;
	}
	
	
	public String duzen()
	{
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		YoneticiBean a =YoneticiCRUD.yoneticiCek(Long.parseLong(map.get("yoneticiTc")));
		
		
		this.yoneticiSoyad=a.yoneticiSoyad;
		this.yoneticiAd=a.yoneticiAd;
		this.yoneticiAdres=a.yoneticiAdres;
		this.yoneticiTc=a.yoneticiTc;
		this.tarih=a.yoneticiDogumTarihi;
		this.yoneticiCepNo=a.yoneticiCepNo;
		this.yoneticiBirimAd=a.yoneticiBirimAd;
		this.yoneticiYetki=a.yoneticiYetki;
		this.yoneticiSifre=a.yoneticiSifre;
		this.yoneticiBirimId=a.yoneticiBirimId;
		this.yoneticiId=a.yoneticiId;
	
		return "yoneticiduzenle.jsf?faces-redirect=true";
	}
	
	
	public void yoneticiGuncelle()
	{
			java.util.Date utilDate = tarih;
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    this.yoneticiDogumTarihi=sqlDate;
		    
			YoneticiBean yonetici = this;
			boolean valid = YoneticiCRUD.yoneticiGuncelle(yonetici);
			if(valid)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Yönetici Güncellendi."));
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Yönetici Güncellenemedi."));
			}
	}
	public int yoneticiYetkiGetir()
	{
		YoneticiBean yonetici = YoneticiCRUD.yoneticiCek(Long.parseLong(YonetimSession.getYoneticiTc()));
		return yonetici.getYoneticiYetki();
	}
	
	
	
	

}
