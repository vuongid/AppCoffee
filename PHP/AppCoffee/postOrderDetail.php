<?php
require "dbConnect.php";

$idHoaDon = $_POST['idHoaDon'];
$idSanPham = $_POST['idSanPham'];
$ten = $_POST['ten'];
$hinhAnh = $_POST['hinhAnh'];
$soLuong = $_POST['soLuong'];
$donGia = $_POST['donGia'];

$query = "INSERT INTO `chitiethd` (`id_hoadon`, `id_sanpham`, `ten`, `hinhanh`, `soluong`, `dongia`) 
			VALUES ('$idHoaDon', '$idSanPham', '$ten', '$hinhAnh', '$soLuong', '$donGia')";

if (mysqli_query($connect, $query)) {
	echo "SUCCESS";
} else {
	echo "ERROR";
}


?>