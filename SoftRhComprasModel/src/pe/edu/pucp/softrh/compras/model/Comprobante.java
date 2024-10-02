package pe.edu.pucp.softrh.compras.model;

public abstract class Comprobante {
    protected static Integer id=1;
    protected Integer idComprobante;
    protected Double totalPagar;

    public Comprobante(Integer idComprobante, Double totalPagar) {
        this.idComprobante = id;
        this.totalPagar = totalPagar;
        id++;
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
}
