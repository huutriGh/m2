package com.aptech.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true,fluent = true)
@AllArgsConstructor
public class Topic implements Serializable {
    private int id;
    private String title;
    private  String url;

}
