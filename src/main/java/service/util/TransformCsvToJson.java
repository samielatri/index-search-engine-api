package service.util;

import java.io.*;
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
        // debug info
        System.out.println("service.util.TransformCsvToJson : main call");
        // Csv file's path to test
        String testPath = "samples/test.csv";
        // readCsvUsingScanner test
        readCsvUsingScanner(testPath);
        // readCsvUsingBufferReader test
        readCsvUsingBufferedReader(testPath);
    } // main end

    /**
     * readCsvUsingScanner :
     *  static method to read csv file using Scanner.
     *  returns number of lines redden from file, -1 if error.
     * @param filePath : String that represents file path of the csv file.
     */
    private static long readCsvUsingScanner(String filePath) {
        // debug info
        System.out.println("service.util.TransformCsvToJson : readCsvUsingScanner call");

        // file
        File file = new File(filePath);

        // number of lines redden
        long reddenLinesNumber = 0;

        try {
            // use Scanner InputStream to open file
            Scanner scanner = new Scanner(file);

            // read file using Scanner InputStream
            while (scanner.hasNext()) {
                // TODO : option to neglect header if needed
                System.out.println("User data : " + scanner.next());
                ++ reddenLinesNumber;
            }

            // close file using Scanner InputStream
            scanner.close();
        } catch (FileNotFoundException exception) {
            // debug info
            exception.printStackTrace();

            System.out.println("/!\\ Error while reading file /!\\");
        } finally {
            // custom message to inform user about the error
            String outputMessage = "";

            // file does not exist
            if(!file.exists()) {
                outputMessage += "\tThe file does not exist.";
                outputMessage += "\n\tPlease verify that the path of the file and that it exists :";
                File currentDirectory = new File(".");
                outputMessage += "\n\tCurrent directory : " + currentDirectory.getAbsolutePath();
                outputMessage += "\n\tThe given path is '" + filePath + "'";
            } // if-end block end

            // file is a directory
            if(file.isDirectory()){
                outputMessage += "\tThe file is a directory.";
            } // if-end block end

            // file cannot be read
            if(!file.canRead()){
                outputMessage += "\tThe file cannot be read.";
                outputMessage += "\tPlease verify that the read rights and that the file is not open by another program.";
            } // if-end block end

            // generic redden successfully or not file message and reddenLinesNumber update
            if (outputMessage.length() == 0) { // file was read successfully
                outputMessage += "File was read successfully";
                outputMessage += reddenLinesNumber + " lines were readen";
            } else { // file was not read successfully
                reddenLinesNumber = -1;
            } // if-else block end

            // output message to user
            System.out.println(outputMessage);
        } // try-catch-finally block end

        return reddenLinesNumber;
    } // readCsvUsingScanner end

    /**
     * readCsvUsingBufferedReader :
     *  static method to read csv file using BufferedReader.
     *  returns number of lines redden from file, -1 if error.
     * @param filePath : A String that represents file path of the csv file.
     */
    private static long readCsvUsingBufferedReader(String filePath) {
        // TODO: do the same logic for file verification as ScannerRead
        // TODO: do the long return logic as ScannerRead
        String reddenLine = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // reddenLine = reader.readLine()

            while ((reddenLine = reader.readLine()) != null) {
                System.out.println("User data : " + reddenLine);
            }
        } catch (IOException ioException) {
            // debug info
            ioException.printStackTrace();
            // placeholder
            System.out.println("Exception !");
        } finally {
            // placeholder
            System.out.println("it's not the end of the world :p");
        }
        /*
            catch (FileNotFoundException fileNotFoundException) { // FileReader constructor call
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) { // readLine constructor call
                ioException.printStackTrace();
            }
        */

        // placeholder return statement
        return 0;
    } // readCsvUsingBufferedReader end
} // TransformCsvToJson end
