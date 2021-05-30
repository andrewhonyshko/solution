package solution;

public class Cable implements USB{
    private Telephone telephone;

    public Cable(Telephone telephone) {
        this.telephone = telephone;
    }

    @Override
    public void connectWithUsbCable() {
        this.telephone.connect();
        this.telephone.charging();
        this.telephone.extracted();

    }
}
