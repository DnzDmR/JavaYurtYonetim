package com.deniz.controller;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.deniz.model.OdaCRUD;

@ManagedBean
@SessionScoped
public class OdaBean {

	private int odaId;
	private int odaYatakSayisi;
	private int odaBalkonDurumu;
	private Integer odaFiyatBilgisi;
	private Integer odaGenislik;
	private String odaKod;
	private OdaBean secilenOda;
	private int odaMevcudu;
	private String arananOda;
	
	private ArrayList<OdaBean> arananOdaList;
	
  
	 
	 
	
	
	
	public ArrayList<OdaBean> getArananOdaList() {
		return arananOdaList;
	}


	public void setArananOdaList(ArrayList<OdaBean> arananOdaList) {
		this.arananOdaList = arananOdaList;
	}


	public String getArananOda() {
		return arananOda;
	}


	public void setArananOda(String arananOda) {
		this.arananOda = arananOda;
	}


	public int getOdaId() {
		return odaId;
	}


	public void setOdaId(int odaId) {
		this.odaId = odaId;
	}


	public int getOdaYatakSayisi() {
		return odaYatakSayisi;
	}


	public void setOdaYatakSayisi(int odaYatakSayisi) {
		this.odaYatakSayisi = odaYatakSayisi;
	}


	public int getOdaBalkonDurumu() {
		return odaBalkonDurumu;
	}


	public void setOdaBalkonDurumu(int odaBalkonDurumu) {
		this.odaBalkonDurumu = odaBalkonDurumu;
	}


	public Integer getOdaFiyatBilgisi() {
		return odaFiyatBilgisi;
	}


	public void setOdaFiyatBilgisi(Integer odaFiyatBilgisi) {
		this.odaFiyatBilgisi = odaFiyatBilgisi;
	}


	public Integer getOdaGenislik() {
		return odaGenislik;
	}


	public void setOdaGenislik(Integer odaGenislik) {
		this.odaGenislik = odaGenislik;
	}


	public String getOdaKod() {
		return odaKod;
	}


	public void setOdaKod(String odaKod) {
		this.odaKod = odaKod;
	}


	public OdaBean getSecilenOda() {
		return secilenOda;
	}


	public void setSecilenOda(OdaBean secilenOda) {
		this.secilenOda = secilenOda;
	}


	public int getOdaMevcudu() {
		return odaMevcudu;
	}


	public void setOdaMevcudu(int odaMevcudu) {
		this.odaMevcudu = odaMevcudu;
	}


	public void odaListele()
	{
		arananOdaList= OdaCRUD.odaListele(arananOda);
	 
	}
	
	
	public ArrayList<OdaBean> bosOdaListele()
	{
		return OdaCRUD.bosOdaGetir();
	}
	
	
	
	public void odaKaydet()
	{
		OdaBean ogrenci = this;
		boolean valid = OdaCRUD.odaKayit(ogrenci);
		
		if(valid)
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Oda Oluşturuldu."));
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Oda Oluşturulamadı."));
		}
		
	}
}
