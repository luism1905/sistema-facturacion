/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO.content;

import javax.sql.DataSource;

/**
 *
 * @author usuario
 */
public class ContentGenericDAO {

    private final DataSource dataSource;
    private final String statementSQL;

    protected ContentGenericDAO(DataSource dataSource, String storedProcedureName, int numParameters) {
        this.dataSource = dataSource;
        StringBuilder sb = new StringBuilder("CALL ");
        sb.append(storedProcedureName);
        if (numParameters != 0) {
            sb.append("(");
            for (int i = 0; i < numParameters - 1; i++) {
                sb.append("?,");
            }
            sb.append("?)");
        }
        statementSQL = sb.toString();
    }

    protected DataSource getDataSource() {
        return dataSource;
    }

    protected String getStatementSQL() {
        return statementSQL;
    }

}
