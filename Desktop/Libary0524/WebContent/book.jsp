<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.Vo.BookVO" %>
<%@ page import="com.library.service.BookService" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<html>
   <head>
         <meta charset = "utf-8">
         <link rel="stylesheet" type="text/css" href="./css/common.css">
         <link rel="stylesheet" type="text/css" href="./css/book.css">
         <script src="./js/jquery.js"></script>
        <title>
            도서관리 | 도서관리 페이지
        </title>
    </head>
    <body>
        <%@ include file="./elements/adminNav.jsp" %>
        <%
        String error = (String)request.getAttribute("error");
        ArrayList<BookVO> search = (ArrayList<BookVO>)request.getAttribute("book");
        String searchText = request.getParameter("searchBox");
        ArrayList<BookVO> rs;
        if(search != null) {
        	rs = search;
        }
        else {
        	BookService service = BookService.getInstance();
            rs = service.BookListService();
            searchText = "";
        }

        
        %>
        <section>
            <h2>도서 관리</h2>
            <form action = "bookSearch.do">
                <input type = "text" id = "searchBox" name = "searchBox" placeholder="검색할 책명을 입력하시오" value="<%=searchText %>">
                <button type = "submit">
                        <img src = "./img/search.png" id = "searchImg">
                </button>
            </form>
            <table>
                <thead>
                    <th>도서명</th>
                    <th>분야</th>
                    <th>저자명</th>
                    <th>출판사</th>
                    <th>출판연도</th>
                    <th></th>
                    <th></th>
                </thead>
                <tbody>
                <%
                if(error != null){
                	out.println("<tr><td colspan=\"6\"><span id=\"errorMsg\">"+error+"<span><td><tr>");
                }
                else{
                	for(BookVO book : rs) {
                %>
					<tr>
						<td><%=book.getTitle() %></td>
						<td><%=book.getCategory() %></td>
						<td><%=book.getAuthor() %></td>
						<td><%=book.getPublisher() %></td>
						<td><%=book.getPublication_Day() %></td>
						<td><form action="bookadd.jsp" method="get">
                        		<input type="hidden" name="title" value="<%=book.getTitle()%>">
   								<input type="submit" value="수정">
							</form></td>
						<td>
                        	<form action="bookDelete.do" method="get">
                        		<input type="hidden" name="bookNum" value="<%=book.getNum() %>">
   								<input type="submit" value="삭제">
							</form>
                        </td>
					</tr>
					<%}%>
                </tbody>
                <%}%>
                <tfoot>
                    <tr>
                        <td colspan="7">
                        	<a class = "button" href = "./bookadd.jsp">책 추가</a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </section>
		<%@ include file="./elements/footer.jsp" %>
    </body>
</html>