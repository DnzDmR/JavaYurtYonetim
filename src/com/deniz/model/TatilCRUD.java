package com.deniz.model;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.deniz.connection.DatabaseConnection;
import com.deniz.controller.TatilBean;

public class TatilCRUD {
	
	public static boolean izinTalep(TatilBean izin)
	{
		Connection conn=null;
		CallableStatement cs =null;
		try {
			conn= DatabaseConnection.getConnection();
			cs = conn.prepareCall("{call IZINEKLE(?,?,?,?)}");
			cs.setInt(1, izin.getOgrenciId());
			cs.setDate(2, izin.getGidisTarih());
			cs.setDate(3, izin.getDonusTarih());
			cs.setString(4, izin.getIzinAdresi());
			cs.execute();
			return true;
			
			
		}catch(Exception e) {System.out.println("hata->>"+e.getMessage()); e.printStackTrace(); return false; }
	}

}
