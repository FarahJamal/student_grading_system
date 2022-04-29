<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<!doctype html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="overflow-y: scroll">

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<div class="container">
	<H1>Welcome ${name}</H1>
	<c:if test='${pageContext.findAttribute("sharedRole")==3}'>
		<button class="btn btn-primary"  >
			<a href="/my-courses" style="color:white; direction: unset;">
				see your courses
			</a>

		</button>
	</c:if>
<hr/>
	<table class="table table-striped">
		<h6>Courses</h6>
		<thead>
		<th>Course Name</th>
		<th>Course Id</th>
		<th>Instructor</th>
		</thead>
		<tbody>
		<c:forEach items="${courses}" var="course">
			<tr>
				<% System.out.println(  pageContext.findAttribute("sharedRoll") ); %>

				<td>${course.courseName}</td>
				<td>${course.course_id}</td>
				<td>${course.instructor}</td>
				<c:if test='${pageContext.findAttribute("sharedRole")==3}'>

				<td>&nbsp;&nbsp;
					<form method="POST" action="/add-course?roll=${pageContext.findAttribute("sharedRoll")}&course_id=${course.course_id}&course_name=${course.courseName}">
						<button class="btn btn-warning">Register</button>
					</form>
				</td>
				</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</div>

</body>
</html>

