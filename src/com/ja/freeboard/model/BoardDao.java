package com.ja.freeboard.model;

import java.util.*;
import java.sql.*;
import com.ja.freeboard.vo.*;

public class BoardDao {
	
	private static final String USER = "SCOTT";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String PASSWORD = "TIGER";

	public ArrayList<BoardVo> selectAll() {
		
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		String query = "SELECT *FROM fb_board ORDER BY b_no DESC";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pstm = conn.prepareStatement(query);
			
			
			rs = pstm.executeQuery();
			
			//로직 ..
			while(rs.next()) {
				int b_no = rs.getInt("b_no");
				int m_no = rs.getInt("m_no");
				String b_title = rs.getString("b_title");
				String b_content = rs.getString("b_content");
				java.util.Date b_writedate = rs.getDate("b_writedate");
				
				BoardVo boardVo = new BoardVo(b_no,m_no,b_title,b_content,b_writedate);
				
				list.add(boardVo);
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs !=null) { 
				
				try {
					rs.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
	
		if(pstm != null) {
			try {
				pstm.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	
		if(conn !=null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
		    }
		}
	}
		
		return list;
	}
}
