<?php
require "dbConnect.php";
	
$tenDangNhap = $_POST['tenDangNhap'];
$matKhau = $_POST['matKhau'];

// $tenDangNhap = '1';
// $matKhau = '1';

$query = "SELECT * FROM khachhang WHERE tendangnhap = '$tenDangNhap' AND matkhau = '$matKhau'";
$data = mysqli_query($connect,$query);
if ($data) {
	while($row = mysqli_fetch_assoc($data)){
		$response = $row;
		echo json_encode($response);
	}
}
?>