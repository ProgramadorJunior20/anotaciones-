package co.jmurillo.anotacines.ejemplo;

import co.jmurillo.anotacines.ejemplo.models.Producto;
import co.jmurillo.anotacines.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;


public class EjemploAnotacion {
    public static void main(String[] args) {

        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("mesa centro ROBLE");
        p.setPrecio(1000L);


        System.out.println("json = " + JsonSerializador.convertirJson(p));

    }
}


