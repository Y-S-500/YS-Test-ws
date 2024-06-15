package com.AMONIC.Airlines.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.AMONIC.Airlines.Entity.ABaseEntity;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IService.IBaseService;




public abstract class ABaseService<T extends ABaseEntity> implements IBaseService<T>{

	protected abstract  IBaseRepository<T, Long> getRepository();
	
    /**
     * Retrieves all entities.
     * @return A list of all entities.
     * @throws Exception If an error occurs while retrieving the entities.
     */
    @Override
    public List<T> all() throws Exception {
    	List<T> allItems = getRepository().findAll();
        List<T> nonDeletedItems = new ArrayList<>();

        for (T item : allItems) {
           
            
                nonDeletedItems.add(item);
            
        }

        return nonDeletedItems;
    }

   
    @Override
    public List<T> findByStateTrue() throws Exception {
        return getRepository().findAll();
    }

  
    @Override
    public Optional<T> findById(Long id) throws Exception {
        Optional<T> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        }   
        return op;
    }

    @Override
    public T save(T entity) throws Exception {
        try {
           
            return getRepository().save(entity);
        } catch (Exception e) {
            // Captura la excepción
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
    }

   
    @Override
    public void update(Long id, T entity) throws Exception {
        Optional<T> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } 

        T entityUpdate = op.get();

        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
       
        getRepository().save(entityUpdate);
    }

   
    @Override
    public void delete(Long id) throws Exception {
        Optional<T> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        }

        T entityUpdate = op.get();
       

        getRepository().delete(entityUpdate);
    }
 
}
