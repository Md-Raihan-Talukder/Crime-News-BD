<?php 

include 'connection.php';

 
 
$sql = "SELECT count(id) as illegal FROM allnews where type='illegal' and location='Barisal' ";
$res=mysqli_query($con,$sql);
$result=array();
while($row=mysqli_fetch_array($res)){
		array_push($result,array(
		//$row["x"] holo database(table) er jonno
		//"x" holo java file er variable
		"illegal"=>$row["illegal"],
		)
	);
}

 echo json_encode(array("result"=>$result));
?>