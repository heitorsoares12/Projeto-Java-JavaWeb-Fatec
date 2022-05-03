create table Estado(
	idestado serial primary key,
	nomeestado varchar(30),
	siglaestado varchar(2)
);

CREATE TABLE cidade(
idcidade serial primary key,
nomecidade varchar(100),
idestado integer,
CONSTRAINT FK_CIDADE_ESTADO
FOREIGN KEY (idestado) REFERENCES estado(idestado));