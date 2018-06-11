package ac.yongin.phs.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ac.yongin.phs.common.JDBCUtil;
import ac.yongin.phs.vo.BoardVO;

@Repository("boardDAO")
public class BoardDao {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public void insertBoard(BoardVO vo)
	{
		String sql = "insert into board(title,writer,content) values(?,?,?)";
		try 
		{
			conn = JDBCUtil.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getTitle());
			psmt.setString(2,vo.getWriter());
			psmt.setString(3,vo.getContent());
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			JDBCUtil.close(conn, psmt);
		}
	}
	
	public void updateBoard(BoardVO vo)
	{
		String sql = "update board set title = ?, content = ? where seq = ?";
		try 
		{
			conn = JDBCUtil.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getTitle());
			psmt.setString(2,vo.getContent());
			psmt.setInt(3,vo.getSeq());
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			JDBCUtil.close(conn, psmt);
		}
	}
	
	public void deleteBoard(BoardVO vo)
	{
		String sql = "delete from board where seq = ?";
		try 
		{
			conn = JDBCUtil.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,vo.getSeq());
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			JDBCUtil.close(conn, psmt);
		}
	}
	
	public ArrayList<BoardVO> getBoardList()
	{
		String sql = "select * from board";
		BoardVO board = null;
		ArrayList<BoardVO> list = null;
		try 
		{
			conn = JDBCUtil.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setCnt(rs.getInt(6));
				list.add(board);
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			JDBCUtil.close(conn, psmt);
		}
		return list;
	}
	public BoardVO getBoard(String writer)
	{
		String sql = "select * from board where writer = ?";
		BoardVO board = null;
		try 
		{
			conn = JDBCUtil.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,writer);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				board.setTitle(rs.getString(1));
				board.setWriter(rs.getString(2));
				board.setContent(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			JDBCUtil.close(conn, psmt);
		}
		return board;
	}
}
