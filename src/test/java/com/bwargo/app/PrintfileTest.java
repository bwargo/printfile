package com.bwargo.app;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.FileReader;
import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;
import java.io.IOException;

/**
 * Unit test for Printfile
 *
 * TODO: Write more tests!!
 */
public class PrintfileTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void checkPrintfileNotNull()
    {	
		Printfile printfile = new Printfile();
        assertNotNull(printfile);
    }

    /**
	 * Tests reformatFile().
	 */
    @Test
	public void printFormattedfileWithArgumentsSuccess() throws Exception
    {

        Printfile.reformatFile("src/test/resources/test.txt",50);

        List<String> lines = null;
        try {
            lines = FileUtils.readLines(new File("newFile.txt"));
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }

        assertNotNull(lines);

        for(String line :lines){
                assertThat(line.length(), lessThanOrEqualTo(50));
            }

    }

}
