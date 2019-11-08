DROP TABLE bestillingsliste; 
DROP TABLE ordre; 
DROP TABLE pizzaer; 

DROP TABLE if exists pizzas;

create table pizzas (
	nr		integer,
    type	varchar(30),
    price	integer,
    primary key (nr),
    UNIQUE KEY type_UNIQUE (type));
    
    
DROP TABLE if exists orders;
    
create table orders (
	id		integer NOT NULL AUTO_INCREMENT,
    date 	date,
	nr		integer references pizzas,
    tele	integer,
    primary key (id)); 
    
	
-- DROP TABLE if exists bestillingslitste;

-- create table orderlist (
-- 	nr		integer references pizzaer, 
--  tele 	integer references orders,
--  ttc	integer);
    

