/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.botmill.fb;

/**
 * An interface that represents the base configuration of a {@link FbBot}. To
 * configure your bot, you will need a class that implements this interface. The
 * class that implements this interface should then registered into your web.xml
 * as an init-param for the {@link FbBotMillServlet}.
 * 
 * @author Donato Rimenti
 * 
 */
public interface FbBotDefinition {

	/**
	 * Method used for the configuration of the bots. This method should
	 * accomplish the following things:
	 * <ul>
	 * <li>register your webhook validation token and your page validation token
	 * using {@link FbBotMillContext#setup(String, String)}</li>
	 * <li>instantiate and define one or more {@link FbBot}</li>
	 * </ul>
	 */
	public void defineBehavior();

}
