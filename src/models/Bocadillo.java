package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Bocadillo implements Serializable {
    static Scanner teclado = new Scanner(System.in);

    private int id;
    private String nombre;
    private String descrip;
    private String ciudadPopular;
    private String[] ingredientes;
    private String[] alergenos;
    private double precio;
    private boolean caliente;
    private LocalDate fecha;

    public Bocadillo(int id, String nombre, String descrip, String ciudadPopular, LocalDate fecha, String[] ingredientes, String[] alergenos, double precio, boolean caliente) {
        this.id = id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.ciudadPopular = ciudadPopular;
        this.fecha = fecha;
        this.ingredientes = ingredientes;
        this.alergenos = alergenos;
        this.precio = precio;
        this.caliente = caliente;
    }


    public static void listarBocadillos(Bocadillo[] lista) {

    }

    public static void verCuriosidades(Bocadillo[] bocadillos) {

    }

    public String mostrarIngredientes() {
        return "";

    }

    public String mostrarAlergenos() {
        return "";

    }

    public static Bocadillo[] agregarBocadillo(Bocadillo[] lista, Bocadillo bocadillo) {
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }


    public String[] getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(String[] alergenos) {
        this.alergenos = alergenos;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCiudadPopular() {
        return ciudadPopular;
    }

    public void setCiudadPopular(String ciudadPopular) {
        this.ciudadPopular = ciudadPopular;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isCaliente() {
        return caliente;
    }

    public void setCaliente(boolean caliente) {
        this.caliente = caliente;
    }

    public boolean esCaliente() {
        return false;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String mostrarCuriosidades() {
        return "ID: " + id + "\nNombre: " + nombre + "\nDescripción: " + descrip + "\nCiudad Popular: " + ciudadPopular + "\nPrecio: " + precio + "€\nTipo: " + (caliente ? "Caliente" : "Frío");
    }

    public void mostrarInfoBocadillo(){
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripcion: " + descrip);
        System.out.println("Ciduad Popular : " + ciudadPopular);
        System.out.println("Ingredientes: " + ingredientes);
        System.out.println("Alergenos: " + alergenos);
        System.out.println("Precio: " + precio);
        System.out.println("Caliente: " + esCaliente());

    }
}

