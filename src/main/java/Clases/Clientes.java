package Clases;

import java.util.Scanner;

public class Clientes {
    
    static Scanner teclado=new Scanner(System.in);
    protected NodoClientes CAB;

    public Clientes() {
        this.CAB=null;
    }
    
    public boolean EsVacia(){
        return CAB==null;
    }
    
    public void Insertar(String apellido, String nombre,String direccion,String telefono,String genero,int codigo){
        NodoClientes nuevo=new NodoClientes();
        nuevo.nombre=nombre;
        nuevo.apellido=apellido;
        nuevo.direccion=direccion;
        nuevo.telefono=telefono;
        nuevo.genero=genero;
        nuevo.codigo=codigo;
        if(EsVacia()){
            CAB=nuevo;
            nuevo.sig=null;
        }else{
            nuevo.sig=CAB;
            CAB=nuevo;
        }
        System.out.println("El cliente se ha agregado\n");
    }
     
    public void MostrarInfo(){
         
        if(!EsVacia()){
            int cont=1;
            NodoClientes t=CAB;
            while(t!=null){
                System.out.println("");
                System.out.println("Información del cliente número "+cont+" en la lista");
                System.out.print(" Nombre: "+ t.nombre+
                                 "\n Apellido: "+ t.apellido+
                                 "\n Direccion: "+ t.direccion+
                                 "\n Telefono "+ t.telefono+
                                 "\n Genero: "+ t.genero+
                                 "\n Codigo: "+ t.codigo);
                System.out.println("");
                cont++;
                t=t.sig;
            }
            System.out.println("");
        }else{
            System.out.println("Aún no se han ingresado clientes.\n");
        }
        System.out.println("");
            
    }
     
    public boolean Existe(String ref){
          
        NodoClientes t=CAB;
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
     
    public void EditarCliente(String ref,String apellido, String nombre,String direccion,String telefono,String genero,int codigo){
        if(!EsVacia()){
            NodoClientes t=CAB;
            if(Existe(ref)){
                while(!t.nombre.equals(ref)){
                    t=t.sig;
                }
                t.nombre=nombre;
                t.apellido=apellido;
                t.direccion=direccion;
                t.telefono=telefono;
                t.genero=genero;
                t.codigo=codigo;
                System.out.println("El cliente se ha actualizado.\n");
            }else{
                System.out.println("El cliente no se encontró.\n");
            }
        }else{
            System.out.println("Aún no se han ingresado clientes.\n");
        }          
             
    }
    
    public void ImprimirUno (String ref){
        NodoClientes t = CAB;
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
        System.out.println("Información del cliente número "+cont+" en la lista");
        System.out.println(" Nombre: "+ t.nombre+
                        "\n Apellido: "+ t.apellido+
                        "\n Direccion: "+ t.direccion+
                        "\n Telefono "+ t.telefono+
                        "\n Genero: "+ t.genero+
                        "\n Codigo: "+ t.codigo);
        System.out.println("\n");
    }
     
    public void BuscarClientes(String ref){
        if(!EsVacia()){
            if(Existe(ref)){
                System.out.println("El cliente está en la lista!");
                ImprimirUno(ref);       
            }else{
                System.out.println("El cliente no está en la lista!\n");
            }
        }else{
            System.out.println("Aún no se han ingresado clientes.\n");
        }  
    }
     
    public void EliminarCliente(String ref){
        if (Existe(ref)){
            if (CAB.nombre.equals(ref)){
                CAB=CAB.sig;                                 
            }else{
                NodoClientes t=CAB;
                while (!(t.sig.nombre.equals(ref))){
                    t=t.sig;
                }    
                NodoClientes nodoAux=t.sig.sig;
                t.sig=nodoAux;            
            }
            System.out.println("El cliente "+ref+" se elimino con éxito.\n");
        }
    }
    
    public String getNombre(String ref){
        NodoClientes t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.nombre;
    }
    
    public String getApellido (String ref){
        NodoClientes t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.apellido;
    }
    
    public String getdireccion (String ref){
        NodoClientes t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.direccion;
    }
    
    public String getelefono(String ref){
        NodoClientes t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.telefono;
    }
    
    public String getgenero (String ref){
        NodoClientes t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.genero;
    }
    
    public int getCodigo (String ref){
        NodoClientes t=CAB;
        while(!t.nombre.equalsIgnoreCase(ref)){
            t=t.sig;
        }
        return t.codigo;
    }
    
    
}

