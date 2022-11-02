<?php
require "dbConnect.php";

$query = "SELECT * FROM danhmuc";
$data = mysqli_query($connect,$query);

/**
 * 
 */
class DanhMuc
{

	function __construct($idDM,$ten,$hinhAnh)
	{
		$this-> idDM = $idDM;
		$this-> ten = $ten;
		$this-> hinhAnh = $hinhAnh;
	}
}

$mangDM = array();
while ($row = mysqli_fetch_assoc($data)) {
	array_push($mangDM, new DanhMuc(
		$row['id_danhmuc'],
		$row['tendanhmuc'],
		$row['hinhanh'],
	));
}

echo json_encode($mangDM);

?>

