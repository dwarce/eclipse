package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Translations database table.
 * 
 */
@Entity
@Table(name="Translations")
@NamedQuery(name="Translation.findAll", query="SELECT t FROM Translation t")
public class Translation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTranslations;

	private String eng;

	private String name;

	private String slo;

	public Translation() {
	}

	public int getIdTranslations() {
		return this.idTranslations;
	}

	public void setIdTranslations(int idTranslations) {
		this.idTranslations = idTranslations;
	}

	public String getEng() {
		return this.eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlo() {
		return this.slo;
	}

	public void setSlo(String slo) {
		this.slo = slo;
	}

}