package jm.batchserver.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Station {
  private final Long id;
  private final String name;
}

