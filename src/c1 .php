<?php
$colors = array ("red","green","blue");


foreach($colors as $color){
  
print $color;
  
}
  function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}$requestErr = "";
$name= "";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["name"])) {
    $nameErr = "Name is required";
  }
   else {
 $name= test_input($_POST["name"]);
  }
} 
$name= test_input($_POST[" name"]);
 if (!preg_match("/^[a-zA-Z-' ]*$/",$name)) {
    $nameErr = "Only letters and white space allowed";
    }
    $requestErr = "";
$name= "";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["name"])) {
    $nameErr = "Name is required";
  } else {
 $name= test_input($_POST["name"]);
  }
} 
$name= test_input($_POST[" name"]);
 if (!preg_match("/^[a-zA-Z-' ]*$/",$name)) {
    $nameErr = "Only letters and white space allowed";
    }print $_REQUEST['name'];
  header('p.html');?>