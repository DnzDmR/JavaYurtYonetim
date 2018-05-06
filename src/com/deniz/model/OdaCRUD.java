package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.OdaBean;

import oracle.jdbc.OracleTypes;

public class OdaCRUD {
	
	
	public static ArrayList<OdaBean> odaListele(String arananOda)
	{
		Connection conn =null;
		CallableStatement cs =null;
		
		try {
				conn=DatabaseConnection.getConnection();
				cs=conn.prepareCall("{call ODALISTELE(?,?)}");
				cs.registerOutParameter(1, OracleTypes.CURSOR);
				cs.setString(2, arananOda);
				cs.executeQuery();
				ResultSet rs = (ResultSet) cs.getObject(1);
 
				
				
				ArrayList<OdaBean> liste = new ArrayList<OdaBean>();
				while(rs.next())
				{
					OdaBean oda = new OdaBean();
					oda.setOdaBalkonDurumu(rs.getInt("BALKON_DURUMU"));
					oda.setOdaFiyatBilgisi(rs.getInt("FIYAT_BILGISI"));
					oda.setOdaGenislik(rs.getInt("GENISLIK"));
					oda.setOdaYatakSayisi(rs.getInt("YATAK_SAYISI"));
					oda.setOdaId(rs.getInt("ODA_ID"));
					oda.setOdaMevcudu(rs.getInt("KONTENJAN"));
					oda.setOdaKod(rs.getString("ODA_KOD"));

					liste.add(oda);
				}
				conn.close();
				cs.close();
				return liste;
				
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return null;}
		
	}
	
	public static ArrayList<OdaBean> bosOdaGetir()
	{
		Connection conn=null;
		CallableStatement cs=null;
		
		try {
			conn=DatabaseConnection.getConnection();
			cs=conn.prepareCall("{call BOSODALISTELE(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(1);


			
			ArrayList<OdaBean> liste = new ArrayList<OdaBean>();
			while(rs.next())
			{
				OdaBean oda = new OdaBean();
				oda.setOdaBalkonDurumu(rs.getInt("BALKON_DURUMU"));
				oda.setOdaFiyatBilgisi(rs.getInt("FIYAT_BILGISI"));
				oda.setOdaGenislik(rs.getInt("GENISLIK"));
				oda.setOdaYatakSayisi(rs.getInt("YATAK_SAYISI"));
				oda.setOdaId(rs.getInt("ODA_ID"));
				oda.setOdaMevcudu(rs.getInt("KONTENJAN"));
				oda.setOdaKod(rs.getString("ODA_KOD"));

				liste.add(oda);
			}
			conn.close();
			cs.close();
			return liste;
			
			
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return null;}
		
	}
	
	
	public static boolean odaKayit(OdaBean ogrenci)
	{
		Connection conn =null;
		CallableStatement cs =null;
		try {
			conn = DatabaseConnection.getConnection();
			cs =conn.prepareCall("{call ODAKAYIT(?,?,?,?,?)}");
			cs.setString(1, ogrenci.getOdaKod());
			cs.setInt(2, ogrenci.getOdaYatakSayisi());
			cs.setInt(3, ogrenci.getOdaBalkonDurumu());
			cs.setInt(4, ogrenci.getOdaFiyatBilgisi());
			cs.setInt(5, ogrenci.getOdaGenislik());
			cs.executeQuery();
			
			return true;
		}catch(Exception e) {System.out.println("Hata->>"+e.getMessage()); e.printStackTrace(); return false;}
	}
	

}
