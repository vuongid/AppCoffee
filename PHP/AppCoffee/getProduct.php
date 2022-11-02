<?php
require "dbConnect.php";

$id = $_POST['idDM'];
$query = "SELECT * FROM sanpham WHERE id_danhmuc = '$id'";
$data = mysqli_query($connect,$query);

/**
 * 
 */
class SanPham
{

	function __construct($idSP,$idDM,$ten,$donGia,$moTa,$hinhAnh)
	{
		$this-> idSP = $idSP;
		$this-> idDM = $idDM;
		$this-> ten = $ten;
		$this-> donGia = $donGia;
		$this-> moTa = $moTa;
		$this-> hinhAnh = $hinhAnh;
	}
}

$mangSP = array();
while ($row = mysqli_fetch_assoc($data)) {
	array_push($mangSP, new SanPham(
		$row['id_sanpham'],
		$row['id_danhmuc'],
		$row['ten'],
		$row['dongia'],
		$row['mota'],
		$row['hinhanh'],
	));
}

echo json_encode($mangSP);

?>

