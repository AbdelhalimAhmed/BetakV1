<?php
define('DB_HOST', 'localhost');
define('DB_NAME', 'betak');
define('DB_USER','root');
define('DB_PASSWORD','');
$con=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("Failed to connect to MySQL: "
. mysql_error());
$db=mysql_select_db(DB_NAME,$con) or die("Failed to connect to MySQL: " . mysql_error(
));




$TitleUnits=$_POST['TitleUnits'];
$Type=$_POST['Type'];
$Price=$_POST['Price'];
$NumberOfTunant=$_POST['NumberOfTunant'];
$Place=$_POST['Place'];
$Address=$_POST['Address'];
$PhotoUnit=$_POST['PhotoUnit'];

$sql="INSERT INTO units(TitleUnits,Type,Price,NumberOfTunant,Place,Address, PhotoUnit)
            VALUES('$TitleUnits',  '$Type', '$Price','$NumberOfTunant','$Place', '$Address', '$PhotoUnit')";
 
if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }
echo "welcome ";
 
mysql_close($con);

?>
<form method="POST" action="form.html">

<input id="button" type="submit" name="sign" value="login">
</form> 