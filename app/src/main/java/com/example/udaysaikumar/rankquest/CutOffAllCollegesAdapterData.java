package com.example.udaysaikumar.rankquest;

import java.io.Serializable;

/**
 * Created by udaysaikumar on 28/01/18.
 */

public class CutOffAllCollegesAdapterData implements Serializable {
    private boolean isSelected;
    private String allclg;

    public CutOffAllCollegesAdapterData( String allclg,boolean isSelected) {
        this.isSelected = isSelected;
        this.allclg = allclg;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getAllclg() {
        return allclg;
    }

    public void setAllclg(String allclg) {
        this.allclg = allclg;
    }
}
