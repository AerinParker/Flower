import java.io.*;
import static org.junit.Assert.assertEquals;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


public class Driver implements FlowerInterface {
    public static void main(String [] args) throws IOException {
        Flower flower1 = new Flower("rose", "red");
        Serializer.serializeToCSV(flower1, "flowers.txt");
        String expectedValue = Flower.getFlowerDetails(flower1).toString();
        String deserialized = Deserializer.deserializeFromCSV("flowers.txt");
        System.out.println(deserialized);

        assertEquals(expectedValue, deserialized);

        Result result = JUnitCore.runClasses(Driver.class);
        System.out.println(result.wasSuccessful());
    }

    @Override
    public void setFlowerName() {

    }

    @Override
    public void setFlowerColor() {

    }
}
