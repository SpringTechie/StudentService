package com.example.demoEMP.Repo;

import com.example.demoEMP.Entity.EmpData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDataRepo extends JpaRepository<EmpData,Integer>{

}
