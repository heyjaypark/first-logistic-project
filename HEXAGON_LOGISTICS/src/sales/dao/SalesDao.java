package sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import product.model.Product;
import sales.model.Sales;

public class SalesDao {
	
	public Sales selectByP_No(Connection conn, String p_No) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from member where memberid = ?");
			pstmt.setString(1, p_No);
			rs = pstmt.executeQuery();
			Product product = null;
			if(rs.next()) {
				Product = new Product(
						rs.getString("p_No"),
						rs.getString("p_Name"),
						rs.getString("p_Seoul"),
						rs.getString("p_Suwon"),
						rs.getString("p_Incheon"),
						rs.getString("p_Price")
						);
							
			}
			return product;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void insert(Connection conn, Sales sal) throws SQLException {
		try(PreparedStatement pstmt =
				conn.prepareStatement("insert into member values(?S_SALES_LIST.NEXTVAL,?,?,?,?)")) {
			pstmt.setInt(1, sal.getP_No());
			pstmt.setInt(2, sal.getS_Seoul());
			pstmt.setInt(3, sal.getS_Suwon());
			pstmt.setInt(4, sal.getS_Incheon());
			pstmt.setString(5, sal.getS_Date()));
			pstmt.executeUpdate();
		}
	}
		
		public void update(Connection conn, Product product) throws SQLException {
			try (PreparedStatement pstmt = conn.prepareStatement(
					"update PRODUCT_LIST set P_SEOUL=P_SEOUL-?, P_SUWON=P_SUWON-?,P_INCHEON=P_INCHEON-?")) {
				pstmt.setInt(1, product.getP_Seoul());
				pstmt.setInt(2, product.getP_Suwon());
				pstmt.setInt(3, product.getP_Incheon());
				pstmt.executeUpdate();
			}
		
	}

}
