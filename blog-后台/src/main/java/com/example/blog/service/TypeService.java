package com.example.blog.service;

import com.example.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService  {
    //保存
    Type saveType(Type type);
    //查询
    Type getType(Long id);
    //分页查询
    Page<Type> listType(Pageable pageable);
    //修改
    Type updateType(Long id,Type type);
    //删除
    void deleteType(Long id);
    //类型名称重复查询
    Type findName(String name);
}
