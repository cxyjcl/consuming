package cn.whpu.management.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by Fiona on 2016/11/13.
 */
public interface CharacterDao {

    /**
     *
     * @param name
     * @return
     */
    int getCharacterId(String name);
}
