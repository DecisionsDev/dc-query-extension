package ilog.rules.teamserver;

import ilog.rules.brl.bql.IlrQueryableElementWrapper;

public class RuleflowQueryExtension {

	public static boolean isLocked(IlrQueryableElementWrapper projectElement) {
		return RuleArtifactQueryExtension.isLocked(projectElement);
	}

} 