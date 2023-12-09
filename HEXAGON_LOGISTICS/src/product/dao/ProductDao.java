package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import product.model.Product;
import sales.model.Sales;

public class ProductDao {
	
	public Product selectById(Connection conn, int p_no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product_list where p_no = ?");
			pstmt.setInt(1, p_no);
			rs = pstmt.executeQuery();
			Product product = null;
			if(rs.next()) {
				product = new Product(
						rs.getInt("p_no"),
						rs.getString("p_name"),
						rs.getInt("p_seoul"),
						rs.getInt("p_suwon"),
						rs.getInt("p_incheon"),
						rs.getInt("price")
						);
							
			}
			return product;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	
	public void insert(Connection conn, Product prod) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into product_list values(S_PRODUCT_LIST.NEXTVAL,?,?,?,?,?)")) {
			pstmt.setString(1, prod.getP_Name());
			pstmt.setInt(2, prod.getP_Seoul());
			pstmt.setInt(3, prod.getP_Suwon());
			pstmt.setInt(4, prod.getP_Incheon());
			pstmt.setInt(5, prod.getPrice());
			pstmt.executeUpdate();
		}
	}
		
		public void update(Connection conn, Product prod) throws SQLException {
			try (PreparedStatement pstmt = conn.prepareStatement(
					"update product_list set p_seoul = p_seoul + ?, p_suwon = p_suwon + ?, p_incheon = p_incheon + ? where p_no = ?")) {
				pstmt.setInt(1, prod.getP_Seoul());
				pstmt.setInt(2, prod.getP_Suwon());
				pstmt.setInt(3, prod.getP_Incheon());
				pstmt.executeUpdate();
			}
		
	}

}
