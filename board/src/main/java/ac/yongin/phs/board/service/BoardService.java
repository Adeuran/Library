package ac.yongin.phs.board.service;

import java.util.ArrayList;

import ac.yongin.phs.vo.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(String writer);

	ArrayList<BoardVO> getBoardList();

}