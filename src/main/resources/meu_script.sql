create table cliente
(
	id integer primary key auto_increment,
	nome varchar(100)
);

create table produto
(
	id integer primary key auto_increment,
	nome varchar(100),
	preco_unitario numeric(20,2)
);

create table pedido
(
	id int primary key auto_increment,
	id_cliente integer references cliente(id),
	data_pedido timestamp,
	total numeric(20,2)
);

create table item_pedido
(
	id int primary key auto_increment,
	id_pedido integer references pedido(id),
	id_produto integer references produto(id),
	quantidade integer
);