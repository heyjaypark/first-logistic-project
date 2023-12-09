
package sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import jdbc.JdbcUtil;
import product.model.Product;
import sales.model.Sales;

public class SalesDao {

	public Product selectByP_No(Connection conn, String p_No) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product_list where p_no = ?");
			pstmt.setString(1, p_No);
			rs = pstmt.executeQuery();
			Product product = null;
			if (rs.next()) {
				product = new Product(rs.getInt("p_No"), 
						rs.getString("p_Name"), 
						rs.getInt("p_Seoul"),
						rs.getInt("p_Suwon"), 
						rs.getInt("p_Incheon"), 
						rs.getInt("Price")
						);

			}
			return product;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void insert(Connection conn, Sales sal) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into sales_list values(S_SALES_LIST.NEXTVAL,?,?,?,?,?)")) {
			pstmt.setInt(1, sal.getS_Num());
			pstmt.setInt(2, sal.getP_No());
			pstmt.setInt(2, sal.getS_Seoul());
			pstmt.setInt(3, sal.getS_Suwon());
			pstmt.setInt(4, sal.getS_Incheon());
			pstmt.setDate(5, sal.getS_Date());
			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, Sales sal) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update PRODUCT_LIST set P_SEOUL=P_SEOUL-?, P_SUWON=P_SUWON-?,P_INCHEON=P_INCHEON-?")) {
			pstmt.setInt(1, sal.getS_Seoul());
			pstmt.setInt(2, sal.getS_Suwon());
			pstmt.setInt(3, sal.getS_Incheon());
			pstmt.executeUpdate();
		}

	}

}
