package nur.p3.imagenes.modelo;

import nur.p3.imagenes.serviicios.IDibujable;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class Circulo implements IDibujable{
    private int x;
    private int y;
    private int tamano;
    private PropertyChangeSupport observado;
    private boolean seleccionado;

    public Circulo(int m, int n, int t){
        x = m;
        y = n;
        tamano = t;
        observado = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    @Override
    public void dibujar(Graphics g) {
        g.fillOval(x,y,tamano,tamano);
        g.setColor(Color.WHITE);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTamanoC() {
        return tamano;
    }

    public void setTamanoC(int tamano) {
        this.tamano = tamano;
    }

    public boolean isSeleccionadoC() {
        return seleccionado;
    }

    public void setSeleccionadoC(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void moverA(int x, int y) {
        this.x = x;
        this.y = y;
        observado.firePropertyChange("CIRCULO", false, true);
    }
}
