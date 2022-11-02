<?php
require "dbConnect.php";
	
$tenDangNhap = $_POST['tenDangNhap'];
$matKhau = $_POST['matKhau'];
$hoTen = $_POST['hoTen'];
$diaChi = $_POST['diaChi'];
$soDienThoai = $_POST['soDienThoai'];

$query = "INSERT INTO `khachhang` VALUES (NULL, '$tenDangNhap', '$matKhau', '$hoTen', '$diaChi', '$soDienThoai')"; 
if (mysqli_query($connect,$query)) {
	echo "SUCCESS";
} else {
	echo "ERROR";
}
?>