package BD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


public abstract class DAO {
	
	protected final Connection c = ConnectionClass.getConnection();
	protected String[] TABLE_PK;
	protected String TABLE;
	protected String ID;
	protected static final String V_ID = "idVeterinaria";
	
	protected String prepareInsertStatement(JSONObject jo, String tabla) {
		StringBuilder stmnt = new StringBuilder();
		List <Object> namesList = new ArrayList<Object>(jo.names().toList());
		
		stmnt.append("insert into " + tabla + " ");
		stmnt.append(namesList.toString().replace("[", "(").replace("]", ")"));
		stmnt.append(" values ");
		
		List<String> aux = new ArrayList<String>();
		for(Object s : namesList) {
			aux.add("\'" + jo.get(s.toString()).toString() + "\'");
		}
		
		stmnt.append(aux.toString().replace("[", "(").replace("]", ")"));
		
		return stmnt.toString();
	}
	
	protected String prepareUpdateStatement(JSONObject jo, String tabla, String... id) {
		StringBuilder stmnt = new StringBuilder("update " + tabla + " set ");
		stmnt.append(jo.toMap().toString().replace("{", "").replace("}", "\'").replace("=", "=\'").replace(",", "\',"));
		stmnt.append(" where " + createExactSearchParams(createParams(jo, id)));
		
		return stmnt.toString();
	}
	
	protected String prepareDeleteStatement(JSONObject jo, String tabla, String... id) {
		
		String stmnt = "delete from " + tabla;
		stmnt += " where " + createExactSearchParams(createParams(jo, id));
		
		return stmnt;
	}
	
	protected void updateId(JSONObject jo, String tabla, String id, String... pk) throws SQLException {
		List<String> params = new ArrayList<String>(Arrays.asList(pk));
		params.remove(id);
		
		String stmnt = "Update " + tabla + " set " + id + " = " + id + " - 1" + " where " +
				id + " > " + jo.getInt(id);
		String[] aux = {};
		if(!params.isEmpty()) stmnt += " AND " + createExactSearchParams(createParams(jo, params.toArray(aux))); 
		c.prepareStatement(stmnt).executeUpdate();
	}
	
	protected String generateId(String tabla, String id) throws SQLException { 
		String stmnt = "select MAX("+ id + ") as "+ id + " from " + tabla;
		ResultSet rs = c.prepareStatement(stmnt).executeQuery();
		rs.next();
		String s = "";
		BigDecimal bdId = rs.getBigDecimal(id);
		if(bdId != null) {
			Integer idI = bdId.intValue();
			idI+= 1;
			s = idI.toString();
		}
		return fillId(s);
	}
	
	protected String fillId(String s) throws SQLException{
		for (int i = s.length(); i < 9; i++ ) {
			s = "0" + s;
		}
		return s;
	}
	
	protected ResultSet busqueda(String params, String tabla) throws SQLException {
		String stmnt;
		ResultSet rs = null;
		
		stmnt = "Select * from " + tabla;
		if (params != null)
			stmnt += " where " + params;
		
		
		if(c.prepareStatement(stmnt).executeQuery().next()) {
			rs = c.prepareStatement(stmnt).executeQuery();
		}
		return rs;
	}
	
	protected Object[] createParams(JSONObject jo, String... params) throws JSONException{
		List<String> aux = new ArrayList<String>();
		for(int i = 0; i < params.length; i++) {
			if(params[i] != null) {
				aux.add(params[i]);
				aux.add(jo.get(params[i]).toString());
			}
		}
		return aux.toArray();
		
	}
	
	protected String createPartialSearchParams(Object... params) {
		StringBuilder aux = new StringBuilder();
		String aux2 = null;
		
		if(!(params.length % 2 == 1 || params.length == 0)) {
			for(int i = 0; i < params.length; i+=2) {
				if (i < params.length - 1 && params[i + 1] != null && i > 0 && !aux.toString().equals(""))
					aux.append(" AND ");
				if (params[i + 1] != null) {
					aux.append(params[i] + " LIKE '%" + params[i+1] + "%'");
				}
			}
			if (!aux.toString().equals(""))
				aux2 = aux.toString();
		}
		
		return aux2;
	}
	
	protected String createExactSearchParams(Object... params) {
		StringBuilder aux = new StringBuilder();
		String aux2 = null;
		
		if(!(params.length % 2 == 1 || params.length == 0)) {
			for(int i = 0; i < params.length; i+=2) {
				if (i < params.length - 1 && params[i + 1] != null && i > 0 && !aux.toString().equals(""))
					aux.append(" AND ");
				if (params[i + 1] != null) {
					aux.append(params[i] + " = " + "\'" + params[i+1] + "\'");
				}
			}
			if (!aux.toString().equals(""))
				aux2 = aux.toString();
		}
		
		return aux2;
	}

}
