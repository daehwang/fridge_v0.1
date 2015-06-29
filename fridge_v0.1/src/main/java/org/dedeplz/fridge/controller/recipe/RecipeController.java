package org.dedeplz.fridge.controller.recipe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dedeplz.fridge.common.LoginCheck;
import org.dedeplz.fridge.model.member.MemberVO;
import org.dedeplz.fridge.model.recipe.FavoriteVO;
import org.dedeplz.fridge.model.recipe.FileVO;
import org.dedeplz.fridge.model.recipe.RecipeService;
import org.dedeplz.fridge.model.recipe.RecipeVO;
import org.dedeplz.fridge.model.recipe.paging.FavoriteListVO;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 레시피 컨트롤러
 * 
 * @author KOSTA
 * 
 */
@Controller
public class RecipeController {
	@Resource(name = "recipeServiceImpl")
	private RecipeService recipeService;
	@Resource(name = "uploadPath")
	private String path;
	
	/**
	 * multiplePhotoUpload 메서드의 FileVO값을 저장
	 */
	/**
	 * 메인 페이지에 레시피 마지막 사진을 전송
	 * 
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("home.do")
	public ModelAndView home() {
		//전체 레시피 리스트
		List<String> recipeNoList = recipeService.getAllRecipeNo();
		List<HashMap<String,Object>> fileLastNamePath = new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < recipeNoList.size(); i++) {
			String fileLastNo = recipeService.getFileLastNo(recipeNoList.get(i));
			String fileLastPath = recipeService.getFileLastNamePath(fileLastNo);
			 RecipeVO rvo=recipeService.getRecipeInfoNoHits(Integer.parseInt(recipeNoList.get(i)));
			 String tag=recipeService.getItemTag(Integer.parseInt(recipeNoList.get(i)));
			 int goodPoint = recipeService.getTotalGood(Integer.parseInt(recipeNoList.get(i)));
			 HashMap<String, Object> map=new HashMap<String, Object>();
	         map.put("rvo",rvo);
	         map.put("fileLastPath", fileLastPath);
	         map.put("tag", tag);
	         map.put("goodPoint",goodPoint);
	         fileLastNamePath.add(map);
		}
		//탑 3 레시피 리스트
				List<String> topRecipeNoList = recipeService.getTopPointRecipeList();
				System.out.println("탑 목록" + topRecipeNoList);
				List<HashMap<String,Object>> topFileLastNamePath = new ArrayList<HashMap<String,Object>>();
				for (int i = 0; i < topRecipeNoList.size(); i++) {
					String fileLastNo = recipeService.getFileLastNo(topRecipeNoList.get(i));
					String fileLastPath = recipeService.getFileLastNamePath(fileLastNo);
					 RecipeVO rvo=recipeService.getRecipeInfoNoHits(Integer.parseInt(topRecipeNoList.get(i)));
					 String tag=recipeService.getItemTag(Integer.parseInt(topRecipeNoList.get(i)));
					 int goodPoint = recipeService.getTotalGood(Integer.parseInt(topRecipeNoList.get(i)));
					 HashMap<String, Object> map=new HashMap<String, Object>();
			         map.put("rvo",rvo);
			         map.put("fileLastPath", fileLastPath);
			         map.put("tag", tag);
			         map.put("goodPoint",goodPoint);
			         topFileLastNamePath.add(map);
				}
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("recipeNoList", recipeNoList.size());
				resultMap.put("filePath",fileLastNamePath);
				resultMap.put("topFileInfo", topFileLastNamePath);
				return new ModelAndView("home", "total", resultMap);
	}
	/**
	 * 레시피 검색
	 * @param items
	 * @return
	 */
    @RequestMapping("searchRecipe.do")
    public ModelAndView searchRecipe(String items){
        List<String> recipeNoList = recipeService.getRecipeNoByItem(items);
        List<HashMap<String,Object>> fileLastNamePath = new ArrayList<HashMap<String,Object>>();
       System.out.println(fileLastNamePath);
       for (int i = 0; i < recipeNoList.size(); i++) {
          String fileLastNo = recipeService.getFileLastNo(recipeNoList.get(i));
          String fileLastPath = recipeService.getFileLastNamePath(fileLastNo);
           RecipeVO rvo=recipeService.getRecipeInfoNoHits(Integer.parseInt(recipeNoList.get(i)));
           String tag=recipeService.getItemTag(Integer.parseInt(recipeNoList.get(i)));
           int goodPoint = recipeService.getTotalGood(Integer.parseInt(recipeNoList.get(i)));
           HashMap<String, Object> map=new HashMap<String, Object>();
             map.put("rvo",rvo);
             map.put("fileLastPath", fileLastPath);
             map.put("tag", tag);
             map.put("goodPoint",goodPoint);
             fileLastNamePath.add(map);
       }
       Map<String, Object> resultMap = new HashMap<String, Object>();
       resultMap.put("recipeNoList", recipeNoList.size());
       resultMap.put("filePath",fileLastNamePath);

       return new ModelAndView("home", "total", resultMap);
     }
	/**
	 * 레시피 상세 정보 보기
	 * 
	 * @param fvo
	 * @param model
	 * @return
	 */
	@RequestMapping("showRecipe.do")
	@ResponseBody
	public ModelAndView showContents(FileVO fvo,@CookieValue(value="memberCookie",required=false) String cookieValue,HttpServletResponse response, HttpSession session) {
		System.out.println("showRecipe");
		RecipeVO rvo = null;
		int recipeNo = recipeService.getRecipeNoByPath(fvo.getFilePath());
		 if(cookieValue==null){//memberCookie cookie 존재하지 않으므로 cookie 생성하고 count 증가 (맨처음)
	         response.addCookie(new Cookie("memberCookie","|"+recipeNo+"|"));
	          rvo=recipeService.getRecipeInfo(recipeNo);
	          System.out.println("cookieValue==null 일때 cookieValue : "+cookieValue);
	      }else if(cookieValue.indexOf("|"+recipeNo+"|")==-1){//memberCookie cookie 존재하지만 {}번글은 처음 조회하므로 count증가
	         cookieValue+="|"+recipeNo+"|";
	         //글번호를 쿠키에 추가 
	         response.addCookie(new Cookie("memberCookie",cookieValue));
	          rvo=recipeService.getRecipeInfo(recipeNo);
	          System.out.println("cookieValue.indexOf('|'+recipeNo+'|')==-1 cookieValue : "+cookieValue);
	      }else{//memberCookie cookie 존재하고 이전에 해당 게시물 읽었으므로 count 증가x
	          rvo=recipeService.getRecipeInfoNoHits(recipeNo);
	          System.out.println("else 일떄 cookieValue : "+cookieValue);
	      }   
		List<String> allFilePath = recipeService.getAllFilePahtByRecipeNo(recipeNo);
		String tag = recipeService.getItemTag(rvo.getRecipeNo());
		int totalGood=recipeService.getTotalGood(rvo.getRecipeNo());
		int totalBad=recipeService.getTotalBad(rvo.getRecipeNo());
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("memberId", rvo.getMemberId());
		map.put("recipeNo", rvo.getRecipeNo());
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if(mvo != null){
			HashMap<String,Object> favoriteMap=new HashMap<String, Object>();
		
			favoriteMap.put("memberId", mvo.getId());
			favoriteMap.put("recipeNo", rvo.getRecipeNo());
			int favoriteInfo = recipeService.getFavoriteRecipe(favoriteMap);
			System.out.println(favoriteInfo);
		
			resultMap.put("favoriteInfo", favoriteInfo);
		}
		resultMap.put("rvo", rvo);
		resultMap.put("tag",tag);
		resultMap.put("allFilePath", allFilePath.toString());
		resultMap.put("totalGood", totalGood);
		resultMap.put("totalBad", totalBad);
		ModelAndView model = new ModelAndView("jsonView",resultMap);
		return model;
	}

