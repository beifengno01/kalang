// Generated from Kava.g4 by ANTLR 4.5
package kava.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KavaParser}.
 */
public interface KavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KavaParser#dslStatList}.
	 * @param ctx the parse tree
	 */
	void enterDslStatList(KavaParser.DslStatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#dslStatList}.
	 * @param ctx the parse tree
	 */
	void exitDslStatList(KavaParser.DslStatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#dslStat}.
	 * @param ctx the parse tree
	 */
	void enterDslStat(KavaParser.DslStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#dslStat}.
	 * @param ctx the parse tree
	 */
	void exitDslStat(KavaParser.DslStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslVarDecl}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslVarDecl(KavaParser.DslVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslVarDecl}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslVarDecl(KavaParser.DslVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslVarNew}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslVarNew(KavaParser.DslVarNewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslVarNew}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslVarNew(KavaParser.DslVarNewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslExpression}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslExpression(KavaParser.DslExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslExpression}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslExpression(KavaParser.DslExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslChainStat}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void enterDslChainStat(KavaParser.DslChainStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslChainStat}
	 * labeled alternative in {@link KavaParser#dslExpr}.
	 * @param ctx the parse tree
	 */
	void exitDslChainStat(KavaParser.DslChainStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#dslParam}.
	 * @param ctx the parse tree
	 */
	void enterDslParam(KavaParser.DslParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#dslParam}.
	 * @param ctx the parse tree
	 */
	void exitDslParam(KavaParser.DslParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(KavaParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(KavaParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompiliantUnit(KavaParser.CompiliantUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#compiliantUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompiliantUnit(KavaParser.CompiliantUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(KavaParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(KavaParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclList(KavaParser.MethodDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#methodDeclList}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclList(KavaParser.MethodDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(KavaParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(KavaParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(KavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(KavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDeclList(KavaParser.ArgumentDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#argumentDeclList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDeclList(KavaParser.ArgumentDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDecl(KavaParser.ArgumentDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#argumentDecl}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDecl(KavaParser.ArgumentDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(KavaParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(KavaParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(KavaParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(KavaParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void enterIfStatSuffix(KavaParser.IfStatSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#ifStatSuffix}.
	 * @param ctx the parse tree
	 */
	void exitIfStatSuffix(KavaParser.IfStatSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(KavaParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(KavaParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(KavaParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(KavaParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStat(KavaParser.VarDeclStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#varDeclStat}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStat(KavaParser.VarDeclStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(KavaParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(KavaParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(KavaParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#breakStat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(KavaParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void enterContinueStat(KavaParser.ContinueStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#continueStat}.
	 * @param ctx the parse tree
	 */
	void exitContinueStat(KavaParser.ContinueStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(KavaParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(KavaParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStat(KavaParser.DoWhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#doWhileStat}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStat(KavaParser.DoWhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(KavaParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(KavaParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(KavaParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(KavaParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(KavaParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(KavaParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(KavaParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(KavaParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(KavaParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#exprStat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(KavaParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPrimay(KavaParser.ExprPrimayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPrimay}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPrimay(KavaParser.ExprPrimayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssign(KavaParser.ArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssign(KavaParser.ArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMemberInvocation(KavaParser.ExprMemberInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMemberInvocation}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMemberInvocation(KavaParser.ExprMemberInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(KavaParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAssign}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(KavaParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMidOp(KavaParser.ExprMidOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMidOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMidOp(KavaParser.ExprMidOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprInvocation(KavaParser.ExprInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInvocation}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprInvocation(KavaParser.ExprInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNotOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNotOp(KavaParser.ExprNotOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNotOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNotOp(KavaParser.ExprNotOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetField(KavaParser.ExprGetFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetField}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetField(KavaParser.ExprGetFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLogicCmp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogicCmp(KavaParser.ExprLogicCmpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLogicCmp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogicCmp(KavaParser.ExprLogicCmpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOp(KavaParser.ExprSelfOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOp}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOp(KavaParser.ExprSelfOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogic(KavaParser.ExprLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogic(KavaParser.ExprLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprSelfOpPre(KavaParser.ExprSelfOpPreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSelfOpPre}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprSelfOpPre(KavaParser.ExprSelfOpPreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprGetArrayElement(KavaParser.ExprGetArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetArrayElement}
	 * labeled alternative in {@link KavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprGetArrayElement(KavaParser.ExprGetArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#offset}.
	 * @param ctx the parse tree
	 */
	void enterOffset(KavaParser.OffsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#offset}.
	 * @param ctx the parse tree
	 */
	void exitOffset(KavaParser.OffsetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimayParen(KavaParser.PrimayParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primayParen}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimayParen(KavaParser.PrimayParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryLiteral(KavaParser.PrimaryLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryLiteral(KavaParser.PrimaryLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryIdentifier(KavaParser.PrimaryIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link KavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryIdentifier(KavaParser.PrimaryIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(KavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(KavaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(KavaParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(KavaParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(KavaParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(KavaParser.ArgumentListContext ctx);
}