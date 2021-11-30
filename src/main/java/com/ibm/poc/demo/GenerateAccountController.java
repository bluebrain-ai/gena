package com.ibm.poc.demo;

import javax.xml.bind.annotation.XmlElement.DEFAULT;

import com.ibm.poc.demo.entity.GenAccount;
import com.ibm.poc.demo.repository.GenAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController

@RequestMapping("/gena")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server/Application is down. Please contact support team.") })
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GenerateAccountController {
    // @Autowired
    // private IgenerateAccountRepository genAccountRepo;
    // private long customerNumber = 5001;
    @Autowired
    private GenAccountRepository genaAccountRepo;

    @GetMapping(value = "/genacustnum")
    public ResponseEntity<Long> GenerateAccount() {

        // customerNumber = customerNumber + 1;
        Long customerNumer = 0L;
        GenAccount g = new GenAccount();
        try {
            customerNumer = genaAccountRepo.save(g).getCustomerNumer();
        } catch (Exception e) {
            log.error(e);
        }

        log.warn("customerNumer:" + customerNumer);
        return new ResponseEntity<>(customerNumer, HttpStatus.OK);

    }
}
