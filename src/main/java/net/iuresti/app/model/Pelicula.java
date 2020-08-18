package net.iuresti.app.model;

/**
 * Clase de modelo que representa una pelicula en la cartelera
 */

import java.util.Date;
//import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen = "cinema.png"; // Imagen por default
	private Date fechaEstreno;
	private String estatus = "Activa"; // Posibles valores: Activa, Inactiva

	// @Transient // Ignorar este atributo durante la persistencia
	// Relacion Uno a Uno -> Una pelicula tiene un registro de detalle
	@OneToOne
	@JoinColumn(name = "idDetalle") // foreignKey en la tabla de Peliculas
	private Detalle detalle;

	/**
	 * En realidad en la aplicacion, no se ocupa la consulta de TODOS los horarios
	 * por idPelicula. La consulta que se ocupa es TODOS LOS HORARIOS POR FECHA para
	 * una determinada pelicula. Por eso, dejamos comentada dicha relacion, aqui en
	 * la clase Pelicula. Con esto nos evitamos un left outer join Horarios on
	 * pelicula.id=horarios.idPelicula
	 */
	// Relacion Uno a Muchos -> Una pelicula tiene muchos horarios
	//@OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER) 
	//private List<Horario> horarios;

	/**
	 * Constructor sin parametros
	 */
	public Pelicula() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	//public List<Horario> getHorarios() {
	//	return horarios;
	//}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion="
				+ clasificacion + ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
				+ ", estatus=" + estatus + ", detalle=" + detalle + "]";
	}

}
