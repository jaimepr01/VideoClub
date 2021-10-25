
package com.ceep.videoclub.negocio;

public interface ICatalogoPeliculas {
    
    public void agregarPelicula(String nombrePelicula, String nombreArchivo);
    
    public void listarPeliculas(String nombreArchivo);
    
    public void buscarPeliculas(String nombreArchivo, String buscar);
    
    public void iniciarArchivo(String nombreArchivo);
}
