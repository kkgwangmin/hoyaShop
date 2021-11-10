package com.vam.model;

import lombok.Data;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : PageDTO
 * date : 2021-10-18
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-10-18   오후 5:00     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

public class PageDTO {

	/* 페이지 시작 번호, 페이지 끝 번호, 행 전체 개수 */
	private int pageStart, pageEnd, total;

	/* 이전, 다음 버튼 존재 유무 */
	private boolean next, prev;

	/* 현재페이지 번호(pageNum), 행 표시 수(amount), 검색 키워드(keyword), 검색 종류(type) */
	private Criteria cri;

	/* 생성자(클래스 호출 시 각 변수 값 초기화) */
	public PageDTO(Criteria cri, int total) {

		/* cri, total 초기화 */
		this.cri = cri;
		this.total = total;

		/* 페이지 끝 번호 */
		this.pageEnd = (int)(Math.ceil(cri.getPageNum()/10.0))*10;

		/* 페이지 시작 번호 */
		this.pageStart = this.pageEnd - 9;

		/* 전체 마지막 페이지 번호 */
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount()));

		/* 페이지 끝 번호 유효성 체크 */
		if(realEnd < pageEnd) {
			this.pageEnd = realEnd;
		}

		/* 이전 버튼 값 초기화 */
		this.prev = this.pageStart > 1;

		/* 다음 버튼 값 초기화 */
		this.next = this.pageEnd < realEnd;

	}


	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageDTO [pageStart=" + pageStart + ", pageEnd=" + pageEnd + ", next=" + next + ", prev=" + prev
				+ ", total=" + total + ", cri=" + cri + "]";
	}

}

