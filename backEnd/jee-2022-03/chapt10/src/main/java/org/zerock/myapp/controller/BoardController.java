package org.zerock.myapp.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
//@NoArgsConstructor
@AllArgsConstructor

@RequestMapping("/board")
@Controller
//아래의 어노테이션의 배열({속성1, 속성2..})에 지정한
//모델 속성들은 자동으로 세션에도 저장하게 해주는 어노테이션이다.
//ex. board 라는 이름의 모델속성의 이름.
//model.addAttribute("board", vo);
@SessionAttributes({"board", "boardDTO"})
public class BoardController {

	//Spring Framework v4.3이후부터는 아래와 같은 조건 시, 자동 주입
	//즉 @Setter(onMethod_= @Autowired)하지 않아도 됨
//	(1) 주입받을 필드가 오직 1개이고,
//	(2) 이 필드를 매개변수로 가지는 생성자가 있다면
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) throws ControllerException{ //게시판 전체 목록 조회 요청 처리 핸들러
		
		//게시판 전체 목록 로직을 처리하는 메소드가 비즈니스계층에 있기 때문에
		//이 주입받은 service객체를 가지고 하면 된다.
		log.trace("list() invoked.");
		
		Objects.requireNonNull(this.service);
		log.info("\t+this.service:{}", this.service);
		
			try {
				List<BoardVO> list = this.service.getList();
				model.addAttribute("list",list);
			}catch(Exception e) {
				throw new ControllerException(e);
			}//try-catch
		}//list()
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Integer bno, Model model) throws ControllerException{
		log.trace("get() invoked.");
		
		try {
			
			BoardVO vo = this.service.get(bno);
			model.addAttribute("board", vo);
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}//get()
	
	@PostMapping("/remove")
	public String remove(Integer bno, RedirectAttributes rttrs) throws ControllerException{
		log.trace("remove:{}, {}", bno, rttrs);
		
		
		try {
			boolean success =this.service.remove(bno);
			log.info("\t+success:{}", success);
			
			
			//어떤 bno가 담겼는지?
			rttrs.addFlashAttribute("bno",bno);
			rttrs.addAttribute("result", (success)? "success": "failure");
			
			return "redirect:/board/list";
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}//try-catch
	}//remove
	
	@PostMapping("/modify")
	public String modify(BoardDTO dto, RedirectAttributes rttrs)  throws ControllerException{
	
			log.trace("modify:{}, {}", dto, rttrs);
			
			
			try {
				boolean success =this.service.modify(dto);
				log.info("\t+success:{}", success);
				
				rttrs.addFlashAttribute("bno",dto.getBno());
				rttrs.addAttribute("result", (success)? "success": "failure");
				
				return "redirect:/board/list";
				
			}catch(Exception e) {
				throw new ControllerException(e);
			}//try-catch
			
	}//modify()
	
	@PostMapping("/register")
	public String register(BoardDTO dto, RedirectAttributes rttrs)  throws ControllerException{
		
			log.trace("register:{}, {}", dto, rttrs);
			
			
			try {
				boolean success =this.service.register(dto);
				log.info("\t+success:{}", success);
				
				//bno라는이름으로 CUD수행한 bno값을 담아준다. 
				rttrs.addFlashAttribute("bno",dto.getBno());
				rttrs.addAttribute("result", (success)? "success": "failure");
				
				return "redirect:/board/list";
				
			}catch(Exception e) {
				throw new ControllerException(e);
			}//try-catch
			
	}//register()
	
//	==========================================================
//	HttpSession, HttpServletReqeust, HttpServletResponse 객체가 
//	정말 필요하면 DispatcherServlet에게 달라라고 지정하면 준다.
//	(주의사항)하지만, 이 객체를 직접핸들링하는 것은
//	스프링에 반하는 행위이다.
//	==========================================================
	@GetMapping("/temp")
	void temp(
			HttpSession session, 
			HttpServletRequest req, 
			HttpServletResponse res,
			@SessionAttribute("board") BoardVO vo)
			 {
		log.trace("session:{},req: {}, res: {},vo: {}", session, req, res, vo);
		
	}//temp()
	
	@ModelAttribute()
	BoardDTO createBoardDTO() { //이 메소드는 요청을 처리하는 핸들러메소드가아니다.
		log.trace("createBoardDTO() invoked");
		
		BoardDTO dto = new BoardDTO();
		dto.setBno(1000);
		dto.setTitle("TEST");
		
		return dto;
	}//createBoardDTO
	
	
}//end class
