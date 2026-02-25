package com.example.demoEMP.Controller;

import com.example.demoEMP.Entity.EmpData;
import com.example.demoEMP.Service.EmpdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpDataCont {

    @Autowired
    public EmpdataService empdataService;

    @GetMapping("/Get/Emp")
    public List<EmpData> getEmp(){
        return empdataService.getAllUser();
    }

    @GetMapping("/Emp/get/Id/{id}")
    public EmpData getEmpById(@PathVariable(name = "Id")Integer Id)
    {
        return empdataService.getAllById(Id);
    }
    @PostMapping("/Emp/POST/Save")
    public String postEmp(@RequestBody EmpData empData){
      return empdataService.saveEmp(empData);
    }

    @PutMapping("/Emp/put")
    public String putEmp(@RequestBody EmpData empData){
        return empdataService.updateEmp(empData);
    }
    @DeleteMapping("/Emp/Delete")
    public String delete(@RequestBody Integer Id){
        return empdataService.deleteEmp(Id);
    }




}
