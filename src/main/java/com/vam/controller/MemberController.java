package com.vam.controller;

import com.vam.model.MemberVO;
import com.vam.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : MemberController
 * date : 2021-10-15
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-15   오후 5:47     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	//회원가입 페이지 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void loginGET() {
		logger.info("회원가입 페이지 진입");
	}

	//로그인 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void joinGET() {
		logger.info("로그인 페이지 진입");
	}

	//회원가입
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception{

		String rawPw        = "";       // 인코딩 전 비밀
		String encodePw     = "";       // 인코딩 후 비밀

		rawPw    = member.getMemberPw();    // 비밀번호 데이터 얻음
		encodePw = pwEncoder.encode(rawPw); // 얻어온 데이터를 인코딩
		member.setMemberPw(encodePw);

		// 회원가입 쿼리 ㄱㄱ
		memberService.memberJoin(member);

		return "redirect:/main";

	}

	// 아이디 중복 검사
	@RequestMapping(value = "memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {
		int result = memberService.memberIdChk(memberId);

		if (result != 0) {
			return "fail";
		} else {
			return "sucess";
		}
	}

	// 이메일 인증
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {

		// 뷰(view)로부터 넘어온 데이터 확인
		logger.info("이메일 데이터 전송 확인");
		logger.info("인증번호 : " + email);

		// 인증번호 랜덤값 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		logger.info("인증번호 : " + checkNum);

		// 이메일 보내기 시작
		String setFrom = "ew202002@gmail.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String context =
				"홈페이지를 방문해주셔서 감사합니다." +
				"<br><br>" +
				"인증 번호는 " + "<b>" + checkNum + "</b>" + "입니다." +
				"<br>" +
				"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(context, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);

		return num;
	}

	// 로그인
	@RequestMapping(value="login.do", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception {

		HttpSession session = request.getSession();
		String rawPw = "";
		String encodePw = "";


		MemberVO lvo = memberService.memberLogin(member);

		if(lvo != null) {                                       // 제출한아이디와 일치하는 아이디있는지

			rawPw = member.getMemberPw();                       // 사용자가 제출한 비밀번호
			encodePw = lvo.getMemberPw();                       // 데이터베이스에 저장한 인코딩된 비밀번호

			if(true == pwEncoder.matches(rawPw, encodePw)) {    // 비밀번호 일치 여부 판단
				lvo.setMemberPw("");                            // 인코딩된 비밀번호 정보 지움
				session.setAttribute("member", lvo);     // session에 사용자의 정보 저장
				return "redirect:/main";                        // 메인페이지 이동

			} else {

				rttr.addFlashAttribute("result", 0);
				return "redirect:/member/login";                // 로그인 페이지로 이동
			}
		} else {                                                // 일치하는 아이디가 존재하지 않을 시 (로그인 실패)
			rttr.addFlashAttribute("result", 0);
			return "redirect:/member/login";                    // 로그인 페이지로 이동
		}
	}

	// main logOut
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logOutMainGET(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/main";
	}

	// 비동기 방식 로그아웃
	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	@ResponseBody
	public void logOutPOST(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		session.invalidate();

	}

}
