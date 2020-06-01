package ru.iaie.reflex.generator.r2c.helpers

import ru.iaie.reflex.reflex.Port
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import ru.iaie.reflex.utils.LiteralUtils
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.PortMapping
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper
import ru.iaie.reflex.generator.r2c.util.LiteralGenerationUtil

class PortGenerationHelper {
	IReflexIdentifiersHelper identifiersHelper
	
	new(IReflexIdentifiersHelper ih) {
		this.identifiersHelper = ih 
	}
	
	def generatePortVariableDefinition(Port reg) {
		return '''«LiteralGenerationUtil.translateType(reg.suitableTypeForPort)» «identifiersHelper.getPortId(reg)»'''
	}
	
	def translateInputPortReading(Port port) {
		val portId = identifiersHelper.getPortId(port)
		val funcName = LiteralUtils.parseInteger(port.size) == 8 ? "read_byte" : "read_word"
		return '''«portId» = «funcName»(«port.addr1», «port.addr2»);'''
	}
	
	def translateOutputPortWriting(Port port) {
		val portId = identifiersHelper.getPortId(port)
		val funcName = LiteralUtils.parseInteger(port.size) == 8 ? "write_byte" : "write_word"
		return '''«funcName»(«port.addr1», «port.addr2», «portId»);'''
	}
	
	def translateReadingFromInput(PhysicalVariable v) {
		val mapping = v.mapping
		val varName = identifiersHelper.getMapping(v) 
		if (mapping.fullMapping) {
			return '''«varName» = «identifiersHelper.getPortId(mapping.port)»;'''
		} else {
			return 
			'''
			if («identifiersHelper.getPortId(mapping.port)» & «generatePortMappingMask(mapping)») {
				«varName» = TRUE;
			}
			else {
				«varName» = FALSE;
			} 
			'''
		}
	}
	
	def translateWritingToOutput(PhysicalVariable v) {
		val mapping = v.mapping
		val portVariableName = identifiersHelper.getPortId(mapping.port)
		val varName = identifiersHelper.getMapping(v)
		val mask =  generatePortMappingMask(mapping)
		if (mapping.fullMapping) {
			return '''«portVariableName» = «varName»;'''
		} else {
			return 
			'''
			if («varName») {
				«portVariableName» |= «mask»; 
			} else {
				«portVariableName» &= ~«mask»; 
			}
			'''
		}
	}
	
	def generatePortMappingMask(PortMapping mapping) {
		return '''MASK«mapping.bit»_S«mapping.port.size»'''
	}
	
}