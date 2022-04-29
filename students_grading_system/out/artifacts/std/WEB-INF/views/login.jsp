<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Todos</title>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	</head>

<body>
<center>
	<img style="height:15rem; padding-bottom: 23px;" src='<c:url value="/images/schoolvirsity.png"></c:url>' />

</center>

	<div class="container">
		<form action="/login" method="post">
			<fieldset class="form-group">
				<label>User Name</label>
				<input required name="name" type="text"
					   class="form-control" />
				<BR />
			</fieldset>

			<fieldset class="form-group">
				<label>Password</label>
				<input required name="password" type="password"
					   class="form-control" />
				<BR />
			</fieldset>
			<p>
				<font color="red">${errorMessage}</font>
			</p>
			<input required type="submit" class="btn btn-success" value="Login" />
			<p>Don't have account?<a href="/signup">create one</a></p>

		</form>

	</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>