create database ghamanager;
use ghamanager;

create table Usuario (
id int primary key auto_increment not null,
nome varchar (30),
usuario varchar (100),
senha text,
tipoUsuario varchar (30)
);

create table Equipamento (
id int primary key auto_increment not null,
patrimonio varchar (100),
tipoDoEquipamento varchar (90),
emUso varchar (15),
transferencia varchar (15),
transferido varchar (15),
ultimaPreventiva date,
proximaPreventiva date,
observacoes text
);

create table Funcionario (
id int primary key auto_increment not null,
nome varchar (250),
matricula varchar (30),
rg varchar (20),
cpf varchar (20),
dataDeNascimento date,
endereco varchar (300),
dataDeAdmissao date,
funcao varchar (100),
setor varchar (100),
demitido varchar (15),
dataDeDemissao date,
observacoes text
);

create table curso (
id int primary key auto_increment not null,
nomeCurso varchar (100),
dataRealizada date,
dataValidade date,
idFuncionario int,
observacoes text,
foreign key (idFuncionario) references funcionario(id)
);



select * from usuario;
select * from equipamento;
select * from funcionario;
select * from curso;

insert into usuario (nome, usuario, senha, tipousuario) values ('Luan Nalati', 'nalati', 'Nallu@2025', 'Administrador');

delete from funcionario;
