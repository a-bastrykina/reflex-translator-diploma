package ru.iaie.reflex.generator

interface ISourceBuilder {
	def void withConstantDefinitions(String str);
	def void withEnumDefinitions(String str);
	def void withProcessVariableDefinitions(String str);
	def void withGlobalVariableDefinitions(String str);
	def void withProcessDefinitions(String str); // ?
	def void build();
}