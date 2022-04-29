<%@ page import="java.util.Random" %>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<head>
    <title>Todos</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<div class="container">
    <form method="POST" action="/new-course">
        <%
            Random rand = new Random();
            int n = rand.nextInt(90000) + 10000;
        %>
        <fieldset class="form-group">
            <label>Course Id</label>
            <input required name="courseId" type="text"
                   class="form-control" value="<%=n%>" readonly="readonly"/>
            <BR />
        </fieldset>

        <fieldset class="form-group">
            <label>Course Name</label>
            <input required name="courseName" type="text"
                   class="form-control" /> <BR />
        </fieldset>
        <fieldset class="form-group">
            <label>Instructor Name</label>
            <input required name="instructor" type="text"
                   class="form-control" />
            <BR />
        </fieldset>
        <fieldset class="form-group">
            <label>Number of Students</label>
            <input required name="numberOfStd" type="number"
                   class="form-control" />
            <BR />
        </fieldset>
        <input required type="submit" class="btn btn-success" value="Submit" />
    </form>
</div>

