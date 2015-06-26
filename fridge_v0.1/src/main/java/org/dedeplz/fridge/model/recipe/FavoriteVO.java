package org.dedeplz.fridge.model.recipe;

public class FavoriteVO {
   private int favoriteNo;
   private String memberId;
   private int recipeNo;
   private String insertDate;
   private String recipeTitle;
   
   public FavoriteVO() {
      super();
   }

   public FavoriteVO(int favoriteNo, String memberId, int recipeNo,
         String insertDate, String recipeTitle) {
      super();
      this.favoriteNo = favoriteNo;
      this.memberId = memberId;
      this.recipeNo = recipeNo;
      this.insertDate = insertDate;
      this.recipeTitle = recipeTitle;
   }

   public int getFavoriteNo() {
      return favoriteNo;
   }

   public void setFavoriteNo(int favoriteNo) {
      this.favoriteNo = favoriteNo;
   }

   public String getMemberId() {
      return memberId;
   }

   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }

   public int getRecipeNo() {
      return recipeNo;
   }

   public void setRecipeNo(int recipeNo) {
      this.recipeNo = recipeNo;
   }

   public String getInsertDate() {
      return insertDate;
   }

   public void setInsertDate(String insertDate) {
      this.insertDate = insertDate;
   }

   public String getRecipeTitle() {
      return recipeTitle;
   }

   public void setRecipeTitle(String recipeTitle) {
      this.recipeTitle = recipeTitle;
   }

   @Override
   public String toString() {
      return "FavoriteVO [favoriteNo=" + favoriteNo + ", memberId="
            + memberId + ", recipeNo=" + recipeNo + ", insertDate="
            + insertDate + ", recipeTitle=" + recipeTitle + "]";
   }
}