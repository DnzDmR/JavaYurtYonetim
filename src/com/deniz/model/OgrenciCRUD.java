package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.OgrenciBean;

public class OgrenciCRUD {
	
	public static boolean ogrenciKayit(OgrenciBean ogrenci)
	{
		Connection conn=null;
		CallableStatement cs=null;
		
		try
		{
		conn = DatabaseConnection.getConnection();
		cs = conn.prepareCall("{call OGRENCIEKLE(?,?,?,?,?,?,?,?,?,?,?)}");
		cs.setInt(1, ogrenci.getOgrenciOdaNo());
		cs.setLong(2, ogrenci.getOgrenciTc());
		cs.setString(3, ogrenci.getOgrenciAd());
		cs.setString(4, ogrenci.getOgrenciSoyad());
		cs.setString(5, ogrenci.getOgrenciAdres());
		cs.setDate(6, ogrenci.getOgrenciDogumTarihi());
		cs.setLong(7, ogrenci.getOgrenciCepNo());
		cs.setString(8, ogrenci.getOgrenciVeliAd());
		cs.setLong(9, ogrenci.getOgrenciVeliCepNo());
		cs.setInt(10, ogrenci.getOgrenciSinif());
		cs.setInt(11, ogrenci.getSecilenBolumId());
		cs.executeQuery();	
		conn.close();
		cs.close();
		return true;
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return false;}
		
	}
	

}
