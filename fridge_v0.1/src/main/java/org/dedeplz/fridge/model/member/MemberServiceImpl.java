package org.dedeplz.fridge.model.member;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	 @Resource
	private MemberDAO memberDAO;
	 /* (non-Javadoc)
	 * @see org.dedeplz.fridge.model.MemberService#allMember()
	*/
	 	/**
		 * 아이디 찾기
		 */
	public MemberVO findById(String id) {
		// TODO Auto-generated method stub
		return memberDAO.findById(id);
	}
	/**
	 * 회원등록
	 */
	@Override
	public void registerMember(MemberVO vo) {
		memberDAO.registerMember(vo);		
	}
	/**
	 * 아이디 중복체크
	 */
	@Override
	public String idCheck(String id) {
		return memberDAO.idCheck(id);
	}
	/**
	 * 로그인
	 */
	 @Override
	   public MemberVO login(MemberVO vo) {
	      return memberDAO.login(vo);
	   }
	/**
	 * 회원 정보 수정
	 */
	@Override
	public void updateMember(MemberVO vo) {
		System.out.println("updateServiceImpl");
		memberDAO.updateMember(vo);
	}
	/**
	 * 회원 탈퇴
	 */
	   @Override
	   public void deleteMember(MemberVO vo) {
	      memberDAO.deleteMember(vo);
	   }
	/**
	 * 닉네임 중복체크
	*/
	@Override
	public String nickCheck(String nick) {
		return memberDAO.nickCheck(nick);
	}
	/**
	 * 내 아이디 찾기
	 */
	   @Override
	   public String findMyId(MemberVO vo) {
	      return memberDAO.findMyId(vo);
	   }
	 /**
	  * 내 비밀번호 찾기
	  */
	@Override
	public String findMyPassword(MemberVO vo) {
		return memberDAO.findMyPassword(vo);
	}
	/**
	 * 회원 리스트
	 */
	@Override
	public MemberListVO getMemberList(String pageNo) {
		if(pageNo==null||pageNo=="") 
			pageNo="1";
		List<MemberVO> list=memberDAO.getMemberList(pageNo);
		int total=memberDAO.totalMember();
		MemberPagingBean paging=new MemberPagingBean(total,Integer.parseInt(pageNo));
		MemberListVO lvo=new MemberListVO(list,paging);
		return lvo;
	}
	/**
	 * 레벨 변경
	 */
	@Override
	public void levelChange(MemberVO vo) {
		memberDAO.levelChange(vo);
	}
	 /**
     * 좋아요 수
     */
   @Override
   public int loveCount(MemberVO vo) {
      System.out.println("좋아요수(service) : "+memberDAO.loveCount(vo));
      return memberDAO.loveCount(vo);
   }
   /** 좋아요 수에따른
    * 자동 렙업
    */
   @Override
   public void updateMemberGrade(MemberVO vo){
      memberDAO.updateMemberGrade(vo);
   }
}
