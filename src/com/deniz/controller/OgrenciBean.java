package com.deniz.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.deniz.model.BolumCRUD;
import com.deniz.model.FakulteCRUD;
import com.deniz.model.OgrenciCRUD;




@ManagedBean
@SessionScoped
public class OgrenciBean {
	
	private Integer ogrenciId;
	private Long ogrenciTc;
	private Long ogrenciCepNo;
	private Long ogrenciVeliCepNo;
	
	private Integer ogrenciKayitDurum;
	private Integer ogrenciOdaNo;
	private Integer ogrenciSinif;
	private Integer ogrenciBolumId;
	
	private String ogrenciAd;
	private String ogrenciSoyad;
	private String ogrenciAdres;
	
	private String ogrenciVeliAd;
	private Date ogrenciDogumTarihi;
 
	private  ArrayList<FakulteBean> fakulteList;
	private  ArrayList<BolumBean> bolumList;
	private ArrayList<OgrenciBean> arananOgrenciList;
	
	private int secilenUniversiteId;
	private int secilenFakulteId;
	private int secilenBolumId;
	
 	private java.util.Date tarih;
	 
	private int kayitId;
	private Date girisTarih;
	private Date cikisTarih;
	
	private String arananOgrenciAdi;
	private OgrenciBean secilenOgrenci;
	
	
	
	
	 
	
	

	

	public ArrayList<OgrenciBean> getArananOgrenciList() {
		return arananOgrenciList;
	}

	public void setArananOgrenciList(ArrayList<OgrenciBean> arananOgrenciList) {
		this.arananOgrenciList = arananOgrenciList;
	}

	public String getArananOgrenciAdi() {
		return arananOgrenciAdi;
	}

	public void setArananOgrenciAdi(String arananOgrenciAdi) {
		this.arananOgrenciAdi = arananOgrenciAdi;
	}

	public OgrenciBean getSecilenOgrenci() {
		return secilenOgrenci;
	}

	public void setSecilenOgrenci(OgrenciBean secilenOgrenci) {
		this.secilenOgrenci = secilenOgrenci;
	}

	public int getKayitId() {
		return kayitId;
	}

	public void setKayitId(int kayitId) {
		this.kayitId = kayitId;
	}

	public Date getGirisTarih() {
		return girisTarih;
	}

	public void setGirisTarih(Date girisTarih) {
		this.girisTarih = girisTarih;
	}

	public Date getCikisTarih() {
		return cikisTarih;
	}

	public void setCikisTarih(Date cikisTarih) {
		this.cikisTarih = cikisTarih;
	}

	public Integer getOgrenciBolumId() {
		return ogrenciBolumId;
	}

	public void setOgrenciBolumId(Integer ogrenciBolumId) {
		this.ogrenciBolumId = ogrenciBolumId;
	}

	public Integer getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(Integer ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public Long getOgrenciTc() {
		return ogrenciTc;
	}

	public void setOgrenciTc(Long ogrenciTc) {
		this.ogrenciTc = ogrenciTc;
	}

	public Long getOgrenciCepNo() {
		return ogrenciCepNo;
	}

	public void setOgrenciCepNo(Long ogrenciCepNo) {
		this.ogrenciCepNo = ogrenciCepNo;
	}

	public Long getOgrenciVeliCepNo() {
		return ogrenciVeliCepNo;
	}

	public void setOgrenciVeliCepNo(Long ogrenciVeliCepNo) {
		this.ogrenciVeliCepNo = ogrenciVeliCepNo;
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

	public Date getOgrenciDogumTarihi() {
		return ogrenciDogumTarihi;
	}

	public void setOgrenciDogumTarihi(Date ogrenciDogumTarihi) {
		this.ogrenciDogumTarihi = ogrenciDogumTarihi;
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

	public java.util.Date getTarih() {
		return tarih;
	}

	public void setTarih(java.util.Date tarih) {
		this.tarih = tarih;
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
		boolean valid = OgrenciCRUD.ogrenciKayit(ogrenci);
		if(valid)
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Kayıt Başarılı"));
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Kayıt Başarısız"));
		}
	}
	
	
	
	
	public ArrayList<OgrenciBean> kayitBekleyenOgrenciler()
	{
		return OgrenciCRUD.kayitBekleyenOgrenciler();
	}
	
	

	public void ogrenciOdaKayit()
	{
 
		boolean valid =OgrenciCRUD.ogrenciOdaKayit(ogrenciId, ogrenciOdaNo);
		
		if(valid)
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Oda Kaydı Başarılı"));
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Oda Kaydı Başarısız"));
		}
		
	}
	
	
	public void ogrenciArama()
	{
		arananOgrenciList= OgrenciCRUD.ogrenciArama(arananOgrenciAdi);
	}
	
	 
	public String ogrenciCek()   
	{
		Map<String,String> parametre =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		System.out.println(parametre.get("ogrenciId"));
		OgrenciBean  ogrenci =OgrenciCRUD.ogrenciCek(Integer.parseInt(parametre.get("ogrenciId")));
		
		 this.ogrenciTc = ogrenci.ogrenciTc;
		 this.ogrenciAd = ogrenci.ogrenciAd;
		 this.ogrenciSoyad = ogrenci.ogrenciSoyad;
		 this.ogrenciAdres = ogrenci.ogrenciAdres;
		 this.ogrenciCepNo = ogrenci.ogrenciCepNo;
		 this.ogrenciVeliAd =ogrenci.ogrenciVeliAd;
		 this.ogrenciVeliCepNo = ogrenci.ogrenciVeliCepNo;
		 this.tarih = ogrenci.ogrenciDogumTarihi;
		 this.ogrenciSinif = ogrenci.ogrenciSinif;
		 this.ogrenciKayitDurum = ogrenci.ogrenciKayitDurum;
		
		 return "ogrenciduzenle.jsf?faces-redirect=true";
		
 	}
	
	
}
