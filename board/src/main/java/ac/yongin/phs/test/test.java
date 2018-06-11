package ac.yongin.phs.test;

import ac.yongin.phs.board.service.BoardServiceImp1;

public class test {

	public static void main(String[] args)
	{
		BoardServiceImp1 S = new BoardServiceImp1();
		S.getBoard("관리자");
	}
}
