package com.madhukar.test.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offerDAO")
public class OfferDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers(){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name1","Madhukar");
		param.addValue("name2", "Faltoo");
		
		return jdbc.query("SELECT * FROM OFFER where name in (:name1,:name2)", param, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet rs, int arg1) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setEmail(rs.getString("email"));
				offer.setName(rs.getString("name"));
				offer.setOffertext(rs.getString("offertext"));
				return offer;
			}

		});
	}
	
	public boolean deleteOffer(int id){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return jdbc.update("delete from offer where id = :id", param) == 1;
	}
	
	public Offer getOffer(int id){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id",id);
		
		return jdbc.queryForObject("SELECT * FROM OFFER where id =:id", param, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet rs, int arg1) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setEmail(rs.getString("email"));
				offer.setName(rs.getString("name"));
				offer.setOffertext(rs.getString("offertext"));
				return offer;
			}

		});
	}
	
	public boolean create(Offer offer){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("INSERT INTO OFFER (name, email, offertext) VALUES (:name, :email, :offertext) ", param  ) == 1;
	}
	
	@Transactional
	public int[] create(List<Offer> offers){
		SqlParameterSource[] params =  SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("INSERT INTO OFFER (id, name, email, offertext) VALUES (:id, :name, :email, :offertext) ",  params);
	}
	
	public boolean updateOffer(Offer offer){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("UPDATE OFFER SET name = :name, email = :email, offertext = :offertext where id = :id", param  ) == 1;
	}
}
