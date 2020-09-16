
/*drop table bd_sicredi.pauta;
drop table bd_sicredi.sessao;
drop table bd_sicredi.associados;
drop table bd_sicredi.votacao;*/

select * from bd_sicredi.associados;
select * from bd_sicredi.sessao  ;
select * from bd_sicredi.votacao;
update bd_sicredi.votacao set id_sessao = 53 
where agencia = '0229' and conta = 51 and id_pauta = 3
select * from bd_sicredi.pauta

select agencia, id_pauta, count(*) from bd_sicredi.votacao where agencia = '0116' and ( voto = 's' or voto = 'S' ) and id_pauta = 2

select count(*) from votacao v where v.agencia = '0116' and v.id_Pauta = 2 and ( v.voto = 'S' or v.voto = 's')

select * from bd_sicredi.votacao
select count(*) from bd_sicredi.votacao where agencia = '0116' and voto = 'n' or voto = 'N'

SELECT current_time(), ADDTIME(current_time(), "5.000003");

drop table bd_sicredi.associados;
delete from bd_sicredi.associados where agencia = '0116';

insert into bd_sicredi.associados( agencia, conta, nome, endereco, cpf ) values ( "0116", "066044", "Diego Oli", "rua clovis bevilaqua", "00138556032" )

CREATE TABLE bd_sicredi.pauta
( id_pauta INT AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL,
CONSTRAINT key_pauta PRIMARY KEY (Id_pauta)
);

CREATE TABLE bd_sicredi.sessao
( id INT AUTO_INCREMENT,
  data_hora_inicio DATETIME NULL,
  data_hora_fim DATETIME NULL,
  id_pauta INT,
  agencia VARCHAR(05),
CONSTRAINT key_sessao PRIMARY KEY (id)
);

CREATE TABLE bd_sicredi.associados
( conta varchar(06) NOT NULL,
  agencia VARCHAR(05) NOT NULL,
  nome VARCHAR(35) NOT NULL,
  endereco VARCHAR(50) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
CONSTRAINT key_associados PRIMARY KEY (agencia, conta)
);

CREATE TABLE bd_sicredi.votacao
( conta varchar(06) NOT NULL,
  agencia VARCHAR(05) NOT NULL,
  id_pauta INT NOT NULL,
  id_sessao INT NOT NULL,
  voto VARCHAR(01) NULL,
CONSTRAINT key_votacao PRIMARY KEY ( agencia, conta, id_pauta)
);




