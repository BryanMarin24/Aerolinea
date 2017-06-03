
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
                            <strong>BUSCAR AVIONES:</strong>
                        </h2>
                        <hr>
                    </div>
                </div>

                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="identificador" class="col-sm-2 control-label">
                            <input type="checkbox" value="">
                            Identificador
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="identificador">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="anno" class="col-sm-2 control-label">
                            <input type="checkbox" value="">
                            Año
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="anno">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="marca" class="col-sm-2 control-label">
                            <input type="checkbox" value="">
                            Marca
                        </label>
                        <div class="col-sm-10">
                            <select class="form-control" id="marca">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="modelo" class="col-sm-2 control-label">
                            <input type="checkbox" value="">
                            Modelo
                        </label>
                        <div class="col-sm-10">
                            <select class="form-control" id="modelo">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pasajeros" class="col-sm-2 control-label">
                            <input type="checkbox" value="">
                            Cantidad de Pasajeros
                        </label>
                        <div class="col-sm-10">
                            <select class="form-control" id="pasajeros">

                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="filas" class="col-sm-2 control-label">
                            <input type="checkbox" value="">
                            Cantidad de Filas
                        </label>
                        <div class="col-sm-10">
                            <select class="form-control" id="filas">

                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="asientosFila" class="col-sm-2 control-label">
                            <input type="checkbox" value="">
                            Asientos por fila
                        </label>
                        <div class="col-sm-10">
                            <select class="form-control" id="asientosFila">

                            </select>
                        </div>
                    </div>
                </form>


            </div>             
        </div>


        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
