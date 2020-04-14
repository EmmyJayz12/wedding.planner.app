package gozie.s.project.wedding.planner.app.controller;

import gozie.s.project.wedding.planner.app.model.response.BaseResponse;
import gozie.s.project.wedding.planner.app.model.PlannerPersonalDetails;
import gozie.s.project.wedding.planner.app.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/planner-app")
public class ImplController {
    private ServiceImpl serviceImpl;

    @Autowired
    public ImplController(ServiceImpl serviceImpl){
        this.serviceImpl = serviceImpl;
    }

@RequestMapping(value="/register-personal-details", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse insertPersonalDetails(@RequestBody @Validated PlannerPersonalDetails details){
        return serviceImpl.insertPersonalDetails(details);
    }
    @RequestMapping(value="/update-personal-details", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updatetPersonalDetails(@RequestBody @Validated PlannerPersonalDetails details){
        return serviceImpl.updatePersonalDetails(details);
}
}

