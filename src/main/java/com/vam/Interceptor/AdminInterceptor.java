package com.vam.Interceptor;

import com.vam.model.MemberVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();

		MemberVO lvo = (MemberVO)session.getAttribute("member");

		if(lvo == null || lvo.getAdminCk() == 0 ) { // 관리자가 아닌경우
			response.sendRedirect("/main");

			return false;
		}
		return true;
	}
}
