<?php

include 'connection.php';

$sql = "SELECT * FROM policestation ORDER BY station_name";

$res = mysqli_query($con,$sql);

$result = array();

while($row = mysqli_fetch_array($res)){
		array_push($result,array(
		//left side json variable name declear, right side tabler attribute name ja json variable e rakha hosse
				"json_station_name"=>$row["station_name"],
				"json_number"=>$row["number"],
				"json_email"=>$row["email"]
			)
		);
	}
	echo json_encode(array("result"=>$result));
	
	//json array name

?>