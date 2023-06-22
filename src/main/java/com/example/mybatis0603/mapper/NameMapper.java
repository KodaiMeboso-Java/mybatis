package com.example.mybatis0603.mapper;

import com.example.mybatis0603.entity.Name;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NameMapper {
    @Select("SELECT * FROM anime")
    List<Name> findAll();

    @Select("SELECT * FROM anime WHERE id = #{id}")
    List<Name> findById(int id);

    @Insert("INSERT INTO anime (characterName) VALUE (#{name}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createName(Name name);
}
