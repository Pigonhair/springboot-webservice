package com.pigonhair.springboot.web.dto;

import com.pigonhair.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    
    // 기본적인 구조는 생성자를 통해 최종값을 채운 후 DB에 삽입 > setter대신 builder클래스를 사용하여 DB에 삽입함
    @Builder 
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
    
}
