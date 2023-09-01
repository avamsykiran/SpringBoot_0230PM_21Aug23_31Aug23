<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Our Web Home</title>
</head>
<body>
	<nav>
		<a href="/home">Home Page</a>
	</nav>
	<h3>Loan Page</h3>

	<form:form modelAttribute="loan" method="POST">
		<div>
			<form:label path="loanAmount">Amount </form:label>
			<form:input path="loanAmount" type="number"/>
		</div>
		<div>
			<form:label path="rateOfInterest">Rate Of Interest </form:label>
			<form:input path="rateOfInterest" type="number"/>
		</div>
		<div>
			<form:label path="timePeriod">Time Period</form:label>
			<form:input path="timePeriod" type="number"/>
		</div>
		<button>Compute</button>
	</form:form>
	
	<div>
		<p>The simple interest for an amount of <strong>${loan.loanAmount }</strong>
		 for a period of <strong>${loan.timePeriod } years</strong>
		at a rate of interst of <strong> ${loan.rateOfInterest} </strong> is 
		<strong> ${loan.simpleInterest } </strong> </p>
	</div>
</body>
</html>