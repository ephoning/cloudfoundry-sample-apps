<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>DB Service Test</title>
</head>
<body>
<h2>
	Testing DB Service Connectivity...  
</h2>

<P>  Data source available:  ${dataSourcePresent}. </P>
<P>  Number of records in 'thing' table: ${thingRowCount}. </P>
</body>
</html>
