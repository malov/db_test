package com.mdialog.db_test

import ru.circumflex.orm.{Table, Record}


class CircumflexTest
{}

class Video extends Record[Long, Video]
{
	val id = "id".BIGINT.NOT_NULL;
	val name = "name".VARCHAR(255).NOT_NULL;
	val created_by_user_id = "created_by_user_id".INTEGER;
	val times_played = "times_played".INTEGER.NOT_NULL;
	val times_fully_played = "times_fully_played".INTEGER.NOT_NULL;
	val tags = "tags".VARCHAR(512);
	val rating = "rating".NUMERIC(4,2).NOT_NULL;
	val created_at = "created_at".TIMESTAMP;
	val updated_at = "updated_at".TIMESTAMP;
	val description = "description".VARCHAR(1024);
	val parental_rating_id = "parental_rating_id".INTEGER;
	val times_rated = "times_rated".INTEGER.NOT_NULL;
	val certified_rights_owner = "certified_rights_owner".BOOLEAN;
	val certified_not_obscene = "certified_not_obscene".BOOLEAN;
	val video_type = "video_type".VARCHAR(1);
	val latitude ="latitude".DOUBLE();
	val longitude = "longitude".DOUBLE();
	val status = "status".VARCHAR(255).NOT_NULL;
	val duration_in_seconds = "duration_in_seconds".INTEGER;
	val account_id = "account_id".INTEGER;
	val network_id = "network_id".INTEGER;
	val enable_adaptive ="enable_adaptive".BOOLEAN;
	val deleted_at = "deleted_at".TIMESTAMP;
	val external_key = "external_key".VARCHAR(512);
	val external_key_qualifier = "external_key_qualifier".VARCHAR(255);
	val content_type = "content_type".VARCHAR(255);

	def PRIMARY_KEY = id;
	def relation = Video;
}

object Video extends Video with Table[Long, Video]
/*
CREATE TABLE videos
(
  id serial NOT NULL,
  name character varying(255) NOT NULL,
  created_by_user_id integer,
  times_played integer NOT NULL DEFAULT 0,
  times_fully_played integer NOT NULL DEFAULT 0,
  tags character varying(512),
  rating numeric(4,2) NOT NULL DEFAULT 0.0,
  created_at timestamp without time zone,
  updated_at timestamp without time zone,
  description character varying(1024),
  parental_rating_id integer,
  times_rated integer NOT NULL DEFAULT 0,
  certified_rights_owner boolean,
  certified_not_obscene boolean,
  video_type character varying(1),
  latitude double precision,
  longitude double precision,
  status character varying(255) NOT NULL,
  duration_in_seconds integer,
  account_id integer,
  network_id integer,
  enable_adaptive boolean,
  deleted_at timestamp without time zone,
  external_key character varying(512),
  external_key_qualifier character varying(255),
  content_type character varying(255),
  CONSTRAINT videos_pkey PRIMARY KEY (id )
)
*/