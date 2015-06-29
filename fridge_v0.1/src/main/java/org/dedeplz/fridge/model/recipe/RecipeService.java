package org.dedeplz.fridge.model.recipe;


import java.util.HashMap;
import java.util.List;

import org.dedeplz.fridge.model.recipe.paging.FavoriteListVO;

public interface RecipeService {
	public int getItemNo(String itemName);
	public void insertRecipeItem(RecipeItemVO rivo);
	public RecipeVO getRecipeInfo(int recipeNo);
	public int registerRecipe(RecipeVO rvo,String items,List<FileVO> fvoList) throws Exception;
	public String getItemTag(int recipeNo);
	public List<String> getFilePath(int recipeNo);
	public void deleteRecipeAll(int recipeNo);
	public List<String> getAllRecipeNo();
	public String getFileLastNo(String recipeNo);
	public String getFileLastNamePath(String fileLastNo);
	public int getRecipeNoByPath(String filePath);
	public List<String> getAllFilePahtByRecipeNo(int recipeNo);
	public List<String> getFileName(int recipeNo);
	public void updateRecipe(RecipeVO rvo);
	void insertRecipeFile(RecipeVO rvo,List<FileVO> fvoList);
	public void deleteRecipeFile(int recipeNo);
	public void deleteRecipeItem(int recipeNo);
	public void insertRecipeItem(RecipeVO rvo, String items);
	public List<String> getRecipeNoByItem(String items);
	public int getTotalGood(int recipeNo);
	public int getTotalBad(int recipeNo);
	public int getGood(HashMap<String, Object> map);
	public int getBad(HashMap<String, Object> map);
	public int getGoodAndBadNoCountByRecipeNoAndMemberId(HashMap<String, Object> map);
	public void insertGood(HashMap<String, Object> map);
	public void updateCancleGood(HashMap<String, Object> map);
	public void updateUpGood(HashMap<String, Object> map);
	public void insertBad(HashMap<String, Object> map);
	public void updateCancleBad(HashMap<String, Object> map);
	public void updateUpBad(HashMap<String, Object> map);
	
	public String registerFavorite(FavoriteVO fvo);
	public FavoriteListVO getFavoriteRecipeList(String pageNo, String id);
	public void deleteFavorite(FavoriteVO fvo);
	
	public RecipeVO getRecipeInfoNoHits(int recipeNo);
	public int getFavoriteRecipe(HashMap<String,Object> map);
	public List<Integer> getMyRecipeList(String id);
	public List<String> getTopPointRecipeList();
}
