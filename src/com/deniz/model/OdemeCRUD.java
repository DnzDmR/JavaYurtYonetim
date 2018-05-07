package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.deniz.connection.DatabaseConnection;

public class OdemeCRUD {
	
	public static void ogrenciOdemeYap(int ogrenciId,int yoneticiId)
	{
		Connection conn =null;
		CallableStatement cs = null;
		
		try {
			conn = DatabaseConnection.getConnection();
			cs = conn.prepareCall("{call ODEMEYAP(?,?) }");
			cs.setInt(1, yoneticiId);
			cs.setInt(2, ogrenciId);
			cs.execute();
			
			cs.close();
			conn.close();
			
			
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace();}
	}
	

}
