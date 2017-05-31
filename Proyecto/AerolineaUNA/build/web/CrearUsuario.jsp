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
                                <a class="dropdown-item" href="AsignarAviones.jsp">ASIGNAR AVIONES</a><br><br>
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
                            <strong>CREAR CUENTA:</strong>
                        </h2>
                        <hr>
                    </div>
                </div>
                
                <div class="col-sm-12">
                        <form role="form" onsubmit="return false;" id="formPersonas" class="form-horizontal centered">
                            <div class="form-group" id="groupCedula">
                                <div class="col-sm-4" style="text-align: right; vertical-align: middle;">
                                    <p><b>Buscar por nombre de la persona:</b></p>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="nombrePersona" placeholder="Digite el nombre de la persona">
                                </div>
                                <div class="col-sm-4">
                                    <button type="button" id="buscar" class="btn btn-info centered" >
                                        Buscar <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>

                <form class="form-horizontal">

                    <div class="form-group">
                        <label class="control-label col-xs-3">CORREO: </label>
                        <div class="col-xs-9">
                            <input type="email" class="form-control" id="inputEmail" placeholder="Correo">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">CONTRASEÑA</label>
                        <div class="col-xs-9">
                            <input type="password" class="form-control" id="inputPassword" placeholder="Contraseña">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">NOMBRE:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" placeholder="Nombre">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">PRIMER APELLIDO:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" placeholder="Primer Apellido">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">SEGUNDO APELLIDO:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" placeholder="Segundo Apellido">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" >TELÉFONO 1:</label>
                        <div class="col-xs-9">
                            <input type="tel" class="form-control" placeholder="Telefono1">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-xs-3" >TELÉFONO 2:</label>
                        <div class="col-xs-9">
                            <input type="tel" class="form-control" placeholder="Telefono2">
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-xs-3">DIRECCIÓN:</label>
                        <div class="col-xs-9">
                            <textarea rows="3" class="form-control" placeholder="Dirección"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-xs-3">F. NACIMIENTO:</label>
                        <div class="col-xs-9">
                            <input type="date" name="fecha" id="salida">
                        </div>
                    </div>  

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">                               
                            <br><br>
                            <input type="submit" class="btn btn-primary" value="Enviar">
                            <input type="reset" class="btn btn-default" value="Limpiar">
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
