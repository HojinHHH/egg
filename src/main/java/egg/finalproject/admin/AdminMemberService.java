package egg.finalproject.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egg.finalproject.member.MemberDTO;

@Service
public class AdminMemberService {
	
	@Autowired
	private AdminMemberDAO dao;
	
	// ��ü ȸ�� ��������
	public List<MemberDTO> memberSelectAll() throws Exception {
		return dao.memberSelectAll();
	}
	
	// ȸ�� ���̵�, �г���, �̸��Ϸ� �˻�
	public List<MemberDTO> memberSearch(String searchOption, String searchKeyword) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("searchKeyword", searchKeyword);
		return dao.memberSearch(map);
	}
	
	// ȸ�� ���� Ż��
	public int memberExpulsion(String[] userList) throws Exception {
		Map<String, String[]> map = new HashMap<>();
		map.put("userList", userList);
		return dao.memberExpulsion(map);
	}
	
	// ȸ�� ������Ʈ ���
	public int memberBlacklistRegist(String[] userList) throws Exception {
		Map<String, String[]> map = new HashMap<>();
		map.put("userList", userList);
		return dao.memberBlacklistRegist(map);
	}
	
	// test
	public int test() throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setUser_id("id11");
		dto.setPassword("id11");
		dto.setNickname("nn11");
		dto.setPhone("phone11");
		dto.setEmail("em11");
		dto.setAddress("adress11");
		dto.setProfile_path("path");
		dto.setType(1);
		dto.setBlacklist(0);
		return dao.test(dto);
	}

}
