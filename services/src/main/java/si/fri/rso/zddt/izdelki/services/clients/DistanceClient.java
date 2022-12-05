package si.fri.rso.zddt.izdelki.services.clients;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import si.fri.rso.zddt.common.models.Trgovina;
import si.fri.rso.zddt.izdelki.services.DTOs.TrgovinaDistanceDTO;
import si.fri.rso.zddt.izdelki.services.beans.TrgovinaBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.net.URI;


@Slf4j
@RequestScoped
public class DistanceClient {

    @Inject
    private TrgovinaBean trgovinaBean;

    public TrgovinaDistanceDTO vrniNajblizjo(double lat, double lng){

        //GET POSTAJE
        List<Trgovina> trgovine = trgovinaBean.vrniTrgovine();
        TrgovinaDistanceDTO trgovinaDistanceDTOS = new TrgovinaDistanceDTO();

        String params = "?start_point=("+lat+"%2C"+lng+")";

        for( int i = 0; i < trgovine.size(); i++){
            System.out.println(i);
            params+= "&end_point_"+(i+1)+"=("+ trgovine.get(i).getLatitude()+"%2C"+trgovine.get(i).getLongitude()+")";
        }

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://distance-calculator.p.rapidapi.com/v1/one_to_many"+params+"&decimal_places=2"))
                    .header("Content-Type", "application/json")
                    .header("X-RapidAPI-Key", "5079ab9f5cmshc1f4e94f23a69b4p1068f3jsne20867807d82")
                    .header("X-RapidAPI-Host", "distance-calculator.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


            JsonObject json = new Gson().fromJson(response.body(), JsonObject.class);
            json.remove("start_point");
            json.remove("unit");

            int index_min = 0;
            double min_distance = 9999;
            int i = 0;
            for ( var a : json.entrySet()){
                double curr_distance = a.getValue().getAsJsonObject().get("distance").getAsDouble();
                if(curr_distance < min_distance){
                    index_min = i;
                    min_distance = curr_distance;
                }
                i ++;
            }
            trgovinaDistanceDTOS.setTrgovina(trgovine.get(index_min));
            trgovinaDistanceDTOS.setDistance(min_distance);
            return trgovinaDistanceDTOS;

        } catch (Exception ignored) {
            log.info("Napaka pri klicanju zunanje storitve za pridobitev najblizje trgovine");
        }
        return trgovinaDistanceDTOS;
    }
}
