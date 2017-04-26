# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table answer (
  id                            integer not null,
  answer                        varchar(255),
  positive_rating               boolean,
  id_message                    integer,
  constraint uq_answer_id_message unique (id_message),
  constraint pk_answer primary key (id)
);
create sequence answer_seq;

create table message (
  id                            integer not null,
  name                          varchar(255),
  constraint pk_message primary key (id)
);
create sequence message_seq;

alter table answer add constraint fk_answer_id_message foreign key (id_message) references message (id) on delete restrict on update restrict;


# --- !Downs

alter table answer drop constraint if exists fk_answer_id_message;

drop table if exists answer;
drop sequence if exists answer_seq;

drop table if exists message;
drop sequence if exists message_seq;

