package com.myProperty.Property_Manageent.Controller;

import com.myProperty.Property_Manageent.Model.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    //http://localhost:8080/api/v1/calculator/add(Unable to pass the parameters)
    //http://localhost:8080/api/v1/calculator/add?num1=16.8&num2=12.5
    //Both num1 and a should variable will be same it s best practice
    @GetMapping("/add/{num3}")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @PathVariable("num3") Double num3){
        return num1+num2;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double subtract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result=null;
        if(num1>num2){
            result = num1 - num2;
        }else{
            result = num2 - num1;
        }
        return result;
    }

    @PostMapping("/mult")
    public ResponseEntity<Double> Multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result =null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2()* calculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }

}
