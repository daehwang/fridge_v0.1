package org.dedeplz.fridge.model.member;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
   @Resource
   private SqlSessionTemplate sqlSessionTemplate;
   /* (non-Javadoc)
    * @see org.dedeplz.fridge.model.MemberDAO#allMember()
    */
   /**
    * 아이디 찾기
    */
   @Override
   public MemberVO findById(String id){
      return sqlSessionTemplate.selectOne("member.findById",id);
   }
   
   /**
    * 회원등록
    */
   @Override
   public void registerMember(MemberVO vo) {
      sqlSessionTemplate.insert("member.registerMember",vo);
      
   }
   /**
    * 아이디 중복체크
    */
   public String idCheck(String id) {
      int count=sqlSessionTemplate.selectOne("member.idCheck",id);
      return (count==0) ? "ok":"fail";       
   }
   
   /**
    * 로그인
    */
   @Override
      public MemberVO login(MemberVO vo) {
         return sqlSessionTemplate.selectOne("member.login",vo);
      }
   
   /**
    * 회원 정보 수정
    */
   @Override
   public void updateMember(MemberVO vo) {
      sqlSessionTemplate.update("member.updateMember",vo);   
   }
   
   /**
    * 회원 탈퇴
    */
   @Override
      public void deleteMember(MemberVO vo) {
         sqlSessionTemplate.delete("member.deleteMember",vo);
      }
   
   /**
    * 닉네임 중복체크
    */
   @Override
   public String nickCheck(String nick) {
      int count=sqlSessionTemplate.selectOne("member.nickCheck",nick);
      return (count==0) ? "ok":"fail";
   }
   
   /**
    * 내 아이디 찾기
    */
      @Override
      public String findMyId(MemberVO vo) {
         return sqlSessionTemplate.selectOne("member.findMyId",vo);
      }
      
      /**
       * 내 비밀번호 찾기
       */
   @Override
   public String findMyPassword(MemberVO vo) {
      return sqlSessionTemplate.selectOne("member.findMyPassword", vo);
   }
   
   /**
    * 회원 리스트
    */
   @Override
   public List<MemberVO> getMemberList(String pageNo) {
      return sqlSessionTemplate.selectList("member.getMemberList", pageNo);
   }
   
   /**
    * 전체 회원 수 
    */
   @Override
   public int totalMember(){
      return sqlSessionTemplate.selectOne("member.totalMember");
   }
   
   /**
    * 레벨 변경
    */
   @Override
   public void levelChange(MemberVO vo) {
      sqlSessionTemplate.update("member.levelChange",vo);
   }
    
      
      /**
       * 좋아요 수에 따른 자동 등업
       */
      @Override
      public void updateMemberGrade(MemberVO vo) {
         sqlSessionTemplate.update("member.updateMemberGrade", vo);

      }
      /**
       * member love 정보 입력
       */
      @Override
      public void updateMemberLove(MemberVO mvo) {
         sqlSessionTemplate.update("member.updateMemberLove", mvo);

      }
}