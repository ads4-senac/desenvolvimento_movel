-- Criacao de banco
-- drop database Locadora;
-- create database Locadora;

-- Criacao de tabelas
drop table if exists modelo cascade;
drop table if exists cor;
drop table if exists marca;
create table marca (mar_id	serial 	not null 	primary key, mar_nome	varchar (40));
create table cor (cor_id	serial	not null	primary key, cor_nome	varchar(40));
create table modelo (mod_id	serial not null	primary key, mod_descricao	varchar(60), mar_id int	not null, constraint rel_marca_modelo foreign key (mar_id) references marca);

-- Insercao de dados
insert into marca (mar_nome) values ('Chevrolet') ;
insert into cor (cor_nome) values ('amarela') ;
insert into modelo (mod_descricao, mar_id) values ('SS', 1);

insert into marca (mar_nome) values ('Ford') ;
insert into cor (cor_nome) values ('azul') ;
insert into modelo (mod_descricao, mar_id) values ('Maverick GT', 2) ;

insert into marca (mar_nome) values ('VW') ;
insert into cor (cor_nome) values ('branca') ;
insert into modelo (mod_descricao, mar_id) values ('1.6 - Fafá de Belém', 3) ;

insert into marca (mar_nome) values ('Austin') ;
insert into cor (cor_nome) values ('Preto') ;
insert into modelo (mod_descricao, mar_id) values ('16/16', 4) ;

select * from modelo;
select * from cor;
select * from marca;