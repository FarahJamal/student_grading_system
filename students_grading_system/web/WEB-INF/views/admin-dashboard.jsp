<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div>


<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
    img{
        height:418px;
        width:30rem;
    }
</style>
</head>


<div class="card-deck" style="margin-top:10%; padding-left: 70px;">
    <center>
    <div class="card" style="width:35rem; ">
        <div class="card-header" style="width:35rem;">
            <img style="width:35rem;" src="https://www.ymple.com/images/template2020/user/signup.png"/>
        </div>
        <div class="card-body">
            <h5 class="card-title">Add New Student</h5>
            <p class="card-text">Add New Student to the system</p>
            <a href="/signup" class="btn btn-info">Add user</a>
        </div>
    </div>
    </center>
    <center>
        <div class="card" style="width: 35rem;">
            <div class="card-header" style="width:35rem;">
                <img style="width:35rem;" src="https://cdni.iconscout.com/illustration/premium/thumb/result-3715221-3119070.png"/>
            </div>
            <div class="card-body">
                <h5 class="card-title">Generate Student Result</h5>
                <p class="card-text">Generate Result for students.</p>
                <a href="results" class="btn btn-info">See Results</a>
            </div>
        </div>
    </center>
   <center>
       <div class="card" style="width: 35rem;">
           <div class="card-header" style="width:35rem;">
               <img style="width:35rem;" src="http://kidstutorial.online/Elearning%20for%20children.jpg"/>
           </div>
           <div class="card-body">
               <h5 class="card-title">Add New Course</h5>
               <p class="card-text">Add New Course to the system</p>
               <a href="/new-course" class="btn btn-info">Add Course</a>
           </div>
       </div>
   </center>
</div>
</div>