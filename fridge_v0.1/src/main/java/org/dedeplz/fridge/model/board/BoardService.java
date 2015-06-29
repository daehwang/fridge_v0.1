package org.dedeplz.fridge.model.board;

import java.util.List;

import org.dedeplz.fridge.model.board.paging.BoardListVO;

public interface BoardService {

	public BoardListVO getPostingList(String pageNo);

	public int registerBoard(BoardVO rvo, String items, List<FileVO> fvoList);

	public BoardVO getBoardInfo(int boardNo);

	public void insertBoardFile(BoardVO bvo, List<FileVO> fvoList);

	public List<String> getFileName(int boardNo);

	public void deleteBoardAll(int boardNo);

	public BoardVO getBoardInfoNoHits(int boardNo);

	public void updateBoard(BoardVO bvo);

	public void deleteBoardFile(int boardNo);

	public BoardListVO getSearchByCategoryList(String pageNo, String category);

	public BoardListVO getSearchByContentsList(String pageNo, String contents);

	public BoardListVO getSearchByTitleList(String pageNo, String title);

	public BoardListVO getSearchByWriterList(String pageNo, String nick);
	

	
	

}