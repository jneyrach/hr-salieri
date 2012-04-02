package sshr.web.servlet.asistencia;

import sshr.domainmodel.asistencia.GrupoHorario;

import sshr.asistencia.AsistenciaApplication;

import java.util.*;

import java.io.*;

import javax.servlet.http.*;


import javax.xml.bind.*;
import javax.xml.bind.annotation.*;


public class CrudFindAllGrupoHorario extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		this.processRequest(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		this.processRequest(request, response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();

		try {
				List<GrupoHorario> lgh = AsistenciaApplication.findAllGrupoHorario();


				if (request.getParameter("format").equals("XML")) {

						/*
						for (GrupoHorario gh: lgh) {
						
								gh.setCreatedOn(new Date());
								gh.setUpdatedOn(new Date());
						}
						*/
				
						CrudTransferObject<GrupoHorario> to = new CrudTransferObject<GrupoHorario>();
						to.setXmlDataRows(lgh);

						out.println( CrudXMLHelper.marshal(to) );
						//out.println("<root><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow><dataRow><nombre>Bandera - Vendedores</nombre><desc>Bandera - Vendedores</desc><codigo>BANVEN</codigo><creado>01.01.2012</creado><actualizado>01.01.2012</actualizado></dataRow></root>");
				}


		} catch (Exception ex) {

					out.println("ERROR");
		}

		out.flush();
		out.close();
	}




}
