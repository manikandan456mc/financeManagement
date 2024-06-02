package com.example.praveen.financeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.praveen.financeManagement.Model.DataResponse;
import com.example.praveen.financeManagement.Model.FundType;
import com.example.praveen.financeManagement.Payload.CategoryCreateReq;
import com.example.praveen.financeManagement.Payload.FlowRecordCreateReq;
import com.example.praveen.financeManagement.Repository.CategoryRepository;
import com.example.praveen.financeManagement.Repository.FlowRecordRepository;
import com.example.praveen.financeManagement.Services.FinanceServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/finance/")
public class FinanceController {

        @Autowired
        CategoryRepository categoryRepository;

        @Autowired
        FlowRecordRepository flowRecordRepository;

        @Autowired
        ReactiveMongoTemplate reactiveMongoTemplate;

        @PostMapping("category/create")
        public ResponseEntity<?> createStory(
                        @RequestBody CategoryCreateReq CategoryCreateReq) {
                try {

                        FinanceServices financeServices = new FinanceServices(
                                        categoryRepository, null, null);
                        return new ResponseEntity<>(
                                        DataResponse.builder()
                                                        .data(financeServices.CategoryCreate(CategoryCreateReq))
                                                        .build(),
                                        HttpStatus.OK);
                } catch (Exception ex) {
                        System.out.println(ex.getLocalizedMessage());
                        return new ResponseEntity<>(DataResponse.builder().error(ex.getLocalizedMessage()).build(),
                                        HttpStatus.FORBIDDEN);
                }
        }

        @PostMapping("create/record")
        public ResponseEntity<?> createRecord(
                        @RequestBody FlowRecordCreateReq flowRecordCreateReq) {
                try {

                        FinanceServices financeServices = new FinanceServices(
                                        categoryRepository, flowRecordRepository, null);
                        return new ResponseEntity<>(
                                        DataResponse.builder()
                                                        .data(financeServices.RecordCreate(flowRecordCreateReq))
                                                        .build(),
                                        HttpStatus.OK);
                } catch (Exception ex) {
                        System.out.println(ex.getLocalizedMessage());
                        return new ResponseEntity<>(DataResponse.builder().error(ex.getLocalizedMessage()).build(),
                                        HttpStatus.FORBIDDEN);
                }
        }

        @GetMapping("getall/category")
        public ResponseEntity<?> getAllcategory(@RequestParam(required = false, name = "type") FundType type) {
                try {

                        FinanceServices financeServices = new FinanceServices(
                                        categoryRepository, flowRecordRepository, reactiveMongoTemplate);
                        return new ResponseEntity<>(
                                        DataResponse.builder()
                                                        .data(financeServices.getCategoryByType(type))
                                                        .build(),
                                        HttpStatus.OK);

                } catch (Exception ex) {
                        System.out.println(ex.getLocalizedMessage());
                        return new ResponseEntity<>(DataResponse.builder().error(ex.getLocalizedMessage()).build(),
                                        HttpStatus.FORBIDDEN);
                }
        }

        @GetMapping("getall/record")
        public ResponseEntity<?> getAllRecord(@RequestParam(required = false, name = "type") FundType type) {
                try {

                        FinanceServices financeServices = new FinanceServices(
                                        categoryRepository, flowRecordRepository, reactiveMongoTemplate);
                        return new ResponseEntity<>(
                                        DataResponse.builder()
                                                        .data(financeServices.GetRecordByFundType(type))
                                                        .build(),
                                        HttpStatus.OK);

                } catch (Exception ex) {
                        System.out.println(ex.getLocalizedMessage());
                        return new ResponseEntity<>(DataResponse.builder().error(ex.getLocalizedMessage()).build(),
                                        HttpStatus.FORBIDDEN);
                }
        }
}
