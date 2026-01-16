package com.example.genie_tune_java.common.config;

import com.example.genie_tune_java.domain.prompt.dto.WordFilterResult;
import com.example.genie_tune_java.domain.word_rule.dto.GetWordRulesResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Log4j2
public class WordRuleCache {

  // 전체 리스트가 필요한 경우를 위해 유지
  private volatile List<GetWordRulesResponseDTO> cache = List.of();

  // 빠른 조회를 위한 Map (금칙어 -> DTO 전체)
  private volatile Map<String, GetWordRulesResponseDTO> cacheMap = Map.of();

  public void load(List<GetWordRulesResponseDTO> data) {
    // 1. 리스트 저장
    this.cache = List.copyOf(data);

    // 2. 조회를 위한 Map 생성 (금칙어를 Key로, DTO를 Value로)
    this.cacheMap = data.stream()
            .collect(Collectors.toUnmodifiableMap(
                    GetWordRulesResponseDTO::forbiddenWord,
                    dto -> dto,
                    (existing, replacement) -> replacement // 중복 시 후순위 데이터 사용
            ));

    log.info("WordRuleCache loaded. size={}", cache.size());
  }

  // casheMap의 key 값: forbiddenWord, value 값: GetWordRuleResponseDTO (DB에서 3개 필드 맵핑한 DTO)
  // GetWordRulesResponseDTO 단일 객체 1개가 튀어나온다. (Redis와 유사)
  public GetWordRulesResponseDTO getRule(String forbiddenWord) {
    return cacheMap.get(forbiddenWord);
  }

  // 전체 리스트가 혹시 필요하면 이 메서드
  public List<GetWordRulesResponseDTO> getAll() {
    return cache;
  }

  // filter 여부와, 치환 모든 것이 다 기록되어야 해서 별도의 DTO 생성
  public WordFilterResult filterWord(String word) {
    String originalWord = word;  // 원본 단어
    String filteredWord = word; // 필터링을 거친 단어
    String reason = null;
    boolean isSlang = false;

    // 맵에 저장된 모든 금칙어 키셋을 하나씩 꺼내서 확인
    for (String forbidden : cacheMap.keySet()) {
      // ex) 이 부분이 핵심! "개같은"이 "개"를 포함하고 있는가?
      if (originalWord.contains(forbidden)) {
        GetWordRulesResponseDTO rule = cacheMap.get(forbidden);

        //대체 문장이 null일수 있다. (아예 빈칸 처리)
        String replacement = (rule.cleanWord() != null) ? rule.cleanWord() : "";

        // 포함되어 있다면 치환본으로 교체 ("개같은" -> "안좋은 등의 단어")
        filteredWord = filteredWord.replace(forbidden, replacement);

        isSlang = true;
        reason = rule.reason();
        // 여러 금칙어가 섞여 있을 수 있으니 break 하지 않고 계속 순회합니다.
      }
    }

    return new WordFilterResult(originalWord, filteredWord, isSlang, reason);

  }
}
