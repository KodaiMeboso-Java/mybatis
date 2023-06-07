package com.example.mybatis0603;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NameMapper {
    @Select("SELECT * FROM anime")
    List<Name> findAll();
    @Select("SELECT * FROM anime WHERE id = #{id}")

    Optional<Name> findById(int id);
}
