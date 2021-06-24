--Criação e seleção do schema:
create schema meproject;
SET search_path TO meproject;
SHOW search_path;

--Criação da tabela:
create table pessoa_fisica (
	id int primary key,
    pessoa_nome varchar(50) not null,
    pessoa_data_nascimento varchar(50) not null,
    pessoa_estado_civil varchar(60) not null,
    pessoa_dependentes varchar(100),
    check (pessoa_estado_civil 
    	in ('solteiro(a)',
    	'união estável',
    	'casado(a)',
    	'divorciado(a)',
    	'viuvo(a)')
    )
);

--Inserts mockados:
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (1, 'Herbert Head', '18/05/1998', 'solteiro(a)', 4);
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (2, 'Elicia Humfrey', '30/09/1991', 'união estável', null);
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (3, 'Ariel Scotford', '12/06/1996', 'casado(a)', null);
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (4, 'Gabbie Normanvill', '22/09/1997', 'solteiro(a)', null);
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (5, 'Randa Bart', '24/08/1997', 'casado(a)', 9);
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (6, 'Normy Quin', '29/06/1993', 'viuvo(a)', 7);
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (7, 'Antin Jemmison', '17/05/1997', 'solteiro(a)', null);
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (8, 'Vonni Votier', '26/08/1998', 'união estável', 1);
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (9, 'Barris Vakhlov', '02/12/1993', 'solteiro(a)', 1);
insert into pessoa_fisica (id, pessoa_nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (10, 'Woodie Dowda', '17/11/1998', 'união estável', 9);

--Insert para testar a constraint pessoa_fisica_pessoa_estado_civil_check:
insert into pessoa_fisica (id, _nome, pessoa_data_nascimento, pessoa_estado_civil, pessoa_dependentes) values (11, 'Wesley Vinicius', '31/03/1997', 'não declarado', null);

--Exibição da tabela com os dados:
select * from pessoa_fisica;