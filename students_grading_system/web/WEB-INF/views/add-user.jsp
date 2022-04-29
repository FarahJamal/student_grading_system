<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>Todos</title>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<div class="container">
	<center>
		<img style="height:15rem; padding-bottom: 23px;" src='<c:url value="/images/schoolvirsity.png"></c:url>' />

	</center>
	<form method="POST" action="/signup">
		<fieldset class="form-group">
			<label>Role</label>
			<select name="role" class="form-control" >
				<option value="1">Admin</option>
				<option value="2">Teacher</option>
				<option value="3">Student</option>
			</select>

			<BR />
		</fieldset>
		<fieldset class="form-group">
			<label>User Name</label>
			<input required name="username" type="text"
				class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Email</label>
			<input required name="email" type="email"
				   class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label>
			<input required name="password" type="password"
				   class="form-control" /> <BR />
		</fieldset>
		<input required type="submit" class="btn btn-success" value="Submit" />
		<p>Already User?<a href="/login">Login</a></p>
	</form>
</div>

