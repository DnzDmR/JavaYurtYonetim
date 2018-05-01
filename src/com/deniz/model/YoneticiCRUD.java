package com.deniz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import com.deniz.connection.DatabaseConnection;

public class YoneticiCRUD {

	public static String yoneticiGiris(Integer yoneticiId,String yoneticiSifre) 
	{
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn =DatabaseConnection.getConnection();
			ps = conn.prepareStatement("Select * from YONETICIGIRIS_V where YONETICI_ID=? and YONETICI_SIFRE=?");
			ps.setInt(1, yoneticiId);
			ps.setString(2, yoneticiSifre);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				ps.close();
				conn.close();
				return "var";
			}
			else
			{
				ps.close();
				conn.close();
				return "yok";
			}
			
		}catch(Exception e) {System.out.println("hata-->>>> "+e.getMessage()); return "hata"; }
		
 	}
	 

}
