<?php

include("connection.php");
    
   $station_name=$_POST['station_name'];
  
   $res = mysqli_query($con, "select * from policestation where station_name='$station_name'");

	$result = array();

while($row = mysqli_fetch_array($res)){
		array_push($result,array(
				"station_name"=>$row["station_name"],
				"email"=>$row["email"],
				"number"=>$row["number"],
			)
		);
	}
	echo json_encode(array("result"=>$result));

?>