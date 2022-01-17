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
	public int memberExpulsion(String[] userCheckBox) throws Exception {
		Map<String, String[]> map = new HashMap<>();
		map.put("userCheckBox", userCheckBox);
		return dao.memberExpulsion(map);
	}
	
	// ȸ�� ������Ʈ ���
	public int memberBlacklistRegist(String[] userCheckBox) throws Exception {
		Map<String, String[]> map = new HashMap<>();
		map.put("userCheckBox", userCheckBox);
		return dao.memberBlacklistRegist(map);
	}
	
	// ȸ�� ������Ʈ ����
	public int memberBlackListCancel(String[] userCheckBox) throws Exception {
		Map<String, String[]> map = new HashMap<>();
		map.put("userCheckBox", userCheckBox);
		return dao.memberBlackListCancel(map);
	}

}
