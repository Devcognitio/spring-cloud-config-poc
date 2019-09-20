CREATE DATABASE secrets;
USE secrets;
create table PROPERTIES (id integer not null auto_increment, CREATED_ON datetime ,APPLICATION varchar(255), PROFILE varchar(255), LABEL varchar(255), PROP_KEY varchar(255), VALUE varchar(255), primary key (id)) engine=InnoDB;
insert into PROPERTIES (CREATED_ON, APPLICATION, PROFILE, LABEL, PROP_KEY, VALUE) VALUES (NULL,'devglan','dev','latest','test-property','This is my test value');