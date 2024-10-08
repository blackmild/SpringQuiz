package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	
	//  input: id
	// output: RealEstate
	public RealEstate selectRealEstateById(int id);
	
	//  input: Integer(rentPrice)
	// output: List<RealEstate>
	public List<RealEstate> selectRealEstateByRentPrice(Integer rentPrice);
	
	//input: area(int), price(int)
	//output:List<RealEstate>
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// 파라미터를 두개이상 xml에 보낼수 없다.
			// 하나의 맵으로 구성해야 하는데 ,@Param이 맵으로 만들어줌
			@Param("area") int area,
			@Param("price") int price);
	
	// input: RealEstate
	// output: int(성공한 행의 개수)
	public int insertRealEstate(RealEstate realEstate);
	
	// input: 여러 파라미터
	//output: int
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice);
}
