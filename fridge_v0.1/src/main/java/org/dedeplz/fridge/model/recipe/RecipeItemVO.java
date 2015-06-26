package org.dedeplz.fridge.model.recipe;

public class RecipeItemVO {
	private int foodReserves;
	private int itemNo;
	private int recipeNo;
	public RecipeItemVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecipeItemVO(int foodReserves, int itemNo, int recipeNo) {
		super();
		this.foodReserves = foodReserves;
		this.itemNo = itemNo;
		this.recipeNo = recipeNo;
	}
	public int getFoodReserves() {
		return foodReserves;
	}
	public void setFoodReserves(int foodReserves) {
		this.foodReserves = foodReserves;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	@Override
	public String toString() {
		return "RecipeItemVO [foodReserves=" + foodReserves + ", itemNo="
				+ itemNo + ", recipeNo=" + recipeNo + "]";
	}
}
