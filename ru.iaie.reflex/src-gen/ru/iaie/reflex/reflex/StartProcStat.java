/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Proc Stat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.StartProcStat#getProcId <em>Proc Id</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.reflex.ReflexPackage#getStartProcStat()
 * @model
 * @generated
 */
public interface StartProcStat extends Statement
{
  /**
   * Returns the value of the '<em><b>Proc Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proc Id</em>' attribute.
   * @see #setProcId(String)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getStartProcStat_ProcId()
   * @model
   * @generated
   */
  String getProcId();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.StartProcStat#getProcId <em>Proc Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Proc Id</em>' attribute.
   * @see #getProcId()
   * @generated
   */
  void setProcId(String value);

} // StartProcStat
