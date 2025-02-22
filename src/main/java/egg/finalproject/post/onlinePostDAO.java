package egg.finalproject.post;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egg.finalproject.category.CategoryDTO;
import egg.finalproject.image.ImageDTO;
import egg.finalproject.product.ProductDTO;

@Repository
public class onlinePostDAO {
	@Autowired
	private SqlSession session;
	
	public void insertPost(PostDTO dto) throws Exception{
		session.insert("onlinePostMapper.insertPost",dto);
	}
	
	public int getPost_no() throws Exception{
		return session.selectOne("onlinePostMapper.getPost_no");
	}
	
	public PostDTO getPostInfo(int post_no) throws Exception{
		return session.selectOne("onlinePostMapper.getPostInfo",post_no);
	}
	
	public int deletePost(int post_no)throws Exception{
		return session.delete("onlinePostMapper.deletePost",post_no);
	}
	
	public void updatePost(PostDTO dto) throws Exception{
		session.update("onlinePostMapper.updatePost",dto);
	}
	
	//================================================================================
	public List<Object> selectRecent() throws Exception{
		return session.selectList("onlinePostMapper.selectRecent");
	}
}
