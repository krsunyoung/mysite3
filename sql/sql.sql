--users
select * from users;

--insert
insert into users values(user_seq.nextval, 'sun','sun@naver.com','123','female');

--delete
delete from users;

commit;


--select (login)

select no, name from users where email='asd@daum.net' and password='asd'; 

