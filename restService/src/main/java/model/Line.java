package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Lines database table.
 * 
 */
@Entity
@Table(name="Lines")
@NamedQuery(name="Line.findAll", query="SELECT l FROM Line l")
public class Line implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLines;

	private String desc;

	private Object pointsArray;

	//bi-directional many-to-one association to Layer
	@ManyToOne
	@JoinColumn(name="layerId")
	private Layer layer;

	public Line() {
	}

	public int getIdLines() {
		return this.idLines;
	}

	public void setIdLines(int idLines) {
		this.idLines = idLines;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getPointsArray() {
		return this.pointsArray;
	}

	public void setPointsArray(Object pointsArray) {
		this.pointsArray = pointsArray;
	}

	public Layer getLayer() {
		return this.layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}

}