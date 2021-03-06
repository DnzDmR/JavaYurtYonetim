package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.OgrenciBean;

import oracle.jdbc.OracleTypes;

public class OgrenciCRUD {
	
	public static boolean ogrenciKayit(OgrenciBean ogrenci)
	{
		Connection conn=null;
		CallableStatement cs=null;
		
		try
		{
		conn = DatabaseConnection.getConnection();
		cs = conn.prepareCall("{call OGRENCIEKLE(?,?,?,?,?,?,?,?,?,?,?)}");
		cs.setLong(1, ogrenci.getOgrenciTc());
		cs.setString(2, ogrenci.getOgrenciAd());
		cs.setString(3, ogrenci.getOgrenciSoyad());
		cs.setString(4, ogrenci.getOgrenciAdres());
		cs.setDate(5, ogrenci.getOgrenciDogumTarihi());
		cs.setLong(6, ogrenci.getOgrenciCepNo());
		cs.setString(7, ogrenci.getOgrenciVeliAd());
		cs.setLong(8, ogrenci.getOgrenciVeliCepNo());
		cs.setInt(9, ogrenci.getOgrenciSinif());
		cs.setInt(10, ogrenci.getSecilenBolumId());
		cs.registerOutParameter(11, OracleTypes.INTEGER);
		cs.executeQuery();
		
		int sorguSonuc =(int) cs.getObject(11);
		if(sorguSonuc==0)
		{
			conn.close();
			cs.close();
			return false;
		} 
		
		conn.close();
		cs.close();
		return true;
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return false;}
		
	}
	
	
	public static ArrayList<OgrenciBean> kayitBekleyenOgrenciler()
	{
		Connection conn =null;
		CallableStatement cs=null;
		try
		{
			conn = DatabaseConnection.getConnection();
			cs = conn.prepareCall("{call BEKLEYENOGRENCI(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(1);
			ArrayList<OgrenciBean> liste =new ArrayList<OgrenciBean>();
			
			while(rs.next())
			{
				OgrenciBean ogrenci = new OgrenciBean();
				ogrenci.setOgrenciAd(rs.getString("OGRENCI_AD"));
				ogrenci.setOgrenciId(rs.getInt("OGRENCI_ID"));
				ogrenci.setOgrenciTc(rs.getLong("OGRENCI_TC"));
				ogrenci.setOgrenciSoyad(rs.getString("OGRENCI_SOYAD"));
				ogrenci.setOgrenciAdres(rs.getString("OGRENCI_ADRES"));
				ogrenci.setOgrenciDogumTarihi(rs.getDate("OGRENCI_DOGUM_TARIHI"));
				ogrenci.setOgrenciCepNo(rs.getLong("OGRENCI_CEPNO"));
				ogrenci.setOgrenciVeliAd(rs.getString("OGRENCI_VELI_AD"));
				ogrenci.setOgrenciVeliCepNo(rs.getLong("OGRENCI_VELI_CEPNO"));
				ogrenci.setOgrenciSinif(rs.getInt("OGRENCI_SINIF"));
				ogrenci.setOgrenciBolumId(rs.getInt("BOLUM_ID"));
				ogrenci.setOgrenciKayitDurum(rs.getInt("KAYIT_DURUM"));
				liste.add(ogrenci);
			}
			
				conn.close();
				cs.close();
				return liste;
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return null;}
		
	}
	
	
	
	
	public static boolean ogrenciOdaKayit(Integer ogrenciId, Integer ogrenciOdaNo)
	{
		Connection conn;
		CallableStatement cs;
		
		try {
			conn =DatabaseConnection.getConnection();
			cs =conn.prepareCall("{call OGRENCIODAKAYIT(?,?)}");
			cs.setInt(1, ogrenciOdaNo);
			cs.setInt(2, ogrenciId);
			cs.executeQuery();
			
			cs.close();
			conn.close();
			return true;
			
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return false;}
	}
	
	
	
	public static ArrayList<OgrenciBean> ogrenciArama(String arananOgrenciAdi)
	{
		Connection conn =null;
		CallableStatement cs=null;
		try {
			
			conn=DatabaseConnection.getConnection();
			cs =conn.prepareCall("call OGRENCIARAMA(?,?)");
			cs.setString(1, arananOgrenciAdi.toLowerCase());
			cs.registerOutParameter(2, OracleTypes.CURSOR);

			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(2);
			
			ArrayList<OgrenciBean>  liste = new ArrayList<OgrenciBean> ();
			
			while(rs.next())
			{
				OgrenciBean ogrenci  = new OgrenciBean();
				 
				ogrenci.setOgrenciId(rs.getInt("OGRENCI_ID"));
				ogrenci.setOgrenciTc(rs.getLong("OGRENCI_TC"));
				ogrenci.setOgrenciAd(rs.getString("OGRENCI_AD"));
				ogrenci.setOgrenciSoyad(rs.getString("OGRENCI_SOYAD"));
				ogrenci.setOgrenciAdres(rs.getString("OGRENCI_ADRES"));
				ogrenci.setOgrenciDogumTarihi(rs.getDate("OGRENCI_DOGUM_TARIHI"));
				ogrenci.setOgrenciCepNo(rs.getLong("OGRENCI_CEPNO"));
				ogrenci.setOgrenciVeliAd(rs.getString("OGRENCI_VELI_AD"));
				ogrenci.setOgrenciVeliCepNo(rs.getLong("OGRENCI_VELI_CEPNO"));
				ogrenci.setOgrenciSinif(rs.getInt("OGRENCI_SINIF"));
				ogrenci.setOgrenciKayitDurum(rs.getInt("KAYIT_DURUM"));
				ogrenci.setOgrenciOdaNo(rs.getInt("ODA_ID"));
				ogrenci.setOgrenciFakulteAd(rs.getString("FAKULTE_AD"));
				ogrenci.setOgrenciBolumAd(rs.getString("BOLUM_AD"));
				ogrenci.setOgrenciUniversiteAd(rs.getString("UNIVERSITE_AD"));
				
				
				
				liste.add(ogrenci);
			}
			
			cs.close();
			conn.close();
			
			return liste;
			
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return null;}
	}
	
	
	
	public static OgrenciBean ogrenciCek(int ogrenciId)
	{
		Connection conn=null;
		CallableStatement cs =null;
		try{
			conn =DatabaseConnection.getConnection();
			cs=conn.prepareCall("{call OGRENCICEK(?,?)}");
			cs.setInt(1, ogrenciId);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(2);
			OgrenciBean ogrenci = new OgrenciBean();
			
			if(rs.next())
			{
				ogrenci.setOgrenciId(rs.getInt("OGRENCI_ID"));
				ogrenci.setOgrenciTc(rs.getLong("OGRENCI_TC"));
				ogrenci.setOgrenciAd(rs.getString("OGRENCI_AD"));
				ogrenci.setOgrenciSoyad(rs.getString("OGRENCI_SOYAD"));
				ogrenci.setOgrenciAdres(rs.getString("OGRENCI_ADRES"));
				ogrenci.setOgrenciDogumTarihi(rs.getDate("OGRENCI_DOGUM_TARIHI"));
				ogrenci.setOgrenciCepNo(rs.getLong("OGRENCI_CEPNO"));
				ogrenci.setOgrenciVeliAd(rs.getString("OGRENCI_VELI_AD"));
				ogrenci.setOgrenciVeliCepNo(rs.getLong("OGRENCI_VELI_CEPNO"));
				ogrenci.setOgrenciSinif(rs.getInt("OGRENCI_SINIF"));
				ogrenci.setOgrenciKayitDurum(rs.getInt("KAYIT_DURUM"));
				ogrenci.setOgrenciOdaNo(rs.getInt("ODA_ID"));
				ogrenci.setOgrenciBolumId(rs.getInt("BOLUM_ID"));
				ogrenci.setOgrenciOdeme(rs.getInt("FIYAT_BILGISI"));
			 
			}
			
				conn.close();
				cs.close();
				
				return ogrenci;
				
			}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return null;}
	}
	
	
	public static boolean ogrenciGuncelle(OgrenciBean ogrenci)
	{
		Connection conn =null;
		CallableStatement cs =null;
		
		try {
			conn = DatabaseConnection.getConnection();
			cs = conn.prepareCall("{call OGRENCIGUNCELLE(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, ogrenci.getOgrenciId());
			cs.setLong(2, ogrenci.getOgrenciTc());
			cs.setString(3, ogrenci.getOgrenciAd());
			cs.setString(4, ogrenci.getOgrenciSoyad());
			cs.setString(5, ogrenci.getOgrenciAdres());
			cs.setDate(6, ogrenci.getOgrenciDogumTarihi());
			cs.setLong(7, ogrenci.getOgrenciCepNo());
			cs.setString(8, ogrenci.getOgrenciVeliAd());
			cs.setLong(9,ogrenci.getOgrenciVeliCepNo());
			cs.setInt(10, ogrenci.getOgrenciSinif());
			cs.setInt(11, ogrenci.getOgrenciBolumId());
			cs.setInt(12, ogrenci.getOgrenciKayitDurum());
			cs.setInt(13, ogrenci.getOgrenciOdaNo());
			
			cs.executeQuery();
			
			cs.close();
			conn.close();
			
			return true;
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return false;}
	}
	
	public static boolean ogrenciSil(int ogrenciId)
	{
		Connection conn=null;
		CallableStatement cs=null;
		
		try {
			conn = DatabaseConnection.getConnection();
			cs = conn.prepareCall("{call OGRENCISIL(?)}");
			cs.setInt(1, ogrenciId);
			cs.execute();
			return true;
			
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return false;}
		
	}
	

}
