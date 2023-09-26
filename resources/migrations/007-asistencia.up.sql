create table asistencia (
  id int unsigned not null auto_increment primary key,
  d1 varchar(255) default null,
  d2 text default null
) engine=innodb default charset=utf8;
