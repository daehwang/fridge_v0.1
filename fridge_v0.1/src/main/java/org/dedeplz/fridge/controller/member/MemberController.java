package org.dedeplz.fridge.controller.member;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.dedeplz.fridge.common.LoginCheck;
import org.dedeplz.fridge.model.member.MemberService;
import org.dedeplz.fridge.model.member.MemberVO;
import org.dedeplz.fridge.model.recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MemberController {
   @Resource
   private MemberService memberService;
   @Resource
   private RecipeService recipeService;
   
   /**
    * 메인 화면 (home.jsp)로 이동
    * @return
    */
/*   @RequestMapping("home.do")
   public String home(){
      return "home";
   }*/
   /**
    *회원 가입약관 joinclause_view.jsp로 이동 
    * @return
    */
   @RequestMapping("member_joinclause_view.do")
   public String joinClause(){
      return "member_joinclause_view";
   }
   /**
    * 로그인 인터셉터
    * @return
    */
   @RequestMapping("loginCheck.do")
   public String loginCheck(){
      return "loginCheck";
   }
   
   /**
    * 회원등록 폼(join_form.jsp)으로 이동
    * @return
    */
   @RequestMapping("member_registerForm.do")
   public ModelAndView registerForm(){   
      return new ModelAndView("member_join_form","memberVO",new MemberVO());
   }
   /**
    * 로그인 폼(login.jsp)로 이동
    * @return
    */
   @RequestMapping("member_loginForm.do")
   public String loginForm(){
      return "member_login_form";
   } 
   /**
    * 마이페이지 (mypage.jsp)로 이동
    * @return
    */
   @LoginCheck
   @RequestMapping("member_mypage.do")
   public String showMyPage(){
      return "member_mypage";
   }
/*   *//**
    * 업데이트 전 비밀번호 체크 폼 (update_check_form.jsp)로 이동
    *//*
   @RequestMapping("member_updateMemberForm.do")
   public String updateMemeberForm(){
      return "member_update_check_form";
   }*/
   /**
    *회원 탈퇴 전 비밀번호 확인form.jsp로 이동 
    * @return
    */
   @RequestMapping("member_deleteMemberForm.do")
   public String deleteMemberForm() {
      return "member_delete_check_form";
   }
   /**
    * 아이디 /비밀번호 찾기 폼으로
    * @return
    */
   @RequestMapping("member_findMyInfo.do")
   public String findMyInfo(){
      return "member_findMyInfo";
   }   
   /**
    * 회원 등록 및 validation,  등록 결과 메서드로 redirect
    * @param vo
    * @param result
    * @return
    */
   @RequestMapping(value="member_register.do",method=RequestMethod.POST)
   public ModelAndView registerMember(@Valid MemberVO vo,BindingResult result){
      if(result.hasErrors()){
         return new ModelAndView("member_join_form"); 
      }
        memberService.registerMember(vo);
         return new ModelAndView("redirect:regiResult.do?id="+vo.getId());
   }   
   /**
    * 회원 등록 완료
    * @param request
    * @param response
    * @param vo
    * @return
    */
   @RequestMapping("regiResult.do")
   public ModelAndView regiResult(HttpServletRequest request, MemberVO vo){
      MemberVO mvo = memberService.findById(vo.getId());
      HttpSession session=request.getSession();
        session.setAttribute("mvo", mvo);
      return new ModelAndView("member_join_result","mvo",mvo);
   }
   /**
    * 아이디 중복체크(ajax)
    * @param request
    * @return
    */
   @RequestMapping("member_memberIdCheck.do")
   @ResponseBody
   public String idCheckAjax(HttpServletRequest request) {      
      String id=request.getParameter("id");
      return memberService.idCheck(id);
   }   
   /**
    * 닉네임 중복체크(ajax)
    * @param request
    * @return
    */
   @RequestMapping("member_memberNickCheck.do")
   @ResponseBody
   public String nickCheckAjax(HttpServletRequest request) {      
      String nick=request.getParameter("nick");
      return memberService.nickCheck(nick);
   }
   /**
       *  로그인
       * @param vo
       * @param request
       * @return
       */
     @RequestMapping("member_login.do")
      public String login(MemberVO vo, HttpServletRequest request) {
         MemberVO mvo = memberService.login(vo);
         if (mvo == null)
            return "member_login_fail";
         else {
            int totalLove=memberService.getTotalLove(vo.getId());
            System.out.println("totalLove:"+totalLove);
            mvo.setLove(totalLove);
            memberService.updateMemberLove(mvo);
            HttpSession session = request.getSession();
            if ((mvo.getLevel()==1)&&(totalLove >= 10)) {
               memberService.updateMemberGrade(mvo);
               mvo.setLevel(mvo.getLevel()+1);
               session.setAttribute("mvo", mvo);
               return "member_upgrade_result";
            }else if ((mvo.getLevel()==2)&&(totalLove >= 30)) {
               memberService.updateMemberGrade(mvo);
               mvo.setLevel(mvo.getLevel()+1);
               session.setAttribute("mvo", mvo);
               return "member_upgrade_result";
            }else if((mvo.getLevel()==3)&&(totalLove >= 50)) {
               memberService.updateMemberGrade(mvo);
               mvo.setLevel(mvo.getLevel()+1);
               session.setAttribute("mvo", mvo);
               return "member_upgrade_result";
            }else if((mvo.getLevel()==4)&&(totalLove >= 80)) {
               memberService.updateMemberGrade(mvo);
               mvo.setLevel(mvo.getLevel()+1);
               session.setAttribute("mvo", mvo);
               return "member_upgrade_result";
            }
            session.setAttribute("mvo", mvo);
            System.out.println("로그인 mvo:"+mvo);
            return "redirect:home.do";
         }
      }     
     
   /**
    * 로그아웃 
    * @param request
    * @return
    */
      @RequestMapping("member_logout.do")
      public String logout(HttpServletRequest request){
         HttpSession session=request.getSession(false);
         if(session!=null)
            session.invalidate();
         return "redirect:home.do";
      }        
      /**
       * 회원정보 업데이트
       * @param vo
       * @param result
       * @param request
       * @param session
       * @return
       */
   
      @RequestMapping("member_update.do")
      public ModelAndView updateMember(@Valid MemberVO vo,BindingResult result,HttpServletRequest request, HttpSession session){
            if(result.hasErrors()){
            
            return new ModelAndView("member_update_form"); 
         }
         MemberVO vo1 = (MemberVO) session.getAttribute("mvo");
         vo.setId(vo1.getId());
         memberService.updateMember(vo);
        session.setAttribute("mvo", vo);
      return new ModelAndView("member_mypage");
      }      
      /**
       * 회원 수정 비밀번호 체크
       * @param vo
       * @return
       */
      @LoginCheck
      @RequestMapping("member_passwordCheck_update.do")
      public ModelAndView passwordCheckUpdate(MemberVO vo) {
         MemberVO mvo = memberService.login(vo);
         if (mvo == null) {
            return new ModelAndView("member_password_check_fail");
         } else{
            return new ModelAndView("member_update_form","memberVO",new MemberVO());
         }         
      }
      /**
       * 비밀번호 확인 되었으면 회원탈퇴
       * 
       * @param vo
       * @param request
       * @return
       */
      @RequestMapping("member_passwordCheck_delete.do")
      public String passwordCheckDelete(MemberVO vo, HttpServletRequest request) {
         MemberVO mvo = memberService.login(vo);
         if (mvo == null) {
            return "member_password_check_fail";
         } else{
            List<Integer> list=recipeService.getMyRecipeList(mvo.getId());
            for(int i=0;i<list.size();i++){
               recipeService.deleteRecipeAll(mvo.getId(),list.get(i));
            }
            memberService.deleteMember(mvo);
         }
            
         HttpSession session = request.getSession(false);
         if (session != null)
            session.invalidate();
         return "member_delete_result";
      }   
      /**
       * 내 아이디 찾기
       */
      @RequestMapping("member_findMyId.do")
      @ResponseBody
      public String findMyId(MemberVO vo) {
         String id = memberService.findMyId(vo);
         if (id == null) {
            return "fail";
         } else {
            return id;
         }
      }      
      /**
       * 내 비밀번호 찾기
       * @return
       */      
      @RequestMapping("member_findMyPassword.do")
      @ResponseBody
      public  String findMyPassword(MemberVO vo){
         String password=memberService.findMyPassword(vo);
         if(password==null){
            return "fail";
         }else{
         return password;
        }
      }
      
      
}