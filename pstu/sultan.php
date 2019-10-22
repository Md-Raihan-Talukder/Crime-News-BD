<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PSTU News</title>
<!-- Bootstrap -->
<link href="ext/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #f9f9f9">
<div class="container">
<div class="row">
<div class="col-md-1"></div>
<div class="col-md-10" style="margin-top: 60px">
<h3> PSTU News </h3><p>24 ghonTa TaJa khobor </p>
<span class="label label-success">Welcome to pstu news</span>
<span class="label label-danger" style="margin-left: 10px; margin-right: 10px;"> By: Sultan Ahmed </span>
<?php
//open connection to mysql db
$connection = mysqli_connect("localhost","root","","pstu")
or die("Error" . mysqli_error($connection));
//fetch table rows from mysql db
$sql = "select * from information";
$result = mysqli_query($connection, $sql)
or die("Error in Selecting" . mysqli_error($connection));
//create an array
// $emparray[] = array();
while($row =mysqli_fetch_assoc($result))
{
$emparray[] = $row;
}
//print_r($emparray);
// echo json_encode($emparray);
?>
<table class="table table-hover" style="margin-top: 20px;">
<tr class="success">
<td><b>Id</b></td>
<td><b>Topic</b></td>
<td><b>Details</b></td>
</tr>
<?php foreach( $emparray as $vale): ?>
<tr class ="info">
<td>
<?php echo $vale['id']; ?>
</td>
<td>
<?php echo $vale['title']." (".$vale['time'].")"; ?>
</td>
<td>
<?php echo $vale['news']; ?>
</td>
</tr>
<?php endforeach; ?>
</table>
<?php
//close the db connection
mysqli_close($connection);
?>
</div>
<div class="col-md-1"></div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="ext/ootstrap.min.js"></script>
</body>
</html>