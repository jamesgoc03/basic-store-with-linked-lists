package Clases;

import java.util.Scanner;

public class VentasAlquiler {
    
    protected NodoVentasAlquiler CAB;
    static Scanner teclado = new Scanner(System.in);

    public VentasAlquiler() {
        this.CAB=null;
    }
    
    public boolean EsVacia(){
        return CAB==null;
    }
    
    public void RealizarVenta(Clientes c, Productos p, String ref, String ref2){
        
        if(!c.EsVacia()){
            if(c.Existe(ref)){
                if(!p.EsVacia()){
                    if (p.Existe(ref2)){
                        
                        boolean aprobado=false;
                        int cantidad=0;
                        do{
                            System.out.println("Número de "+ref2+ " en stock: "+p.getCantidad(ref2));
                            System.out.println("¿Qué cantidad desea comprar?:");
                            cantidad=teclado.nextInt();
                            if (p.getCantidad(ref2)>=cantidad){
                                p.setCantidad(ref2, cantidad);
                                aprobado=true;
                             }else{
                                System.out.println("No se pudo realizar la transacción, la cantidad ingresada es mayor al inventario disponible.");
                                System.out.println("Intente de nuevo con una cantidad inferior.\n");
                            }
                        }while(!aprobado);     
                        
                        NodoVentasAlquiler nuevo = new NodoVentasAlquiler();
                        System.out.println("Ingrese el número del día de la venta:");
                        nuevo.diaCompra=teclado.nextInt();
                        System.out.println("Ingrese el número del mes de la venta:");
                        nuevo.mesCompra=teclado.nextInt();
                        System.out.println("Ingrese el número del año de la venta:");
                        nuevo.añoCompra=teclado.nextInt();
                        nuevo.nombre=c.getNombre(ref);
                        nuevo.apellido=c.getApellido(ref);
                        nuevo.codigo=c.getCodigo(ref);
                        nuevo.direccion=c.getdireccion(ref);
                        nuevo.telefono=c.getelefono(ref);
                        nuevo.genero=c.getgenero(ref);
                        nuevo.nombrep=p.getNombre(ref2);
                        nuevo.categoria=p.getCategoria(ref2);
                        nuevo.codigop=p.getCodigo(ref2);
                        nuevo.precio=p.getPrecioVenta(ref2);
                        nuevo.cantidad=cantidad;
                        nuevo.iva=0.19*p.getPrecioVenta(ref2);
                        nuevo.precioFinal=p.getPrecioVenta(ref2)*cantidad+nuevo.iva*cantidad;
                        nuevo.VentaOAlquiler=1;
                        System.out.println("Ingrese el valor del descuento que tiene:");
                        nuevo.descuento=teclado.nextDouble();
                        nuevo.precioFinal=nuevo.precioFinal-nuevo.descuento;
                        System.out.println("El precio final de la compra es: "+nuevo.precioFinal);
                        System.out.println("Ingrese el valor con el que va a pagar:");
                        nuevo.pagocon=teclado.nextDouble();
                        nuevo.devuelta=nuevo.pagocon-nuevo.precioFinal;
                        UnaFacturaVenta(nuevo);
                        if(EsVacia()){
                            CAB=nuevo;
                            nuevo.sig=null;
                        }else{
                            nuevo.sig=CAB;
                            CAB=nuevo;
                        }
                        
                    }else{
                        System.out.println("No se pudo realizar la venta porque el producto no éxiste.");
                    }
                }else{
                    System.out.println("No se pudo realizar la venta porque la lista de productos está vacia.\n");
                }
            }else{
                System.out.println("No se puede realizar la venta porque el cliente no existe,\n");
            }
        }else{
            System.out.println("No se puede realizar la venta porque la lista de clientes está vacia.\n");
        }
            
        
    }
    
    
    
