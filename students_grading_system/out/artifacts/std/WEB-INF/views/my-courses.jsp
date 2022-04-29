<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/bootstrap.min.js"></script>
<head>
    <title>Todos</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
    .btn{
        width:7rem;
    }
</style>
</head>
<div class="container" style="overflow: auto">

    <H1>Welcome ${name}</H1>
    <form method="GET" action="/my-courses">

        <fieldset class="form-group">

        <select name="select" id="select"  class="form-control">
        <option value="none">none</option>
<c:forEach items="${courses}" var="course">

<option value=${course.courseName} var="courseName">${course.courseName}</option>

</c:forEach>

    </select>
        </fieldset>
    <button class="btn btn-danger" type="submit">show Marks</button>
    </form>
    <%-- To display selected value from dropdown list. --%>
    <%
        String s=request.getParameter("select");
        if (s !=null)
        {
            out.println("Selected value is : "+s);
        }
    %>

    <p><b>average: ${marks[0].avg} ,Median: ${marks[0].median} Min Score: ${marks[0].min} Highest Score: ${marks[0].max}</b></p>
<h4>
   ${myCourses[0].rollNumber}
</h4>
    <h6>
        My Courses
    </h6>
    <table class="table table-striped">
        <thead>
        <th>Course Name</th>
        <th>Instructor</th>
        <th>Marks</th>
        </thead>
        <tbody>
        <c:forEach items="${myCourses}" var="course">
            <tr>
                <td>${course.name}</td>
                <td>${course.instructor}</td>
                <td>${course.mark}</td>

                <c:if test = "${course.mark >= 50}">

                <td>&nbsp;&nbsp;<div class="btn btn-success">
                        Passed
                    </c:if>
                </div></td>
                <c:if test = "${course.mark < 50 && course.mark >0}">

                <td>&nbsp;&nbsp;<div class="btn btn-danger">
                    Failed
                    </c:if>
                </div></td>
                <c:if test = "${course.mark==0}">

                <td>&nbsp;&nbsp;<div class="btn btn-primary">
                    in Progress
                    </c:if>
                </div></td>




            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

