package blood.bank.infra.mappers;

import blood.bank.domain.entities.applicant.Applicant;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.domain.entities.patient.Patient;
import blood.bank.domain.entities.request.Request;
import blood.bank.infra.persistence.models.ApplicantEntity;
import blood.bank.infra.persistence.models.EmployeeEntity;
import blood.bank.infra.persistence.models.PatientEntity;
import blood.bank.infra.persistence.models.RequestEntity;

public class RequestEntityMapper {

    public static RequestEntity toEntity(Request request){
        PatientEntity patient = PatientEntityMapper.toEntity(request.getPatient());
        ApplicantEntity applicant = ApplicantMapper.toEntity(request.getApplicant());
        EmployeeEntity employee = EmployeeEntityMapper.toEntity(request.getEmployee());
        return new RequestEntity(patient, applicant, employee, request.getRequestDate(), request.getRequestedType(), request.getRequestedComponent(), request.getRequestedQuantity(), request.getNeedByDate(), request.getFulfillmentDate());
    }

    public static Request toRequest(RequestEntity requestEntity){
        Patient patient = PatientEntityMapper.toPatient(requestEntity.getPatient());
        Applicant applicant = ApplicantMapper.toApplicant(requestEntity.getApplicant());
        Employee employee = EmployeeEntityMapper.toEmployee(requestEntity.getEmployee());
        return new Request(patient, applicant, employee, requestEntity.getRequestDate(), requestEntity.getRequestedType(), requestEntity.getRequestedComponent(), requestEntity.getRequestedQuantity(), requestEntity.getNeedByDate(), requestEntity.getFulfillmentDate());
    }
}
