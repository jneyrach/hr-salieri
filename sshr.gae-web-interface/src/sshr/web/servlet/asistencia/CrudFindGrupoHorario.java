package sshr.web.servlet.asistencia;

import sshr.domainmodel.asistencia.GrupoHorario;

import sshr.asistencia.AsistenciaApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrudFindGrupoHorario extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		this.processRequest(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		this.processRequest(request, response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		try {
				long id = Long.parseLong( request.getParameter("id") );
		
				GrupoHorario gh = AsistenciaApplication.findGrupoHorario( id );
			
				out.println("GrupoHorario: " + gh.getCodigo() + " - " + gh.getDesc());
		
		} catch (Exception ex) {
		
					out.println("ERROR: " + ex.getMessage());
		}
		
		out.flush();
		out.close();
	}




}
