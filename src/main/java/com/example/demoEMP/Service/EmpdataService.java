package com.example.demoEMP.Service;


import com.example.demoEMP.Entity.EmpData;
import com.example.demoEMP.Repo.EmpDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpdataService{

@Autowired
    public EmpDataRepo empdatarepo;

    public List<EmpData> getAllUser()
    {
    return empdatarepo.findAll();
    }
    public EmpData getAllById(Integer Id)
    {
        empdatarepo.findAllById(List.of(1,2));
        return null;
    }

    public String saveEmp(EmpData empData){
        EmpData save = empdatarepo.save(empData);
        if(save != null){
            return "Updated";
        }
        else {
            return "not updated";
        }
    }
    public String deleteEmp(Integer Id)
    {
        if(empdatarepo.existsById(Id))
        {
            empdatarepo.deleteById(Id);
            return "Delete by Name";
        }
        else{
            return "Not found";
        }
    }
    public String updateEmp(EmpData empData){
        if(empdatarepo.save(empData)!=null){
            return "updated sucessfully";
        }
        else {
            return "not updated";
        }
    }


}


