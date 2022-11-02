-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 02, 2022 at 06:50 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ql_banhang`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethd`
--

CREATE TABLE `chitiethd` (
  `id_hoadon` int(11) NOT NULL,
  `id_sanpham` int(11) NOT NULL,
  `ten` varchar(100) NOT NULL,
  `hinhanh` varchar(100) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

CREATE TABLE `danhmuc` (
  `id_danhmuc` int(11) NOT NULL,
  `tendanhmuc` text NOT NULL,
  `hinhanh` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`id_danhmuc`, `tendanhmuc`, `hinhanh`) VALUES
(1, 'Cà Phê', 'img_ca_phe'),
(2, 'Trà', 'img_tra'),
(3, 'Đá Xay', 'img_da_xay'),
(4, 'Trà Trái Cây', 'img_trai_cay'),
(5, 'Bánh', 'img_banh');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `id_hoadon` int(11) NOT NULL,
  `id_khachhang` int(11) NOT NULL,
  `ngayban` date NOT NULL,
  `tongsoluong` float NOT NULL,
  `tongtien` float NOT NULL,
  `diachi` varchar(100) NOT NULL,
  `sodienthoai` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `id_khachhang` int(11) NOT NULL,
  `tendangnhap` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `hoten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `sodienthoai` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id_sanpham` int(11) NOT NULL,
  `id_danhmuc` int(11) NOT NULL,
  `ten` text NOT NULL,
  `dongia` int(11) NOT NULL,
  `mota` text NOT NULL,
  `hinhanh` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id_sanpham`, `id_danhmuc`, `ten`, `dongia`, `mota`, `hinhanh`) VALUES
(1, 1, 'Cà Phê Sữa Đá', 29000, 'Cà phê Đắk Lắk nguyên chất được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.', 'img_ca_phe_sua_da'),
(2, 1, 'Bạc Sỉu', 29000, 'Bạc sỉu chính là \"Ly sữa trắng kèm một chút cà phê\". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.', 'img_bac_siu'),
(3, 1, 'Cà Phê Đen Đá', 29000, 'Không ngọt ngào như Bạc sỉu hay Cà phê sữa, Cà phê đen mang trong mình phong vị trầm lắng, thi vị hơn. Người ta thường phải ngồi rất lâu mới cảm nhận được hết hương thơm ngào ngạt, phảng phất mùi cacao và cái đắng mượt mà trôi tuột xuống vòm họng.', 'img_ca_phe_den_da'),
(4, 1, 'Caramel Macchiato Đá', 49000, 'Caramel Macchiato sẽ mang đến một sự ngạc nhiên thú vị khi vị thơm béo của bọt sữa, sữa tươi, vị đắng thanh thoát của cà phê Espresso hảo hạng và vị ngọt đậm của sốt caramel được gói gọn trong một tách cà phê.', 'img_caramel_macchiato_da'),
(5, 1, 'Latte Đá', 49000, 'Một sự kết hợp tinh tế giữa vị đắng cà phê Espresso nguyên chất hòa quyện cùng vị sữa nóng ngọt ngào, bên trên là một lớp kem mỏng nhẹ tạo nên một tách cà phê hoàn hảo về hương vị lẫn nhãn quan.', 'img_latte_da'),
(6, 1, 'Americano Đá', 39000, 'Americano được pha chế bằng cách pha thêm nước với tỷ lệ nhất định vào tách cà phê Espresso, từ đó mang lại hương vị nhẹ nhàng và giữ trọn được mùi hương cà phê đặc trưng.', 'img_americano_da'),
(7, 1, 'Cappuccino Đá', 49000, 'Capuchino là thức uống hòa quyện giữa hương thơm của sữa, vị béo của bọt kem cùng vị đậm đà từ cà phê Espresso. Tất cả tạo nên một hương vị đặc biệt, một chút nhẹ nhàng, trầm lắng và tinh tế', 'img_cappuccino_da'),
(8, 1, 'Espresso Đá', 45000, 'Một tách Espresso nguyên bản được bắt đầu bởi những hạt Arabica chất lượng, phối trộn với tỉ lệ cân đối hạt Robusta, cho ra vị ngọt caramel, vị chua dịu và sánh đặc.', 'img_espresso_da'),
(9, 2, 'Trà Đào Cam Sả Đá', 49000, 'Vị thanh ngọt của đào, vị chua dịu của Cam Vàng nguyên vỏ, vị chát của trà đen tươi được ủ mới mỗi 4 tiếng, cùng hương thơm nồng đặc trưng của sả chính là điểm sáng làm nên sức hấp dẫn của thức uống này.', 'img_tra_dao_cam_sa_da'),
(10, 2, 'Trà Hạt Sen Đá', 49000, 'Nền trà oolong hảo hạng kết hợp cùng hạt sen tươi, bùi bùi và lớp foam cheese béo ngậy. Trà hạt sen là thức uống thanh mát, nhẹ nhàng phù hợp cho cả buổi sáng và chiều tối.', 'img_tra_hat_sen_da'),
(11, 2, 'Trà Long Nhãn Hạt Chia', 49000, 'Vị nhãn ngọt, tươi mát đặc trưng hoà quyện tinh tế cùng vị trà oolong hảo hạng và hạt chia mang đến cho bạn một thức uống không chỉ thơm ngon mà còn bổ dưỡng.', 'img_tra_long_nhan_hat_chia'),
(12, 2, 'Trà Đen Macchiato', 55000, 'Trà đen được ủ mới mỗi ngày, giữ nguyên được vị chát mạnh mẽ đặc trưng của lá trà, phủ bên trên là lớp Macchiato \"homemade\" bồng bềnh quyến rũ vị phô mai mặn mặn mà béo béo.', 'img_tra_den_macchiato'),
(13, 2, 'Hồng Trà Sữa Trân Châu', 55000, 'Thêm chút ngọt ngào cho ngày mới với hồng trà nguyên lá, sữa thơm ngậy được cân chỉnh với tỉ lệ hoàn hảo, cùng trân châu trắng dai giòn có sẵn để bạn tận hưởng từng ngụm trà sữa ngọt ngào thơm ngậy thiệt đã.', 'img_hong_tra_sua_tran_chau'),
(14, 2, 'Trà sữa Oolong Nướng Trân Châu', 55000, 'Hương vị chân ái đúng gu đậm đà với trà oolong được “sao” (nướng) lâu hơn cho hương vị đậm đà, hòa quyện với sữa thơm béo mang đến cảm giác mát lạnh, lưu luyến vị trà sữa đậm đà nơi vòm họng.', 'img_tra_sua_olong_nuong_tran_chau'),
(15, 2, 'Trà Sữa Mắc Ca Trân Châu', 55000, 'Mỗi ngày với The Coffee House sẽ là điều tươi mới hơn với sữa hạt mắc ca thơm ngon, bổ dưỡng quyện cùng nền trà oolong cho vị cân bằng, ngọt dịu đi kèm cùng Trân châu trắng giòn dai mang lại cảm giác “đã” trong từng ngụm trà sữa.', 'img_tra_sua_mac_ca_tran_chau'),
(16, 2, 'Hồng Trà Latte Macchiato', 55000, 'Sự kết hợp hoàn hảo bởi hồng trà dịu nhẹ và sữa tươi, nhấn nhá thêm lớp macchiato trứ danh của The Coffee House mang đến cho bạn hương vị trà sữa đúng gu tinh tế và healthy.', 'img_hong_tra_latte_macchiato'),
(17, 3, 'Đá Xay Xoài Đào', 55000, 'Những miếng đào vàng ươm kết hợp với đá tuyết vị xoài mát lành, cùng nền trà hoa Hibiscus chua dịu đem đến cảm giác lạ miệng, hấp dẫn đến tận ngụm cuối cùng.', 'img_da_xay_xoai_dao'),
(18, 3, 'Đá Tuyết Yuzu Vải', 55000, 'Vị trà hoa Hibiscus chua chua, kết hợp cùng đá tuyết Yuzu mát lạnh tái tê, thêm miếng vải căng mọng, ngọt ngào sẽ khiến bạn thích thú ngay từ lần thử đầu tiên.', 'img_da_xay_yuzu_vai'),
(19, 4, 'Trà Xoài Aloe Vera', 49000, 'Vị ngọt thanh, thơm phức từ xoài chín mọng kết hợp cùng vị chua đặc trưng của trà hoa Hibiscus tự nhiên, sẽ khiến bạn khó lòng quên được thức uống “chân ái” mùa hè này. Đặc biệt, topping Aloe Vera tự nhiên không chỉ nhâm nhi vui miệng mà còn giúp bạn “nâng tầm nhan sắc”.', 'img_tra_xoai_aloe_vera'),
(20, 4, 'Trà Dâu Tây Mận Muối Aloe Vera', 49000, 'Sự kết hợp độc đáo giữa 3 sắc thái hương vị khác nhau: trà hoa Hibiscus chua thanh, Mận muối mặn mặn và Dâu tây tươi Đà Lạt cô đặc ngọt dịu. Ngoài ra, topping Aloe Vera tươi mát, ngon ngất ngây, đẹp đắm say, hứa hẹn sẽ khuấy đảo hè này.', 'img_tra_dau_tay_man'),
(21, 4, 'Trà Vải', 49000, 'Chút ngọt ngào của Vải, mix cùng vị chua thanh tao từ trà hoa Hibiscus, mang đến cho bạn thức uống đúng chuẩn vừa ngon, vừa healthy.', 'img_tra_vai'),
(22, 5, 'Bánh Mì Que Pate', 15000, 'Vỏ bánh mì giòn tan, kết hợp với lớp nhân pate béo béo đậm đà sẽ là lựa chọn lý tưởng nhẹ nhàng để lấp đầy chiếc bụng đói , cho 1 bữa sáng - trưa - chiều - tối của bạn thêm phần thú vị.', 'img_band_mi_que_pate'),
(23, 5, 'Mochi Kem Phúc Bồn Tử', 19000, 'Bao bọc bởi lớp vỏ Mochi dẻo thơm, bên trong là lớp kem lạnh cùng nhân phúc bồn tử ngọt ngào. Gọi 1 chiếc Mochi cho ngày thật tươi mát. Sản phẩm phải bảo quán mát và dùng ngon nhất trong 2h sau khi nhận hàng.', 'img_mochi_kem_phuc_bon_tu'),
(24, 5, 'Mochi Kem Việt Quất', 19000, 'Bao bọc bởi lớp vỏ Mochi dẻo thơm, bên trong là lớp kem lạnh cùng nhân việt quất đặc trưng thơm thơm, ngọt dịu. Gọi 1 chiếc Mochi cho ngày thật tươi mát. Sản phẩm phải bảo quán mát và dùng ngon nhất trong 2h sau khi nhận hàng.', 'img_mochi_kem_viet_quat');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`id_hoadon`,`id_sanpham`),
  ADD KEY `chitiethd_ibfk_1` (`id_sanpham`);

--
-- Indexes for table `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`id_danhmuc`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id_hoadon`),
  ADD KEY `id_khachhang` (`id_khachhang`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id_khachhang`),
  ADD UNIQUE KEY `tendangnhap` (`tendangnhap`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id_sanpham`),
  ADD KEY `id_danhmuc` (`id_danhmuc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `id_danhmuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id_hoadon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id_khachhang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id_sanpham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `chitiethd_ibfk_1` FOREIGN KEY (`id_sanpham`) REFERENCES `sanpham` (`id_sanpham`),
  ADD CONSTRAINT `chitiethd_ibfk_2` FOREIGN KEY (`id_hoadon`) REFERENCES `hoadon` (`id_hoadon`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`id_khachhang`) REFERENCES `khachhang` (`id_khachhang`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`id_danhmuc`) REFERENCES `danhmuc` (`id_danhmuc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
