package pe.edu.pucp.softrh.compras.model;

public abstract class Comprobante {
    protected Integer idComprobante;
    protected Double totalPagar;
	protected OrdenCompra orden;

	public Comprobante() {}

    public Comprobante(Double totalPagar, OrdenCompra orden) {
        this.totalPagar = totalPagar;
		this.orden = orden;
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

	public OrdenCompra getOrden() {
		return orden;
	}

	public void setOrden(OrdenCompra orden) {
		this.orden = orden;
	}
}
