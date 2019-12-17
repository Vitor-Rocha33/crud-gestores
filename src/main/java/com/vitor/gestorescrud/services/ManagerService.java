package com.vitor.gestorescrud.services;

import com.vitor.gestorescrud.domain.Manager;
import com.vitor.gestorescrud.dto.ManagerDTO;
import com.vitor.gestorescrud.dto.ManagerNewDTO;
import com.vitor.gestorescrud.repositories.ManagerRepository;
import com.vitor.gestorescrud.services.exceptions.DataIntegrityException;
import com.vitor.gestorescrud.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository repo;

    public Manager find(Integer id) {
        Optional <Manager> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Manager.class.getName()));
    }

    public Manager update(Manager obj){
        Manager newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public Manager insert(Manager obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public List<Manager> findAll() {
        return repo.findAll();
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }
    }

    public Manager fromDTO(ManagerDTO objDto) {
        return new Manager(objDto.getId(), null,objDto.getName(), objDto.getDateOfBirth(), objDto.getSector());
    }

    public Manager fromDTO(ManagerNewDTO objDto) {
        Manager man = new Manager(null, objDto.getRegistration(), objDto.getName(), objDto.getDateOfBirth(),
                objDto.getSector());
        return man;
    }

    private void updateData (Manager newObj, Manager obj) {
        newObj.setName(obj.getName());
        newObj.setDateOfBirth(obj.getDateOfBirth());
        newObj.setSector(obj.getSector());
    }
}
