/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.DAO.content;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author usuario
 * @param <OutputType>
 */
public class ContentQueryDAO<OutputType> extends ContentGenericDAO {

    private List<OutputType> resultList;

    public ContentQueryDAO(DataSource dataSource, String storedProcedureName, int numParameters) {
        super(dataSource, storedProcedureName, numParameters);
    }

    public List<OutputType> getResultList() {
        return resultList;
    }

    public void setResultList(List<OutputType> resultList) {
        this.resultList = resultList;
    }
    
    public OutputType getResult(){
        if(resultList != null && !resultList.isEmpty()){
            return resultList.get(0);
        }
        return null;
    } 

}
