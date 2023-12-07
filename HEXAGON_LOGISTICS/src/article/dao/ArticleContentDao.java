package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleContentDao {
	
	public ArticleContent insert(Connection conn, ArticleContent content)
	throws SQLException{
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement("insert into article_content (article_no,content) values (s_article_list_content.nextval,?)");
			//게시글 read오류 시 sequence s_article_list_content와 ArticleDao안의 s_article_list가 일치하는지 반드시 확인후 삭제 및 새로생성!!
			pstmt.setString(1, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			if(insertedCount>0) {
				return content;
				
			}else {
				return null;
			}
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
		
		public ArticleContent selectById(Connection conn, int no) throws SQLException{
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			try {
				pstmt=conn.prepareStatement("select * from article_content where article_no = ?");
				pstmt.setInt(1, no);
				rs=pstmt.executeQuery();
				ArticleContent content = null;
				if(rs.next()) {
					content=new ArticleContent(
							rs.getInt("article_no"),rs.getString("content"));
				
				
				}
				return content;
				
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				
			}
		}
		
		public int update(Connection conn, int no, String content) throws SQLException{
			try(PreparedStatement pstmt= conn.prepareStatement("update article_content set content = ? where article_no = ?")){
				pstmt.setString(1, content);
				pstmt.setInt(2, no);
				return pstmt.executeUpdate();
				
					
			}
		}
		
		public int delete(Connection conn, int no, String content) throws SQLException{
			try(PreparedStatement pstmt= conn.prepareStatement("delete from article_content where article_no = ?")){
				pstmt.setInt(1, no);
				return pstmt.executeUpdate();
				
					
			}
		}

	}
