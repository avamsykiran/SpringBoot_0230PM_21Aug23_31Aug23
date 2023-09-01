<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
<title>Our Web Home</title>
</head>
<body>
	<nav>
		<a href="/home">Home Page</a>
	</nav>
	<h3>Friends</h3>

	<form>
		<label>Friend Name: <input type="text" name="friend" />
		</label>
		<button>Add</button>
	</form>

	<c:if test="${friends.isEmpty() }">
		<p><strong>No Friends</strong>
	</c:if>
	
	<c:if test="${!friends.isEmpty() }">
		<h4>Friends List</h4>
		<ol>
			<c:forEach var="f" items="${friends }">
				<li>${f }</li>
			</c:forEach>
		</ol>
	</c:if>
	
	
</body>
</html>