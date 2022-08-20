/* 기본에 있는 테이블을 외래키로 둘로 나누는 방법*/
/* 주키 */
create table user_login_info( no int(4) auto_increment primary key, id varchar(15) not null, password varchar(200));
/* 외래키 */
create table user_basic_info ( no int(4) primary key, name varchar(10) not null , foreign key user_FK(no) REFERENCES  user_login_info(no));

insert into user_login_info ( id, password ) select id, password from user;
insert into user_basic_info (no, name ) select user.no, user.name from user inner join user_login_info uli on user.no =  uli.no;
