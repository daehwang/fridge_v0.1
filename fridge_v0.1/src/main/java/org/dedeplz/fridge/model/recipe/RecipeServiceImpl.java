package org.dedeplz.fridge.model.recipe;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.Resource;

import org.dedeplz.fridge.model.recipe.paging.FavoriteListVO;
import org.dedeplz.fridge.model.recipe.paging.ListVO;
import org.dedeplz.fridge.model.recipe.paging.PagingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Resource(name="recipeDAOImpl")
	private RecipeDAO recipeDAO;
	@Resource(name="uploadPath")
	private String path;
	/**
	 * 태그를 이용한 레시피 검색
	 */
	@Override
	public List<String> getRecipeNoByItem(String items) {
		StringTokenizer st = new StringTokenizer(items,"#"); 	
		List<String> recipeList=null;
		List<String> firstRecipeList = null;
		List<String> itemList = new ArrayList<String>();
		List<String> searchResult = new ArrayList<String>();
		while (st.hasMoreTokens()){ 
			 String temp = st.nextToken(); 
			 itemList.add(temp.trim());
		 }
		Set<String> set = new LinkedHashSet<String>();
		for (int i = 0; i < itemList.size(); i++) { //아이템 갯수만큼 for
			recipeList = getRecipeNo(itemList.get(i));  //재료하나에 따른 레시피 검색
			if(i==0){
				firstRecipeList=recipeList;
				if(itemList.size()==1){
					System.out.println("하나일때"+recipeList);
					return recipeList;
				}
			}else{
				for (int j = 0; j < firstRecipeList.size(); j++) { // 재료 하나에 의한 레시피 리스트
					for (int j2 = 0; j2 < recipeList.size(); j2++) {						
						if (firstRecipeList.get(j).equals(recipeList.get(j2))) {							
							set.add(recipeList.get(j));							
						}
					}
				}
			}			
		}
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			searchResult.add(it.next());
		}
		
		return searchResult;
	}
	
	
	/**
	 * 아이템 등록(아이템 네임 중복 확인)
	 * @param itemName
	 */
	public void itemUpdate(String itemName){
		int no=recipeDAO.getCountItemNo(itemName);
		if(no==0){
			recipeDAO.insertItem(itemName);
		}	     
	}
	/**
	 * 아이템 이름으로 해당 아이템 번호 받아온다. 
	 */
	@Override
	public int getItemNo(String itemName) {
		int no=recipeDAO.getItemNo(itemName);
		return no;
	}
	/**
	 * 해당 아이템 이름으로	 레시피 정보를 받아온다.
	 */
	public List<String> getRecipeNo(String item){
		return recipeDAO.getRecipeNoByItem(item);
	}
	/**
	 * 레시피 아이템 테이블에 정보 입력
	 */
	@Override
	public void insertRecipeItem(RecipeItemVO rivo) {
		recipeDAO.insertRecipeItem(rivo);		
	}
	/**
	 * 레시피 등록
	 */
	@Override
	@Transactional
	public int registerRecipe(RecipeVO rvo,String items,List<FileVO> fvoList) throws Exception {
			recipeDAO.registerRecipe(rvo);
			String id=rvo.getMemberId();
			insertRecipeItem(rvo,items);
			int recipeNo=rvo.getRecipeNo();
			System.out.println(path);
			String uploadPath=path+id;
			File file=new File(uploadPath);
			System.out.println(file.isDirectory());
			if(!file.exists()){
				file.mkdir();
			}
			insertRecipeFile(rvo,fvoList);
			return recipeNo;
	}
	/**
	 * file 테이블 정보 등록
	 */
	@Override
	@Transactional
	public void insertRecipeFile(RecipeVO rvo,List<FileVO> fvoList){
		for(int i=0;i<fvoList.size();i++){
			FileVO fvo=new FileVO();
			fvo.setFileName(fvoList.get(i).getFileName());
			fvo.setFilePath(fvoList.get(i).getFilePath());
			fvo.setRecipeNo(rvo.getRecipeNo());
			recipeDAO.insertRecipeFile(fvo);
			System.out.println("fileupload ok:"+fvoList.get(i).getFileName());
		}
	}
	/**
	 * 레시피 아이템을 받아와서 테그 형식으로 변환
	 */
	@Override
	public String getItemTag(int recipeNo) {
		List<String> itemNoList=recipeDAO.getItemNoList(recipeNo);
		System.out.println(itemNoList);
		String tag="";
		for(int i=0;i<itemNoList.size();i++){
			int itemNo=Integer.parseInt(itemNoList.get(i));
			String itemName=recipeDAO.getItemNameByItemNo(itemNo);
			tag+="#"+itemName;
		}
		return tag;
	}
	/**
	 * 레시피 번호를 이용 해당 레시피의 모든 사진 path를 받아온다.
	 */
	@Override
	public List<String> getFilePath(int recipeNo) {
		List<String> list=recipeDAO.getFilePath(recipeNo);
		return list;
	}
	/**
	 * 레시피 번호를 이용해서 해당 레시피의 모든 정보 삭제(레시피 테이블, 레시피 아이템 테이블, 파일 테이블,추천테이블)
	 */
	@Override
	@Transactional
	public void deleteRecipeAll(int recipeNo) {
		int GnBResult=recipeDAO.getGoodAndBadNoCountByRecipeNo(recipeNo);
		recipeDAO.deleteRecipeFile(recipeNo);
		recipeDAO.deleteRecipeItem(recipeNo);
		if(GnBResult!=0){
			recipeDAO.deleteGoodAndBad(recipeNo);
		}
		recipeDAO.deleteRecipe(recipeNo);
	}
	/**
	 * 등록된 모든 레시피의 번호를 받아온다.
	 */
	@Override
	public List<String> getAllRecipeNo() {
		return recipeDAO.getAllRecipeNo();
	}
	/**
	 * 레시피 번호를 이용 해당 레시피의 마지막 사진의 파일 번호를 받아온다.
	 */
	@Override
	public String getFileLastNo(String recipeNo) {
		return recipeDAO.getFileLastNo(recipeNo);
	}
	/**
	 * 파일 번호를 이용 해당 레시피의 사진 path를 받아온다.
	 */
	@Override
	public String getFileLastNamePath(String fileLastNo) {
		return recipeDAO.getFileLastNamePath(fileLastNo);
	}
	/**
	 * 사진의 path를 이용해 해당 레시피의 번호를 받아온다.
	 */
	@Override
	public int getRecipeNoByPath(String filePath) {
		return recipeDAO.getRecipeNoByPath(filePath);
	}
	/**
	 * 레시피 번호로 해당 레시피의 모든 사진 path를 받아온다. 
	 */
	@Override
	public List<String> getAllFilePahtByRecipeNo(int recipeNo) {
		return recipeDAO.getAllFilePahtByRecipeNo(recipeNo);
	}
	/**
	 * 레시피 번호를 이용해 해당 레시피의 모든 사진 이름을 받아온다.
	 */
	@Override
	public List<String> getFileName(int recipeNo) {
		List<String> list=recipeDAO.getFileName(recipeNo);
		return list;
	}
	/**
	 * 레시피 수정
	 */
	@Override
	public void updateRecipe(RecipeVO rvo) {
		deleteRecipeFile(rvo.getRecipeNo());
	    deleteRecipeItem(rvo.getRecipeNo());
		recipeDAO.updateRecipe(rvo);
	}
	/**
	 * 레시피 수정 시 해당 레시피의 기존 recipe_file 테이블 정보 삭제
	 */
	@Override
	public void deleteRecipeFile(int recipeNo) {
		recipeDAO.deleteRecipeFile(recipeNo);
	}
	/**
	 * 레시피 수정 시 해당 레시피의 기존 recipe_item 테이블 정보 삭제
	 */
	@Override
	public void deleteRecipeItem(int recipeNo) {
		recipeDAO.deleteRecipeItem(recipeNo);
		
	}
	/**
	 * 태크 값을 이용해서 recipe_item 테이블에 정보 입력
	 */
	@Override
	@Transactional
	public void insertRecipeItem(RecipeVO rvo,String items){
		StringTokenizer st = new StringTokenizer(items,"#"); 	
		while (st.hasMoreTokens()){ 
			 RecipeItemVO rivo=new RecipeItemVO();
			 String temp = st.nextToken(); 
			 itemUpdate(temp.trim());
			 int no=getItemNo(temp.trim());
			 System.out.println(no);
			 //레시피 아이템 등록
			 rivo.setItemNo(no);
			 rivo.setRecipeNo(rvo.getRecipeNo());
			 recipeDAO.insertRecipeItem( rivo );
		 }
	}
	/**
	 * 레시피 번호를 이용 해당 레시피의 모든 good 을 조회 후
	 * good
	 */
	@Override
	public int getTotalGood(int recipeNo) {
		return  recipeDAO.getTotalGood(recipeNo);
		
	}
	/**
	 * 레시피 번호를 이용 해당 레시피의 모든 bad 를 조회 후
	 * bad의 총합계산
	 */
	@Override
	public int getTotalBad(int recipeNo) {
		return recipeDAO.getTotalBad(recipeNo);
		
	}
	/**
	 * 레시피의 번호와 레시피 작성자 아이디를 이용
	 * 해당 good값을 얻어온다.
	 */
	@Override
	public int getGood(HashMap<String, Object> map) {
		return recipeDAO.getGood(map);
	}
	/**
	 * 레시피의 번호와 레시피 작성자 아이디를 이용
	 * 해당 bad값을 얻어온다.
	 */
	@Override
	public int getBad(HashMap<String, Object> map) {
		return recipeDAO.getBad(map);
	}
	/**
	 * 레시피의 번호와 로그인 아이디를 이용
	 * 추천 비추천 테이블이 존재 유무를 count로 확인
	 */
	@Override
	public int getGoodAndBadNoCountByRecipeNoAndMemberId(HashMap<String, Object> map) {
		return recipeDAO.getGoodAndBadNoCountByRecipeNoAndMemberId(map);
	}
	/**
	 * 추천 버튼 클릭 시 
	 * 추천 비추천 테이블이 없는 경우
	 * 추천 비추천 테이블 생성 
	 * good에 1을 입력
	 */
	@Override
	public void insertGood(HashMap<String, Object> map) {
		recipeDAO.insertGood(map);
	}
	/**
	 * 추천 버튼 클릭 시 이미 추천한 경우
	 * good을 0으로 업데이트
	 */
	@Override
	public void updateCancleGood(HashMap<String, Object> map) {
		recipeDAO.updateCancleGood(map);
	/**
	 * 추천 버튼 클릭 시 
	 * good을 1로 업데이트	
	 */
	}
	@Override
	public void updateUpGood(HashMap<String, Object> map) {
		recipeDAO.updateUpGood(map);
	}
	/**
	 * 비추천 버튼 클릭 시 
	 * 추천 비추천 테이블이 없는 경우
	 * 추천 비추천 테이블 생성
	 * bad에 1을 입력
	 */
	@Override
	public void insertBad(HashMap<String, Object> map) {
		recipeDAO.insertBad(map);
	/**
	 * 비추천 버튼 클릭 시 이미 비추천한 경우
	 * bad을 0으로 업데이트	
	 */
	}
	@Override
	public void updateCancleBad(HashMap<String, Object> map) {
		recipeDAO.updateCancleBad(map);
		
	}
	/**
	 * 비추천 버튼 클릭 시 
	 * bad을 1로 업데이트	 
	 */
	@Override
	public void updateUpBad(HashMap<String, Object> map) {
		recipeDAO.updateUpBad(map);
	}
	
	   /**
	    * 로그인 한 사용자가 레시피를 즐겨찾기 등록
	    */
		@Override
		public String registerFavorite(FavoriteVO fvo) {
			String str = "fail";
			System.out.println("registerFavorites");
			if(getRecipeNoById(fvo) == -1){
				recipeDAO.registerFavorite(fvo);
				str = "ok";
				
			}
			return str;
		}
	   /**
	    * recipeNo 중복 체크 
	    */
	   public int getRecipeNoById(FavoriteVO fvo){
	      int  index = -1;
	      List<Integer> recipeList = recipeDAO.findRecipeNoById(fvo.getMemberId());
	      System.out.println(recipeList);
	      for(int i = 0; i < recipeList.size(); i++){
	         if(fvo.getRecipeNo() == recipeList.get(i)){
	            index = i;
	         }
	      }
	      return index;
	   }
	   @Override
	   public FavoriteListVO getFavoriteRecipeList(String pageNo, String id) {
	      if(pageNo==null||pageNo=="") {
	         pageNo="1";
	      }
	      Map< String, Object> favoriteMap = new HashMap<String, Object>();
	      favoriteMap.put("pageNo", pageNo);
	      favoriteMap.put("id", id);
	      List<FavoriteVO> favoriteList=recipeDAO.getFavoriteRecipeList(favoriteMap);
	      System.out.println(favoriteList);
	      int total=recipeDAO.totalContent();
	      PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
	      FavoriteListVO lvo=new FavoriteListVO(favoriteList,paging);
	      return lvo;
	   }
	   
	   /**
	    * 즐겨찾기 삭제
	    */
	   @Override
	   public void deleteFavorite(FavoriteVO fvo) {
	      recipeDAO.deleteFavorite(fvo);
	   }
	   
	   /**
	    * 레시피 번호를 이용해서 해당 레시피의 정보를 받아온다.
	    */
	   @Override
	   public RecipeVO getRecipeInfo(int recipeNo) {
	      recipeDAO.updateHitsByRecipeNo(recipeNo);
	      RecipeVO rvo=recipeDAO.getRecipeInfo(recipeNo);
	      return rvo;
	   }
	   /**
	    *  (No Hits!!)레시피 번호를 이용해서 해당 레시피의 정보를 받아온다
	    */
	   @Override
	   public RecipeVO getRecipeInfoNoHits(int recipeNo) {
	      RecipeVO rvo=recipeDAO.getRecipeInfo(recipeNo);
	      return rvo;
	   }
	@Override
	public int getFavoriteRecipe(HashMap<String,Object> map) {
		System.out.println(map);
		return recipeDAO.getFavoriteRecipe(map);
	}
}
