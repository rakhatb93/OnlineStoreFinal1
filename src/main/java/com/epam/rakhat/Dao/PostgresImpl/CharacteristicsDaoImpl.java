package com.epam.rakhat.Dao.PostgresImpl;

import com.epam.rakhat.Dao.CharacteristicsDao;
import com.epam.rakhat.Entities.Characteristics;
import com.epam.rakhat.Exceptions.DAOException;

import java.sql.Connection;

public class CharacteristicsDaoImpl extends BaseDao<Characteristics> implements CharacteristicsDao{

    private Connection connection;

    public CharacteristicsDaoImpl (Connection connection){
        super(connection);
        this.connection = connection;
    }

    public Characteristics findByValue (String value) throws DAOException{
        return null;
    }
}
