package com.k3519076.gajikaryawan.service;

import com.k3519076.gajikaryawan.IO.gajiInput;
import com.k3519076.gajikaryawan.IO.gajiOutput;
import org.springframework.stereotype.Service;

@Service
public class GajiService {
    private final int baseGaji = 4500;


    public gajiOutput ceoPayment(gajiInput input){
        gajiOutput outputData = new gajiOutput();
        outputData.setInputData(input);
        outputData.setBasicSallary(baseGaji * 8);

        gajiInput inputData = new gajiInput();
        inputData.setFamily(input.getFamily()*30);
        inputData.setOvertime(input.getOvertime()*20);

        outputData.setAllowance(inputData);
        return outputData;
    }

    public gajiOutput managerPayment(gajiInput input){
        gajiOutput outputData = new gajiOutput();
        outputData.setInputData(input);
        outputData.setBasicSallary(baseGaji * 3);

        gajiInput inputData = new gajiInput();
        inputData.setFamily(input.getFamily()*30);
        inputData.setOvertime(input.getOvertime()*10);

        outputData.setAllowance(inputData);
        return outputData;
    }


    public gajiOutput seniorWorkerPayment(int family, int overtime){
        gajiInput inputData = new gajiInput();
        gajiOutput outputData = new gajiOutput();
        outputData.setBasicSallary(baseGaji * 2);

        inputData.setOvertime(overtime);
        inputData.setFamily(family);
        outputData.setInputData(inputData);

        gajiInput inputData2 = new gajiInput();
        inputData2.setFamily(family*30);
        inputData2.setOvertime(overtime*5);
        outputData.setAllowance(inputData2);
        return outputData;
    }

    public gajiOutput regularWorkerPayment(int family, int overtime){
        gajiInput inputData = new gajiInput();
        gajiOutput outputData = new gajiOutput();
        outputData.setBasicSallary(baseGaji);

        inputData.setOvertime(overtime);
        inputData.setFamily(family);
        outputData.setInputData(inputData);

        gajiInput inputData2 = new gajiInput();
        inputData2.setFamily(family*30);
        inputData2.setOvertime(overtime*4);
        outputData.setAllowance(inputData2);
        return outputData;
    }
}
