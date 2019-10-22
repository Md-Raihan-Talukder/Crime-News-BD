<?php

include 'connection.php';

$sql = "SELECT * FROM robbery ORDER BY id DESC";

$res = mysqli_query($con,$sql);

$result = array();

while($row = mysqli_fetch_array($res)){
		array_push($result,array(
				"title"=>$row["title"],
				"news"=>$row["news"],
				"time"=>$row["time"],
				"location"=>$row["location"]
			)
		);
	}
	echo json_encode(array("result"=>$result));

?>