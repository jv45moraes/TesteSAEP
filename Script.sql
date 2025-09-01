create Database testeSaep;
use testeSaep;

create table Usuario(
idUsuario int primary key identity(1,1) not null,
nome varchar(150) not null,
email varchar(250) not null
);

create table Tarefa(
idTarefa int primary key identity(1,1) not null,
idUsuario int not null foreign key references Usuario(idUsuario),
descricao varchar(250) not null,
setor varchar(50) not null,
nivel varchar(50) not null,
statusTarefa varchar(50) not null


INSERT INTO Usuario (nome, email) VALUES ('Jo�o Vitor Moraes', 'joao.moraes@email.com');
INSERT INTO Usuario (nome, email) VALUES ('Maria Oliveira', 'maria.oliveira@email.com');
INSERT INTO Usuario (nome, email) VALUES ('Carlos Alberto', 'carlos.alberto@email.com');
INSERT INTO Usuario (nome, email) VALUES ('Fernanda Souza', 'fernanda.souza@email.com');
INSERT INTO Usuario (nome, email) VALUES ('Ricardo Santos', 'ricardo.santos@email.com');
);

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (1, 'Revisar documenta��o t�cnica', 'Engenharia', 'Alto', 'A fazer');

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (2, 'Atualizar planilha de custos', 'Financeiro', 'M�dio', 'Fazendo');

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (3, 'Responder e-mails de clientes', 'Atendimento', 'Baixo', 'Pronto');

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (4, 'Configurar servidor de testes', 'TI', 'Alto', 'A fazer');

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (5, 'Organizar agenda de reuni�es', 'Administrativo', 'M�dio', 'Fazendo');

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (1, 'Criar prot�tipo de interface', 'Design', 'Alto', 'Pronto');

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (2, 'Gerar relat�rio de desempenho', 'RH', 'M�dio', 'A fazer');

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (3, 'Testar funcionalidades novas', 'Qualidade', 'Baixo', 'Fazendo');

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (4, 'Implementar backup autom�tico', 'TI', 'Alto', 'Pronto');

INSERT INTO Tarefa (idUsuario, descricao, setor, nivel, statusTarefa) 
VALUES (5, 'Realizar invent�rio de materiais', 'Almoxarifado', 'M�dio', 'A fazer');

