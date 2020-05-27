package ru.iaie.reflex.generator.r2c.interfaces;

interface IFileGenerator {
	def void prepareForGeneration()
	def void generateVariableDefinitions()
	def void generateConstantDefinitions()
	def void generateProcessDefinitions()
	def void generateProcessImplementations()
	def void generateIOFiles()
	def void generatePlatformImplementations()
	def void generateMain()
    def void generateBuildFiles()
}