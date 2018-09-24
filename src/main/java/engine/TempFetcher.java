package engine;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import tmpr.TemperatureResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class TempFetcher {

    private static String logPath;

    private static final String execCommand = "tdtool -l";
    //private static final String execCommand = "cat /home/anders/result.txt";

    private static final String[] cmd = {"/usr/bin/tdtool -l | grep mandolyn "};

    private static TempFetcher instance ;

    public static TempFetcher getInstance(){
        if (instance == null) {

            instance = new TempFetcher();
            java.util.logging.Logger.getLogger(TempFetcher.class.getName()).log(Level.INFO, "## TempFetcher initializes ##");

        }

        return instance;
    }



    public TemperatureResponse fetchCommand(){
        TemperatureResponse response = new TemperatureResponse();



        Process proc;
        String reply = null;

        try {

            String[] data = null;
            proc = Runtime.getRuntime().exec(execCommand);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proc.getInputStream()));
            while ((reply = br.readLine()) != null) {
                //System.out.println("line: " + reply);
                if (reply.contains("mandolyn")){
                    data = reply.split("\t");

                    if (data!= null ){
                        if (data.length==8){
                            response.setTemperatureAsString(data[3].toString().trim());
                            response.setHumidityAsString(data[4].toString().trim());
                            response.setTimePointAsString(data[7].toString().trim());
                        }
                    } else{
                        java.util.logging.Logger.getLogger(TempFetcher.class.getName()).log(Level.WARNING, "$$ TempFetcher did not get reply from command -> " + execCommand + " $$") ;
                    }

                    break;

                }

                //3, 4, 7
            }



            proc.waitFor();
            proc.destroy();

        } catch (IOException e) {
            e.printStackTrace();
            java.util.logging.Logger.getLogger(TempFetcher.class.getName()).log(Level.WARNING, e.getMessage(), e);

        } catch (InterruptedException e) {
            e.printStackTrace();
            java.util.logging.Logger.getLogger(TempFetcher.class.getName()).log(Level.WARNING, e.getMessage(), e);

        }

        java.util.logging.Logger.getLogger(TempFetcher.class.getName()).log(Level.INFO, "## TempFetcher returns data => " + reply + " ##" );

        return response;
    }
}
