package proyectofinal;

import java.util.Scanner;
import Clases.*;

public class ProyectoFinal {
    public static void main(String[] args) {
       
        Scanner teclado=new Scanner(System.in);
        int opc=0, opc2=0, codigo, cantidad;
        double precioVenta, precioAlquiler;
        String nombre, categoria,ref, ref2, apellido, direccion, genero, telefono;
        Productos producto=new Productos();
        Clientes Cliente=new Clientes();
        VentasAlquiler deHoy=new VentasAlquiler();
        
        do {
            System.out.println("__________MENÚ__________");
            System.out.println("    ------------------   ");
            System.out.println(" 1. Ingreso de productos");
            System.out.println(" 2. Ingreso de clientes");
            System.out.println(" 3. Realizar venta");
            System.out.println(" 4. Realizar alquiler");
            System.out.println(" 5. Mostrar facturas de ventas y alquileres realizados");
            System.out.println(" 6. Salir del menú");
            System.out.println("    Ingrese su opción   ");
            opc=teclado.nextInt();
            switch (opc){
                case 1:
                    do{
                        System.out.println("______MENÚ INGRESO DE PRODUCTOS______");
                        System.out.println(" 1. Ingresar producto nuevo");
                        System.out.println(" 2. Actualizar producto");
                        System.out.println(" 3. Buscar un producto");
                        System.out.println(" 4. Eliminar un producto");
                        System.out.println(" 5. Mostrar los productos");
                        System.out.println(" 6. Salir del menú ingreso de productos");
                        System.out.println("    Ingrese su opción   ");
                        opc2= teclado.nextInt();
                        switch (opc2){
                            case 1: 
                                System.out.println("Ingrese el producto nuevo");
                                nombre=teclado.next();
                                System.out.println("Ingrese el codigo del producto");
                                codigo=teclado.nextInt();
                                System.out.println("Ingrese el precio de venta del producto");
                                precioVenta=teclado.nextDouble();
                                System.out.println("Ingrese el precio de alquiler del producto");
                                precioAlquiler=teclado.nextDouble();
                                System.out.println("Ingrese la cantidad de productos");
                                cantidad=teclado.nextInt();
                                System.out.println("Ingrese la categoría del producto");
                                categoria=teclado.next();
                                producto.Insertar(codigo, nombre, precioVenta, precioAlquiler, cantidad, categoria);
                                break;                                
                            case 2:
                                System.out.println("Ingrese el nombre del producto que desea actualizar");   
                                ref=teclado.next();
                                System.out.println("Ingrese el producto nuevo");
                                nombre=teclado.next();
                                System.out.println("Ingrese el codigo del producto");
                                codigo=teclado.nextInt();
                                System.out.println("Ingrese el precio de venta del producto");
                                precioVenta=teclado.nextDouble();
                                System.out.println("Ingrese el precio de alquiler del producto");
                                precioAlquiler=teclado.nextDouble();
                                System.out.println("Ingrese la cantidad de productos");
                                cantidad=teclado.nextInt();
                                System.out.println("Ingrese la categoría del producto");
                                categoria=teclado.next();
                                producto.EditarProducto(ref, codigo, nombre, precioVenta, precioAlquiler, cantidad, categoria);
                                break;                                    
                            case 3:
                                System.out.println("Ingrese el nombre del producto que desea buscar");   
                                ref=teclado.next();
                                producto.Buscar(ref);
                                break;                                    
                            case 4:
                                System.out.println("Ingrese el nombre del producto que desea eliminar");   
                                ref=teclado.next();
                                producto.EliminarProducto(ref);
                                break;                                
                            case 5:
                               producto.MostrarInfo();
                               break;
                            case 6:
                                System.out.println("Saliste del menú de ingreso de productos.");
                                break;
                            default:
                                System.out.println("Opción incorrecta, intente de nuevo.");
                                break;
                        }
                    }while (opc2!=6);                            
                    break;
                case 2: 
                    do{
                        System.out.println("______MENÚ INGRESO DE CLIENTES______");
                        System.out.println(" 1. Ingresar cliente nuevo");
                        System.out.println(" 2. Actualizar cliente");
                        System.out.println(" 3. Buscar un cliente");
                        System.out.println(" 4. Eliminar un cliente");
                        System.out.println(" 5. Mostrar los clientes ingresados");
                        System.out.println(" 6. Salir del menú ingreso de cliente");
                        System.out.println("    Ingrese su opción   ");
                        opc2= teclado.nextInt();
                        
                        switch(opc2){
                            case 1: 
                                System.out.println("Ingrese el cliente nuevo");
                                nombre=teclado.next();
                                System.out.println("Ingrese el apellido del cliente");
                                apellido=teclado.next();
                                System.out.println("Ingrese la direccion del cliente");
                                direccion=teclado.next();
                                System.out.println("Ingrese el telefono del cliente");
                                telefono=teclado.next();
                                System.out.println("Ingrese el genero del cliente");
                                genero=teclado.next();
                                System.out.println("Ingrese el código del cliente");
                                codigo=teclado.nextInt();
                                Cliente.Insertar(apellido, nombre, direccion, telefono, genero, codigo);
                                break;                                
                            case 2:
                                System.out.println("Ingrese el cliente a actualizar");
                                ref=teclado.next();
                                System.out.println("Ingrese el cliente nuevo");
                                nombre=teclado.next();
                                System.out.println("Ingrese el apellido del cliente");
                                apellido=teclado.next();
                                System.out.println("Ingrese la direccion del cliente");
                                direccion=teclado.next();
                                System.out.println("Ingrese el telefono del cliente");
                                telefono=teclado.next();
                                System.out.println("Ingrese el genero del cliente");
                                genero=teclado.next();
                                System.out.println("Ingrese elcodigo del cliente");
                                codigo=teclado.nextInt();
                                Cliente.EditarCliente(ref, apellido, nombre, direccion, telefono, genero, codigo);
                                break;                                    
                            case 3:
                                System.out.println("Ingrese el nombre del cliente que desea buscar");   
                                ref=teclado.next();
                                Cliente.BuscarClientes(ref);
                                break;                                    
                            case 4:
                                System.out.println("Ingrese el nombre del cliente que desea eliminar");   
                                ref=teclado.next();
                                Cliente.EliminarCliente(ref);
                                break;                                
                            case 5:
                               Cliente.MostrarInfo();
                               break;
                            case 6:
                                System.out.println("Saliste del menú de ingreso de clientes.");
                                break;
                            default:
                                System.out.println("Opción incorrecta, intente de nuevo.");
                                break;
                            }
                             
                    }while (opc2!=6);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del cliente");
                    ref=teclado.next();
                    System.out.println("Ingrese el nombre del producto que desea comprar:");
                    ref2=teclado.next();
                    deHoy.RealizarVenta(Cliente, producto, ref, ref2);
                    break;
                case 4:
                    do{
                        System.out.println("______MENÚ REALIZAR ALQUILER______");
                        System.out.println(" 1. Alquilar");
                        System.out.println(" 2. Devolver");
                        System.out.println(" 3. Salir del menú realizar alquiler");
                        System.out.println("    Ingrese su opción   ");
                        opc2= teclado.nextInt();
                        switch(opc2){
                            case 1:
                                System.out.println("Ingrese el nombre del cliente");
                                ref=teclado.next();
                                System.out.println("Ingrese el nombre del producto que desea alquilar:");
                                ref2=teclado.next();
                                deHoy.RealizarAlquiler(Cliente, producto, ref, ref2);
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre del cliente que desea realizar devolución.");
                                ref=teclado.next();
                                System.out.println("Ingrese el nombre del producto que desea devolver: ");
                                ref2=teclado.next();
                                deHoy.RealizarDevolución(Cliente, producto, ref, ref2);
                                break;
                            case 3:
                                System.out.println("Saliste del menú alquiler.");
                                break;
                            default:
                                System.out.println("Opción incorrecta, intente de nuevo.");
                                break;
                        }
                    }while (opc2!=3);
                    break;  
                case 5:
                    deHoy.MostrarVentas();
                    deHoy.MostrarAlquileres();
                    break;
                case 6:
                    System.out.println("Saliste del programa.");
                    break;
                default:
                    System.out.println("Opción incorrecta, intente de nuevo.");
                    break;
            }
        }while (opc!=6);
        
    }
}
