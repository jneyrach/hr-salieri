
    package sshr.web.servlet.asistencia;

    import sshr.domainmodel.asistencia.*;
    import sshr.asistencia.*;
    import sshr.domainmodel.util.*;
    
    import java.util.*;
    import java.io.*;
    import javax.servlet.http.*;


    public class CrudCreatePeriodoAsistencia extends HttpServlet {

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
            
            
            String codigo = (String)ParseAndValidationUtils.parseParameterFromString( request.getParameter("codigo"), String.class );
            String nombre = (String)ParseAndValidationUtils.parseParameterFromString( request.getParameter("nombre"), String.class );
            String descripcion = (String)ParseAndValidationUtils.parseParameterFromString( request.getParameter("descripcion"), String.class );
            Date fechaDeInicio = (Date)ParseAndValidationUtils.parseParameterFromString( request.getParameter("fechaDeInicio"), Date.class );
            Date fechaDeTermino = (Date)ParseAndValidationUtils.parseParameterFromString( request.getParameter("fechaDeTermino"), Date.class );
        
            try {
                    AsistenciaApplication.createPeriodoAsistencia(codigo,nombre,descripcion,fechaDeInicio,fechaDeTermino);
                
                    out.println("OK");
            
            } catch (Exception ex) {
            
                        out.println("ERROR: " + ex.getMessage());
            }
            
            out.flush();
            out.close();
        }

    }
    
