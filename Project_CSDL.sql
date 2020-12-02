create database qlhanghoa;
use qlhanghoa;

create table  NT_SanPham  (
	MaHang varchar(10) primary key not null,
    TenHang varchar(30) not null,
    DonGia float not null,
    NoiSx varchar(30),
	NgaySx date 
);


create table NT_NhanVien (
	MaNv varchar(10) primary key not null,
    TenNv varchar(30) not null,
    GioiTinh varchar(10) not null,
    Ngaysinh date not null,
    DienThoai int not null,
	Luong float
);

create table NT_KhachHang (
	MaKhachHang varchar(10) primary key not null,
    TenKhachHang varchar(30) not null,
    NgaySinh date not null,
    DiaChi varchar(50),
    NgayGiaNhap date,
    Diem int check(Diem >= 0)
);

create table NT_HoaDon (
	SoHoaDon varchar(10) primary key not null,
    MaNv varchar(10) not null ,
    ThoiGian datetime,
    GiaTri float not null,
    MaKhachHang varchar(10),
    FOREIGN KEY (MaNv) REFERENCES NT_NhanVien(MaNv) , 
    FOREIGN KEY (MaKhachHang) REFERENCES NT_KhachHang(MaKhachHang)
);



create table NT_ChiTietHoaDon (
	SoHoaDon varchar(10) not null,
    MaHang varchar(10) not null,
    SoLuong int not null,
    CONSTRAINT chitiethoadon_pk PRIMARY KEY (SoHoaDon, MaHang),
    FOREIGN KEY (SoHoaDon) REFERENCES NT_HoaDon(SoHoaDon), 
    FOREIGN KEY (MaHang) REFERENCES NT_SanPham(MaHang)
);


select * from NT_SanPham;
insert into NT_SanPham values ("A0001","Xa phong",5000,"Phap","2020-05-04");
insert into NT_SanPham values ("A0002","Dau An",12000,"Viet Nam","2020-02-01");
insert into NT_SanPham values ("A0003","Mi Goi",3000,"Viet Nam","2019-09-12");
insert into NT_SanPham values ("A0004","Bot Giat",20000,"Han Quoc","2018-03-21");
insert into NT_SanPham values ("A0005","Dau Goi",32000,"Thai Lan","2020-09-01");
insert into NT_SanPham values ("A0006","Sua Tam",42000,"Trung Quoc","2019-02-01");

select * from NT_NhanVien;
insert into NT_NhanVien values("NV0001","Nguyen Nhi Thai","Nam","2020-06-04",0395996992,5000);
insert into NT_NhanVien values("NV0002","Nguyen Thi Thao","Nu","2000-04-30",0395969991,6000);
insert into NT_NhanVien values("NV0003","Vo Thanh Long","Nam","2000-12-1",0395996001,1000);
insert into NT_NhanVien values("NV0004","Bui Quoc Trong","Nam","2001-04-04",0395226992,3000);
insert into NT_NhanVien values("NV0005","Nguyen Van Minh","Nam","1998-06-13",0393216992,4500);
insert into NT_NhanVien values("NV0006","Tran Van Tien","Nam","2000-11-04",0395996001,1000);



select * from NT_KhachHang;
insert into NT_KhachHang values("KH0001","Tran Van Lam","1980-02-12","Chau Doc, Long Xuyen","2020-12-09",0);
insert into NT_KhachHang values("KH0002","Nguyen Thanh Hai","1990-11-12","Ninh Kieu, Can Tho","2020-12-09",0);
insert into NT_KhachHang values("KH0003","Len Minh Hoang","1992-02-02","Chau Thanh, An Giang","2018-11-09",0);
insert into NT_KhachHang values("KH0004","Trinh Cong Anh","2000-01-02","Cho Moi, An Giang","2020-02-09",0);
insert into NT_KhachHang values("KH0005","Nguyen Kieu Diem","1972-08-19","Binh Thuy, Can Tho","2010-12-08",0);
insert into NT_KhachHang values("KH0006","Huynh Anh Tho","1989-01-22","Lap Vo, Dong Thap","2019-02-09",0);


