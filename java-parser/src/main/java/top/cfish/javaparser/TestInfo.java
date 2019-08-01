package top.cfish.javaparser;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/7/19
 * @time: 17:43
 */
@Getter
@Setter
public class TestInfo
{
    private String className;
    private List<MethodInfo> methodList;
}
