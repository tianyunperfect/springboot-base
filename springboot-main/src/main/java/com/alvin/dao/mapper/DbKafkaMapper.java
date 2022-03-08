package com.alvin.dao.mapper;

import com.alvin.dao.entity.DbKafka;
import com.alvin.dao.entity.example.DbKafkaExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DbKafkaMapper {
    long countByExample(DbKafkaExample example);

    int deleteByExample(DbKafkaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DbKafka record);

    int insertSelective(@Param("record") DbKafka record, @Param("selective") DbKafka.Column ... selective);

    DbKafka selectOneByExample(DbKafkaExample example);

    DbKafka selectOneByExampleSelective(@Param("example") DbKafkaExample example, @Param("selective") DbKafka.Column ... selective);

    List<DbKafka> selectByExampleSelective(@Param("example") DbKafkaExample example, @Param("selective") DbKafka.Column ... selective);

    List<DbKafka> selectByExample(DbKafkaExample example);

    DbKafka selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DbKafka.Column ... selective);

    DbKafka selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DbKafka record, @Param("example") DbKafkaExample example, @Param("selective") DbKafka.Column ... selective);

    int updateByExample(@Param("record") DbKafka record, @Param("example") DbKafkaExample example);

    int updateByPrimaryKeySelective(@Param("record") DbKafka record, @Param("selective") DbKafka.Column ... selective);

    int updateByPrimaryKey(DbKafka record);

    int batchInsert(@Param("list") List<DbKafka> list);

    int batchInsertSelective(@Param("list") List<DbKafka> list, @Param("selective") DbKafka.Column ... selective);

    int upsert(DbKafka record);

    int upsertSelective(@Param("record") DbKafka record, @Param("selective") DbKafka.Column ... selective);
}