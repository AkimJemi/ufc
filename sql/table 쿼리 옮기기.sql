drop table if exists parent.old_table;
drop table if exists parent.new_table;

create table if not exists parent.old_table (
id int auto_increment,
pk char(30) not null,
primary key(id)
);

insert into parent.old_table (pk)value ('A'),('B'),('C');

create table if not exists parent.new_table (
id int auto_increment,
pk char(30),
primary key(id)
);

insert into parent.new_table (pk) select pk from parent.old_table;

drop table parent.old_table;

rename table parent.new_table to parent.old_table; 


select * from parent.old_table;

delete from parent.new_table;
select * from parent.old_table;

