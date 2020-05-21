package ceit.aut.ac.ir.utils;

import ceit.aut.ac.ir.model.Note;

import java.io.*;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(File file) {
        //TODO: Phase1: read content from file
        String output = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = bufferedReader.readLine()) != null)
                output = output.concat(line);
        }catch(IOException ex){
            ex.printStackTrace();
            System.err.println("Couldn't open file!");
        }
        return output;
    }

    public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = NOTES_PATH + getProperFileName(content);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
            bufferedWriter.write(content);
        }catch(IOException ex){
            ex.printStackTrace();
            System.err.println("Couldn't open file!");
        }

    }

    //TODO: Phase1: define method here for reading file with InputStream
    public static String fileInputStreamReader(File file){
        String output = "";
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            int i;
            while((i = fileInputStream.read()) != -1)
                output = output.concat("" + (char)i);
        }catch(IOException ex){
            ex.printStackTrace();
            System.err.println("Couldn't open file!");
        }
        return output;
    }

    //TODO: Phase1: define method here for writing file with OutputStream
    public static void fileOutputStreamWriter(String content){
        String fileName = NOTES_PATH + getProperFileName(content);
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            byte[] text = content.getBytes();
            fileOutputStream.write(text);
        }catch(IOException ex){
            ex.printStackTrace();
            System.err.println("Couldn't open file!");
        }
    }

    //TODO: Phase2: proper methods for handling serialization
    public static void serializeData(Note note){
        String fileName = NOTES_PATH + getProperFileName(note.getContent()) + ".note";
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(note);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Couldn't open file!");
        }
    }

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }

    public static Note deserializeData(File file) {
        Note result = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            result = (Note)objectInputStream.readObject();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Couldn't open file!");
        }
        return result;
    }
}
