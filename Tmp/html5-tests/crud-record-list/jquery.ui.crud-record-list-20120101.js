/*
 * Crud Record List
 *
 * This is basically a list of records, with the intention of improve the presentation of records.
 * The second goal is to pass the record to its corresponding editting form.
 *
 *
 */
	var classCrudRecordList = {
	
			options: {
				contentWidthInPixels    : "",
				contentDivID            : "",
				mainDivID               : "",
				evtRowSelected          : "",
				records                 : { }
			},

			// Setters
			setContentDivID        : function(value) {this.options.contentDivID = value;},
			setMainDivID           : function(value) {this.options.mainDivID = value;},
			setContentWidthInPixels: function(value) {this.options.contentWidthInPixels = value;},
			setRecords             : function(value) {this.options.records = value;},
			setEvtRowSelected      : function(value) {this.options.evtRowSelected = value;},

			// Getters
			getContentDivID        : function() {return this.options.contentDivID;},
			getMainDivID           : function() {return this.options.mainDivID;},
			getContentWidthInPixels: function() {return this.options.contentWidthInPixels;},
			getRecords             : function() {return this.options.records;},
			getEvtRowSelected      : function() {return this.options.evtRowSelected;},

			
			unloadData: function() {
			
				$("#" + this.options.contentDivID).html("");
			},
					
			repaint: function() {
			
				$("#" + this.options.contentDivID).html("");
			
				for (i = 0; i < this.options.records.dataRows.length; i++) {

					var thekeys = "'" + this.options.records.keyRows[i][0] + "'";
					for (c = 1; c < this.options.records.columns.length; c++) {
					     thekeys = thekeys + ",'" + this.options.records.keyRows[i][c] + "'";
					}

					var record    = $("<div onclick=\"" + this.options.evtRowSelected + "(" + thekeys + ");\" style='width:" + this.options.contentWidthInPixels + "px; position:relative;'></div>");
					var separator = $("<div style='width:" + this.options.contentWidthInPixels + "px; position:relative;'><hr></hr></div>");
					var cell      = $("<div class='cell-table'></div>");
					var row       = $("<div class='cell-row'></div>");
					var content   = $("<div class='cell-content'></div>");
					
					for (c = 0; c < this.options.records.columns.length; c++) {
					
							var fieldName  = $("<span>" + this.options.records.columns[c] + ":</span>");
							var fieldValue = $("<span>" + this.options.records.dataRows[i][c] + "</span>");
						
							content.append(fieldName);
							content.append(fieldValue);
					}
					
					row.append(content);
					cell.append(row);
					record.append(cell);

					// Adds a new record within the css table
					$("#" + this.options.contentDivID).append(record);
					$("#" + this.options.contentDivID).append(separator);
				}
				
				$("#" + this.options.mainDivID).nanoScroller({scrollTop: 10});
			},
			
			_create: function() { }
					
	};

	
	$.widget("ui.classCrudRecordList", classCrudRecordList);
