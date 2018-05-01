package com.deniz.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.deniz.model.OdaCRUD;

@ManagedBean
@SessionScoped
public class OdaBean {

	private int odaId;
	private int odaYatakSayisi;
	private int odaBalkonDurumu;
	private int odaFiyatBilgisi;
	private int odaGenislik;
	
	private OdaBean secilenOda;
	
	
	
	public OdaBean getSecilenOda() {
		return secilenOda;
	}
	public void setSecilenOda(OdaBean secilenOda) {
		this.secilenOda = secilenOda;
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
	public int getOdaFiyatBilgisi() {
		return odaFiyatBilgisi;
	}
	public void setOdaFiyatBilgisi(int odaFiyatBilgisi) {
		this.odaFiyatBilgisi = odaFiyatBilgisi;
	}
	public int getOdaGenislik() {
		return odaGenislik;
	}
	public void setOdaGenislik(int odaGenislik) {
		this.odaGenislik = odaGenislik;
	}
	
	
	
	public ArrayList<OdaBean> odaListele()
	{
		ArrayList<OdaBean> a = OdaCRUD.odaListele();
		
		for(OdaBean nesne :a)
		{
			this.odaBalkonDurumu=nesne.odaBalkonDurumu;
			this.odaFiyatBilgisi=nesne.odaFiyatBilgisi;
			this.odaGenislik=nesne.odaGenislik;
			this.odaId=nesne.odaId;
			this.odaYatakSayisi=nesne.odaYatakSayisi;
		}
		
		return OdaCRUD.odaListele();
	}
}
