package co.gyeongmin.abst;

import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * Created by gyeongmin on 3/24/16.
 */
public interface CRUDOperations<E, K> {
    List<E> findAll();
    E findOne(K id);
    Result create(E entity, BindingResult bindingResult);
    Result update(K id, E entity, BindingResult bindingResult);
    Result delete(K id);
}
