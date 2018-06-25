package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Polygons database table.
 * 
 */
@Entity
@Table(name="Polygons")
@NamedQuery(name="Polygon.findAll", query="SELECT p FROM Polygon p")
public class Polygon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPolygons;

	private String desc;

	private Object pointsArray;

	//bi-directional many-to-one association to Layer
	@ManyToOne
	@JoinColumn(name="layerId")
	private Layer layer;

	public Polygon() {
	}

	public int getIdPolygons() {
		return this.idPolygons;
	}

	public void setIdPolygons(int idPolygons) {
		this.idPolygons = idPolygons;
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