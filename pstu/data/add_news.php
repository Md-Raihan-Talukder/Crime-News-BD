<?php 

include 'connection.php';
 
 //$user_type = $_POST['user_type'];
 $title = $_POST['title'];
 $news = $_POST['news'];
 $time = $_POST['time'];
 $type = $_POST['type'];
 $location = $_POST['location'];
 
 $sql = "insert into allnews (title,news,time,type,location) values('$title','$news','$time','$type','$location')";
 
 if($type=="murder"){
	$sql2 = "insert into murder (title,news,location,time) values('$title','$news','$location','$time')";
	mysqli_query($con,$sql2);
 }
 
  if($type=="rape"){
	$sql3 = "insert into rape (title,news,location,time) values('$title','$news','$location','$time')";
	mysqli_query($con,$sql3);
 }

  if($type=="corruption"){
	$sql4 = "insert into corruption (title,news,location,time) values('$title','$news','$location','$time')";
	mysqli_query($con,$sql4);
 }
 
  if($type=="sports"){
	$sql5 = "insert into sports (title,news,location,time) values('$title','$news','$location','$time')";
	mysqli_query($con,$sql5);
 }
 
  if($type=="illegal"){
	$sql6 = "insert into illegal (title,news,location,time) values('$title','$news','$location','$time')";
	mysqli_query($con,$sql6);
 }
 
  if($type=="robbery"){
	$sql7 = "insert into robbery (title,news,location,time) values('$title','$news','$location','$time')";
	mysqli_query($con,$sql7);
 }
 
 if(mysqli_query($con,$sql)){
	echo "Success";
 }else{
	echo "Error";
 }
?>