<?php

function add_user($connection){
    
     $response=array();
     $u_id=$_POST['u_id'];
     $u_photo=$_POST['u_photo'];
     $u_Name=$_POST['u_Name']; 
    // $add_query="CALL Add_user('".$u_id."','".$u_Name."','".$u_photo."');";
     $add_query="INSERT INTO user(fb_id,name,photo) values('".$u_id."','".$u_Name."','".$u_photo."');";
	 $my_query=mysqli_query($connection,$add_query) ;
     if(!$my_query){
        echo "notDone".$my_query.mysqli_error($connection);
      }
     else{
        echo "done";
      }  
}

function add_place($connection){
    
	  $response=array();
      $u_id=$_POST['u_id'];
      $p_name=$_POST['p_name'];
      $p_location=$_POST['p_location'];
      $p_description=$_POST['p_description'];
      $p_picture=$_POST['p_picture'];
      $p_category=$_POST['p_category']; 
      $flag=$_POST['flag']; 
    //  $query="CALL Add_place($u_id,'".$p_location."','".$p_name."','".$p_picture."','".$p_category."','".$p_description."');"; 
      $query=" insert into places (user_id,location,name,description,picture,com.example.halim.betak.category)
                  values('".$u_id."','".$p_location."','".$p_name."','".$p_picture."','".$p_category."','".$p_description."'); 
                  insert into user_places (flag,user_id,location) values($flag,'".$u_id."','".$p_location."')";
                  
	  $my_query=mysqli_query($connection,$query) ;
	   if(!$my_query){
	       echo $query;
        echo "notDone";
        echo mysqli_error($connection);
      }
     else{
       echo "done";
      }  
}

