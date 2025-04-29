package Clases;

public class Productos {
    protected NodoProductos CAB;

    public Productos() {
        this.CAB=null;
    }
    
    public boolean EsVacia(){
        return CAB==null;
    }
    
    public void Insertar(int codigo, String nombre, double precioVenta,double precioAlquiler, int cantidad, String categoria){
        NodoProductos nuevo=new NodoProductos();
        nuevo.nombre=nombre;
        nuevo.codigo=codigo;
        nuevo.precioVenta=precioVenta;
        nuevo.precioAlquiler=precioAlquiler;
        nuevo.cantidad=cantidad;
        nuevo.categoria=categoria;
        if(EsVacia()){
            CAB=nuevo;
            nuevo.sig=null;
        }else{
            nuevo.sig=CAB;
            CAB=nuevo;
        }
        System.out.println("El producto se ha agregado\n");
    }
     
    public void MostrarInfo(){
            
        if(!EsVacia()){
            int cont=1;
            NodoProductos t=CAB;
            while(t!=null){
                System.out.println("Información del producto número "+cont+" en la lista");
                System.out.println("Nombre: "+ t.nombre+
                                 "\nCódigo: "+ t.codigo+
                                 "\nPrecio Venta: "+ t.precioVenta+
                                 "\nPrecio alquiler "+ t.precioAlquiler+
                                 "\nCantidad: "+ t.cantidad+
                                 "\nCategoría: "+ t.categoria);
                System.out.println("");
                cont++;
                t=t.sig;
            }
            System.out.println("");
        }else{
            System.out.println("Aún no se ingresaron productos.\n");
        }
        System.out.println("");
            
    }
     
    public boolean Existe(String ref){
        NodoProductos t=CAB;
        boolean encontro=false;
        while(t!=null && encontro!=true){
            if(t.nombre.equalsIgnoreCase(ref)){
                 encontro=true;
            }else{
                 t=t.sig;
            }
        }     
        return encontro;
    }
     
    public void EditarProducto(String ref,int codigo, String nombre, double precioVenta,double precioAlquiler, int cantidad, String categoria){
        if(!EsVacia()){
            NodoProductos t=CAB;
            if(Existe(ref)){
                while(!t.nombre.equalsIgnoreCase(ref)){
                    t=t.sig;
                }
                t.nombre=nombre;
                t.codigo=codigo;
                t.precioVenta=precioVenta;
                t.precioAlquiler=precioAlquiler;
                t.cantidad=cantidad;
                t.categoria=categoria;
                System.out.println("El producto se ha actualizado\n");
            }else{
                System.out.println("El producto no se encontró\n");
            }
        }else{
            System.out.println("Aún no se ingresaron productos.\n");
        }  
           
             
    }
    
    public void ImprimirUno (String ref){
        NodoProductos t = CAB;
        boolean encontro=false;
        int cont = 0;
        while(t!=null && encontro!=true){
            cont++;
            if (t.nombre.equalsIgnoreCase(ref)){
                encontro=true;
            }else{
                t=t.sig;
            }
        }
        
        System.out.println("Información del producto número "+cont+" en la lista");
        System.out.println("Nombre: "+ t.nombre+
                        "\nCódigo: "+ t.codigo+
                        "\nPrecio Venta: "+ t.precioVenta+
                        "\nPrecio alquiler "+ t.precioAlquiler+
                        "\nCantidad: "+ t.cantidad+
                        "\nCategoría: "+ t.categoria);
        System.out.println("\n");
        
    }
    
    public void Buscar(String ref){
        if(!EsVacia()){
            if(Existe(ref)){
                System.out.println("El producto está en el inventario!");
                ImprimirUno(ref);
            }else{
                System.out.println("El producto no está en el inventario!\n");
            }
        }else{
            System.out.println("Aún no se ingresaron productos.\n");
        }  
            
    }
     
    public void EliminarProducto(String ref){
        if(!EsVacia()){
            if (Existe(ref)){
                if (CAB.nombre.equalsIgnoreCase(ref)){
                    CAB=CAB.sig;                                 
                }else{
                    NodoProductos t=CAB;
                    while (!(t.sig.nombre.equalsIgnoreCase(ref))){
                        t=t.sig;
                    }    
                    NodoProductos nodoAux=t.sig.sig;
                    t.sig=nodoAux;            
                }
            }
        }else{
            System.out.println("Aún no se ingresaron productos.\n");
        }
            
        
    }
    
    public String getNombre(String ref){
        NodoProductos t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.nombre;
    }
    
    public String getCategoria(String ref){
        NodoProductos t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.categoria;
    }
    
    
    public double getPrecioVenta(String ref){
        NodoProductos t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.precioVenta;
    }
    
    public double getPrecioAlquiler(String ref){
        NodoProductos t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.precioAlquiler;
    }
    
    public int getCodigo(String ref){
        NodoProductos t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.codigo;
    }
    
    public int getCantidad(String ref){
        NodoProductos t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.cantidad;
    }
    
    public void setCantidad(String ref, int cantidad){
        NodoProductos t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        
        t.cantidad-=cantidad;   
           
    }
    
    public void setCantidad2(String ref, int cantidad){
        NodoProductos t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        
        t.cantidad+=cantidad;   
           
    }
  
    
}
