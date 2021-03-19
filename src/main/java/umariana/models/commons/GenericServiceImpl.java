package umariana.models.commons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl <T,ID extends Serializable> implements GenericServiceApi<T,ID>{

    @Override
    @Transactional
    public T save(T entity)
    {
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T findByID(ID id) {
       final Optional<T> optional = getDao().findById(id);
       return optional.isPresent()?optional.get():null;
    }

    @Override
    public List<T> getAll() {
        final List<T> list = new ArrayList<T>();
        getDao().findAll().forEach(list::add);
        return list;
    }

    public abstract CrudRepository<T,ID> getDao();
}