select * from NT_HoaDon;
insert into NT_HoaDon values("HD0001","NV0001","2020-04-03 13:04:01",200,"KH0001");
insert into NT_HoaDon values("HD0002","NV0004","2019-05-01 03:02:01",200110,"KH0001");
insert into NT_HoaDon values("HD0003","NV0002","2020-12-09 11:04:41",2310000,"KH0002");
insert into NT_HoaDon values("HD0004","NV0004","2020-11-11 16:04:11",122200,"KH0005");
insert into NT_HoaDon values("HD0005","NV0003","2020-04-02 23:04:01",342000,"KH0006");
insert into NT_HoaDon values("HD0006","NV0002","2020-08-03 13:02:01",120000,"KH0003");
insert into NT_HoaDon values("HD0007","NV0006","2020-02-03 10:04:11",2012000,"KH0004");



select * from NT_ChiTietHoaDon;
insert into NT_ChiTietHoaDon values("HD0001","A0001",5);
insert into NT_ChiTietHoaDon values("HD0002","A0004",3);
insert into NT_ChiTietHoaDon values("HD0001","A0002",1);
insert into NT_ChiTietHoaDon values("HD0004","A0003",2);
insert into NT_ChiTietHoaDon values("HD0003","A0001",5);
insert into NT_ChiTietHoaDon values("HD0002","A0005",10);
insert into NT_ChiTietHoaDon values("HD0005","A0006",11);


delimiter //
create procedure insert_hoadon(p_sohoadon varchar(10),p_manv varchar(10),p_thoigian datetime,p_giatri float,p_makhachhang varchar(10))
BEGIN
	insert into nt_hoadon values(p_sohoadon,p_manv,p_thoigian,p_giatri,p_makhachhang);

END//

call insert_hoadon("HD0008","NV0006","2020-02-03 10:04:11",2012000,"KH0004");

delimiter //
create procedure insert_sanpham(p_mahang varchar(10),p_tenhang varchar(30),p_dongia float,p_noisx varchar(30),p_ngaysx date)
BEGIN
	insert into nt_SanPham values(p_mahang,p_tenhang,p_dongia,p_noisx,p_ngaysx);

END//

call insert_sanpham("A0007","Banh Mi",5000,"VietNam","2020-11-04");
select * from nt_sanpham;


delimiter //
create procedure insert_khachhang(p_makhachhang varchar(10),p_tenkhachhang varchar(30),p_ngaysinh date,p_diachi varchar(50),p_ngaygianhap date,p_diem int)
BEGIN
	insert into nt_khachhang values(p_makhachhang,p_tenkhachhang,p_ngaysinh,p_diachi,p_ngaygianhap,p_diem);

END//

call insert_khachhang("KH0007","Nguyen Chi Hoang Minh","2000-02-12","Cai Rang, Can Tho","2020-12-09",0)
select * from nt_khachhang;


delimiter //
create procedure insert_nhanvien(p_manv varchar(10),p_tennv varchar(30),p_gioitinh varchar(10) ,p_ngaysinh date,p_dienthoai int,p_luong float)
BEGIN
	insert into nt_nhanvien values(p_manv,p_tennv,p_gioitinh,p_ngaysinh,p_dienthoai,p_luong);

END//
call insert_nhanvien("NV0007","Buoi Quoc Trong","Nam","2000-01-04",0395996991,4000);
select * from nt_nhanvien;

delimiter //
create procedure insert_chitiethoadon(p_sohoadon varchar(10),p_mahang varchar(10),p_soluong int)
BEGIN
	insert into nt_chitiethoadon values(p_sohoadon,p_mahang,p_soluong);
END//

call insert_chitiethoadon("HD0002","A0003",10);
select * from nt_chitiethoadon;


delimiter //
create procedure delete_sanpham(p_mahang varchar(10))
BEGIN
	delete from nt_sanpham where ( MaHang = p_mahang);
END//

call delete_sanpham("A0007");

delimiter //
create procedure delete_hoadon(p_sohoadon varchar(10))
BEGIN
	delete from nt_hoadon where ( SoHoaDon = p_sohoadon);
END//

call delete_hoadon("HD0009");


delimiter //
create procedure delete_chitiethoadon(p_sohoadon varchar(10),p_mahang varchar(10))
BEGIN
	delete from nt_chitiethoadon where ( SoHoaDon = p_sohoadon and MaHang = p_mahang);
END//

call delete_chitiethoadon("HD0001","A0001");

delimiter //
create procedure delete_nhanvien(p_manhanvien varchar(10))
BEGIN
	delete from nt_nhanvien where ( MaNv = p_manhanvien);
END//

call delete_nhanvien("NV0005");


delimiter //
create procedure delete_khachhang(p_makhachhang varchar(10))
BEGIN
	delete from nt_khachhang where ( MaKhachHang = p_makhachhang);
END//

call delete_khachhang("KH0004");


