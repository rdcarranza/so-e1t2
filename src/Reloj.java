import java.util.Observable;

public class Reloj extends Observable {
    int hora;
    int minutos;
    int segundos;

    public Reloj(){
        hora=0;
        minutos=0;
        segundos=0;
    }

    public String getTiempo(){
        String s;
        if(segundos<10){
            s="0"+segundos;
        }else{
            s=Integer.toString(segundos);
        }

        String m;
        if(minutos<10){
            m="0"+minutos;
        }else {
            m = Integer.toString(minutos);
        }

        String h;
        if(hora<10){
            h="0"+hora;
        }else {
            h=Integer.toString(hora);
        }

        return h+":"+m+":"+s;

    }

    public void reiniciar(){
        this.hora=0;
        this.minutos=0;
        this.segundos=0;
        this.actualizarObs();

    }

    private void actualizarObs(){
        this.setChanged();
        this.notifyObservers(this.getTiempo());
        this.clearChanged();
    }

    public void transcurreSegundo(){
        if(segundos==59){
            transcurreMinuto();
            segundos=0;
        }else{
            segundos++;
        }
        this.actualizarObs();

    }

    private void transcurreMinuto(){
        if(minutos==59){
            transcurreHora();
            minutos=0;
        }else{
            minutos++;
        }

    }

    private void transcurreHora(){
        if(hora==23){
            hora=0;
        }else{
            hora++;
        }

    }

    public boolean setSegundos(int s){
        if(s<60 && s>=0){
            segundos=s;
            this.actualizarObs();
            return true;
        }else{
            return false;
        }


    }

    public boolean setMinutos(int m){
        if(m<60 && m>=0){
            minutos=m;
            this.actualizarObs();
            return true;
        }else {
            return false;
        }

    }

    public boolean setHora(int h){
        if(h<24 && h>=0){
            hora=h;
            this.actualizarObs();
            return true;
        }else{
            return false;
        }
    }

}//FIN CLASE
