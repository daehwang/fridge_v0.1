package org.dedeplz.fridge.model.recipe;

public class RecipeVO {
	private int recipeNo;
	private String title;
	private String contents;
	private String postDate;
	private String nick;
	private int cookingTime;
	private int hits;
	private String memberId;
	public RecipeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecipeVO(int recipeNo, String title, String contents,
			String postDate, String nick, int cookingTime, int hits,
			String memberId) {
		super();
		this.recipeNo = recipeNo;
		this.title = title;
		this.contents = contents;
		this.postDate = postDate;
		this.nick = nick;
		this.cookingTime = cookingTime;
		this.hits = hits;
		this.memberId = memberId;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "RecipeVO [recipeNo=" + recipeNo + ", title=" + title
				+ ", contents=" + contents + ", postDate=" + postDate
				+ ", nick=" + nick + ", cookingTime=" + cookingTime + ", hits="
				+ hits + ", memberId=" + memberId + "]";
	}
	
}
