
<?php
//open connection to mysql db
$connection = mysqli_connect("localhost","root","","pstu")
or die("Error" . mysqli_error($connection));
/* //fetch table rows from mysql db
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
 echo json_encode($emparray);
?>

<?php
//close the db connection
mysqli_close($connection); */

$sql = "SELECT * FROM information";

$res = mysqli_query($connection,$sql);

$result = array();

while($row = mysqli_fetch_array($res)){
		array_push($result,array(
				"mtitle"=>$row["mytitle"],
				"mnews"=>$row["mynews"],
				"mdate"=>$row["mydate"]
			)
		);
	}
	echo json_encode(array("result"=>$result));


?>
