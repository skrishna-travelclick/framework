package com.automation.framework.constants;

public enum SheetIds {
    ENVIRONMENT_DETAILS_SHEETID(0), ENV_FUNCTIONS_SHEETID(1);

private final int sheetId;

SheetIds(final int sheetId) {
this.sheetId = sheetId;
}

public int getSheetId() {
return sheetId;
}

}
