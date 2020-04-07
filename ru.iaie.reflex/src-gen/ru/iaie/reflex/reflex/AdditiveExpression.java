/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.AdditiveExpression#getAddOp <em>Add Op</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.reflex.ReflexPackage#getAdditiveExpression()
 * @model
 * @generated
 */
public interface AdditiveExpression extends ShiftExpression
{
  /**
   * Returns the value of the '<em><b>Add Op</b></em>' attribute.
   * The literals are from the enumeration {@link ru.iaie.reflex.reflex.AdditiveOp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Add Op</em>' attribute.
   * @see ru.iaie.reflex.reflex.AdditiveOp
   * @see #setAddOp(AdditiveOp)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getAdditiveExpression_AddOp()
   * @model
   * @generated
   */
  AdditiveOp getAddOp();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.AdditiveExpression#getAddOp <em>Add Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Add Op</em>' attribute.
   * @see ru.iaie.reflex.reflex.AdditiveOp
   * @see #getAddOp()
   * @generated
   */
  void setAddOp(AdditiveOp value);

} // AdditiveExpression
