package ilog.rules.teamserver;

import ilog.rules.brl.bql.IlrQueryableElementWrapper;

public class VariableSetQueryExtension {

	public static boolean isLocked(IlrQueryableElementWrapper projectElement) {
		return RuleArtifactQueryExtension.isLocked(projectElement);
	}

} 