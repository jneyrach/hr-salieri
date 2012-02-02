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
				records                 : { }
			},
			
			setContentDivID        : function(value) {this.options.contentDivID = value;},
			setMainDivID           : function(value) {this.options.mainDivID = value;},
			setContentWidthInPixels: function(value) {this.options.contentWidthInPixels = value;},
			setRecords             : function(value) {this.options.records = value;},

			getContentDivID        : function() {return this.options.contentDivID;},
			getMainDivID           : function() {return this.options.mainDivID;},
			getContentWidthInPixels: function() {return this.options.contentWidthInPixels;},
			getRecords             : function() {return this.options.records;},
					
			unloadData: function() {
			
				$("#" + this.options.contentDivID).html("");
			},
					
			repaint: function() {
			
				$("#" + this.options.contentDivID).html("");
			
				for (i = 0; i < this.options.records.rows.dataRows.length; i++) {
				
					var record    = $("<div onclick=\"alert('');\" style='width:" + this.options.contentWidthInPixels + "px; position:relative;'></div>");
					var separator = $("<div style='width:" + this.options.contentWidthInPixels + "px; position:relative;'><hr></hr></div>");
					var cell      = $("<div class='cell-table'></div>");
					var row       = $("<div class='cell-row'></div>");
					var content   = $("<div class='cell-content'></div>");
					
					for (c = 0; c < this.options.records.columns.length; c++) {
					
							var fieldName  = $("<span>" + this.options.records.columns[c] + ":</span>");
							var fieldValue = $("<span>" + this.options.records.rows.dataRows[i][c] + "</span>");
						
							content.append(fieldName);
							content.append(fieldValue);
					}
					
					row.append(content);
					cell.append(row);
					record.append(cell);

					record.onclick = function () { alert('here'); };
					
					$("#" + this.options.contentDivID).append(record);
					$("#" + this.options.contentDivID).append(separator);
					$("#" + this.options.mainDivID).nanoScroller();
				}
			},
			
			_create: function() {
										
			}
					
	};

	
	$.widget("ui.classCrudRecordList", classCrudRecordList);
