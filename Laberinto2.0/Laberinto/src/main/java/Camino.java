import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Camino extends JPanel implements MouseListener,Runnable,KeyListener {
    private JLabel camino = new JLabel("", SwingConstants.CENTER);
    private JLabel camino2 = new JLabel("", SwingConstants.CENTER);
    private JLabel camino3 = new JLabel("", SwingConstants.CENTER);
    private JLabel camino4 = new JLabel("", SwingConstants.CENTER);
    private JLabel camino5 = new JLabel("", SwingConstants.CENTER);
    private JLabel camino6 = new JLabel("", SwingConstants.CENTER);
    private JLabel camino7 = new JLabel("", SwingConstants.CENTER);
    private JLabel camino8 = new JLabel("", SwingConstants.CENTER);
    private JLabel camino9 = new JLabel("", SwingConstants.CENTER);
    public int tiempo1 = 50;
    public JLabel tiempo = new JLabel(String.valueOf(tiempo1), SwingConstants.CENTER);

    private int cantidadtempo;
    public Jugador jugador = new Jugador(3);
    Font f = new Font("Helvetica", Font.PLAIN, 62);
    private JButton BtbVictoria = new JButton("Victoria");
    public boolean Victoria = false;

    private JButton egg= new JButton("ANASHE");

    public Camino() {
        this.setBackground(Color.black);
        setLayout(null);
        tiempo.setFont(f);
        egg.setBounds(40,670,100,24);
        add(egg);
        egg.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Que haces aca nashe no debeirias estar aqui, no me lo rompas el juego ctm");
        });
        tiempo.setBounds(380, 240, 200, 100);
        camino.setBounds(900, 0, 100, 600);
        camino2.setBounds(140, 550, 810, 50);
        camino3.setBounds(60, 80, 80, 520);
        camino4.setBounds(140, 80, 710, 40);
        camino5.setBounds(800, 120, 50, 330);
        camino6.setBounds(200, 450, 650, 40);
        camino7.setBounds(0, 0, 900, 40);
        camino8.setBounds(0, 0, 30, 800);
        camino9.setBounds(0, 620, 900, 50);
        camino.addMouseListener(this);
        camino2.addMouseListener(this);
        camino3.addMouseListener(this);
        camino4.addMouseListener(this);
        camino5.addMouseListener(this);
        camino6.addMouseListener(this);
        camino7.addMouseListener(this);
        camino8.addMouseListener(this);
        camino9.addMouseListener(this);
        add(tiempo);
        add(camino);
        add(camino2);
        add(camino3);
        add(camino4);
        add(camino5);
        add(camino6);
        add(camino7);
        add(camino8);
        add(camino9);
        BtbVictoria.setBounds(900, 620, 90, 41);
        add(BtbVictoria);
        BtbVictoria.addKeyListener(this);
        BtbVictoria.addActionListener(e -> {
            //JOptionPane.showMessageDialog(null, "GANASTE!!");
            Victoria = true;
            tiempo1++;
            cantidadtempo=tiempo1;
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(26, 77, 46));
        g.fillRect(900, 0, 100, 600);//Primer muro vertical
        g.fillRect(140, 550, 810, 50);//Segundo muro - horizontal
        g.fillRect(60, 80, 80, 520);//Tercer muro - vertical
        g.fillRect(140, 80, 710, 40);//Cuarto muro - horizontal
        g.fillRect(800, 120, 50, 330);//Quinto muro - vertical
        g.fillRect(200, 450, 650, 40);//Sexto muro - horizontal
        g.fillRect(0, 0, 900, 40);//pared superior
        g.fillRect(0, 0, 30, 800);//pared lateral izq
        g.fillRect(0, 620, 900, 50);//pared inferior
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if (Victoria == false) {
            jugador.restarvida();

        }
    }

    @Override
    public void run() {
        while (true) {
            if (Victoria ==false) {
                try {
                    Thread.sleep(1000);
                    tiempo1--;
                    if (tiempo1 >= 0) {
                        tiempo.setText(String.valueOf(tiempo1));
                    }
                    acabar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public int getiempo(){
        return tiempo1;
    }
    public void acabar() {
        if (tiempo1 == 0) {
            JOptionPane.showMessageDialog(null, "Se te acabo el tiempo");
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_F5){//REINICIO
            Victoria= false;
            JOptionPane.showMessageDialog(null,"REINICIO");
            tiempo1=51;
            jugador.sumarvida();

        }
        if (e.getKeyCode()==KeyEvent.VK_F4){//PAUSA
            Victoria=true;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
}

