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
public class ContentCommandDAO extends ContentGenericDAO {

    public ContentCommandDAO(DataSource dataSource, String storedProcedureName, int numParameters) {
        super(dataSource, storedProcedureName, numParameters);
    }

}
