package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.GirisBean;

import oracle.jdbc.OracleTypes;

public class GirisCRUD {

	public static ArrayList<GirisBean> girisLogCek()
	{
		Connection conn=null;
		CallableStatement cs =null;
		try {
			conn =DatabaseConnection.getConnection();
			cs=conn.prepareCall("call YONETICIGIRISLOGCEK(?)");	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			ArrayList<GirisBean> liste = new ArrayList<GirisBean>();
		
			while(rs.next())
			{
				GirisBean giris = new GirisBean();
				giris.setYoneticiAd(rs.getString("YONETICI_AD"));
				giris.setYoneticiSoyad(rs.getString("YONETICI_SOYAD"));
				giris.setYoneticiTc(rs.getLong("YONETICI_TC"));
				giris.setGirisTarih(rs.getTimestamp("GIRIS_TARIH"));
				liste.add(giris);
			}
			
			cs.close();
			rs.close();
			return liste;
		} catch (Exception e) {System.out.println("hata--->"+e.getMessage()); e.printStackTrace();   return null;}
		
	}

}
