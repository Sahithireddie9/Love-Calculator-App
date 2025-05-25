package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import dtos.NamesDTO;

@Repository
public class LoveResultDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
     * Saves the  user name and crush name along with result in database
     * @param NamesDTO ,userId,result 
     * @return true if saved to database, false otherwise
     */
	public boolean saveResult(NamesDTO namesDTO,int userId,String result) {
		String sql="INSERT INTO love_results(user_id,your_name,crush_name,result)"+
					"VALUES(?,?,?,?)";
		int re=jdbcTemplate.update(sql,userId,namesDTO.getYourname(),namesDTO.getCrushname(),result);
		return re==1;
		
	}
	
	/**
     * Retrieves all the records from the database for love results
     * @param userId to get all the records belong to that userId
     * @return rowset if exist ,null otherwise
     */
	public SqlRowSet getHistory(int userId) {
		String sql="SELECT  your_name,crush_name,result,calculated_at FROM love_results WHERE user_id=?";
		return jdbcTemplate.queryForRowSet(sql,userId);
	}
	
	
	
	

}
