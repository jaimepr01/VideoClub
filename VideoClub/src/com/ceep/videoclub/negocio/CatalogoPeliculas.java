package com.ceep.videoclub.negocio;

import com.ceep.videoclub.datos.AccesoDatosImp;
import com.ceep.videoclub.datos.IAccesoDatos;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.AccesoDatosEx;
import com.ceep.videoclub.excepciones.EscrituraDatosEx;
import com.ceep.videoclub.excepciones.LecturaDatosEx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogoPeliculas implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculas() {
        this.datos = new AccesoDatosImp();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreCatalogo) {
        try {
            if (this.datos.existe(nombreCatalogo)) {
                this.datos.escribir(new Pelicula(nombrePelicula),nombreCatalogo,true);
            } else{
                System.out.println("CATALOGO NO INICIADO");
            }
        } catch (EscrituraDatosEx ex) {
            System.out.println("Excepción agregando la película");
            ex.printStackTrace(System.out);
        } catch (AccesoDatosEx ex) {
            Logger.getLogger(CatalogoPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void listarPeliculas(String nombreCatalogo) {

        List<Pelicula> peliculas = new ArrayList<>();
        try {
            peliculas = this.datos.listar(nombreCatalogo);
            peliculas.forEach(pelicula -> {
                System.out.println(pelicula.getNombre());
            });
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPeliculas(String nombreCatalogo, String buscar) {
        try {
            System.out.println(this.datos.buscar(nombreCatalogo, buscar));
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);

        }
    }

    @Override
    public void iniciarArchivo(String nombreCatalogo) {
        try {
            if (this.datos.existe(nombreCatalogo)){
                this.datos.borrar(nombreCatalogo);
                this.datos.crear(nombreCatalogo);
            }else{
                this.datos.crear(nombreCatalogo);
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            System.out.println("Error al inicializar el catálogo de películas");
        }
        
    }
}
