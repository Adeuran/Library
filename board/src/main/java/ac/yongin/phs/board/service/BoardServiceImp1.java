package ac.yongin.phs.board.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ac.yongin.phs.board.dao.BoardDao;
import ac.yongin.phs.vo.BoardVO;

@Service("boardService")
public class BoardServiceImp1 implements BoardService {

	private BoardDao dao;
	
	/* (non-Javadoc)
	 * @see ac.yongin.phs.board.service.BoardService#insertBoard(ac.yongin.phs.vo.BoardVO)
	 */
	@Override
	public void insertBoard(BoardVO vo)
	{
		dao.insertBoard(vo);
	}
	
	/* (non-Javadoc)
	 * @see ac.yongin.phs.board.service.BoardService#updateBoard(ac.yongin.phs.vo.BoardVO)
	 */
	@Override
	public void updateBoard(BoardVO vo)
	{
		dao.updateBoard(vo);
	}
	/* (non-Javadoc)
	 * @see ac.yongin.phs.board.service.BoardService#deleteBoard(ac.yongin.phs.vo.BoardVO)
	 */
	@Override
	public void deleteBoard(BoardVO vo)
	{
		dao.deleteBoard(vo);
	}
	/* (non-Javadoc)
	 * @see ac.yongin.phs.board.service.BoardService#getBoard(ac.yongin.phs.vo.BoardVO)
	 */
	@Override
	public BoardVO getBoard(String writer)
	{
		return dao.getBoard(writer);
	}
	
	/* (non-Javadoc)
	 * @see ac.yongin.phs.board.service.BoardService#getBoardList()
	 */
	@Override
	public ArrayList<BoardVO> getBoardList()
	{
		return dao.getBoardList();
	}
}
