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
    <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        
        <!--  PAGINATION plugin -->
        <link href="css/jquery.bs_pagination.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.bs_pagination.min.js" type="text/javascript"></script>
        <script src="js/en.min.js" type="text/javascript"></script>

        <link href="css/css.css" rel="stylesheet" type="text/css"/>
        <script src="js/utils.js" type="text/javascript"></script>
        <script src="js/GestionTipoAviones.js" type="text/javascript"></script>


    </head>

    
    
    <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" id="myModalTitle">Modal Header</h4>
                    </div>
                    <div class="modal-body" id="myModalMessage">
                        <p>This is a small modal.</p>
                    </div>
                    <div class="modal-footer" id="myModalFooter">
                    </div>
                </div>
            </div>
        </div>
    
    
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
                            <strong>GESTION TIPOS DE AVIONES:</strong>
                        </h2>
                        <hr>
                    </div>
                </div>
                
                <div class="col-sm-12">
                        <form role="form" onsubmit="return false;" id="formTiposAviones" class="form-horizontal centered">
                            <div class="form-group" id="groupID">
                                <div class="col-sm-4" style="text-align: right; vertical-align: middle;">
                                    <p><b>Buscar por id del avión:</b></p>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="nombrePersona" placeholder="Digite el id del avión">
                                </div>
                                <div class="col-sm-4">
                                    <button type="button" id="buscar" class="btn btn-info centered" >
                                        Buscar <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>


                <form role="form" onsubmit="return false;" class="form-horizontal" id="formAviones">
                    <div class="form-group">
                        <label for="identificador" class="col-sm-2 control-label">Identificador</label>
                        <div class="col-sm-10" id="groupId">
                            <input type="text" class="form-control" id="identificador">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="anno" class="col-sm-2 control-label">Año</label>
                        <div class="col-sm-10" id="groupAno">
                            <input type="text" class="form-control" id="ano">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="marca" class="col-sm-2 control-label">Marca</label>
                        <div class="col-sm-10" id="groupMarca">
                            <input type="text" class="form-control" id="marca">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="modelo" class="col-sm-2 control-label">Modelo</label>
                        <div class="col-sm-10" id="groupModelo">
                            <input type="text" class="form-control" id="modelo">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cantFilas" class="col-sm-2 control-label">Cantidad Filas</label>
                        <div class="col-sm-10" id="groupCantFilas">
                            <input type="number" class="form-control" name="quantity" id="cantFilas" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="asientosFila" class="col-sm-2 control-label">Asientos por Fila</label>
                        <div class="col-sm-10"id="groupCantAsientosFila">
                            <input type="number" class="form-control" name="quantity" id="cantAsientosFila" >
                        </div>
                    </div>

                     <div class="form-group">
                        <input type="hidden" value="agregarAvion" id="avionAction"/>
                        <div class="col-sm-offset-2 col-sm-3">
                            <button  type="submit" class="btn btn-default" id="enviar">Registrar</button>
                            <button  type="reset" class="btn btn-danger hidden" id="cancelar">Cancelar Edicion</button>
                        </div>
                        
                        <div class="col-sm-5">
                    <div class="form-group height25" >
                                <div class="hiddenDiv" id="mesajeResult">
                                    <strong id="mesajeResultNeg">Info!</strong> 
                                    <span id="mesajeResultText">This alert box could indicate a neutral informative change or action.</span>
                                </div>
                            </div>
                        </div>
                    
                    </div>
                </form>
                  <div class="container">
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-hover" id="tablaAviones">
                            </table>
                            <div class="col-md-12 text-center">
                                <ul class="pagination pagination-lg pager" id="myPager"></ul>
                            </div>
                        </div>
                    </div>




                </div>             
            </div>

    </body>

</html>
