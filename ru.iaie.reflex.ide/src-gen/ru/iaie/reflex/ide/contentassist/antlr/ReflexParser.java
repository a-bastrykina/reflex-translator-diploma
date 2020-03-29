/*
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import ru.iaie.reflex.ide.contentassist.antlr.internal.InternalReflexParser;
import ru.iaie.reflex.services.ReflexGrammarAccess;

public class ReflexParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ReflexGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ReflexGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getProgramAccess().getAlternatives_4(), "rule__Program__Alternatives_4");
			builder.put(grammarAccess.getVariableAccess().getAlternatives_0(), "rule__Variable__Alternatives_0");
			builder.put(grammarAccess.getDeclaredVariableAccess().getAlternatives_0(), "rule__DeclaredVariable__Alternatives_0");
			builder.put(grammarAccess.getVisibilityAccess().getAlternatives(), "rule__Visibility__Alternatives");
			builder.put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
			builder.put(grammarAccess.getSetStateStatAccess().getAlternatives_2(), "rule__SetStateStat__Alternatives_2");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
			builder.put(grammarAccess.getUnaryExpressionAccess().getAlternatives(), "rule__UnaryExpression__Alternatives");
			builder.put(grammarAccess.getCastExpressionAccess().getAlternatives(), "rule__CastExpression__Alternatives");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getAlternatives(), "rule__AssignmentExpression__Alternatives");
			builder.put(grammarAccess.getCTypeAccess().getAlternatives(), "rule__CType__Alternatives");
			builder.put(grammarAccess.getCTypeAccess().getAlternatives_3_2(), "rule__CType__Alternatives_3_2");
			builder.put(grammarAccess.getIntegerTypeAccess().getAlternatives(), "rule__IntegerType__Alternatives");
			builder.put(grammarAccess.getReflexTypeAccess().getAlternatives(), "rule__ReflexType__Alternatives");
			builder.put(grammarAccess.getRegisterTypeAccess().getAlternatives(), "rule__RegisterType__Alternatives");
			builder.put(grammarAccess.getInfixPostfixOpAccess().getAlternatives(), "rule__InfixPostfixOp__Alternatives");
			builder.put(grammarAccess.getAssignOperatorAccess().getAlternatives(), "rule__AssignOperator__Alternatives");
			builder.put(grammarAccess.getUnaryOpAccess().getAlternatives(), "rule__UnaryOp__Alternatives");
			builder.put(grammarAccess.getCompareOpAccess().getAlternatives(), "rule__CompareOp__Alternatives");
			builder.put(grammarAccess.getCompareEqOpAccess().getAlternatives(), "rule__CompareEqOp__Alternatives");
			builder.put(grammarAccess.getShiftOpAccess().getAlternatives(), "rule__ShiftOp__Alternatives");
			builder.put(grammarAccess.getAdditiveOpAccess().getAlternatives(), "rule__AdditiveOp__Alternatives");
			builder.put(grammarAccess.getMultiplicativeOpAccess().getAlternatives(), "rule__MultiplicativeOp__Alternatives");
			builder.put(grammarAccess.getCTypeSignSpecAccess().getAlternatives(), "rule__CTypeSignSpec__Alternatives");
			builder.put(grammarAccess.getProgramAccess().getGroup(), "rule__Program__Group__0");
			builder.put(grammarAccess.getProcessAccess().getGroup(), "rule__Process__Group__0");
			builder.put(grammarAccess.getVariableAccess().getGroup(), "rule__Variable__Group__0");
			builder.put(grammarAccess.getImportedVariableAccess().getGroup(), "rule__ImportedVariable__Group__0");
			builder.put(grammarAccess.getImportedVariableAccess().getGroup_4(), "rule__ImportedVariable__Group_4__0");
			builder.put(grammarAccess.getDeclaredVariableAccess().getGroup(), "rule__DeclaredVariable__Group__0");
			builder.put(grammarAccess.getPhysicalVariableAccess().getGroup(), "rule__PhysicalVariable__Group__0");
			builder.put(grammarAccess.getPhysicalVariableAccess().getGroup_5(), "rule__PhysicalVariable__Group_5__0");
			builder.put(grammarAccess.getRegisterPortAccess().getGroup(), "rule__RegisterPort__Group__0");
			builder.put(grammarAccess.getProgramVariableAccess().getGroup(), "rule__ProgramVariable__Group__0");
			builder.put(grammarAccess.getVisibilityAccess().getGroup_2(), "rule__Visibility__Group_2__0");
			builder.put(grammarAccess.getVisibilityAccess().getGroup_2_2(), "rule__Visibility__Group_2_2__0");
			builder.put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
			builder.put(grammarAccess.getStatementSequenceAccess().getGroup(), "rule__StatementSequence__Group__0");
			builder.put(grammarAccess.getStatementBlockAccess().getGroup(), "rule__StatementBlock__Group__0");
			builder.put(grammarAccess.getTimeoutFunctionAccess().getGroup(), "rule__TimeoutFunction__Group__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_0(), "rule__Statement__Group_0__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_11(), "rule__Statement__Group_11__0");
			builder.put(grammarAccess.getIfElseStatAccess().getGroup(), "rule__IfElseStat__Group__0");
			builder.put(grammarAccess.getIfElseStatAccess().getGroup_5(), "rule__IfElseStat__Group_5__0");
			builder.put(grammarAccess.getSwitchStatAccess().getGroup(), "rule__SwitchStat__Group__0");
			builder.put(grammarAccess.getCaseStatAccess().getGroup(), "rule__CaseStat__Group__0");
			builder.put(grammarAccess.getBreakStatAccess().getGroup(), "rule__BreakStat__Group__0");
			builder.put(grammarAccess.getStartProcStatAccess().getGroup(), "rule__StartProcStat__Group__0");
			builder.put(grammarAccess.getStopProcStatAccess().getGroup(), "rule__StopProcStat__Group__0");
			builder.put(grammarAccess.getErrorStatAccess().getGroup(), "rule__ErrorStat__Group__0");
			builder.put(grammarAccess.getLoopStatAccess().getGroup(), "rule__LoopStat__Group__0");
			builder.put(grammarAccess.getRestartStatAccess().getGroup(), "rule__RestartStat__Group__0");
			builder.put(grammarAccess.getResetStatAccess().getGroup(), "rule__ResetStat__Group__0");
			builder.put(grammarAccess.getSetStateStatAccess().getGroup(), "rule__SetStateStat__Group__0");
			builder.put(grammarAccess.getSetStateStatAccess().getGroup_2_0(), "rule__SetStateStat__Group_2_0__0");
			builder.put(grammarAccess.getFunctionAccess().getGroup(), "rule__Function__Group__0");
			builder.put(grammarAccess.getFunctionAccess().getGroup_4(), "rule__Function__Group_4__0");
			builder.put(grammarAccess.getRegisterAccess().getGroup(), "rule__Register__Group__0");
			builder.put(grammarAccess.getConstAccess().getGroup(), "rule__Const__Group__0");
			builder.put(grammarAccess.getEnumAccess().getGroup(), "rule__Enum__Group__0");
			builder.put(grammarAccess.getEnumAccess().getGroup_4(), "rule__Enum__Group_4__0");
			builder.put(grammarAccess.getEnumMemberAccess().getGroup(), "rule__EnumMember__Group__0");
			builder.put(grammarAccess.getInfixOpAccess().getGroup(), "rule__InfixOp__Group__0");
			builder.put(grammarAccess.getPostfixOpAccess().getGroup(), "rule__PostfixOp__Group__0");
			builder.put(grammarAccess.getFunctionCallAccess().getGroup(), "rule__FunctionCall__Group__0");
			builder.put(grammarAccess.getFunctionCallAccess().getGroup_2(), "rule__FunctionCall__Group_2__0");
			builder.put(grammarAccess.getFunctionCallAccess().getGroup_2_1(), "rule__FunctionCall__Group_2_1__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_1(), "rule__PrimaryExpression__Group_1__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_2(), "rule__PrimaryExpression__Group_2__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_3(), "rule__PrimaryExpression__Group_3__0");
			builder.put(grammarAccess.getUnaryExpressionAccess().getGroup_4(), "rule__UnaryExpression__Group_4__0");
			builder.put(grammarAccess.getCastExpressionAccess().getGroup_1(), "rule__CastExpression__Group_1__0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
			builder.put(grammarAccess.getShiftExpressionAccess().getGroup(), "rule__ShiftExpression__Group__0");
			builder.put(grammarAccess.getShiftExpressionAccess().getGroup_1(), "rule__ShiftExpression__Group_1__0");
			builder.put(grammarAccess.getCompareExpressionAccess().getGroup(), "rule__CompareExpression__Group__0");
			builder.put(grammarAccess.getCompareExpressionAccess().getGroup_1(), "rule__CompareExpression__Group_1__0");
			builder.put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
			builder.put(grammarAccess.getEqualityExpressionAccess().getGroup_1(), "rule__EqualityExpression__Group_1__0");
			builder.put(grammarAccess.getBitAndExpressionAccess().getGroup(), "rule__BitAndExpression__Group__0");
			builder.put(grammarAccess.getBitAndExpressionAccess().getGroup_1(), "rule__BitAndExpression__Group_1__0");
			builder.put(grammarAccess.getBitXorExpressionAccess().getGroup(), "rule__BitXorExpression__Group__0");
			builder.put(grammarAccess.getBitXorExpressionAccess().getGroup_1(), "rule__BitXorExpression__Group_1__0");
			builder.put(grammarAccess.getBitOrExpressionAccess().getGroup(), "rule__BitOrExpression__Group__0");
			builder.put(grammarAccess.getBitOrExpressionAccess().getGroup_1(), "rule__BitOrExpression__Group_1__0");
			builder.put(grammarAccess.getLogicalAndExpressionAccess().getGroup(), "rule__LogicalAndExpression__Group__0");
			builder.put(grammarAccess.getLogicalAndExpressionAccess().getGroup_1(), "rule__LogicalAndExpression__Group_1__0");
			builder.put(grammarAccess.getLogicalOrExpressionAccess().getGroup(), "rule__LogicalOrExpression__Group__0");
			builder.put(grammarAccess.getLogicalOrExpressionAccess().getGroup_1(), "rule__LogicalOrExpression__Group_1__0");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getGroup_1(), "rule__AssignmentExpression__Group_1__0");
			builder.put(grammarAccess.getCTypeAccess().getGroup_0(), "rule__CType__Group_0__0");
			builder.put(grammarAccess.getCTypeAccess().getGroup_1(), "rule__CType__Group_1__0");
			builder.put(grammarAccess.getCTypeAccess().getGroup_2(), "rule__CType__Group_2__0");
			builder.put(grammarAccess.getCTypeAccess().getGroup_3(), "rule__CType__Group_3__0");
			builder.put(grammarAccess.getReflexTypeAccess().getGroup_1(), "rule__ReflexType__Group_1__0");
			builder.put(grammarAccess.getTactAccess().getGroup(), "rule__Tact__Group__0");
			builder.put(grammarAccess.getProgramAccess().getNameAssignment_1(), "rule__Program__NameAssignment_1");
			builder.put(grammarAccess.getProgramAccess().getTicksAssignment_3(), "rule__Program__TicksAssignment_3");
			builder.put(grammarAccess.getProgramAccess().getConstsAssignment_4_0(), "rule__Program__ConstsAssignment_4_0");
			builder.put(grammarAccess.getProgramAccess().getEnumsAssignment_4_1(), "rule__Program__EnumsAssignment_4_1");
			builder.put(grammarAccess.getProgramAccess().getFunctionsAssignment_4_2(), "rule__Program__FunctionsAssignment_4_2");
			builder.put(grammarAccess.getProgramAccess().getRegistersAssignment_4_3(), "rule__Program__RegistersAssignment_4_3");
			builder.put(grammarAccess.getProgramAccess().getProcessesAssignment_4_4(), "rule__Program__ProcessesAssignment_4_4");
			builder.put(grammarAccess.getProcessAccess().getNameAssignment_1(), "rule__Process__NameAssignment_1");
			builder.put(grammarAccess.getProcessAccess().getVariablesAssignment_3(), "rule__Process__VariablesAssignment_3");
			builder.put(grammarAccess.getProcessAccess().getStatesAssignment_4(), "rule__Process__StatesAssignment_4");
			builder.put(grammarAccess.getImportedVariableAccess().getProcIdAssignment_2(), "rule__ImportedVariable__ProcIdAssignment_2");
			builder.put(grammarAccess.getImportedVariableAccess().getVarNamesAssignment_3(), "rule__ImportedVariable__VarNamesAssignment_3");
			builder.put(grammarAccess.getImportedVariableAccess().getVarNamesAssignment_4_1(), "rule__ImportedVariable__VarNamesAssignment_4_1");
			builder.put(grammarAccess.getDeclaredVariableAccess().getVisibilityAssignment_1(), "rule__DeclaredVariable__VisibilityAssignment_1");
			builder.put(grammarAccess.getPhysicalVariableAccess().getTypeAssignment_0(), "rule__PhysicalVariable__TypeAssignment_0");
			builder.put(grammarAccess.getPhysicalVariableAccess().getNameAssignment_1(), "rule__PhysicalVariable__NameAssignment_1");
			builder.put(grammarAccess.getPhysicalVariableAccess().getPortsAssignment_4(), "rule__PhysicalVariable__PortsAssignment_4");
			builder.put(grammarAccess.getPhysicalVariableAccess().getPortsAssignment_5_1(), "rule__PhysicalVariable__PortsAssignment_5_1");
			builder.put(grammarAccess.getRegisterPortAccess().getRegNameAssignment_0(), "rule__RegisterPort__RegNameAssignment_0");
			builder.put(grammarAccess.getRegisterPortAccess().getPortAssignment_2(), "rule__RegisterPort__PortAssignment_2");
			builder.put(grammarAccess.getProgramVariableAccess().getTypeAssignment_0(), "rule__ProgramVariable__TypeAssignment_0");
			builder.put(grammarAccess.getProgramVariableAccess().getNameAssignment_1(), "rule__ProgramVariable__NameAssignment_1");
			builder.put(grammarAccess.getVisibilityAccess().getLOCALAssignment_0(), "rule__Visibility__LOCALAssignment_0");
			builder.put(grammarAccess.getVisibilityAccess().getGLOBALAssignment_1(), "rule__Visibility__GLOBALAssignment_1");
			builder.put(grammarAccess.getVisibilityAccess().getSHAREDAssignment_2_0(), "rule__Visibility__SHAREDAssignment_2_0");
			builder.put(grammarAccess.getVisibilityAccess().getSharingProcsAssignment_2_1(), "rule__Visibility__SharingProcsAssignment_2_1");
			builder.put(grammarAccess.getVisibilityAccess().getSharingProcsAssignment_2_2_1(), "rule__Visibility__SharingProcsAssignment_2_2_1");
			builder.put(grammarAccess.getStateAccess().getNameAssignment_1(), "rule__State__NameAssignment_1");
			builder.put(grammarAccess.getStateAccess().getStateFunctionAssignment_3(), "rule__State__StateFunctionAssignment_3");
			builder.put(grammarAccess.getStateAccess().getTimeoutFunctionAssignment_4(), "rule__State__TimeoutFunctionAssignment_4");
			builder.put(grammarAccess.getStatementSequenceAccess().getStatementsAssignment_1(), "rule__StatementSequence__StatementsAssignment_1");
			builder.put(grammarAccess.getStatementBlockAccess().getStatementsAssignment_2(), "rule__StatementBlock__StatementsAssignment_2");
			builder.put(grammarAccess.getTimeoutFunctionAccess().getTimeAssignment_1(), "rule__TimeoutFunction__TimeAssignment_1");
			builder.put(grammarAccess.getTimeoutFunctionAccess().getBodyAssignment_2(), "rule__TimeoutFunction__BodyAssignment_2");
			builder.put(grammarAccess.getIfElseStatAccess().getCondAssignment_2(), "rule__IfElseStat__CondAssignment_2");
			builder.put(grammarAccess.getIfElseStatAccess().getThenAssignment_4(), "rule__IfElseStat__ThenAssignment_4");
			builder.put(grammarAccess.getIfElseStatAccess().getElseAssignment_5_1(), "rule__IfElseStat__ElseAssignment_5_1");
			builder.put(grammarAccess.getSwitchStatAccess().getExprAssignment_2(), "rule__SwitchStat__ExprAssignment_2");
			builder.put(grammarAccess.getSwitchStatAccess().getOptionsAssignment_5(), "rule__SwitchStat__OptionsAssignment_5");
			builder.put(grammarAccess.getCaseStatAccess().getOptionAssignment_1(), "rule__CaseStat__OptionAssignment_1");
			builder.put(grammarAccess.getCaseStatAccess().getBodyAssignment_3(), "rule__CaseStat__BodyAssignment_3");
			builder.put(grammarAccess.getCaseStatAccess().getHasBreakAssignment_4(), "rule__CaseStat__HasBreakAssignment_4");
			builder.put(grammarAccess.getStartProcStatAccess().getProcIdAssignment_1(), "rule__StartProcStat__ProcIdAssignment_1");
			builder.put(grammarAccess.getStopProcStatAccess().getProcIdAssignment_2(), "rule__StopProcStat__ProcIdAssignment_2");
			builder.put(grammarAccess.getErrorStatAccess().getProcIdAssignment_2(), "rule__ErrorStat__ProcIdAssignment_2");
			builder.put(grammarAccess.getSetStateStatAccess().getStateIdAssignment_2_0_1(), "rule__SetStateStat__StateIdAssignment_2_0_1");
			builder.put(grammarAccess.getSetStateStatAccess().getNextAssignment_2_1(), "rule__SetStateStat__NextAssignment_2_1");
			builder.put(grammarAccess.getFunctionAccess().getReturnTypeAssignment_0(), "rule__Function__ReturnTypeAssignment_0");
			builder.put(grammarAccess.getFunctionAccess().getNameAssignment_1(), "rule__Function__NameAssignment_1");
			builder.put(grammarAccess.getFunctionAccess().getArgTypesAssignment_3(), "rule__Function__ArgTypesAssignment_3");
			builder.put(grammarAccess.getFunctionAccess().getArgTypesAssignment_4_1(), "rule__Function__ArgTypesAssignment_4_1");
			builder.put(grammarAccess.getRegisterAccess().getTypeAssignment_0(), "rule__Register__TypeAssignment_0");
			builder.put(grammarAccess.getRegisterAccess().getNameAssignment_1(), "rule__Register__NameAssignment_1");
			builder.put(grammarAccess.getRegisterAccess().getAddr1Assignment_2(), "rule__Register__Addr1Assignment_2");
			builder.put(grammarAccess.getRegisterAccess().getAddr2Assignment_3(), "rule__Register__Addr2Assignment_3");
			builder.put(grammarAccess.getRegisterAccess().getRegSizeAssignment_4(), "rule__Register__RegSizeAssignment_4");
			builder.put(grammarAccess.getConstAccess().getConstIdAssignment_1(), "rule__Const__ConstIdAssignment_1");
			builder.put(grammarAccess.getConstAccess().getConstValueAssignment_2(), "rule__Const__ConstValueAssignment_2");
			builder.put(grammarAccess.getEnumAccess().getEnumIdAssignment_1(), "rule__Enum__EnumIdAssignment_1");
			builder.put(grammarAccess.getEnumAccess().getEnumMembersAssignment_3(), "rule__Enum__EnumMembersAssignment_3");
			builder.put(grammarAccess.getEnumAccess().getEnumMembersAssignment_4_1(), "rule__Enum__EnumMembersAssignment_4_1");
			builder.put(grammarAccess.getEnumMemberAccess().getNameAssignment_0(), "rule__EnumMember__NameAssignment_0");
			builder.put(grammarAccess.getEnumMemberAccess().getValueAssignment_2(), "rule__EnumMember__ValueAssignment_2");
			builder.put(grammarAccess.getInfixOpAccess().getOpAssignment_0(), "rule__InfixOp__OpAssignment_0");
			builder.put(grammarAccess.getInfixOpAccess().getVarIdAssignment_1(), "rule__InfixOp__VarIdAssignment_1");
			builder.put(grammarAccess.getPostfixOpAccess().getVarIdAssignment_0(), "rule__PostfixOp__VarIdAssignment_0");
			builder.put(grammarAccess.getPostfixOpAccess().getOpAssignment_1(), "rule__PostfixOp__OpAssignment_1");
			builder.put(grammarAccess.getFunctionCallAccess().getFuncIdAssignment_0(), "rule__FunctionCall__FuncIdAssignment_0");
			builder.put(grammarAccess.getFunctionCallAccess().getArgsAssignment_2_0(), "rule__FunctionCall__ArgsAssignment_2_0");
			builder.put(grammarAccess.getFunctionCallAccess().getArgsAssignment_2_1_1(), "rule__FunctionCall__ArgsAssignment_2_1_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getVarIdAssignment_0(), "rule__PrimaryExpression__VarIdAssignment_0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getExprAssignment_3_1(), "rule__PrimaryExpression__ExprAssignment_3_1");
			builder.put(grammarAccess.getUnaryExpressionAccess().getUnaryOpAssignment_4_0(), "rule__UnaryExpression__UnaryOpAssignment_4_0");
			builder.put(grammarAccess.getUnaryExpressionAccess().getRestAssignment_4_1(), "rule__UnaryExpression__RestAssignment_4_1");
			builder.put(grammarAccess.getCastExpressionAccess().getTypeAssignment_1_1(), "rule__CastExpression__TypeAssignment_1_1");
			builder.put(grammarAccess.getCastExpressionAccess().getRightAssignment_1_3(), "rule__CastExpression__RightAssignment_1_3");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getMulOpAssignment_1_1(), "rule__MultiplicativeExpression__MulOpAssignment_1_1");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1_2(), "rule__MultiplicativeExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getAddOpAssignment_1_1(), "rule__AdditiveExpression__AddOpAssignment_1_1");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getRighttAssignment_1_2(), "rule__AdditiveExpression__RighttAssignment_1_2");
			builder.put(grammarAccess.getShiftExpressionAccess().getShiftOpAssignment_1_1(), "rule__ShiftExpression__ShiftOpAssignment_1_1");
			builder.put(grammarAccess.getShiftExpressionAccess().getRightAssignment_1_2(), "rule__ShiftExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getCompareExpressionAccess().getCmpOpAssignment_1_1(), "rule__CompareExpression__CmpOpAssignment_1_1");
			builder.put(grammarAccess.getCompareExpressionAccess().getRightAssignment_1_2(), "rule__CompareExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getEqualityExpressionAccess().getEqCmpOpAssignment_1_1(), "rule__EqualityExpression__EqCmpOpAssignment_1_1");
			builder.put(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1_2(), "rule__EqualityExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getBitAndExpressionAccess().getRightAssignment_1_2(), "rule__BitAndExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getBitXorExpressionAccess().getRightAssignment_1_2(), "rule__BitXorExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getBitOrExpressionAccess().getRightAssignment_1_2(), "rule__BitOrExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getLogicalAndExpressionAccess().getRightAssignment_1_2(), "rule__LogicalAndExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getLogicalOrExpressionAccess().getRightAssignment_1_2(), "rule__LogicalOrExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getAssignVarAssignment_1_0(), "rule__AssignmentExpression__AssignVarAssignment_1_0");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getAssignOpAssignment_1_1(), "rule__AssignmentExpression__AssignOpAssignment_1_1");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getExprAssignment_1_2(), "rule__AssignmentExpression__ExprAssignment_1_2");
			builder.put(grammarAccess.getCTypeAccess().getSignSpecAssignment_3_1(), "rule__CType__SignSpecAssignment_3_1");
			builder.put(grammarAccess.getTactAccess().getValueAssignment_1(), "rule__Tact__ValueAssignment_1");
			builder.put(grammarAccess.getTimeAccess().getTicksAssignment(), "rule__Time__TicksAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ReflexGrammarAccess grammarAccess;

	@Override
	protected InternalReflexParser createParser() {
		InternalReflexParser result = new InternalReflexParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public ReflexGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ReflexGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
