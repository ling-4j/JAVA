package objects.HoNgocQuyen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ProductIO {
	public static void saveToFile(List<Painting> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TV.bin"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load tvList from a file
    public static void loadFromFile(List<Painting> list) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TV.bin"))) {
            list = (List<Painting>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File 'Painting.bin' not found. Creating a new file...");
            saveToFile(list); // Tạo một tệp mới
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
