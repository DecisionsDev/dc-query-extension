/*
 *
 *   Copyright IBM Corp. 2022
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package ilog.rules.teamserver;

import java.util.logging.Level;
import java.util.logging.Logger;

import ilog.rules.brl.bql.IlrQueryableElementWrapper;
import ilog.rules.commonbrm.model.IlrElement;
import ilog.rules.teamserver.brm.IlrModelElement;
import ilog.rules.teamserver.model.IlrApplicationException;
import ilog.rules.teamserver.model.IlrElementHandle;
import ilog.rules.teamserver.model.IlrSession;
import ilog.rules.teamserver.model.IlrSessionHelperEx;
import ilog.rules.teamserver.model.impl.IlrIdentifiedObject;

public class RuleArtifactQueryExtension {

	static final String CLASS_FQN = RuleArtifactQueryExtension.class.getCanonicalName();
	static final Logger LOGGER    = Logger.getLogger(CLASS_FQN);

	/*
	 * 	returns whether a rule artifact, rule flow or variable set is locked (including locks created by the current user themselves)
	 * 
	 *  	bql.RuleArtifact.isLocked()#sentence.navigation = {this} is locked
	 *  	bql.RuleFlow.isLocked()#sentence.navigation = {this} is locked
	 *  	bql.VariableSet.isLocked()#sentence.navigation = {this} is locked
	 */
	public static boolean isLocked(IlrQueryableElementWrapper projectElement) 
	{
		IlrElement modelElement = projectElement.getModelElement();
		IlrSession session = (IlrSession) ((IlrElementHandle) modelElement).getSession();
		
		try {
			String owner = session.getLockOwner((IlrElementHandle) modelElement);
			boolean locked = (owner != null);
			
			if (locked && LOGGER.isLoggable(Level.FINE)) {
				String  type       = ((IlrElementHandle)    modelElement).getType();
				Integer id         = ((IlrIdentifiedObject) modelElement).getId();

				LOGGER.fine (new StringBuilder(((IlrModelElement) modelElement).getName())
								.append(" (type=")
								.append(type)
								.append(", id=")
								.append(id)
								.append(") is locked")
								.toString());
			}
			return locked;

		} catch (IlrApplicationException e) {
			LOGGER.log(Level.WARNING, e.getMessage(), e);
			return false;
		}
	}

} 