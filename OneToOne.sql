# onetoone database
create database onetoone;

# user table
select * from user;
select up_id from user where id = 1;
delete from user where id = 1;
delete from user where up_id=12 or up_id=14;
update user set up_id = 1 where id = 1;
update user set id=1, email="mohiburrahman5509@gmail.com", name="Mohibur Rahman", up_id=1 where id = 3;

# user_profile table
select * from user_profile;
delete from user_profile where id = 11;
delete from user_profile where id=12 or id=14;
