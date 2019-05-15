package servlets.inicio;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/registroServlet")
public class RegistroServlet extends HttpServlet {
    String primerNombre, segundoNombre, primerApellido, segundoApellido;
    String correo, codigo, contrasena;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        crearUsuario(req);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write(armarPaginaPrincipal());
        out.close();
    }


    private void crearUsuario(HttpServletRequest req){
        primerNombre = req.getParameter("nombresUsuario").split(" ")[0];
        segundoNombre= req.getParameter("nombresUsuario").split(" ")[1];
        primerApellido = req.getParameter("apellidosUsuario").split(" ")[0];
        segundoApellido = req.getParameter("apellidosUsuario").split(" ")[1];
        correo = req.getParameter("correoUsuario");
        codigo = req.getParameter("codigoUsuario");
        contrasena = req.getParameter("contrasena");
        //En esta parte se creara el VO del usuario para ser agregado posteriormente a la base de datos
        //Especificar si es necesario otros atributos
    }

    private String armarPaginaPrincipal(){
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
                "            <li class=\"nav-item\">\n"+
                "                <a class=\"nav-link disabled\" href=\"#\">Mi solicitud</a>\n"+
                "            </li>\n" +
                "            <li class=\"nav-item dropdown\">\n" +
                "                <a class=\"nav-link\" href=\"#\">Mis Datos</a>\n" +
                "            </li>\n" +
                "            <li class=\"nav-item\">\n"+
                "                <a class=\"nav-link disabled\" href=\"#\">Revisar Solicitudes</a>\n"+
                "            </li>\n" +
                "            <li class=\"nav-item\">\n"+
                "                <a class=\"nav-link\" href=\"registro.html\">Registrar Ususario</a>\n"+
                "            </li>\n" +
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
            pagina +=   "    <a href=\"#\"><button id=\"registroSolicitud\" class=\"ingresar\" disabled type=\"submit\" value=\"guardar\">Realizar Solicitud</button></a>\n";

        pagina +="</div>\n" +
                "</body>\n" +
                "</html>\n";


        return pagina;
    }
    private boolean verificarSolicitud(){
        boolean solicitud = false;
        //Se realiza el proceso de consulta en la base de datos para saber si el usuario ya hizo la solicitud previamente

        return solicitud;
    }

}
