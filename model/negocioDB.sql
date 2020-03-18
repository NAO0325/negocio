/*
Created		3/17/2020
Modified	3/17/2020
Project		Negocio
Model			
Company		
Author		Napoleon Avila
Version		1.0
Database	MS SQL 2005 
*/


Create table [persona]
(
	[idpersona] Integer identity(1,1) NOT NULL,
	[nombres] Varchar(100) NOT NULL,
	[apellidos] Varchar(100) NOT NULL,
	[numdocumento] Bigint NOT NULL,
	[tipo] Varchar(100) NOT NULL Check (tipo IN ('USUARIO','CLIENTE','VENDEDOR')),
Primary Key ([idpersona])
) 
go

Create table [producto]
(
	[idproducto] Integer identity(1,1) NOT NULL,
	[tipo] Varchar(100) NOT NULL Check (tipo IN ('CAMISA','CAMISETA','PANTALON','CHAQUETA','BUFANDA','GAFAS')),
	[nombre] Varchar(100) NOT NULL,
	[valor] Decimal(18,0) NOT NULL Check (valor > 0),
Primary Key ([idproducto])
) 
go

Create table [venta]
(
	[idventa] Integer identity(1,1) NOT NULL,
	[idpersona_cliente] Integer NOT NULL,
	[idpersona_vendedor] Integer NOT NULL,
	[fecha] Datetime NOT NULL,
	[total] Decimal(18,0) NOT NULL Check (total > 0),
Primary Key ([idventa])
) 
go

Create table [venta_item]
(
	[iditem] Integer identity(1,1) NOT NULL,
	[cantidad] Integer NOT NULL Check (cantidad > 0),
	[idproducto] Integer NOT NULL,
	[idventa] Integer NOT NULL,
Primary Key ([iditem])
) 
go


Alter table [venta] add  foreign key([idpersona_vendedor]) references [persona] ([idpersona])  on update no action on delete no action 
go
Alter table [venta] add  foreign key([idpersona_cliente]) references [persona] ([idpersona])  on update no action on delete no action 
go
Alter table [venta_item] add  foreign key([idproducto]) references [producto] ([idproducto])  on update no action on delete no action 
go
Alter table [venta_item] add  foreign key([idventa]) references [venta] ([idventa])  on update no action on delete no action 
go


Set quoted_identifier on
go


Set quoted_identifier off
go


