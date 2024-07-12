package com.example.warehouse.dao;

import com.example.warehouse.dto.DetailDto;
import com.example.warehouse.dto.InoutDto;
import com.example.warehouse.dto.ProductDto;
import com.example.warehouse.dto.SalesDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface MainDao {
        @Select("select * from tbl_product_01")
        public List<ProductDto> selectProductTb1() throws DataAccessException;
        @Select("select sum(p_incost) from tbl_product_01")
        public int sumIncost() throws DataAccessException;

        @Select("select sum(p_outcost) from tbl_product_01")
        public int sumOutcost() throws DataAccessException;
        @Select("select max(t_no) from tbl_inout_01")
        public String selectLastTno() throws DataAccessException;
        @Insert("insert into tbl_inout_01 values (#{t_no},#{p_code},#{t_type},#{t_cnt},#{t_date},#{c_code})")
        public void insertInoutTbl(InoutDto dto) throws DataAccessException;
        @Select("SELECT t.t_no, t.p_code, p.p_name, t.t_type, t.t_cnt, t.c_code, c.c_name, t.t_date " +
                "FROM tbl_inout_01 t " +
                "JOIN tbl_product_01 p ON t.p_code = p.p_code " +
                "JOIN tbl_company_01 c ON t.c_code = c.c_code")
        public List<DetailDto> selectInoutDetail() throws DataAccessException;
        @Select("SELECT p.p_code, p.p_name, t.t_cnt, t.t_cnt * (p.p_outcost - p.p_incost) AS p_outcost " +
                "FROM tbl_product_01 p " +
                "JOIN (SELECT p_code, SUM(t_cnt) AS t_cnt " +
                "      FROM tbl_inout_01 " +
                "      WHERE t_type = 'O' " +
                "      GROUP BY p_code) t " +
                "ON p.p_code = t.p_code")
        public List<SalesDto> selectSales() throws DataAccessException;
        @Select("select sum(t_cnt) from tbl_inout_01 where t_type='O'")
        public int sumTotCnt() throws DataAccessException;
        @Select("select sum(p_outcost) - sum(p_incost) from tbl_product_01")
        public int sumTotOutCost() throws DataAccessException;
}