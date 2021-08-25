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
		 
		 <!-- For updating the data for customer, we have given the modelAttribute 'customer'
		 and we are have same named attribute which has get the customer data from database in it 
		 when we click on 'Update' link in table.
		 So, whatever data that we have populated in our model attribute 'customer',  it will use
		 to PRE_POPULATE the below fields in this form.
		 So, behind the scenes, Spring will call the appropriate GETTER METHODS (.getFirstName(), 
		 .getLastName, .getEmail()) of each field on the 'customer' object if the values of it are NON_NULL.
		 
		 While submitting the form, Spring will call SETTER METHODS (.setFirstName, .setLastName, .setEmail)
		 to save the data AND while loading the form, Spring will call GETTER METHODS to pre-populate the fields in the form. -->
		 
		 
		 <!-- while updating the customer, need to associate this data with customer id -->
		 <form:hidden path="id" />
		 <!-- Above, is a hidden form field having customer id.
		 So when this form is loaded, it will get the id by Getter Method (customer.getId()) like other 
		 fields and place it there in hidden form field.
		 Then, when we do SUBMIT, it will actually submit this data by customer.setID() with the 
		 appropriate data.
		 This is very IMPORTANT.
		 Without this line, we would actually lose the ID of the original customer.
		 So we use this line to track the customer so that the back end system knows which customer to 
		 form the update operation on. -->
		 
		 
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