<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!doctype html>
<head>  
	<title><spring:message code="application.title"/></title>  
</head>  
<body>  
	

	<c:url var="gprCupLink" value="/gprcup/main.html"/>	
	<c:url var="gprCupIcon" value="/images/trophy-png-23.png"/>
	<c:url var="gprResultsLink" value="/results/results.html"/>	
	
	<security:authorize access="hasAuthority('Admin')">
	<div class="row">
	  <div class="col-xs-6 col-md-3">
	    <a href="${gprCupLink}" class="thumbnail">
	      <img src="${gprCupIcon}" title="<spring:message code="label.copa"/>" width="171" height="180">
	    </a>
	  </div>
	</div>
	
	<div>
		<a href="${gprResultsLink}">Resultados</a>
	</div>
	
	</security:authorize>

	<c:url value="/perform_logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post" >
  		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<button class="btn btn-link" type="submit">Logout (${pageContext.request.userPrincipal.name})
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</button>
		</c:if>	
	</form>
</body>  
</html>  