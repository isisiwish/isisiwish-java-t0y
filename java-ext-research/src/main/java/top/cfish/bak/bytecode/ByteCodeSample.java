package top.cfish.bak.bytecode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ByteCodeSample
{
    public static void main(String[] args)
    {
        int i = 1, j = 5;
        i++;
        ++j;
        log.info("{}", i);
        log.info("{}", j);
    }
}
