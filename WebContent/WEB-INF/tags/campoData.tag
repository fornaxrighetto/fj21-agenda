<!-- <%@tag import="com.sun.xml.internal.ws.org.objectweb.asm.Attribute" %> -->
<%@tag import="com.sun.xml.internal.ws.org.objectweb.*" %>
<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ attribute name="id" required="true"%>

<input type="text" id="${id}" name="${id}"/>
<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>