import javax.swing.*;

public class Main {
    static HiloReloj hr;
    public static void main(String[] args) {
        hr=new HiloReloj();
        hr.start();
        VentanaPrincipal vp=new VentanaPrincipal(hr.getReloj());
        hr.getReloj().addObserver(vp);
        vp.setTitle("Reloj: Sistema Operativo 2020");
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vp.pack();
        vp.setVisible(true);
    }
}
