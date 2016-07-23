<html>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<head>

	<title>betak </title>

	</head>
	<body>

<?php
define('DB_HOST', 'localhost');
define('DB_NAME', 'betak');
define('DB_USER','root');
define('DB_PASSWORD','');
$con=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("Failed to connect to MySQL: "
. mysql_error());
mysql_query('set names "utf8";');
$db=mysql_select_db(DB_NAME,$con) or die("Failed to connect to MySQL: " . mysql_error(
));

$strSQL = "SELECT * FROM units";
$rs = mysql_query($strSQL);
while($row = mysql_fetch_array($rs)) {

	   // Write the value of the column FirstName (which is now in the array $row)
	  echo $row['TitleUnits'] . " " . $row['Type'] ." ".$row['PhotoUnit'] .  "<br />";

	  }
     mysql_close($con);

?>

    </body>
</html>