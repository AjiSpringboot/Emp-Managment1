package com.project;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
 
import jakarta.servlet.http.HttpSession;

@Component
public class Sessiohelper {

	public void removeMassage() {
		
		try {
HttpSession session=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	 session.removeAttribute("msg");	
  
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
