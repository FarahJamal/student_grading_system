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
<script>
    function myFunction() {
        // Get the checkbox
        const checkBox = document.getElementById("myCheck");
        // Get the output text
        const text = document.getElementById("input");
        const dropDown=document.getElementById("select");
        // If the checkbox is checked, display the output text
        if (checkBox.checked == true){
            text.style.display = "block";
            dropDown.removeAttribute("required");
            dropDown.value="none"
            dropDown.disabled=true;
            text.disabled=false;


        } else {
            text.style.display = "none";
            text.value="0";
            text.removeAttribute("required");
            dropDown.disabled=false;


        }
    }
</script>

<div class="container">

    <H1>Welcome ${name}</H1>
    <form method="GET" action="/results">
        <h4>Choose from drop down to generate whole class results enter user roll number to generate one user results</h4>
        <select name="select" id="select" required="">
            <option></option>
            <option value="none">none</option>
            <c:forEach items="${courses}" var="course">
                <option value=${course.courseName} var="courseName">${course.courseName}</option>
            </c:forEach>
        </select>
        Do you have Roll: <input type="checkbox" id="myCheck" onclick="myFunction()">

        <fieldset class="form-group" >
            <input name="roll" type="number"
                   id="input" style="display:none"
                   placeholder="Enter Student Roll Number"
                   class="form-control"
                   disabled
            />
            <BR />
        </fieldset>

        <button type="submit">show Marks</button>
    </form>

    <%String s=request.getParameter("marks");%>
    <%System.out.println(s);%>

        <h4>average: ${marks[0].avg}</h4>
        <h4>Median: ${marks[0].median}</h4>
        <h4>Min Score: ${marks[0].min}</h4>
        <h4>Highest Score: ${marks[0].max}</h4>

</div>
