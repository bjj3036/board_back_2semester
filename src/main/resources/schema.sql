use webboard;

drop table if exists user;
drop table if exists attach;
drop table if exists board;
drop table if exists post;

create table user
(
  id            varchar(30) primary key,
  password      varchar(100) not null,
  username      varchar(30)  not null,
  age           int          not null,
  gender        varchar(30)  not null,
  profile_image bigint,
  created       datetime default current_timestamp,
  updated       datetime default current_timestamp on update current_timestamp
) engine = InnoDB
  default charset = utf8;

create table attach
(
  id       bigint primary key auto_increment,
  filename varchar(100),
  filepath varchar(100),
  created  datetime default current_timestamp,
  updated  datetime default current_timestamp on update current_timestamp
) engine = InnoDB
  default charset = utf8;

create table post
(
  id        bigint primary key auto_increment,
  title     varchar(40)  not null,
  content   varchar(200) not null,
  recommend integer  default 0,
  views     integer  default 0,
  board     bigint not null,
  writer    varchar(30)  not null,
  created   datetime default current_timestamp,
  updated   datetime default current_timestamp on update current_timestamp
) engine = InnoDB
  default charset = utf8;

create table board
(
  id         bigint primary key auto_increment,
  board_name varchar(30),
  board_desc varchar(100),
  created    datetime default current_timestamp,
  updated    datetime default current_timestamp on update current_timestamp
) engine = InnoDB
  default charset = utf8;