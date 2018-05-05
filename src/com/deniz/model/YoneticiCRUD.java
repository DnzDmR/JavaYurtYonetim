package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import com.deniz.connection.DatabaseConnection;

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
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(3);
			
			if(rs.next())
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
			
		}catch(Exception e) {System.out.println("hata-->>>> "+e.getMessage()); return "hata"; }
		
 	}
	 

}
