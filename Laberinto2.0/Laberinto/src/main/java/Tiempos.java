/*public class Tiempos implements Runnable{
    Camino camino=new Camino();
    private int tempo;
    public Tiempos (int cantidad){
        this.tempo=cantidad;

    }
    @Override
    public void run() {
        while (true) {
            if (camino.Victoria ==false) {
                try {
                    Thread.sleep(1000);
                    tempo--;
                    if (tempo >= 0) {
                        camino.tiempo.setText(String.valueOf(tempo));
                    }
                    camino.acabar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setTempo (int cantidad){
        tempo=cantidad;
    }
    public int getTempo(){
        return tempo;
    }
}
*/