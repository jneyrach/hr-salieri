package sshr.web.servlet.asistencia;

import sshr.asistencia.AsistenciaApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrudCreateGrupoHorario extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		this.processRequest(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		this.processRequest(request, response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		String desc   = request.getParameter("desc");
		String codigo = request.getParameter("codigo");
	
		try {
				AsistenciaApplication.createGrupoHorario(desc, codigo);
			
				out.println("OK");
		
		} catch (Exception ex) {
		
					out.println("ERROR: " + ex.getMessage());
		}
		
		out.flush();
		out.close();
	}




}
