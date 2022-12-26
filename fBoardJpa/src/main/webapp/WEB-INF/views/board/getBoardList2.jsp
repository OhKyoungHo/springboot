<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>글 목록</title>
</head>
<body>
      <h1>게시글 목록</h1>

   <table border="1">
         <tr>
            <th bgcolor="orange" width="100">번호</th>
            <th bgcolor="orange" width="200">제목</th>
            <th bgcolor="orange" width="150">작성자</th>
            <th bgcolor="orange" width="150">등록일</th>
            <th bgcolor="orange" width="100">조회수</th>
            <th bgcolor="orange" width="100">img</th>
         </tr>
         <c:forEach items="${boardList}" var="board">
            <tr>
               <td>${board[0]}</td>
               <td align="left"><a href="getBoard?seq=${board[0]}">
                     ${board[1]}</a></td>
               <td>${board[2]}</td>
               <td>${board[3]}</td>
               <td>${board[4]}</td>
               <td>${board[5]}</td>
            </tr>
         </c:forEach>
      </table>
      <br> <a href="insertBoard">새글 등록</a>
</body>
</html>