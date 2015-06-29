package org.dedeplz.fridge.model.board;
/**
 * 이미지 파일 Value Object
 * @author KOSTA
 *
 */
public class FileVO {
	private int fileNo;
	private String filePath;
	private String fileName;
	private int boardNo;
	public FileVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileVO(int fileNo, String filePath, String fileName, int boardNo) {
		super();
		this.fileNo = fileNo;
		this.filePath = filePath;
		this.fileName = fileName;
		this.boardNo = boardNo;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	@Override
	public String toString() {
		return "FileVO [fileNo=" + fileNo + ", filePath=" + filePath
				+ ", fileName=" + fileName + ", boardNo=" + boardNo + "]";
	}

	
}