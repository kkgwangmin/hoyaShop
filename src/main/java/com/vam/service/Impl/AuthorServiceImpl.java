package com.vam.service.Impl;

import com.vam.mapper.AuthorMapper;
import com.vam.model.AuthorVO;
import com.vam.model.Criteria;
import com.vam.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : AuthorServiceImpl
 * date : 2021-10-18
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-18   오후 3:47     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Service
public class AuthorServiceImpl implements AuthorService {

	private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

	@Autowired
	AuthorMapper authorMapper;

	// 작가 등록
	@Override
	public void authorEnroll(AuthorVO author) throws Exception{
		authorMapper.authorEnroll(author);
	}

	// 작가 목록
	@Override
	public List<AuthorVO> authorGetList(Criteria cri) throws Exception {

		log.info("(service)authorGetList()........." + cri);

		return authorMapper.authorGetList(cri);
	}

	// 작가 총 수
	@Override
	public int authorGetTotal(Criteria cri) throws Exception {
		log.info("(service)authorGetTotal()......." + cri);
		return authorMapper.authorGetTotal(cri);
	}

	// 작가 상세페이지
	@Override
	public AuthorVO authorGetDetail(int authorId) {
		return authorMapper.authorGetDetail(authorId);
	}

	// 작가 정보 수정
	@Override
	public int authorModify(AuthorVO author) throws Exception {
		log.info("(service) authorModify........." + author);
		return authorMapper.authorModify(author);
	}
}
