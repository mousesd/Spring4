delete from T_USER_ROLE;
delete from T_ROLE;
delete from T_USER;

insert into T_ROLE values(1, 'ROLE_USER', '일반 롤');
insert into T_ROLE values(2, 'ROLE_ADMIN', '관리 롤');

insert into T_USER values(1, 'user', 'userpassword', '사용자', '개발부');
insert into T_USER values(2, 'admin', 'adminpassword', '관리자', '관리부');

insert into T_USER_ROLE values(1, 1);
insert into T_USER_ROLE values(2, 2);
