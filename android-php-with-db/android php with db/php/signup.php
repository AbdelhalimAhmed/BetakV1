<?php
define('DB_HOST', 'localhost');
define('DB_NAME', 'betak');
define('DB_USER','root');
define('DB_PASSWORD','');
$con=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("Failed to connect to MySQL: "
. mysql_error());
$db=mysql_select_db(DB_NAME,$con) or die("Failed to connect to MySQL: " . mysql_error(
));




$username=$_POST['username'];
$email=$_POST['email'];
$Password=$_POST['Password'];
$ConfirmPassword=$_POST['ConfirmPassword'];
$PhoneUsers=$_POST['PhoneUsers'];
$Gender=$_POST['Gender'];
$Photo=$_POST['Photo'];

$sql="INSERT INTO users(NameUsers,EmailUsers,Password,ConfirmPassword,PhoneUsers,Gender, Photo)
            VALUES('$username',  '$email', '$Password','$ConfirmPassword','$PhoneUsers', '$Gender', '$Photo')";
 
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