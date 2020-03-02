/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.PrimaryExpression#getVarId <em>Var Id</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.PrimaryExpression#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.reflex.ReflexPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends UnaryExpression
{
  /**
   * Returns the value of the '<em><b>Var Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Id</em>' attribute.
   * @see #setVarId(String)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getPrimaryExpression_VarId()
   * @model
   * @generated
   */
  String getVarId();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.PrimaryExpression#getVarId <em>Var Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Id</em>' attribute.
   * @see #getVarId()
   * @generated
   */
  void setVarId(String value);

  /**
   * Returns the value of the '<em><b>Literal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' containment reference.
   * @see #setLiteral(ru.iaie.reflex.reflex.Integer)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getPrimaryExpression_Literal()
   * @model containment="true"
   * @generated
   */
  ru.iaie.reflex.reflex.Integer getLiteral();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.PrimaryExpression#getLiteral <em>Literal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal</em>' containment reference.
   * @see #getLiteral()
   * @generated
   */
  void setLiteral(ru.iaie.reflex.reflex.Integer value);

} // PrimaryExpression
