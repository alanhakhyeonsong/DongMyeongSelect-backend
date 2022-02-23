package me.ramos.dongmyeonselect.controller;

import lombok.RequiredArgsConstructor;
import me.ramos.dongmyeonselect.dto.api.RandomRequestDto;
import me.ramos.dongmyeonselect.dto.api.ResponseDto;
import me.ramos.dongmyeonselect.service.StoreServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final StoreServiceImpl service;

    // 전체 조회
    @GetMapping("/all")
    public List<ResponseDto> listAll() throws Exception {
        return service.findAll();
    }

    // Category 선택 후 random 으로 1개 조회
    @PostMapping("/random")
    public ResponseEntity<ResponseDto> randomSelect(@RequestBody RandomRequestDto dto) throws Exception {
        ResponseDto response = service.randomChoice(dto);
        if (response == null) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
