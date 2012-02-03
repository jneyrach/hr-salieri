package sshr.web.servlet.asistencia;

import sshr.domainmodel.asistencia.GrupoHorario;

import sshr.asistencia.AsistenciaApplication;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrudFindAllGrupoHorario extends HttpServlet {

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
				List<GrupoHorario> lgh = AsistenciaApplication.findAllGrupoHorario();
			
				CrudJSONTransferObject to = new CrudJSONTransferObject();
				to.addColumn("Nombre");
				to.addColumn("Descripción");
				to.addColumn("Creado");
				to.addColumn("Actualizado");
				
				to.addKey("ID");
				
				for (GrupoHorario gh: lgh) {
					List<String> kr = new ArrayList<String>();
					kr.add(gh.getId().toString());
					to.addKeyRow(kr);
				
					List<String> dr = new ArrayList<String>();
					dr.add(gh.getDesc());
					dr.add(gh.getCodigo());
					dr.add(gh.getCreatedOn().toString());
					dr.add(gh.getUpdatedOn().toString());
					
					to.addDataRow(dr);
				}
			
				to.prepareToSerialize();
				
				out.println( CrudJSONHelper.serialize(to) );
		
		} catch (Exception ex) {
		
					out.println("ERROR: " + ex.getMessage());
		}
		
		out.flush();
		out.close();
	}




}
