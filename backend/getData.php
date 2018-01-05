<?php

$servername = "sql.pharmawayjn.nazwa.pl";
$username = "pharmawayjn_17";
$password = "slubowaNIE_1";
$dbname = "pharmawayjn_17";

$lekarzType = $_GET["lekarzType"];

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
 }

$sql = "SELECT * FROM baza_lekarze where lekarzType = $lekarzType group by ID";
$conn->query("SET NAMES 'utf8'");
$result = $conn->query($sql);

$return_arr = array();

if ($result->num_rows > 0) {

    while($row = $result->fetch_assoc()) {
        array_push($return_arr,$row);
    }
}
$r = array();
$r["response"] = $return_arr;
echo json_encode($r);

 $conn->close();
 ?>