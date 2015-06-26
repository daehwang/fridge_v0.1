package org.dedeplz.fridge.model.recipe;
/**
 * 이미지 파일 Value Object
 * @author KOSTA
 *
 */
public class FileVO {
	private int fileNo;
	private String filePath;
	private String fileName;
	private int recipeNo;
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public FileVO(int fileNo, String fileName, int recipeNo, String filePath) {
		super();
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.recipeNo = recipeNo;
		this.filePath = filePath;
	}
	public FileVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FileVO [fileNo=" + fileNo + ", filePath=" + filePath
				+ ", fileName=" + fileName + ", recipeNo=" + recipeNo + "]";
	}
	
}