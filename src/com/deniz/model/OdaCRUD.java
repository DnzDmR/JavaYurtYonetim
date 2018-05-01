package com.deniz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.OdaBean;

public class OdaCRUD {
	
	
	public static ArrayList<OdaBean> odaListele()
	{
		Connection conn =null;
		PreparedStatement ps =null;
		
		try {
				conn=DatabaseConnection.getConnection();
				ps=conn.prepareStatement("Select * from YP_ODA_OZELLIK");
				ResultSet rs = ps.executeQuery();  
				
				ArrayList<OdaBean> liste = new ArrayList<OdaBean>();
				while(rs.next())
				{
					OdaBean oda = new OdaBean();
					oda.setOdaBalkonDurumu(rs.getInt("BALKON_DURUMU"));
					oda.setOdaFiyatBilgisi(rs.getInt("FIYAT_BILGISI"));
					oda.setOdaGenislik(rs.getInt("GENISLIK"));
					oda.setOdaYatakSayisi(rs.getInt("YATAK_SAYISI"));
					oda.setOdaId(rs.getInt("ODA_ID"));

					liste.add(oda);
				}
				conn.close();
				ps.close();
				return liste;
				
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return null;}
		
	}

}
