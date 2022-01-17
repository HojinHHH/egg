package egg.finalproject.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egg.finalproject.member.MemberDTO;

@Repository
public class AdminMemberDAO {
	
	@Autowired
	private SqlSession session;
	
	// ��ü ȸ�� ��������
	public List<MemberDTO> memberSelectAll() throws Exception {
		return session.selectList("adminMemberMapper.memberSelectAll");
	}
	
	// ȸ�� ���̵�, �г���, �̸��Ϸ� �˻�
	public List<MemberDTO> memberSearch(Map<String, String> map) throws Exception {
		return session.selectList("adminMemberMapper.memberSearch", map);
	}
	
	// ȸ�� ���� Ż��
	public int memberExpulsion(Map<String, String[]> map) throws Exception {
		return session.update("adminMemberMapper.memberExpulsion", map);
	}
	
	// ȸ�� ������Ʈ ���
	public int memberBlacklistRegist(Map<String, String[]> map) throws Exception {
		return session.update("adminMemberMapper.memberBlacklistRegist", map);
	}
	
	// ȸ�� ������Ʈ ����
	public int memberBlackListCancel(Map<String, String[]> map) throws Exception {
		return session.update("adminMemberMapper.memberBlackListCancel", map);
	}

}
