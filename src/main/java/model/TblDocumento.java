package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_documento database table.
 * 
 */
@Entity
@Table(name="tbl_documento")
@NamedQuery(name="TblDocumento.findAll", query="SELECT t FROM TblDocumento t")
public class TblDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddocument;

	private String descripdocument;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nrodocument;

	private String proveedocument;

	private String rucdocument;

	//bi-directional many-to-one association to TblTipodocumento
	//
	//El siguiente codigo, nos va a permitir hacer un CRUD
	//Fetch => Nos permitira hacer listados tanto en productos como categoria
	@ManyToOne//(optional=false,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="idtipodocum")
	private TblTipodocumento tblTipodocumento;

	public TblDocumento() {
	}

	public int getIddocument() {
		return this.iddocument;
	}

	public void setIddocument(int iddocument) {
		this.iddocument = iddocument;
	}

	public String getDescripdocument() {
		return this.descripdocument;
	}

	public void setDescripdocument(String descripdocument) {
		this.descripdocument = descripdocument;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNrodocument() {
		return this.nrodocument;
	}

	public void setNrodocument(String nrodocument) {
		this.nrodocument = nrodocument;
	}

	public String getProveedocument() {
		return this.proveedocument;
	}

	public void setProveedocument(String proveedocument) {
		this.proveedocument = proveedocument;
	}

	public String getRucdocument() {
		return this.rucdocument;
	}

	public void setRucdocument(String rucdocument) {
		this.rucdocument = rucdocument;
	}

	public TblTipodocumento getTblTipodocumento() {
		return this.tblTipodocumento;
	}

	public void setTblTipodocumento(TblTipodocumento tblTipodocumento) {
		this.tblTipodocumento = tblTipodocumento;
	}

}