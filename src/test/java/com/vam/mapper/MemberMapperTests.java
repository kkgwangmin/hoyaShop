package com.vam.mapper;

import com.vam.model.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : MemberMapperTests
 * date : 2021-10-15
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-15   오후 4:57     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/applicationContext.xml")
public class MemberMapperTests {

	@Autowired
	private MemberMapper memberMapper;

	@Test
	public void memberJoin() throws Exception {
		MemberVO member = new MemberVO();

		member.setMemberId("spring_test1");
		member.setMemberPw("spring_text1");
		member.setMemberName("spring_text1");
		member.setMemberMail("spring_text1");
		member.setMemberAddr1("spring_text1");
		member.setMemberAddr2("spring_text1");
		member.setMemberAddr3("spring_text1");

		memberMapper.memberJoin(member);
	}

}
