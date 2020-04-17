package gozie.s.project.wedding.planner.app.service;

import gozie.s.project.wedding.planner.app.model.response.BaseResponse;
import gozie.s.project.wedding.planner.app.model.PlannerPersonalDetails;
import gozie.s.project.wedding.planner.app.model.response.PlannerInfo;
import gozie.s.project.wedding.planner.app.model.response.PlannerInformation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ServiceImpl<Planner> {
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
    public PlannerInfo getAllPersonalDetails(){
        BaseResponse base = new BaseResponse();
        PlannerInfo information = new PlannerInfo();
        String sql = "SELECT * FROM personal_details";
        try {
           List<PlannerPersonalDetails> info= this.jdbcTemplate.query(sql, new RowMapperInfo());
           if(info.isEmpty()|| info==null){
               information.setResponseCode("10001");
               information.setResponseMessage("No Record Found");
               return information;
           }
           information.setResponseCode("00");
           information.setResponseMessage("Successful");
           information.setPlannerDetails(info);
        }
        catch (Exception e){
            e.printStackTrace();
            base.setResponseCode("100002");
            base.setResponseMessage(e.getCause().getMessage());
        }
        return information;
    }
    private class RowMapperInfo implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {

            PlannerPersonalDetails details = new PlannerPersonalDetails();
            details.setId(rs.getLong("id"));
            details.setCompanyName(rs.getString("company_name"));
            details.setFirstName(rs.getString("first_name"));
            details.setMiddleName(rs.getString("middle_name"));
            details.setSurname(rs.getString("surname"));
            details.setOfficeAddress(rs.getString("office_address"));
            details.setState(rs.getString("state"));
            details.setPhoneNumber(rs.getString("phone_number"));
            details.setEmailAddress(rs.getString("email_address"));
            details.setUsername(rs.getString("username"));
            details.setPassword(rs.getString("password"));
            details.setDate_time(rs.getString("date_time"));
            return details;
        }
    }
}
