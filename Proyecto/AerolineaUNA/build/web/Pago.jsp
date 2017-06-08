<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title> AEROLÍNEA UNA</title>


        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/business-casual.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
        <link href="css/pago.css" rel="stylesheet" type="text/css"/>
        <script src="js/pago.js" type="text/javascript"></script>
    </head>

    <body>
        <div class="page-header">
            <div class="brand"> AEROLÍNEA UNA </div>
            <div class="address-bar">COSTA RICA | HEREDIA | LAGUNILLA</div>
        </div>

        <nav class="navbar navbar-default" role="navigation">
            <div class="contenedor">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="index.jsp">AEROLÍNEA UNA </a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="font-size:10px">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="index.jsp">INICIO</a>
                        </li>

                        <li>         
                            <a href="BuscarVuelos.jsp">BUSCAR VUELOS</a>
                        </li>

                        <li>
                            <a href="Contactenos.jsp">CONTACTENOS</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ADMINISTRACION
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="GestionTipoAviones.jsp">AGREGAR AVIONES</a><br><br>

                                <a class="dropdown-item" href="GestionHorarios.jsp">GESTION DE HORARIOS</a><br><br>
                                <a class="dropdown-item" href="GestionRutas.jsp">GESTION DE RUTAS</a><br><br>
                            </div>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                REPORTES
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="ClientesPorAvion.jsp">CLIENTES POR AVION</a><br><br>
                                <a class="dropdown-item" href="FacturadoMes.jsp">FACTURADO ULTIMOS 12 MESES</a><br><br>
                                <a class="dropdown-item" href="IngresosAño.jsp">INGRESOS POR AÑO</a><br><br>
                                <a class="dropdown-item" href="TiposDeAviones.jsp">TIPOS DE AVION</a><br><br>
                                <a class="dropdown-item" href="RutasMasVentas.jsp">RUTAS CON MAS VENTAS</a><br><br>
                            </div>
                        </li>
                    </ul>
                </div>

            </div>
        </nav>



        <div class="contenedor">
            <div class="box">
                <div class="row">
                    <div class="col-lg-12">
                        <hr>
                        <h2 class="intro-text text-center">AEROLÍNEA UNA |
                            <strong>REALIZAR PAGO</strong>
                        </h2>
                        <hr>
                    </div>
                </div>

                <br><br>
                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-4 col-sm-4 col-xs-4"></div>
                        <div class="col-md-4 col-sm-4 col-xs-4 " id="tipoDeCambio"></div>
                        <div class="col-md-4 col-sm-4 col-xs-4"></div>
                    </div>
                </div>
                <br><br>
                <div class="row">

                    <form action="#" class="credit-card-div">
                        <div class="panel panel-default" >
                            <div class="panel-heading">

                                <div class="row ">
                                    <div class="col-md-12">
                                        <input type="text" class="form-control" placeholder="Número de la Tarjeta" />
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="col-md-3 col-sm-3 col-xs-3">
                                        <span class="help-block text-muted small-font" > Mes Expiración</span>
                                        <input type="text" class="form-control" placeholder="MM" />
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-3">
                                        <span class="help-block text-muted small-font" >  Año Expiración</span>
                                        <input type="text" class="form-control" placeholder="AA" />
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-3">
                                        <span class="help-block text-muted small-font" >  CCV</span>
                                        <input type="text" class="form-control" placeholder="CCV" />
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-3">
                                        <img src="img/ccv.jpg" class="img-rounded"  width="200" height="100"/>
                                    </div>
                                </div>
                                <div class="row ">
                                    <br>
                                    <div class="col-md-12 pad-adjust">

                                        <input type="text" class="form-control" placeholder="Nombre de la tarjeta" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 pad-adjust">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" checked class="text-muted"> De acuerdo con los términos de pago <a href="https://www.paypal.com/mx/webapps/mpp/website-payments-standard"> Leer más ?</a>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="col-md-6 col-sm-6 col-xs-6 pad-adjust">
                                        <input type="submit"  class="btn btn-danger" value="CANCELAR" />
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-6 pad-adjust">
                                        <input type="submit"  class="btn btn-warning btn-block" value="PAGAR" />
                                    </div>
                                </div>

                            </div>
                        </div>
                    </form>


                </div>             
            </div>
        </div>


        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
