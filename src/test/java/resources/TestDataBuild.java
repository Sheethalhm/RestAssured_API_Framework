package resources;

import org.e2e.api.AddPlace;
import org.e2e.api.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace getAddPlace(String name, String language, String address) throws IOException {
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite(Utils.getGlobalValue("baseUrl"));
        p.setName(name);
        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public String deletePayload(String placeId){
        return "{\"place_id\":\""+placeId+"\"}";
    }
}
