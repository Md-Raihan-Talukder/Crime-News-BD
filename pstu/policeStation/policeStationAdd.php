<?php 

include 'connection.php';
 
 //$user_type = $_POST['user_type'];
 $receive_station_name = $_POST['send_station_name'];
 $receive_number = $_POST['send_number'];
 $receive_email = $_POST['send_email'];
 //android theke pathano send_email,send_number,send_station_name POST method dara receive kora holo
 
 $sql = "insert into policestation(station_name,number,email) values('$receive_station_name','$receive_number','$receive_email')";

 if(mysqli_query($con,$sql)){
	echo "Success";
 }else{
	echo "Error";
 }
?>