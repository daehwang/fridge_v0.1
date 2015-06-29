package org.dedeplz.fridge.model.recipe;

public class TopRecipeVO {
	private int recipeNo;
	private int totalGood;
	private int totalBad;
	public TopRecipeVO() {
		super();
	}
	public TopRecipeVO(int recipeNo, int totalGood, int totalBad) {
		super();
		this.recipeNo = recipeNo;
		this.totalGood = totalGood;
		this.totalBad = totalBad;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public int getTotalGood() {
		return totalGood;
	}
	public void setTotalGood(int totalGood) {
		this.totalGood = totalGood;
	}
	public int getTotalBad() {
		return totalBad;
	}
	public void setTotalBad(int totalBad) {
		this.totalBad = totalBad;
	}
	@Override
	public String toString() {
		return "TopRecipeVO [recipeNo=" + recipeNo + ", totalGood=" + totalGood
				+ ", totalBad=" + totalBad + "]";
	}
	
}
