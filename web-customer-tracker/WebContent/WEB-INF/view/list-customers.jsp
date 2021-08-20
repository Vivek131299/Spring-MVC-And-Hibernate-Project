<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Above line is for adding support for JSTL Core Tags -->

<!DOCTYPE>

<html>

<head>

<title>List Customers</title>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	
	<div id="container">
		
		<div id="content">
			
			<!-- Add our html table here -->
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<!-- Loop over and print out customers -->
				<c:forEach var="tempCustomer" items="${customers}"> <!-- 'customers' is actual attribute name from in Spring Model -->
					
					<tr>
						<td>${tempCustomer.firstName} </td>
						<td>${tempCustomer.lastName} </td>
						<td>${tempCustomer.email} </td>
					</tr>
					
				</c:forEach>
			</table>
			
		</div>
		
	</div>

</body>

</html>