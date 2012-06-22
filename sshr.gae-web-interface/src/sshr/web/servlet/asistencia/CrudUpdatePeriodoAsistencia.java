
    package sshr.web.servlet.asistencia;

    import sshr.domainmodel.asistencia.*;
    import sshr.asistencia.*;
    import sshr.domainmodel.util.*;
    
    import java.util.*;
    import java.io.*;
    import javax.servlet.http.*;


    public class CrudUpdatePeriodoAsistencia extends HttpServlet {

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
                    String fechaDeInicio = request.getParameter("fechaDeInicio");
                    String fechaDeTermino = request.getParameter("fechaDeTermino");
                
                    Long id = Long.parseLong( request.getParameter("ID") );
                
                    AsistenciaApplication.updatePeriodoAsistencia(id,(String)ParseAndValidationUtils.parseParameterFromString( request.getParameter("codigo"), String.class ),(String)ParseAndValidationUtils.parseParameterFromString( request.getParameter("nombre"), String.class ),(String)ParseAndValidationUtils.parseParameterFromString( request.getParameter("descripcion"), String.class ),(Date)ParseAndValidationUtils.parseParameterFromString( request.getParameter("fechaDeInicio"), Date.class ),(Date)ParseAndValidationUtils.parseParameterFromString( request.getParameter("fechaDeTermino"), Date.class ));
                
                    out.println("OK");
            
            } catch (Exception ex) {
            
                        out.println("ERROR: " + ex.getMessage());
            }
            
            out.flush();
            out.close();
        }

    }
