package hw8;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import hw7.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class TestDataProvider {

    private static final String dataPath = TestDataProvider.class.getClassLoader().getResource("data").getPath();

    @DataProvider(name = "testDataProvider")
    public static Object[] testDataProvider() throws FileNotFoundException {

        FileReader file = new FileReader(dataPath + "/MetalsColorsDataSet.json");
        JsonElement jsonData = new JsonParser().parse(file);
        Map<String, MetalsAndColorsData> dataMap = new Gson()
                .fromJson(jsonData, new TypeToken<Map<String, MetalsAndColorsData>>(){}.getType());

//        Object[][] data = new Object[dataMap.size()][1];
//        int count = 0;
//        for (String dataKey : dataMap.keySet()) {
//            data[count][0] = dataMap.get(dataKey);
//            count++;
//        }
//        return data;
        return dataMap.values().toArray();
    }
}
