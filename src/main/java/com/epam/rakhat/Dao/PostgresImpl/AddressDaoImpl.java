package com.epam.rakhat.Dao.PostgresImpl;

import com.epam.rakhat.Dao.AddressDao;
import com.epam.rakhat.Entities.Address;
import com.epam.rakhat.Exceptions.DAOException;

import java.sql.Connection;

public class AddressDaoImpl extends BaseDao<Address> implements AddressDao{

    private Connection connection;

    public AddressDaoImpl(Connection connection){
        super(connection);
        this.connection = connection;
    }
    @Override
    public Address findByCity(String city) throws DAOException {
        return null;
    }
}
