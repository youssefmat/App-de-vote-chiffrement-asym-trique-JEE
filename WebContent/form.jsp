<%@page import="java.util.ArrayList"%>
<%@page import="dao.Devotant"%>
<%@page import="java.util.Collection"%>
<%@page import="dao.GestionBd"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de Vote</title>
           <link rel="stylesheet" type="text/css" href="cssform/style.css">
          <link href="https://fonts.googleapis.com/css?family=Montserrat:300,600" rel="stylesheet">
	      <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>
   <div id="booking" class="section">
		<div class="section-center">
			<div class="container">
					<div class="booking-form">
						<form class="form-signin" method="post" action="TraiterVotant">
					<label>Nom</label>
                    <input type="text" id="inputEmail"class="form-control" name="nom" placeholder="Enter nom" required
						autofocus>
				     <label>Prenom</label> 
				     <input type="text" id="inputEmail" class="form-control" name="prenom" placeholder="Enter prenom" required autofocus> <label>Date
						Naissance</label> 
					<input type="date" id="inputEmail" class="form-control" name="datenaissance" placeholder="Enter date naissance" required
						autofocus> 
					<label>Identifiant</label> 
					<input type="text" name="identification" id="inputEmail" class="form-control"
						placeholder="Enter identification" required autofocus> 
						<label>Choix Condidate</label> 
					<select class="custom-select" name="bulltinvote">
					<% GestionBd bd = new GestionBd();
   					int nbrVotes;
   					ArrayList<String> list = bd.getCandidats();
   					for(String candidat : list){
					%>
						<option value="<%=candidat%>"><%=candidat%></option>
					<%
   					}
					%>
					</select> 
					<label></label>
					<button class="btn btn-lg btn-outline-secondary btn-block" type="submit"
						name="env">Voter</button>
				</form>
					</div>
				
			</div>
		</div>
	</div>
</body>
</html>