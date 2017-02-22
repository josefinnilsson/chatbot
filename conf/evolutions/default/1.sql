# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table message (
  id                            integer not null,
  name                          varchar(255),
  constraint pk_message primary key (id)
);
create sequence message_seq;


# --- !Downs

drop table if exists message;
drop sequence if exists message_seq;

