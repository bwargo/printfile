package com.bwargo.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.apache.commons.lang3.text.WordUtils;

/**
* A Java program that accepts a text file as input. create a new file with the following requirements:
* - Each line in the file should not have more than 50 characters
* - Each line should be word wrapped (i.e. there should be no half words on a line)
* - A word is delimited by 1 or more spaces or a linefeed.
* - The paragraphs of the original file should be left intact.
* 
* @author wargo.brandon@gmail.com
*
*/
class Printfile {

       /**
		* Prints out a String at a maximum of 50 characters wide to the Console.
		* TODO: create separate class for this to unit test
		* 
		* @param build <tt> StringBuilder </tt> the string you want to print out
		* @param length - the max length of the line in the file
		* 
		*/
        public static void printToConsole(StringBuilder build, int length) {
            System.out.println(WordUtils.wrap(build.toString(), length));
        }


        /**
         * Reads a local file into a StringBuilder
         * TODO: create separate class for this to unit test
         *
         * @param fileName <tt> String </tt> the fileName including path you want to read in
         * @param length int - new line length in characters
         */
        public static void reformatFile(String fileName, int length) throws IOException{

            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String line;

            File file = new File("newFile.txt");
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileoutputstream));

            try {
                while ((line = input.readLine()) != null) {
                    bufferedWriter.write(WordUtils.wrap(line,length));
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();

            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            } finally {
                input.close();
                fileoutputstream.close();
            }
        }

        public static void main(String args[]) throws Exception{
            if (args.length != 2) {
                System.out.println("Please enter filename including location followed by a space then number of lines you want the file to be.  Exiting program...");
            } else {
                reformatFile(args[0],Integer.valueOf(args[1]));
            }
    }
}