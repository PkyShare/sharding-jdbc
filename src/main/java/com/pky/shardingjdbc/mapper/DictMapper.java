package com.pky.shardingjdbc.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DictMapper {
    /**
     * 插入字典表信息
     * @param dictId 字典id
     * @param type 字典类型
     * @param code 字典编码
     * @param value 字典值
     * @return
     */
    @Insert("Insert into t_dict(dict_id, type, code, value) values(#{dictId}, #{type}, #{code}, #{value})")
    int insertDict(@Param("dictId") Long dictId, @Param("type") String type, @Param("code") String code, @Param("value") String value);

    /**
     * 删除字典信息
     * @param dictId 字典id
     * @return
     */
    @Delete("Delete from t_dict where dict_id = #{dictId}")
    int deleteDict(@Param("dictId") Long dictId);
}
