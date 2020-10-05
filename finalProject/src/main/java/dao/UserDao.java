package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kolesnick.SummaryTask.db.entity.User;

public class UserDao {
	
	public User getUser(String login, String password) {
		User user = new User();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/kolesnick_db");
			con = dataSource.getConnection();
			pstmt = con.prepareStatement("select * from `user` where `login` = ? and `password` = ?");
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setLogin(login);
				user.setPassword(password);
				user.setAdress(rs.getString("adress"));
				user.setFirstname(rs.getString("user_firstname"));
				user.setName(rs.getString("user_name"));
				user.setLastname(rs.getString("user_lastname"));
				user.setPasport(rs.getString("pasport"));
				user.setTel(rs.getInt("tel"));
				user.setRole_id(rs.getInt("role_id"));
			}
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					// nothing
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					// nothing
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					// nothing
				}
			}
		}
		return user;
	}
}
