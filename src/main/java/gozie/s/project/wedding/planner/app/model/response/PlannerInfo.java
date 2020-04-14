package gozie.s.project.wedding.planner.app.model.response;

import gozie.s.project.wedding.planner.app.model.PlannerPersonalDetails;

import java.util.List;

public class PlannerInfo extends BaseResponse {
    private List<PlannerPersonalDetails> plannerDetails;

    public List<PlannerPersonalDetails> getPlannerDetails() {
        return plannerDetails;
    }
    public void setPlannerDetails(List<PlannerPersonalDetails> plannerDetails) {
        this.plannerDetails = plannerDetails;
    }
}
