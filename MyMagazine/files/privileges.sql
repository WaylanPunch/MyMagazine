use mysql;

select host, user from user;

create user mymagazine identified by '123456';

grant all on mymagazine.* to mymagazine@'%' identified by '123456' with grant option;

flush privileges;

-- privileges.sql