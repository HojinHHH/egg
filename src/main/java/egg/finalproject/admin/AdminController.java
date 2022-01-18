package egg.finalproject.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egg.finalproject.member.MemberDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminMemberService service;
	
	/********** ������ �̵� **********/
	
	// ������ ������ �̵�(�ӽ�)
	@RequestMapping("/toAdmin")
	public String toAdmin() throws Exception {
		return "admin/adminMain";
	}
	
	// ȸ�� ���� ������ �̵�
	@RequestMapping("/toMemberManagement")
	public String toMemberManagement() throws Exception {
		return "redirect:/admin/getMemberList?currentIdx="+1;
	}
	
	// �Խñ� ���� ������ �̵�
	@RequestMapping("/toPostManagement")
	public String toPostManagement() throws Exception {
		return "admin/postManagement";
	}
	
	// �Ű� ���� ������ �̵�
	@RequestMapping("/toReportManagement")
	public String toReportManagement() throws Exception {
		return "admin/reportManagement";
	}
	
	/********** ȸ�� ���� **********/
	
	// ȸ�� ��� ��������
	@RequestMapping("/getMemberList")
	public String getMemberList(Model model, String searchOption, String searchKeyword, int currentIdx) throws Exception {
		System.out.println("searchOption : " + searchOption + " : " + "searchKeyword : " + searchKeyword + " : " + "currentIdx : " + currentIdx);
		model.addAttribute("list", service.getMemberList(searchOption, searchKeyword, currentIdx));
		model.addAttribute("map", service.getNavi(currentIdx));
		return "admin/memberManagement"; 
	}
	
	// ȸ�� ���� Ż��
	@RequestMapping("/memberExpulsion")
	public String memberExpulsion(String[] userCheckBox) throws Exception {
		service.memberExpulsion(userCheckBox);
		return "redirect:/admin/toMemberManagement";
	}
	
	// ������Ʈ ON / OFF
	@RequestMapping("/memberBlackList")
	public String memberBlackList(String[] userCheckBox, int idx) throws Exception {
		service.memberBlackList(userCheckBox, idx);
		return "redirect:/admin/toMemberManagement";
	}

}
