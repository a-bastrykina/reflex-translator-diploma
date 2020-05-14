/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ru.iaie.reflex.reflex.ReflexPackage
 * @generated
 */
public interface ReflexFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReflexFactory eINSTANCE = ru.iaie.reflex.reflex.impl.ReflexFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Program</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Program</em>'.
   * @generated
   */
  Program createProgram();

  /**
   * Returns a new object of class '<em>Tact</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tact</em>'.
   * @generated
   */
  Tact createTact();

  /**
   * Returns a new object of class '<em>Process</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process</em>'.
   * @generated
   */
  Process createProcess();

  /**
   * Returns a new object of class '<em>State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State</em>'.
   * @generated
   */
  State createState();

  /**
   * Returns a new object of class '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation</em>'.
   * @generated
   */
  Annotation createAnnotation();

  /**
   * Returns a new object of class '<em>Imported Variable List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Imported Variable List</em>'.
   * @generated
   */
  ImportedVariableList createImportedVariableList();

  /**
   * Returns a new object of class '<em>Process Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Variable</em>'.
   * @generated
   */
  ProcessVariable createProcessVariable();

  /**
   * Returns a new object of class '<em>Global Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Global Variable</em>'.
   * @generated
   */
  GlobalVariable createGlobalVariable();

  /**
   * Returns a new object of class '<em>Physical Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Physical Variable</em>'.
   * @generated
   */
  PhysicalVariable createPhysicalVariable();

  /**
   * Returns a new object of class '<em>Port Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Mapping</em>'.
   * @generated
   */
  PortMapping createPortMapping();

  /**
   * Returns a new object of class '<em>Program Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Program Variable</em>'.
   * @generated
   */
  ProgramVariable createProgramVariable();

  /**
   * Returns a new object of class '<em>Timeout Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Timeout Function</em>'.
   * @generated
   */
  TimeoutFunction createTimeoutFunction();

  /**
   * Returns a new object of class '<em>Time Amount Or Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Amount Or Ref</em>'.
   * @generated
   */
  TimeAmountOrRef createTimeAmountOrRef();

  /**
   * Returns a new object of class '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function</em>'.
   * @generated
   */
  Function createFunction();

  /**
   * Returns a new object of class '<em>Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port</em>'.
   * @generated
   */
  Port createPort();

  /**
   * Returns a new object of class '<em>Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Const</em>'.
   * @generated
   */
  Const createConst();

  /**
   * Returns a new object of class '<em>Enum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum</em>'.
   * @generated
   */
  Enum createEnum();

  /**
   * Returns a new object of class '<em>Enum Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Member</em>'.
   * @generated
   */
  EnumMember createEnumMember();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>Statement Sequence</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement Sequence</em>'.
   * @generated
   */
  StatementSequence createStatementSequence();

  /**
   * Returns a new object of class '<em>Compound Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compound Statement</em>'.
   * @generated
   */
  CompoundStatement createCompoundStatement();

  /**
   * Returns a new object of class '<em>If Else Stat</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Else Stat</em>'.
   * @generated
   */
  IfElseStat createIfElseStat();

  /**
   * Returns a new object of class '<em>Switch Stat</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Stat</em>'.
   * @generated
   */
  SwitchStat createSwitchStat();

  /**
   * Returns a new object of class '<em>Case Stat</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Case Stat</em>'.
   * @generated
   */
  CaseStat createCaseStat();

  /**
   * Returns a new object of class '<em>Start Proc Stat</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Start Proc Stat</em>'.
   * @generated
   */
  StartProcStat createStartProcStat();

  /**
   * Returns a new object of class '<em>Stop Proc Stat</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stop Proc Stat</em>'.
   * @generated
   */
  StopProcStat createStopProcStat();

  /**
   * Returns a new object of class '<em>Error Stat</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Stat</em>'.
   * @generated
   */
  ErrorStat createErrorStat();

  /**
   * Returns a new object of class '<em>Restart Stat</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Restart Stat</em>'.
   * @generated
   */
  RestartStat createRestartStat();

  /**
   * Returns a new object of class '<em>Reset Stat</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reset Stat</em>'.
   * @generated
   */
  ResetStat createResetStat();

  /**
   * Returns a new object of class '<em>Set State Stat</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Set State Stat</em>'.
   * @generated
   */
  SetStateStat createSetStateStat();

  /**
   * Returns a new object of class '<em>Id Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Id Reference</em>'.
   * @generated
   */
  IdReference createIdReference();

  /**
   * Returns a new object of class '<em>Infix Op</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Infix Op</em>'.
   * @generated
   */
  InfixOp createInfixOp();

  /**
   * Returns a new object of class '<em>Postfix Op</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Op</em>'.
   * @generated
   */
  PostfixOp createPostfixOp();

  /**
   * Returns a new object of class '<em>Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Call</em>'.
   * @generated
   */
  FunctionCall createFunctionCall();

  /**
   * Returns a new object of class '<em>Check State Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Check State Expression</em>'.
   * @generated
   */
  CheckStateExpression createCheckStateExpression();

  /**
   * Returns a new object of class '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression</em>'.
   * @generated
   */
  PrimaryExpression createPrimaryExpression();

  /**
   * Returns a new object of class '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Expression</em>'.
   * @generated
   */
  UnaryExpression createUnaryExpression();

  /**
   * Returns a new object of class '<em>Cast Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cast Expression</em>'.
   * @generated
   */
  CastExpression createCastExpression();

  /**
   * Returns a new object of class '<em>Multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicative Expression</em>'.
   * @generated
   */
  MultiplicativeExpression createMultiplicativeExpression();

  /**
   * Returns a new object of class '<em>Additive Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Additive Expression</em>'.
   * @generated
   */
  AdditiveExpression createAdditiveExpression();

  /**
   * Returns a new object of class '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shift Expression</em>'.
   * @generated
   */
  ShiftExpression createShiftExpression();

  /**
   * Returns a new object of class '<em>Compare Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compare Expression</em>'.
   * @generated
   */
  CompareExpression createCompareExpression();

  /**
   * Returns a new object of class '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expression</em>'.
   * @generated
   */
  EqualityExpression createEqualityExpression();

  /**
   * Returns a new object of class '<em>Bit And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bit And Expression</em>'.
   * @generated
   */
  BitAndExpression createBitAndExpression();

  /**
   * Returns a new object of class '<em>Bit Xor Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bit Xor Expression</em>'.
   * @generated
   */
  BitXorExpression createBitXorExpression();

  /**
   * Returns a new object of class '<em>Bit Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bit Or Expression</em>'.
   * @generated
   */
  BitOrExpression createBitOrExpression();

  /**
   * Returns a new object of class '<em>Logical And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical And Expression</em>'.
   * @generated
   */
  LogicalAndExpression createLogicalAndExpression();

  /**
   * Returns a new object of class '<em>Logical Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Or Expression</em>'.
   * @generated
   */
  LogicalOrExpression createLogicalOrExpression();

  /**
   * Returns a new object of class '<em>Assignment Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Expression</em>'.
   * @generated
   */
  AssignmentExpression createAssignmentExpression();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ReflexPackage getReflexPackage();

} //ReflexFactory
