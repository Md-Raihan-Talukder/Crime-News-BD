<?php 

include 'connection.php';

 
 
$sql = "SELECT * FROM allnews where id = 75";
$res=mysqli_query($con,$sql);
$result=array();
while($row=mysqli_fetch_array($res)){
		array_push($result,array(
		"id"=>$row["id"],
		"title"=>$row["title"],
		"news"=>$row["news"],
		"time"=>$row["time"],
		
		)
	);
}

 
 echo json_encode(array("result"=>$result));
 
 
 
 


?>