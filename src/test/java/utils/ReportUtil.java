package utils;

import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;

public class ReportUtil {

    private static int counter = 1;

    private static int passed = 0;

    private static int failed = 0;

    private static boolean firstRun = true;

    private static List<String> rows =
            new ArrayList<>();


    public static void create(

            String type,

            String testName,

            String url,

            boolean isPassed,

            long executionTime

    ) throws Exception {



        // clear old report once


        if(firstRun){

            File oldReport =
                    new File(
                            "reports/index.html"
                    );

            if(oldReport.exists()){

                oldReport.delete();
            }

            firstRun = false;
        }



        if(isPassed){

            passed++;

        }else{

            failed++;
        }



        int total =
                passed + failed;



        int percentage =
                (passed * 100) / total;



        rows.add(

                "<tr>"

                + "<td>TC-"

                + String.format(
                        "%03d",
                        counter++
                )

                + "</td>"

                + "<td>"
                + type
                + "</td>"

                + "<td>"
                + testName
                + "</td>"

                + "<td>"
                + url
                + "</td>"

                + "<td>"
                + executionTime
                + " ms</td>"

                + "<td style='color:"
                + (isPassed
                        ? "green"
                        : "red")
                + "'>"

                + (isPassed
                        ? "PASS"
                        : "FAIL")

                + "</td>"

                + "</tr>"
        );



        String tableRows =
                String.join(
                        "",
                        rows
                );



        new File(
                "reports"
        ).mkdirs();



        FileWriter writer =
                new FileWriter(
                        "reports/index.html"
                );



        writer.write(


                "<html>"

                + "<head>"

                + "<title>Automation Report</title>"

                + "<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>"

                + "<style>"

                + "body{font-family:Arial;background:#f5f7fa;padding:20px;}"

                + ".cards{display:flex;gap:20px;margin-bottom:30px;}"

                + ".card{background:white;padding:20px;border-radius:10px;"
                + "box-shadow:0 2px 10px rgba(0,0,0,.1);width:200px;}"

                + ".charts{display:flex;gap:20px;}"

                + "canvas{width:250px!important;height:250px!important;}"

                + "table{width:100%;margin-top:30px;border-collapse:collapse;background:white;}"

                + "th,td{padding:12px;border:1px solid #ddd;}"

                + "th{background:#f1f1f1;}"

                + "</style>"

                + "</head>"



                + "<body>"

                + "<h1>Automation Report</h1>"



                // cards


                + "<div class='cards'>"

                + "<div class='card'><h3>Total</h3><h1>"
                + total
                + "</h1></div>"

                + "<div class='card'><h3>Passed</h3><h1>"
                + passed
                + "</h1></div>"

                + "<div class='card'><h3>Failed</h3><h1>"
                + failed
                + "</h1></div>"

                + "<div class='card'><h3>Pass %</h3><h1>"
                + percentage
                + "%</h1></div>"

                + "</div>"



                // graphs


                + "<div class='charts'>"

                + "<canvas id='pie'></canvas>"

                + "<canvas id='bar'></canvas>"

                + "<canvas id='doughnut'></canvas>"

                + "</div>"



                + "<script>"



                + "new Chart(document.getElementById('pie'),{"
                + "type:'pie',"
                + "data:{labels:['Pass','Fail'],"
                + "datasets:[{data:["
                + passed
                + ","
                + failed
                + "]}]}});"



                + "new Chart(document.getElementById('bar'),{"
                + "type:'bar',"
                + "data:{labels:['Pass','Fail'],"
                + "datasets:[{data:["
                + passed
                + ","
                + failed
                + "]}]}});"



                + "new Chart(document.getElementById('doughnut'),{"
                + "type:'doughnut',"
                + "data:{labels:['Pass','Fail'],"
                + "datasets:[{data:["
                + passed
                + ","
                + failed
                + "]}]}});"



                + "</script>"



                // table


                + "<table>"

                + "<tr>"

                + "<th>TC No</th>"

                + "<th>Type</th>"

                + "<th>Test Name</th>"

                + "<th>URL / Endpoint</th>"

                + "<th>Execution Time</th>"

                + "<th>Status</th>"

                + "</tr>"

                + tableRows

                + "</table>"



                + "</body>"

                + "</html>"
        );



        writer.close();
    }
}