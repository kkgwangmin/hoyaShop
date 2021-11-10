package com.vam.service;

import com.vam.model.BookVO;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : AdminService
 * date : 2021-10-18
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-18   오후 6:33     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */
public interface AdminService {

	// 상품 등록
	public void bookEnroll(BookVO book);

}
