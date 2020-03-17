import flower.Flower;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class FlowerTest {

    @Test
    public void testCSV() throws IOException {
        Flower flower1 = new Flower();
        flower1.setFlowerName("rose");
        flower1.setFlowerColor("red");
        Flower.serializeToCSV(flower1, "flowers.csv");
        Flower flower2 = Flower.deserializeFromCSV("flowers.csv");

        assertEquals(flower1, flower2);

    }

    @Test
    public void testBinary() throws IOException, ClassNotFoundException {
        Flower flower1 = new Flower();
        flower1.setFlowerName("tulip");
        flower1.setFlowerColor("pink");
        Flower.binarySerialization(flower1, "flowers.ser");
        Flower flower2 = Flower.binaryDeserialization("flowers.ser");

        assertEquals(flower1, flower2);

    }

    @Test
    public void testXML() throws IOException {
        Flower flower1 = new Flower();
        flower1.setFlowerName("pansy");
        flower1.setFlowerColor("purple");
        Flower.serializeToXML(flower1, "flowers.xml");
        Flower flower2 = Flower.deserializeFromXML("flowers.xml");

        assertEquals(flower1, flower2);
    }

    @Test
    public void testXStream() throws IOException {
        Flower flower1 = new Flower();
        flower1.setFlowerName("daffodil");
        flower1.setFlowerColor("yellow");
        Flower.xStreamSerialization(flower1, "flowers2.xml");
        Flower flower2 = Flower.xStreamDeserialization("flowers2.xml");

        assertEquals(flower1, flower2);
    }

}
