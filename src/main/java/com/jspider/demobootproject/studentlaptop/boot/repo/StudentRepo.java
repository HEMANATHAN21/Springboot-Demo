package com.jspider.demobootproject.studentlaptop.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jspider.demobootproject.studentlaptop.boot.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
