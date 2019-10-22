<?PHP

include("connection.php");

if(isset($_POST['name']) && isset($_POST['email'])&& isset($_POST['password'])){
	
	$name=$_POST["name"];
    $email=$_POST["email"];
    $password=$_POST["password"];
	$pin=$_POST["pin"];
	
	$age=$_POST["age"];
	$gender=$_POST["gender"];
	$division=$_POST["division"];
	$district=$_POST["district"];
	$phone=$_POST["phone"];
    
	$result = mysqli_query($con, "SELECT email FROM login WHERE email = '".$email."'");	
	
	if(mysqli_num_rows($result) > 0){	
		echo "email exist";
		exit;
	}			
	else if($pin=="112233"){	
      
	  $query="INSERT INTO login(name,email,password,pin,age,gender,division,district,phone)VALUES('$name','$email','$password','$pin','$age','$gender','$division','$district','$phone')";
      $data=mysqli_query($con,$query);
 
    if($data){
            echo "Successfully Signed In";
      }
    else{
            echo "Error Sign in";
      }
		exit;
	}	
}				

?>