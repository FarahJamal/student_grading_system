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
    <form method="POST" action="/new-mark">
        <fieldset class="form-group">
            <label>Student Roll</label>
            <input required name="roll" type="text"
                   class="form-control"
                   required
            /> <BR />

        </fieldset>
        <fieldset class="form-group">
            <label>Mark</label>
            <input required name="mark" type="number"
                   class="form-control" /> <BR />
        </fieldset>

        <select name="courseName" id="select" required="">
            <c:forEach items="${courses}" var="course">
                <option value=${course.courseName} var="courseName">${course.courseName}</option>
            </c:forEach>
        </select>
        <input required type="submit" class="btn btn-success" value="Submit" />
    </form>
</div>
