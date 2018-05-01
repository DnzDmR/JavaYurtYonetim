package com.deniz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.UniversiteBean;

public class UniversiteCRUD {
	
	public static ArrayList<UniversiteBean> universiteCek()
	{
		Connection conn =null;
		PreparedStatement ps =null;
		
		try {
				conn=DatabaseConnection.getConnection();
				ps=conn.prepareStatement("Select * from YP_UNIVERSITE");
				ResultSet rs = ps.executeQuery();
				
				ArrayList<UniversiteBean> liste = new ArrayList<UniversiteBean >();
				while(rs.next())
				{
					UniversiteBean universite = new UniversiteBean();	
					universite.setUniversiteAd(rs.getString("UNIVERSITE_AD"));
					universite.setUniversiteId(rs.getInt("UNIVERSITE_ID"));
					liste.add(universite);
				}
				conn.close();
				ps.close();
				return liste;
				
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return null;}
		
	}

}
