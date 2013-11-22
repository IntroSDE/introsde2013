package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the "LifeStatus" database table.
 * 
 */
@Entity
@Table(name="\"LifeStatus\"")
@NamedQuery(name="LifeStatus.findAll", query="SELECT l FROM LifeStatus l")
@XmlRootElement
public class LifeStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idMeasure\"")
	private Long idMeasure;

	@Column(name="\"idMeasureDef\"")
	private Long idMeasureDef;

	@Column(name="\"idPerson\"")
	private Long idPerson;

	@Column(name="\"value\"")
	private String value;

	public LifeStatus() {
	}

	public Long getIdMeasure() {
		return this.idMeasure;
	}

	public void setIdMeasure(Long idMeasure) {
		this.idMeasure = idMeasure;
	}

	public Long getIdMeasureDef() {
		return this.idMeasureDef;
	}

	public void setIdMeasureDef(Long idMeasureDef) {
		this.idMeasureDef = idMeasureDef;
	}

	public Long getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}