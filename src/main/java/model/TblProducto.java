package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_producto database table.
 * 
 */
@Entity
@Table(name="tbl_producto")
@NamedQuery(name="TblProducto.findAll", query="SELECT t FROM TblProducto t")
public class TblProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproducto;

	private String codbarras;

	@Temporal(TemporalType.DATE)
	private Date fechavenc;

	private String nomprod;

	private String nrolote;

	private double precio;

	//bi-directional many-to-one association to TblCategoria
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private TblCategoria tblCategoria;

	public TblProducto() {
	}

	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getCodbarras() {
		return this.codbarras;
	}

	public void setCodbarras(String codbarras) {
		this.codbarras = codbarras;
	}

	public Date getFechavenc() {
		return this.fechavenc;
	}

	public void setFechavenc(Date fechavenc) {
		this.fechavenc = fechavenc;
	}

	public String getNomprod() {
		return this.nomprod;
	}

	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}

	public String getNrolote() {
		return this.nrolote;
	}

	public void setNrolote(String nrolote) {
		this.nrolote = nrolote;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public TblCategoria getTblCategoria() {
		return this.tblCategoria;
	}

	public void setTblCategoria(TblCategoria tblCategoria) {
		this.tblCategoria = tblCategoria;
	}

}