import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana extends JFrame implements KeyListener {
    private Camino camino = new Camino();
    private JPanel jogo = new JPanel();
    private JTextField nombre = new JTextField();
    Font f = new Font("Helvetica", Font.PLAIN, 22);
    private JLabel Usuario = new JLabel("Jugador",SwingConstants.CENTER);
    private  JLabel puntuacion = new JLabel("Puntuacion",SwingConstants.CENTER);
    private JButton Guardar = new JButton("GUARDAR");
    private int x =70;
    private int highscore=0;
    private int y=70;

    JLabel xe = new JLabel();
    JLabel xa = new JLabel();
    Font fa = new Font("Helvetica", Font.BOLD, 16);

    public Ventana(){
    setTitle("Game");
    setSize(1500,700);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    initComponent();
     JOptionPane.showMessageDialog(null,"Dale a OK para empezar");
     Thread hilo = new Thread(camino);
     hilo.start();
    setVisible(true);

    }
    public void initComponent(){
    jogo.setLayout(null);
    jogo.setBounds(1000,0,450,700);
    jogo.setBackground(new Color(250, 243, 227));
    add(jogo);
    this.add(camino);


        Usuario.setFont(f);
        puntuacion.setFont(f);
        Usuario.setBounds(10,0,150,100);
        puntuacion.setBounds(310,0,150,100);
        jogo.add(Usuario);
        jogo.add(puntuacion);
        Guardar.setBounds(360,600,100,30);
        jogo.add(Guardar);
        nombre.setBounds(40,600,180,30);
        jogo.add(nombre);
        xa.setBounds(375,100,100,30);
        xa.setForeground(new Color(255, 159, 41));
        xa.setFont(fa);
        jogo.add(xa);
        xe.setBounds(70,70,100,30);
        xe.setForeground(new Color(255, 159, 41));
        xe.setFont(fa);
        jogo.add(xe);
        Guardar.addKeyListener( this);
        Guardar.addActionListener(e -> {
            if (camino.Victoria==true) {
                if (camino.getiempo()>highscore) {
                    xe.setText(nombre.getText());
                    xa.setText("" + camino.getiempo());
                    highscore= camino.getiempo();
                    repaint();
                } else{
                    JLabel nuevo = new JLabel("" + nombre.getText());//el nombre
                nuevo.setBounds(x, y + 20, 100, 30);
                JLabel nuevo2 = new JLabel("" + camino.getiempo());//tiempo
                nuevo2.setBounds(375, y + 20, 100, 30);
                y = y + 20;
                jogo.add(nuevo);
                jogo.add(nuevo2);
                repaint();
            }
            }
        });

    }

    public static void main(String[] args) {
        Ventana juego = new Ventana();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_F5){//REINICIO
            camino.Victoria= false;
            JOptionPane.showMessageDialog(null,"REINICIO");
            camino.tiempo1=51;
            camino.jugador.sumarvida();

        }
        if (e.getKeyCode()==KeyEvent.VK_F4){//PAUSA
            camino.Victoria=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
