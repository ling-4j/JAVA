package myio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFile {

	/**
	 * Ghi danh sách đối tượng vào file nhị phân
	 *
	 * @param filename tên của file cần ghi dữ liệu
	 * @param objects  danh sách đối tượng cần ghi vào file
	 * @throws IOException nếu có lỗi khi ghi vào file
	 */
	public static void binaryOutputFile(String filename, List<?> objects) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			for (Object obj : objects) {
				oos.writeObject(obj);
			}
		}
	}

	/**
	 * Đọc dữ liệu từ file nhị phân và trả về danh sách đối tượng
	 *
	 * @param filename tên của file cần đọc dữ liệu
	 * @return danh sách đối tượng được đọc từ file
	 * @throws IOException            nếu có lỗi khi đọc từ file
	 * @throws ClassNotFoundException nếu lớp của đối tượng đọc không được tìm thấy
	 */
	public static List<?> binaryInputFile(String filename) throws IOException, ClassNotFoundException {
		List<Object> objects = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object obj;
			while ((obj = ois.readObject()) != null) {
				objects.add(obj);
			}
		} catch (EOFException e) {
			// Do nothing, reached end of file
		}
		return objects;
	}

}
