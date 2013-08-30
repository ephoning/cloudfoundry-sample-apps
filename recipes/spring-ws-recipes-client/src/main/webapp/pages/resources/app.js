$(document).ready(function(){
	theme = getDemoTheme();

	/* Setting the recipe type dropdowns */
	var recipeTypesSource = ["All", "Indian", "American", "Chinese", "Bengali", "Continental"];
	$("#searchRecipeType").jqxDropDownList({ source: recipeTypesSource, selectedIndex: 0, width: '200', height: '25', autoDropDownHeight: true, theme: theme });
	$("#ed_recipeType").jqxDropDownList({ source: recipeTypesSource, selectedIndex: 0, width: '200', height: '25', autoDropDownHeight: true, theme: theme });
	$("#add_recipeType").jqxDropDownList({ source: recipeTypesSource, selectedIndex: 0, width: '200', height: '25', autoDropDownHeight: true, theme: theme });

	/* Setting style on the buttons - Start */	
	$("#saveButton").jqxButton({ theme: theme });
	$("#resetAdd").jqxButton({ theme: theme });
	$("#fetch").jqxButton({ theme: theme });
	$("#deleterowbutton").jqxButton({ theme: theme });
	$("#searchButton").jqxButton({ theme: theme });

	$("#searchRecipeName").jqxInput({placeHolder: "Recipe Name", height: 25, width: 200, minLength: 1, theme: theme });
	/* Setting style on the buttons - End */

	/* Accordion for outer most area */
	$( "#accordionAll" ).accordion({
		collapsible: true,
		/* active: false, */
		active:0,
		heightStyle: "content",
		activate: function( event, ui ) {
			$("#searchRecipeName").focus();
		}
	});

	/* Accordions for inside add recipe */
	$( "#accordionAdd" ).accordion({
		collapsible: true,
		active: 0,
		activate: function( event, ui ) {
			$("#add_name").focus();
		}
	});

	/* Fetch all recipes - fetch button event - Start */
	$( "#fetch" ).click(function() {
		fetchAllRecords('');
	});

	$( "#searchButton" ).click(function() {
		fetchAllRecords('search');
	});

	var fetchAllRecords = function (resulttype){
		$("#jqxgrid").remove();

		$("#fetch").attr("disabled","disabled");
		$("#waitText1").text('Please wait ... ');
		$("#fetch").css('cursor','progress');

		var fetchURL = '';

		if (resulttype=='search') {
			var recipeName = $("#searchRecipeName").val();
			var recipeType = $("#searchRecipeType").jqxDropDownList('getSelectedItem').label; 

			if (recipeName==''){
				recipeName='NA';
			}
			if (recipeType=='All'){
				recipeType = 'NA';
			}

			fetchURL=contextPath+'/recipe/getrecipe.view?recipeName='+recipeName+'&recipeType='+recipeType;
		} else {
			fetchURL=contextPath+'/recipe/getrecipe.view?recipeName=NA&recipeType=NA';
		}

        var source = {
                type: "GET",
                datatype: "json",
				datafields: [
				             { name: 'recipeId' },
				             { name: 'recipeName' },
				             { name: 'recipeDescription'},
				             { name: 'createdBy' },
				             { name: 'recipeType'},
				             { name: 'visitorCount'},
				             { name: 'process'},
				             { name: 'recipeIngredients' }
				             ],
				url: fetchURL,
				cache: false,
				beforeprocessing: function (data) {
				    source.totalrecords = data.totalRecord;
				     }
		};

		var dataAdapter = new $.jqx.dataAdapter(source, {
            error: function () { alert('error'); },
            loadError: function () { alert('data load error'); } } );

		$('<div id="jqxgrid"></div>').appendTo($("#jqxWidget"));
		$("#fetch").removeAttr("disabled","disabled");
		$("#waitText1").text('');
		$("#fetch").css('cursor','pointer');
		var editrow = -1;

		var initrowdetails = function (index, parentElement, gridElement, datarecord) {
			var tabsdiv = null;
			var process = null;
			var ingredients = null;
			tabsdiv = $($(parentElement).children()[0]);

			if (tabsdiv != null) {
				process = tabsdiv.find('.process');
				ingredients = tabsdiv.find('.ingredients');

				var texT = datarecord.process;
				if(texT==null || texT==''){
					texT = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
				}
				var processContainer = $('<div style="white-space: normal; margin: 5px;">'
						+'<table>'
						+ '	<tr><td>'+texT+'</td></tr>'
						+ '</table>'
						+ ' </div>');

				$(process).append(processContainer);

				var ingredientsource = { 
						datafields: [
						             { name: 'recipeDetailId' },
						             { name: 'ingredientName' },
						             { name: 'quantity' },
						             { name: 'uom' }
						             ],
						             id: 'recipeDetailId',
						             localdata: datarecord.recipeIngredients
				};
				$(ingredients).jqxGrid({
					source: ingredientsource, 
					theme: theme, 
					width: 500, 
					autoheight:true,
					columns: [
					          { text: 'Id', datafield: 'recipeDetailId', hidden: true },
					          { text: 'Ingredient Name', datafield: 'ingredientName', width: 200 },
					          { text: 'Quantity', datafield: 'quantity', width: 150 },
					          { text: 'UOM', datafield: 'uom', width: 150 }
					          ]
				});

				$(tabsdiv).jqxTabs({ width: 600, height: 170, theme: theme });
			}
		};

		$("#jqxgrid").jqxGrid({
			/* Setting up Grid properties - START */
			width: 950,
			autoheight: true,
			source: dataAdapter,
			theme: theme,
			rowdetails: true,
			columnsresize: true,
			sortable: true,

			pageable: true,
			virtualmode: true,
			pagesize : 20,
			rendergridrows: function (params) {
				return params.data;
			},
			/* Setting up Grid properties - END */
			rowdetailstemplate: { 
				rowdetails: "<div style='margin: 10px;'><ul style='margin-left: 30px;'><li>Process</li><li>Ingredients</li></ul>" +
				"<div class='process'></div><div class='ingredients' style='margin-top:4px; margin-left:4px;'></div></div>", 
				rowdetailsheight: 200 
			},
			ready: function () {
				$("#jqxgrid").jqxGrid('sortby', 'recipeName', 'asc');
			},
			initrowdetails: initrowdetails,
			columns: [
			          { text: 'Name', datafield: 'recipeName', width: 200, type: 'string' },
			          { text: 'Description', datafield: 'recipeDescription', width: 400, type: 'string' },
			          { text: 'Type', datafield: 'recipeType', width: 100, type: 'string' },
			          { text: 'Visitor', datafield: 'visitorCount', width: 60, filtertype: 'number', type: 'int' },
			          { text: 'Created By', datafield: 'createdBy', width: 100, type: 'string' },
			          { text: 'Edit', datafield: 'Edit', width:60, columntype: 'button', sortable: false, cellsrenderer: function () {
			        	  return "Edit";
			          }, buttonclick: function (row) {
			        	  editrow = row;
			        	  dataRecord_row = $("#jqxgrid").jqxGrid('getrowdata', editrow);

			        	  var offset = $("#jqxgrid").offset();
			        	  var extraHeight = 20*parseInt(dataRecord_row.recipeIngredients.length)+10;
			        	  var popupHeight = 400 + extraHeight;

			        	  $("#ed_recipeId").val(dataRecord_row.recipeId);
			        	  $("#ed_name").text(dataRecord_row.recipeName);
			        	  $("#ed_desc").text(dataRecord_row.recipeDescription);
			        	  $("#ed_process").html(dataRecord_row.process);
			        	  $("#ed_recipeType").jqxDropDownList('selectItem', dataRecord_row.recipeType); 

			        	  var ingredientsource = {
			        			  datafields: [
			        			               { name: 'recipeDetailId' },
			        			               { name: 'ingredientName' },
			        			               { name: 'quantity' },
			        			               { name: 'uom' }
			        			               ],
        			               localdata: dataRecord_row.recipeIngredients
			        	  };

			        	  var dataAdapter = new $.jqx.dataAdapter(ingredientsource);

			        	  initChildDataGrid("#ingredient_dtl", dataAdapter);

			        	  $("#ed_control").empty();
			        	  $("#ed_control").append('<button id="ed_save" style="margin-right: 5px; font-size: 13px;">SAVE</button><span id="waitText4"></span><button id="ed_cancel">CANCEL</button>');
			        	  // show the popup window.
			        	  $("#popupWindow").jqxWindow({ 
			        		  position: { x: parseInt(offset.left) + 100, y: parseInt(offset.top) - 180 }, 
			        		  height: popupHeight,
			        		  width: 800,
			        		  theme: theme,
			        		  autoOpen: false,
			        		  cancelButton: $("#ed_cancel"),
			        		  isModal: true,
			        		  modalOpacity: 0.3 
			        	  });

			        	  $("#popupWindow").jqxWindow('open');

			        	  $("#ed_cancel").jqxButton({ theme: theme });
			        	  $("#ed_save").jqxButton({ theme: theme });

			        	  $("#ed_save").on('click', editSave);
			          }
			          }
			          ]
		});
	};
	/* Fetch all recipes - fetch button event - End */

	/* Edit a recipe - ed_save button event - Start */
	var editSave = function(){
		$("#ed_save").attr("disabled","disabled");
		$("#waitText4").text('Please wait ... ');
		$("#ed_save").css('cursor','progress');

		var arr = [];
		arr = $('#ingredient_dtl').jqxGrid('getrows');
		for (x in arr){
			delete arr[x]['uid'];
		}

		if (arr.length==0){
			alert('Cannot save. Please add atleast one ingredient');
			$("#ed_save").removeAttr("disabled","disabled");
			$("#waitText4").text('');
			hideAndFade("#waitText4");
			$("#ed_save").css('cursor','pointer');

			return;
		}
		
		if ($("#ed_recipeType").jqxDropDownList('getSelectedItem').label == 'All'){
			alert('Cannot save. Please select valid recipe type');
			$("#ed_save").removeAttr("disabled","disabled");
			$("#waitText4").text('');
			hideAndFade("#waitText4");
			$("#ed_save").css('cursor','pointer');
			
			return;
		}

		var formElements = new Object({
			recipeId : $("#ed_recipeId").val(),
			recipeName: $("#ed_name").text(), 
			recipeDescription: $("#ed_desc").text(),
			recipeType: $("#ed_recipeType").jqxDropDownList('getSelectedItem').label,
			visitorCount: 1,
			process: $("#ed_process").html(),
			recipeIngredients: arr,
			createdBy: 'admin',
			createdOn: new Date()
		});

		$.ajax({
			type: 'POST',
			url: contextPath+'/recipe/editRecipe.do?reqType=UPDATE',
			dataType: 'json',
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(formElements),
			success : function(data, textStatus, jqXHR) {
				$("#ed_save").removeAttr("disabled","disabled");
				$("#waitText4").text('Save successful...');
				hideAndFade("#waitText4");
				$("#ed_save").css('cursor','pointer');

				$("#popupWindow").jqxWindow('hide');
				fetchAllRecords('search');
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log('error:', errorThrown);
				$("#ed_save").removeAttr("disabled","disabled");
				$("#waitText4").text('Save failed : '+errorThrown);
				hideAndFade("#waitText4");
				$("#ed_save").css('cursor','pointer');
			}
		});
	};

	/* Edit a recipe - ed_save button event - Start */

	/* Delete selected row - Start */
	$("#deleterowbutton").on('click', function () {
		$("#deleterowbutton").attr("disabled","disabled");
		$("#waitText3").text('Please wait ... ');
		$("#deleterowbutton").css('cursor','progress');

		var id = null;
		var recipeId = null;
		try {
			var selectedrowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
			var rowscount = $("#jqxgrid").jqxGrid('getdatainformation').rowscount;
			if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
				id = $("#jqxgrid").jqxGrid('getrowid', selectedrowindex);
			}
		}catch(err){}

		if (id != null){
			recipeId = $('#jqxgrid').jqxGrid('getrowdata', id).recipeId;	

			$.ajax({
				type: 'GET',
				url: contextPath+'/recipe/remove.do?recipeId='+recipeId,
				dataType: 'json',
				success : function(responseData, textStatus, jqXHR) {
					var commit = $("#jqxgrid").jqxGrid('deleterow', id);
					$("#deleterowbutton").removeAttr("disabled","disabled");
					$("#waitText3").text('Row deleted successfully');
					$("#deleterowbutton").css('cursor','pointer');

					hideAndFade("#waitText3");
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log('error: '+textStatus);
					$("#deleterowbutton").removeAttr("disabled","disabled");
					$("#waitText3").text('Error: '+textStatus);
					hideAndFade("#waitText3");
					$("#deleterowbutton").css('cursor','pointer');
				}
			});
		} else {
			$("#deleterowbutton").removeAttr("disabled","disabled");
			$("#waitText3").text('Please select a row');
			hideAndFade("#waitText3");
			$("#deleterowbutton").css('cursor','pointer');
		}
	});
	/* Delete selected row - End */

	/* Add recipe - submit button event - Start */
	$("#saveButton").click(function() {
		$("#saveButton").attr("disabled","disabled");
		$("#waitText2").text('Please wait ... ');
		$("#saveButton").css('cursor','progress');

		var validationCheck = function(txt){
			alert(txt);
			$("#saveButton").removeAttr("disabled","disabled");
			$("#waitText2").text('');
			hideAndFade("#waitText2");
			$("#saveButton").css('cursor','pointer');
		};
		
		var arr = [];
		arr = $('#ingredient_dtl2').jqxGrid('getrows');
		for (x in arr){
			delete arr[x]['uid'];
		}
		
		if($("#add_name").text().trim()==''||$("#add_desc").text().trim()==''||$("#add_process").html().trim()==''){
			validationCheck('Cannot save. Please fill all fields.');
			return;
		}else if ($("#add_recipeType").jqxDropDownList('getSelectedItem').label == 'All'){
			validationCheck('Cannot save. Please select valid recipe type');
			return;
		}else if (arr.length==0 || arr[0]['ingredientName'].trim()==''){
			validationCheck('Cannot save. Please add atleast one ingredient');
			return;
		}
		
		var formElements = new Object({
			recipeId : 0,
			recipeName: $("#add_name").text(), 
			recipeDescription: $("#add_desc").text(),
			recipeType: $("#add_recipeType").jqxDropDownList('getSelectedItem').label,
			visitorCount: 1,
			process: $("#add_process").html(),
			recipeIngredients: arr,
			createdBy: 'admin',
			createdOn: new Date()
		});

		$.ajax({
			type: 'POST',
			url: contextPath+'/recipe/editRecipe.do?reqType=ADD',
			dataType: 'json',
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(formElements),
			success : function(data, textStatus, jqXHR) {
				$("#saveButton").removeAttr("disabled","disabled");
				$("#waitText2").text('Save successful...');
				hideAndFade("#waitText2");
				$("#saveButton").css('cursor','pointer');

				fetchAllRecords('');
				
				hideAndFade("#waitText2", activateFetchArea);
				clearAddForm();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log('error:', errorThrown);
				$("#saveButton").removeAttr("disabled","disabled");
				$("#waitText2").text('Save failed : '+errorThrown);
				hideAndFade("#waitText4");
				$("#saveButton").css('cursor','pointer');
			}
		});
	});
	/* Add recipe - submit button event - End */

	/* Add blank ingredient grid - Start */
	addRecipeChild();
	/* Add blank ingredient grid - End*/
	
	/* Associate reset button */
	$('#resetAdd').click(clearAddForm);
});

