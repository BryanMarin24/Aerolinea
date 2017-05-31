<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title> AEROLÃNEA UNA</title>


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
        
            <div class="contenedor">
                <div id="navbar" class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" role="form">
                        <div class="form-group">
                            <input type="text" placeholder="Correo" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Contraseña" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-success btn-lg">Ingresar</button>              
                        <a href="CrearUsuario.jsp" class="btn btn-primary btn-lg active" role="button">Crear Cuenta</a>

                    </form>
                </div>
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

            <div class="row">
                <div class="box">
                    <div class="col-lg-12">
                        <hr>
                        <h2 class="intro-text text-center"> AEROLÍNEA UNA  |
                            <strong>Contactenos</strong>
                        </h2>
                        <hr>
                    </div>

                    <div class="col-md-4">
                        <p>Teléfono:
                            <strong>2225-9898</strong>
                        </p>
                        <p>Correo:
                            <strong><a href="mailto:name@example.com">aerolineauna@gmail.com</a></strong>
                        </p>
                        <p>Dirección:
                            <strong>UNIVERSIDAD NACIONAL 
                                <br>HEREDIA, LAGUNILLA</strong>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>

            <div class="row">
                <div class="box">
                    <div class="col-lg-12">
                        <hr>
                        <h2 class="intro-text text-center">Consultas:                   
                        </h2>
                        <hr>
                        <form role="form">
                            <div class="row">
                                <div class="form-group col-lg-4">
                                    <label>Nombre</label>
                                    <input type="text" class="form-control">
                                </div>
                                <div class="form-group col-lg-4">
                                    <label>Correo Electrónico</label>
                                    <input type="email" class="form-control">
                                </div>
                                <div class="form-group col-lg-4">
                                    <label>Teléfono</label>
                                    <input type="tel" class="form-control">
                                </div>
                                <div class="clearfix"></div>
                                <div class="form-group col-lg-12">
                                    <label>Descripción</label>
                                    <textarea class="form-control" rows="6"></textarea>
                                </div>
                                <div class="form-group col-lg-12">
                                    <input type="hidden" name="save" value="contact">
                                    <button type="submit" class="btn btn-default">Enviar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
