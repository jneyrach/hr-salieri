<!DOCTYPE html>
<html lang="en" class="no-js">

	<head>
		<meta charset="ISO-8859-1" />
	
	
		<link rel="stylesheet" href="jquery.ui.crud-record-list-20120101.css" type="text/css" />
	
	
		<script type="text/javascript" src="jquery-1.7.1.min.js"></script>

		<script type="text/javascript" src="jquery.nanoscroller.min.js"></script>

		<script type="text/javascript" src="jquery-ui-1.8.17.custom.min.js"></script>

		<script type="text/javascript" src="jquery.ui.core.js"></script>

		<script type="text/javascript" src="jquery.ui.widget.js"></script>

		<script type="text/javascript" src="jquery.ui.mouse.js"></script>

		<script type="text/javascript" src="jquery.ui.crud-record-list-20120101.js"></script>
		
		<script>
		</script>
	</head>

	<body>
			<div id="list1" class="nano">
				<div id="listcontent" class="content">
				</div>
			</div>
	</body>

	<script>
				$.ajax({
						  url      : "http://mirhrh.appspot.com/AsistenciaCrudFindAllGrupoHorario",
						  dataType : "json",
						  data     : "",
						  success  : function(data) {alert(data);}
				});
	
				var records = {
						columns : ["Código", "Nombre", "Creado", "Ultima actualización"],
						keys    : ["ID"],
						dataRows: [ ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"],
                                    ["GRPDEFA", "Grupo Genérico", "01.01.2012", "01.01.2012"]  ],
                        keyRows :  [ ["1"],
									 ["2"],
									 ["3"],
									 ["4"],
									 ["5"],
									 ["6"],
									 ["7"],
									 ["8"],
									 ["9"],
									 ["10"],
									 ["11"],
									 ["12"],
									 ["13"],
									 ["14"],
									 ["15"],
									 ["16"],
									 ["17"],
									 ["18"],
									 ["19"],
									 ["20"]  ]
				};
	
				var records2 = {
"class":"sshr.web.servlet.asistencia.CrudJSONTransferObject","columns":["Nombre","Descripción","Creado","Actualizado"],"dataRows":[["Bandera - Guardias","BANGUA","01.01.2012","01.01.2012"],["Bandera - Vendedores","BANVEN","01.01.2012","01.01.2012"],["Alameda 1 - Guardias","AL1GUA","01.01.2012","01.01.2012"],["Alameda 1 - Vendedores","AL1NVEN","01.01.2012","01.01.2012"],["Grupo Genérico","GRPGEN","01.01.2012","01.01.2012"]],"keyRows":[["1"],["2"],["3"],["4"],["5"]],"keys":["ID"]
				};
	

			// The creation
			var list = $("#list1").classCrudRecordList();
			
			// The setup
			list.classCrudRecordList("setContentWidthInPixels", "280");
			list.classCrudRecordList("setContentDivID", "listcontent");
			list.classCrudRecordList("setMainDivID", "list1");
			list.classCrudRecordList("setRecords", records);
			list.classCrudRecordList("setEvtRowSelected", "testclick");

			// The painting of data
			list.classCrudRecordList("repaint");

			
			
			
			function testclick(a) {
			
				list.classCrudRecordList("setEvtRowSelected", "testclick2");
				
				list.classCrudRecordList("setRecords", records2);

				list.classCrudRecordList("unloadData");

				list.classCrudRecordList("repaint");				
				
				return true;
			}
			
			function testclick2(a) {
			
				list.classCrudRecordList("setEvtRowSelected", "testclick");
				
				list.classCrudRecordList("setRecords", records);

				list.classCrudRecordList("unloadData");

				list.classCrudRecordList("repaint");				
				
				return true;
			}
			
	</script>
	
</html>
