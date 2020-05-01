package ru.iaie.reflex.generator

interface ISourceBuilder {
	def void withConstantDefinitions(String str);
	def void build();
}