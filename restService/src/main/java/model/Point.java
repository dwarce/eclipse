package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Points database table.
 * 
 */
@Entity
@Table(name="Points")
@NamedQuery(name="Point.findAll", query="SELECT p FROM Point p")
public class Point implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPoints;

	private Object coordinates;

	private String desc;

	//bi-directional many-to-one association to Layer
	@ManyToOne
	@JoinColumn(name="layerId")
	private Layer layer;

	public Point() {
	}

	public int getIdPoints() {
		return this.idPoints;
	}

	public void setIdPoints(int idPoints) {
		this.idPoints = idPoints;
	}

	public Object getCoordinates() {
		return this.coordinates;
	}

	public void setCoordinates(Object coordinates) {
		this.coordinates = coordinates;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Layer getLayer() {
		return this.layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}

}