package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import LibreriaV2.Archivos;


public class ManagerFile {
	Archivos f = new Archivos("");
	

	public void openFile() {

		f.getFileChooser(new JFrame("ventana"), "txt");
		try {
			System.out.println(f.readerFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Archivos filesave = new Archivos("src/sources");
		filesave.create(0);
		filesave.setFile(new File(filesave.getFile().getAbsolutePath(), f.getFile().getName()));
		try {
			filesave.writerFile(f.readerFile(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listFile() {
		File directory = new File("src/sources");
		if (directory.exists() && directory.isDirectory()) {
			File[] files = directory.listFiles();
			if (files != null && files.length > 0) {
				System.out.println("Archivos almacenados:");
				int count = 1;
				for (File file : files) {
					if (file.isFile()) {
						System.out.println(count + "- " + file.getName());
						count++;
					}
				}
			} else {
				System.out.println("El directoriovacío.");
			}
		} else {
			System.out.println("El directorio no existe o no es válido");
		}
	}

	private File[] getStoredFiles() {
		File directory = new File("src/sources");
		if (directory.exists() && directory.isDirectory()) {
			File[] files = directory.listFiles();
			return files;
		} else {
			System.out.println("El directorio no existe o no es válido");
			return null;
		}
	}

	public void editFile(int a){
		Scanner leer=new Scanner(System.in);
		File[] files = getStoredFiles();
		if (files != null && a >= 1 && a <= files.length) {
			File selectedFile = files[a - 1];
			System.out.println("\nArchivo: " + selectedFile.getName());
			System.out.println("\nIngrese el texto: ");
			String line = leer.nextLine();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile, true))) {
				writer.write(line);
				writer.newLine();
				System.out.println("El texto fue agregado con exito");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error al escribir");
			}
		} else {
			System.out.println("El archivo seleccionado no existe");
		}

	}

	public  void getInfo() {
		String regex = "\\b[a-zA-Z0-9]+\\b";
		Pattern pattern = Pattern.compile(regex);
		File[] files = getStoredFiles();
		if (files != null) {
			for (File file : files) {
				String content;
				try {
					content = new String(Files.readAllBytes(Paths.get(file.getPath())));
				} catch (IOException e) {
					System.out.println("Error al leer archivo: " + file.getName());
					continue;
				}
				Matcher matcher = pattern.matcher(content);
				System.out.println("Patron del archivo " + file.getName() + ":");
				while (matcher.find()) {
					System.out.println(matcher.group());
				}
			}
		} else {
			System.out.println("No existen archivos en el directorio!");
		}
	}

}