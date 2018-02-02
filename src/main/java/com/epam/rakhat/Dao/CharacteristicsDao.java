package com.epam.rakhat.Dao;

import com.epam.rakhat.Entities.Characteristics;
import com.epam.rakhat.Exceptions.DAOException;

public interface CharacteristicsDao extends CommonDao<Characteristics>{
     Characteristics findByValue (String value) throws DAOException;
}
