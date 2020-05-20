/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import ru.iaie.reflex.reflex.AdditiveExpression;
import ru.iaie.reflex.reflex.Annotation;
import ru.iaie.reflex.reflex.AssignmentExpression;
import ru.iaie.reflex.reflex.BitAndExpression;
import ru.iaie.reflex.reflex.BitOrExpression;
import ru.iaie.reflex.reflex.BitXorExpression;
import ru.iaie.reflex.reflex.CaseStat;
import ru.iaie.reflex.reflex.CastExpression;
import ru.iaie.reflex.reflex.CheckStateExpression;
import ru.iaie.reflex.reflex.ClockDefinition;
import ru.iaie.reflex.reflex.CompareExpression;
import ru.iaie.reflex.reflex.CompoundStatement;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.DefaultStat;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.EqualityExpression;
import ru.iaie.reflex.reflex.ErrorStat;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.Function;
import ru.iaie.reflex.reflex.FunctionCall;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.IfElseStat;
import ru.iaie.reflex.reflex.ImportedVariableList;
import ru.iaie.reflex.reflex.InfixOp;
import ru.iaie.reflex.reflex.LogicalAndExpression;
import ru.iaie.reflex.reflex.LogicalOrExpression;
import ru.iaie.reflex.reflex.MultiplicativeExpression;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.Port;
import ru.iaie.reflex.reflex.PortMapping;
import ru.iaie.reflex.reflex.PostfixOp;
import ru.iaie.reflex.reflex.PrimaryExpression;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.reflex.ReflexPackage;
import ru.iaie.reflex.reflex.ResetStat;
import ru.iaie.reflex.reflex.RestartStat;
import ru.iaie.reflex.reflex.SetStateStat;
import ru.iaie.reflex.reflex.ShiftExpression;
import ru.iaie.reflex.reflex.StartProcStat;
import ru.iaie.reflex.reflex.State;
import ru.iaie.reflex.reflex.Statement;
import ru.iaie.reflex.reflex.StatementSequence;
import ru.iaie.reflex.reflex.StopProcStat;
import ru.iaie.reflex.reflex.SwitchOptionStatSequence;
import ru.iaie.reflex.reflex.SwitchStat;
import ru.iaie.reflex.reflex.TimeAmountOrRef;
import ru.iaie.reflex.reflex.TimeoutFunction;
import ru.iaie.reflex.reflex.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ru.iaie.reflex.reflex.ReflexPackage
 * @generated
 */
