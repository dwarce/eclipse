package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Layers database table.
 * 
 */
@Entity
@Table(name="Layers")
@NamedQuery(name="Layer.findAll", query="SELECT l FROM Layer l")
public class Layer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLayers;

	private String layerName;

	private String layerType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//bi-directional many-to-one association to Line
	@OneToMany(mappedBy="layer")
	private List<Line> lines;

	//bi-directional many-to-one association to Point
	@OneToMany(mappedBy="layer")
	private List<Point> points;

	//bi-directional many-to-one association to Polygon
	@OneToMany(mappedBy="layer")
	private List<Polygon> polygons;

	public Layer() {
	}

	public int getIdLayers() {
		return this.idLayers;
	}

	public void setIdLayers(int idLayers) {
		this.idLayers = idLayers;
	}

	public String getLayerName() {
		return this.layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public String getLayerType() {
		return this.layerType;
	}

	public void setLayerType(String layerType) {
		this.layerType = layerType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Line> getLines() {
		return this.lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public Line addLine(Line line) {
		getLines().add(line);
		line.setLayer(this);

		return line;
	}

	public Line removeLine(Line line) {
		getLines().remove(line);
		line.setLayer(null);

		return line;
	}

	public List<Point> getPoints() {
		return this.points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Point addPoint(Point point) {
		getPoints().add(point);
		point.setLayer(this);

		return point;
	}

	public Point removePoint(Point point) {
		getPoints().remove(point);
		point.setLayer(null);

		return point;
	}

	public List<Polygon> getPolygons() {
		return this.polygons;
	}

	public void setPolygons(List<Polygon> polygons) {
		this.polygons = polygons;
	}

	public Polygon addPolygon(Polygon polygon) {
		getPolygons().add(polygon);
		polygon.setLayer(this);

		return polygon;
	}

	public Polygon removePolygon(Polygon polygon) {
		getPolygons().remove(polygon);
		polygon.setLayer(null);

		return polygon;
	}

}