<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

<script type='text/javascript' src='/dwr-example/dwr/interface/Member.js'></script>
<script type='text/javascript' src='/dwr-example/dwr/engine.js'></script>
<script type='text/javascript'>
	dwr.engine.setActiveReverseAjax(true);
/* 	Member.getA({
		callback : function(str) {
			alert(str);
		}
	}); */
	
	function update(time) {
		document.getElementById("time").value = time;
	}
	
	function shout() {
		try {
			Member.shout();
		} catch (err) {
			console.debug(err);
		}
	}
</script>
</head>
<body>

<input type="button" value="shout" onclick="shout()" />
<input type="text" id="time"/>
</body>
</html>
