package com.springboot.catchmind.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.springboot.catchmind.vo.FavoritesVo;

@Repository
public class FavoritesDao extends DBConn {
	
	public int deleteFavorites(String fid) {
		int result = 0;
		String sql = " delete from FAVORITES where fid=?";
		getPreparedStatement(sql);
		try {
            pstmt.setString(1, fid);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
	}
	
    public ArrayList<FavoritesVo> select(String mid) {
        ArrayList<FavoritesVo> favoritesList = new ArrayList<FavoritesVo>();
        String sql = "SELECT f.fid, f.sid, f.fmemo, f.mid, s.sname, s.smphoto, s.lunch, s.dinner\r\n" + 
        		" FROM FAVORITES f, SHOP s\r\n" + 
        		" WHERE f.sid = S.sid  and mid = ? ";
        getPreparedStatement(sql);
        try {
            pstmt.setString(1, mid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                FavoritesVo favorite = new FavoritesVo();
                favorite.setFid(rs.getString(1));
                favorite.setSid(rs.getString(2));
                favorite.setFmemo(rs.getString(3));
                favorite.setMid(rs.getString(4));
                favorite.setSname(rs.getString(5));
                favorite.setSmphoto(rs.getString(6));
                favorite.setLunch(rs.getString(7));
                favorite.setDinner(rs.getString(8));

                favoritesList.add(favorite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return favoritesList;
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}