package com.example.warehouse.controller;

import com.example.warehouse.dto.DetailDto;
import com.example.warehouse.dto.InoutDto;
import com.example.warehouse.dto.ProductDto;
import com.example.warehouse.dto.SalesDto;
import com.example.warehouse.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final MainService service;

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }
    @GetMapping("/product")
    public String productPage(Model model) {
        List<ProductDto> list = service.getProduct();
        int tot_incost = service.getTotInCost();
        int tot_outcost = service.getTotOutCost();
        model.addAttribute("list", list);
        model.addAttribute("tot_incost", tot_incost);
        model.addAttribute("tot_outcost", tot_outcost);
        return "product";
    }

    @GetMapping("/inout")
    public String inoutPage(Model model) {
        String nextno = service.getNextTno();
        model.addAttribute("nextno", nextno);
        return "inout";
    }
    @PostMapping("/regist")
    public String registInout(InoutDto dto){
        service.putInout(dto);
        return "index";
    }

    @GetMapping("/detail")
    public String detailPage(Model model) {
        List<DetailDto> list = service.getInoutDetail();
        model.addAttribute("list", list);
        return "detail";
    }

    @GetMapping("/sales")
    public String salesPage(Model model) {
        List<SalesDto> list = service.getSales();
        int tot_cnt = service.getTotCnt();
        int tot_outcost = service.sumTotOutCost() * tot_cnt;
        model.addAttribute("list", list);
        model.addAttribute("tot_cnt", tot_cnt);
        model.addAttribute("tot_outcost", tot_outcost);
        return "sales";
    }


}
