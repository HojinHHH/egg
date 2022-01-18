package egg.finalproject.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminReportDAO {

	@Autowired
	private SqlSession session;
	
	// �Ű� ��� ��������
	public List<Map<String, Object>> getReportList(Map<String, String> map) throws Exception {
		return session.selectList("adminReportMapper.getReportList", map);
	}
	
}
