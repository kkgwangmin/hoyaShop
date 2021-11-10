package com.vam.mapper;

import com.vam.model.BookVO;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : AdminMapper
 * date : 2021-10-18
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-18   오후 6:31     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */
public interface AdminMapper {

	// 상품 등록
	void bookEnroll(BookVO book);

}
