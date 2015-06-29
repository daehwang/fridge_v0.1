package org.dedeplz.fridge.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dedeplz.fridge.model.member.MemberVO;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.WebContentInterceptor;


public class LoginCheckInterceptor extends WebContentInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {
		//@CheckLogin 어노테이션이 컨트롤러에 사용되었는지 체크함
		 LoginCheck usingAuth = ((HandlerMethod) handler).getMethodAnnotation(LoginCheck.class);
		//@LoginCheck가 있으므로 무조건 로그인 체크
		 if(usingAuth != null){
			 //로그인 체크
			 HttpSession session = request.getSession();
			 MemberVO vo = (MemberVO)session.getAttribute("mvo");
			 if(vo==null){
				 try{
				 response.sendRedirect("loginCheck.do");
				 return false;
				 }catch(IOException e){
					 e.printStackTrace();
				 }
			 }
		 }else{
			 //LoginCheck가 없으므로 로그인 체크 하지 않음
		 }
		return true;
	}


	

}
