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
	
	// �� ȸ�� �� ��������
	public int memberCount() throws Exception {
		return session.selectOne("adminMemberMapper.memberCount");
	}
	
	// ȸ�� ��� ��������
	public List<MemberDTO> getMemberList(Map<String, Object> map) {
		return session.selectList("adminMemberMapper.getMemberList", map);
	}
	
	// ȸ�� ���� Ż��
	public int memberExpulsion(Map<String, String[]> map) throws Exception {
		return session.update("adminMemberMapper.memberExpulsion", map);
	}
	
	// ������Ʈ ON / OFF
	public int memberBlackList(Map<String, Object> map) throws Exception {
		return session.update("adminMemberMapper.memberBlackList", map);
	}

}
