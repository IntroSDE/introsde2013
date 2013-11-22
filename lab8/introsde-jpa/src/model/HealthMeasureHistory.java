package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;


/**
 * The persistent class for the "HealthMeasureHistory" database table.
 * 
 */
@Entity
@Table(name="\"HealthMeasureHistory\"")
@NamedQuery(name="HealthMeasureHistory.findAll", query="SELECT h FROM HealthMeasureHistory h")
@XmlRootElement
public class HealthMeasureHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"idMeasureDefinition\"")
	private Long idMeasureDefinition;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idMeasureHistory\"")
	private Long idMeasureHistory;

	@Column(name="\"idPerson\"")
	private Long idPerson;

	@Column(name="\"timestamp\"")
	private Timestamp timestamp;

	@Column(name="\"value\"")
	private String value;

	public HealthMeasureHistory() {
	}

	public Long getIdMeasureDefinition() {
		return this.idMeasureDefinition;
	}

	public void setIdMeasureDefinition(Long idMeasureDefinition) {
		this.idMeasureDefinition = idMeasureDefinition;
	}

	public Long getIdMeasureHistory() {
		return this.idMeasureHistory;
	}

	public void setIdMeasureHistory(Long idMeasureHistory) {
		this.idMeasureHistory = idMeasureHistory;
	}

	public Long getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}