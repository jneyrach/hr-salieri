
    package sshr.web.servlet.asistencia;

    import sshr.domainmodel.asistencia.*;
    import sshr.asistencia.*;
    
    import java.io.*;
    import javax.servlet.http.*;


    public class CrudFindPerfilHorario extends HttpServlet {

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
                    Long id = Long.parseLong( request.getParameter("id") );
            
                    PerfilHorario e = AsistenciaApplication.findPerfilHorario( id );
                
            } catch (Exception ex) {
            
                        out.println("ERROR: " + ex.getMessage());
            }
            
            out.flush();
            out.close();
        }

    }
    
