drop table if exists product;

create table product (
  id long primary key,
  name varchar(120), 
  quantity int, 
  sale_amount double, 
  event_id varchar(80), 
  created_time timestamp
);
