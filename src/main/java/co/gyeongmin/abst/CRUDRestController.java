package co.gyeongmin.abst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

public abstract class CRUDRestController<E, K extends Serializable, R extends JpaRepository<E, K>>
        implements CRUDOperations<E, K> {
    protected final R repository;

    public CRUDRestController(R repository) {
        this.repository = repository;
    }

    @RequestMapping("/{id}/show")
    @Override
    public E findOne(@PathVariable K id) {
        return repository.findOne(id);
    }

    @RequestMapping
    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @Transactional
    @Override
    public Result create(@ModelAttribute E entity,
                         BindingResult bindingResult) {
        repository.save(entity);
        return new Result(true);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @Transactional
    @Override
    public Result update(@PathVariable K id, @ModelAttribute E entity,
                         BindingResult bindingResult) {
        repository.save(entity);
        return new Result(true);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @Transactional
    @Override
    public Result delete(@PathVariable K id) {
        repository.delete(id);
        return new Result(true);
    }
}
