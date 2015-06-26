package org.dedeplz.fridge.model.member;

import java.util.List;

public interface MemberDAO {
	public MemberVO findById(String id);

	public void registerMember(MemberVO vo);

	public String idCheck(String id);

	public MemberVO login(MemberVO vo);

	public void updateMember(MemberVO vo);
	
	public void deleteMember(MemberVO vo);

	public String nickCheck(String nick);

	public String findMyPassword(MemberVO vo);

	public String findMyId(MemberVO vo);

	public List<MemberVO> getMemberList(String pageNo);

	public int totalMember();

	public void levelChange(MemberVO vo);

	public int loveCount(MemberVO vo);

	public void updateMemberGrade(MemberVO vo);
	

}