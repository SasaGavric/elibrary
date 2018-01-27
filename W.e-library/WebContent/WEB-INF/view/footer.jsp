<!DOCTYPE html>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<html>

<head></head>

<body>
	 <!--Footer-->
<footer class="footer">

    <!--Copyright-->
   
            © <% 
            	Date date = new Date();
            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            	
            	out.print(sdf.format(date));
            
            %> Copyright: <a href="https://www.linkedin.com/in/sasa-gavric-9a667b129"> Sasa Gavric </a> All rights reserved

    <!--/.Copyright-->

</footer>
<!--/.Footer-->
</body>

</html>