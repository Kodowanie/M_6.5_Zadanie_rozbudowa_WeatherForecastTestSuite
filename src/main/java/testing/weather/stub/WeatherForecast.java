package testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String,Double> calculateForecast(){

        Map <String, Double> resultMap = new HashMap<>();

        for(Map.Entry<String,Double> temperature : temperatures.getTemperatures().entrySet()){
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(),temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public Double calculateAverageForecast(){
        double sum = 0;
        double average = 0;
        Map <String, Double > resultMap = new HashMap<>();
        for(Map.Entry<String,Double> temperature : temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(),temperature.getValue());
            sum += temperature.getValue();
            average = sum / resultMap.size();
        }
        return average;
    }

    public Double calculateMedianForecast(){
        double median = 0;
        Map <String, Double> resultMap = new HashMap<>();
        for(Map.Entry<String,Double> temperature : temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(),temperature.getValue());
            List <Double> mapTemperatures = new ArrayList<>(resultMap.values());
            Collections.sort(mapTemperatures);
            if (mapTemperatures.size() % 2 == 0){
                median = ((double) mapTemperatures.get(mapTemperatures.size()/2)
                        + (double) mapTemperatures.get(mapTemperatures.size()/2-1))/2;
            }else{
                median = (double) mapTemperatures.get(mapTemperatures.size() / 2);
            }
        }
        return median;
    }
}
