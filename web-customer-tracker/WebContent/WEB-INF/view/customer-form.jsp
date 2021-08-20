<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Above line adds support for Spring MVC Form Tags. -->

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>
	
	<link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" >
		  
	<link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" >
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST" >
		<!-- So above, 'action='saveCustomer' will send to Spring MVC Mapping.
		modelAttribute='customer' will bind the data to that modelAttribute item
		 that's in the actual Model in our Controller class. -->
		 
		 <table>
		 	<tbody>
		 	
		 		<tr>
		 			<td><label>First name:</label></td>
		 			<td><form:input path="firstName" /></td> <!-- This will bind to 'firstName' field. -->
		 		</tr>
		 		
		 		<tr>
		 			<td><label>Last name:</label></td>
		 			<td><form:input path="lastName" /></td> <!-- This will bind to 'lastName' field. -->
		 		</tr>
		 		
		 		<tr>
		 			<td><label>Email:</label></td>
		 			<td><form:input path="email" /></td> <!-- This will bind to 'email' field. -->
		 		</tr>
		 		
		 		
		 		<tr>
		 			<td><label></label></td>
		 			<td><input type="submit" value="Save" class="save" /></td>
		 		</tr>
		 	
		 	</tbody>
		 </table>
		
		</form:form>
		
		<div style="clear; both;">
		
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
			</p>
		
		</div>
		
	</div>

</body>

</html>