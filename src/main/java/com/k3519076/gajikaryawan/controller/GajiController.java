package com.k3519076.gajikaryawan.controller;

import com.k3519076.gajikaryawan.IO.gajiInput;
import com.k3519076.gajikaryawan.IO.gajiOutput;
import com.k3519076.gajikaryawan.service.GajiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payrollinfo")
public class GajiController {

    @Autowired
    public GajiService gajiService;

    @PostMapping("ceo")
    public ResponseEntity<gajiOutput> ceoPayroll(@RequestBody gajiInput input){
        gajiOutput outputData = gajiService.ceoPayment(input);
        return ResponseEntity.ok(outputData);
    }

    @PostMapping("manager")
    public ResponseEntity<gajiOutput> managerPayroll(@RequestBody gajiInput input){
        gajiOutput outputData = gajiService.managerPayment(input);
        return ResponseEntity.ok(outputData);
    }

    @GetMapping("senioremp/{family}/{overtime}")
    public ResponseEntity<gajiOutput> seniorEmpPayroll(@PathVariable int family, @PathVariable int overtime){
        gajiOutput outputData = gajiService.seniorWorkerPayment(family, overtime);
        return  ResponseEntity.ok(outputData);
    }


    @GetMapping("defaultemp/{family}/{overtime}")
    public ResponseEntity<gajiOutput> defaultEmpPayroll(@PathVariable int family, @PathVariable int overtime){
        gajiOutput outputData = gajiService.regularWorkerPayment(family, overtime);
        return  ResponseEntity.ok(outputData);
    }
}
