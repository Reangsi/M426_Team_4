package dao;

import util.Result;

import java.util.List;
/**
 * interface for data access objects
 *
 * @author Christian Zimmermann
 * @version 1.0
 * @since 2020-05-06
 */
public interface Dao<T, K> {

    /**
     * gets all datasets in a table
     * @return list of model-objects
     */
    default List<T> getAll() {
        throw new UnsupportedOperationException();
    }

    /**
     * gets a single datasets in a table
     * @param k  primary key
     * @return model-object
     */
    default T getEntity(K k) {
        throw new UnsupportedOperationException();
    }

    /**
     * saves an object to the database entity
     * @param t model-object
     * @return Result-code
     */
    default Result save(T t) {
        throw new UnsupportedOperationException();
    }

    /**
     * delets an entity in the database
     * @param k primary key
     * @return Result-code
     */
    default Result delete(K k) {
        throw new UnsupportedOperationException();
    }

    /**
     * counts the datasets in a table
     * @return
     */
    default Integer count() {
        return 0;
    }

}
