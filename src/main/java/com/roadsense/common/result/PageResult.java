package com.roadsense.common.result;

import lombok.Data;

import java.util.List;

/**
 * author  Edith
 * created  2023/12/26 19:18
 */
@Data
public class PageResult {
    private Long total;
    private List records;
}
