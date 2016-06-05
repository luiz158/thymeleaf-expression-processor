/* 
 * Copyright 2016, Emanuel Rabina (http://www.ultraq.net.nz/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.thymeleaf.expressions

import org.thymeleaf.context.ITemplateContext
import org.thymeleaf.standard.expression.IStandardExpression
import org.thymeleaf.standard.expression.StandardExpressions

/**
 * A simplified API for working with Thymeleaf expressions.
 * 
 * @author Emanuel Rabina
 */
class ExpressionProcessor {

	private final ITemplateContext context

	/**
	 * Constructor, sets the execution context.
	 * 
	 * @param context
	 */
	ExpressionProcessor(ITemplateContext context) {

		this.context = context
	}

	/**
	 * Parses an expression, returning the matching expression type.
	 * 
	 * @param expression
	 * @return Matching expression type.
	 */
	IStandardExpression parse(String expression) {

		return StandardExpressions.getExpressionParser(context.configuration)
			.parseExpression(context, expression)
	}

	/**
	 * Parses and executes an expression, returning the result of the expression
	 * having been parsed and executed.
	 * 
	 * @param expression
	 * @return The result of the expression being executed.
	 */
	Object process(String expression) {

		return parse(expression).execute(context)
	}

	/**
	 * Parse and execute an expression, returning the result as a string.  Useful
	 * for expressions that expect a simple result.
	 * 
	 * @param expression
	 * @return The expression as a string.
	 */
	String processAsString(String expression) {

		return process(expression).toString()
	}
}