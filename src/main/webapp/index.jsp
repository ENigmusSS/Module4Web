<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Totalizatorrr</title>
</head>
<body>
<a href="/stats">Stats</a>
<br/>
<a href="/race/start">Start race</a>
<br/>
<form action="race/info" method="get">
  Get race info: <input type="text" name="startTime"/>
  <input type="submit" name="Submit">
</form>
</body>
</html>