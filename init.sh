psql -c "CREATE DATABASE meprojectdatabase2" -c "CREATE SCHEMA meproject2" -c "SET search_path TO meproject2" -c "create table pessoa_fisica (id int primary key, pessoa_nome varchar(50) not null, pessoa_data_nascimento varchar(50) not null, pessoa_estado_civil varchar(60) not null, pessoa_dependentes varchar(100), check (pessoa_estado_civil in ('solteiro(a)', 'união estável', 'casado(a)', 'divorciado(a)', 'viuvo(a)')))" -U postgres
psql -c 'CREATE ROLE postgres WITH LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION';
cd me-project/
