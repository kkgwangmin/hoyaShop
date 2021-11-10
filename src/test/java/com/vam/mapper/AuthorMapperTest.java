package com.vam.mapper;

import com.vam.model.AuthorVO;
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
 * @class : AuthorMapperTest
 * date : 2021-10-18
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-18   오후 3:55     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/applicationContext.xml")
public class AuthorMapperTest {

	@Autowired
	private AuthorMapper mapper;

	// 작가 등록 테스트
	@Test
	public void authorEnroll() throws Exception{

		AuthorVO author = new AuthorVO();

		author.setNationId("62");
		author.setAuthorName("테스트12");
		author.setAuthorIntro("테스트 소개61");

		mapper.authorEnroll(author);

	}
}
