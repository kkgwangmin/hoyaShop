package com.vam.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : Criteria
 * date : 2021-10-18
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-18   오후 4:37     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Getter
@Setter
public class Criteria {

	/* 현재 페이지 번호 */
	private int pageNum;

	/* 페이지 표시 개수 */
	private int amount;

	/* 검색 타입 */
	private String type;

	/* 검색 키워드 */
	private String keyword;

	/* Criteria 생성자 */
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	/* Criteria 기본 생성자 */
	public Criteria(){
		this(1,10);
	}

	/* 검색 타입 데이터 배열 변환 */
	public String[] getTypeArr() {
		return type == null? new String[] {}:type.split("");
	}

}
