package com.deniz.controller;


import javax.faces.bean.ManagedBean;



@ManagedBean
public class FakulteBean {
	
	private int fakulteId;
	private int universiteId;
	private String fakulteAd;
	private int secilenFakulteId;
	
	
	
	
	public int getSecilenFakulteId() {
		return secilenFakulteId;
	}
	public void setSecilenFakulteId(int secilenFakulteId) {
		this.secilenFakulteId = secilenFakulteId;
	}
	public int getFakulteId() {
		return fakulteId;
	}
	public void setFakulteId(int fakulteId) {
		this.fakulteId = fakulteId;
	}
	public int getUniversiteId() {
		return universiteId;
	}
	public void setUniversiteId(int universiteId) {
		this.universiteId = universiteId;
	}
	public String getFakulteAd() {
		return fakulteAd;
	}
	public void setFakulteAd(String fakulteAd) {
		this.fakulteAd = fakulteAd;
	}
	

	 
	

}
