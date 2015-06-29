package org.dedeplz.fridge.model.board;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * 자유게시판 전체 리스트
	 */
	@Override
	public List<BoardVO> getPostingList(int pn) {
		return  sqlSessionTemplate.selectList("board.getPostingList",pn);
	}
	/**
	 * 자유게시판 전체 포스팅 수 
	 */
	@Override
	public int getTotalPostingCount() {
		return sqlSessionTemplate.selectOne("board.getTotalPostingCount");
	}
	/**
	 * 자유게시판 등록
	 */
	@Override
	public void registerBoard(BoardVO bvo) {
		sqlSessionTemplate.insert("board.registerBoard", bvo);
		
	}
	/**
	 * 자유게시판 정보
	 */
	@Override
	public BoardVO getBoardInfo(int boardNo) {
		return sqlSessionTemplate.selectOne("board.getBoardInfo", boardNo);
	}
	/**
	 * 파일 삽입
	 */
	@Override
	public void insertBoardFile(FileVO fvo) {
		sqlSessionTemplate.insert("boardFile.insertBoardFile", fvo);
	}
	/**
	 * 레시피 번호에 해당하는 모든 사진의 파일네임을 받아온다.
	 */
	@Override
	public List<String> getFileName(int boardNo) {
		return sqlSessionTemplate.selectList("boardFile.getFileName", boardNo);
	}
/**
 * 파일 삭제
 */
	@Override
	public void deleteBoardFile(int boardNo) {
		sqlSessionTemplate.delete("boardFile.deleteBoardFile", boardNo);
	}
	/**
	 * 자유게시판 삭제
	 */
	@Override
	public void deleteBoard(int boardNo) {
		sqlSessionTemplate.delete("board.deleteBoard", boardNo);
	}
	/**
	 * 조회수 업데이트
	 */
	@Override
	public void updateCount(int boardNo) {
		sqlSessionTemplate.update("board.updateCount",boardNo);
	}
	   /**
	    * 게시글수정
	    */
	   @Override
	   public void updateBoard(BoardVO bvo) {
	      sqlSessionTemplate.update("board.updateBoard", bvo);
	   }

	/**
	 * 카테고리로 검색한 자유게시글 목록
	 */
	@Override
	public List<BoardVO> getSearchByCategoryList(HashMap<String, Object> paramMap) {
		System.out.println(paramMap);
		return  sqlSessionTemplate.selectList("board.getSearchByCategoryList",paramMap);
	}
	   /**
	    * 카테고리로 검색한 자유게시글 수 
	    */
	@Override
	public int getTotalCategoryCount(String category) {
		return sqlSessionTemplate.selectOne("board.getTotalCategoryCount",category);
	}
	/**
	 * 제목으로 검색한 자유게시글 목록
	 */
	@Override
	   public List<BoardVO> getSearchByTitleList(HashMap<String,Object> map) {
	      System.out.println("맵:" + map);
	      return sqlSessionTemplate.selectList("board.getSearchByTitleList",map);
	   }
	 /**
	    * 제목으로 검색한 자유게시글 수 
	    */
	   @Override
	   public int getTotalSearchByTitleCount(String title) {
	      System.out.println("getTotalSearchByTitleCount");
	      return sqlSessionTemplate.selectOne("board.getTotalSearchByTitleCount",title);
	   }
	   /**
		 * 글쓴이(닉네임)로 검색한 자유게시글 목록
		 */
	   @Override
	   public List<BoardVO> getSearchByWriterList(HashMap<String, Object> map) {
	      return sqlSessionTemplate.selectList("board.getSearchByWriterList",map);
	   }
	   /**
	    * 글쓴이(닉네임)로 검색한 자유게시글 수 
	    */
	   @Override
	   public int getTotalSearchByWriterCount(String nick) {
	      return sqlSessionTemplate.selectOne("board.getTotalSearchByWriterCount",nick);
	   }
	   /**
		 * 내용으로 검색한 자유게시글 목록
		 */
	   @Override
	   public List<BoardVO> getSearchByContentsList(HashMap<String, Object> map) {
	      return sqlSessionTemplate.selectList("board.getSearchByContentsList",map);
	   }
	   /**
	    *내용으로 검색한 자유게시글 수 
	    */
	   @Override
	   public int getTotalSearchByContentsCount(String contents) {
	      return sqlSessionTemplate.selectOne("board.getTotalSearchByContentsCount",contents);
	   }

	

}
