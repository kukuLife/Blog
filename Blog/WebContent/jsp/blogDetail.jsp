<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>blogDetail</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/blogDetail.css">
</head>
<body>
<div id="topBanner"><input type="button" value="logOut"/></div>
	<form action="updateBlogDetail.action" >
		<table id="blogDetail">
			<tr>
				<td>articleId</td>
				<td>title</td>
				<td>content</td>
				<td>createBy</td>
			</tr>
			<tr>
				<td><textarea rows="1" cols="5" readonly name="articleId" ><c:out value="${articleDetail.articleId}"/></textarea></td>
				<td><textarea rows="3" cols="20" name="articleTitle"><c:out value="${articleDetail.title}"/></textarea></td>
				<td><textarea rows="3" cols="20" name="articleContent"><c:out value="${articleDetail.content}"/></textarea></td>
				<td><c:out value="${articleDetail.createBy}"/></td>
			</tr>
		</table>
		<input type="submit" value="submit">	
	</form>
</body>
</html>