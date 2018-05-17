package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.OdaBean;
import com.deniz.controller.YoneticiBean;
import com.deniz.session.YonetimSession;

import oracle.jdbc.OracleTypes;

public class YoneticiCRUD {

	public static String yoneticiGiris(Long yoneticiTc,String yoneticiSifre) 
	{
		Connection conn=null;
		CallableStatement cs=null;
		try {
			conn =DatabaseConnection.getConnection();
			cs=conn.prepareCall("{call YONETICIGIRIS(?,?,?)}");
			cs.setLong(1, yoneticiTc);
			cs.setString(2, yoneticiSifre);
			cs.registerOutParameter(3, OracleTypes.INTEGER);
			cs.executeQuery();
			int adet =(int) cs.getObject(3);
			
			if(adet>0)
			{
				cs.close();
				conn.close();
				return "var";
			}
			else
			{
				cs.close();
				conn.close();
				return "yok";
			}
			
		}catch(Exception e) {System.out.println("hata-->>>> "+e.getMessage()); e.printStackTrace(); return "hata"; }
		
 	}
	
	
	public static boolean yoneticiKaydet(YoneticiBean yonetici)
	{
		Connection conn=null;
		CallableStatement cs =null;
		
		try {
			conn = DatabaseConnection.getConnection();
			cs = conn.prepareCall("{call YONETICIEKLE(?,?,?,?,?,?,?,?,?,?)}");
			cs.setLong(1,yonetici.getYoneticiTc());
			cs.setString(2, yonetici.getYoneticiAd());
			cs.setString(3, yonetici.getYoneticiSoyad());
			cs.setString(4, yonetici.getYoneticiAdres());
			cs.setDate(5, yonetici.getYoneticiDogumTarihi());
			cs.setLong(6,yonetici.getYoneticiCepNo());
			cs.setString(7, yonetici.getYoneticiSifre());
			cs.setInt(8, yonetici.getYoneticiYetki());
			cs.setInt(9, yonetici.getYoneticiBirimId());
			cs.registerOutParameter(10, OracleTypes.INTEGER);
			cs.executeQuery();
			
			int sorguSonuc =(int) cs.getObject(10);
			if(sorguSonuc==0)
			{
				conn.close();
				cs.close();
				return false;
			}
			
			return true;
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return false;}
	}
	
