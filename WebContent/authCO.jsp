<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Centre de Comptage</title>
         <link rel="stylesheet" type="text/css" href="cssform/style.css">
          <link href="https://fonts.googleapis.com/css?family=Montserrat:300,600" rel="stylesheet">
	      <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

<!-- Custom styles for this template -->
</head>
<body >
	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
			<div class="booking-form">
				<form class="form-signin" method="post" action="TraiterAuthoCo">
					<h1 >Connexion</h1>
					<label>Email</label>
                    <input type="text" id="inputEmail"class="form-control" name="email" placeholder="Entrez Email" required
						autofocus>
				     <label>Mot de Passe</label> 
				     <input type="password" id="inputEmail" class="form-control" name="password" placeholder="Entrez Mot de Passe " required autofocus>
					<label></label>
					<button class="btn btn-lg btn-outline-secondary btn-block" type="submit"
						name="env">Connexion</button>
				</form>
			</div>
		</div>
		</div>
	</div>
</body>
</html>