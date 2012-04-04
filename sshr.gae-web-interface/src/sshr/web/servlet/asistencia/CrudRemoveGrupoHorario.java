package sshr.web.servlet.asistencia;

import sshr.asistencia.AsistenciaApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrudRemoveGrupoHorario extends HttpServlet {

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
				Long id = Long.parseLong( request.getParameter("ID") );
			
				AsistenciaApplication.removeGrupoHorario(id);
			
				out.println("OK");
		
		} catch (Exception ex) {
		
					out.println("ERROR: " + ex.getMessage());
					ex.printStackTrace();
		}
		
		out.flush();
		out.close();
	}




}