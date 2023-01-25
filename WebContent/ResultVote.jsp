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
<title>Resultats des Votes</title>
          <link rel="stylesheet" type="text/css" href="cssform/style.css">
          <link href="https://fonts.googleapis.com/css?family=Montserrat:300,600" rel="stylesheet">
	      <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <script type="text/javascript" src="js/pagination.js"></script>
</head>
<body >
    <nav class="navbar" style="background-color:#fff">
                
                <div class="nav">
                    <a class="btn btn-lg btn-outline-secondary btn-block" href="index.jsp">Deconnexion</a></li>
                </div>   
            </nav>
	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
			<div class="booking-form" id ="booking-table">
			<h1 class="h3 mb-3 font-weight-normal">Resultats des Votes</h1>
				<table  class="table table-bordered"  >
  <thead>
           <tr>
               <% GestionBd bd = new GestionBd();
   int nbrVotes;
   ArrayList<String> list = bd.getCandidats();
   for(String candidat : list){
%>
	   <th><%=candidat%></th>
<%
   }
%>
				
          </tr>
  </thead>
  <tbody>
        	<tr>
				<%
         for(String candidat : list){
	   nbrVotes = bd.getNbrVotes(candidat);
%>
	   <td><%=nbrVotes%></td>
   <%
   }
  %>
			</tr>
   
  </tbody>
</table>
			</div>
		</div>
	</div>
	</div>
</body>
</html>