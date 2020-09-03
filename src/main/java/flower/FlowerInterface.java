package flower;

import com.thoughtworks.xstream.XStream;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FlowerInterface {
    static String toString(flower.Flower myFlower) {
        String flowerString = myFlower.getFlowerName() + ", " + myFlower.getFlowerColor();
        return flowerString;
    }

    void setFlowerName(String flowerName);

    void setFlowerColor(String flowerColor);

    String getFlowerName();

    String getFlowerColor();

    static Flower deserializeFromCSV(String filename) throws IOException {
        Path path = Paths.get(filename);

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();

        String [] contents = line.split(", ");
        Flower flower1 = new Flower(contents[0], contents[1]);
        return flower1;
    }

    static void serializeToCSV(Flower myFlower, String filename) {
        String flowerDetails = Flower.toString(myFlower);
        File file = new File(filename);
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8 ))) {
            writer.write(flowerDetails);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void binarySerialization(flower.Flower myFlower, String filename) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream objectOut = new ObjectOutputStream (fileOut);
        objectOut.writeObject (myFlower);
        fileOut.close();
        objectOut.close();
    }

    static Flower binaryDeserialization(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Flower flower1 = (Flower) objectIn.readObject();
        fileIn.close();
        objectIn.close();
        return flower1;
    }

    static void serializeToXML(flower.Flower myFlower, String filename) throws IOException {
        FileOutputStream objectOut = new FileOutputStream(filename);
        XMLEncoder encoder = new XMLEncoder(objectOut);
        encoder.writeObject(myFlower);
        encoder.close();
        objectOut.close();
    }

    static Flower deserializeFromXML(String filename) throws IOException {
        FileInputStream objectIn = new FileInputStream(filename);
        XMLDecoder decoder = new XMLDecoder(objectIn);
        Flower flower1 = (Flower) decoder.readObject();
        decoder.close();
        objectIn.close();
        return flower1;
    }

    static void xStreamSerialization(flower.Flower myFlower, String filename) throws IOException {
        XStream xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        Class [] classes = new Class [] { Flower.class };
        xStream.allowTypes(classes);
        FileOutputStream out = new FileOutputStream(filename);
        xStream.toXML(myFlower, out);
    }

    static Flower xStreamDeserialization(String filename) {
        XStream xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        Class [] classes = new Class [] { Flower.class };
        xStream.allowTypes(classes);
        File file = new File(filename);
        Flower flower1 = (Flower) xStream.fromXML(file);
        return flower1;
    }
}