package Clases;

public class NodoClientes {
   
    protected NodoClientes sig;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String telefono;
    protected String genero;
    protected int codigo;
   

    public NodoClientes() {
    }

    public NodoClientes(NodoClientes sig, int codigo, String nombre, String apellido, String direccion, String telefono, String genero) {
        this.sig = sig;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
    }

    public NodoClientes getSig() {
        return sig;
    }

    public void setSig(NodoClientes sig) {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