    public void RealizarAlquiler(Clientes c, Productos p, String ref, String ref2){
        
        if(!c.EsVacia()){
            if(c.Existe(ref)){
                if(!p.EsVacia()){
                    if (p.Existe(ref2)){
                        
                        boolean aprobado=false;
                        int cantidad=0;
                        do{
                            System.out.println("Número de "+ref2+ " en stock: "+p.getCantidad(ref2));
                            System.out.println("¿Qué cantidad desea alquilar?:");
                            cantidad=teclado.nextInt();
                            if (p.getCantidad(ref2)>=cantidad){
                                p.setCantidad(ref2, cantidad);
                                aprobado=true;
                             }else{
                                System.out.println("No se pudo realizar la transacción, la cantidad ingresada es mayor al inventario disponible.");
                                System.out.println("Intente de nuevo con una cantidad inferior.\n");
                            }
                        }while(!aprobado);     
                        
                        NodoVentasAlquiler nuevo = new NodoVentasAlquiler();
                        System.out.println("Ingrese el número del día del alquiler:");
                        nuevo.diaCompra=teclado.nextInt();
                        System.out.println("Ingrese el número del mes del alquiler:");
                        nuevo.mesCompra=teclado.nextInt();
                        System.out.println("Ingrese el número del año del alquiler:");
                        nuevo.añoCompra=teclado.nextInt();
                        System.out.println("Ingrese el número de días en que debe devolver el producto:");
                        nuevo.diasDevolucion=teclado.nextInt();
                        System.out.println("Ingrese la multa por día de mora");
                        nuevo.mora=teclado.nextDouble();
                        nuevo.nombre=c.getNombre(ref);
                        nuevo.apellido=c.getApellido(ref);
                        nuevo.codigo=c.getCodigo(ref);
                        nuevo.direccion=c.getdireccion(ref);
                        nuevo.telefono=c.getelefono(ref);
                        nuevo.genero=c.getgenero(ref);
                        nuevo.nombrep=p.getNombre(ref2);
                        nuevo.categoria=p.getCategoria(ref2);
                        nuevo.codigop=p.getCodigo(ref2);
                        nuevo.precio=p.getPrecioAlquiler(ref2);
                        nuevo.cantidad=cantidad;
                        nuevo.iva=0.19*p.getPrecioAlquiler(ref2);
                        nuevo.precioFinal=p.getPrecioAlquiler(ref2)*cantidad+nuevo.iva*cantidad;
                        nuevo.VentaOAlquiler=0;
                        nuevo.devuelto=false;
                        System.out.println("Ingrese el valor del descuento que tiene:");
                        nuevo.descuento=teclado.nextDouble();
                        nuevo.precioFinal=nuevo.precioFinal-nuevo.descuento;
                        System.out.println("El precio final del alquiler es: "+nuevo.precioFinal);
                        System.out.println("Ingrese el valor con el que va a pagar:");
                        nuevo.pagocon=teclado.nextDouble();
                        nuevo.devuelta=nuevo.pagocon-nuevo.precioFinal;
                        UnaFacturaAlquiler(nuevo);
                        if(EsVacia()){
                            CAB=nuevo;
                            nuevo.sig=null;
                        }else{
                            nuevo.sig=CAB;
                            CAB=nuevo;
                        }
                        
                    }else{
                        System.out.println("No se pudo realizar el alquiler porque el producto no éxiste en la lista.\n");
                    }
                }else{
                    System.out.println("No se pudo realizar el alquiler porque la lista de productos está vacia.\n");
                }
            }else{
                System.out.println("No se puede realizar el alquiler porque el cliente no existe en la lista.\n");
            }
        }else{
            System.out.println("No se puede realizar la alquiler porque la lista de clientes está vacia.\n");
        }
            
        
    }
    
