package service.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created bu PacLab
 * User: sami
 * Date: 2/9/2021
 * Time: 3:02 PM
 * Package: service.util
 *
 * Class name: TransformCsvToJson
 * Class description: A TransformCsvToJson is a tool to transform Csv to Json.
 */
public class TransformCsvToJson {
    /**
     * main : main entry of TransformCsvToJson class to test member methods of the class.
     * @param args : an array of String meant to hold passed command line arguments.
     */
    public static void main(String [] args) {
        // System.out.println("service.util.TransformCsvToJson : main call");
        readCsvUsingScanner("samples/test.csv");
        // readCsvUsingBufferReader("samples/addresses");
    }

    /**
     * readCsvUsingScanner :
     *  static method to read csv file using Scanner.
     *  returns number of lines readen from file, -1 if error.
     * @param filePath : String that represents file path of the csv file.
     */
    private static long readCsvUsingScanner(String filePath) {
        // debug info
        System.out.println("service.util.TransformCsvToJson : readCsvUsingScanner call");

        // file
        File file = new File(filePath);

        // number of lines readen
        long readenLinesNumber = 0;

        try {
            // use Scanner InputStream to open file
            Scanner scanner = new Scanner(file);

            // read file using Scanner InputStream
            while (scanner.hasNext()) {
                // TODO : option to neglect header if needed
                System.out.println("User data : " + scanner.next());
                ++readenLinesNumber;
            }

            // close file using Scanner InputStream
            scanner.close();
        } catch (FileNotFoundException exception) {
            // debug info
            exception.printStackTrace();

            System.out.println("/!\\ Error while reading file /!\\");
        } finally {
            // custom message to inform user about the error
            String msg = "";

            // file does not exist
            if(!file.exists()) {
                msg += "\tThe file does not exist.";
                msg += "\n\tPlease verify that the path of the file and that it exists :";
                File currentDirectory = new File(".");
                msg += "\n\tCurrent directory : " + currentDirectory.getAbsolutePath();
                msg += "\n\tThe given path is '" + filePath + "'";
            }

            // file is a directory
            if(file.isDirectory()){
                msg += "\tThe file is a directory.";
            }

            // file cannot be read
            if(!file.canRead()){
                msg += "\tThe file cannot be read.";
                msg += "\tPlease verify that the read rights and that the file is not open by another program.";
            }

            // file was read successfully
            if (msg.length() == 0) {
                msg += "File was read successfully";
                msg += readenLinesNumber + " lines were readen";
            } else {
                readenLinesNumber = -1;
            }

            // output message to user
            System.out.println(msg);
        }

        return readenLinesNumber;
    }

    /**
     * readCsvUsingBufferReader : static method to read csv file using BufferReader.
     * @param filePath : A String that represents file path of the csv file.
     */
    private static void readCsvUsingBufferReader(String filePath) {
        // TODO : implement logic
    }
}

