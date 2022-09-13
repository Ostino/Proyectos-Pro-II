package nur.p3.imagenes.vista;

import nur.p3.imagenes.modelo.*;


import nur.p3.logs.TestLogs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelImagen extends JPanel

        implements PropertyChangeListener, MouseListener, MouseMotionListener {
    private static final Logger logger = LogManager.getLogger(TestLogs.class);

    private Escena modelo;

    public PanelImagen(Escena escena) {
        modelo = escena;
        modelo.addListener(this);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(modelo.getImagen().getAncho(),
                modelo.getImagen().getAlto());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo == null)
            return;

        modelo.dibujar(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        modelo.seleccionarObjeto(e.getX(), e.getY());
        modelo.seleccionarObjetoCirculo(e.getX(),e.getY());
        modelo.seleccionarObjetoLinea(e.getX(),e.getY());
        logger.debug("Figura seleccionada");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        modelo.soltarObjeto();
        modelo.soltarCirculo();
        modelo.soltarLinea();
        logger.debug("Se solto la figura");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Cuadrado m = modelo.getObjetoSeleccionado();

        Circulo c = modelo.getObjetoCirculo();

        Linea l = modelo.getObjetoLinea();

        if (m != null) {
            m.moverA(e.getX(), e.getY());
            logger.debug("Tamaño cuadrado : "+m.getTamano()+"    X : "+m.getX()+"   Y : "+m.getY());
        }
        if (  c != null){
            c.moverA(e.getX(),e.getY());
            logger.debug("Tamaño circulo : "+c.getTamanoC()+"    X : "+c.getX()+"   Y : "+c.getY());
        }
        if (l !=null){
            l.moverA(e.getX(),e.getY());
            logger.debug("Tamaño linea : "+l.getTamano()+"        X : "+l.getX()+"   Y : "+l.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
