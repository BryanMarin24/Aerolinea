package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Pago_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("        <title> AEROLÍNEA UNA</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"css/business-casual.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <link href=\"css/pago.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <script src=\"js/pago.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"page-header\">\r\n");
      out.write("            <div class=\"brand\"> AEROLÍNEA UNA </div>\r\n");
      out.write("            <div class=\"address-bar\">COSTA RICA | HEREDIA | LAGUNILLA</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-default\" role=\"navigation\">\r\n");
      out.write("            <div class=\"contenedor\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.jsp\">AEROLÍNEA UNA </a>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\" style=\"font-size:10px\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav\">\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"index.jsp\">INICIO</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("\r\n");
      out.write("                        <li>         \r\n");
      out.write("                            <a href=\"BuscarVuelos.jsp\">BUSCAR VUELOS</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"Contactenos.jsp\">CONTACTENOS</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("\r\n");
      out.write("                        <li class=\"nav-item dropdown\">\r\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                                ADMINISTRACION\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n");
      out.write("                                <a class=\"dropdown-item\" href=\"GestionTipoAviones.jsp\">AGREGAR AVIONES</a><br><br>\r\n");
      out.write("\r\n");
      out.write("                                <a class=\"dropdown-item\" href=\"GestionHorarios.jsp\">GESTION DE HORARIOS</a><br><br>\r\n");
      out.write("                                <a class=\"dropdown-item\" href=\"GestionRutas.jsp\">GESTION DE RUTAS</a><br><br>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </li>\r\n");
      out.write("\r\n");
      out.write("                        <li class=\"nav-item dropdown\">\r\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                                REPORTES\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n");
      out.write("                                <a class=\"dropdown-item\" href=\"ClientesPorAvion.jsp\">CLIENTES POR AVION</a><br><br>\r\n");
      out.write("                                <a class=\"dropdown-item\" href=\"FacturadoMes.jsp\">FACTURADO ULTIMOS 12 MESES</a><br><br>\r\n");
      out.write("                                <a class=\"dropdown-item\" href=\"IngresosAño.jsp\">INGRESOS POR AÑO</a><br><br>\r\n");
      out.write("                                <a class=\"dropdown-item\" href=\"TiposDeAviones.jsp\">TIPOS DE AVION</a><br><br>\r\n");
      out.write("                                <a class=\"dropdown-item\" href=\"RutasMasVentas.jsp\">RUTAS CON MAS VENTAS</a><br><br>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"contenedor\">\r\n");
      out.write("            <div class=\"box\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("                        <hr>\r\n");
      out.write("                        <h2 class=\"intro-text text-center\">AEROLÍNEA UNA |\r\n");
      out.write("                            <strong>REALIZAR PAGO</strong>\r\n");
      out.write("                        </h2>\r\n");
      out.write("                        <hr>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <br><br>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                        <div class=\"col-md-4 col-sm-4 col-xs-4\"></div>\r\n");
      out.write("                        <div class=\"col-md-4 col-sm-4 col-xs-4 \" id=\"tipoDeCambio\"></div>\r\n");
      out.write("                        <div class=\"col-md-4 col-sm-4 col-xs-4\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br><br>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                    <form action=\"#\" class=\"credit-card-div\">\r\n");
      out.write("                        <div class=\"panel panel-default\" >\r\n");
      out.write("                            <div class=\"panel-heading\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"row \">\r\n");
      out.write("                                    <div class=\"col-md-12\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Número de la Tarjeta\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row \">\r\n");
      out.write("                                    <div class=\"col-md-3 col-sm-3 col-xs-3\">\r\n");
      out.write("                                        <span class=\"help-block text-muted small-font\" > Mes Expiración</span>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"MM\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-3 col-sm-3 col-xs-3\">\r\n");
      out.write("                                        <span class=\"help-block text-muted small-font\" >  Año Expiración</span>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"AA\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-3 col-sm-3 col-xs-3\">\r\n");
      out.write("                                        <span class=\"help-block text-muted small-font\" >  CCV</span>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"CCV\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-3 col-sm-3 col-xs-3\">\r\n");
      out.write("                                        <img src=\"img/ccv.jpg\" class=\"img-rounded\"  width=\"200\" height=\"100\"/>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row \">\r\n");
      out.write("                                    <br>\r\n");
      out.write("                                    <div class=\"col-md-12 pad-adjust\">\r\n");
      out.write("\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Nombre de la tarjeta\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-md-12 pad-adjust\">\r\n");
      out.write("                                        <div class=\"checkbox\">\r\n");
      out.write("                                            <label>\r\n");
      out.write("                                                <input type=\"checkbox\" checked class=\"text-muted\"> De acuerdo con los términos de pago <a href=\"https://www.paypal.com/mx/webapps/mpp/website-payments-standard\"> Leer más ?</a>\r\n");
      out.write("                                            </label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row \">\r\n");
      out.write("                                    <div class=\"col-md-6 col-sm-6 col-xs-6 pad-adjust\">\r\n");
      out.write("                                        <input type=\"submit\"  class=\"btn btn-danger\" value=\"CANCELAR\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-6 col-sm-6 col-xs-6 pad-adjust\">\r\n");
      out.write("                                        <input type=\"submit\"  class=\"btn btn-warning btn-block\" value=\"PAGAR\" />\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>             \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- jQuery -->\r\n");
      out.write("        <script src=\"js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap Core JavaScript -->\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
