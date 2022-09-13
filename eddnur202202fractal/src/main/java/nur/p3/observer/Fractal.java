package nur.p3.observer;

import nur.p3.logs.TestLogs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import  java.util.Random;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Fractal implements IDibujo {
    private static final Logger logger = LogManager.getLogger(TestLogs.class);
    public static final int VONKOCH = 1;
    public static final int SIERPINSKY = 2;
    Random random = new Random();
    protected int profundidad;
    protected String nombre;
    protected int tipo;
    private PropertyChangeSupport objeto;

    public Fractal(int tipo, int profundidad) {
        objeto = new PropertyChangeSupport(this);
        this.tipo = tipo;
        this.profundidad = profundidad;
        if (this.tipo == SIERPINSKY) {
            nombre = "Sierpinsky";
        }
        if (this.tipo == VONKOCH) {
            nombre = "Von Koch";
        }
    }

    public void addListener(PropertyChangeListener listener) {
        objeto.addPropertyChangeListener(listener);
    }

    public void cambio() {
        objeto.firePropertyChange("FRACTAL", false, true);
    }

    /**
     * @return Returns the profundidad.
     */
    public int getProfundidad() {
        return profundidad;
    }
    /**
     * @param profundidad The profundidad to set.
     */
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
    /**
     * @return Returns the nombre.
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void dibujar(Graphics g) {
        if(tipo == SIERPINSKY) {
            hacerSierpinsky(300, 200, 200, 200, this.profundidad, g);
        }
        if (tipo == VONKOCH) {
            hacerVonKoch(10, 150, 400, 150, this.profundidad, g);
        }
    }

    public void hacerSierpinsky(int x1, int y1, int ancho, int alto, int n, Graphics gc) {

        int pAncho = ancho ;
        int pAlto = alto ;
        int XX = x1 ;
        int YY = y1 ;

        if (n == 1) {
            gc.setColor(new Color(random.nextInt(255), 230, random.nextInt(255)));
            gc.drawRect(x1, y1, ancho, alto);
            gc.fillRect(x1, y1, ancho, alto);
        } else {
            hacerSierpinsky(XX, YY, pAncho, pAlto, n - 1, gc);
            logger.debug("Altura : " + pAlto + " Anchura : " + pAncho + " Cord X: " + XX + " Cord Y :" + YY + "  DESPUES cuadrado base");
            hacerSierpinsky(XX - (pAncho / 2), YY + (pAlto / 4), pAncho / 2, pAlto / 2, n - 1, gc);//Izq
            logger.debug("Altura : " + pAlto + " Anchura : " + pAncho + " Cord X: " + XX + " Cord Y :" + YY + "  DESPUES 1 CUBO");
            hacerSierpinsky(XX + (pAncho / 4), YY - (pAlto / 2), pAncho / 2, pAlto / 2, n - 1, gc); //Arriba
            logger.debug("Altura : " + pAlto + " Anchura : " + pAncho + " Cord X: " + XX + " Cord Y :" + YY + "  DESPUES 2 CUBO");
            hacerSierpinsky(XX + pAncho, YY + (pAlto / 4), pAncho / 2, pAlto / 2, n - 1, gc);//Derecha
            logger.debug("Altura : " + pAlto + " Anchura : " + pAncho + " Cord X: " + XX + " Cord Y :" + YY + "  DESPUES 3 CUBO");
            hacerSierpinsky(XX + (pAncho / 4), YY + pAlto, pAncho / 2, pAlto / 2, n - 1, gc);//Abajo
            logger.debug("Altura : " + pAlto + " Anchura : " + pAncho + " Cord X: " + XX + " Cord Y :" + YY + "  DESPUES 4 CUBO");
        }
    }
   public void hacerVonKoch(int x0, int y0, int x3, int y3, int n, Graphics gc) {
        if (n == 1) {
            gc.drawLine(x0, y0, x3, y3);
        } else {
            double angle = Math.atan2(y3 - y0, x3 - x0);

            double dx1 = (double) (x3 - x0) / 3.0;
            double dy1 = (double) (y3 - y0) / 3.0;
            double distance3 = Math.sqrt((y3 - y0) * (y3 - y0) + (x3 - x0)
                    * (x3 - x0)) / 3.0;
            int x1 = x0 + (int) dx1;
            int y1 = y0 + (int) dy1;
            int x2 = x0 + (int) (2.0 * dx1);
            int y2 = y0 + (int) (2.0 * dy1);

            int x4 = (int) (x1 + distance3 * Math.cos(angle - Math.PI / 3.0));
            int y4 = (int) (y1 + distance3 * Math.sin(angle - Math.PI / 3.0));

            hacerVonKoch(x0, y0, x1, y1, n - 1, gc);
            hacerVonKoch(x1, y1, x4, y4, n - 1, gc);
            hacerVonKoch(x4, y4, x2, y2, n - 1, gc);
            hacerVonKoch(x2, y2, x3, y3, n - 1, gc);
        }
    }
}
