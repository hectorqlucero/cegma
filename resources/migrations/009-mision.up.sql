create table mision (
  id int unsigned not null auto_increment primary key,
  empresa varchar(255) default null,
  meta text default null
) engine=innodb default charset=utf8;
