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
	public List<MemberDTO> memberSearch(String searchOption, String searchKeyword, int currentIdx) throws Exception {
		Map<String, Object> map = this.getRange(currentIdx);
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
	
	// �� ȸ�� �� ��������
	public int memberCount() throws Exception {
		return dao.memberCount();
	}
	
	// ������ ó��
	public Map<String, Object> getNavi(int currentIdx) throws Exception {
		int rowCnt = this.memberCount(); // ��ü ȸ�� ��
		int rowCntPage = 10; // 10��/page
		int naviCnt = (int)Math.ceil((double)rowCnt/rowCntPage); // ��ü ������ ��(�ø�ó��)
		int naviCntPage = 5; // 10navi/page
		
		if(currentIdx < 1) {
			currentIdx = 1;
		}
		if(currentIdx > naviCnt) {
			currentIdx = naviCnt;
		}
		
		int firstIdx = ((currentIdx - 1) / naviCntPage) * naviCntPage + 1; // ������ ���� ��ȣ 
		int lastIdx = firstIdx + naviCntPage - 1; // ������ ������ ��ȣ
		
		boolean needPrev = firstIdx == 1 ? false : true;
		boolean needNext = lastIdx == naviCnt ? false : true; 
		
		Map<String, Object> map = new HashMap<>();
		map.put("currentIdx", currentIdx);
		map.put("firstIdx", firstIdx);
		map.put("lastIdx", lastIdx);
		map.put("needPrev", needPrev);
		map.put("needNext", needNext);
		return map;
	}
	
	// ��ü ȸ�� ��� �������� 
	public List<MemberDTO> getMemberList(int currentIdx) {
		return dao.getMemberList(this.getRange(currentIdx));
	}
	
	// startRange, endRange���ϱ�
	public Map<String, Object> getRange(int currentIdx) {
		int rowCntPage = 10; // �������� 10��
		int startRange = currentIdx * rowCntPage - (rowCntPage - 1);
		int endRange = currentIdx * rowCntPage;
		Map<String, Object> map = new HashMap<>();
		map.put("startRange", startRange);
		map.put("endRange", endRange);
		return map;
	}
	

}
