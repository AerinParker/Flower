import java.io.*;

public class Driver implements FlowerInterface {
    public static void main(String [] args) {
        Flower flower1 = new Flower("rose", "red");
        Serializer.serializeToCSV(flower1, "flowers.txt");
    }

    @Override
    public void setFlowerName() {

    }

    @Override
    public void setFlowerColor() {

    }
}
