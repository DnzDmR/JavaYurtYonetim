package com.deniz.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.deniz.model.BolumCRUD;
import com.deniz.model.FakulteCRUD;
import com.deniz.model.UniversiteCRUD;

@ManagedBean
@SessionScoped
public class UniversiteBean {
	
	private int universiteId;
	private String universiteAd;
	private int secilenUniversiteId;
	private int secilenFakulteId;
	private int secilenBolumId;
	
	private  ArrayList<FakulteBean> fakulteList;
	private  ArrayList<BolumBean> bolumList;
	
	
	
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
	public int getSecilenUniversiteId() {
		return secilenUniversiteId;
	}
	public void setSecilenUniversiteId(int secilenUniversiteId) {
		this.secilenUniversiteId = secilenUniversiteId;
	}
	public int getUniversiteId() {
		return universiteId;
	}
	public void setUniversiteId(int universiteId) {
		this.universiteId = universiteId;
	}
	public String getUniversiteAd() {
		return universiteAd;
	}
	public void setUniversiteAd(String universiteAd) {
		this.universiteAd = universiteAd;
	}
	
	public int getSecilenFakulteId() {
		return secilenFakulteId;
	}
	public void setSecilenFakulteId(int secilenFakulteId) {
		this.secilenFakulteId = secilenFakulteId;
	}
	
	
	public ArrayList<UniversiteBean> universiteCek()
	{
		return UniversiteCRUD.universiteCek();
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
 

}
