package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.YurtBean;

import oracle.jdbc.OracleTypes;

public class YurtCRUD {
	
	
	public static YurtBean yurtCek()
	{
		Connection conn=null;
		CallableStatement cs = null;
		try {
				conn = DatabaseConnection.getConnection();
				cs = conn.prepareCall("{call YURTCEK(?)}");
				cs.registerOutParameter(1, OracleTypes.CURSOR);
				cs.executeQuery();
				
				ResultSet rs = (ResultSet) cs.getObject(1);
				YurtBean yurt = new YurtBean();
				if(rs.next())
				{
					yurt.setYurtAd(rs.getString("YURT_AD"));
					yurt.setYurtId(rs.getInt("YURT_ID"));
					yurt.setYurtTelefon(rs.getLong("YURT_TELEFON"));
					yurt.setYurtAdres(rs.getString("YURT_ADRES"));
					yurt.setYurtEposta(rs.getString("YURT_EPOSTA"));
				}
				
				return yurt;
			
		}catch(Exception e) {System.out.println("hata-->"+e.getMessage()); e.printStackTrace(); return null;}
	}


}
