package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.OdaBean;

import oracle.jdbc.OracleTypes;

public class OdaCRUD {
	
	
	public static ArrayList<OdaBean> odaListele()
	{
		Connection conn =null;
		CallableStatement cs =null;
		
		try {
				conn=DatabaseConnection.getConnection();
				cs=conn.prepareCall("{call ODALISTELE(?)}");
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

					liste.add(oda);
				}
				conn.close();
				cs.close();
				return liste;
				
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); return null;}
		
	}

}
