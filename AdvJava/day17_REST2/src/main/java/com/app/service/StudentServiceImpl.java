package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.dto.StudentDTO;
import com.app.entities.Student;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	 @Autowired
	 private ModelMapper mapper;

	@Override
	public StudentDTO addStudentDetails(StudentDTO dto) {
		Student student=mapper.map(dto, Student.class);
		
		return mapper.map
				(studentDao.save(student),StudentDTO.class);
	}
	 
	 
	
}
