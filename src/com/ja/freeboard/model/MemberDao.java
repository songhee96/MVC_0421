package com.ja.freeboard.model;


import java.sql.*;
import java.util.*;

import com.ja.freeboard.vo.*;

public class MemberDao  {
	
	private static final String USER = "SCOTT";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String PASSWORD = "TIGER";
	
	public void insert(String m_id,String m_pw,String m_nick,String m_phone) {
		
		
		String query ="INSERT INTO fb_member VALUES(fb_member_seq.nextval,?,?,?,?,sysdate)";
		
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn= DriverManager.getConnection(URL,USER,PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setString(1, m_id);
			pstm.setString(2, m_pw);
			pstm.setString(3, m_nick);
			pstm.setString(4, m_phone);
			
			
			
			pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstm != null) {
				try {
					pstm.close();
				}catch(Exception e) {
					e.printStackTrace();
				}				
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
		}
	}
	
	public MemberVo selectByIdAndPw(String id,String pw) {
	
		MemberVo memberVo = null;
		
		String query = "SELECT * FROM fb_member WHERE m_id = ? AND m_pw = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			
			rs = pstm.executeQuery();
			
			//로직 ..
			if(rs.next()) {
				int m_no = rs.getInt("m_no");
				String m_id = rs.getString("m_id");
				String m_pw = rs.getString("m_pw");
				String m_nick = rs.getString("m_nick");
				String m_phone = rs.getString("m_phone");
				java.util.Date m_joindate = rs.getDate("m_joindate");
				
				memberVo = new MemberVo(m_no, m_id,m_pw, m_nick, m_phone, m_joindate);
				
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
		
		return memberVo;
		
	}
	public MemberVo selectByNo(int no) {
		
		MemberVo memberVo = null;
		
String query = "SELECT *FROM fb_member WHERE m_no = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setInt(1,no);			
			rs = pstm.executeQuery();
			
			//로직 ..
			if(rs.next()) {
				int m_no = rs.getInt("m_no");
				String m_id = rs.getString("m_id");
				String m_pw = rs.getString("m_pw");
				String m_nick = rs.getString("m_nick");
				String m_phone = rs.getString("m_phone");
				java.util.Date m_joindate = rs.getDate("m_joindate");
				
				memberVo = new MemberVo(m_no, m_id,m_pw, m_nick, m_phone, m_joindate);
				
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
		
		
		return memberVo;
		
	}
	

}
