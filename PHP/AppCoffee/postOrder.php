<?php
require "dbConnect.php";

$idKhachHang = $_POST['idKhachHang'];
$ngayBan = $_POST['ngayBan'];
$tongSoLuong = $_POST['tongSoLuong'];
$tongTien = $_POST['tongTien'];
$diaChi = $_POST['diaChi'];
$soDienThoai = $_POST['soDienThoai'];
$query = "INSERT INTO `hoadon` 
		  VALUES (NULL, '$idKhachHang', '$ngayBan', '$tongSoLuong', '$tongTien','$diaChi','$soDienThoai')";

if (mysqli_query($connect,$query)) {
	$idDonHang = $connect -> insert_id;
	echo $idDonHang;
} else {
	echo "ERROR";
}
?>