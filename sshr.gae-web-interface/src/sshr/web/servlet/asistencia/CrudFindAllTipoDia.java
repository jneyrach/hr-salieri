
    package sshr.web.servlet.asistencia;

    import sshr.domainmodel.asistencia.*;
    import sshr.asistencia.*;
    
    import java.io.*;
    import javax.servlet.http.*;


    public class CrudFindAllTipoDia extends HttpServlet {

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
                    List<TipoDia> l = AsistenciaApplication.findAllTipoDia();


                    if (request.getParameter("format").equals("XML")) {

                            CrudTransferObject<TipoDia> to = new CrudTransferObject<TipoDia>();
                            to.setXmlDataRows(l);
                    }


            } catch (Exception ex) {

                        out.println("ERROR: " + ex.getMessage());
            }

            out.flush();
            out.close();
        }

    }
    
