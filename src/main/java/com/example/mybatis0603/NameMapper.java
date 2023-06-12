package com.example.mybatis0603;

import com.example.mybatis0603.controller.Name;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NameMapper {
    @Select("SELECT * FROM anime")
    List<Name> findAll();

    @Select("SELECT * FROM anime WHERE id = #{id}")
    Optional<Name> findById(int id);

    @Insert("INSERT INTO anime (characterName) VAKUE (#{name}) ")
    int insert(@Param("name") String name);
}
