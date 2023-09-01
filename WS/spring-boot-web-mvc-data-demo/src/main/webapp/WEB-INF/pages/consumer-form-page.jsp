<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Consumers - Form</title>
</head>
<body>
	<h3>Consumer</h3>

	<a href="/home">Home</a>

	<form:form method="POST" modelAttribute="consumer">
		<div>
			<form:label path="consumerId">Consumer Id</form:label>
			<form:input path="consumerId" readonly="true" />
		</div>
		<div>
			<form:label path="fullName">Full Name</form:label>
			<form:input path="fullName" />
			<form:errors path="fullName"></form:errors>
		</div>
		<div>
			<form:label path="mobile">Mobile Number</form:label>
			<form:input path="mobile" />
			<form:errors path="mobile"></form:errors>
		</div>
		<div>
			<form:label path="mailId">Email Id</form:label>
			<form:input path="mailId" />
			<form:errors path="mailId"></form:errors>
		</div>
		<div>
			<form:label path="dateOfBirth">Date Of Birth</form:label>
			<form:input path="dateOfBirth" type="date"/>
			<form:errors path="dateOfBirth" ></form:errors>
		</div>
		<button>SAVE</button>
	</form:form>
</body>
</html>