<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>Consumers - Home</title>
	</head>
	<body>
		<h3>Consumers</h3>
		
		<a href="/add">New Consumer</a>
		
		<c:choose>
			<c:when test="${consumers== null || consumers.isEmpty() }">
				<p><strong>No Records To Display</strong></p>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th>Consumer#</th>
						<th>Full Name</th>
						<th>Mobile</th>
						<th>Mail</th>
						<th>Date Of Birth</th>
						<th>Action</th>
					</tr>
					<c:forEach var="c" items="${consumers }">
						<tr>
							<td>${c.consumerId }</td>
							<td>${c.fullName }</td>
							<td>${c.mobile }</td>
							<td>${c.mailId }</td>
							<td>${c.dateOfBirth }</td>
							<td>
								<a href="/edit?id=${c.consumerId }">EDIT</a> <span>|</span>
								<a href="/delete?id=${c.consumerId }">DELETE</a> 
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>