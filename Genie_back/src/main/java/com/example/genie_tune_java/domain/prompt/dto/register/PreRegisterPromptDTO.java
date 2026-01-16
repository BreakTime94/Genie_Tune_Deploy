package com.example.genie_tune_java.domain.prompt.dto.register;

import com.example.genie_tune_java.domain.prompt.entity.PromptStatus;
import com.example.genie_tune_java.domain.service_access.entity.ServiceAccess;

public record PreRegisterPromptDTO(
  ServiceAccess serviceAccess,
  String originalContent,
  String filteredContent,   // 비속어가 치환된 문장
  PromptStatus promptStatus,
  boolean isSlang
) {}
