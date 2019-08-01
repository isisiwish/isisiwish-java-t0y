package top.cfish.mybatisplugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: isisiwish
 * @date: 2017/9/13
 * @time: 18:20
 */
public class LombokPlugin extends PluginAdapter
{
    private static final String AUTHOR = "isisiwish";
    
    @Override
    public boolean validate(List<String> list)
    {
        return true;
    }
    
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
    {
        topLevelClass.addImportedType("lombok.Getter");
        topLevelClass.addImportedType("lombok.Setter");
        topLevelClass.addImportedType("lombok.ToString");
        
        topLevelClass.addAnnotation("@Getter");
        topLevelClass.addAnnotation("@Setter");
        topLevelClass.addAnnotation("@ToString");
        
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @author: " + AUTHOR);
        topLevelClass.addJavaDocLine(" * @date: " + dateToDateStr(new Date()));
        topLevelClass.addJavaDocLine(" * @time: " + dateToTimeStr(new Date()));
        topLevelClass.addJavaDocLine(" */");
        
        return true;
    }
    
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
    {
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine(" * @author: " + AUTHOR);
        interfaze.addJavaDocLine(" * @date: " + dateToDateStr(new Date()));
        interfaze.addJavaDocLine(" * @time: " + dateToTimeStr(new Date()));
        interfaze.addJavaDocLine(" */");
        return true;
    }
    
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType)
    {
        return false;
    }
    
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType)
    {
        return false;
    }
    
    private String dateToDateStr(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(date);
    }
    
    private String dateToTimeStr(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(date);
    }
}
