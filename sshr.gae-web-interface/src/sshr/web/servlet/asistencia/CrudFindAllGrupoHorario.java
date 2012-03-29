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


				if (request.getParameter("format").equals("XML")) {

						CrudXMLTransferObject<GrupoHorario> to = new CrudXMLTransferObject<GrupoHorario>();
						to.setDataRows(lgh);

						out.println( CrudXMLHelper.marshal(to) );
				}


		} catch (Exception ex) {

					ex.printStackTrace();
					out.println("ERROR: " + ex.getMessage());
		}

		out.flush();
		out.close();
	}




}
