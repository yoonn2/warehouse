package com.example.warehouse.service;

import com.example.warehouse.dao.MainDao;
import com.example.warehouse.dto.DetailDto;
import com.example.warehouse.dto.InoutDto;
import com.example.warehouse.dto.ProductDto;
import com.example.warehouse.dto.SalesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainService {
    private final MainDao dao;

    public List<ProductDto> getProduct() {
        return dao.selectProductTb1();
    }

    public int getTotInCost() {
        return dao.sumIncost();
    }

    public int getTotOutCost() {
        return dao.sumOutcost();
    }

    public String getNextTno() {

        String next_no;
        String last_no = dao.selectLastTno();
        next_no = String.valueOf(Integer.parseInt(last_no) + 1);
        return next_no;
    }

    public void putInout(InoutDto dto) {
        dao.insertInoutTbl(dto);
    }

    public List<DetailDto> getInoutDetail() {
        return dao.selectInoutDetail();
    }

    public List<SalesDto> getSales() {
        return dao.selectSales();
    }


    public int getTotCnt() {
        return dao.sumTotCnt();
    }

    public Map<String, Object> sumTotOutCost() {
        return dao.sumTotOutCost();
    }
}


