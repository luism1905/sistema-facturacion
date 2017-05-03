
package cadisystem.model.DAO.interfaces;

import java.sql.Statement;

/**
 *
 * @author usuario
 * @param <InputType>
 * @param <StatementType>
 */
public interface ICommandDAO<InputType, StatementType extends Statement> extends IGenericDAO<InputType, StatementType> {

}
