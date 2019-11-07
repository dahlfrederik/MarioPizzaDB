DROP TABLE if exists pizzaer;

create table pizzaer (
	nr		integer,
    type	varchar(30),
    pris	integer,
    primary key (nr),
    UNIQUE KEY type_UNIQUE (type));
    
DROP TABLE if exists bestillingslitste;

create table bestillingsliste (
	nr		integer references pizzaer, 
    tlf 	integer,
    tta		integer);
    
DROP TABLE if exists ordre;
    
create table ordre (
	dato 	integer,
	nr		integer references pizzaer,
    tlf		integer references bestillingsliste);
    

