<?php 

include 'connection.php';

 
 
$sql = "SELECT count(id) as count FROM allnews ";

$res=mysqli_query($con,$sql);

$result=array();
while($row=mysqli_fetch_array($res)){
		array_push($result,array(
		//$row["x"] holo database(table) er jonno
		//"x" holo java file er variable
		"count"=>$row["count"],
		
		
		)
	);
}
 
 echo json_encode(array("result"=>$result));
 

 
?>