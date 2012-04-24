package com.mdialog.db_test

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.squeryl.adapters.PostgreSqlAdapter
import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import java.sql.Timestamp

object SquerylTest
{
	def main(args: Array[String])
	{
		DBInit.initialize();
		
		import StreamDB._;
		transaction
		{
			val vs = from(videos) (v => where ( (v.duration_in_seconds === 15) and (v.name.toString like "Global%") ) select(v));

			for (v <- vs)
			{
				println("Name: " + v.name.toString + ", created: " + v.created_at.toString);
			}
		}
		transaction { printDdl(println(_)); }
	}
}

object DBInit
{
	val dbUsername = "mdev";
	val dbPassword = "";
	val dbConnection = "jdbc:postgresql://localhost/mdev";

	val cpds = new ComboPooledDataSource;
	def initialize()
	{
		cpds.setDriverClass("org.postgresql.Driver");
		cpds.setJdbcUrl(dbConnection);
		cpds.setUser(dbUsername);
		cpds.setPassword(dbPassword);

		SessionFactory.concreteFactory = Some ( () => Session.create(cpds.getConnection, new PostgreSqlAdapter));
	}
}

class Video (val id:Long,
			 val name:String,
			 val created_by_user_id:Option[Long],
			 val times_played:Long,
			 val times_fully_played:Long,
			 val tags:Option[String],	// varying(512)
			 val rating:Double,				// it is numeric in db, should be BigDecimal
			 val created_at:Timestamp,
			 val updated_at:Timestamp,
			 val description:Option[String], // varying(1024),
			 val parental_rating_id:Option[Long],
			 val times_rated:Long,
			 val certified_rights_owner:Option[Boolean],
			 val certified_not_obscene:Option[Boolean],
			 val video_type:Option[String],
			 val latitude:Option[Double],
			 val longitude:Option[Double],
			 val status:String, 		// varying(255)
			 val duration_in_seconds:Option[Long],
			 val account_id:Option[Long],
			 val network_id:Option[Long],
			 val enable_adaptive:Option[Boolean],
			 val deleted_at: Option[Timestamp],
			 val external_key:Option[String],	// varying(512),
			 val external_key_qualifier:Option[String], 	// varying(255),
			 val content_type:Option[String] )	// varying(255),
extends KeyedEntity[Long]
{
	def this() = this(0,					// id
					  "",					// name
					  Some(0L),				// created_by_user_id 
					  0,					// times_played 
					  0,					// times_fully_played
					  Some(""),				// tags
					  0.0,					// rating
					  new Timestamp(0L),    // created_at
					  new Timestamp(0L),	// updated_at
					  Some(""), 			// description
					  Some(0L),				// parental_rating_id
					  0,					// times_rated
					  Some(false),			// certified_rights_owner
					  Some(false),			// certified_not_obscene
					  Some(" "),			// video_type
					  Some(0.0),			// latitude
					  Some(0.0),			// longitude
					  "",					// status
					  Some(0L),				// duration_in_seconds
					  Some(0L),				// account_id
					  Some(0L),				// network_id
					  Some(false),			// enable_adaptive
					  Some(new Timestamp(0L)), // deleted_at
					  Some(""),				// external_key
	                  Some(""),				// external_key_qualifier
					  Some("")				// content_type
	)
}


object StreamDB extends Schema
{
	val videos = table[Video]("videos");

	/*on(videos) (v => declare(
		v.id is (primaryKey)
		v.times_played defaultsTo (0L),
		v.times_fully_played defaultsTo (0L),
		v.times_rated defaultsTo (0L),
		v.rating defaultsTo (0.0),
		v.latitude is (indexed("index_medias_on_latitude")),
		v.longitude is (indexed("index_medias_on_longitude")),
		v.created_by_user_id is indexed(("medias_user_id_idx"))*/
		/*v.tags.get is (dbType("varying(512)")),
					v.description is(dbType("varying(1024)")),
					v.status is(dbType("varying(255")),
					v.external_key is(dbType("varying(512)")),
					v.external_key_qualifier is(dbType("varying(255)")),
					v.content_type is(dbType("varying(255)")) */
//		)
//	)
}

/*
-- Index: index_videos_on_external_key_and_external_key_qualifier

-- DROP INDEX index_videos_on_external_key_and_external_key_qualifier;

CREATE INDEX index_videos_on_external_key_and_external_key_qualifier
  ON videos
  USING btree
  (external_key COLLATE pg_catalog."default" , external_key_qualifier COLLATE pg_catalog."default" );

*/