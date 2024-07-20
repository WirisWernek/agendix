-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
create type TIPO_USUARIO as enum ('CLIENTE', 'PRESTADOR', 'ADMINISTRADOR');

create table
	if not exists usuario (
		id BIGSERIAL not null,
		nome VARCHAR(120) not null,
		cpf VARCHAR(12) not null,
		email VARCHAR(100) not null,
		data_nascimento DATE not null,
		telefone VARCHAR(15) not null,
		whatsapp VARCHAR(15) null,
		observacoes VARCHAR(200) null,
		"login" VARCHAR(100) not null,
		"password" VARCHAR(200) not null,
		ativo BOOLEAN not null,
		"role" TIPO_USUARIO not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		primary key (id)
	);

-- -----------------------------------------------------
-- Table prestador
-- -----------------------------------------------------
create table
	if not exists prestador (
		id BIGSERIAL not null,
		nome VARCHAR(200) not null,
		razao_social VARCHAR(200) not null,
		cnpj VARCHAR(20) not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		ativo BOOLEAN not null,
		id_usuario BIGINT not null,
		primary key (id),
		constraint fk_prestador_usuario foreign key (id_usuario) references usuario (id)
	);

create index idx_prestador_usuario on prestador (id_usuario asc);

-- -----------------------------------------------------
-- Table avaliacao
-- -----------------------------------------------------
create type TIPO_AVALIACAO as enum ('SUGESTAO', 'CRITICA', 'RECLAMACAO', 'ELOGIO');

create table
	if not exists avaliacao (
		id BIGSERIAL not null,
		tipo TIPO_AVALIACAO not null,
		avaliacao VARCHAR(300) not null,
		nota FLOAT not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		id_prestador BIGINT not null,
		id_cliente BIGINT not null,
		primary key (id),
		constraint fk_avaliacao_prestador foreign key (id_prestador) references prestador (id),
		constraint fk_avaliacao_usuario foreign key (id_cliente) references usuario (id)
	);

create index idx_avaliacao_prestador on avaliacao (id_prestador asc);
create index idx_avaliacao_usuario on avaliacao (id_cliente asc);

-- -----------------------------------------------------
-- Table imagem
-- -----------------------------------------------------
create table
	if not exists imagem (
		id BIGSERIAL not null,
		nome VARCHAR(100) not null,
		"url" VARCHAR(200) not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		primary key (id)
	);

-- -----------------------------------------------------
-- Table servico
-- -----------------------------------------------------
create table
	if not exists servico (
		id BIGSERIAL not null,
		nome VARCHAR(150) not null,
		tempo_medio FLOAT not null,
		descricao VARCHAR(300) not null,
		ativo BOOLEAN not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		id_prestador BIGINT not null,
		primary key (id),
		constraint fk_servico_prestador foreign key (id_prestador) references prestador (id)
	);

create index idx_servico_prestador on servico (id_prestador asc);

-- -----------------------------------------------------
-- Table atendimento_personalizado
-- -----------------------------------------------------
create table
	if not exists atendimento_personalizado (
		id BIGSERIAL not null,
		tempo_medio FLOAT not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		id_usuario BIGINT not null,
		id_prestador BIGINT not null,
		id_servico BIGINT not null,
		primary key (id),
		constraint fk_atendimento_personalizado_usuario foreign key (id_usuario) references usuario (id),
		constraint fk_atendimento_personalizado_prestador foreign key (id_prestador) references prestador (id),
		constraint fk_atendimento_personalizado_servico foreign key (id_servico) references servico (id)
	);

create index idx_atendimento_personalizado_usuario on atendimento_personalizado (id_usuario asc);
create index idx_atendimento_personalizado_prestador on atendimento_personalizado (id_prestador asc);
create index idx_atendimento_personalizado_servico on atendimento_personalizado (id_servico asc);

-- -----------------------------------------------------
-- Table imagem_servico
-- -----------------------------------------------------
create table
	if not exists imagem_servico (
		id BIGSERIAL not null,
		id_imagem BIGINT not null,
		id_servico BIGINT not null,
		primary key (id),
		constraint fk_imagem_servico_imagem foreign key (id_imagem) references imagem (id),
		constraint fk_imagem_servico_servico foreign key (id_servico) references servico (id)
	);

create index idx_imagem_servico_imagem on imagem_servico (id_imagem asc);
create index idx_imagem_servico_servico on imagem_servico (id_servico asc);

-- -----------------------------------------------------
-- Table link
-- -----------------------------------------------------
create type TIPO_LINK as enum (
	'REDE_SOCIAL',
	'WEBSITE',
	'CARTAO_DIGITAL',
	'CATALOGO_DIGITAL',
	'PORTIFOLIO',
	'OUTRO'
);

