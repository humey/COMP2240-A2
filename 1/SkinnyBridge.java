import java.util.concurrent.Semaphore;

public class SkinnyBridge {

    public Semaphore skinnyBridgeSem;
    public int neonSign = 0;

    public SkinnyBridge(){
        skinnyBridgeSem = new Semaphore(1,true);
    }

    public void bridgeCross() throws InterruptedException {

        skinnyBridgeSem.acquire();

    }

    public void bridgeCrossed(){

        skinnyBridgeSem.release();

    }

    public void incrementNeonSign() {
        this.neonSign++;
    }

    public int getNeonSign() {
        return neonSign;
    }
}
