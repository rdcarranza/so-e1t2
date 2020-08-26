import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class VentanaPrincipal extends JFrame implements Observer{
    private JPanel panelPrincipal;
    private JLabel etiquetaReloj;
    private JButton buttonReiniciar;
    private JButton btnModificar;
    private JButton btnCerrar;
    private JTextField textFieldHora;
    private JLabel lp1;
    private JTextField textFieldMinutos;
    private JLabel lp2;
    private JTextField textFieldSegundos;
    Reloj reloj;

    public VentanaPrincipal(Reloj r){
        reloj=r;
        add(panelPrincipal);
        this.setResizable(false);

        buttonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r.reiniciar();
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int h = Integer.parseInt(textFieldHora.getText());
                    int m = Integer.parseInt(textFieldMinutos.getText());
                    int s = Integer.parseInt(textFieldSegundos.getText());
                    if(h!=0 || m!=0 || s!=0){
                        if (h>0 && h<24){
                            reloj.setHora(h);
                        }
                        if (m>0 && m<60){
                            reloj.setMinutos(m);
                        }
                        if (s>0 && s<60){
                            reloj.setSegundos(s);
                        }
                    }
                    limpiarCampos();
                }catch (NumberFormatException e){
                    limpiarCampos();
                }
            }
        });
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    private void limpiarCampos(){
        this.textFieldHora.setText("00");
        this.textFieldMinutos.setText("00");
        this.textFieldSegundos.setText("00");
    }

    @Override
    public void update(Observable observable, Object o) {
        this.etiquetaReloj.setText((String)o);
    }
}
