<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <spring:url value="http://localhost:8080/spring_hibernate" var="url" htmlEscape="true"/>

<div class="wrapper">
	<span class="pull-right">
		Designed & Developed By <a href="#" target="_blank">H kapil Kumar</a>
	</span>
</div>

<script type="text/javascript" src="${url }/resources/js/jquery.js"></script>
<script type="text/javascript" src="${url }/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${url }/resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${url }/resources//assets/js/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="${url }/resources//assets/js/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="${url }/resources//assets/js/ace/ace.js"></script>
<script type="text/javascript" src="${url }/resources//assets/js/ace/mode-html.js"></script>
<script type="text/javascript" src="${url }/resources//assets/js/ace/theme-github.js"></script>

<script>
$("#date").datepicker({
	format:'dd/mm/yyyy'
	});
	
	function response(val)
	{
		window.open(""+val, "", "width=600,height=600");
	}
</script>
