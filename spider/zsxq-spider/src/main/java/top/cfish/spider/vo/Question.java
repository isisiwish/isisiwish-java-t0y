package top.cfish.spider.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question
{
    private Questionee questionee;
    private String text;
    private List<Images> images;
}
