psql -c 'CREATE ROLE postgres WITH LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION';
psql -c "CREATE DATABASE meprojectdatabase" -c "CREATE SCHEMA meproject" -c "CREATE SEQUENCE meproject.meproject_id_seq" -c "SET search_path TO meproject" -c "create table meproject.pessoa_fisica (id int primary key, pessoa_nome varchar(50) not null, pessoa_data_nascimento varchar(50) not null, pessoa_estado_civil varchar(60) not null, pessoa_dependentes varchar(100), check (pessoa_estado_civil in ('solteiro(a)', 'união estável', 'casado(a)', 'divorciado(a)', 'viuvo(a)')))" -U postgres
cd me-project/
mvn install
mvn spring-boot:run
