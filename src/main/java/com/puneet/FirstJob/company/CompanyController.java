package com.puneet.FirstJob.company;

import com.puneet.FirstJob.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompany(company, id);
        return new ResponseEntity<>("Company updated Successfully", HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return  new ResponseEntity<>("Company added successfully",HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted=companyService.deleteCompanyById(id);
        if(deleted) return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
        else return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){

        Company company = companyService.getCompanyById(id);
        if(company!=null) return new ResponseEntity<>(company, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

}
