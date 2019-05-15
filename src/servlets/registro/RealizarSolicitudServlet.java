package servlets.registro;

import VO.PdfVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;


@WebServlet("/realizarSolicitudServlet")
public class RealizarSolicitudServlet  extends HttpServlet {
    Part cartaAdmision = null;
    Part certificadoEstrato = null;
    Part reciboPublico = null;
    Part reciboUniversidad = null;
    Part certificadoDesplazamiento = null;
    Part certificadoDiscapacidad = null;
    Part cartaIndependiente = null;
    Part cartaIngresoMensual = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtener cada uno de los pdf subido por el estudiante
        resp.sendRedirect("solicitudRealizada.html");

        InputStream inputstream = null;
        try{
            cartaAdmision = req.getPart("cartaAdmision");
            inputstream = cartaAdmision.getInputStream();
            PdfVO pdfCartaAdmision = new PdfVO();
            pdfCartaAdmision.setArchivopdf(inputstream);
            pdfCartaAdmision.setNombrepdf("cartaAdmision");


            certificadoEstrato = req.getPart("certificadoEstrato");
            inputstream = certificadoEstrato.getInputStream();
            PdfVO pdfCertificadoEstrato = new PdfVO();
            pdfCertificadoEstrato.setArchivopdf(inputstream);
            pdfCertificadoEstrato.setNombrepdf("certificadoEstrato");


            reciboPublico = req.getPart("reciboPublico");
            inputstream = reciboPublico.getInputStream();
            PdfVO pdfReciboPublico = new PdfVO();
            pdfReciboPublico.setArchivopdf(inputstream);
            pdfReciboPublico.setNombrepdf("reciboPublico");


            reciboUniversidad = req.getPart("reciboUniversidad");
            inputstream = reciboUniversidad.getInputStream();
            PdfVO pdfReciboUniversidad = new PdfVO();
            pdfReciboUniversidad.setArchivopdf(inputstream);
            pdfReciboUniversidad.setNombrepdf("reciboUniversidad");


            certificadoDesplazamiento = req.getPart("certificadoDesplazamiento");
            inputstream = certificadoDesplazamiento.getInputStream();
            if(inputstream != null){
                PdfVO pdfCertificadoDesplazamiento = new PdfVO();
                pdfCertificadoDesplazamiento.setArchivopdf(inputstream);
                pdfCertificadoDesplazamiento.setNombrepdf("certificadoDesplazamiento");
            }


            certificadoDiscapacidad = req.getPart("certificadoDiscapacidad");
            inputstream = certificadoDesplazamiento.getInputStream();
            if(inputstream != null){
                PdfVO pdfCertificadoDiscapacidad = new PdfVO();
                pdfCertificadoDiscapacidad.setArchivopdf(inputstream);
                pdfCertificadoDiscapacidad.setNombrepdf("certificadoDiscapacidad");
            }


            cartaIndependiente = req.getPart("cartaIndependiente");
            inputstream = cartaIndependiente.getInputStream();
            if(inputstream != null){
                PdfVO pdfCartaIndependiente = new PdfVO();
                pdfCartaIndependiente.setArchivopdf(inputstream);
                pdfCartaIndependiente.setNombrepdf("cartaIndependiente");
            }


            cartaIngresoMensual = req.getPart("cartaIngresoMensual");
            inputstream = cartaIngresoMensual.getInputStream();
            if (inputstream != null){
                PdfVO pdfCartaIngresoMensual = new PdfVO();
                pdfCartaIngresoMensual.setArchivopdf(inputstream);
                pdfCartaIngresoMensual.setNombrepdf("cartaIngresoMensual");
            }
        }catch(Exception ex){
            System.out.println("fichero: "+ex.getMessage());
        }
    }
}
