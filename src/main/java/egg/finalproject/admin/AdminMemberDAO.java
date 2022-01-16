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
		System.out.println("dao - memberselectall ����");
		List<MemberDTO> list = session.selectList("userMapper.memberSelectAll");
		System.out.println(list.size());
		return list;
	}
	
	// ȸ�� ���̵�, �г���, �̸��Ϸ� �˻�
	public List<MemberDTO> memberSearch(Map<String, String> map) throws Exception {
		return session.selectList("userMapper.memberSearch", map);
	}
	
	// ȸ�� ���� Ż��
	public int memberExpulsion(Map<String, String[]> map) throws Exception {
		return session.update("userMapper.memberExpulsion", map);
	}
	
	// ȸ�� ������Ʈ ���
	public int memberBlacklistRegist(Map<String, String[]> map) throws Exception {
		return session.update("userMapper.memberBlacklistRegist", map);
	}
	
	// test
	public int test(MemberDTO dto) throws Exception {
		int rs = session.insert("userMapper.test", dto);
		System.out.println(rs);
		return rs;
	}

}
