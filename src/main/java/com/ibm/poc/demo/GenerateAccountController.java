package com.ibm.poc.demo;

import com.ibm.poc.demo.repository.GenAccount;
//import com.ibm.poc.demo.repository.IgenerateAccountRepository;

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
    private long customerNumber = 5001;

    @GetMapping(value = "/genacustnum")
    public ResponseEntity<Long> GenerateAccount() {

        customerNumber = customerNumber + 1;
        // try {
        // // customerNumber = genAccountRepo.findAll().get(0).getCustomerNumer();

        // /** add customer generation strategy */
        // customerNumber = customerNumber + 1;

        // } catch(IndexOutOfBoundsException ie)
        // {
        // customerNumber = customerNumber + 1;
        // }catch (Exception e) {
        // log.error("GenAccount Customer Retrival failed", e);
        // }

        // try {
        // //GenAccount g = new GenAccount();
        // //g.setCustomerNumer(customerNumber);
        // genAccountRepo.updateCustomerNumber(customerNumber);
        // } catch (Exception e) {
        // log.error("Generation failed", e);
        // throw new RuntimeException("Generation Failed for customer Number");
        // }

        return new ResponseEntity<>(customerNumber, HttpStatus.OK);

    }
}
