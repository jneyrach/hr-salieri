
    package sshr.web.servlet.asistencia;

    import sshr.domainmodel.asistencia.*;
    import sshr.asistencia.*;
    
    import java.io.*;
    import javax.servlet.http.*;


    public class CrudUpdateTipoDia extends HttpServlet {

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
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            
            try {
                    String codigo = request.getParameter("codigo");
                    String nombre = request.getParameter("nombre");
                    String descripcion = request.getParameter("descripcion");
                
                    Long id = Long.parseLong( request.getParameter("ID") );
                
                    AsistenciaApplication.updateTipoDia(id,codigo,nombre,descripcion);
                
                    out.println("OK");
            
            } catch (Exception ex) {
            
                        out.println("ERROR: " + ex.getMessage());
            }
            
            out.flush();
            out.close();
        }

    }
