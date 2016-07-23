<html>
<head>
  <title>Search</title>
</head>
<body>
<?php
$host = "localhost";
$dbuser = "root";
$dbpass = "";
$db = "betak";

$con = mysql_connect($host, $dbuser, $dbpass);
if(!$con){
die(mysql_error());
}
$select = mysql_select_db($db, $con);
if(!$select){
die(mysql_error());
}
$item = $_REQUEST['find'];
if($item == "")
{
        echo "&Ccedil;&auml;&Ecirc; &aacute;&atilde; &Ecirc;&szlig;&Ecirc;&Egrave; &szlig;&aacute;&atilde;&Eacute; &Ccedil;&aacute;&Egrave;&Iacute;&Euml;";
}
else
{
$data = mysql_query("SELECT * FROM units WHERE price LIKE '%$item%'");
while($row = mysql_fetch_array($data)){
echo $row['IdUnits']. "<br>";
echo $row['price']. "<br>";
}
}

?>