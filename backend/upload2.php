<?php
$servername = "sql.pharmawayjn.nazwa.pl";
$username = "pharmawayjn_17";
$password = "slubowaNIE_1";
$dbname = "pharmawayjn_17";


// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$inserted = 0;
$row = 1;

$conn->query("SET NAMES 'utf8'");

//$conn->query("DELETE FROM baza_lekarze WHERE 1");
$lekarzType = 1;

if (($handle = fopen("dane2.csv", "r")) !== FALSE) {
    $i = 0;
    while (($data = fgetcsv($handle, 1000, ";")) !== FALSE) {
	if($i == 0) {
		$i++;
		continue;
	}

	for($a = 0; $a < count($data); $a++) {
	//	$data[$a] = str_replace ("''","\"", $data[$a]  );
	//	$data[$a] = str_replace ("'","`", $data[$a]  );
	}

        $num = count($data);
        echo $row . " : ";
        $row++;

		$agentColumn = 0;
		$doctorColumn = 4;
        $idColumn = 2;

		$agent = $data[$agentColumn];
		$doctor = $data[$doctorColumn];
		$id = $data[$idColumn];


		//Nazwa apteki	Adres apteki	Miasto apteki	Kod pocztowy	Województwo	Cegła B1162	Sieci	Pracownik

		$sql = "insert INTO baza_lekarze "
		  ."(`ID`, `lekarzType`,  `agent`,   `lekarz`) VALUES ".
		  "( $id,  $lekarzType,  '$agent', '$doctor')";




		$result = $conn->query($sql);
		if(!$result) die ("error: " . $sql);
$i++;
		$inserted += $result;
		echo $result . " - sql:" . $sql ;

		echo "\n";
    }
    fclose($handle);
	echo "=======================";
	echo "inserted: $inserted ,  total rows: $row";


}

?>