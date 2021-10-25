package com.ceep.videoclub;

import java.util.Scanner;
import com.ceep.videoclub.datos.AccesoDatosImp;
import com.ceep.videoclub.negocio.CatalogoPeliculas;
import com.ceep.videoclub.negocio.ICatalogoPeliculas;

public class VideoClub {
    public static void main(String[] args) {
        ICatalogoPeliculas catalogo = new CatalogoPeliculas();
        var nombreCatalogo = "Videoclub.txt";
        var lectura = new Scanner(System.in);
        var nombrePeli = "";
        int opcion;
        Scanner menu = new Scanner(System.in);
        while (true) {
            System.out.println("MENU");
            System.out.println("====");
            System.out.println("1.- Crear");
            System.out.println("2.- Agregar");
            System.out.println("3.- Buscar");
            System.out.println("4.- Listar");
            System.out.println("0.- Salir");
            System.out.println("Elige una opcion");

            opcion = menu.nextInt();
            switch (opcion) {
                case 1:
                    catalogo.iniciarArchivo(nombreCatalogo);
                    System.out.println("Catálogo iniciado");

                    break;
                case 2:
                    System.out.println("Introduzca el nombre de la pelicula que quiere agregar");
                    nombrePeli = lectura.nextLine();
                    catalogo.agregarPelicula(nombrePeli, nombreCatalogo);
                    System.out.println("Se ha agregado la " + nombrePeli + "al catálogo " + nombreCatalogo);
                    break;
                case 3:
                    catalogo.listarPeliculas(nombreCatalogo);
                    System.out.println("Introduzca el nombre de la película que quiere buscar");
                    break;
                case 4:
                    nombrePeli = lectura.nextLine();
                    catalogo.buscarPeliculas(nombreCatalogo, nombrePeli);
                    System.out.println("Nombre de todas las películas del catálogo");
                    break;
                case 0:
                    System.out.println("Gracias por utilizar la aplicación");
                    return;
                default:
                    System.out.println("Debe seleccionar una opción entre 0 y 4");
            }
        }
    }
}
        
