package org.dedeplz.fridge.model.board.paging;

import java.util.List;

import org.dedeplz.fridge.model.board.BoardVO;



/**
 * 리스트(list.jsp) 화면에서 보여줄 게시물 리스트를 저장하고<br>
 * 페이징 정보 객체를 저장하는 클래스 
 * @author KOSTA-00-KANGSA
 *
 */
public class BoardListVO {
	private List<BoardVO> list;
	private PagingBean pagingBean;
	public BoardListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardListVO(List<BoardVO> list, PagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}
	
	public List<BoardVO> getList() {
		return list;
	}
	public void setList(List<BoardVO> list) {
		this.list = list;
	}
	public PagingBean getPagingBean() {
		return pagingBean;
	}
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}
	@Override
	public String toString() {
		return "BoardListVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}

}
