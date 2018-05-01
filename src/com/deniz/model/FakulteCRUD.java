package com.deniz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.FakulteBean;


public class FakulteCRUD {
	
 	
	public static ArrayList<FakulteBean> fakulteCek(int universiteId)
	{
 
		Connection conn =null;
		PreparedStatement ps =null;
		
		try {
				conn=DatabaseConnection.getConnection();
				ps=conn.prepareStatement("Select * from YP_FAKULTE where UNIVERSITE_ID=?");
				ps.setInt(1, universiteId);
				ResultSet rs = ps.executeQuery(); 
				
				ArrayList<FakulteBean> liste = new ArrayList<FakulteBean>();
				while(rs.next())
				{
					FakulteBean fakulte = new FakulteBean();
					fakulte.setFakulteAd(rs.getString("FAKULTE_AD"));
					fakulte.setFakulteId(rs.getInt("FAKULTE_ID"));
					fakulte.setUniversiteId(rs.getInt("UNIVERSITE_ID"));
					liste.add(fakulte);
				}
				conn.close();
				ps.close();
				return liste;
				
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return null;}
	}

}
