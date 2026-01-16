package com.example.genie_tune_java.api.gpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OpenAIRequestDTO(
  @JsonProperty("access_id")
  String accessId, // user의 accessId 앞에 6자리
  @JsonProperty("original_content")
  String originalContent, //얘는 filteredContent임. 원본일 수도 있고 한 번 거쳐진 친구일 수도 있고
  @JsonProperty("is_slang")
  boolean isSlang, // 금칙어 기반 필터링 여부
  @JsonProperty("access_id_character")
  String accessIdCharacter // 저 accessId가 웹툰 제작시 부여하는 캐릭터 외형(최초 1회)
) {}
