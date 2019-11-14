DROP TABLE if exists pizzas;

create table pizzas (
	nr		integer not null primary key,
    type	varchar(30),
    price	integer);
    
    
DROP TABLE if exists orders;
    
create table orders (
	oid		integer not null,
    date 	date,
    tele	integer);
     
    
DROP TABLE if exists odetails;

create table odetails (
  oid      integer not null references orders,
  nr       integer not null references pizzas,
  qty      integer,
  primary key (oid, nr));
    

