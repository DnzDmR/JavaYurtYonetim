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
	
 
	
	
	
	
	public ArrayList<UniversiteBean> universiteCek()
	{
		return UniversiteCRUD.universiteCek();
	}
	

 

}
