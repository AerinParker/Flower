import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class FlowerTest {

    @Test
    public void testCSV() throws IOException {
        Flower flower1 = new Flower("rose", "red");
        Flower.serializeToCSV(flower1, "flowers.csv");
        Flower deserialized = Flower.deserializeFromCSV("flowers.csv");

        assertEquals(flower1, deserialized);

    }

    @Test
    public void testBinary() throws IOException, ClassNotFoundException {
        Flower flower1 = new Flower("tulip", "yellow");
        Flower.binarySerialization(flower1, "flowers.ser");
        Flower deserialized = Flower.binaryDeserialization("flowers.ser");

        assertEquals(flower1, deserialized);

    }

    @Test
    public void testXML() throws IOException {
        Flower flower1 = new Flower("pansy", "purple");
        Flower.serializeToXML(flower1, "flowers.xml");
        Flower deserialized = Flower.deserializeFromXML("flowers.xml");

        assertEquals(flower1, deserialized);
    }

}
