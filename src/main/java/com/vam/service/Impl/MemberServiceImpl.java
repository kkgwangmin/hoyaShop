package com.vam.service.Impl;

import com.vam.mapper.MemberMapper;
import com.vam.model.MemberVO;
import com.vam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : MemberServiceImpl
 * date : 2021-10-15
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-15   오후 5:50     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public void memberJoin(MemberVO member) throws Exception {

		memberMapper.memberJoin(member);

	}

	@Override
	public int memberIdChk(String memberId) throws Exception {

		return memberMapper.memberIdChk(memberId);
	}

	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		return memberMapper.memberLogin(member);
	}
}
