import java.util.concurrent.Semaphore;

public class IceCreamShop {

    private Semaphore shopSem;
    public ClockTime ct;

    public IceCreamShop(ClockTime ct){

        shopSem = new Semaphore(5, true);
        this.ct = ct;

    }

    public Semaphore getShopSem() {
        return shopSem;
    }

    // Customer enters the shop - Sets the customers seat/leave timings and sets the clocks last customer time
    // Holds the thread until the clock gets to the customers leave time, note this could be done better I think
    // perhaps with a semaphore? But I did this question wrong and had to re-do it and spend to long on it.
    // Sets the customer as finished and releases the shop Semaphore
    public void enterShop(Customer c) {
        try {

            c.setSeatTime(ct.getClockTime());

            c.setLeaveTime(ct.getClockTime() + c.getEatingTime());
            ct.setLastCustomerLeftTime(c.getLeaveTime());

            while(ct.getClockTime() < c.getLeaveTime()) {
                Thread.sleep(1);
            }

            c.setFinished(true);

            //ct.setCustomerBeenThrough();

            ct.customerLeft();

            shopSem.release();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
