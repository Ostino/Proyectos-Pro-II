import javax.swing.*;
import java.awt.*;

public class VentanaDatos extends JFrame  {
    private JTextField nombre = new JTextField();
    Font f = new Font("Helvetica", Font.PLAIN, 22);
    private JLabel Usuario = new JLabel("Jugador",SwingConstants.CENTER);
    private  JLabel puntuacion = new JLabel("Puntuacion",SwingConstants.CENTER);
    private JButton Guardar = new JButton("GUARDAR");
    private  int tiempo1=50;
    private Camino tempo = new Camino();
    int x = 10;
    int y = 120;
    public VentanaDatos(){
        setTitle("Puntuacion");
        setSize(600,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initcomponent();
        //Thread hilo =new Thread(this);
        //hilo.start();
        setVisible(true);
    }
    public void initcomponent (){
    setLayout(null);
    Usuario.setFont(f);
    puntuacion.setFont(f);
    Usuario.setBounds(10,0,150,100);
    puntuacion.setBounds(310,0,150,100);
    add(Usuario);
    add(puntuacion);
    Guardar.setBounds(360,600,100,30);
    add(Guardar);
    nombre.setBounds(40,600,180,30);
    add(nombre);
    Guardar.addActionListener(e -> {
        System.out.println(tempo.getiempo());
        JLabel nuevo = new JLabel(""+nombre.getText());
        nuevo.setBounds(x,y+20,100,30);
        JLabel nuevo2 = new JLabel(""+tempo.getiempo());//tiempo
        System.out.println(tiempo1);
        nuevo2.setBounds(300,y+20,100,30);
        y=y+20;
        add(nuevo);
        add(nuevo2);
        repaint();
    });
    }
    /*public void run() {
        while (true) {
            if (tempo.Victoria ==false) {
                try {
                    Thread.sleep(1000);
                    tiempo1--;
                    tempo.acabar();
                    Victoriatablero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void Victoriatablero (){
        if (tempo.getReset()){
            tiempo1=51;
        }
    }*/
}