	public static ArrayList<YoneticiBean> birimListele()
	{
		Connection conn =null;
		CallableStatement cs = null;
		
		try {
			conn =DatabaseConnection.getConnection();
			cs = conn.prepareCall("{call BIRIMCEK(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs =(ResultSet) cs.getObject(1);
			
			ArrayList<YoneticiBean> liste = new ArrayList<YoneticiBean>();
			
			while(rs.next())
			{
				YoneticiBean yonetici = new YoneticiBean();
				yonetici.setYoneticiBirimId(rs.getInt("BIRIM_ID"));
				yonetici.setYoneticiBirimAd(rs.getString("BIRIM_AD"));
				yonetici.setYoneticiBirimMaas(rs.getInt("BIRIM_MAAS"));
				liste.add(yonetici);
			}
			
			conn.close();
			cs.close();
			return liste;
			
			
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return null;}
	}
	
	
	public static ArrayList<YoneticiBean> yoneticiArama(String arananDeger)
	{
		Connection conn =null;
		CallableStatement cs =null;
		try {
				conn=DatabaseConnection.getConnection();
				cs=conn.prepareCall("{call YONETICIARAMA(?,?)}");
				cs.setString(1, arananDeger);
				cs.registerOutParameter(2, OracleTypes.CURSOR);
				cs.executeQuery();
				ResultSet rs = (ResultSet) cs.getObject(2);


				
				ArrayList<YoneticiBean> liste = new ArrayList<YoneticiBean>();
				while(rs.next())
				{
					YoneticiBean yonetici = new YoneticiBean();
					yonetici.setYoneticiAd(rs.getString("YONETICI_AD"));
					yonetici.setYoneticiSoyad(rs.getString("YONETICI_SOYAD"));
					yonetici.setYoneticiTc(rs.getLong("YONETICI_TC"));
					yonetici.setYoneticiAdres(rs.getString("YONETICI_ADRES"));
					yonetici.setYoneticiId(rs.getInt("YONETICI_ID"));
					yonetici.setYoneticiDogumTarihi(rs.getDate("YONETICI_DOGUM_TARIHI"));
					yonetici.setYoneticiCepNo(rs.getLong("YONETICI_CEPNO"));
					yonetici.setYoneticiSifre(rs.getString("YONETICI_SIFRE"));
					yonetici.setYoneticiYetki(rs.getInt("YONETICI_YETKI"));
					yonetici.setYoneticiBirimId(rs.getInt("BIRIM_ID"));
					yonetici.setYoneticiBirimAd(rs.getString("BIRIM_AD"));
					yonetici.setYoneticiBirimMaas(rs.getInt("BIRIM_MAAS"));

					liste.add(yonetici);
				}
				conn.close();
				cs.close();
				return liste;
				
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return null;}
		
	}
	
	
	public static boolean sifreGuncelle(Long yoneticiTc,String yoneticiSifre)
	{
		Connection conn =null;
		CallableStatement cs =null;
		try {
			conn = DatabaseConnection.getConnection();
			cs=conn.prepareCall("{call SIFREGUNCELLE(?,?)}");
			cs.setLong(1, yoneticiTc);
			cs.setString(2, yoneticiSifre);
			cs.executeQuery();
			
			cs.close();
			conn.close();
			return true;
		}catch(Exception e) {System.out.println("hata-->"+e.getMessage()); e.printStackTrace(); return false;}
	}
	
	public static YoneticiBean yoneticiCek(Long yoneticiTc)
	{
		Connection conn =null;
		CallableStatement cs =null;
		try {
				conn = DatabaseConnection.getConnection();
				cs= conn.prepareCall("{call YONETICICEK(?,?)}");
				cs.setLong(1,yoneticiTc);
				cs.registerOutParameter(2, OracleTypes.CURSOR);
				cs.executeQuery();
				ResultSet rs = (ResultSet) cs.getObject(2);
				YoneticiBean yonetici = new YoneticiBean();
				
				if(rs.next())
				{
					yonetici.setYoneticiAd(rs.getString("YONETICI_AD"));
					yonetici.setYoneticiSoyad(rs.getString("YONETICI_SOYAD"));
					yonetici.setYoneticiTc(rs.getLong("YONETICI_TC"));
					yonetici.setYoneticiAdres(rs.getString("YONETICI_ADRES"));
					yonetici.setYoneticiId(rs.getInt("YONETICI_ID"));
					yonetici.setYoneticiDogumTarihi(rs.getDate("YONETICI_DOGUM_TARIHI"));
					yonetici.setYoneticiCepNo(rs.getLong("YONETICI_CEPNO"));
					yonetici.setYoneticiSifre(rs.getString("YONETICI_SIFRE"));
					yonetici.setYoneticiYetki(rs.getInt("YONETICI_YETKI"));
					yonetici.setYoneticiBirimId(rs.getInt("BIRIM_ID"));
					yonetici.setYoneticiBirimAd(rs.getString("BIRIM_AD"));
					yonetici.setYoneticiBirimMaas(rs.getInt("BIRIM_MAAS"));
				}
					
				cs.close();
				conn.close();
				
			return yonetici;
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace();return null; }
	}
	
	
	public static boolean yoneticiGuncelle(YoneticiBean yonetici)
	{
		Connection conn =null;
		CallableStatement cs = null;
		try
		{
			conn = DatabaseConnection.getConnection();
			cs=conn.prepareCall("{call YONETICIGUNCELLE(?,?,?,?,?,?,?,?,?,?)}");
			cs.setLong(1, yonetici.getYoneticiTc());
			cs.setString(2, yonetici.getYoneticiAd());
			cs.setString(3, yonetici.getYoneticiSoyad());
			cs.setString(4, yonetici.getYoneticiAdres());
			cs.setDate(5, yonetici.getYoneticiDogumTarihi());
			cs.setLong(6, yonetici.getYoneticiCepNo());
			cs.setString(7, yonetici.getYoneticiSifre());
			cs.setInt(8, yonetici.getYoneticiYetki());
			cs.setInt(9, yonetici.getYoneticiBirimId());
			cs.setInt(10,yonetici.getYoneticiId());
			cs.execute();
			
			cs.close();
			conn.close();
			
			return true;
		}catch(Exception e) {System.out.println("hata-->"+e.getMessage()); e.printStackTrace(); return false;}
	}
	
	 

}
