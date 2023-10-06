package com.utn.Tp.servicies;

import com.utn.Tp.entities.Base;
import com.utn.Tp.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }
    @Override
    @Transactional
    public List<E> findAll() throws Exception{
        try {
            List<E> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public E findById(ID id) throws Exception{
        try {
            Optional<E> entitiesOptional = baseRepository.findById(id);
            return entitiesOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public E save(E entity) throws Exception{
        try {
            baseRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception{
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
                E entityToUpdate=entityOptional.get();
            BeanUtils.copyProperties(entity,entityToUpdate);  //copio los campos de una entidad a otra
            E entityUpdated =baseRepository.save(entityToUpdate); //los gurado en la db
            return entityUpdated;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public boolean delete(ID id) throws Exception{
        try {
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
