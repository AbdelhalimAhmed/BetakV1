<?php
header('Content-Type: application/json');

 /*if(isset($_GET['function']) && function_exists($_GET['function']))
 call_user_func($_GET['function']);
 else
 echo "Function not found or wrong input";
 */
//set connection charset ut8;

  // End Configuration
include 'functions.php';

$con = mysqli_connect('127.0.0.1','root','','buzzone');
if (!$con){
	 die('Could not connect: ' . mysqli_error());
}
$tag=$_POST['tag'];

if($tag=='add_user'){
     add_user($con);
}
else if($tag=='add_place'){
	 add_place($con);
}
else if($tag=='getPlacePhotos'){
	 getPlacePhotos($con);
}
else if($tag=='deletePlace'){
	 deletePlace($con);
}
else if($tag=='getPoints'){
	 getPoints($con);
}
else if($tag=='getUserPlaces'){
	 getUserPlaces($con);
}

else if($tag=='getUserFavourites'){
	 getUserFavourites($con);
}
 else if($tag=='add_rate'){
	 add_rate($con);
}
else if($tag=='confirm_place'){
	confirm_place($con);
}
else if($tag=='getplace_rate'){
	getplace_rate($con);
}
else if($tag=='getplace_UserInfo'){
	getplace_UserInfo($con);
}
else if($tag=='get_places'){
	
	 get_places($con);
}
else if($tag=='report_place'){
	report_place($con);
}
else if($tag=='update_location'){
	update_location($con);
}
else if($tag=='setplace_description'){
	setplace_description($con);
}
else if($tag=='setplace_picture'){
	setplace_picture($con);
}
else if($tag=='update_points'){
	update_points($con);
}

?>