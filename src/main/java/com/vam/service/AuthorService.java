package com.vam.service;

import com.vam.model.AuthorVO;
import com.vam.model.Criteria;

import java.util.List;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : AuthorService
 * date : 2021-10-18
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-18   오후 3:47     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */
public interface AuthorService {

	// 작가 등록
	void authorEnroll(AuthorVO author) throws Exception;

	// 작가 목록
	List<AuthorVO> authorGetList(Criteria cri) throws Exception;

	// 작가 총수
	public int authorGetTotal(Criteria cri) throws Exception;

	// 작가 상세 페이지
	AuthorVO authorGetDetail(int authorId) throws Exception;


	// 작가 정보 수정
	int authorModify(AuthorVO author) throws Exception;


}
