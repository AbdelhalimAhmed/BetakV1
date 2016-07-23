<?php
define('DB_HOST', 'localhost');
define('DB_NAME', 'villa');
define('DB_USER','root');
define('DB_PASSWORD','');
$con=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("Failed to connect to MySQL: "
. mysql_error());
$db=mysql_select_db(DB_NAME,$con) or die("Failed to connect to MySQL: " . mysql_error(
));
/*
$ID = $_POST['user'];
$Password = $_POST['pass'];
*/
function SignIn()
{
session_start(); //starting the session for user profile page
if(!empty($_POST['user'])) //checking the 'user' name which is from Sign‐In.html, is it empty or have some text

{
$query = mysql_query("SELECT * FROM users where UserName = '$_POST[user]'
AND PassUser = '$_POST[pass]'") or die(mysql_error());
$row = mysql_fetch_array($query) or die(mysql_error());
if(!empty($row['UserName']) AND !empty($row['PassUser']))
{
$_SESSION['UserName'] = $row['PassUser'];
echo "SUCCESSFULLY LOGIN TO USER PROFILE PAGE...";
}
else
{
echo "SORRY... YOU ENTERD WRONG ID AND PASSWORD... PLEASE RETRY...";
}
}
}
if(isset($_POST['submit']))
{
SignIn();
}
?>

<!DOCTYPE HTML> <html>
<head>
    <title>item here</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body id="body-color">
    <div id="Sign-Up">
       <form name="reg" action="item.php" onsubmit="return validateForm()" method="post">
<table width="274" border="0" align="center" cellpadding="2" cellspacing="0">
  <tr>
    <td colspan="2">
		<div align="center">
		  <?php 
		$remarks=$_GET['remarks'];
		if ($remarks==null and $remarks=="")
		{
		echo 'item Here';
		}
		if ($remarks=='success')
		{
		echo 'Registration Success';
		}
		?>	
	    </div></td>
  </tr>
  <tr>
    <td width="95"><div align="right">ID:</div></td>
    <td width="171"><input type="text" name="id" /></td>
  </tr>
  
  <tr>
    <td width="95"><div align="right">price:</div></td>
    <td width="171"><input type="text" name="price" /></td>
  </tr>
  <tr>
    <td><div align="right">image :</div></td>
    <td><input type="text" name="img" /></td>
  </tr>
  <tr>
    <td><div align="right">title:</div></td>
    <td><input type="text" name="ti" /></td>
  </tr>
  <tr>
    
    <td><div align="right">notes:</div></td>
    <td><input type="text" name="no" /></td>
  </tr>
  <tr>
    
    <td><div align="right">govern:</div></td>
    <td><input type="text" name="go" /></td>
  </tr>
  <tr>
    
    <td><div align="right">area :</div></td>
    <td><input type="text" name="ar" /></td>
  </tr>
  <tr>
    
    
    <td><div align="right">address:</div></td>
    <td><input type="text" name="ad" /></td>
  </tr>
  
    
    
    
    <td><div align="right"></div></td>
    <td><input name="submit" type="submit" value="Submit" /></td>
  </tr>
</table>
</form>
	  
	  
	   
    </div>
</body>
</html>



