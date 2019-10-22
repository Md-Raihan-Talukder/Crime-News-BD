<?php 

include 'connection.php';

 
 
$sql = "SELECT count(id) as murder FROM allnews where type='murder' and location='Dhaka' ";
$res=mysqli_query($con,$sql);
$result=array();
while($row=mysqli_fetch_array($res)){
		array_push($result,array(
		//$row["x"] holo database(table) er jonno
		//"x" holo java file er variable
		"murder"=>$row["murder"],
		)
	);
}

$sql2 = "SELECT count(id) as murder FROM allnews where type='murder' and location='Dhaka' ";
$res2=mysqli_query($con,$sql);
$result2=array();
while($row=mysqli_fetch_array($res2)){
		array_push($result2,array(
		//$row["x"] holo database(table) er jonno
		//"x" holo java file er variable
		"murder"=>$row["murder"],
		)
	);
}
 
 echo json_encode(array("result"=>$result));
  echo json_encode(array("result2"=>$result2));
?>