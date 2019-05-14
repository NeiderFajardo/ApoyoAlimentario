package servlets.inicio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario, contrasena;
        usuario = req.getParameter("correo").trim();
        contrasena = req.getParameter("contrasena").trim();
        resp.setContentType("text/html");
        if(verificarCuenta(usuario, contrasena)){
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            //Se debe especificar el rol del usuario que ingreso al sistema, esto se hará depende del rol en la conexión de la base
            //de datos
            out.write(armarPaginaPrincipal("admin"));
            out.close();
        }else{
            resp.setContentType("text/html");
            PrintWriter outError = resp.getWriter();
            outError.write("<html lang=\"en\" dir=\"ltr\">\n" +
                    "  <head>\n" +
                    "    <meta charset=\"utf-8\">\n" +
                    "    <link rel=\"stylesheet\", type=\"text/css\", href=\"estilos/styles.css\"/>\n" +
                    "    <title>Datos Iconrrectos\n" +
                    "    </title>\n" +
                    "  </head>\n" +
                    "  <header class=\"titulo\">\n" +
                    "    <h1>Programa Apoyo Alimentario</h1>\n" +
                    "    <img src=\"imgs/logoud_0.png\" alt=\"logoUd\" width=\"100\" height=\"100\">\n" +
                    "  </header>\n" +
                    "  <body>\n" +
                    "    <div class=\"panel\">\n" +
                    "      <h4>Usuario o contraseña incorrectos</h4>\n" +
                    "    </div>\n" +
                    "  </body>\n" +
                    "</html>");

            outError.close();
        }

    }

    private boolean verificarCuenta(String usuario, String contrasena){
        boolean exito = false;
        //En esta parte se debe conectar con la base de datos para berificar si el usuario ya esta registrado en el sistema
        //por ahora solo se podrá ingresar con el usuario: admin, contraseña: admin
        if (usuario.equals("correo@correo.com") && contrasena.equals("admin"))
            exito = true;

        return exito;

    }
    //Este método armara la vista Principal del aplicativo, en caso de que sea un estudiante se le habilitaran algunas opciones
    //y se bloquearan otras, de igual forma si es administrador o revisor
    //rol: Rol del usuario en la base de datos, roles posibles: {estudiante, admin, revisor}
    private String armarPaginaPrincipal(String rol){
        String pagina = "";
        pagina += "<!DOCTYPE html>\n" +
                "<html lang=\"en  \" dir=\"ltr\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
                "    <link rel=\"stylesheet\", type=\"text/css\", href=\"estilos/styles.css\"/>\n" +
                "    <link rel=\"stylesheet\", type=\"text/css\", href=\"estilos/principal.css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Heebo\" rel=\"stylesheet\">\n" +
                "    <title>Apoyo Alimentario</title>\n" +
                "</head>\n" +
                "<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n" +
                "\n" +
                "    <a class=\"navbar-brand\" href=\"#\">\n" +
                "        <img src=\"imgs/logoud_0.png\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n" +
                "        Apoyo UD\n" +
                "    </a>\n" +
                "    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                "        <ul class=\"navbar-nav mr-auto\">\n" +
                "            <li class=\"nav-item\">\n";
                if (rol.equalsIgnoreCase("estudiante")) {
                    pagina +=  "                <a class=\"nav-link\" href=\"#\">Mi solicitud</a>\n";
                }else if(rol.equalsIgnoreCase("admin")) {
                    pagina +=  "                <a class=\"nav-link disabled\" href=\"#\">Mi solicitud</a>\n";
                }else if(rol.equalsIgnoreCase("revisor")){
                    pagina +=  "                <a class=\"nav-link disabled\" href=\"#\">Mi solicitud</a>\n";
                }
                pagina +=      "            </li>\n" +
                "            <li class=\"nav-item dropdown\">\n" +
                "                <a class=\"nav-link\" href=\"#\">Mis Datos</a>\n" +
                "            </li>\n" +
                "            <li class=\"nav-item\">\n";
                if(rol.equalsIgnoreCase("estudiante")) {
                 pagina+=   "                <a class=\"nav-link disabled\" href=\"#\">Revisar Solicitudes</a>\n";
                }else if(rol.equalsIgnoreCase("admin")){
                    pagina+=   "                <a class=\"nav-link disabled\" href=\"#\">Revisar Solicitudes</a>\n";
                }else if(rol.equalsIgnoreCase("revisor")){
                    pagina+=   "                <a class=\"nav-link\" href=\"#\">Revisar Solicitudes</a>\n";
                }
                pagina +="            </li>\n" +
                "            <li class=\"nav-item\">\n";
                if (rol.equalsIgnoreCase("estudiante")) {
                    pagina += "                <a class=\"nav-link disabled\" href=\"#\">Registrar Ususario</a>\n";
                }else if(rol.equalsIgnoreCase("admin")){
                    pagina += "                <a class=\"nav-link\" href=\"registro.html\">Registrar Ususario</a>\n";
                }else if(rol.equalsIgnoreCase("revisor")){
                    pagina += "                <a class=\"nav-link disabled\" href=\"#\">Registrar Ususario</a>\n";
                }
                pagina += "            </li>\n" +
                "            <li class=\"nav-item\">\n" +
                "                <a class=\"nav-link\" href=\"index.html\">Cerrar Sesion</a>\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "    </div>\n" +
                "</nav>\n" +
                "<header class=\"titulo\">\n" +
                "    <h1>Programa Apoyo Alimentario</h1>\n" +
                "    <img src=\"imgs/logoud_0.png\" alt=\"logoUd\" width=\"100\" height=\"100\">\n" +
                "</header>\n" +
                "<body>\n" +
                "<div class=\"panel1\">\n" +
                "    <h3 id=\"banner\">Si no has realizado tú solicitud para ser parte del programa de apoyo alimetario,\n" +
                "        puedes hacerla aquí:</h3>\n";
                if (rol.equalsIgnoreCase("estudiante")) {
                 pagina +=   "    <a href=\"realizarSolicitud.html\"><button id=\"registroSolicitud\" class=\"ingresar\" type=\"submit\" value=\"guardar\">Realizar Solicitud</button></a>\n";
                }else if(rol.equalsIgnoreCase("admin") || rol.equalsIgnoreCase("revisor")){
                    pagina +=   "    <a href=\"#\"><button id=\"registroSolicitud\" class=\"ingresar\" disabled type=\"submit\" value=\"guardar\">Realizar Solicitud</button></a>\n";
                }
                pagina +="</div>\n" +
                "</body>\n" +
                "</html>\n";


        return pagina;
    }
}
