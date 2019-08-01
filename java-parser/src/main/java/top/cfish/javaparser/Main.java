package top.cfish.javaparser;


import japa.parser.JavaParser;
import japa.parser.ast.*;
import japa.parser.ast.body.*;
import japa.parser.ast.expr.*;
import japa.parser.ast.stmt.*;
import japa.parser.ast.type.*;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/7/19
 * @time: 10:36
 */

// 正则搜索(?<=class)(.*?)(?=extends)
@Slf4j
public class Main
{
    public static void main(String[] args) throws Exception
    {
        File fileDirectory = new File("E:\\Github\\java-toy\\java-parser\\src\\main\\resources\\item\\publication");
        File[] inputFiles = fileDirectory.listFiles();
        if (inputFiles != null)
        {
            for (File file : inputFiles)
            {
                if ((file.getName().endsWith(".java")))
                {
                    log.info("开始解析: {}", file);
                    File f = new File(file.getPath());
                    FileInputStream in = new FileInputStream(f);
                    
                    CompilationUnit cu;
                    try
                    {
                        cu = JavaParser.parse(in, "UTF8");
                    }
                    finally
                    {
                        in.close();
                    }
                    
                    // 非常有用
                    // new JavadocCommentParser().visit(cu, null);
                    // new BlockStmtParser().visit(cu, null);
                    new ClassOrInterfaceDeclarationParser().visit(cu, null);
                    
                    ///////////////////////////////////////////////////////
                    
                    // 一般
                    // new ClassOrInterfaceTypeParser().visit(cu, null);
                    // new CompilationUnitParser().visit(cu, null);
                    
                    
                    // 未测试
                    // new ExpressionStmtParser().visit(cu, null);
                    // new FieldAccessExprParser().visit(cu, null);
                    // new ImportDeclarationParser().visit(cu, null);
                    // new IntegerLiteralExprParser().visit(cu, null);
                    // new MarkerAnnotationExprParser().visit(cu, null);
                    // new MethodCallExprParser().visit(cu, null);
                    // new MethodDeclarationParser().visit(cu, null);
                    // new NameExprParser().visit(cu, null);
                    // new ObjectCreationExprParser().visit(cu, null);
                    // new QualifiedNameExprParser().visit(cu, null);
                    // new ReferenceTypeParser().visit(cu, null);
                    // new StringLiteralExprParser().visit(cu, null);
                    // new VariableDeclarationExprParser().visit(cu, null);
                    // new VariableDeclaratorParser().visit(cu, null);
                    // new VariableDeclaratorIdParser().visit(cu, null);
                    // new VoidTypeParser().visit(cu, null);
                    
                    // 无用
                    // new AnnotationDeclarationParser().visit(cu, null);
                    // new AnnotationMemberDeclarationParser().visit(cu, null);
                    // new ArrayAccessExprParser().visit(cu, null);
                    // new ArrayCreationExprParser().visit(cu, null);
                    // new ArrayInitializerExprParser().visit(cu, null);
                    // new AssertStmtParser().visit(cu, null);
                    // new AssignExprParser().visit(cu, null);
                    // new BinaryExprParser().visit(cu, null);
                    // new BlockCommentParser().visit(cu, null);
                    // new BooleanLiteralExprParser().visit(cu, null);
                    // new BreakStmtParser().visit(cu, null);
                    // new CastExprParser().visit(cu, null);
                    // new CatchClauseParser().visit(cu, null);
                    // new CharLiteralExprParser().visit(cu, null);
                    // new ClassExprParser().visit(cu, null);
                    // new ConditionalExprParser().visit(cu, null);
                    // new ConstructorDeclarationParser().visit(cu, null);
                    // new ContinueStmtParser().visit(cu, null);
                    // new DoStmtParser().visit(cu, null);
                    // new DoubleLiteralExprParser().visit(cu, null);
                    // new EmptyMemberDeclarationParser().visit(cu, null);
                    // new EmptyStmtParser().visit(cu, null);
                    // new EmptyTypeDeclarationParser().visit(cu, null);
                    // new EnclosedExprParser().visit(cu, null);
                    // new EnumConstantDeclarationParser().visit(cu, null);
                    // new EnumDeclarationParser().visit(cu, null);
                    // new ExplicitConstructorInvocationStmtParser().visit(cu, null);
                    // new FieldDeclarationParser().visit(cu, null);
                    // new ForeachStmtParser().visit(cu, null);
                    // new ForStmtParser().visit(cu, null);
                    // new IfStmtParser().visit(cu, null);
                    // new InitializerDeclarationParser().visit(cu, null);
                    // new InstanceOfExprParser().visit(cu, null);
                    // new IntegerLiteralMinValueExprParser().visit(cu, null);
                    // new LabeledStmtParser().visit(cu, null);
                    // new LineCommentParser().visit(cu, null);
                    // new LongLiteralExprParser().visit(cu, null);
                    // new LongLiteralMinValueExprParser().visit(cu, null);
                    // new MemberValuePairParser().visit(cu, null);
                    // new NormalAnnotationExprParser().visit(cu, null);
                    // new NullLiteralExprParser().visit(cu, null);
                    // new PackageDeclarationParser().visit(cu, null);
                    // new ParameterParser().visit(cu, null);
                    // new PrimitiveTypeParser().visit(cu, null);
                    // new ReturnStmtParser().visit(cu, null);
                    // new SingleMemberAnnotationExprParser().visit(cu, null);
                    // new SuperExprParser().visit(cu, null);
                    // new SwitchEntryStmtParser().visit(cu, null);
                    // new SwitchStmtParser().visit(cu, null);
                    // new SynchronizedStmtParser().visit(cu, null);
                    // new ThisExprParser().visit(cu, null);
                    // new ThrowStmtParser().visit(cu, null);
                    // new TryStmtParser().visit(cu, null);
                    // new TypeDeclarationStmtParser().visit(cu, null);
                    // new TypeParameterParser().visit(cu, null);
                    // new UnaryExprParser().visit(cu, null);
                    // new WhileStmtParser().visit(cu, null);
                    // new WildcardTypeParser().visit(cu, null);
                }
                log.info("############################################################");
            }
        }
    }
    
