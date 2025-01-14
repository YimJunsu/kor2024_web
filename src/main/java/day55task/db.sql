#[1] 데이터베이스 생성
drop database if exists day55taskdb;
create database day55taskdb;
use day55taskdb;

create table todolist(
	bno int unsigned auto_increment,
    content varchar(100) not null,
    status boolean,
    primary key(bno)
);

insert into todolist(content, status) values ('아침밥 먹기', '0');
insert into todolist(content, status) values ('헬스장 가기', '0');

select * from todolist;



