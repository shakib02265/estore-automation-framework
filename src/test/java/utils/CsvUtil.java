package utils;

import java.io.File;
import java.io.FileWriter;

public class CsvUtil {

    private static int counter = 1;


    public static void create(

            String type,

            String testName,

            String url,

            String status,

            long executionTime

    ) throws Exception {



        File file =

                new File(
                        "csv/results.csv"
                );



        file.getParentFile()
                .mkdirs();



        boolean isNewFile =
                !file.exists();



        FileWriter writer =

                new FileWriter(
                        file,
                        true
                );



        if(isNewFile){

            writer.write(

                    "Test Number,"
                    + "Type,"
                    + "Test Name,"
                    + "URL,"
                    + "Execution Time,"
                    + "Result\n"
            );
        }



        writer.write(

                "TC-"

                        + String.format(
                                "%03d",
                                counter++
                        )

                        + ","

                        + type

                        + ","

                        + testName

                        + ","

                        + url

                        + ","

                        + executionTime
                        + " ms"

                        + ","

                        + status

                        + "\n"
        );



        writer.close();
    }
}