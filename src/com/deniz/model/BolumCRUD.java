package com.deniz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.BolumBean;


public class BolumCRUD {

	
	public static ArrayList<BolumBean> bolumCek(int fakulteId)
	{
 
		Connection conn =null;
		PreparedStatement ps =null;
		
		try {
				conn=DatabaseConnection.getConnection();
				ps=conn.prepareStatement("Select * from YP_BOLUM where FAKULTE_ID=?");
				ps.setInt(1, fakulteId);
				ResultSet rs = ps.executeQuery(); 
				
				ArrayList<BolumBean> liste = new ArrayList<BolumBean>();
				while(rs.next())
				{
					BolumBean bolum = new BolumBean();
					bolum.setBolumAd(rs.getString("BOLUM_AD"));
					bolum.setBolumId(rs.getInt("BOLUM_ID"));
					bolum.setDonemSayisi(rs.getInt("YIL_SAYISI"));
					bolum.setFakulteId(rs.getInt("FAKULTE_ID"));
					liste.add(bolum);
				}
				conn.close();
				ps.close();
				return liste;
				
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return null;}
	}

	
	
	
	
	
	

	
}
