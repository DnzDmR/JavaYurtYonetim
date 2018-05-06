package com.deniz.controller;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.deniz.model.YurtCRUD;

@ManagedBean
@SessionScoped
public class YurtBean {
	
	@PostConstruct
	public void init() {
		this.yurtCek();
	}
	
	private int yurtId;
	private Long yurtTelefon;
	private String yurtAd;
	private String yurtEposta;
	private String yurtAdres;
	public int getYurtId() {
		return yurtId;
	}
	public void setYurtId(int yurtId) {
		this.yurtId = yurtId;
	}
	public Long getYurtTelefon() {
		return yurtTelefon;
	}
	public void setYurtTelefon(Long yurtTelefon) {
		this.yurtTelefon = yurtTelefon;
	}
	public String getYurtAd() {
		return yurtAd;
	}
	public void setYurtAd(String yurtAd) {
		this.yurtAd = yurtAd;
	}
	public String getYurtEposta() {
		return yurtEposta;
	}
	public void setYurtEposta(String yurtEposta) {
		this.yurtEposta = yurtEposta;
	}
	public String getYurtAdres() {
		return yurtAdres;
	}
	public void setYurtAdres(String yurtAdres) {
		this.yurtAdres = yurtAdres;
	}
	
	
	public void yurtCek()
	{
 		YurtBean yurt =YurtCRUD.yurtCek();
		
		yurtAd =yurt.yurtAd;
		yurtAdres=yurt.yurtAdres;
		yurtId = yurt.yurtId;
		yurtTelefon = yurt.yurtTelefon;
		yurtEposta = yurt.yurtEposta;
		
	}
	
}
