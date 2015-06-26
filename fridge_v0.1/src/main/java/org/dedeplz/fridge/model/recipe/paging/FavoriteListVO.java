package org.dedeplz.fridge.model.recipe.paging;

import java.util.List;

import org.dedeplz.fridge.model.recipe.FavoriteVO;
import org.dedeplz.fridge.model.recipe.RecipeVO;
/**
 * 리스트(list.jsp) 화면에서 보여줄 게시물 리스트를 저장하고<br>
 * 페이징 정보 객체를 저장하는 클래스 
 * @author KOSTA-00-KANGSA
 *
 */
public class FavoriteListVO {
   private List<FavoriteVO> list;
   private PagingBean pagingBean;
   public FavoriteListVO() {
      super();      
   }
   public FavoriteListVO(List<FavoriteVO> list, PagingBean pagingBean) {
      super();
      this.list = list;
      this.pagingBean = pagingBean;
   }
   public List<FavoriteVO> getList() {
      return list;
   }
   public void setList(List<FavoriteVO> list) {
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
      return "FavoriteListVO [list=" + list + ", pagingBean=" + pagingBean
            + "]";
   }
   
}