package com.webservice.webservice.service;

import com.webservice.webservice.domain.User;
import com.webservice.webservice.exceptions.DatabaseException;
import com.webservice.webservice.exceptions.ResourceNotFoundException;
import com.webservice.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
       return userRepository.save(user);
    }

    public User update(Integer id, User user){
        User entity = userRepository.getOne(id);
        updateData(entity, user);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

    public void delete(Integer id){
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new DatabaseException(dataIntegrityViolationException.getMessage());
        }
    }
}
