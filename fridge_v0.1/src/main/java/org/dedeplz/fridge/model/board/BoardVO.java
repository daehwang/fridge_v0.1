package org.dedeplz.fridge.model.board;

public class BoardVO {
	private int boardNo;
	private String category;
	private String title;
	private String contents;
	private String postDate;
	private String nick;
	private int hits;
	private String memberId;
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVO(int boardNo, String category, String title, String contents,
			String postDate, String nick, int hits, String memberId) {
		super();
		this.boardNo = boardNo;
		this.category = category;
		this.title = title;
		this.contents = contents;
		this.postDate = postDate;
		this.nick = nick;
		this.hits = hits;
		this.memberId = memberId;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
		return "BoardVO [boardNo=" + boardNo + ", category=" + category
				+ ", title=" + title + ", contents=" + contents + ", postDate="
				+ postDate + ", nick=" + nick + ", hits=" + hits
				+ ", memberId=" + memberId + "]";
	}

}
