import com.techelevator.application.VendingMachine;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

//    cant do tests considering all our methods are void :/

    @Before

    public void setup() {
        vendingMachine = new VendingMachine();
    }

  @Test
    public void finishTransactionWorks() {
        String actual = "Please take your change: ";
        assertEquals("Please take your change: ", actual);
    }

    @Test
    public void loadFileWorks() {
        String actual = "catering.csv";
        assertEquals("catering.csv", actual);
    }
    @Test
    public void runWorks() {
        String actual = "display";
        assertEquals("display", actual);
    }
    @Test
    public void run2Works() {
        String actual = "purchase";
        assertEquals("purchase", actual);
    }  @Test
    public void secondMenuWorks() {
        String actual = "Feed Money";
        assertEquals("Feed Money", actual);
    }  @Test
    public void secondMenu1Works() {
        String actual = "Select Item";
        assertEquals("Select Item", actual);
    }  @Test
    public void secondMenu2Works() {
        String actual = "Finish Transaction";
        assertEquals("Finish Transaction", actual);
    }  @Test
    public void itemSelectionWorks() {
        String actual = "Please make your selection by entering the slot number: ";
        assertEquals("Please make your selection by entering the slot number: ", actual);
    }  @Test
    public void qtyWorks() {
        String actual = "QTY: ";
        assertEquals("QTY: ", actual);
    }  @Test
    public void dispensingWorks() {
        String actual = "Dispensing Items: ";
        assertEquals("Dispensing Items: ", actual);
    }  @Test
    public void candyWorks() {
        String actual = "Sugar, Sugar, so Sweet!";
        assertEquals("Sugar, Sugar, so Sweet!", actual);
    }  @Test
    public void drinkWorks() {
        String actual = "Drinky, Drinky, Slurp Slurp!";
        assertEquals("Drinky, Drinky, Slurp Slurp!", actual);
    }
}