create table PET (PET_ID integer primary key, PET_NAME varchar(50), OWNER_ID integer, PRICE integer, BIRTH_DATE date);
create table OWNER (OWNER_ID integer primary key, OWNER_NAME varchar(50));

insert into PET values(1, '발라리', 1, 5000, '2015-01-01');
insert into PET values(2, '나비', 2, 5000, '2015-01-01');
insert into PET values(3, '나비', 1, 15000, '2015-01-01');
insert into PET values(10, '나비3', 1, 15000, '2015-01-01');
insert into PET values(11, '나비4', 2, 9000, '2015-01-01');
insert into PET values(12, '나비5', 1, 1500, '2015-01-01');

insert into OWNER VALUES (1, '홍길동');
insert into OWNER VALUES (2, '김삿갓');