/* Add blank ingredient grid */
var addRecipeChild = function (){
	var ingredientsource = {
			datafields: [
			             { name: 'recipeDetailId' },
			             { name: 'ingredientName' },
			             { name: 'quantity' },
			             { name: 'uom' }
             ]
	};

	var dataAdapter = new $.jqx.dataAdapter(ingredientsource);
	initChildDataGrid("#ingredient_dtl2", dataAdapter);
	
	var datarow = generaterow();
	var commit = $("#ingredient_dtl2").jqxGrid('addrow', null, datarow);
};

/* Hide slowly effect */
var hideAndFade = function(selector, callback){
	setTimeout(function() {
		$(selector).text('');
		if (callback && typeof(callback) === "function") {  
			callback();
		}
	}, 2000);
};

/* Activate the fetch area */
var activateFetchArea = function(){
	$( "#accordionAll" ).accordion( {active:0} );	
};

/* Provides ingredient grid structure */
var initChildDataGrid = function(selector, dataAdapter){
	var unqIdentifier = selector.substring(1); 
	var addBtnId = 'addIndg_'+unqIdentifier;
	var deleteBtnId = 'deleteIndg_'+unqIdentifier;
	$(selector).jqxGrid({
		source: dataAdapter,
		theme: theme,
		autoheight: true,
		editable: true,
		editmode: 'dblclick',
		selectionmode: 'singlerow',
		showtoolbar: true,
		columns: [
		          { text: 'recipeDetailId', datafield: 'recipeDetailId', hidden:true},
		          { text: 'Ingredient Name', datafield: 'ingredientName'},
		          { text: 'Quantity', datafield: 'quantity'},
		          { text: 'UOM', datafield: 'uom'}
		          ],
		          rendertoolbar: function (toolbar) {
		        	  var container = $("<div style='margin: 5px;'></div>");
		        	  var addButton = $("<button id="+addBtnId+" style='float: left; margin-right: 4px;'>ADD</button>");
		        	  var deleteButton = $("<button id="+deleteBtnId+" style='float: left;  margin-right: 4px;'>DELETE</button>");
		        	  var span = $("<span style='vertical-align:middle; margin-right: 4px;'>(Double click to edit)</span>")
		        	  toolbar.append(container);
		        	  container.append(addButton);
		        	  container.append(deleteButton);
		        	  container.append(span); 
		        	  $("#"+addBtnId).jqxButton({ theme: theme });
		        	  $("#"+deleteBtnId).jqxButton({ theme: theme });

		        	  $("#"+addBtnId).on('click', function () {
		        		  var datarow = generaterow();
		        		  log(datarow);
		        		  var commit = $(selector).jqxGrid('addrow', null, datarow);
		        	  });
		        	  $("#"+deleteBtnId).on('click', function () {
		        		  var selectedrowindex = $(selector).jqxGrid('getselectedrowindex');
		        		  var rowscount = $(selector).jqxGrid('getdatainformation').rowscount;
		        		  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		        			  var id = $(selector).jqxGrid('getrowid', selectedrowindex);
		        			  var commit = $(selector).jqxGrid('deleterow', id); 
		        		  }
		        	  });

		          }
	});
};

/* Provides blank row data */
var generaterow = function () {
	var row = {};
	row["recipeDetailId"] = 0;
	row["ingredientName"] = '';
	row["quantity"] = '';
	row["uom"] = '';
	
	var rows = new Array();
	rows.push(row);
	return rows;
};

/* Clears the form area in ADD section */
var clearAddForm = function(){
	$("#add_name").text(''); 
	$("#add_desc").text('');
	$("#add_recipeType").jqxDropDownList('selectItem', 'All');
	$("#add_process").text('');

	addRecipeChild();
//	var rows = $('#ingredient_dtl2').jqxGrid('getrows');
//	var rowIDs = new Array();
//	for (x in rows){
//		rowIDs.push(rows[x].uid);
//	}
//	$('#ingredient_dtl2').jqxGrid('deleterow', rowIDs); 
//	var datarow = generaterow();
//	$("#ingredient_dtl2").jqxGrid('addrow', null, datarow);
};