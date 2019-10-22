<?php

	$server_name = "127.0.0.1";
	$user_name = "root";
	$password = "";
	$db= 'pstu';
	
	$con = mysqli_connect($server_name, $user_name, $password, $db);

	if(!$con){
		die("Error Connection");
	}
	else{
		//echo "Connection OK";
	}

?>