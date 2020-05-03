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
			builder.put(grammarAccess.getProgramAccess().getAlternatives_5(), "rule__Program__Alternatives_5");
			builder.put(grammarAccess.getProcessVariableAccess().getAlternatives_0(), "rule__ProcessVariable__Alternatives_0");
			builder.put(grammarAccess.getDeclaredVariableAccess().getAlternatives_0(), "rule__DeclaredVariable__Alternatives_0");
			builder.put(grammarAccess.getGlobalVariableAccess().getAlternatives_0(), "rule__GlobalVariable__Alternatives_0");
			builder.put(grammarAccess.getTimeoutFunctionAccess().getAlternatives_1(), "rule__TimeoutFunction__Alternatives_1");
			builder.put(grammarAccess.getTimeAmountOrRefAccess().getAlternatives(), "rule__TimeAmountOrRef__Alternatives");
			builder.put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
			builder.put(grammarAccess.getSetStateStatAccess().getAlternatives_2(), "rule__SetStateStat__Alternatives_2");
			builder.put(grammarAccess.getIdReferenceAccess().getAlternatives(), "rule__IdReference__Alternatives");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
			builder.put(grammarAccess.getUnaryExpressionAccess().getAlternatives(), "rule__UnaryExpression__Alternatives");
			builder.put(grammarAccess.getCastExpressionAccess().getAlternatives(), "rule__CastExpression__Alternatives");
			builder.put(grammarAccess.getCompareExpressionAccess().getAlternatives(), "rule__CompareExpression__Alternatives");
			builder.put(grammarAccess.getCTypeAccess().getAlternatives(), "rule__CType__Alternatives");
			builder.put(grammarAccess.getCTypeAccess().getAlternatives_3_2(), "rule__CType__Alternatives_3_2");
			builder.put(grammarAccess.getIntegerTypeAccess().getAlternatives(), "rule__IntegerType__Alternatives");
			builder.put(grammarAccess.getReflexTypeAccess().getAlternatives(), "rule__ReflexType__Alternatives");
			builder.put(grammarAccess.getAnnotationAccess().getAlternatives(), "rule__Annotation__Alternatives");
			builder.put(grammarAccess.getAnnotationKeyAccess().getAlternatives(), "rule__AnnotationKey__Alternatives");
			builder.put(grammarAccess.getRegisterTypeAccess().getAlternatives(), "rule__RegisterType__Alternatives");
			builder.put(grammarAccess.getStateQualifierAccess().getAlternatives(), "rule__StateQualifier__Alternatives");
			builder.put(grammarAccess.getInfixPostfixOpAccess().getAlternatives(), "rule__InfixPostfixOp__Alternatives");
			builder.put(grammarAccess.getAssignOperatorAccess().getAlternatives(), "rule__AssignOperator__Alternatives");
			builder.put(grammarAccess.getUnaryOpAccess().getAlternatives(), "rule__UnaryOp__Alternatives");
			builder.put(grammarAccess.getCompareOpAccess().getAlternatives(), "rule__CompareOp__Alternatives");
			builder.put(grammarAccess.getCompareEqOpAccess().getAlternatives(), "rule__CompareEqOp__Alternatives");
			builder.put(grammarAccess.getShiftOpAccess().getAlternatives(), "rule__ShiftOp__Alternatives");
			builder.put(grammarAccess.getAdditiveOpAccess().getAlternatives(), "rule__AdditiveOp__Alternatives");
			builder.put(grammarAccess.getMultiplicativeOpAccess().getAlternatives(), "rule__MultiplicativeOp__Alternatives");
			builder.put(grammarAccess.getBoolLiteralAccess().getAlternatives(), "rule__BoolLiteral__Alternatives");
			builder.put(grammarAccess.getCTypeSignSpecAccess().getAlternatives(), "rule__CTypeSignSpec__Alternatives");
			builder.put(grammarAccess.getProgramAccess().getGroup(), "rule__Program__Group__0");
			builder.put(grammarAccess.getProgramAccess().getGroup_0(), "rule__Program__Group_0__0");
			builder.put(grammarAccess.getProcessAccess().getGroup(), "rule__Process__Group__0");
			builder.put(grammarAccess.getProcessAccess().getGroup_0(), "rule__Process__Group_0__0");
			builder.put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
			builder.put(grammarAccess.getStateAccess().getGroup_0(), "rule__State__Group_0__0");
			builder.put(grammarAccess.getProcessVariableAccess().getGroup(), "rule__ProcessVariable__Group__0");
			builder.put(grammarAccess.getImportedVariableAccess().getGroup(), "rule__ImportedVariable__Group__0");
			builder.put(grammarAccess.getImportedVariableAccess().getGroup_1(), "rule__ImportedVariable__Group_1__0");
			builder.put(grammarAccess.getImportedVariableAccess().getGroup_1_1(), "rule__ImportedVariable__Group_1_1__0");
			builder.put(grammarAccess.getDeclaredVariableAccess().getGroup(), "rule__DeclaredVariable__Group__0");
			builder.put(grammarAccess.getGlobalVariableAccess().getGroup(), "rule__GlobalVariable__Group__0");
			builder.put(grammarAccess.getPhysicalVariableAccess().getGroup(), "rule__PhysicalVariable__Group__0");
			builder.put(grammarAccess.getRegisterPortMappingAccess().getGroup(), "rule__RegisterPortMapping__Group__0");
			builder.put(grammarAccess.getRegisterPortMappingAccess().getGroup_1(), "rule__RegisterPortMapping__Group_1__0");
			builder.put(grammarAccess.getProgramVariableAccess().getGroup(), "rule__ProgramVariable__Group__0");
			builder.put(grammarAccess.getStatementSequenceAccess().getGroup(), "rule__StatementSequence__Group__0");
			builder.put(grammarAccess.getCompoundStatementAccess().getGroup(), "rule__CompoundStatement__Group__0");
			builder.put(grammarAccess.getTimeoutFunctionAccess().getGroup(), "rule__TimeoutFunction__Group__0");
			builder.put(grammarAccess.getTimeoutFunctionAccess().getGroup_1_1(), "rule__TimeoutFunction__Group_1_1__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_0(), "rule__Statement__Group_0__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_10(), "rule__Statement__Group_10__0");
			builder.put(grammarAccess.getIfElseStatAccess().getGroup(), "rule__IfElseStat__Group__0");
			builder.put(grammarAccess.getIfElseStatAccess().getGroup_5(), "rule__IfElseStat__Group_5__0");
			builder.put(grammarAccess.getSwitchStatAccess().getGroup(), "rule__SwitchStat__Group__0");
			builder.put(grammarAccess.getCaseStatAccess().getGroup(), "rule__CaseStat__Group__0");
			builder.put(grammarAccess.getBreakStatAccess().getGroup(), "rule__BreakStat__Group__0");
			builder.put(grammarAccess.getStartProcStatAccess().getGroup(), "rule__StartProcStat__Group__0");
			builder.put(grammarAccess.getStopProcStatAccess().getGroup(), "rule__StopProcStat__Group__0");
			builder.put(grammarAccess.getStopProcStatAccess().getGroup_2(), "rule__StopProcStat__Group_2__0");
			builder.put(grammarAccess.getErrorStatAccess().getGroup(), "rule__ErrorStat__Group__0");
			builder.put(grammarAccess.getErrorStatAccess().getGroup_2(), "rule__ErrorStat__Group_2__0");
			builder.put(grammarAccess.getRestartStatAccess().getGroup(), "rule__RestartStat__Group__0");
			builder.put(grammarAccess.getResetStatAccess().getGroup(), "rule__ResetStat__Group__0");
			builder.put(grammarAccess.getSetStateStatAccess().getGroup(), "rule__SetStateStat__Group__0");
			builder.put(grammarAccess.getSetStateStatAccess().getGroup_2_0(), "rule__SetStateStat__Group_2_0__0");
			builder.put(grammarAccess.getSetStateStatAccess().getGroup_2_1(), "rule__SetStateStat__Group_2_1__0");
			builder.put(grammarAccess.getFunctionAccess().getGroup(), "rule__Function__Group__0");
			builder.put(grammarAccess.getFunctionAccess().getGroup_4(), "rule__Function__Group_4__0");
			builder.put(grammarAccess.getRegisterAccess().getGroup(), "rule__Register__Group__0");
			builder.put(grammarAccess.getConstAccess().getGroup(), "rule__Const__Group__0");
			builder.put(grammarAccess.getEnumAccess().getGroup(), "rule__Enum__Group__0");
			builder.put(grammarAccess.getEnumAccess().getGroup_4(), "rule__Enum__Group_4__0");
			builder.put(grammarAccess.getEnumMemberAccess().getGroup(), "rule__EnumMember__Group__0");
			builder.put(grammarAccess.getEnumMemberAccess().getGroup_1(), "rule__EnumMember__Group_1__0");
			builder.put(grammarAccess.getInfixOpAccess().getGroup(), "rule__InfixOp__Group__0");
			builder.put(grammarAccess.getPostfixOpAccess().getGroup(), "rule__PostfixOp__Group__0");
			builder.put(grammarAccess.getFunctionCallAccess().getGroup(), "rule__FunctionCall__Group__0");
			builder.put(grammarAccess.getFunctionCallAccess().getGroup_2(), "rule__FunctionCall__Group_2__0");
			builder.put(grammarAccess.getFunctionCallAccess().getGroup_2_1(), "rule__FunctionCall__Group_2_1__0");
			builder.put(grammarAccess.getCheckStateExpressionAccess().getGroup(), "rule__CheckStateExpression__Group__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_1(), "rule__PrimaryExpression__Group_1__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_2(), "rule__PrimaryExpression__Group_2__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_3(), "rule__PrimaryExpression__Group_3__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_4(), "rule__PrimaryExpression__Group_4__0");
			builder.put(grammarAccess.getUnaryExpressionAccess().getGroup_4(), "rule__UnaryExpression__Group_4__0");
			builder.put(grammarAccess.getCastExpressionAccess().getGroup_1(), "rule__CastExpression__Group_1__0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
			builder.put(grammarAccess.getShiftExpressionAccess().getGroup(), "rule__ShiftExpression__Group__0");
			builder.put(grammarAccess.getShiftExpressionAccess().getGroup_1(), "rule__ShiftExpression__Group_1__0");
			builder.put(grammarAccess.getCompareExpressionAccess().getGroup_1(), "rule__CompareExpression__Group_1__0");
			builder.put(grammarAccess.getCompareExpressionAccess().getGroup_1_1(), "rule__CompareExpression__Group_1_1__0");
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
			builder.put(grammarAccess.getAssignmentExpressionAccess().getGroup(), "rule__AssignmentExpression__Group__0");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getGroup_0(), "rule__AssignmentExpression__Group_0__0");
			builder.put(grammarAccess.getCTypeAccess().getGroup_0(), "rule__CType__Group_0__0");
			builder.put(grammarAccess.getCTypeAccess().getGroup_1(), "rule__CType__Group_1__0");
			builder.put(grammarAccess.getCTypeAccess().getGroup_2(), "rule__CType__Group_2__0");
			builder.put(grammarAccess.getCTypeAccess().getGroup_3(), "rule__CType__Group_3__0");
			builder.put(grammarAccess.getReflexTypeAccess().getGroup_1(), "rule__ReflexType__Group_1__0");
			builder.put(grammarAccess.getTactAccess().getGroup(), "rule__Tact__Group__0");
			builder.put(grammarAccess.getAnnotationAccess().getGroup_0(), "rule__Annotation__Group_0__0");
			builder.put(grammarAccess.getAnnotationKeyAccess().getGroup_0(), "rule__AnnotationKey__Group_0__0");
			builder.put(grammarAccess.getProgramAccess().getAnnotationsAssignment_0_1(), "rule__Program__AnnotationsAssignment_0_1");
			builder.put(grammarAccess.getProgramAccess().getNameAssignment_2(), "rule__Program__NameAssignment_2");
			builder.put(grammarAccess.getProgramAccess().getTicksAssignment_4(), "rule__Program__TicksAssignment_4");
			builder.put(grammarAccess.getProgramAccess().getConstsAssignment_5_0(), "rule__Program__ConstsAssignment_5_0");
			builder.put(grammarAccess.getProgramAccess().getEnumsAssignment_5_1(), "rule__Program__EnumsAssignment_5_1");
			builder.put(grammarAccess.getProgramAccess().getFunctionsAssignment_5_2(), "rule__Program__FunctionsAssignment_5_2");
			builder.put(grammarAccess.getProgramAccess().getGlobalVarsAssignment_5_3(), "rule__Program__GlobalVarsAssignment_5_3");
			builder.put(grammarAccess.getProgramAccess().getRegistersAssignment_5_4(), "rule__Program__RegistersAssignment_5_4");
			builder.put(grammarAccess.getProgramAccess().getProcessesAssignment_5_5(), "rule__Program__ProcessesAssignment_5_5");
			builder.put(grammarAccess.getProcessAccess().getAnnotationsAssignment_0_1(), "rule__Process__AnnotationsAssignment_0_1");
			builder.put(grammarAccess.getProcessAccess().getNameAssignment_2(), "rule__Process__NameAssignment_2");
			builder.put(grammarAccess.getProcessAccess().getVariablesAssignment_4(), "rule__Process__VariablesAssignment_4");
			builder.put(grammarAccess.getProcessAccess().getStatesAssignment_5(), "rule__Process__StatesAssignment_5");
			builder.put(grammarAccess.getStateAccess().getAnnotationsAssignment_0_1(), "rule__State__AnnotationsAssignment_0_1");
			builder.put(grammarAccess.getStateAccess().getNameAssignment_2(), "rule__State__NameAssignment_2");
			builder.put(grammarAccess.getStateAccess().getLoopedAssignment_3(), "rule__State__LoopedAssignment_3");
			builder.put(grammarAccess.getStateAccess().getStateFunctionAssignment_5(), "rule__State__StateFunctionAssignment_5");
			builder.put(grammarAccess.getStateAccess().getTimeoutFunctionAssignment_6(), "rule__State__TimeoutFunctionAssignment_6");
			builder.put(grammarAccess.getImportedVariableAccess().getVariablesAssignment_1_0(), "rule__ImportedVariable__VariablesAssignment_1_0");
			builder.put(grammarAccess.getImportedVariableAccess().getVariablesAssignment_1_1_1(), "rule__ImportedVariable__VariablesAssignment_1_1_1");
			builder.put(grammarAccess.getImportedVariableAccess().getProcessAssignment_4(), "rule__ImportedVariable__ProcessAssignment_4");
			builder.put(grammarAccess.getDeclaredVariableAccess().getSharedAssignment_1(), "rule__DeclaredVariable__SharedAssignment_1");
			builder.put(grammarAccess.getPhysicalVariableAccess().getTypeAssignment_0(), "rule__PhysicalVariable__TypeAssignment_0");
			builder.put(grammarAccess.getPhysicalVariableAccess().getNameAssignment_1(), "rule__PhysicalVariable__NameAssignment_1");
			builder.put(grammarAccess.getPhysicalVariableAccess().getPortAssignment_3(), "rule__PhysicalVariable__PortAssignment_3");
			builder.put(grammarAccess.getRegisterPortMappingAccess().getRegisterAssignment_0(), "rule__RegisterPortMapping__RegisterAssignment_0");
			builder.put(grammarAccess.getRegisterPortMappingAccess().getPortBitAssignment_1_1(), "rule__RegisterPortMapping__PortBitAssignment_1_1");
			builder.put(grammarAccess.getProgramVariableAccess().getTypeAssignment_0(), "rule__ProgramVariable__TypeAssignment_0");
			builder.put(grammarAccess.getProgramVariableAccess().getNameAssignment_1(), "rule__ProgramVariable__NameAssignment_1");
			builder.put(grammarAccess.getStatementSequenceAccess().getStatementsAssignment_1(), "rule__StatementSequence__StatementsAssignment_1");
			builder.put(grammarAccess.getCompoundStatementAccess().getStatementsAssignment_2(), "rule__CompoundStatement__StatementsAssignment_2");
			builder.put(grammarAccess.getTimeoutFunctionAccess().getBodyAssignment_2(), "rule__TimeoutFunction__BodyAssignment_2");
			builder.put(grammarAccess.getTimeAmountOrRefAccess().getTimeAssignment_0(), "rule__TimeAmountOrRef__TimeAssignment_0");
			builder.put(grammarAccess.getTimeAmountOrRefAccess().getRefAssignment_1(), "rule__TimeAmountOrRef__RefAssignment_1");
			builder.put(grammarAccess.getIfElseStatAccess().getCondAssignment_2(), "rule__IfElseStat__CondAssignment_2");
			builder.put(grammarAccess.getIfElseStatAccess().getThenAssignment_4(), "rule__IfElseStat__ThenAssignment_4");
			builder.put(grammarAccess.getIfElseStatAccess().getElseAssignment_5_1(), "rule__IfElseStat__ElseAssignment_5_1");
			builder.put(grammarAccess.getSwitchStatAccess().getExprAssignment_2(), "rule__SwitchStat__ExprAssignment_2");
			builder.put(grammarAccess.getSwitchStatAccess().getOptionsAssignment_5(), "rule__SwitchStat__OptionsAssignment_5");
			builder.put(grammarAccess.getCaseStatAccess().getOptionAssignment_1(), "rule__CaseStat__OptionAssignment_1");
			builder.put(grammarAccess.getCaseStatAccess().getBodyAssignment_3(), "rule__CaseStat__BodyAssignment_3");
			builder.put(grammarAccess.getCaseStatAccess().getHasBreakAssignment_4(), "rule__CaseStat__HasBreakAssignment_4");
			builder.put(grammarAccess.getStartProcStatAccess().getProcessAssignment_2(), "rule__StartProcStat__ProcessAssignment_2");
			builder.put(grammarAccess.getStopProcStatAccess().getProcessAssignment_2_1(), "rule__StopProcStat__ProcessAssignment_2_1");
			builder.put(grammarAccess.getErrorStatAccess().getProcessAssignment_2_1(), "rule__ErrorStat__ProcessAssignment_2_1");
			builder.put(grammarAccess.getSetStateStatAccess().getNextAssignment_2_0_0(), "rule__SetStateStat__NextAssignment_2_0_0");
			builder.put(grammarAccess.getSetStateStatAccess().getStateAssignment_2_1_1(), "rule__SetStateStat__StateAssignment_2_1_1");
			builder.put(grammarAccess.getFunctionAccess().getReturnTypeAssignment_0(), "rule__Function__ReturnTypeAssignment_0");
			builder.put(grammarAccess.getFunctionAccess().getNameAssignment_1(), "rule__Function__NameAssignment_1");
			builder.put(grammarAccess.getFunctionAccess().getArgTypesAssignment_3(), "rule__Function__ArgTypesAssignment_3");
			builder.put(grammarAccess.getFunctionAccess().getArgTypesAssignment_4_1(), "rule__Function__ArgTypesAssignment_4_1");
			builder.put(grammarAccess.getRegisterAccess().getTypeAssignment_0(), "rule__Register__TypeAssignment_0");
			builder.put(grammarAccess.getRegisterAccess().getNameAssignment_1(), "rule__Register__NameAssignment_1");
			builder.put(grammarAccess.getRegisterAccess().getAddr1Assignment_2(), "rule__Register__Addr1Assignment_2");
			builder.put(grammarAccess.getRegisterAccess().getAddr2Assignment_3(), "rule__Register__Addr2Assignment_3");
			builder.put(grammarAccess.getRegisterAccess().getRegSizeAssignment_4(), "rule__Register__RegSizeAssignment_4");
			builder.put(grammarAccess.getConstAccess().getTypeAssignment_1(), "rule__Const__TypeAssignment_1");
			builder.put(grammarAccess.getConstAccess().getNameAssignment_2(), "rule__Const__NameAssignment_2");
			builder.put(grammarAccess.getConstAccess().getConstValueAssignment_4(), "rule__Const__ConstValueAssignment_4");
			builder.put(grammarAccess.getEnumAccess().getIdentifierAssignment_1(), "rule__Enum__IdentifierAssignment_1");
			builder.put(grammarAccess.getEnumAccess().getEnumMembersAssignment_3(), "rule__Enum__EnumMembersAssignment_3");
			builder.put(grammarAccess.getEnumAccess().getEnumMembersAssignment_4_1(), "rule__Enum__EnumMembersAssignment_4_1");
			builder.put(grammarAccess.getEnumMemberAccess().getNameAssignment_0(), "rule__EnumMember__NameAssignment_0");
			builder.put(grammarAccess.getEnumMemberAccess().getValueAssignment_1_1(), "rule__EnumMember__ValueAssignment_1_1");
			builder.put(grammarAccess.getInfixOpAccess().getOpAssignment_0(), "rule__InfixOp__OpAssignment_0");
			builder.put(grammarAccess.getInfixOpAccess().getVarIdAssignment_1(), "rule__InfixOp__VarIdAssignment_1");
			builder.put(grammarAccess.getPostfixOpAccess().getVarIdAssignment_0(), "rule__PostfixOp__VarIdAssignment_0");
			builder.put(grammarAccess.getPostfixOpAccess().getOpAssignment_1(), "rule__PostfixOp__OpAssignment_1");
			builder.put(grammarAccess.getFunctionCallAccess().getFunctionAssignment_0(), "rule__FunctionCall__FunctionAssignment_0");
			builder.put(grammarAccess.getFunctionCallAccess().getArgsAssignment_2_0(), "rule__FunctionCall__ArgsAssignment_2_0");
			builder.put(grammarAccess.getFunctionCallAccess().getArgsAssignment_2_1_1(), "rule__FunctionCall__ArgsAssignment_2_1_1");
			builder.put(grammarAccess.getCheckStateExpressionAccess().getProcessAssignment_1(), "rule__CheckStateExpression__ProcessAssignment_1");
			builder.put(grammarAccess.getCheckStateExpressionAccess().getQualfierAssignment_4(), "rule__CheckStateExpression__QualfierAssignment_4");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getReferenceAssignment_0(), "rule__PrimaryExpression__ReferenceAssignment_0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getIntegerAssignment_1_1(), "rule__PrimaryExpression__IntegerAssignment_1_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getFloatingAssignment_2_1(), "rule__PrimaryExpression__FloatingAssignment_2_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getBooleanAssignment_3_1(), "rule__PrimaryExpression__BooleanAssignment_3_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getNestedExprAssignment_4_1(), "rule__PrimaryExpression__NestedExprAssignment_4_1");
			builder.put(grammarAccess.getUnaryExpressionAccess().getUnaryOpAssignment_4_0(), "rule__UnaryExpression__UnaryOpAssignment_4_0");
			builder.put(grammarAccess.getUnaryExpressionAccess().getRightAssignment_4_1(), "rule__UnaryExpression__RightAssignment_4_1");
			builder.put(grammarAccess.getCastExpressionAccess().getTypeAssignment_1_1(), "rule__CastExpression__TypeAssignment_1_1");
			builder.put(grammarAccess.getCastExpressionAccess().getRightAssignment_1_3(), "rule__CastExpression__RightAssignment_1_3");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getMulOpAssignment_1_1(), "rule__MultiplicativeExpression__MulOpAssignment_1_1");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1_2(), "rule__MultiplicativeExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getAddOpAssignment_1_1(), "rule__AdditiveExpression__AddOpAssignment_1_1");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1_2(), "rule__AdditiveExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getShiftExpressionAccess().getShiftOpAssignment_1_1(), "rule__ShiftExpression__ShiftOpAssignment_1_1");
			builder.put(grammarAccess.getShiftExpressionAccess().getRightAssignment_1_2(), "rule__ShiftExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getCompareExpressionAccess().getCmpOpAssignment_1_1_1(), "rule__CompareExpression__CmpOpAssignment_1_1_1");
			builder.put(grammarAccess.getCompareExpressionAccess().getRightAssignment_1_1_2(), "rule__CompareExpression__RightAssignment_1_1_2");
			builder.put(grammarAccess.getEqualityExpressionAccess().getEqCmpOpAssignment_1_1(), "rule__EqualityExpression__EqCmpOpAssignment_1_1");
			builder.put(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1_2(), "rule__EqualityExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getBitAndExpressionAccess().getRightAssignment_1_2(), "rule__BitAndExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getBitXorExpressionAccess().getRightAssignment_1_2(), "rule__BitXorExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getBitOrExpressionAccess().getRightAssignment_1_2(), "rule__BitOrExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getLogicalAndExpressionAccess().getRightAssignment_1_2(), "rule__LogicalAndExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getLogicalOrExpressionAccess().getRightAssignment_1_2(), "rule__LogicalOrExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getAssignVarAssignment_0_0(), "rule__AssignmentExpression__AssignVarAssignment_0_0");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getAssignOpAssignment_0_1(), "rule__AssignmentExpression__AssignOpAssignment_0_1");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getExprAssignment_1(), "rule__AssignmentExpression__ExprAssignment_1");
			builder.put(grammarAccess.getCTypeAccess().getSignSpecAssignment_3_1(), "rule__CType__SignSpecAssignment_3_1");
			builder.put(grammarAccess.getTactAccess().getValueAssignment_1(), "rule__Tact__ValueAssignment_1");
			builder.put(grammarAccess.getTimeAccess().getTicksAssignment(), "rule__Time__TicksAssignment");
			builder.put(grammarAccess.getAnnotationAccess().getKeyAssignment_0_0(), "rule__Annotation__KeyAssignment_0_0");
			builder.put(grammarAccess.getAnnotationAccess().getValueAssignment_0_2(), "rule__Annotation__ValueAssignment_0_2");
			builder.put(grammarAccess.getAnnotationAccess().getKeyAssignment_1(), "rule__Annotation__KeyAssignment_1");
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
