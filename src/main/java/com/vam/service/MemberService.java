package com.vam.service;

import com.vam.model.MemberVO;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : MemberService
 * date : 2021-10-15
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-15   오후 5:49     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */
public interface MemberService {

	// 회원가입
	public void memberJoin(MemberVO member) throws Exception;

	// 아이디 중복체크
	int memberIdChk(String memberId) throws Exception;

	// 로그인
	MemberVO memberLogin(MemberVO member) throws Exception;
}
