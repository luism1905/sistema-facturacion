package cadisystem.model.DAO.interfaces;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 * @param <InputType>
 * @param <StatementType>
 */
public interface IGenericDAO<InputType, StatementType extends Statement> {

    void prepareInput(InputType input, StatementType statement) throws SQLException;

    void execute(InputType input) throws SQLException;

}
