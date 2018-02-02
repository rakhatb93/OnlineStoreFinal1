package com.epam.rakhat.Dao;

import com.epam.rakhat.Entities.Address;
import com.epam.rakhat.Exceptions.DAOException;

public interface AddressDao extends CommonDao<Address> {
     Address findByCity(String city) throws DAOException;
}
