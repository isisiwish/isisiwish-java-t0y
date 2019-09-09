package top.cfish.spider.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Task
{
    private Owner owner;
    private String text;
    private List<Files> files;
    private List<Images> images;
}