    // 有用，基本所有东西都能读取
    private static class ClassOrInterfaceDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ClassOrInterfaceDeclaration n, Object arg)
        {
            log.info("类名: {}", n.getName());
            log.info("注释: {}", n.getJavaDoc());
            log.info("方法数量： {}", n.getMembers().size());
    
            List<BodyDeclaration> methodList = n.getMembers();
    
            log.info("进入方法列表处理");
            for (BodyDeclaration method : methodList)
            {
                log.info("方法名: {}", ((MethodDeclaration)method).getName());
                List<Statement> stmts = ((MethodDeclaration)method).getBody().getStmts();
                if (stmts != null && stmts.size() != 0)
                {
                    for (Statement stmt : stmts)
                    {
                        //log.info("{}", stmt);
        
                        Expression expression = ((ExpressionStmt)stmt).getExpression();
        
                        if (expression instanceof MethodCallExpr)
                        {
                            MethodCallExpr expr = (MethodCallExpr)expression;
                            String scopeName = null;
                            if (expr.getScope() != null)
                            {
                                scopeName = expr.getScope().toString();
                            }
                            String name = expr.getName();
                            if ("setVersion".equals(name))
                            {
                                log.info("sdk版本号: {}", expr.getArgs().get(0).toString());
                            }
                            if ("request".equals(scopeName))
                            {
                                log.info("set表达式: {}", expr.toString());
                            }
                        }
                        else if (expression instanceof VariableDeclarationExpr)
                        {
                            VariableDeclarationExpr expr = (VariableDeclarationExpr)expression;
                            String typeName = ((ClassOrInterfaceType)((ReferenceType)((VariableDeclarationExpr)expression).getType()).getType()).getName();
            
                            if ("CaseId".equals(typeName))
                            {
                                log.info("CaseId: {}", ((ObjectCreationExpr)expr.getVars().get(0).getInit()).getArgs().get(0));
                            }
                            else if ("SdkClient".equals(typeName))
                            {
                                log.info("sdk客户端: {}", ((FieldAccessExpr)expr.getVars().get(0).getInit()).getField());
                            }
                            else if (typeName.endsWith("Request"))
                            {
                                log.info("Request 对象名: {}", typeName);
                            }
                        }
                    }
                }
                log.info("################");
            }
            
            super.visit(n, arg);
        }
    }
    
    private static class JavadocCommentParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(JavadocComment n, Object arg)
        {
            String comment = n.toString();
            log.info("注释信息:\r\n{}", comment);
            super.visit(n, arg);
        }
    }
    
    // 有多个方法，会被自动调用多次
    private static class BlockStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(BlockStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    
    private static class AnnotationDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(AnnotationDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class AnnotationMemberDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(AnnotationMemberDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ArrayAccessExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ArrayAccessExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ArrayCreationExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ArrayCreationExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ArrayInitializerExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ArrayInitializerExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class AssertStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(AssertStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class AssignExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(AssignExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class BinaryExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(BinaryExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class BlockCommentParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(BlockComment n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    
    private static class BooleanLiteralExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(BooleanLiteralExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class BreakStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(BreakStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class CastExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(CastExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class CatchClauseParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(CatchClause n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class CharLiteralExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(CharLiteralExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ClassExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ClassExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    
    private static class ClassOrInterfaceTypeParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ClassOrInterfaceType n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class CompilationUnitParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(CompilationUnit n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ConditionalExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ConditionalExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ConstructorDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ConstructorDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ContinueStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ContinueStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class DoStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(DoStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class DoubleLiteralExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(DoubleLiteralExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class EmptyMemberDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(EmptyMemberDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class EmptyStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(EmptyStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class EmptyTypeDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(EmptyTypeDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class EnclosedExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(EnclosedExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class EnumConstantDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(EnumConstantDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class EnumDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(EnumDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ExplicitConstructorInvocationStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ExplicitConstructorInvocationStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ExpressionStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ExpressionStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class FieldAccessExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(FieldAccessExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class FieldDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(FieldDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ForeachStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ForeachStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ForStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ForStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class IfStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(IfStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ImportDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ImportDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class InitializerDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(InitializerDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class InstanceOfExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(InstanceOfExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class IntegerLiteralExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(IntegerLiteralExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class IntegerLiteralMinValueExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(IntegerLiteralMinValueExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class LabeledStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(LabeledStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class LineCommentParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(LineComment n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class LongLiteralExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(LongLiteralExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class LongLiteralMinValueExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(LongLiteralMinValueExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class MarkerAnnotationExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(MarkerAnnotationExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class MemberValuePairParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(MemberValuePair n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class MethodCallExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(MethodCallExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class MethodDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(MethodDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class NameExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(NameExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class NormalAnnotationExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(NormalAnnotationExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class NullLiteralExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(NullLiteralExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ObjectCreationExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ObjectCreationExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class PackageDeclarationParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(PackageDeclaration n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ParameterParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(Parameter n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class PrimitiveTypeParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(PrimitiveType n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class QualifiedNameExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(QualifiedNameExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ReferenceTypeParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ReferenceType n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ReturnStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ReturnStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class SingleMemberAnnotationExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(SingleMemberAnnotationExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class StringLiteralExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(StringLiteralExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class SuperExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(SuperExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class SwitchEntryStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(SwitchEntryStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class SwitchStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(SwitchStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class SynchronizedStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(SynchronizedStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ThisExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ThisExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class ThrowStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(ThrowStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class TryStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(TryStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class TypeDeclarationStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(TypeDeclarationStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class TypeParameterParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(TypeParameter n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class UnaryExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(UnaryExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class VariableDeclarationExprParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(VariableDeclarationExpr n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class VariableDeclaratorParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(VariableDeclarator n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class VariableDeclaratorIdParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(VariableDeclaratorId n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class VoidTypeParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(VoidType n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class WhileStmtParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(WhileStmt n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
    
    private static class WildcardTypeParser extends VoidVisitorAdapter
    {
        @Override
        public void visit(WildcardType n, Object arg)
        {
            log.info("{}", n);
            super.visit(n, arg);
        }
    }
}
