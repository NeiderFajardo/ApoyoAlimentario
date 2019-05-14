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

            PrintWriter out = resp.getWriter();
            out.write("<html>" +
                    "<body>" +
                    "<h1>El usuario: "+usuario+" ingreso con éxito</h1>" +
                    "</body>" +
                    "</html>");
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
}
