create table if not exists pessoa (
	id serial4 NOT NULL,
	cpf varchar(15) NULL,
	data_nascimento date NULL,
	nome varchar(100) NULL,
	sexo varchar(20) NULL,
	CONSTRAINT pessoa_pkey PRIMARY KEY (id)
);

create table if not exists usuario (
	id serial4 NOT NULL,
	ativo bool NULL,
	data_criacao timestamp(6) NULL,
	email varchar(100) NULL,
	login varchar(100) NULL,
	senha varchar(255) NULL,
	tipo_usuario varchar(50) NULL,
	id_pessoa int4 NULL,
	CONSTRAINT id_pessoa UNIQUE (id_pessoa),
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

ALTER TABLE usuario ADD CONSTRAINT fk_usuario_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id);
