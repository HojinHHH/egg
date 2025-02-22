package egg.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egg.finalproject.post.onlinePostService;

@Controller
@RequestMapping("/online")
public class OnlineController {

	@Autowired
	private onlinePostService service;
	
	public OnlineController() {
		System.out.println("온라인컨트롤러 접속완료");
	}
	
	@RequestMapping("/toMain.do")
	public String toMain(Model model) throws Exception{
		List<Object> listRecent = service.selectRecent();
		model.addAttribute("listRecent", listRecent);
		
		return "online/onlineMain";
	}
}
