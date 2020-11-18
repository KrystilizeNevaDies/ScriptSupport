package cuberiteAPI;

public enum ePluginStatus {
	
	psLoaded,	// 0
	psDisabled,	// 1
	psUnloaded,	// 2
	psError,	// 3
	psNotFound;	// 4
	
	public static ePluginStatus getEnum(int i) {
		switch (i) {
			case 0: return psLoaded;
			case 1: return psDisabled;
			case 2: return psUnloaded;
			case 3: return psError;
			case 4: return psNotFound;
			
			default: return null;
		}
	}
	
	public static int getID(ePluginStatus someEnum) {
		switch (someEnum) {
			case psLoaded: return 0;
			case psDisabled: return 1;
			case psUnloaded: return 2;
			case psError: return 3;
			case psNotFound: return 4;
			
			default: return 3;
		}
	}
}
