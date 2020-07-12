CREATE SEQUENCE hibernate_sequence
    START WITH 100000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

/* Create Tables */

CREATE TABLE hexagon
(
  hexagon_id bigserial NOT NULL,
  name varchar(64) NULL,
  coordinate_x integer NOT NULL,
  coordinate_y integer NOT NULL,
  created_by varchar(64) NOT NULL,
  created_date timestamp NOT NULL,
  updated_by varchar(64) NOT NULL,
  updated_date timestamp NOT NULL,

  PRIMARY KEY (hexagon_id),
  UNIQUE (name)
)
;