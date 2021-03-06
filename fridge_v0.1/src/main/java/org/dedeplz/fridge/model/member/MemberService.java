package org.dedeplz.fridge.model.member;

public interface MemberService {

   public  MemberVO findById(String id);
   
   public void registerMember(MemberVO vo);
   
   public String idCheck(String id);
   
   public MemberVO login(MemberVO vo);

   public void updateMember(MemberVO vo);

   public void deleteMember(MemberVO vo);

   public String nickCheck(String nick);

   public String findMyPassword(MemberVO vo);

   public String findMyId(MemberVO vo);

   public  MemberListVO getMemberList(String pageNo);

   public void levelChange(MemberVO vo);

   public void updateMemberGrade(MemberVO vo);
   
    public int getTotalLove(String id);

     public void updateMemberLove(MemberVO mvo);

}