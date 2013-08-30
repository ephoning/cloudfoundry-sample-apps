<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8">

<title>My Wonderful Recipes</title>
<link rel="stylesheet" href="resources/custom.css" media="all"/>
<link rel="stylesheet" href="resources/jquery/css/jquery-ui-1.10.2.smoothness.min.css" media="all"/>
<link rel="stylesheet" href="resources/jqwidgets/css/jqx.base.css" type="text/css" />

<script src="resources/jquery/js/jquery-1.9.1.min.js"></script>
<script src="resources/jquery/js/jquery-ui-1.10.2.smoothness.min.js"></script>
<script src="resources/jquery/js/jquery-validate.min.js"></script>

<script src="resources/jqwidgets/js/jqxcore.js"></script>
<script src="resources/jqwidgets/js/jqxdata.js"></script> 
<script src="resources/jqwidgets/js/jqxbuttons.js"></script>
<script src="resources/jqwidgets/js/jqxscrollbar.js"></script>
<script src="resources/jqwidgets/js/jqxmenu.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.js"></script>
<script src="resources/jqwidgets/js/jqxtabs.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.selection.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.sort.js"></script> 
<script src="resources/jqwidgets/js/jqxwindow.js"></script>
<script src="resources/jqwidgets/js/jqxinput.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.columnsresize.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.pager.js"></script>
<script src="resources/jqwidgets/js/jqxlistbox.js"></script>
<script src="resources/jqwidgets/js/jqxdropdownlist.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.filter.js"></script>
<script src="resources/jqwidgets/js/jqxgrid.edit.js"></script>

<script src="resources/jqwidgets/js/gettheme.js"></script>

<script src="resources/app.js"></script>

<script>
	rowCount=0;
	contextPath = '<%= request.getContextPath() %>';	
</script>
</head>

<body>
<div id="accordionAll">
	<h3>Show all Recipe</h3>
	<div id="customerAll">
		<button id="fetch" style="margin-right: 5px; font-size: 13px;">FETCH ALL</button><span id="waitText1"></span><button id="deleterowbutton" style="margin-right: 5px; font-size: 13px;">DELETE SELECTED</button><span id="waitText3"></span>
		<br><br>
		<div id="searchDiv" style="border: 1px solid #A9A9A9; padding: 6px; border-radius: 4px; height: 28px;">
		<form action="" onSubmit="return false;">
			<input type="text" id="searchRecipeName" style="padding-left:4px;">&nbsp;&nbsp;
			<div id="searchRecipeType" style="position:relative; left:210px; top:-27px;"></div>&nbsp;&nbsp; 
			<button id="searchButton" style="margin-right: 5px; font-size: 13px; position: relative; top:-52px; left:410px;">SEARCH</button>
		</form>
		</div>
		<br>
		<div id='jqxWidget' style="float: left; width: 100%">
			<div id="jqxgrid"></div>
		</div>
	</div>
	
	<h3>Add new Recipe</h3>
	<div id="recipeAdd">
	     <div style="overflow: auto; position: relative; height:100%;">
	         <table id="editTable" style="width: 100%;">
	         <thead>
	             <tr>
	                 <th colspan="5" align="left">Recipe Details</th>
	             </tr>
	         </thead>
	         <tbody>
	             <tr>
	                 <td align="right" style="width: 50px;">Name:</td>
	                 <td align="left" colspan="4"><div id="add_name" class="divEdit" style="min-height: 20px; padding-left:4px; padding-top:4px;" contenteditable></div></td>
	             </tr>
	             <tr>
	                 <td align="right">Description:</td>
	                 <td align="left" colspan="4"><div id="add_desc" class="divEdit" style="min-height: 36px; padding-left:4px; padding-top:4px;" contenteditable></div></td>
	             </tr>
	             <tr>
	                 <td align="right">Type:</td>
	                 <td align="left"><div id="add_recipeType"></div></td>
	             </tr>
	             <tr>
	                 <td align="right">Process:</td>
	                 <td align="left" colspan="4"><div id="add_process" class="divEdit" style="min-height: 54px; padding-left:4px; padding-top:4px;" contenteditable></div></td>
	             </tr>
	          </tbody>
	          <thead>
	             <tr>
	                 <th colspan="5" align="left">Ingredients</th>
	             </tr>
	          </thead>
	          <tbody>
	             <tr>
	                 <td align="right"></td>
	                 <td align="left" colspan="4"><div id="ingredient_dtl2"></div></td>
	             </tr>
	          </tbody>
	         </table>
			<div id="add_control" style="text-align: right; width: 100%; right: 4px; bottom: 4px;">
			</div>
	     </div>
	     
		<br>
		<button id="saveButton" style="margin-right: 5px; font-size: 13px;">SAVE</button><span id="waitText2"></span><button id="resetAdd" type="reset" style="font-size: 13px;">CLEAR</button>
	</div>
</div>

<div id="popupWindow" style="display: none;"> 
     <div>EDIT</div>
     <input id="ed_recipeId" type="hidden" />
     <div style="overflow: auto; position: relative; height:100%;">
         <table id="editTable" style="width: 100%;">
         <thead>
             <tr>
                 <th colspan="5" align="left">Recipe Details</th>
             </tr>
         </thead>
         <tbody>
             <tr>
                 <td align="right" style="width: 50px;">Name:</td>
                 <td align="left" colspan="4"><div id="ed_name" class="divEdit" style="min-height: 20px; padding-left:4px; padding-top:4px;" contenteditable></div></td>
             </tr>
             <tr>
                 <td align="right">Description:</td>
                 <td align="left" colspan="4"><div id="ed_desc" class="divEdit" style="min-height: 36px; padding-left:4px; padding-top:4px;" contenteditable></div></td>
             </tr>
             <tr>
                 <td align="right">Type:</td>
                 <td align="left"><div id="ed_recipeType"></div></td>
             </tr>
             <tr>
                 <td align="right">Process:</td>
                 <td align="left" colspan="4"><div id="ed_process" class="divEdit" style="min-height: 54px; padding-left:4px; padding-top:4px;" contenteditable></div></td>
             </tr>
          </tbody>
          <thead>
             <tr>
                 <th colspan="5" align="left">Ingredients</th>
             </tr>
          </thead>
          <tbody>
             <tr>
                 <td align="right"></td>
                 <td align="left" colspan="4"><div id="ingredient_dtl"></div></td>
             </tr>
          </tbody>
         </table>
		<div id="ed_control" style="text-align: right; width: 100%; right: 4px; bottom: 4px;">
		</div>
     </div>
</div>
<script>
log = function(a,b){
    if (typeof console!=="undefined"){
        if(b == undefined){
            console.log(a);
        }else{
            console.log(a+':',b);
        }
    }
};
</script>
</body>
</HTML>
