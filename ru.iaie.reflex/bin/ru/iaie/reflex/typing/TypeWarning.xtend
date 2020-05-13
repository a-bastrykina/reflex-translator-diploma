package ru.iaie.reflex.typing

import org.eclipse.emf.ecore.EObject

class TypeWarning {
	public String message
	public EObject expression
	
	new(String message, EObject expression) {
		this.message = message
		this.expression = expression
	}
}