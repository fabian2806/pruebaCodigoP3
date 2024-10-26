package pe.edu.pucp.softrh.compras.model;

public class Boleta extends Comprobante{
    private String dni;
    private String nombres;
    private String apellidos;

	public Boleta() {}

    public Boleta(Double totalPagar, OrdenCompra orden, String dni, String nombres, String apellidos) {
        super(totalPagar, orden);
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