    public boolean ExisteN(String ref){
        NodoVentasAlquiler t=CAB;
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
    
    public boolean Existep(String ref){
        NodoVentasAlquiler t=CAB;
        boolean encontro=false;
        while(t!=null && encontro!=true){
            if(t.nombrep.equalsIgnoreCase(ref)){
                 encontro=true;
            }else{
                 t=t.sig;
            }
        }     
        return encontro;
    }
    
    public void RealizarDevolución(Clientes c, Productos p, String ref, String ref2){
        if(!EsVacia()){
            if(ExisteN(ref)){
                if (Existep(ref2)){
                    
                    NodoVentasAlquiler t=CAB;
                    while(t!=null && !t.nombre.equalsIgnoreCase(ref)){                        
                        t=t.sig;
                    }
                    
                    if (t.VentaOAlquiler==0){
                        if(t.devuelto==false){
                            boolean aprobado=false;
                            do{
                                System.out.println("¿Cuántos productos con nombre "+t.nombrep+" está devolviendo?");
                                int cantidad=teclado.nextInt();
                                if(t.cantidad==cantidad){
                                    System.out.println("¿Cuántos días permanecio con los productos?: ");
                                    int dias=teclado.nextInt();
                                    if(t.diasDevolucion<dias){
                                        t.díasMora=dias-t.diasDevolucion;
                                        t.MultaTotal=t.mora*t.díasMora;
                                        System.out.println("Usted tuvo "+t.díasMora+" de mora, que multiplicados por la multa de: ");
                                        System.out.println(t.mora+" Por día de mora, da un total de: "+t.MultaTotal);
                                        p.setCantidad2(ref2, cantidad);
                                        t.devuelto=true;
                                    }else{
                                        System.out.println("Usted entrego el producto a tiempo, no tendrá cobro por mora.");
                                        t.díasMora=0;
                                        t.MultaTotal=0;
                                        t.devuelto=true;
                                    }
                                    aprobado=true;
                                }else {
                                    System.out.println("La cantidad que debe devolver no está completa, intente de nuevo.");
                                    System.out.println("Recuerde que la cantidad que debe entregar es: " + t.cantidad);
                                } 
                            }while(!aprobado);
                        }else{
                            System.out.println("El producto ya fue devuelto.");
                        }
                    }else{
                        System.out.println("El cliente no ha ralizado un alquiler.");
                    }
                }else{
                    System.out.println("El producto que se quiere devolver no ha sido alquilado.");
                }
            }else{
                System.out.println("El cliente no se encuentra en la lista de alquileres.");
            }
        }else{
            System.out.println("No se han realizado alquileres aún");
        }
    }
    
    public void UnaFacturaVenta(NodoVentasAlquiler nueva){
        System.out.println("**********Factura de compra**********");
        System.out.println("_____________________________________");
        System.out.println("Fecha de venta: \nDía: "+nueva.diaCompra+" Mes: "+nueva.mesCompra+" Año: "+nueva.añoCompra);
        System.out.println("_____________________________________");
        System.out.println("Datos del cliente:");
        System.out.println("Nombre: "+nueva.nombre);
        System.out.println("Apellido: "+nueva.apellido);
        System.out.println("Código: "+nueva.codigo);
        System.out.println("Telefono: "+nueva.telefono);
        System.out.println("Dirección: "+nueva.direccion);
        System.out.println("Genero: "+nueva.genero);
        System.out.println("_____________________________________");
        System.out.println("Datos de la compra:");
        System.out.println("Nombre del producto: "+nueva.nombrep);
        System.out.println("Categoria: "+nueva.categoria);
        System.out.println("Código: "+nueva.codigop);
        System.out.println("precio unidad: "+nueva.precio);
        System.out.println("Precio del iva del 19%: "+nueva.iva);
        System.out.println("Cantidad comprada: "+nueva.cantidad);
        System.out.println("Descuento aplicado: "+nueva.descuento);
        System.out.println("");
        System.out.println("Precio final + iva sin descuento: "+(nueva.precioFinal+nueva.descuento));
        System.out.println("Precio final + iva con descuento: "+nueva.precioFinal);
        System.out.println("Pago con: "+nueva.pagocon);
        System.out.println("Dinero devuelto: "+nueva.devuelta);
        System.out.println("");
    }
    
    
    public void UnaFacturaAlquiler(NodoVentasAlquiler nueva){
        System.out.println("**********Factura de alquiler**********");
        System.out.println("_____________________________________");
        System.out.println("Fecha de alquiler: \nDía: "+nueva.diaCompra+" Mes: "+nueva.mesCompra+" Año: "+nueva.añoCompra);
        System.out.println("_____________________________________");
        System.out.println("Días en los que debe hacer devolución: \n"+nueva.diasDevolucion+" Días.");
        System.out.println("_____________________________________");
        System.out.println("Datos del cliente:");
        System.out.println("Nombre: "+nueva.nombre);
        System.out.println("Apellido: "+nueva.apellido);
        System.out.println("Código: "+nueva.codigo);
        System.out.println("Telefono: "+nueva.telefono);
        System.out.println("Dirección: "+nueva.direccion);
        System.out.println("Genero: "+nueva.genero);
        System.out.println("_____________________________________");
        System.out.println("Datos de la compra:");
        System.out.println("Nombre del producto: "+nueva.nombrep);
        System.out.println("Categoria: "+nueva.categoria);
        System.out.println("Código: "+nueva.codigop);
        System.out.println("precio unidad: "+nueva.precio);
        System.out.println("Precio del iva del 19%: "+nueva.iva);
        System.out.println("Cantidad comprada: "+nueva.cantidad);
        System.out.println("Descuento aplicado: "+nueva.descuento);
        System.out.println("Multa por día si ocurre tiempo de mora: "+nueva.mora);
        System.out.println("");
        System.out.println("Precio final + iva sin descuento: "+(nueva.precioFinal+nueva.descuento));
        System.out.println("Precio final + iva con descuento: "+nueva.precioFinal);
        System.out.println("Pago con: "+nueva.pagocon);
        System.out.println("Dinero devuelto: "+nueva.devuelta);
        System.out.println("");
    }
    
    public void MostrarAlquileres(){
        
        System.out.println("");
            
        if (!EsVacia()){
            
            int cont=1;
            NodoVentasAlquiler nueva=CAB;
            
            while(nueva!=null){
                if(nueva.VentaOAlquiler==0){
                    System.out.println("**********Factura de alquiler #"+cont+"**********");
                    System.out.println("_____________________________________");
                    System.out.println("Fecha de alquiler: \nDía: "+nueva.diaCompra+" Mes: "+nueva.mesCompra+" Año: "+nueva.añoCompra);
                    System.out.println("_____________________________________");
                    System.out.println("Días en los que debe hacer devolución: \n"+nueva.diasDevolucion+" Días.");
                    System.out.println("_____________________________________");
                    System.out.println("Datos del cliente:");
                    System.out.println("Nombre: "+nueva.nombre);
                    System.out.println("Apellido: "+nueva.apellido);
                    System.out.println("Código: "+nueva.codigo);
                    System.out.println("Telefono: "+nueva.telefono);
                    System.out.println("Dirección: "+nueva.direccion);
                    System.out.println("Genero: "+nueva.genero);
                    System.out.println("_____________________________________");
                    System.out.println("Datos de la compra:");
                    System.out.println("Nombre del producto: "+nueva.nombrep);
                    System.out.println("Categoria: "+nueva.categoria);
                    System.out.println("Código: "+nueva.codigop);
                    System.out.println("precio unidad: "+nueva.precio);
                    System.out.println("Precio del iva del 19%: "+nueva.iva);
                    System.out.println("Cantidad comprada: "+nueva.cantidad);
                    System.out.println("Descuento aplicado: "+nueva.descuento);
                    System.out.println("Multa por día si ocurre tiempo de mora: "+nueva.mora);
                    System.out.println("");
                    System.out.println("Precio final + iva sin descuento: "+(nueva.precioFinal+nueva.descuento));
                    System.out.println("Precio final + iva con descuento: "+nueva.precioFinal);
                    System.out.println("Pago con: "+nueva.pagocon);
                    System.out.println("Dinero devuelto: "+nueva.devuelta);
                    System.out.println("");
                    if (nueva.devuelto){
                        System.out.println("Producto devuelto: Sí");
                        if(nueva.díasMora>0){
                            System.out.println("Días de mora: "+nueva.díasMora);
                            System.out.println("Multa total por días de mora: "+nueva.MultaTotal);
                            System.out.println("Nuevo total pagado: "+(nueva.MultaTotal+nueva.precioFinal));
                        }else{
                            System.out.println("Días de mora: No aplica");
                            System.out.println("Multa total por días de mora: No aplica");
                        }
                    }else{
                        System.out.println("Devuelto: No");
                    }
                    cont++;
                }
                nueva=nueva.sig;
            }
        }else{
            System.out.println("Aún no se realizaron alquileres.\n");
        }
        System.out.println("");
            
    }
    
    public void MostrarVentas(){
        
        System.out.println("");
        
        if(!EsVacia()){
            int cont=1;
            NodoVentasAlquiler nueva=CAB;
            
            while(nueva!=null){
                if(nueva.VentaOAlquiler==1){
                    System.out.println("**********Factura de venta #"+cont+"**********");
                    System.out.println("_____________________________________");
                    System.out.println("Fecha de venta: \nDía: "+nueva.diaCompra+" Mes: "+nueva.mesCompra+" Año: "+nueva.añoCompra);
                    System.out.println("_____________________________________");
                    System.out.println("Datos del cliente:");
                    System.out.println("Nombre: "+nueva.nombre);
                    System.out.println("Apellido: "+nueva.apellido);
                    System.out.println("Código: "+nueva.codigo);
                    System.out.println("Telefono: "+nueva.telefono);
                    System.out.println("Dirección: "+nueva.direccion);
                    System.out.println("Genero: "+nueva.genero);
                    System.out.println("_____________________________________");
                    System.out.println("Datos de la compra:");
                    System.out.println("Nombre del producto: "+nueva.nombrep);
                    System.out.println("Categoria: "+nueva.categoria);
                    System.out.println("Código: "+nueva.codigop);
                    System.out.println("precio unidad: "+nueva.precio);
                    System.out.println("Precio del iva del 19%: "+nueva.iva);
                    System.out.println("Cantidad comprada: "+nueva.cantidad);
                    System.out.println("Descuento aplicado: "+nueva.descuento);
                    System.out.println("");
                    System.out.println("Precio final + iva sin descuento: "+(nueva.precioFinal+nueva.descuento));
                    System.out.println("Precio final + iva con descuento: "+nueva.precioFinal);
                    System.out.println("Pago con: "+nueva.pagocon);
                    System.out.println("Dinero devuelto: "+nueva.devuelta);
                    
                    cont++;
                }
                nueva=nueva.sig;
            }
        }else{
            System.out.println("No se han realizado ventas aún.");
        }
        
    }
    
    
}
