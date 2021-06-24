psql -c 'CREATE DATABASE meprojectdatabase';
psql -d meprojectdatabase -c 'CREATE SCHEMA meproject';
psql -d meprojectdatabase -c "create table meproject.pessoa_fisica (id int primary key, pessoa_nome varchar(50) not null, pessoa_data_nascimento varchar(50) not null, pessoa_estado_civil varchar(60) not null, pessoa_dependentes varchar(100), check (pessoa_estado_civil in ('solteiro(a)', 'união estável', 'casado(a)', 'divorciado(a)', 'viuvo(a)')))"
cd me-project/
mvn install
mvn spring-boot:run
