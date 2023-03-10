package com.validation.service.controller;

import com.validation.service.model.DefaultResponseDto;
import com.validation.service.model.UserDataDto;
import com.validation.service.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.validation.service.util.Constant.OK_STATUS;
import static com.validation.service.util.Constant.VALID_DATA;

@RestController
@RequestMapping("/validation")
@RequiredArgsConstructor
public class ValidationController {
    private final UserService userService;
    private final List<UserDataDto> userDataDtoList = new ArrayList<>();

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DefaultResponseDto> functionPostEmail(@RequestBody UserDataDto userDataDto) {
        String status = userService.validate(userDataDto.getPassword(), userDataDto.getEmail());

        if (status.equals(OK_STATUS)) {
            userDataDtoList.add(userDataDto);

            return ResponseEntity.ok(DefaultResponseDto.builder()
                .body(VALID_DATA)
                .date(LocalDateTime.now())
                .build());
        }

        return ResponseEntity.badRequest().body(DefaultResponseDto.builder()
            .errorMessage(status)
            .date(LocalDateTime.now())
            .build());
    }
}
