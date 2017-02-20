
public class Driver {

    private final int number;

    public Driver(int number) {
        this.number = number + 1;
    }

    @Override
    public String toString() {
        return "Driver " + number;
    }
}
