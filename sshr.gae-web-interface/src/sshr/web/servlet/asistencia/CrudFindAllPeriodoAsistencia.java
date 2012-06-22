
    package sshr.web.servlet.asistencia;

    import sshr.domainmodel.asistencia.*;
    import sshr.asistencia.*;
    import sshr.domainmodel.util.*;
    
    import java.util.*;
    import java.io.*;
    import javax.servlet.http.*;


    public class CrudFindAllPeriodoAsistencia extends HttpServlet {

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

            this.processRequest(request, response);
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            this.processRequest(request, response);
        }

        public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
            response.setDateHeader("Expires", 1);
            response.setContentType("text/xml");
            PrintWriter out = response.getWriter();

            try {
                    List<PeriodoAsistencia> l = AsistenciaApplication.findAllPeriodoAsistencia();


                    if (request.getParameter("format").equals("XML")) {

                            CrudTransferObject<PeriodoAsistencia> to = new CrudTransferObject<PeriodoAsistencia>();
                            to.setXmlDataRows(l);
                            
                            out.println( CrudXMLHelper.marshal(to) );
                    }


            } catch (Exception ex) {

                        out.println("ERROR: " + ex.getMessage());
            }

            out.flush();
            out.close();
        }

    }
    
