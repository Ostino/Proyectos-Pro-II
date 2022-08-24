import javax.swing.*;

public class Jugador {

    public int vidas;
    public Jugador (int vidas){
        this.vidas=vidas;
    }
    public void restarvida(){
        vidas--;
        if (vidas>0){
            JOptionPane.showMessageDialog(null,"Perdiste una vida te quedan : "+vidas);
        }
        if (vidas==0){
            JOptionPane.showMessageDialog(null,"PERDISTE");
        System.exit(0);
        vidas=3;
        }
    }
    public void sumarvida(){
        vidas=3;
    }
}
