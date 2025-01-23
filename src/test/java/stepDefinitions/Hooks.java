package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {

        StepDefinition sd = new StepDefinition();
        if(StepDefinition.placeId == null) {

            sd.addPlacePayloadWith("Sheethal", "Hindi", "Asia");
            sd.userCallsWithHttpRequest("AddPlaceAPI", "POST");
            sd.verifyPlace_IdCreatedMapsToUsing("Sheethal", "getPlaceAPI");
        }
    }
}