create table
	if not exists link (
		id BIGSERIAL not null,
		"url" VARCHAR(200) not null,
		tipo TIPO_LINK not null,
		nome VARCHAR(50) not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		id_prestador BIGINT not null,
		primary key (id),
		constraint fk_link_prestador foreign key (id_prestador) references prestador (id)
	);

create index idx_link_prestador on link (id_prestador asc);

-- -----------------------------------------------------
-- Table comunicado
-- -----------------------------------------------------
create type TIPO_COMUNICADO as enum (
	'PROMOCAO',
	'OFERTA',
	'FIDELIDADE',
	'PARCERIA',
	'SORTEIO',
	'NOTIFICACAO_FERIAS',
	'NOTIFICACAO_INDISPONIBILIDADE',
	'NOTA_ESCLARECIMENTO'
);

create table
	if not exists comunicado (
		id BIGSERIAL not null,
		tipo TIPO_COMUNICADO not null,
		conteudo VARCHAR(3000) not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		id_prestador BIGINT not null,
		primary key (id),
		constraint fk_comunicado_prestador foreign key (id_prestador) references prestador (id)
	);

create index idx_comunicado_prestador on comunicado (id_prestador asc);

-- -----------------------------------------------------
-- Table horario_por_dia
-- -----------------------------------------------------
create type DIA_SEMANA as enum (
	'DOMINGO',
	'SEGUNDA',
	'TERCA',
	'QUARTA',
	'QUINTA',
	'SEXTA',
	'SABADO'
);

create table
	if not exists horario_por_dia (
		id BIGSERIAL not null,
		inicio_atendimento TIME not null,
		fim_atendimento TIME not null,
		inicio_intervalo TIME not null,
		fim_intervalo TIME not null,
		dia DIA_SEMANA not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		id_prestador BIGINT not null,
		primary key (id),
		constraint fk_horario_por_dia_prestador foreign key (id_prestador) references prestador (id)
	);

create index idx_horario_por_dia_prestador on horario_por_dia (id_prestador asc);

-- -----------------------------------------------------
-- Table parametrizacao_horario
-- -----------------------------------------------------
create table
	if not exists parametrizacao_horario (
		id BIGSERIAL not null,
		tempo_medio TIME not null,
		atende_domingo BOOLEAN not null,
		atende_segunda BOOLEAN not null,
		atende_terca BOOLEAN not null,
		atende_quarta BOOLEAN not null,
		atende_quinta BOOLEAN not null,
		atende_sexta BOOLEAN not null,
		atende_sabado BOOLEAN not null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		id_prestador BIGINT not null,
		primary key (id),
		constraint fk_parametrizacao_horario_prestador foreign key (id_prestador) references prestador (id)
	);

create index idx_parametrizacao_horario_prestador on parametrizacao_horario (id_prestador asc);

-- -----------------------------------------------------
-- Table agendamento
-- -----------------------------------------------------
create type STATUS_AGENDAMENTO as enum (
	'ATENDIDO',
	'AGENDADO',
	'CANCELADO',
	'REMARCADO',
	'RECUSADO'
);

create table
	if not exists agendamento (
		id BIGSERIAL not null,
		"data" DATE not null,
		inicio TIME not null,
		fim TIME not null,
		status STATUS_AGENDAMENTO not null,
		justificativa_cancelamento_desistencia VARCHAR(200) null,
		data_criacao TIMESTAMP not null,
		data_exclusao TIMESTAMP null,
		data_atualizacao TIMESTAMP null,
		id_cliente BIGINT not null,
		id_prestador BIGINT not null,
		primary key (id),
		constraint fk_agendamento_usuario foreign key (id_cliente) references usuario (id),
		constraint fk_agendamento_prestador foreign key (id_prestador) references prestador (id)
	);

create index idx_agendamento_usuario on agendamento (id_cliente asc);
create index idx_agendamento_prestador on agendamento (id_prestador asc);

-- -----------------------------------------------------
-- Table servico_agendamento'
-- -----------------------------------------------------
create table
	if not exists servico_agendamento (
		id BIGSERIAL not null,
		id_agendamento BIGINT not null,
		id_servico BIGINT not null,
		primary key (id),
		constraint fk_servico_agendamento_agendamento foreign key (id_agendamento) references agendamento (id),
		constraint fk_servico_agendamento_servico foreign key (id_servico) references servico (id)
	);

create index idx_servico_agendamento_agendamento on servico_agendamento (id_agendamento asc);
create index idx_servico_agendamento_servico on servico_agendamento (id_servico asc);