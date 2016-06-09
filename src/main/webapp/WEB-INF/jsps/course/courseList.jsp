<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>课程列表页</title>
<%@include file="../common/head.jsp"%>
<%@include file="../common/tag.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>课程列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>编号</th>
							<th>课程名称</th>
							<th>授课老师</th>
							<th>学分</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>详细</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="course" items="${courseList}" varStatus="var">
							<tr>
								<td>${var.index}</td>
								<td>${course.courseName}</td>
								<td>${course.teacher}</td>
								<td>${course.courseName}</td>
								<td><fmt:formatDate value="${course.startDate}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td><fmt:formatDate value="${course.endDate}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								
								<td><a class="btn btn-info"
									href="${course.courseId}/detail" target="_blank">详细</a>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