public class ReflexAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ReflexPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReflexAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ReflexPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReflexSwitch<Adapter> modelSwitch =
    new ReflexSwitch<Adapter>()
    {
      @Override
      public Adapter caseProgram(Program object)
      {
        return createProgramAdapter();
      }
      @Override
      public Adapter caseClockDefinition(ClockDefinition object)
      {
        return createClockDefinitionAdapter();
      }
      @Override
      public Adapter caseProcess(ru.iaie.reflex.reflex.Process object)
      {
        return createProcessAdapter();
      }
      @Override
      public Adapter caseState(State object)
      {
        return createStateAdapter();
      }
      @Override
      public Adapter caseAnnotation(Annotation object)
      {
        return createAnnotationAdapter();
      }
      @Override
      public Adapter caseImportedVariableList(ImportedVariableList object)
      {
        return createImportedVariableListAdapter();
      }
      @Override
      public Adapter caseProcessVariable(ProcessVariable object)
      {
        return createProcessVariableAdapter();
      }
      @Override
      public Adapter caseGlobalVariable(GlobalVariable object)
      {
        return createGlobalVariableAdapter();
      }
      @Override
      public Adapter casePhysicalVariable(PhysicalVariable object)
      {
        return createPhysicalVariableAdapter();
      }
      @Override
      public Adapter casePortMapping(PortMapping object)
      {
        return createPortMappingAdapter();
      }
      @Override
      public Adapter caseProgramVariable(ProgramVariable object)
      {
        return createProgramVariableAdapter();
      }
      @Override
      public Adapter caseTimeoutFunction(TimeoutFunction object)
      {
        return createTimeoutFunctionAdapter();
      }
      @Override
      public Adapter caseTimeAmountOrRef(TimeAmountOrRef object)
      {
        return createTimeAmountOrRefAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter casePort(Port object)
      {
        return createPortAdapter();
      }
      @Override
      public Adapter caseConst(Const object)
      {
        return createConstAdapter();
      }
      @Override
      public Adapter caseEnum(ru.iaie.reflex.reflex.Enum object)
      {
        return createEnumAdapter();
      }
      @Override
      public Adapter caseEnumMember(EnumMember object)
      {
        return createEnumMemberAdapter();
      }
      @Override
      public Adapter caseStatement(Statement object)
      {
        return createStatementAdapter();
      }
      @Override
      public Adapter caseStatementSequence(StatementSequence object)
      {
        return createStatementSequenceAdapter();
      }
      @Override
      public Adapter caseCompoundStatement(CompoundStatement object)
      {
        return createCompoundStatementAdapter();
      }
      @Override
      public Adapter caseIfElseStat(IfElseStat object)
      {
        return createIfElseStatAdapter();
      }
      @Override
      public Adapter caseSwitchStat(SwitchStat object)
      {
        return createSwitchStatAdapter();
      }
      @Override
      public Adapter caseCaseStat(CaseStat object)
      {
        return createCaseStatAdapter();
      }
      @Override
      public Adapter caseDefaultStat(DefaultStat object)
      {
        return createDefaultStatAdapter();
      }
      @Override
      public Adapter caseSwitchOptionStatSequence(SwitchOptionStatSequence object)
      {
        return createSwitchOptionStatSequenceAdapter();
      }
      @Override
      public Adapter caseStartProcStat(StartProcStat object)
      {
        return createStartProcStatAdapter();
      }
      @Override
      public Adapter caseStopProcStat(StopProcStat object)
      {
        return createStopProcStatAdapter();
      }
      @Override
      public Adapter caseErrorStat(ErrorStat object)
      {
        return createErrorStatAdapter();
      }
      @Override
      public Adapter caseRestartStat(RestartStat object)
      {
        return createRestartStatAdapter();
      }
      @Override
      public Adapter caseResetStat(ResetStat object)
      {
        return createResetStatAdapter();
      }
      @Override
      public Adapter caseSetStateStat(SetStateStat object)
      {
        return createSetStateStatAdapter();
      }
      @Override
      public Adapter caseIdReference(IdReference object)
      {
        return createIdReferenceAdapter();
      }
      @Override
      public Adapter caseInfixOp(InfixOp object)
      {
        return createInfixOpAdapter();
      }
      @Override
      public Adapter casePostfixOp(PostfixOp object)
      {
        return createPostfixOpAdapter();
      }
      @Override
      public Adapter caseFunctionCall(FunctionCall object)
      {
        return createFunctionCallAdapter();
      }
      @Override
      public Adapter caseCheckStateExpression(CheckStateExpression object)
      {
        return createCheckStateExpressionAdapter();
      }
      @Override
      public Adapter casePrimaryExpression(PrimaryExpression object)
      {
        return createPrimaryExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryExpression(UnaryExpression object)
      {
        return createUnaryExpressionAdapter();
      }
      @Override
      public Adapter caseCastExpression(CastExpression object)
      {
        return createCastExpressionAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpression(MultiplicativeExpression object)
      {
        return createMultiplicativeExpressionAdapter();
      }
      @Override
      public Adapter caseAdditiveExpression(AdditiveExpression object)
      {
        return createAdditiveExpressionAdapter();
      }
      @Override
      public Adapter caseShiftExpression(ShiftExpression object)
      {
        return createShiftExpressionAdapter();
      }
      @Override
      public Adapter caseCompareExpression(CompareExpression object)
      {
        return createCompareExpressionAdapter();
      }
      @Override
      public Adapter caseEqualityExpression(EqualityExpression object)
      {
        return createEqualityExpressionAdapter();
      }
      @Override
      public Adapter caseBitAndExpression(BitAndExpression object)
      {
        return createBitAndExpressionAdapter();
      }
      @Override
      public Adapter caseBitXorExpression(BitXorExpression object)
      {
        return createBitXorExpressionAdapter();
      }
      @Override
      public Adapter caseBitOrExpression(BitOrExpression object)
      {
        return createBitOrExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalAndExpression(LogicalAndExpression object)
      {
        return createLogicalAndExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalOrExpression(LogicalOrExpression object)
      {
        return createLogicalOrExpressionAdapter();
      }
      @Override
      public Adapter caseAssignmentExpression(AssignmentExpression object)
      {
        return createAssignmentExpressionAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.Program
   * @generated
   */
  public Adapter createProgramAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.ClockDefinition <em>Clock Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.ClockDefinition
   * @generated
   */
  public Adapter createClockDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.Process <em>Process</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.Process
   * @generated
   */
  public Adapter createProcessAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.State
   * @generated
   */
  public Adapter createStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.Annotation
   * @generated
   */
  public Adapter createAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.ImportedVariableList <em>Imported Variable List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.ImportedVariableList
   * @generated
   */
  public Adapter createImportedVariableListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.ProcessVariable <em>Process Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.ProcessVariable
   * @generated
   */
  public Adapter createProcessVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.GlobalVariable <em>Global Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.GlobalVariable
   * @generated
   */
  public Adapter createGlobalVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.PhysicalVariable <em>Physical Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.PhysicalVariable
   * @generated
   */
  public Adapter createPhysicalVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.PortMapping <em>Port Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.PortMapping
   * @generated
   */
  public Adapter createPortMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.ProgramVariable <em>Program Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.ProgramVariable
   * @generated
   */
  public Adapter createProgramVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.TimeoutFunction <em>Timeout Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.TimeoutFunction
   * @generated
   */
  public Adapter createTimeoutFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.TimeAmountOrRef <em>Time Amount Or Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.TimeAmountOrRef
   * @generated
   */
  public Adapter createTimeAmountOrRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.Port
   * @generated
   */
  public Adapter createPortAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.Const <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.Const
   * @generated
   */
  public Adapter createConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.Enum <em>Enum</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.Enum
   * @generated
   */
  public Adapter createEnumAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.EnumMember <em>Enum Member</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.EnumMember
   * @generated
   */
  public Adapter createEnumMemberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.Statement
   * @generated
   */
  public Adapter createStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.StatementSequence <em>Statement Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.StatementSequence
   * @generated
   */
  public Adapter createStatementSequenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.CompoundStatement <em>Compound Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.CompoundStatement
   * @generated
   */
  public Adapter createCompoundStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.IfElseStat <em>If Else Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.IfElseStat
   * @generated
   */
  public Adapter createIfElseStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.SwitchStat <em>Switch Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.SwitchStat
   * @generated
   */
  public Adapter createSwitchStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.CaseStat <em>Case Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.CaseStat
   * @generated
   */
  public Adapter createCaseStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.DefaultStat <em>Default Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.DefaultStat
   * @generated
   */
  public Adapter createDefaultStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.SwitchOptionStatSequence <em>Switch Option Stat Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.SwitchOptionStatSequence
   * @generated
   */
  public Adapter createSwitchOptionStatSequenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.StartProcStat <em>Start Proc Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.StartProcStat
   * @generated
   */
  public Adapter createStartProcStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.StopProcStat <em>Stop Proc Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.StopProcStat
   * @generated
   */
  public Adapter createStopProcStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.ErrorStat <em>Error Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.ErrorStat
   * @generated
   */
  public Adapter createErrorStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.RestartStat <em>Restart Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.RestartStat
   * @generated
   */
  public Adapter createRestartStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.ResetStat <em>Reset Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.ResetStat
   * @generated
   */
  public Adapter createResetStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.SetStateStat <em>Set State Stat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.SetStateStat
   * @generated
   */
  public Adapter createSetStateStatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.IdReference <em>Id Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.IdReference
   * @generated
   */
  public Adapter createIdReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.InfixOp <em>Infix Op</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.InfixOp
   * @generated
   */
  public Adapter createInfixOpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.PostfixOp <em>Postfix Op</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.PostfixOp
   * @generated
   */
  public Adapter createPostfixOpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.FunctionCall
   * @generated
   */
  public Adapter createFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.CheckStateExpression <em>Check State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.CheckStateExpression
   * @generated
   */
  public Adapter createCheckStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.PrimaryExpression
   * @generated
   */
  public Adapter createPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.CastExpression <em>Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.CastExpression
   * @generated
   */
  public Adapter createCastExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.MultiplicativeExpression
   * @generated
   */
  public Adapter createMultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.AdditiveExpression
   * @generated
   */
  public Adapter createAdditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.ShiftExpression
   * @generated
   */
  public Adapter createShiftExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.CompareExpression <em>Compare Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.CompareExpression
   * @generated
   */
  public Adapter createCompareExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.EqualityExpression
   * @generated
   */
  public Adapter createEqualityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.BitAndExpression <em>Bit And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.BitAndExpression
   * @generated
   */
  public Adapter createBitAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.BitXorExpression <em>Bit Xor Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.BitXorExpression
   * @generated
   */
  public Adapter createBitXorExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.BitOrExpression <em>Bit Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.BitOrExpression
   * @generated
   */
  public Adapter createBitOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.LogicalAndExpression
   * @generated
   */
  public Adapter createLogicalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.LogicalOrExpression
   * @generated
   */
  public Adapter createLogicalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.AssignmentExpression <em>Assignment Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.AssignmentExpression
   * @generated
   */
  public Adapter createAssignmentExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ru.iaie.reflex.reflex.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ru.iaie.reflex.reflex.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ReflexAdapterFactory
