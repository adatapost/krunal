drop table product;
drop table category;

create table category
(
  category_id  number(2) primary key,
  category_name varchar(60)
);

create table product
(
  product_id number(5) primary key,
  category_id number(2),
  product_name varchar(100),
  unit varchar(10),
  is_available number(1),
  foreign key (category_id) references category(category_id)
);




