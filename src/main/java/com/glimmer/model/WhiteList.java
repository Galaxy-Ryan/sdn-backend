package com.glimmer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
public class WhiteList implements Serializable {
    //表示序列化的版本UID
    private static final long serialVersionUID = 1L;

}
