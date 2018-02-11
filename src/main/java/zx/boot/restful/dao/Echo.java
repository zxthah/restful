package zx.boot.restful.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Echo {
    private final long id;
    private final String content;
}
