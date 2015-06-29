package org.dedeplz.fridge.model.board;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.dedeplz.fridge.model.board.paging.BoardListVO;
import org.dedeplz.fridge.model.board.paging.PagingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Resource(name="boardDAOImpl")
	private BoardDAO boardDAO;

	@Resource(name="uploadPath")
	private String path;
	
	/**
	 * 자유게시판 전체 포스팅 리스트
	 */
	@Override
	public BoardListVO getPostingList(String pageNo) {
		int pn=1;
		if(pageNo!=null){
			pn=Integer.parseInt(pageNo);
		}
		List<BoardVO> list=boardDAO.getPostingList(pn);
		int total=boardDAO.getTotalPostingCount();
		PagingBean pagingBean=new PagingBean(total,pn);
		return new BoardListVO(list,pagingBean);
	}
	/**
	 * 자유게시판 등록
	 */
	@Override
	public int registerBoard(BoardVO bvo, String items, List<FileVO> fvoList) {
		boardDAO.registerBoard(bvo);
		String id=bvo.getMemberId();
/*		insertBoardItem(bvo,items);*/
		int boardNo=bvo.getBoardNo();
		String uploadPath=path+id;
		File file=new File(uploadPath);
		if(!file.exists()){
			file.mkdir();
		}
		insertBoardFile(bvo,fvoList);
		return boardNo;
	}
	/**
	 * file 테이블 정보 등록
	 */
	@Override
	@Transactional
	public void insertBoardFile(BoardVO bvo,List<FileVO> fvoList){
		for(int i=0;i<fvoList.size();i++){
			FileVO fvo=new FileVO();
			fvo.setFileName(fvoList.get(i).getFileName());
			fvo.setFilePath(fvoList.get(i).getFilePath());
			fvo.setBoardNo(bvo.getBoardNo());
			boardDAO.insertBoardFile(fvo);
			}
		}
	/**
	 * 자유게시판 정보
	 */
	@Override
	public BoardVO getBoardInfo(int boardNo) {
		boardDAO.updateCount(boardNo);
		BoardVO bvo=boardDAO.getBoardInfo(boardNo);
		return bvo;
	}
	

	/**
	 * 자유게시판 번호를 이용해 해당 자유게시판의 모든 사진 이름을 받아옴.
	 */
	@Override
	public List<String> getFileName(int boardNo) {
		List<String> list=boardDAO.getFileName(boardNo);
		return list;
	}
	/**
	 * 자유게시판 번호를 이용해서 해당 게시판의 모든 정보 삭제
	 * (자유게시판 테이블, 자유게시판 아이템 테이블, 자유게시판 파일 테이블)
	 */
	@Override
	public void deleteBoardAll(int boardNo) {
		boardDAO.deleteBoardFile(boardNo);
		boardDAO.deleteBoard(boardNo);
	}
	/**
	 * 조회수 안 올라가기
	 */
	@Override
	public BoardVO getBoardInfoNoHits(int boardNo) {
		return boardDAO.getBoardInfo(boardNo);
	}
	/**
	 * 자유게시판 수정
	 */
	   @Override
	   public void updateBoard(BoardVO bvo) {
	      boardDAO.updateBoard(bvo);
	   }
	   /**
	    * 자유게시판 삭제
	    */
	   @Override
	   public void deleteBoardFile(int boardNo) {
	      boardDAO.deleteBoardFile(boardNo);
	   }
	   /**
	    * 카테고리로 검색한 리트스 목록
	    */
		@Override
		public BoardListVO getSearchByCategoryList(String pageNo, String category) {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			int pn=1;
			if(pageNo!=null){
				pn=Integer.parseInt(pageNo);
			}
			paramMap.put("pageNo", pn);
			paramMap.put("category",category);
			List<BoardVO> list=boardDAO.getSearchByCategoryList(paramMap);
			int total=boardDAO.getTotalCategoryCount(category);
			PagingBean pagingBean=new PagingBean(total,pn);
			return new BoardListVO(list,pagingBean);
		}	
		   @Override
		   public BoardListVO getSearchByTitleList(String pageNo, String title) {
		      HashMap<String, Object> map=new HashMap<String,Object>();
		      int pn = 1;
		      if (pageNo != null) {
		         pn = Integer.parseInt(pageNo);
		      }
		      map.put("pageNo", pn);
		      map.put("title", title);
		      List<BoardVO> list = boardDAO.getSearchByTitleList(map);
		      int total = boardDAO.getTotalSearchByTitleCount(title);
		      PagingBean pagingBean = new PagingBean(total, pn);
		      return new BoardListVO(list, pagingBean);
		   }

		   @Override
		   public BoardListVO getSearchByWriterList(String pageNo, String nick) {
		      HashMap<String, Object> map=new HashMap<String,Object>();
		      int pn = 1;
		      if (pageNo != null) {
		         pn = Integer.parseInt(pageNo);
		      }
		      map.put("pageNo", pn);
		      map.put("nick", nick);
		      List<BoardVO> list = boardDAO.getSearchByWriterList(map);
		      int total = boardDAO.getTotalSearchByWriterCount(nick);
		      PagingBean pagingBean = new PagingBean(total, pn);
		      return new BoardListVO(list, pagingBean);
		   }

		   @Override
		   public BoardListVO getSearchByContentsList(String pageNo, String contents) {
		      HashMap<String, Object> map=new HashMap<String,Object>();
		      int pn = 1;
		      if (pageNo != null) {
		         pn = Integer.parseInt(pageNo);
		      }
		      map.put("pageNo", pn);
		      map.put("contents", contents);
		      List<BoardVO> list = boardDAO.getSearchByContentsList(map);
		      int total = boardDAO.getTotalSearchByContentsCount(contents);
		      PagingBean pagingBean = new PagingBean(total, pn);
		      return new BoardListVO(list, pagingBean);
		   }
		
}
