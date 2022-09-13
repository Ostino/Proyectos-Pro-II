package nur.p3.imagenes.modelo;

import nur.p3.imagenes.serviicios.IDibujable;
import nur.p3.imagenes.vista.PanelImagen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Escena implements IDibujable {
    private Imagen imagen;
    private ArrayList<Cuadrado> objetosCuadrado;
    private ArrayList<Circulo> objetosCirculo;
    private ArrayList<Linea> objetosLinea;
private PropertyChangeSupport observado;

    public Escena() {
        imagen = new Imagen(400,400);
        objetosCirculo = new ArrayList<>();
        objetosCuadrado = new ArrayList<>();
        objetosLinea = new ArrayList<>();
        observado = new PropertyChangeSupport(this);
    }

    @Override
    public void dibujar(Graphics g) {

        if (imagen != null) {
            BufferedImage rsm = new BufferedImage(
                    imagen.getAncho(), imagen.getAlto(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = rsm.createGraphics();

            imagen.dibujar(g2d);
            g.drawImage(rsm, 0, 0, null);
        }
        for (Circulo c : objetosCirculo) {
            c.dibujar(g);
        }
        for (Cuadrado c : objetosCuadrado) {
            c.dibujar(g);
        }
        for (Linea c : objetosLinea){
            c.dibujar(g);
        }

    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public void addCuadrado(Cuadrado c) {
        objetosCuadrado.add(c);
        observado.firePropertyChange("ESCENA", true, false);
    }
    public void addCirculo(Circulo c) {
        objetosCirculo.add(c);
        observado.firePropertyChange("ESCENA", true, false);
    }
    public void addLinea(Linea c) {
        objetosLinea.add(c);
        observado.firePropertyChange("ESCENA", true, false);
    }
    public void addListener(PanelImagen panelImagen) {
        observado.addPropertyChangeListener(panelImagen);
        this.imagen.addListener(panelImagen);
        for (Cuadrado c: objetosCuadrado) {
            c.addListener(panelImagen);
        } for (Circulo c2: objetosCirculo) {
            c2.addListener(panelImagen);
        }
        for (Linea c3: objetosLinea) {
            c3.addListener(panelImagen);
        }
    }

    public Cuadrado getObjetoSeleccionado() {
        for (Cuadrado c:
             objetosCuadrado) {
            if (c.isSeleccionado()) return c;
        }
        return null;
    }
    public Circulo getObjetoCirculo() {
        for (Circulo c: objetosCirculo) {
            if (c.isSeleccionadoC()) return c;
        }
        return null;
    }
    public Linea getObjetoLinea() {
        for (Linea c: objetosLinea) {
            if (c.isSeleccionadoL()) return c;
        }
        return null;
    }

    public void soltarObjeto() {
        for (Cuadrado c :
                objetosCuadrado) {
            c.setSeleccionado(false);
        }
    }
    public void soltarCirculo() {
        for (Circulo c: objetosCirculo) {
            c.setSeleccionadoC(false);
        }
    }
    public void soltarLinea() {
        for (Linea c: objetosLinea) {
            c.setSeleccionadoL(false);
        }
    }

    public void seleccionarObjeto(int x, int y) {
        for (Cuadrado c:
             objetosCuadrado) {
            if (x > c.getX() && x < (c.getX() + c.getTamano()) &&
                    y > c.getY() && y < (c.getY() + c.getTamano())) {
                c.setSeleccionado(true);
            }
        }
    }
    public void seleccionarObjetoCirculo(int x, int y) {
        for (Circulo c:
                objetosCirculo) {
            if (x > c.getX() && x < (c.getX() + c.getTamanoC()) &&
                    y > c.getY() && y < (c.getY() + c.getTamanoC())) {
                c.setSeleccionadoC(true);
            }
        }
    }
    public void seleccionarObjetoLinea(int x, int y) {
        for (Linea c:
                objetosLinea) {
            if (x > c.getX() && x < (c.getX() + c.getTamano()) &&
                    y > c.getY() && y < (c.getY() + c.getTamano())) {
                c.setSeleccionadoL(true);
            }
        }
    }
}
