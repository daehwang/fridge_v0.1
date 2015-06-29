package org.dedeplz.fridge.model.board;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {

	public List<BoardVO> getPostingList(int pn);

	public int getTotalPostingCount();

	public void registerBoard(BoardVO bvo);

	public BoardVO getBoardInfo(int boardNo);

	public void insertBoardFile(FileVO fvo);

	public List<String> getFileName(int boardNo);

	public void deleteBoardFile(int boardNo);

	public void deleteBoard(int boardNo);

	public void updateCount(int boardNo);
	
	public void updateBoard(BoardVO bvo);

	public List<BoardVO> getSearchByCategoryList(HashMap<String, Object> paramMap);

	public int getTotalCategoryCount(String category);

	public List<BoardVO> getSearchByWriterList(HashMap<String, Object> map);

	public int getTotalSearchByWriterCount(String nick);

	public List<BoardVO> getSearchByContentsList(HashMap<String, Object> map);

	public int getTotalSearchByContentsCount(String contents);

	public List<BoardVO> getSearchByTitleList(HashMap<String, Object> map);

	public int getTotalSearchByTitleCount(String title);

	

}