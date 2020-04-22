/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ru.iaie.reflex.reflex.Annotation;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.Function;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.ReflexPackage;
import ru.iaie.reflex.reflex.Register;
import ru.iaie.reflex.reflex.Tact;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ProgramImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ProgramImpl#getName <em>Name</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ProgramImpl#getTicks <em>Ticks</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ProgramImpl#getConsts <em>Consts</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ProgramImpl#getEnums <em>Enums</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ProgramImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ProgramImpl#getGlobalVars <em>Global Vars</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ProgramImpl#getRegisters <em>Registers</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ProgramImpl#getProcesses <em>Processes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProgramImpl extends MinimalEObjectImpl.Container implements Program
{
  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> annotations;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTicks() <em>Ticks</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTicks()
   * @generated
   * @ordered
   */
  protected Tact ticks;

  /**
   * The cached value of the '{@link #getConsts() <em>Consts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConsts()
   * @generated
   * @ordered
   */
  protected EList<Const> consts;

  /**
   * The cached value of the '{@link #getEnums() <em>Enums</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnums()
   * @generated
   * @ordered
   */
  protected EList<ru.iaie.reflex.reflex.Enum> enums;

  /**
   * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctions()
   * @generated
   * @ordered
   */
  protected EList<Function> functions;

  /**
   * The cached value of the '{@link #getGlobalVars() <em>Global Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalVars()
   * @generated
   * @ordered
   */
  protected EList<GlobalVariable> globalVars;

  /**
   * The cached value of the '{@link #getRegisters() <em>Registers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegisters()
   * @generated
   * @ordered
   */
  protected EList<Register> registers;

  /**
   * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcesses()
   * @generated
   * @ordered
   */
  protected EList<ru.iaie.reflex.reflex.Process> processes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProgramImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReflexPackage.Literals.PROGRAM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Annotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, ReflexPackage.PROGRAM__ANNOTATIONS);
    }
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.PROGRAM__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Tact getTicks()
  {
    return ticks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTicks(Tact newTicks, NotificationChain msgs)
  {
    Tact oldTicks = ticks;
    ticks = newTicks;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReflexPackage.PROGRAM__TICKS, oldTicks, newTicks);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTicks(Tact newTicks)
  {
    if (newTicks != ticks)
    {
      NotificationChain msgs = null;
      if (ticks != null)
        msgs = ((InternalEObject)ticks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.PROGRAM__TICKS, null, msgs);
      if (newTicks != null)
        msgs = ((InternalEObject)newTicks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.PROGRAM__TICKS, null, msgs);
      msgs = basicSetTicks(newTicks, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.PROGRAM__TICKS, newTicks, newTicks));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Const> getConsts()
  {
    if (consts == null)
    {
      consts = new EObjectContainmentEList<Const>(Const.class, this, ReflexPackage.PROGRAM__CONSTS);
    }
    return consts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ru.iaie.reflex.reflex.Enum> getEnums()
  {
    if (enums == null)
    {
      enums = new EObjectContainmentEList<ru.iaie.reflex.reflex.Enum>(ru.iaie.reflex.reflex.Enum.class, this, ReflexPackage.PROGRAM__ENUMS);
    }
    return enums;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Function> getFunctions()
  {
    if (functions == null)
    {
      functions = new EObjectContainmentEList<Function>(Function.class, this, ReflexPackage.PROGRAM__FUNCTIONS);
    }
    return functions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<GlobalVariable> getGlobalVars()
  {
    if (globalVars == null)
    {
      globalVars = new EObjectContainmentEList<GlobalVariable>(GlobalVariable.class, this, ReflexPackage.PROGRAM__GLOBAL_VARS);
    }
    return globalVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Register> getRegisters()
  {
    if (registers == null)
    {
      registers = new EObjectContainmentEList<Register>(Register.class, this, ReflexPackage.PROGRAM__REGISTERS);
    }
    return registers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ru.iaie.reflex.reflex.Process> getProcesses()
  {
    if (processes == null)
    {
      processes = new EObjectContainmentEList<ru.iaie.reflex.reflex.Process>(ru.iaie.reflex.reflex.Process.class, this, ReflexPackage.PROGRAM__PROCESSES);
    }
    return processes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReflexPackage.PROGRAM__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case ReflexPackage.PROGRAM__TICKS:
        return basicSetTicks(null, msgs);
      case ReflexPackage.PROGRAM__CONSTS:
        return ((InternalEList<?>)getConsts()).basicRemove(otherEnd, msgs);
      case ReflexPackage.PROGRAM__ENUMS:
        return ((InternalEList<?>)getEnums()).basicRemove(otherEnd, msgs);
      case ReflexPackage.PROGRAM__FUNCTIONS:
        return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
      case ReflexPackage.PROGRAM__GLOBAL_VARS:
        return ((InternalEList<?>)getGlobalVars()).basicRemove(otherEnd, msgs);
      case ReflexPackage.PROGRAM__REGISTERS:
        return ((InternalEList<?>)getRegisters()).basicRemove(otherEnd, msgs);
      case ReflexPackage.PROGRAM__PROCESSES:
        return ((InternalEList<?>)getProcesses()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReflexPackage.PROGRAM__ANNOTATIONS:
        return getAnnotations();
      case ReflexPackage.PROGRAM__NAME:
        return getName();
      case ReflexPackage.PROGRAM__TICKS:
        return getTicks();
      case ReflexPackage.PROGRAM__CONSTS:
        return getConsts();
      case ReflexPackage.PROGRAM__ENUMS:
        return getEnums();
      case ReflexPackage.PROGRAM__FUNCTIONS:
        return getFunctions();
      case ReflexPackage.PROGRAM__GLOBAL_VARS:
        return getGlobalVars();
      case ReflexPackage.PROGRAM__REGISTERS:
        return getRegisters();
      case ReflexPackage.PROGRAM__PROCESSES:
        return getProcesses();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReflexPackage.PROGRAM__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case ReflexPackage.PROGRAM__NAME:
        setName((String)newValue);
        return;
      case ReflexPackage.PROGRAM__TICKS:
        setTicks((Tact)newValue);
        return;
      case ReflexPackage.PROGRAM__CONSTS:
        getConsts().clear();
        getConsts().addAll((Collection<? extends Const>)newValue);
        return;
      case ReflexPackage.PROGRAM__ENUMS:
        getEnums().clear();
        getEnums().addAll((Collection<? extends ru.iaie.reflex.reflex.Enum>)newValue);
        return;
      case ReflexPackage.PROGRAM__FUNCTIONS:
        getFunctions().clear();
        getFunctions().addAll((Collection<? extends Function>)newValue);
        return;
      case ReflexPackage.PROGRAM__GLOBAL_VARS:
        getGlobalVars().clear();
        getGlobalVars().addAll((Collection<? extends GlobalVariable>)newValue);
        return;
      case ReflexPackage.PROGRAM__REGISTERS:
        getRegisters().clear();
        getRegisters().addAll((Collection<? extends Register>)newValue);
        return;
      case ReflexPackage.PROGRAM__PROCESSES:
        getProcesses().clear();
        getProcesses().addAll((Collection<? extends ru.iaie.reflex.reflex.Process>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReflexPackage.PROGRAM__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case ReflexPackage.PROGRAM__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReflexPackage.PROGRAM__TICKS:
        setTicks((Tact)null);
        return;
      case ReflexPackage.PROGRAM__CONSTS:
        getConsts().clear();
        return;
      case ReflexPackage.PROGRAM__ENUMS:
        getEnums().clear();
        return;
      case ReflexPackage.PROGRAM__FUNCTIONS:
        getFunctions().clear();
        return;
      case ReflexPackage.PROGRAM__GLOBAL_VARS:
        getGlobalVars().clear();
        return;
      case ReflexPackage.PROGRAM__REGISTERS:
        getRegisters().clear();
        return;
      case ReflexPackage.PROGRAM__PROCESSES:
        getProcesses().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReflexPackage.PROGRAM__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case ReflexPackage.PROGRAM__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReflexPackage.PROGRAM__TICKS:
        return ticks != null;
      case ReflexPackage.PROGRAM__CONSTS:
        return consts != null && !consts.isEmpty();
      case ReflexPackage.PROGRAM__ENUMS:
        return enums != null && !enums.isEmpty();
      case ReflexPackage.PROGRAM__FUNCTIONS:
        return functions != null && !functions.isEmpty();
      case ReflexPackage.PROGRAM__GLOBAL_VARS:
        return globalVars != null && !globalVars.isEmpty();
      case ReflexPackage.PROGRAM__REGISTERS:
        return registers != null && !registers.isEmpty();
      case ReflexPackage.PROGRAM__PROCESSES:
        return processes != null && !processes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ProgramImpl
