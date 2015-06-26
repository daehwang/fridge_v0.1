package org.dedeplz.fridge.controller.member;

import javax.annotation.Resource;

import org.dedeplz.fridge.model.member.MemberService;
import org.dedeplz.fridge.model.member.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AdminController {
	  @Resource
	   private MemberService memberService;
	  
	  /**
	   * 관리자 페이지 (회원 리스트)
	   * @param pageNo
	   * @return
	   */
	  @RequestMapping("admin_adminpage.do")
	  public ModelAndView showAdminPage(String pageNo){
		  return new ModelAndView ("admin_adminpage","lvo",memberService.getMemberList(pageNo));
	  }
	  /**
	   * 회원 강제탈퇴
	   * @param vo
	   * @return
	   */
	  @RequestMapping("admin_outMember.do")
	  public String outMemeber(MemberVO vo ){
		  memberService.deleteMember(vo);
		  return "redirect:admin_adminpage.do";
	  }
	  /**
	   * 회원 레벨 변경
	   * @param vo
	   * @return
	   */
	  @RequestMapping("admin_levelChange.do")
	  public String levelChange(MemberVO vo){
		  memberService.levelChange(vo);
		  return "redirect:admin_adminpage.do";
	  }
}
