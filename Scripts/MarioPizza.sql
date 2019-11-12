DROP TABLE if exists pizzas;

create table pizzas (
	pid 	integer not null primary key, 
	nr		integer,
    type	varchar(30),
    price	integer,
    primary key (nr),
    UNIQUE KEY type_UNIQUE (type));
    
    
DROP TABLE if exists orders;
    
create table orders (
	oid		integer not null primary key,
    date 	date,
	nr		integer references pizzas,
    tele	integer,
    primary key (id)); 
    
DROP TABLE if exists odetails;

create table odetails (
  oid      integer not null references orders,
  pid      integer not null references pizzas,
  qty      integer,
  primary key (oid, pid));
    

