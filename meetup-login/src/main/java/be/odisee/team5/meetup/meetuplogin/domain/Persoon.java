package be.odisee.team5.meetup.meetuplogin.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author bramv
 * @version 1.0
 * @created 18-mei-2021 16:52:40
 */
@Entity
@Data
public class Persoon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String gebruikersnaam;

	private String rol;
	private String wachtwoord;

	public Persoon(){

	}



}