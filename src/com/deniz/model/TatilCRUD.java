package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
 import com.deniz.controller.TatilBean;

import oracle.jdbc.OracleTypes;

public class TatilCRUD {
	
	public static boolean izinTalep(TatilBean izin)
	{
		Connection conn=null;
		CallableStatement cs =null;
		try {
			conn= DatabaseConnection.getConnection();
			cs = conn.prepareCall("{call IZINEKLE(?,?,?,?)}");
			cs.setInt(1, izin.getOgrenciId());
			cs.setDate(2, izin.getGidisTarih());
			cs.setDate(3, izin.getDonusTarih());
			cs.setString(4, izin.getIzinAdresi());
			cs.execute();
			return true;
			
			
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return false; }
	}
	
	
	public static ArrayList<TatilBean> izniGecenOgrenciler()
	{
		
		Connection conn=null;
		CallableStatement cs = null;
		try
		{
			conn =DatabaseConnection.getConnection();
			cs=conn.prepareCall("{call IZNIGECENOGRENCI(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs =  (ResultSet) cs.getObject(1);
			
			ArrayList<TatilBean> liste = new  ArrayList<TatilBean>();
			while(rs.next())
			{
				TatilBean ogrenci =new TatilBean();
				
				
				ogrenci.setOgrenciTc(rs.getLong("OGRENCI_TC"));
				ogrenci.setOgrenciId(rs.getInt("OGRENCI_ID"));
				ogrenci.setOgrenciAd(rs.getString("OGRENCI_AD"));
				ogrenci.setOgrenciSoyad(rs.getString("OGRENCI_SOYAD"));
				ogrenci.setOgrenciCepNo(rs.getLong("OGRENCI_CEPNO"));
				ogrenci.setGidisTarih(rs.getDate("GIDIS_TARIH"));
				ogrenci.setDonusTarih(rs.getDate("DONUS_TARIH"));
 		
				liste.add(ogrenci);
			}
			
			conn.close();
			cs.close();
			return liste;
			
			
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return null;}
	}

}
