<%@page import="dao.Devotant"%>
<%@page import="java.util.Collection"%>
<%@page import="dao.GestionBd"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Centre de Depouillement</title>
          <link rel="stylesheet" type="text/css" href="cssform/style.css">
          <link href="https://fonts.googleapis.com/css?family=Montserrat:300,600" rel="stylesheet">
	      <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <script type="text/javascript" src="js/pagination.js"></script>
<!-- Custom styles for this template -->
</head>
<body >
    <nav class="navbar" style="background-color:#fff">
                
                <div class="nav">
                    <a class="btn btn-lg btn-outline-secondary btn-block" href="index.jsp">Deconnexion</a>
                </div>
              
            </nav>
	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
			<div class="booking-form" id ="booking-table">
			  <h1 class="h3 mb-3 font-weight-normal">Centre de Depouillement</h1>
				<table  class="table table-bordered"  >
  <thead>
           <tr>
               <th>id</th>
				<th>Identificateur</th>
				<th>Bulltin Vote</th>
				
          </tr>
  </thead>
  <tbody>
         <%
				GestionBd bd = new GestionBd();
				Collection<Devotant> devotants = bd.getAllDe();
					for (Devotant devotant : devotants) {
			%>

			<tr>
				<td><%=devotant.getId()%></td>
				<td><%=devotant.getIdentification()%></td>
				<td><%=devotant.getBulltinvote()%></td>
			</tr>
			<%
				}
			%>
			
    
  </tbody>
</table>
 <a class="btn btn-lg btn-outline-secondary btn-block" href="ResultVote.jsp">Resultat</a>
			</div>
		</div>
	</div>
	</div>
</body>
</html>