	/**
	 * 레시피 등록 폼으로 이동
	 * 
	 * @return
	 */
	@LoginCheck
	@RequestMapping("registerRecipeForm.do")
	public String registerRecipeForm() {
		return "register_recipe";
	}

	/**
	 * 레시피 등록
	 * 
	 * @param rvo
	 * @param ivo
	 * @param items
	 * @return
	 */
	@LoginCheck
	@RequestMapping("registerRecipe.do")
	@Transactional
	public ModelAndView registerRecipe(RecipeVO rvo, String items) {
		System.out.println("넘어간다!!");
		int recipeNo = 0;
		String contents = rvo.getContents();
		List<String> list = convertHtmlimg(contents);
		System.out.println("list:"+list);
		List<FileVO> fvoList=new ArrayList<FileVO>();
		for (String imgUrl : list) {
			FileVO fvo = new FileVO();
			String imgName[]=imgUrl.split("/");
			fvo.setFileName(imgName[imgName.length-1].toString());
			fvo.setFilePath(imgUrl);
			fvoList.add(fvo);
		}
		try {
			recipeNo = recipeService.registerRecipe(rvo,items,fvoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(rvo);
		return new ModelAndView("redirect:registerResult.do?recipeNo="
				+ recipeNo);
	}

		
	/**
	 * 레시피 등록 후 레시피 상세 페이지로 이동
	 * 
	 * @param rvo
	 * @param model
	 * @return
	 */
	@LoginCheck
	@RequestMapping("registerResult.do")
	public String registerResult(RecipeVO rvo, Model model) {
		rvo = recipeService.getRecipeInfoNoHits(rvo.getRecipeNo());
		String tag = recipeService.getItemTag(rvo.getRecipeNo());
		model.addAttribute("rvo", rvo);
		model.addAttribute("tag", tag);
		return "show_recipe";
	}

	/**
	 * 레시피를 삭제
	 * 
	 * @param rvo
	 * @param session
	 * @return
	 */
	@LoginCheck
	@RequestMapping("deleteRecipe.do")
	@Transactional
	public ModelAndView deleteForm(RecipeVO rvo, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		String id = mvo.getId();
		List<String> list = recipeService.getFileName(rvo.getRecipeNo());
		File file = new File(path + "\\" + id);
		File f[] = file.listFiles();
		for (int i = 0; i < list.size(); i++) {
			for (int y = 0; y < f.length; y++) {
				if (f[y].getName().equals(list.get(i))) {
					f[y].delete();
				}
			}
		}
		recipeService.deleteRecipeAll(rvo.getRecipeNo());
		return home();
	}
	/**
	 * 
	 * @param rvo
	 * @param model
	 * @return
	 */
	@LoginCheck
	@RequestMapping("updateForm.do")
	public String updateForm(RecipeVO rvo, Model model) {
		rvo = recipeService.getRecipeInfoNoHits(rvo.getRecipeNo());
		String tag = recipeService.getItemTag(rvo.getRecipeNo());
		List<String> fileNameList = recipeService
				.getFileName(rvo.getRecipeNo());
		model.addAttribute("rvo", rvo);
		model.addAttribute("tag", tag);
		model.addAttribute("fileNameList", fileNameList);
		return "update_recipe";
	}

	/**
	 * 다중파일업로드
	 * 
	 * @param request
	 * @param response
	 */
	@LoginCheck
	@RequestMapping(value = "multiplePhotoUpload.do", method = {
			RequestMethod.GET, RequestMethod.POST })
	public void multiplePhotoUpload(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		try {
			// 파일정보
			String sFileInfo = "";
			// 파일명을 받는다 - 일반 원본파일명
			String oriName = request.getHeader("file-name");
			oriName = URLDecoder.decode(oriName, "UTF-8");
			System.out.println("filename :" + oriName);
			String filename_ext = oriName.substring(oriName.lastIndexOf(".") + 1);
			filename_ext = filename_ext.toLowerCase();
			String destPath = path + mvo.getId() + "\\";
			File file = new File(destPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			String fileName = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today = formatter.format(new java.util.Date());
			fileName = today + UUID.randomUUID().toString()
					+ oriName.substring(oriName.lastIndexOf("."));
			String filePath = destPath + fileName;
			/**
			 * recipe_file table에 입력
			 */

			/**
			 * 서버에 파일쓰기
			 */
			InputStream is = request.getInputStream();
			OutputStream os = new FileOutputStream(filePath);
			int numRead;
			byte b[] = new byte[Integer
					.parseInt(request.getHeader("file-size"))];
			while ((numRead = is.read(b, 0, b.length)) != -1) {
				os.write(b, 0, numRead);
			}
			if (is != null) {
				is.close();
			}
			os.flush();
			os.close();
			/**
			 * path에 파일 저장
			 */
			/**
			 * 정보 출력
			 */
			sFileInfo += "&bNewLine=true";
			sFileInfo += "&sFileName=" + oriName;
			sFileInfo += "&sFileURL=" + "/fridge_v0.1/photo_upload/" + mvo.getId()+ "/" + fileName;
			PrintWriter print = response.getWriter();
			print.print(sFileInfo);
			print.flush();
			print.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * java 정규 표현식을 이용한 java 이미지 태그 추출(이미지 저장 경로)
	 * 
	 * @param img
	 * @return
	 */
	public static List<String> convertHtmlimg(String img) {
		Pattern nonValidPattern = Pattern
				.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");

		List<String> result = new ArrayList<String>();
		Matcher matcher = nonValidPattern.matcher(img);
		while (matcher.find()) {
			result.add(matcher.group(1));
		}
		return result;
	}
	   /**
	    * 업데이트
	    * @param request
	    * @param rvo
	    * @return
	    */
		@LoginCheck
	   @RequestMapping("updateRecipe.do")
	   @Transactional
	   public ModelAndView updateRecipe(RecipeVO rvo,String items){
	       List<String> list = convertHtmlimg(rvo.getContents());
	       recipeService.updateRecipe(rvo);  
	       List<FileVO> fvoList=new ArrayList<FileVO>();
			for (String imgUrl : list) {
				FileVO fvo = new FileVO();
				String imgName[]=imgUrl.split("/");
				fvo.setFileName(imgName[imgName.length-1].toString());
				fvo.setFilePath(imgUrl);
				fvoList.add(fvo);
			}
			recipeService.insertRecipeItem(rvo,items);
			recipeService.insertRecipeFile(rvo, fvoList);  
	      return home();
	   }
	   
		@RequestMapping("{viewId}.do")
		public String showView(@PathVariable String viewId){
			return viewId;
		}
		/**
		 * 추천 버튼 클릭 시 추천 insert 및 update
		 * @param mvo
		 * @param rvo
		 * @param goodCase
		 * @return
		 */
		@LoginCheck
		@RequestMapping("updateGood.do")
		@ResponseBody
		public void updateGood(MemberVO mvo,RecipeVO rvo,String goodCase){
			String memberId=mvo.getId();
			int recipeNo=rvo.getRecipeNo();
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("memberId", memberId);
			map.put("recipeNo", recipeNo);
			if(goodCase.equals("0")){
				recipeService.insertGood(map);
				System.out.println("insertGood");
			}else if(goodCase.equals("1")){
				recipeService.updateCancleGood(map);
			}else if(goodCase.equals("2")){
				recipeService.updateUpGood(map);
			}
		}
		/**
		 * 비추천 버튼 클릭 시 비추천 insert 및 update 
		 * @param mvo
		 * @param rvo
		 * @param badCase
		 * @return
		 */
		@LoginCheck
		@RequestMapping("updateBad.do")
		@ResponseBody
		public void updateBad(MemberVO mvo,RecipeVO rvo,String badCase){
			String memberId=mvo.getId();
			int recipeNo=rvo.getRecipeNo();
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("memberId", memberId);
			map.put("recipeNo", recipeNo);
			if(badCase.equals("0")){
				recipeService.insertBad(map);
				System.out.println("insertBad");
			}else if(badCase.equals("1")){
				recipeService.updateCancleBad(map);
			}else if(badCase.equals("2")){
				recipeService.updateUpBad(map);
			}
		}
		/**
		 * 추천 비추천 테이블 유무 체크 및
		 * good bad 값 호출
		 * @param mvo
		 * @param rvo
		 * @return
		 */
		@RequestMapping("checkGoodAndBad.do")
		@ResponseBody
		public ModelAndView checkGood(MemberVO mvo,RecipeVO rvo){
			String memberId=mvo.getId();
			int recipeNo=rvo.getRecipeNo();
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("memberId", memberId);
			map.put("recipeNo", recipeNo);
			int count=recipeService.getGoodAndBadNoCountByRecipeNoAndMemberId(map);
			int good=recipeService.getGood(map);
			int bad=recipeService.getBad(map);
			HashMap<String,Object> goodAndBadResult=new HashMap<String, Object>();
			goodAndBadResult.put("count", count);
			goodAndBadResult.put("good",good);
			goodAndBadResult.put("bad", bad);
			return new ModelAndView("jsonView",goodAndBadResult);
		}
		
		/**
		    * 레시피 즐겨찾기 등록
		    */
		@LoginCheck
		@RequestMapping(value="registerFavorite.do", method=RequestMethod.POST )
		@ResponseBody
		public Object registerFavorite(FavoriteVO fvo, HttpSession session){
			System.out.println("즐겨찾기 등록");
			
			System.out.println(fvo.getRecipeNo());
			MemberVO mvo = (MemberVO) session.getAttribute("mvo");
			System.out.println(mvo);
			if(mvo == null){
				return "home";
			}
			fvo.setMemberId(mvo.getId());
			System.out.println(fvo);
			
			String str = recipeService.registerFavorite(fvo);
			System.out.println(str);
			return str;
		}
		   /**
		    * 즐겨찾기 리스트 검색
		    * @param session
		    * @return
		    */
			@LoginCheck
		   @RequestMapping("favoriteRecipeList.do")
		   public String getFavoriteRecipeList(HttpSession session, Model model, String pageNo){
		      MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		      if(mvo == null){
		         return "home";
		      }else{
		         FavoriteListVO lvo = recipeService.getFavoriteRecipeList(pageNo, mvo.getId());
		         model.addAttribute("lvo", lvo);
		         
		      }
		      return "favoriteList_recipe";
		   }
		   
		   /**
		    * 즐겨찾기 삭제
		    * @param fvo
		    * @return
		    */
			@LoginCheck
		   @RequestMapping(value="deleteFavorite.do", method=RequestMethod.POST)
		   @ResponseBody
		   public Object deleteFavorite(FavoriteVO fvo, String pageNo){
		      System.out.println(fvo);
		      recipeService.deleteFavorite(fvo);
		      System.out.println(1234);
		      
		      return recipeService.getFavoriteRecipeList(pageNo, fvo.getMemberId());
		   }
		   
		   /**
		    * 메인 view 즐겨찾기 클릭시
		    * @param model
		    * @param pageNo
		    * @param session
		    * @return
		    */
			@LoginCheck
		   @RequestMapping("favoriteView.do")
		   public String favoriteView(Model model, String pageNo, HttpSession session){
		      System.out.println("asdf");
		      MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		      FavoriteListVO fvo = recipeService.getFavoriteRecipeList(pageNo, mvo.getId());
		      List<FavoriteVO> fList = fvo.getList();
		      System.out.println(fList);
		       List<HashMap<String,Object>> fileLastNamePath = new ArrayList<HashMap<String,Object>>();
		         for (int i = 0; i < fList.size(); i++) {
		            String fileLastNo = recipeService.getFileLastNo(Integer.toString(fList.get(i).getRecipeNo()));
		            System.out.println(fileLastNo);
		            String fileLastPath = recipeService.getFileLastNamePath(fileLastNo);
		            System.out.println(fileLastPath);
		             RecipeVO rvo=recipeService.getRecipeInfo(fList.get(i).getRecipeNo());
		             System.out.println(rvo);
		             String tag=recipeService.getItemTag(fList.get(i).getRecipeNo());
		             System.out.println(tag);
		             HashMap<String, Object> map=new HashMap<String, Object>();
		               map.put("rvo",rvo);
		               map.put("fileLastPath", fileLastPath);
		               map.put("tag", tag);
		               fileLastNamePath.add(map);
		         }
		      model.addAttribute("fileLastNamePath",fileLastNamePath);
		      
		      return "favoriteView_recipe";
		   }
		   
		   /**
		       *  댓글 팝업창 띄우기
		       * @param rvo
		       * @param items
		       * @return
		       */
			@LoginCheck
		      @RequestMapping("recipeCommentForm.do")
		      public String recipeCommentForm(){        
		         return"posting/commentRecipeForm";
		      }
		   
}
