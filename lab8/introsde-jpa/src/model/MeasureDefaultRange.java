package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the "MeasureDefaultRange" database table.
 * 
 */
@Entity
@Table(name="\"MeasureDefaultRange\"")
@NamedQuery(name="MeasureDefaultRange.findAll", query="SELECT m FROM MeasureDefaultRange m")
@XmlRootElement
public class MeasureDefaultRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"alarmLevel\"")
	private String alarmLevel;

	@Column(name="\"endValue\"")
	private String endValue;

	@Column(name="\"idMeasureDef\"")
	private Long idMeasureDef;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"idRange\"")
	private Long idRange;

	@Column(name="\"rangeName\"")
	private String rangeName;

	@Column(name="\"startValue\"")
	private String startValue;

	public MeasureDefaultRange() {
	}

	public String getAlarmLevel() {
		return this.alarmLevel;
	}

	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	public String getEndValue() {
		return this.endValue;
	}

	public void setEndValue(String endValue) {
		this.endValue = endValue;
	}

	public Long getIdMeasureDef() {
		return this.idMeasureDef;
	}

	public void setIdMeasureDef(Long idMeasureDef) {
		this.idMeasureDef = idMeasureDef;
	}

	public Long getIdRange() {
		return this.idRange;
	}

	public void setIdRange(Long idRange) {
		this.idRange = idRange;
	}

	public String getRangeName() {
		return this.rangeName;
	}

	public void setRangeName(String rangeName) {
		this.rangeName = rangeName;
	}

	public String getStartValue() {
		return this.startValue;
	}

	public void setStartValue(String startValue) {
		this.startValue = startValue;
	}

}