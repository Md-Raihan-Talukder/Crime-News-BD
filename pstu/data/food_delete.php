<?php 

include 'connection.php';
 
 $title = $_POST['title'];

 
 $sql="DELETE FROM information where title ='$title'";
 
 if(mysqli_query($con,$sql)){
	echo "Successfully Deleted";
 }else{
	echo "Error";
 }
 
 
 
 


?>