<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>blog list</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/blogList.css">
</head>
<body>
<div id="topBanner"><input type="button" value="logOut" onclick="location.href='logOut.action'"/></div>
<div id="recordTable">
	<table id="blogList">
		<thead>
			<tr>
				<td></td>
				<td>demoTileId</td>
				<td>demoTileHeader</td>
				<td>demoDetailHeader</td>
				<td>demoCreaterHeader</td>
			</tr>
		</thead>
		<tbody>		
			<c:forEach var="articleItem" items="${articlesInfo}">
	    		<tr>
	    			<td><button onclick="location.href='articleDetail.action?articleId=' + '${articleItem.articleId}'" value="edit"></button></td>
	    			<td><c:out value="${articleItem.articleId}"/></td>
	    			<td><c:out value="${articleItem.title}"/></td>
	    			<td><c:out value="${articleItem.content}"/></td>
	    			<td><c:out value="${articleItem.createBy}"/></td>
	    		</tr>
			</c:forEach>	
		</tbody>
	</table>
</div>
</body>
</html>