function add_rate($connection){
    
	 $response=array();
     $u_id=$_POST['u_id'];
     $p_location=$_POST['p_id'];
     $r_value=$_POST['r_value'];
     $comment=$_POST['comment'];
     
    // $query="CALL Add_rate($u_id,'".$p_location."',$r_value);";
     $query="insert into rating (user_id,location_id,rate,comment)values('".$u_id."',".$p_id.",".$r_value.",'".$comment."')
                ON DUPLICATE KEY UPDATE rate=".$r_value." , comment= '".$comment."' ";
	 $my_query=mysqli_query($connection,$query);
	if(!$my_query){
        echo "notDone";
      }
     else{
       echo "done";
      }  
}

 // need to update the android code to store location id in a hidden feild and use it in place info screeen
 
 function confirm_place($connection){
    
     $response=array();
     $p_location=$_POST['p_location'];
    // $query="CALL confirm_place($p_location);";
     $query="update places set confirm_no = confirm_no + 1 where location = $p_location";
	 $my_query=mysqli_query($connection,$query) ;
    if(!$my_query){
        echo "notDone";
      }
     else{
       echo "done";
      }  
 }
 // need to update the android code to store location id in a hidden feild and use it in place info screeen
 
 function getplace_rate($connection){

     $p_id=$_POST['p_id'];
   //  $query="CALL GetPlace_rate('".$p_location."');";
   // $query=" select (sum(rate)/count(location_id)) As rate_value from rating 
   //        where location_id = (select id from places where location='".$p_location."') union select * from place where location='".$p_location."'";
             
    $query= " select (sum(rate)/count(location_id)) As rate_value from rating 
            	where location_id = '".$p_id."' ";
     if (mysqli_multi_query($connection,$query))
    {
        if ($result=mysqli_store_result($connection))
          {
          while ($row=mysqli_fetch_row($result))
            {
              echo $row[0];
            }
          }
    }
    else
    {
        echo -1;
    }
 }
 
 function get_places($connection){
     //$result="CALL Get_places();";
     $result="select * from places";
	 $result=mysqli_query($connection,$result) ;
	  if(mysqli_num_rows($result)>0){
   	  $response["places"] = array();
		 while($row=mysqli_fetch_array($result)){
			 $place=array();
			 $place["p_id"]=$row["id"];
			 $place["p_name"]=$row["name"];
             $place["p_picture"]=$row["picture"];
			 $place["p_description"]=$row["description"];
			 $place["p_location"]=$row["location"];
			 $place["p_category"]=$row["com.example.halim.betak.category"];
			 $place["p_numConfirms"]=$row["confirm_no"];
			 $place["p_numReports"]=$row["report_no"];
			 $place["u_id"]=$row["user_id"];
             array_push($response["places"], $place); 
		 }
             echo json_encode($response);
	  }
 }
 
  // need to update the android code to store location id in a hidden feild and use it in place info screeen
  
 function report_place($connection){
	 $response=array();
	 $p_location=$_POST['p_location'];
    // $result="CALL Report_place($p_location);";
     $result="update places set report_no = report_no + 1 where location = '".$p_location."' ";
	 $result=mysqli_query($connection,$result);
     if(!$result){
        echo "notDone";
      }
     else{
       echo "done";
      }  
 }
 
 function setplace_description($connection){
	 $response=array();
	 $p_location=$_POST['p_location'];
	 $p_description=$_POST['p_description'];
    // $query="CALL setPlace_description('".$p_location."','".$p_description."');";
     $query="update places set description = '".$p_description."' where location = '".$p_location."'";
	 $result=mysqli_query($connection,$query);
	 if(!$result){
        echo "notDone";
      }
     else{
       echo "done";
      }  
 }
 
 function setplace_picture($connection){
	 $response=array();
     $p_location=$_POST['p_location'];
     $p_picture=$_POST['p_picture'];
    // $result="CALL setPlace_picture('".$p_location."','".$p_picture."');";
     $result="update places set picture = '".$p_picture."' where location = '".$p_location."' ";
	 $result=mysqli_query($connection,$result);
	 if(!$result){
        echo "notDone";
      }
     else{
       echo "done";
      }  
 }
 
 function update_location($connection){
	 $response=array();
     $u_id=$_POST['u_id'];
	 $u_location=$_POST['u_location'];
    // $query="CALL update_location($u_id,'".$u_location."');";
     $query="update user set user_location = '".$u_location."' where fb_id = $u_id";
     $result=mysqli_query($connection,$query);
	 if(!$result){
        echo "notDone";
      }
     else{
       echo "done";
      }  
}

 function update_points($connection){
	 $response=array();
     $u_id=$_POST['u_id'];
	 $points=(int)$_POST['points'];
    // $query="CALL update_points($points,$u_id);";
     $query="update user set points = points+$points where fb_id = $u_id";
	 $result=mysqli_query($connection,$query);
     if(!$result){
        echo "notDone";
      }
     else{
       echo "done";
      }  
 }
 
 function getUserPlaces($connection)
 {
     $userID=$_POST['u_id'];
    // $result="CALL getUserPlaces(".$userID.");";
     $result="select picture,name,com.example.halim.betak.category from places where user_id=".$userID." ";
	 $result=mysqli_query($connection,$result) ;
	  if(mysqli_num_rows($result)>0){
	   
             $response["MyPlaces"]=array();
            
		 while($row=mysqli_fetch_array($result)){
		         	      
                $myplace=array(); 
                $myplace["picture"]=$row["picture"];
                $myplace["com.example.halim.betak.category"]=$row["com.example.halim.betak.category"];
                $myplace["name"]=$row["name"];
                array_push($response["MyPlaces"], $myplace);
		 }
             
             echo json_encode($response);
    }
 }
 
  function getUserFavourites($connection)
 {
     $userID=$_POST['u_id'];
    // $result="CALL get_favourites(".$userID.");";
     $result= "select name,com.example.halim.betak.category,picture from places inner join user_places on places.location=user_places.location
                and user_places.user_id=".$userID." and user_places.flag=1";
	 $result=mysqli_query($connection,$result) ;
	  if(mysqli_num_rows($result)>0){
	   
             $response["Favourites"]=array();
            
		 while($row=mysqli_fetch_array($result)){
		         	      
                $myplace=array(); 
                $myplace["picture"]=$row["picture"];
                $myplace["com.example.halim.betak.category"]=$row["com.example.halim.betak.category"];
                $myplace["name"]=$row["name"];
                array_push($response["Favourites"], $myplace);
		 }
             
             echo json_encode($response);
    }
 }
 
   function getplace_UserInfo($connection)
 {
     $placeID=$_POST['placeID'];
    // $result="CALL getplace_UserInfo(".$placeID.");";
     $reult="select R.rate,R.comment,U.name,U.photo from rating as R inner join
                  user as U on U.fb_id = R.user_id and R.location_id=".$placeID." ";
	 $result=mysqli_query($connection,$result) ;
	  if(mysqli_num_rows($result)>0){
	   
             $response["Info"]=array();
            
		 while($row=mysqli_fetch_array($result)){
		         	      
                $UserInfo=array(); 
                $UserInfo["name"]=$row["name"];
                $UserInfo["photo"]=$row["photo"];
                $UserInfo["comment"]=$row["comment"];
                $UserInfo["rate"]=$row["rate"];
                
                array_push($response["Info"], $UserInfo);
		 }
             
             echo json_encode($response);
    }
 }
 
 
 function getPoints($connection)
 {
     $userID=$_POST['u_id'];
     //$query="CALL GetPoints(".$userID.");";
     $query="select points from user where fb_id=".$userID." ";
	  if (mysqli_multi_query($connection,$query))
        {
            if ($result=mysqli_store_result($connection))
              {
              while ($row=mysqli_fetch_row($result))
                {
                  echo $row[0];
                }
              }
        }
        else
        {
            echo -1;
        }
 }
 
 function deletePlace($connection)
 {
     $u_id=$_POST['u_id'];
     $u_id=$_POST['$p_location'];
   //  $query="CALL deletePlace($p_location,$u_id);";
     $query="delete from places where location=$p_location and user_id=$u_id";
	 $result=mysqli_query($connection,$query);
     if(!$result){
        echo "notDone";
      }
     else{
       echo "done";
      }  
 }
 
  function getPlacePhotos($connection)
 {
     $p_id=$_POST['placeID'];
    // $query="CALL getPlacePhotos($p_id);";
     $query="select photo from placesphotos where placeID=$p_id";
	 $result=mysqli_query($connection,$query);
     if(mysqli_num_rows($result)>0){
            $response["photos"] = array();
		 while($row=mysqli_fetch_array($result)){
			 $photo=array();
			 $photo["photo"]=$row["photo"];
             array_push($response["photos"], $photo); 
		 }
             echo json_encode($response);
    }
 }
?>