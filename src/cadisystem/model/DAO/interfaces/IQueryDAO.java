/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO.interfaces;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 * @param <InputType>
 * @param <StatementType>
 * @param <OutputType>
 */
public interface IQueryDAO<InputType, StatementType extends Statement, OutputType> extends IGenericDAO<InputType, StatementType> {

    OutputType prepareOutput(ResultSet rs, CallableStatement statement) throws SQLException;

}
