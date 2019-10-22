<?php

include("connection.php");

if(isset($_POST["email"]) && isset($_POST["password"])){
    
   $email=$_POST["email"];
   $password=$_POST["password"];
  
   $result = mysqli_query($con, "select * from login where email='$email' && password='$password'");

	if(mysqli_num_rows($result) > 0){	
		echo "Login";
		exit;
	}			
	else{	
		echo "invalid";
		exit;
	}
}
?>