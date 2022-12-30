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
//
--------------------------------------------------------------------------------
-- forspring.study_ja のレイアウト変更
--   注意！！：テーブルに依存するオブジェクト（ビューなど）が削除される場合があります。それらのオブジェクトは復元されません。
--   2022/12/30 wowp1
--------------------------------------------------------------------------------


-- 新テーブルの作成
create table forspring.`$$study_ja` (
  id bigint(20) unsigned auto_increment not null
  , name varchar(20) not null
  , meaning varchar(100)
  , example varchar(200) default '4'
  , info varchar(2000)
  , options varchar(100)
  , images varchar(1000)
  , _group int(11) default 0
  , delete_flag tinyint(1) default 0
  , created_at timestamp(6) on update CURRENT_TIMESTAMP default current_timestamp(6) not null
  , updated_at timestamp(6) default '0000-00-00 00:00:00.000000' not null
  , primary key (id)
)
  comment=''
  engine InnoDB
  row_format DYNAMIC
  auto_increment 69
  collate utf8_general_ci
/


-- 新テーブルへデータ投入
insert into forspring.`$$study_ja`(id, name, meaning, example, info, options, images, _group, delete_flag, created_at, updated_at)
  select org.id, org.name, org.meaning, org.content, org.info, org.options, org.images, org._group, org.delete_flag, org.created_at, org.updated_at from forspring.study_ja org
/


-- 元テーブルの削除
drop table forspring.study_ja cascade
/


-- 新テーブルをリネームして元テーブル名に変更
alter table forspring.`$$study_ja` rename to study_ja
/


