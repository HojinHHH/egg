package egg.finalproject.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "redirect:/admin/memberSelectAll";
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
	
	// ��ü ȸ�� ��������
	@RequestMapping("/memberSelectAll")
	public String memberSelectAll(Model model) throws Exception {
		model.addAttribute("list", service.memberSelectAll());
		return "admin/memberManagement";
	}
	
	// ȸ�� ���̵�, �г���, �̸��Ϸ� �˻�
	@RequestMapping("/memberSearch")
	public String memberSearch(Model model, String searchOption, String searchKeyword) throws Exception {
		model.addAttribute("list", service.memberSearch(searchOption, searchKeyword));
		return "admin/memberManagement"; 
	}
	
	// ȸ�� ���� Ż��
	@RequestMapping("/memberExpulsion")
	public String memberExpulsion(String[] userList) throws Exception {
		service.memberExpulsion(userList);
		return "redirect:/admin/memberSelectAll";
	}
	
	// ȸ�� ������Ʈ ���
	@RequestMapping("/memberBlacklistRegist")
	public String memberBlacklistRegist(String[] userList) throws Exception {
		service.memberBlacklistRegist(userList);
		return "redirect:/admin/memberSelectAll";
	}
	
	// test
	@RequestMapping("/test")
	public String test() throws Exception {
		service.test();
		return "/";
	}

}
