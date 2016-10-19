package com.bit2016.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.mysite.vo.BoardVo;

public class BoardDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류 :" + e);
		}

		return conn;
	}
	public void add(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into board values (board_seq.nextval, ? , ? , sysdate , 0 , nvl((select max(group_no) from board),0)+1, 1, 0, ?))";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle() );
			pstmt.setString(2, vo.getContent());
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
	}
	
	public List<BoardVo> getList(){
		List<BoardVo> list = new ArrayList<BoardVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql =
				"select  no, title, hit , reg_date, name , users_no, rownum as rn"+
				" from (select b.no, b.title, b.hit, to_char(reg_date,'yyyy-mm-dd hh:mi:ss') as reg_date, u.name, b.USERS_NO "
					+" from board b, USERS u "
					+" where b.USERS_NO=u.NO "
					+" order by group_no desc, order_no asc)";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				int hit = rs.getInt(3);
				String regdate=rs.getString(4);
				String userName = rs.getString(5);
				Long userNo = rs.getLong(6);
						
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setHit(hit);
				vo.setRegdate(regdate);
				vo.setUserName(userName);
				vo.setUserNo(userNo);
				
				
				//list에 담아놓기
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error :"+e);
		}
		return list;
	}
	public void insert(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into board VALUES(guestbook_seq.nextval, ?, ?, ?, sysdate)";

			pstmt = conn.prepareStatement(sql);

			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
	}
}
