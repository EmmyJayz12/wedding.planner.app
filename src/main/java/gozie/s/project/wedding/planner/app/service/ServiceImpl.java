package gozie.s.project.wedding.planner.app.service;

import gozie.s.project.wedding.planner.app.model.response.BaseResponse;
import gozie.s.project.wedding.planner.app.model.PlannerPersonalDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
@Service
public class ServiceImpl {
    private JdbcTemplate jdbcTemplate;

    public ServiceImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public BaseResponse uniqueResponse(int res){
        BaseResponse base = new BaseResponse();
        if(res==0){
            base.setResponseCode("10002");
            base.setResponseMessage("No record found");
        }
        base.setResponseCode("00");
        base.setResponseMessage("Successful");
        return base;
    }
    public BaseResponse insertPersonalDetails(PlannerPersonalDetails details) {
        BaseResponse base = new BaseResponse();
        String sql = "INSERT INTO personal_details (company_name, first_name, middle_name, surname, office_address, state, phone_number, email_address, username, password) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            int res = this.jdbcTemplate.update(sql, new Object[]{details.getCompanyName(), details.getFirstName(), details.getMiddleName(), details.getSurname(), details.getOfficeAddress(), details.getState(), details.getPhoneNumber(), details.getEmailAddress(), details.getUsername(), details.getPassword()});
            return uniqueResponse(res);
        }
        catch (Exception e){
            e.printStackTrace();
            base.setResponseCode("10002");
            base.setResponseMessage(e.getCause().getMessage());
        }
        return base;
    }
    public BaseResponse updatePersonalDetails(PlannerPersonalDetails details) {
        BaseResponse base = new BaseResponse();
        String sql = "UPDATE personal_details SET company_name=?,first_name=?,middle_name=?,surname=?,office_address=?,state=?,phone_number=?,email_address=?,username=?,password=? WHERE id=?";
        try {
            int res = this.jdbcTemplate.update(sql, new Object[]{details.getCompanyName(), details.getFirstName(), details.getMiddleName(), details.getSurname(), details.getOfficeAddress(), details.getState(), details.getPhoneNumber(), details.getEmailAddress(), details.getUsername(), details.getPassword(), details.getId()});
            return uniqueResponse(res);
        }
        catch (Exception e){
            e.printStackTrace();
            base.setResponseCode("10002");
            base.setResponseMessage(e.getCause().getMessage());
        }
        return base;
    }
}
