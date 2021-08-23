<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Above line is for adding support for JSTL Core Tags -->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Above line adds support for Spring MVC Form Tags. -->


<!DOCTYPE>

<html>

<head>

	<title>List Customers</title>

	<!-- Reference our css files -->
	<link type="text/css" rel="stylesheet"
	      href="${pageContext.request.contextPath}/resources/css/style.css" />
	<!-- Above, '${pageContext.request.contextPath}' will give us actual proper name of our app -->

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	
	<div id="container">
		
		<div id="content">
		
		
		<!-- Adding new button : Add Customer-->
		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button" />
		
		<!-- So, when we click the 'Add Customer' button, it will call a Spring Controller Mapping, 
		then it will show form for add.
		So basically it will take user to /showFormForAdd URL. -->
		
		
		<!-- Add a search box -->
		<form:form action="search" method="GET">
		
			Search customer: <input type="text" name="theSearchName" />
			
			<input type="submit" value="Search" class="add-button" />
		
		</form:form>
			
			
			<!-- Add our html table here -->
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- Loop over and print out customers -->
				<c:forEach var="tempCustomer" items="${customers}"> <!-- 'customers' is actual attribute name from in Spring Model -->
					
					<!-- FOR UPDATING THE CUSTOMER -->
					<!-- Construct an 'update' link with customer id -->
					<!-- Creating a variable to store URL -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<!-- Adding a parameter called 'customerId' and assigning it to current customer(tempCustomer) id. -->
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					
					<!-- FOR DELETING THE CUSTOMER -->
					<!-- Construct an 'delete' link with customer id -->
					<!-- Creating a variable to store URL -->
					<c:url var="deleteLink" value="/customer/delete">
						<!-- Adding a parameter called 'customerId' and assigning it to current customer(tempCustomer) id. -->
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					
					<tr>
						<td>${tempCustomer.firstName} </td>
						<td>${tempCustomer.lastName} </td>
						<td>${tempCustomer.email} </td>
						<td><!-- Display the update link -->
							<a href="${updateLink}">Update</a>	
							<!-- 'updateLink' is the URL variable which we have defined above-->
							
							<!-- For delete -->
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							   <!-- Above, in 'onclick', we are prompting the user for Confirmation 
							   dialog pop up box using JavaScript.
							   So if user clicks cancel then we are returning false which will not perform the delete operation.
							   If user clicks OK then it will proceed and will execute the delete operation. -->
							
						 </td>
					</tr>
					
				</c:forEach>
			</table>
			
		</div>
		
	</div>

</body>

</html>