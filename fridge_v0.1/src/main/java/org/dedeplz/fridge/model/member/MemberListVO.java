package org.dedeplz.fridge.model.member;


import java.util.List;

/**
 * 게시물 리스트 정보와 페이징 정보를 가지고 있는 클래스 
 * @author inst
 *
 */
public class MemberListVO {
	private List<MemberVO> list;
	private MemberPagingBean pagingBean;
	
	public MemberListVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberListVO(List<MemberVO> list, MemberPagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}

	public List<MemberVO> getList() {
		return list;
	}

	public void setList(List<MemberVO> list) {
		this.list = list;
	}

	public MemberPagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(MemberPagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}
	
}










