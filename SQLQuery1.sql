
use Middletest


--這個是CSV的
create table yearGifts (
id int not null primary key identity(1,1),
years varchar(50) not null,
typs varchar(50) not null,
companys varchar(50) not null,
products varchar(50) not null
);


select * 
from yearGifts  
drop table if exists  yearGifts 

--這個圖片的
create table Picturetest(

   picid int not null primary key identity(1,1),
   imageName varchar(50)  null,
   ftent varbinary(max) null,
  
  

);

select *from Picturetest

drop table if exists Picturetest
use Middletest