package sshr.web.servlet.asistencia;

import sshr.domainmodel.asistencia.PerfilHorario;

import sshr.asistencia.AsistenciaApplication;

import java.util.*;

import java.io.*;

import javax.servlet.http.*;


import javax.xml.bind.*;
import javax.xml.bind.annotation.*;


public class CrudFindAllPerfilHorario extends HttpServlet {

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
				List<PerfilHorario> lph = AsistenciaApplication.findAllPerfilHorario();


				if (request.getParameter("format").equals("XML")) {

						CrudTransferObject<PerfilHorario> to = new CrudTransferObject<PerfilHorario>();
						to.setXmlDataRows(lph);

						out.println( CrudXMLHelper.marshal(to) );
				}


		} catch (Exception ex) {

					out.println("ERROR");
		}

		out.flush();
		out.close();
	}




}
