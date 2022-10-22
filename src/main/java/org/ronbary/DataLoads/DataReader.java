package org.ronbary.DataLoads;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {


    /*
    Read the json and return array of HashMap<String,String> with the json data
     */
    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        // convert json file content to json string
        String jsonContent = FileUtils.readFileToString(new File("reservationDetails.json"),
                StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
    }
}