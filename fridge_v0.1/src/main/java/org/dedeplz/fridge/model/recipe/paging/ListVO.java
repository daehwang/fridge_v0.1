package org.dedeplz.fridge.model.recipe.paging;

import java.util.List;

import org.dedeplz.fridge.model.recipe.RecipeVO;
/**
 * 리스트(list.jsp) 화면에서 보여줄 게시물 리스트를 저장하고<br>
 * 페이징 정보 객체를 저장하는 클래스 
 * @author KOSTA-00-KANGSA
 *
 */
public class ListVO {
	private List<RecipeVO> list;
	private PagingBean pagingBean;
	public ListVO() {
		super();		
	}
	public ListVO(List<RecipeVO> list, PagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}
	public List<RecipeVO> getList() {
		return list;
	}
	public void setList(List<RecipeVO> list) {
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
		return "ListVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}
	
}
