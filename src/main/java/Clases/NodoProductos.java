package Clases;

public class NodoProductos {
    
    protected NodoProductos sig;
    protected String nombre;
    protected String categoria;
    protected int codigo;
    protected int cantidad;
    protected double precioVenta;
    protected double precioAlquiler;
    
    public NodoProductos() {
    }

    public NodoProductos(NodoProductos sig, int codigo, String nombre, double precioVenta, double precioAlquiler, int cantidad, String categoria) {
        this.sig = sig;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioAlquiler = precioAlquiler;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public NodoProductos getSig() {
        return sig;
    }

    public void setSig(NodoProductos sig) {
        this.sig = sig;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    String setNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
