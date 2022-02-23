package me.ramos.dongmyeonselect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ramos.dongmyeonselect.dto.admin.EnrollRequestDto;
import me.ramos.dongmyeonselect.dto.admin.ListResponseDto;
import me.ramos.dongmyeonselect.dto.admin.UpdateRequestDto;
import me.ramos.dongmyeonselect.service.StoreServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final StoreServiceImpl service;

    // 메인 경로
    @GetMapping
    public String adminMain() {
        log.info("admin page");
        return "/adminHome";
    }

    // 등록 페이지 GET
    @GetMapping("/stores/new")
    public String createForm(Model model) {
        log.info("등록 페이지 호출");
        model.addAttribute("dto", EnrollRequestDto.builder().build());
        return "/admin/stores/storeForm";
    }

    // 등록 POST - Store, Menu 한번에 등록. Service 두개 필요함.
    @PostMapping("/stores/new")
    public String createStore(@ModelAttribute EnrollRequestDto dto) {
        log.info("create store: ");
        service.enroll(dto);
        return "redirect:/admin";
    }

    // 전체 리스트 페이지 GET
    @GetMapping("/stores")
    public String storeList(Model model) {
        log.info("전체 리스트 페이지 호출");
        List<ListResponseDto> stores = service.findAllForAdmin();
        model.addAttribute("stores", stores);

        return "/admin/stores/storeList";
    }

    // 수정 페이지 GET
    @GetMapping("/stores/{storeId}/edit")
    public String updateForm(@PathVariable("storeId") Long storeId, Model model) {
        log.info("수정 페이지 호출");
        model.addAttribute("id", storeId);
        model.addAttribute("dto", UpdateRequestDto.builder().storeId(storeId).build());

        return "/admin/stores/updateForm";
    }

    // 수정 POST - Store_id로 두 테이블 한번에 수정
    @PostMapping("/stores/{storeId}/edit")
    public String updateStore(@PathVariable("storeId") Long storeId,
                              @ModelAttribute UpdateRequestDto dto) {
        log.info("update store: "+ storeId);
        service.update(storeId, dto);
        return "redirect:/admin/stores";
    }

    // 삭제
    @GetMapping("/stores/{storeId}/delete")
    public String deleteStore(@PathVariable("storeId") Long storeId) {
        log.info("delete store: "+ storeId);
        service.delete(storeId);
        return "redirect:/admin/stores";
    }
}
