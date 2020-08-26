public class HiloReloj extends Thread{
    Reloj reloj;

    @Override
    public void run() {
        super.run();
        reloj= new Reloj();
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reloj.transcurreSegundo();
        }
    }

    public Reloj getReloj(){
        return reloj;
    }
}
