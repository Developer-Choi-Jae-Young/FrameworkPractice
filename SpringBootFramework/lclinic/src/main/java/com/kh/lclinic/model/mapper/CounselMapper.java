package com.kh.lclinic.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.lclinic.model.vo.Counsel;

@Mapper
public interface CounselMapper {
	public List<Counsel> selectAllCounselByUserId(String id);
}
