package egg.finalproject.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminReportController {
	
	@Autowired
	private AdminReportService service;
	
	// �Ű� ���� ������ �̵�
	@RequestMapping("/toReportManagement")
	public String toReportManagement() throws Exception {
		return "redirect:/admin/getReportAll";
	}
	
	// �Ű� ��� ��������
	@RequestMapping("/getReportList")
	public String getReportAll(Model model, String searchOption, String searchKeyword, int currentIdx) throws Exception {
		model.addAttribute("list", service.getReportList(searchOption, searchKeyword, currentIdx));
		return "admin/reportManagement";
	}

}
