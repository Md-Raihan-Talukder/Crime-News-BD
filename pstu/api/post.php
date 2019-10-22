<?php
//open connection to mysql db
$connection = mysqli_connect("localhost","root","","pstu")
or die("Error " . mysqli_error($connection));
// recieved from app

$mtitle = $_POST['mytitle'];
$mnews = $_POST['mynews'];
$mdate = $_POST['mydate'];
echo "Response: ".$mtitle." ";
$sql_query = "INSERT INTO information (title,news,time) VALUES ('".$mtitle."','".$mnews."','".$mdate."')";
if (mysqli_query($connection, $sql_query)) {
echo "We just posted a vua news from cool app!";
} else {
echo "Error: " . $sql_query . "<br>" . mysqli_error($connection);
}
mysqli_close($connection);
?>