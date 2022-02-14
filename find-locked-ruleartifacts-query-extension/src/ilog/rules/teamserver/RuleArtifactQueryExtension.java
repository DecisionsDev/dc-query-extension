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
				Integer baselineId = ((IlrIdentifiedObject) IlrSessionHelperEx.getWorkingBaseline (session, (IlrElementHandle) modelElement)).getId();

				LOGGER.fine (new StringBuilder(((IlrModelElement) modelElement).getName())
								.append(" (type=")
								.append(type)
								.append(", id=")
								.append(id)
								.append(", branch=")
								.append(baselineId)
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