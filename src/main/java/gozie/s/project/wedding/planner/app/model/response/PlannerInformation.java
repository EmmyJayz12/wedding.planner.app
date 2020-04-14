package gozie.s.project.wedding.planner.app.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gozie.s.project.wedding.planner.app.model.PlannerPersonalDetails;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlannerInformation extends BaseResponse {
    private PlannerPersonalDetails personalDetails;

    public PlannerPersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PlannerPersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }
}
