package com.deniz.session;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class YonetimSession {
	
	public static HttpSession getSession()
	{
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	
	public static String getYoneticiId()
	{
		HttpSession session = getSession();
		if (session!=null) 
		{
			return session.getAttribute("yoneticiTc").toString();
		}
		else
		{
			return null;
		}
	}
	
	public static void sessionDestroy()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	

}
