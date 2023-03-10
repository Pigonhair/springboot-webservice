package com.pigonhair.springboot.web;

import com.pigonhair.springboot.service.posts.PostsService;
import com.pigonhair.springboot.web.dto.PostsResponseDto;
import com.pigonhair.springboot.web.dto.PostsSaveRequestDto;
import com.pigonhair.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자 생성 , final이 없는 필드는 생성자에 포함X
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
