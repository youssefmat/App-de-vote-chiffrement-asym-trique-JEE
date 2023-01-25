<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
        <!-- les liens pour récuperer le contuné CSS à dossier CSS  --->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Centre de Vote Electronique</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/swiper.min.css">
           <link rel="stylesheet" href="css/main.css">
    
        
       
  </head>
  <body>
         <!---------------   demarrer la precharge ------------>
        	<div class="loading-overlay text-center" >
			    <div class="loader">
                   <div class="loader-div">
                   <div class="loader-div">
                   <div class="loader-div">
                   <div class="loader-div">
                       <div class="loader-div">
                   </div>
                   </div>
                   </div>
                   </div>
                   </div>
            </div>
	  	</div>	
      <!---------------   fin precharge ------------>
         <!---------------   demarrer navbar ------------>
    <nav class="navbar navbar-expand-lg navbar-dark sticky-top" >
      <div class="container-fluid">
              <a class="navbar-brand" href="#">
                Centre de  <span> Vote</span> 
              </a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-nav" aria-controls="main-nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>

                    <div class="collapse navbar-collapse" id="main-nav">
                        <ul class="navbar-nav mr-auto w-100 justify-content-end">
                            <li class="nav-item active">
                                <a class="nav-link " href="#home">Accueil</a>
                            </li>
                                <a class="nav-link" href="#condidat">Condidats</a>
                            </li>
                            
                        </ul>
                      </div>
                    </div>
                </nav>

        <!------------   fin navbar ------------->
        <!------------   demarrer l'entite de  video ------------->
        <section class="bgVideo"  data-vide-bg="3" id="home">
            <div class="overlay">
                 <div class="wave"></div>
                <div class="title">
                    <h1><span class="type" > </span></h1>
                    <p>  bienvenue sur centre de vote electronique en ligne . </p>
                    
                    <div>
                    <a href="authCO.jsp">
                        <svg><rect></rect></svg>
                        Centre de Comptage
                    </a><span></span>
                    <a href="authDE.jsp">
                        <svg><rect></rect></svg>
                        Centre de Depouillement
                    </a>
                    </div>
                     <br>
                     <br>     
                     <a href="form.jsp">
                        <svg><rect></rect></svg>
                        Votant
                    </a>
                </div>
            </div>
        </section>
       <!------------   fin l'enite de video ------------->
      
        
<!------------- fin price --------------->

        <section class="testimonials  text-center" id="condidat">
            <div class="overlay"></div>
             <div class="headTitle">
                    <h2>Les Candidats</h2>
                     <svg width="180px" height="20px">
                                <line x1="0" y1="10" x2="180" y2="10" stroke="#9e9e9e" stroke-width="1px"></line>
                                 <line x1="50" y1="10" x2="130" y2="10" stroke="#2196f3" stroke-width="5px"></line>        
                    </svg>
            </div>
            <div class="container-fluid " >
                <div class="row">
                      <div class="swiper-container">
                        <div class="swiper-wrapper">
                          <div class="swiper-slide" >
                            <div class="item">
                                <span>Numero : 3</span>
                                <h3>Yousef Mathouri</h3>
                                <img src="img/people/mathouri.jpeg"  >
                            </div>
                           </div>
                           <div class="swiper-slide" >
                                <div class="item">
                                    <span>Numero : 2</span>
                                    <h3>Youssef Lahouifi</h3>
                                    <img src="img/people/lahouifi.jpeg" >      
                                </div>
                            </div>
                            <div class="swiper-slide" >
                                <div class="item">
                                    <span>Numero : 1</span>
                                    <h3>Chaime Khachane</h3>
                                    <img src="img/people/chaimae.jpg" >  
                                </div>
                            </div> 
                        </div>
                        <div class="swiper-pagination"></div>
                          <div class="swiper-button-next"></div>
                          <div class="swiper-button-prev"></div>
                      </div>
                </div>
            </div>
        </section>

  <!-------------  demarrer footer --------------->
            <footer class="footer">
                <div class="container">
                    <div class=" row">
                        <div class="col-sm-12">
                            <div class="icons">
                                <ul>
                                    <li><a><i class="fa fa-facebook"></i></a></li>
                                    <li><a><i class="fa fa-twitter"></i></a></li>
                                    <li><a><i class="fa fa-linkedin"></i></a></li>
                                    <li><a><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                            <div class="copyright">
                                <p>&copy; 2022 </p>
                            </div>
                           
                        </div>
                    </div>
                </div>
            </footer>
 <!-------------  fin footer --------------->
 <!-------------  demarrer button scroll up --------------->
        <div class="topbtn">   <i class="fa fa-arrow-up"></i> </div>
<!-------------  fin button scroll up --------------->
     
        
        <!-------------  les liens de recuperation le contuné de javaScripte  --------------->
        <script src="js/jquery-3.4.1.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/plugin.js"></script>
        <script src="js/main.js"></script>
        <script src="js/jquery.vide.js"></script>
        <script src="js/typed.min.js"></script>
        <script src="js/swiper.min.js"></script>
        <script src="js/isotope.pkgd.min.js"></script>
    </body>
</html>
